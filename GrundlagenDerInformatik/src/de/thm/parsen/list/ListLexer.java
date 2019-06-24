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
					return new Token(",", TokenType.COMMA.name());
					
				case '[':
					consume();
					return new Token("[", TokenType.LBRACK.name());
					
				case ']':
					consume();
					return new Token("]", TokenType.RBRACK.name());
					
				default:
					if(isLetter(c)) return readToken(ListLexer::isLetter, TokenType.NAME.name());
					throw new InvalidCharException(c);
			}
		}
		
		return new Token(EOF_TYPE, TokenType.EOF.name());
	}
	
	private static boolean isLetter(Character character) {
		return (character >= 'a' && character <= 'z') || (character >= 'A' && character <= 'Z');
	}
}
