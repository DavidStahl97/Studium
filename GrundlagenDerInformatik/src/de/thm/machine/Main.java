package de.thm.machine;

public class Main {
	
	public static void main(String[] args) {
		
		var checker = new OperationChecker();
		
		var word = "-(0+(-(+(-5)+3))*(-(+4))(-3))";
		
		System.out.println(checker.validate(word));
	}
	
}
