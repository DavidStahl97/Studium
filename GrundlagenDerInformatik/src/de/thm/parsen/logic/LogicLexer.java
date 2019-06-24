package de.thm.parsen.logic;

import de.thm.parsen.framework.Lexer;
import de.thm.parsen.framework.Token;
import de.thm.parsen.framework.exception.InvalidCharException;

public class LogicLexer extends Lexer {
	
	public LogicLexer(String input) {
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
			
				case '|':
					consume();
					return new Token("|", TokenType.OR.name());
					
				case '&':
					consume();
					return new Token("&", TokenType.AND.name());
					
				case '{':
					consume();
					return new Token("{", TokenType.OPEN_CURLY_BRACKET.name());
					
				case '}':
					consume();
					return new Token("}", TokenType.CLOSE_CURLY_BRACKET.name());
					
				case ',':
					consume();
					return new Token(",", TokenType.COMMA.name());
					
				case '(':
					consume();
					return new Token("(", TokenType.OPEN_BRACKET.name());
					
				case ')':
					consume();
					return new Token(")", TokenType.CLOSE_BRACKET.name());
					
				default:
					if(isSetName(c)) return readToken(LogicLexer::isSetName, TokenType.SET_NAME.name());
					if(isIndiv(c)) return readToken(LogicLexer::isIndiv, TokenType.INDIV.name());
					
					throw new InvalidCharException(c);
			}
		}
		
		return new Token("<EOF>", TokenType.EOF.name());
	}
	
	private static boolean isSetName(Character c) {
		return c >= 'A' && c <= 'Z';
	}
	
	private static boolean isIndiv(Character c) {
		return c >= 'a' && c <= 'z';
	}

}
