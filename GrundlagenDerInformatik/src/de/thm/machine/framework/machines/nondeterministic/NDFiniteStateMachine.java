package de.thm.machine.framework.machines.nondeterministic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.thm.machine.framework.configuration.Configuration;
import de.thm.machine.framework.machines.FiniteStateMachine;
import de.thm.machine.framework.machines.IMachine;
import de.thm.machine.framework.tupleElements.Domain;
import de.thm.machine.framework.tupleElements.Image;
import de.thm.machine.framework.tupleElements.State;
import de.thm.machine.framework.tupleElements.Transition;
import de.thm.machine.framework.tupleElements.TransitionFunction;

public class NDFiniteStateMachine extends FiniteStateMachine {
	
	private BreadthFirstSearch search;
	
	private ConfigurationTransitionRelation currentRelation;
	
	public NDFiniteStateMachine(TransitionFunction function, State start) {
		super(function, start);
	}
	
	@Override
	protected void initialize() {
		super.initialize();
		search = new BreadthFirstSearch();
		
		storeUpcommingTransitions(super.start);
	}
	
	@Override
	protected List<Domain> nextDomainList(State currentState, Character cell) {
		if(accepted()) return null;
		
		currentRelation = search.getNextRelation();
		
		if(currentRelation == null) return null;
		
		super.currentCellIndex = currentRelation.getConfiguration().getCellIndex();
		super.currentState = currentRelation.getConfiguration().getState();
		
		return Arrays.asList(currentRelation.getTransition().getDomain());
	}
	
	@Override
	protected Transition getTransition(List<Domain> domain) {
		if(domain == null) return null;
		return currentRelation.getTransition();
	}
	
	@Override
	protected void processFunction(Domain domain, Image image) {
		super.processFunction(domain, image);
		
		storeUpcommingTransitions(image.getState());
	}
	
	@Override
	protected void showCurrentConfiguration(Configuration configuration) {
		if(search.reachedBorder())
			System.out.println(configuration);
		else
			System.out.print(configuration + "  ");
	}
	
	protected void storeUpcommingTransitions(State state) {
		var cell = super.getInputCell();
		var domainList = super.nextDomainList(state, cell);
		var transitions = function.getTransitions(domainList);
		var configuration = super.getCurrentConfiguration(state, word, currentCellIndex);
		
		var relations = new ArrayList<ConfigurationTransitionRelation>();
		for(var t : transitions) {
			var r = new ConfigurationTransitionRelation(t, configuration);
			relations.add(r);
		}
		
		search.pushRelations(relations);
	}

}
