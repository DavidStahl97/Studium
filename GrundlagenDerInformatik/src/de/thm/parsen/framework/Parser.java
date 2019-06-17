package de.thm.parsen.framework;

public abstract class Parser {
	
	protected Lexer input;
	protected Token lookahead;
	
	public Parser(Lexer input) {
		this.input = input;
		consume();
	}
	
	protected void match(int x) {
		if(lookahead.getType() == x) consume();
		else throw new RuntimeException("Excepting " + input.getTokenName(x) + "; but was " + lookahead);
	}
	
	private void consume() {
		lookahead = input.nextToken();
	}
	
	public abstract void valid();
	
	public String getInput() {
		return input.getInput();
	}
}
