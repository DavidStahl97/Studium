package de.thm.parsen;

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
					return new Token(COMMA, ",");
					
				case '[':
					consume();
					return new Token(LBRACK, "[");
					
				case ']':
					consume();
					return new Token(RBRACK, "]");
					
				default:
					if(isLetter()) return createLetterToken();
					throw new RuntimeException("Invalid char: " + c);
			}
		}
		
		return new Token(EOF_TYPE, "<EOF>");
	}

	private Token createLetterToken() {
		var buffer = new StringBuilder();
		do {
			buffer.append(c);
			consume();
		} while(isLetter());
		
		return new Token(NAME, buffer.toString());
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