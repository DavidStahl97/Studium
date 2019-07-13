package de.thm.complexity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	private static Backpack bestBackpack;
	private static List<Package> packages;
	
	public static void main(String[] args) {
		
		populatePackage();
		
		unboundedKnapsack(new Backpack(), 15);
		
		System.out.println("Best Possiblity: ");
		System.out.println(bestBackpack);
		
	}
	
	private static void unboundedKnapsack(Backpack backpack, int max) {		
		for(var p : packages) {			
			if(p.getWeight() + backpack.getWeight() <= max) {
				backpack.add(p);
				unboundedKnapsack(backpack, max);
				backpack.remove(p);
			}
			else {
				if(bestBackpack == null || backpack.getValue() > bestBackpack.getValue()) {
					bestBackpack = new Backpack(backpack);
				}
			}			
		}
	}
	
	private static void populatePackage() {
		Package[] array = {
				new Package(4, 12),
				new Package(2, 2),
				new Package(1, 1),
				new Package(10, 4),
				new Package(2, 1)
			};
			
		packages = new ArrayList<Package>(Arrays.asList(array));
	}
	
}
