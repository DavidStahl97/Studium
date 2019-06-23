package de.thm.parsen.logic;

import de.thm.parsen.framework.Lexer;
import de.thm.parsen.framework.Token;

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
					return new Token("{", TokenType.OPEN_BRACKET.name());
					
				case '}':
					consume();
					return new Token("}", TokenType.CLOSE_BRACKET.name());
					
				case ',':
					consume();
					return new Token(",", TokenType.COMMA.name());
					
				case '(':
					consume();
					return new Token("(", TokenType.OPEN_BRACKET_2.name());
					
				case ')':
					consume();
					return new Token(")", TokenType.CLOSE_BRACKET_2.name());
					
				default:
					if(isSetName(c)) return createSetNameToken();
					if(isIndiv(c)) return createIndivToken();
					
					throw new RuntimeException("Invalid char: " + c);
			}
		}
		
		return new Token("<EOF>", TokenType.EOF.name());
	}
	
	private Token createSetNameToken() {
		var buffer = new StringBuilder();
		do {
			buffer.append(c);
			consume();
		} while(isSetName(c));
		
		return new Token(buffer.toString(), TokenType.SET_NAME.name());
	}
	
	private Token createIndivToken() {
		var buffer = new StringBuilder();
		do {
			buffer.append(c);
			consume();
		} while(isIndiv(c));
		
		return new Token(buffer.toString(), TokenType.INDIV.name());
	}
	
	private boolean isSetName(char c) {
		return c >= 'A' && c <= 'Z';
	}
	
	private boolean isIndiv(char c) {
		return c >= 'a' && c <= 'z';
	}
	
	private void whiteSpace() {
		while(c == ' ' || c == '\t') {
			consume();
		}
	}

}
