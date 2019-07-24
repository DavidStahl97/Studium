package de.thm.parsen.list;

import de.thm.parsen.framework.Lexer;
import de.thm.parsen.framework.Parser;
import de.thm.parsen.framework.exception.TokenTypeException;

public class ListParser extends Parser {

	public ListParser(Lexer input) {
		super(input);
	}
	
	public void valid() {
		list();
		match(TokenType.EOF.name());
	}
	
	private void list() {
		match(TokenType.LBRACK.name());
		elements();
		match(TokenType.RBRACK.name());
	}
	
	private void elements() {
		element();
		while(lookahead.getType() == TokenType.COMMA.name()) {
			match(TokenType.COMMA.name());
			element();
		}
	}
	
	private void element() {
		if(lookahead.getType() == TokenType.NAME.name())
			match(TokenType.NAME.name());
		else if(lookahead.getType() == TokenType.LBRACK.name())
			list();
		else throw new TokenTypeException(new String[] {TokenType.NAME.name(), TokenType.LBRACK.name()}, lookahead);
	}
	
}
