package de.thm.maschine.framework.tupleElements;

import de.thm.maschine.framework.Util;

public class TuringImage extends Image {
	
	private Character output;
	private ReadDirection direction;
	
	public TuringImage(State state, Character output, ReadDirection direction) {
		super(state);
		this.output = output;
		this.direction = direction;
	}

	public Character getOutput() {
		return output;
	}
	
	public ReadDirection getReadDirection() {
		return direction;
	}
	
	@Override
	public String toString() {
		return Util.toTupleString(getState(), output, direction);
	}

}
