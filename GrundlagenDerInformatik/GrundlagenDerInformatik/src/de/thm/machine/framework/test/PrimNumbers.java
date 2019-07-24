package de.thm.machine.framework.test;

import java.util.ArrayList;
import java.util.List;

import de.thm.machine.MachineFactory;
import de.thm.machine.framework.configuration.Configuration;
import de.thm.machine.framework.machines.IMachine;

public class PrimNumbers {
	
	public static void main(String[] args) {
		
		var machine1 = 
				MachineFactory.getMachine("C:\\Users\\dstah\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\2. Berechenbarkeit\\1. Aufgaben - Automaten\\Turingmachinen\\Primzahlen.tam");
		
		var list1 = testPrimeNumberMachine(machine1);
		
		var machine2 = 
				MachineFactory.getMachine("C:\\Users\\dstah\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\2. Berechenbarkeit\\1. Aufgaben - Automaten\\Turingmachinen\\Primzahlen2.tam");
		
		var list2 = testPrimeNumberMachine(machine2);
		
		System.out.println("Test der ersten Turingmaschine:");
		print(list1);
		
		System.out.println("Test der ersten Turingmaschine:");
		print(list2);
	}
	
	private static List<String> testPrimeNumberMachine(IMachine machine) {		
		var list = new ArrayList<String>();
		
		for(int i = 100; i <= 113; i++) {
			var builder = new StringBuilder();
			for(int j = 0; j < i; j++) {
				builder.append('a');
			}
			
			var s = builder.toString();
			
			var result = machine.start(s);
			result = "Das Wort ist Element der Sprache." == result ? "T" : "F";
			
			list.add(result + " " + i + " Count: " + Configuration.getStepCount());
			System.out.println("next");
		}
		
		return list;
	}
	
	private static void print(List<String> list) {
		System.out.println(String.join("\n", list));
	}
	
}
