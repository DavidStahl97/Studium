package de.thm.machine.framework.tupleElements;

public enum ReadDirection {
	RIGHT,
	LEFT,
	NEUTRAL;
	
	public static ReadDirection getDirection(char c) {
		switch(c) {
			case 'r':
				return RIGHT;
			case 'l':
				return LEFT;
			case 'n':
				return NEUTRAL;
				
			default:
				throw new RuntimeException("Akzeptieriende Möglichkeiten: r - RIGHT, l - LEFT, n - NEUTRAL");
		}
	}
}
