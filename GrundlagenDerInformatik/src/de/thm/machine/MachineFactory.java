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
import java.util.function.Function;
import java.util.regex.Pattern;

import de.thm.machine.framework.machines.FiniteStateMachine;
import de.thm.machine.framework.machines.IMachine;
import de.thm.machine.framework.machines.PushdownAutomaton;
import de.thm.machine.framework.machines.TuringAcceptorMachine;
import de.thm.machine.framework.machines.TuringMachine;
import de.thm.machine.framework.tupleElements.Domain;
import de.thm.machine.framework.tupleElements.Image;
import de.thm.machine.framework.tupleElements.PushdownDomain;
import de.thm.machine.framework.tupleElements.PushdownImage;
import de.thm.machine.framework.tupleElements.ReadDirection;
import de.thm.machine.framework.tupleElements.State;
import de.thm.machine.framework.tupleElements.Transition;
import de.thm.machine.framework.tupleElements.TransitionFunction;
import de.thm.machine.framework.tupleElements.TuringImage;

// refactor
public class MachineFactory {
	
	private static final String START_STATE = "s0";
	private static final Character BLANK = '_';
	
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
			
			case "pda":
				map = createStateMap(lines, getEndStates(lines));
				return createPushdownAutomaton(lines, map);
				
			case "tm":
				map = createStateMap(lines);
				return createTuringMachine(lines, map, 
						(function, state) -> new TuringMachine(function, state) );
				
			case "tam":
				map = createStateMap(lines, getEndStates(lines));
				return createTuringMachine(lines, map,
						(function, state) -> new TuringAcceptorMachine(function, state) );
				
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
	
	private static IMachine createTuringMachine(List<String[]> lines, Map<String, State> map, 
			Function<TransitionFunction, State, IMachine> createMachine) {
		var function = new TransitionFunction();
		
		for(var line : lines) {
			Character input = line[1].charAt(0);
			if(input == BLANK) {
				input = ' ';
			}
			
			var domain = new Domain(map.get(line[0]), input);
			
			Character output = line[2].charAt(0);
			if(output == BLANK) {
				output = ' ';
			}
			
			var direction = ReadDirection.getDirection(line[3].charAt(0));			
			var image = new TuringImage(map.get(line[4]), output, direction);
			
			function.add(domain, image);
		}
		
		return createMachine.apply(function, map.get(START_STATE));
	}
	
	private static IMachine createFiniteStateMachine(List<String[]> lines, Map<String, State> map) {
		var function = new TransitionFunction();
		
		for(var line : lines) {
			var domain = new Domain(map.get(line[0]), line[1].charAt(0));
			var image = new Image(map.get(line[2]));
			function.add(domain, image);
		}
		
		return new FiniteStateMachine(function, map.get(START_STATE));
	}
	
	private static IMachine createPushdownAutomaton(List<String[]> lines, Map<String, State> map) {
		var function = new TransitionFunction();
		
		for(var line : lines) {
			Character popValue = line[2].charAt(0);
			if(popValue == BLANK) {
				popValue = null;
			}
			
			Character input = line[1].charAt(0);
			if(input == BLANK) {
				input = null;
			}
			
			var domain = new PushdownDomain(map.get(line[0]), input, popValue);
			
			Character[] pushValue = line[3].chars().mapToObj(c -> (char)c).toArray(Character[]::new);
			if(pushValue.length == 1 && pushValue[0] == BLANK) {
				pushValue = null;
			}
			var image = new PushdownImage(map.get(line[4]), pushValue);
			
			function.add(domain, image);
		}
		
		return new PushdownAutomaton(function, map.get(START_STATE));
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
			
			var split = line.split(" ");
			if(split.length == 0) return;
			
			array.add(split);
		});
		return array;
	}
	
	@FunctionalInterface
	interface Function<Parameter1, Parameter2, Output> {
		Output apply(Parameter1 par1, Parameter2 par2);
	}
	
}
