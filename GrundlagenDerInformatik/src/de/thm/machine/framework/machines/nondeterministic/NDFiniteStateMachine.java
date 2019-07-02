package de.thm.machine.framework.machines.nondeterministic;

import java.util.ArrayList;
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
	protected ConfigurationTransitionRelation currentRelation;
	
	private boolean canTerminate;
	
	public NDFiniteStateMachine(TransitionFunction function, State start) {
		super(function, start);		
	}
	
	@Override
	protected void initialize() {
		super.initialize();
		canTerminate = false;
		search = new BreadthFirstSearch();
	}
	
	@Override
	protected List<Domain> nextDomainList(State currentState, Character cell) {
		if(canTerminate) return null;
		
		currentRelation = search.getNextTransition();
		if(currentRelation == null) return null;
		
		super.currentCellIndex = currentRelation.getConfiguration().getCellIndex();
		return Arrays.asList(currentRelation.getTransition().getDomain());
	}
	
	@Override
	protected Transition getTransition(List<Domain> domain) {
		if(canTerminate || currentRelation == null) return null;
		return currentRelation.getTransition();
	}
	
	@Override
	protected Configuration getCurrentConfiguration(State state, String word, int cellIndex) {
		var relations = getRelations(state, word, cellIndex);
		search.captureTransitions(relations);
		
		if(super.terminate() && state.isAcceptedEndState()) {
			canTerminate = true;
		}
		
		return currentRelation == null ? getStartConfiguration() : currentRelation.getConfiguration();
	}
	
	protected List<ConfigurationTransitionRelation> getRelations(State state, String word, int cellIndex) {
		var configuration = super.getCurrentConfiguration(state, word, cellIndex);
		var domain = super.nextDomainList(state, getInputCell());
		
		var relations = new ArrayList<ConfigurationTransitionRelation>();
		for(var transition : function.getTransitions(domain)) {
			relations.add(new ConfigurationTransitionRelation(transition, configuration));
		}
		
		return relations;
	}
	
	@Override
	protected void showCurrentConfiguration(Configuration configuration) {
		if(search.reachedBorder())
			System.out.println(configuration);
		else
			System.out.print(configuration + "  ");
	}
	
	protected Configuration getStartConfiguration() {
		return super.getCurrentConfiguration(start, word, 0);
	}
	
	@Override
	protected boolean terminate() {
		return true;
	}
	
}
