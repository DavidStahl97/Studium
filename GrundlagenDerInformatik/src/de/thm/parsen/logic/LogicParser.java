package de.thm.parsen.logic;

import de.thm.parsen.framework.Lexer;
import de.thm.parsen.framework.Parser;
import de.thm.parsen.list.ListLexer;

public class LogicParser extends Parser {

	public LogicParser(Lexer input) {
		super(input);
	}
	
	public void valid() {
		expression();
		match(ListLexer.EOF_TYPE);
	}
	
	private void expression() {
		term();
		
		while(lookahead.getType() == LogicLexer.OR) {
			match(LogicLexer.OR);
			term();
		}
	}
	
	private void term() {
		atom();
		
		while(lookahead.getType() == LogicLexer.AND) {
			match(LogicLexer.AND);
			atom();
		}
	}
	
	private void atom() {
		
		switch(lookahead.getType()) {
			case LogicLexer.SET_NAME:
				match(LogicLexer.SET_NAME);
				break;
				
			case LogicLexer.OPEN_BRACKET:
				indivSet();
				break;
				
			case LogicLexer.OPEN_BRACKET_2:
				match(LogicLexer.OPEN_BRACKET_2);
				expression();
				match(LogicLexer.CLOSE_BRACKET_2);
				break;
				
			default:
				throw new RuntimeException("Excepted set_name, indiv_set or new expression but was " + lookahead);
		}
		
	}
	
	private void indivSet() {
		match(LogicLexer.OPEN_BRACKET);
		match(LogicLexer.INDIV);
		
		while(lookahead.getType() == LogicLexer.COMMA) {
			match(LogicLexer.COMMA);
			match(LogicLexer.INDIV);
		}
		
		match(LogicLexer.CLOSE_BRACKET);
	}
	
	
}
