package de.thm.machine.framework.machines.nondeterministic;

import java.util.Arrays;
import java.util.List;

import de.thm.machine.framework.configuration.Configuration;
import de.thm.machine.framework.machines.FiniteStateMachine;
import de.thm.machine.framework.machines.nondeterministic.capture.ConfigurationTransitionRelation;
import de.thm.machine.framework.tupleElements.Domain;
import de.thm.machine.framework.tupleElements.State;
import de.thm.machine.framework.tupleElements.Transition;
import de.thm.machine.framework.tupleElements.TransitionFunction;

public class NDFiniteStateMachine extends FiniteStateMachine {
	
	private BreadthFirstSearch search;
	private ConfigurationTransitionRelation relation;
	
	private boolean canTerminate;
	
	public NDFiniteStateMachine(TransitionFunction function, State start) {
		super(function, start);		
	}
	
	@Override
	protected void initialize() {
		super.initialize();
		canTerminate = false;
		search = new BreadthFirstSearch(super.function);
	}
	
	@Override
	protected List<Domain> nextDomainList(State currentState, Character cell) {
		if(canTerminate) return null;
		
		relation = search.getNextTransition();
		if(relation == null) return null;
		
		super.currentCellIndex = relation.getConfiguration().getCellIndex();
		return Arrays.asList(relation.getTransition().getDomain());
	}
	
	@Override
	protected Transition getTransition(List<Domain> domain) {
		if(canTerminate || relation == null) return null;
		return relation.getTransition();
	}
	
	@Override
	protected Configuration getCurrentConfiguration(State state, String word, int cellIndex) {
		var configuration = super.getCurrentConfiguration(state, word, cellIndex);
		var list = super.nextDomainList(state, getInputCell());
		
		search.captureTransitions(list, configuration);
		
		if(super.terminate() && state.isAcceptedEndState()) {
			canTerminate = true;
		}
		
		return configuration;
	}
	
	@Override
	protected boolean terminate() {
		return true;
	}
	
	@Override
	protected void showCurrentConfiguration(Configuration configuration) {
		if(search.reachedBorder())
			System.out.println(configuration);
		else
			System.out.print(configuration + "  ");
	}
	
}
