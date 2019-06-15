package de.thm.maschine.framework.tupleElements;

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
		return state.toString();
	}
}
