package de.thm.maschine.framework;

import java.util.List;

import de.thm.maschine.framework.tupleElements.State;
import de.thm.maschine.framework.tupleElements.TransitionFunction;

public class TuringMaschine extends TuringAcceptorMaschine {

	public TuringMaschine(List<TransitionFunction> functions, State start) {
		super(functions, start);
	}
	
	@Override
	protected String returnResult() {
		return "Ausgabe: " + word;
	}

}
