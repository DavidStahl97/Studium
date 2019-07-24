package de.thm.machine.framework.machines;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import de.thm.machine.framework.configuration.Configuration;
import de.thm.machine.framework.configuration.PushdownConfiguration;
import de.thm.machine.framework.tupleElements.Domain;
import de.thm.machine.framework.tupleElements.Image;
import de.thm.machine.framework.tupleElements.PushdownDomain;
import de.thm.machine.framework.tupleElements.PushdownImage;
import de.thm.machine.framework.tupleElements.State;
import de.thm.machine.framework.tupleElements.Transition;
import de.thm.machine.framework.tupleElements.TransitionFunction;

public class PushdownAutomaton extends FiniteStateMachine {
	
	private Stack<Character> stack;
	
	public PushdownAutomaton(TransitionFunction function, State start) {
		super(function, start);
	}
	
	@Override
	protected List<Domain> nextDomainList(State currentState, Character cell) {
		return nextDomainList(currentState, cell, stack);
	}
	
	public static List<Domain> nextDomainList(State currentState, Character cell, Stack<Character> stack) {
		var value = stack.isEmpty() ? null : stack.pop();
		return Arrays.asList(
			new PushdownDomain(currentState, cell, value),
			new PushdownDomain(currentState, null, value)
		);
	}
	
	@Override
	protected void processFunction(Domain domain, Image image) {
		super.processFunction(domain, image);
		processFunction(domain, image, stack);
	}
	
	public static void processFunction(Domain domain, Image image, Stack<Character> stack) {
		var pushdownImage = (PushdownImage)image;
		var pushValues = pushdownImage.getPushValues();
		
		if(pushValues != null) {
			for(var value : pushValues) {
				stack.push(value);
			}
		}
	}
	
	@Override
	protected Configuration getCurrentConfiguration(State state, String word, int cellIndex) {
		return getCurrentConfiguration(state, word, cellIndex, stack);
	}
	
	public static Configuration getCurrentConfiguration(State state, String word, int cellIndex, 
			Stack<Character> stack) {
		return new PushdownConfiguration(state, word, cellIndex, stack);
	}
	
	@Override
	protected void initialize() {
		super.initialize();
		stack = new Stack<Character>();
	}
	
	@Override
	protected boolean terminate() {
		return true;
	}
}
