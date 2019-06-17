package de.thm.parsen;

public class Main {
	
	public static void main(String[] args) {
		
		var word = "[wort, [sdfsdf,dsf,sdf,a,a,[sdf]], sdfsdf, Sfdsfs]";
		System.out.println("Validierung: " + word);
		
		var parser = new ListParser(new ListLexer(word));
		parser.valid();
		
		System.out.println("akzeptiert");
		
	}
	
}
