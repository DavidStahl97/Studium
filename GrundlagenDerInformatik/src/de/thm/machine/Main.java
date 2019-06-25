package de.thm.machine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) {
		
		if(args.length == 0) {
			System.out.println("Der Pfad der Datei muss angegeben werden");
			return;
		}
		
		var machine = MachineFactory.getMachine(getPath(args));
		if(machine == null) return;
		
		
		var word = readWord();
		var result = machine.start(word);
		
		System.out.println(result);
		
	}
	
	private static String getPath(String[] args) {
		var path = "";
		int i = 0;
		for(var s : args) {
			if(i != 0) path += " "; 
			path += s;			
			i++;
		}
		
		return path;
	}
	
	private static String readWord() {
		System.out.println("Wort eingeben: ");
		var buffer = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			try {
				return buffer.readLine();
			} catch (IOException e) {
				System.out.println("Invalide Eingabe!");
			}
		}
	}
	
}
