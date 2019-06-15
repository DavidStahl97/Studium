package de.thm.machine.framework.tupleElements;

import de.thm.machine.framework.Util;

public class PushdownImage extends Image {
	
	private Character[] pushValues;

	public PushdownImage(State state, Character[] pushValues) {
		super(state);
		this.pushValues = pushValues;
	}

	public Character[] getPushValues() {
		return pushValues;
	}
	
	@Override
	public String toString() {
		return Util.toTupleString(getState(), pushValues);
	}
	
}
