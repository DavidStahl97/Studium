package de.thm.parsen.list;

import de.thm.parsen.framework.Lexer;
import de.thm.parsen.framework.Token;
import de.thm.parsen.framework.exception.InvalidCharException;

public class ListLexer extends Lexer {
	
	public ListLexer(String input) {
		super(input);
	}

	@Override
	public Token nextToken() {
		while(c != EOF) {
			switch(c) {
				case ' ':
				case '\t':
				case '\n':
				case '\r':
					whiteSpace();
					continue;
				
				case ',': 
					consume();
					return new Token(",", TupleType.COMMA.name());
					
				case '[':
					consume();
					return new Token("[", TupleType.LBRACK.name());
					
				case ']':
					consume();
					return new Token("]", TupleType.RBRACK.name());
					
				default:
					if(isLetter()) return createLetterToken();
					throw new InvalidCharException(c);
			}
		}
		
		return new Token("<EOF>", TupleType.EOF.name());
	}

	private Token createLetterToken() {
		var buffer = new StringBuilder();
		do {
			buffer.append(c);
			consume();
		} while(isLetter());
		
		return new Token(buffer.toString(), TupleType.NAME.name());
	}
	
	private boolean isLetter() {
		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
	}
	
	private void whiteSpace() {
		while(c == ' ' || c == '\t') {
			consume();
		}
	}
}
