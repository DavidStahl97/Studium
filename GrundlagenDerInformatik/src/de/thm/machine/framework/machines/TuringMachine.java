package de.thm.machine.framework.machines;

import java.util.List;

import de.thm.machine.framework.tupleElements.State;
import de.thm.machine.framework.tupleElements.TransitionFunction;

public class TuringMachine extends TuringAcceptorMachine {

	public TuringMachine(List<TransitionFunction> functions, State start) {
		super(functions, start);
	}
	
	@Override
	protected String returnResult() {
		return "Ausgabe: " + word;
	}

}
