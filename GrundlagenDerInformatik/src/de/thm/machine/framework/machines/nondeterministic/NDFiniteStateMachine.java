package de.thm.machine.framework.machines.nondeterministic;

import java.util.Arrays;
import java.util.List;

import de.thm.machine.framework.configuration.Configuration;
import de.thm.machine.framework.machines.FiniteStateMachine;
import de.thm.machine.framework.tupleElements.Domain;
import de.thm.machine.framework.tupleElements.State;
import de.thm.machine.framework.tupleElements.Transition;
import de.thm.machine.framework.tupleElements.TransitionFunction;

public class NDFiniteStateMachine extends FiniteStateMachine {
	
	private BreadthFirstSearch search;
	private Capture currentCapture;
	
	public NDFiniteStateMachine(TransitionFunction function, State start) {
		super(function, start);		
		search = new BreadthFirstSearch(function);
	}
	
	@Override
	protected List<Domain> nextDomainList(State currentState, Character cell) {
		currentCapture = search.getNextTransition();
		super.currentCellIndex = currentCapture.getConfiguration().getCellIndex();
		return Arrays.asList(currentCapture.getTransition().getDomain());
	}
	
	@Override
	protected Transition getTransition(List<Domain> domain) {
		return currentCapture.getTransition();
	}
	
	@Override
	protected Configuration getCurrentConfiguration(State state, String word, int cellIndex) {
		var configuration = super.getCurrentConfiguration(state, word, cellIndex);
		var list = super.nextDomainList(state, getInputCell());
		search.captureTransitions(list, configuration);
		
		return configuration;
	}
	
}
