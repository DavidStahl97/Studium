package de.thm.parsen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import de.thm.parsen.framework.Parser;
import de.thm.parsen.list.ListLexer;
import de.thm.parsen.list.ListParser;
import de.thm.parsen.logic.LogicLexer;
import de.thm.parsen.logic.LogicParser;

public class Console {
	
	public void start() {
		var word = readWord();
		var parser = createParser(word);
		testWord(parser);
	}
	
	private String readWord() {
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
	
	private Parser createParser(String word) {
		System.out.println("Liste der Parser:");
		System.out.println("1. List");
		System.out.println("2. Logic");
		
		var buffer = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			try {
				System.out.print("Auswählen: ");
				int id = Integer.parseInt(buffer.readLine());
				
				switch(id) {
					case 1:
						return new ListParser(new ListLexer(word));
					case 2:
						return new LogicParser(new LogicLexer(word));
						
					default:
						System.out.println("Keine valide Nummer!");
				}
				
			} catch (IOException e) {
				System.out.println("Nummer eingeben!");
			}
		}

	}
	
	private void testWord(Parser parser) {
		try {
			System.out.println("Input: " + parser.getInput());
			parser.valid();
			System.out.println("Das Wort ist Element der Sprache");
		}
		catch (RuntimeException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Das Wort ist nicht Element der Sprache");
		}
	}
	
}
