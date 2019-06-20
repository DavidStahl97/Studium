package de.thm.parsen.list;

import de.thm.parsen.framework.Lexer;
import de.thm.parsen.framework.Token;
import de.thm.parsen.framework.exception.InvalidCharException;

public class ListLexer extends Lexer {
	
	public static int NAME = 2;
	public static int COMMA = 3;
	public static int LBRACK = 4;
	public static int RBRACK = 5;
	
	public static String[] tokenNames = {
		"n/a", "<EOF>", "NAME", "COMMA", "LBRACK", "RBRACK"	
	};
	
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
					return new Token(COMMA, ",", tokenNames[COMMA]);
					
				case '[':
					consume();
					return new Token(LBRACK, "[", tokenNames[LBRACK]);
					
				case ']':
					consume();
					return new Token(RBRACK, "]", tokenNames[RBRACK]);
					
				default:
					if(isLetter()) return createLetterToken();
					throw new InvalidCharException(c);
			}
		}
		
		return new Token(EOF_TYPE, "<EOF>", tokenNames[EOF_TYPE]);
	}

	private Token createLetterToken() {
		var buffer = new StringBuilder();
		do {
			buffer.append(c);
			consume();
		} while(isLetter());
		
		return new Token(NAME, buffer.toString(), tokenNames[NAME]);
	}

	@Override
	public String getTokenName(int tokenType) {
		return tokenNames[tokenType];
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
