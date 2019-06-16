package de.thm.machine.framework.tupleElements;

import java.util.Arrays;

import de.thm.machine.framework.Util;

public class PushdownImage extends Image {
	
	private Character[] pushValues;

	public PushdownImage(State state, Character[] pushValues) {
		super(state);
		this.pushValues = pushValues;
	}
	
	public PushdownImage(State state, Character pushValue) {
		super(state);
		this.pushValues = pushValue == null ? new Character[] { } : new Character[] { pushValue };
	}
	
	public PushdownImage(State state) {
		super(state);
		this.pushValues = new Character[] { };
	}

	public Character[] getPushValues() {
		return pushValues;
	}
	
	@Override
	public String toString() {
		return Util.toTupleString(getState(), Arrays.toString(pushValues));
	}
	
}
