package de.thm.machine.framework.machines;

import de.thm.machine.framework.tupleElements.State;
import de.thm.machine.framework.tupleElements.TransitionFunction;

public class TuringMachine extends TuringAcceptorMachine {

	public TuringMachine(TransitionFunction function, State start) {
		super(function, start);
	}
	
	@Override
	protected String returnResult() {
		return "Ausgabe: " + word;
	}

}
