package de.thm.machine.framework.tupleElements;

import de.thm.machine.framework.Util;

public class PushdownDomain extends Domain {
	
	private Character popValue;

	public PushdownDomain(State state, Character input, Character popValue) {
		super(state, input);
		
		this.popValue = popValue;
	}

	public Character getPopValue() {
		return popValue;
	}
	
	@Override
	public boolean equals(Object obj) {
		var domain = (PushdownDomain)obj;
		return super.equals(obj) && domain.popValue == this.popValue;
	}
	
	@Override
	public String toString() {
		return Util.toTupleString(getState(), getInput(), popValue);
	}
	
}
