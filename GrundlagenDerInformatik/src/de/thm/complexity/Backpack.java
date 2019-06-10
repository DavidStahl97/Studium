package de.thm.complexity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Backpack {
	
	private List<Package> packages;
	
	public Backpack(Backpack backpack) {
		this.packages = new ArrayList<Package>(backpack.packages);
	}
	
	public Backpack() {
		packages = new ArrayList<Package>();
	}
	
	public void add(Package p) {
		packages.add(p);
	}
	
	public void remove(Package p) {
		packages.remove(p);
	}
	
	public int getValue() {
		int sum = 0;
		for(Package p : packages) {
			sum += p.getValue();
		}
		
		return sum;
	}
	
	public int getWeight() {
		int sum = 0;
		for(Package p : packages) {
			sum += p.getWeight();
		}
		
		return sum;
	}
	
	@Override
	public String toString() {
		String s = "Wert, Gewicht, Durschnitt\n";
		for(Package p : packages) {
			s += p.toString() + "\n";
		}
		
		s += "\nWert: " + getValue();
		return s;
	}
	
}
