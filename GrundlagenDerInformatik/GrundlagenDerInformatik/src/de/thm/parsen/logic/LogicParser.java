package de.thm.parsen.logic;

import de.thm.parsen.framework.Lexer;
import de.thm.parsen.framework.Parser;
import de.thm.parsen.framework.exception.TokenTypeException;

public class LogicParser extends Parser {

	public LogicParser(Lexer input) {
		super(input);
	}
	
	public void valid() {
		expression();
		match(TokenType.EOF.name());
	}
	
	private void expression() {
		term();
		
		while(lookahead.getType() == TokenType.OR.name()) {
			match(TokenType.OR.name());
			term();
		}
	}
	
	private void term() {
		atom();
		
		while(lookahead.getType() == TokenType.AND.name()) {
			match(TokenType.AND.name());
			atom();
		}
	}
	
	private void atom() {
		
		var usedType = lookahead.getType();
		
		if(usedType.equals(TokenType.SET_NAME.name())) {
			match(TokenType.SET_NAME.name());
		}
		else if(usedType.equals(TokenType.OPEN_CURLY_BRACKET.name())) {
			indivSet();
		}
		else if(usedType.equals(TokenType.OPEN_BRACKET.name())) {
			match(TokenType.OPEN_BRACKET.name());
			expression();
			match(TokenType.CLOSE_BRACKET.name());
		}
		else {
			throw new TokenTypeException(
					new String[] { TokenType.SET_NAME.name(), "INDIV_SET", "EXPRESSION" }, 
					lookahead);
		}
	}
	
	private void indivSet() {
		match(TokenType.OPEN_CURLY_BRACKET.name());
		
		if(lookahead.getType() == TokenType.INDIV.name()) {
			match(TokenType.INDIV.name());
			
			while(lookahead.getType() == TokenType.COMMA.name()) {
				match(TokenType.COMMA.name());
				match(TokenType.INDIV.name());
			}
		}
		
		match(TokenType.CLOSE_CURLY_BRACKET.name());
	}
	
	
}
