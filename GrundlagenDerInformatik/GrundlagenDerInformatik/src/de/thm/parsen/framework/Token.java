package de.thm.parsen.framework;

public class Token {
	
	private String text;
	private String type;
	
	public Token(String text, String typeName) {
		this.text = text;
		this.type = typeName;
	}
	
	public String getText() {
		return text;
	}
	
	public String getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return "<'" + text + "', " + type + ">";
	}
	
}
