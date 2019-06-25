package de.thm.machine;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import de.thm.machine.framework.machines.FiniteStateMachine;
import de.thm.machine.framework.machines.IMachine;
import de.thm.machine.framework.tupleElements.Domain;
import de.thm.machine.framework.tupleElements.Image;
import de.thm.machine.framework.tupleElements.State;
import de.thm.machine.framework.tupleElements.TransitionFunction;

public class MachineFactory {
	
	public static IMachine getMachine(String fileName) {
		
		try {
			return createMachine(fileName);
		} catch (IOException e) {
			System.out.println("Fehler beim Versuch die Datei " + fileName + " zu öffnen");
		}
		
		return null;
	}
	
	private static IMachine createMachine(String fileName) throws IOException {
		
		var split = fileName.split(Pattern.quote("."));
		if(split.length < 1) {
			System.out.println("Falsches Dateiformat");
			return null;
		}
		
		var lines = readFile(Paths.get(fileName));
		
		var format = split[split.length - 1];
		switch(format) {
			case "fsm":
				var map = createStateMap(lines, getEndStates(lines));
				return createFiniteStateMachine(lines, map);
			
			default:
				System.out.println("Falsches Dateiformat");
				return null;
		}
		
	}
	
	private static String[] getEndStates(List<String[]> lines) {
		var endStates = lines.get(0);
		lines.remove(0);
		return endStates;
	}
	
	private static IMachine createFiniteStateMachine(List<String[]> lines, Map<String, State> map) {
		var function = new ArrayList<TransitionFunction>();
		
		for(var line : lines) {
			var domain = new Domain(map.get(line[0]), line[1].charAt(0));
			var image = new Image(map.get(line[2]));
			function.add(new TransitionFunction(domain, image));
		}
		
		return new FiniteStateMachine(function, map.get("s0"));
	}
	
	private static Map<String, State> createStateMap(List<String[]> lines, String[] endStates) {
		var map = new HashMap<String, State>();
		map.putAll(createStateMap(lines));
		
		for(var endState : endStates) {
			var state = map.get(endState);
			if(state != null) map.remove(state.getName());
			map.put(endState, new State(endState, true));
		}
				
		return map;
	}
	
	private static Map<String, State> createStateMap(List<String[]> lines) {
		var map = new HashMap<String, State>();
		for(var line : lines) {
			map.putIfAbsent(line[0], new State(line[0]));
			map.putIfAbsent(line[line.length - 1], new State(line[line.length - 1]));
		}
		return map;
	}
	
	private static List<String[]> readFile(Path fileName) throws IOException {
		var array = new ArrayList<String[]>();
		Files.lines(fileName, StandardCharsets.UTF_8).forEach(line -> {
			if(line.length() == 0) return;
			if(line.charAt(0) == ';') return;
			
			array.add(line.split(" "));
		});
		return array;
	}
	
}
