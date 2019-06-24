package de.thm.parsen.framework;

import java.util.function.Function;

import de.thm.parsen.list.TokenType;

public abstract class Lexer {
	
	public static final char EOF = (char)-1;
	public static final String EOF_TYPE = "<EOF>";
	
	protected String input;
	protected int p = 0;
	protected char c;
	
	public Lexer(String input) {
		this.input = input;
		c = input.charAt(p);
	}
	
	public void consume() {
		p++;
		if(p >= input.length()) c = EOF;
		else c = input.charAt(p);
	}
	
	public void match(char x) {
		if(c == x) consume();
		else throw new RuntimeException("excepted " + x + "but was " + c);
	}
	
	protected Token readToken(Function<Character, Boolean> isLetter, String type) {
		var buffer = new StringBuilder();
		do {
			buffer.append(c);
			consume();
		} while(isLetter.apply(c));
		
		return new Token(buffer.toString(), type);
	};
	
	protected void whiteSpace() {
		while(c == ' ' || c == '\t') {
			consume();
		}
	}
	
	public abstract Token nextToken();
	
	public String getInput() {
		return input;
	}
}
