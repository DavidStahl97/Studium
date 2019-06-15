package de.thm.maschine.framework;

public class Util {
	public static final char EMPTY = 0x9D;
	public static final char SPACE = ' ';
	
	public static String toTupleString(Object... parameters) {
		var string = "(";
		
		int i = 0;
		for(var p : parameters) {
			if(i != 0) string += ", ";
			string += p;
			i++;
		}
		
		string += ")";
		return string;
	}
}
