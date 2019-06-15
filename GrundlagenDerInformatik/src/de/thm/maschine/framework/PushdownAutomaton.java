package de.thm.maschine.framework;

import java.util.List;
import java.util.Stack;

import de.thm.maschine.framework.configuration.Configuration;
import de.thm.maschine.framework.configuration.PushdownConfiguration;
import de.thm.maschine.framework.tupleElements.Domain;
import de.thm.maschine.framework.tupleElements.Image;
import de.thm.maschine.framework.tupleElements.PushdownDomain;
import de.thm.maschine.framework.tupleElements.PushdownImage;
import de.thm.maschine.framework.tupleElements.State;
import de.thm.maschine.framework.tupleElements.TransitionFunction;

public class PushdownAutomaton extends FiniteStateMaschine {
	
	private Stack<Character> stack;
	
	public PushdownAutomaton(List<TransitionFunction> functions, State start) {
		super(functions, start);
		stack = new Stack<Character>();
	}
	
	@Override
	protected Domain nextDomain(State currentState, Character cell) {
		var value = stack.isEmpty() ? null : stack.pop();
		return new PushdownDomain(currentState, cell, value);
	}
	
	@Override
	protected void processImage(Image image) {
		super.processImage(image);
		
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
		return new PushdownConfiguration(state, word, cellIndex, stack);
	}
	
}
