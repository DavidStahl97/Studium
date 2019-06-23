package de.thm.parsen.framework;

import de.thm.parsen.framework.exception.TokenTypeException;

public abstract class Parser {
	
	protected Lexer input;
	protected Token lookahead;
	
	public Parser(Lexer input) {
		this.input = input;
		consume();
	}
	
	protected void match(String expectedType) {
		if(lookahead.getType() == expectedType) consume();
		else throw new TokenTypeException(expectedType, lookahead);
	}
	
	private void consume() {
		lookahead = input.nextToken();
	}
	
	public abstract void valid();
	
	public String getInput() {
		return input.getInput();
	}
}
