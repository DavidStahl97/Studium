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
		match(ListLexer.EOF_TYPE);
	}
	
	private void list() {
		match(ListLexer.LBRACK);
		elements();
		match(ListLexer.RBRACK);
	}
	
	private void elements() {
		element();
		while(lookahead.getType() == ListLexer.COMMA) {
			match(ListLexer.COMMA);
			element();
		}
	}
	
	private void element() {
		if(lookahead.getType() == ListLexer.NAME)
			match(ListLexer.NAME);
		else if(lookahead.getType() == ListLexer.LBRACK)
			list();
		else throw new TokenTypeException(input.getTokenTypes(ListLexer.NAME, ListLexer.LBRACK), lookahead);
	}
	
}
