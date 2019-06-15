package de.thm.machine.framework.configuration;

import java.util.List;
import java.util.Stack;

import de.thm.machine.framework.Util;
import de.thm.machine.framework.tupleElements.State;

public class PushdownConfiguration extends Configuration {
	
	private Stack<Character> stack;
	
	public PushdownConfiguration(State state, String word, int cellIndex, Stack<Character> stack) {
		super(state, word, cellIndex);
		this.stack = stack;
	}
	
	@Override
	protected List<String> captureCurrentConfiguration(State state, String word, int cellIndex) {
		var parameters = super.captureCurrentConfiguration(state, word, cellIndex);
		parameters.add(stackToString());
		return parameters;
	}
	
	private String stackToString() {
		var string = "";
		var iterator = stack.iterator();
	
		while(iterator.hasNext()) {
			string += iterator.next();
		}
	
		return string.isEmpty() ? Character.toString(Util.EMPTY) : string;
	}
}
