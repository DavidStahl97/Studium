package de.thm.machine.framework.tupleElements;

import de.thm.machine.framework.Util;

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
	
	public void setInput(Character input) {
		this.input = input;
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
