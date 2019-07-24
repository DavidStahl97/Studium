package de.thm.machine.framework.machines.nondeterministic;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import de.thm.machine.framework.configuration.Configuration;
import de.thm.machine.framework.configuration.PushdownConfiguration;
import de.thm.machine.framework.machines.PushdownAutomaton;
import de.thm.machine.framework.tupleElements.Domain;
import de.thm.machine.framework.tupleElements.Image;
import de.thm.machine.framework.tupleElements.PushdownDomain;
import de.thm.machine.framework.tupleElements.State;
import de.thm.machine.framework.tupleElements.TransitionFunction;

public class NDPushdownAutomaton extends NDFiniteStateMachine {
	
	public NDPushdownAutomaton(TransitionFunction function, State start) {
		super(function, start);
	}
	
	@Override
	protected List<Domain> nextDomainList(State currentState, Character cell) {
		var domain = super.nextDomainList(currentState, cell);
		if(currentRelation != null) {
			var stack = getCurrentStack();
			if(!stack.empty()) {
				stack.pop();
			}
		}
		
		return domain;
	}
	
	@Override
	protected List<Domain> getUncommingDomain(State state, Character cell) {
		var stack = getCurrentStack();
		var value = stack.isEmpty() ? null : stack.peek();
		
		return Arrays.asList(
			new PushdownDomain(state, cell, value),
			new PushdownDomain(state, null, value)
		);
	}
	
	@Override
	protected Configuration getCurrentConfiguration(State state, String word, int cellIndex) {
		return PushdownAutomaton.getCurrentConfiguration(state, word, cellIndex, getClonedStack());
	}
	
	@Override
	protected void processDeterministicFunction(Domain domain, Image image) {
		super.processDeterministicFunction(domain, image);		
		PushdownAutomaton.processFunction(domain, image, getCurrentStack());
	}
	
	private Stack<Character> getCurrentStack() {
		if(currentRelation == null) {
			var configuration = new PushdownConfiguration(currentState, word, currentCellIndex, 
					new Stack<Character>());
			currentRelation = new ConfigurationTransitionRelation(null, configuration);
			return configuration.getStack();
		}
		
		return ((PushdownConfiguration)currentRelation.getConfiguration()).getStack();
	}
	
	@SuppressWarnings("unchecked")
	private Stack<Character> getClonedStack() {
		return (Stack<Character>)getCurrentStack().clone();
	}

}
