package de.thm.parsen.logic;

import de.thm.parsen.framework.Lexer;
import de.thm.parsen.framework.Token;

public class LogicLexer extends Lexer {
	
	public static final int INDIV = 2;
	public static final int SET_NAME = 3;
	public static final int AND = 4;
	public static final int OR = 5;
	public static final int OPEN_BRACKET = 6;
	public static final int CLOSE_BRACKET = 7;
	public static final int COMMA = 8;
	public static final int OPEN_BRACKET_2 = 9;
	public static final int CLOSE_BRACKET_2 = 10;
	
	public static final String[] tokenNames = {
		"n/a", "EXPRESSION", "INDIV", "SET_NAME", "AND", "OR", "OPEN_BRACKET", "CLOSE_BRACKET", "COMMA",
		"OPEN_BRACKET_2", "CLOSE_BRACKET_2"
	};
	
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
					return new Token(OR, "|", getTokenName(OR));
					
				case '&':
					consume();
					return new Token(AND, "&", getTokenName(AND));
					
				case '{':
					consume();
					return new Token(OPEN_BRACKET, "{", getTokenName(OPEN_BRACKET));
					
				case '}':
					consume();
					return new Token(CLOSE_BRACKET, "}", getTokenName(CLOSE_BRACKET));
					
				case ',':
					consume();
					return new Token(COMMA, ",", getTokenName(COMMA));
					
				case '(':
					consume();
					return new Token(OPEN_BRACKET_2, "(", getTokenName(OPEN_BRACKET_2));
					
				case ')':
					consume();
					return new Token(CLOSE_BRACKET_2, ")", getTokenName(CLOSE_BRACKET_2));
					
				default:
					if(isSetName(c)) return createSetNameToken();
					if(isIndiv(c)) return createIndivToken();
					
					throw new RuntimeException("Invalid char: " + c);
			}
		}
		
		return new Token(EOF_TYPE, "<EOF>", tokenNames[EOF_TYPE]);
	}

	@Override
	public String getTokenName(int tokenType) {
		return tokenNames[tokenType];
	}
	
	private Token createSetNameToken() {
		var buffer = new StringBuilder();
		do {
			buffer.append(c);
			consume();
		} while(isSetName(c));
		
		return new Token(SET_NAME, buffer.toString(), getTokenName(SET_NAME));
	}
	
	private Token createIndivToken() {
		var buffer = new StringBuilder();
		do {
			buffer.append(c);
			consume();
		} while(isIndiv(c));
		
		return new Token(INDIV, buffer.toString(), getTokenName(INDIV));
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
