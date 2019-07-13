package de.thm.machine.framework.tupleElements;

import de.thm.machine.framework.Util;

public class Image {
	
	private State state;

	public Image(State state) {
		this.state = state;
	}

	public State getState() {
		return state;
	}
	
	@Override
	public String toString() {
		return Util.toTupleString(state);
	}
}
