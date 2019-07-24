package de.thm.complexity;

public class Package {
	
	private int value;
	private int weight;
	
	public Package(int wert, int gewicht) {
		this.value = wert;
		this.weight = gewicht;
	}
	
	public int getValue() {
		return value;
	}

	public int getWeight() {
		return weight;
	}
	
	@Override
	public String toString() {
		return value + ", " + weight;
	}
}
