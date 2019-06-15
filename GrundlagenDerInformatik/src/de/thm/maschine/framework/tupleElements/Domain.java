package de.thm.maschine.framework.tupleElements;

import de.thm.maschine.framework.Util;

public class Domain {
	
	private Character input;
	private State state;
	
	public Domain(State state, Character input) {
		this.input = input;
		this.state = state;
	}

	public Character getInput() {
		return input;
	}

	public State getState() {
		return state;
	}
	
	@Override
	public boolean equals(Object obj) {
		var domain = (Domain)obj;
		return domain.input == this.input && this.state.equals(domain.state);
	}
	
	@Override
	public String toString() {
		return Util.toTupleString(state, input);
	}
	
}
