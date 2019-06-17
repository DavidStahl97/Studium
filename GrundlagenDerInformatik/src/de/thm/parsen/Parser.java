package de.thm.parsen;

public abstract class Parser {
	
	protected Lexer input;
	protected Token lookahead;
	
	public Parser(Lexer input) {
		this.input = input;
		consume();
	}
	
	public void match(int x) {
		if(lookahead.getType() == x) consume();
		else throw new RuntimeException("Excepting " + input.getTokenName(x) + "; but was " + lookahead);
	}
	
	public void consume() {
		lookahead = input.nextToken();
	}
	
}
