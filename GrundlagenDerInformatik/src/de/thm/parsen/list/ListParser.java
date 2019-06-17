package de.thm.parsen.list;

import de.thm.parsen.framework.Lexer;
import de.thm.parsen.framework.Parser;

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
		else throw new RuntimeException("Excepted name or list but was " + lookahead);
	}
	
}
