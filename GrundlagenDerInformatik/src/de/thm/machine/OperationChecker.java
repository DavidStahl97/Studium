package de.thm.machine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.thm.machine.framework.machines.PushdownAutomaton;
import de.thm.machine.framework.tupleElements.PushdownDomain;
import de.thm.machine.framework.tupleElements.PushdownImage;
import de.thm.machine.framework.tupleElements.State;
import de.thm.machine.framework.tupleElements.TransitionFunction;

public class OperationChecker {
	
	private static final char OPEN_BRACKET = '(';
	private static final char CLOSE_BRACKET = ')';
	
	private static final char ADDITION = '+';
	private static final char SUBSTRACTION = '-';
	private static final char MULTIPLICATION = '*';
	private static final char DIVISION = '/';
	
	private PushdownAutomaton machine;
	
	public OperationChecker() {
		createMachine();
	}
	
	public String validate(String word) {
		return machine.start(word);
	}
	
	public void createMachine() {
		var s0 = new State("s0", false);
		var s1 = new State("s1", false);
		var s2 = new State("s2", false);
		var s3 = new State("s3", false);
		var end = new State("end", true);
		
		var function = new ArrayList<TransitionFunction>();
		
		// ***
		// State s0
		// ***
		function.add(new TransitionFunction(
			new PushdownDomain(s0, OPEN_BRACKET, OPEN_BRACKET), 
			new PushdownImage(s0, new Character[] { OPEN_BRACKET, OPEN_BRACKET })
		));
		function.add(new TransitionFunction(
			new PushdownDomain(s0, OPEN_BRACKET, null), 
			new PushdownImage(s0, OPEN_BRACKET)
		));
		
		function.addAll(functionWithNumbers(s0, OPEN_BRACKET, s1, OPEN_BRACKET));
		function.addAll(functionWithNumbers(s0, s1));
		
		function.add(new TransitionFunction(new PushdownDomain(s0, null, null), new PushdownImage(end)));
		
		function.add(new TransitionFunction(new PushdownDomain(s0, ADDITION, null), new PushdownImage(s2)));
		function.add(new TransitionFunction(new PushdownDomain(s0, ADDITION, OPEN_BRACKET), new PushdownImage(s2, OPEN_BRACKET)));
		function.add(new TransitionFunction(new PushdownDomain(s0, SUBSTRACTION, null), new PushdownImage(s2)));
		function.add(new TransitionFunction(new PushdownDomain(s0, SUBSTRACTION, OPEN_BRACKET), new PushdownImage(s2, OPEN_BRACKET)));
		
		// ***
		// State s1
		// ***
		function.addAll(functionWithNumbers(s1, OPEN_BRACKET, s1, OPEN_BRACKET));
		function.addAll(functionWithNumbers(s1, s1));
		
		function.add(new TransitionFunction(new PushdownDomain(s1, CLOSE_BRACKET, OPEN_BRACKET), new PushdownImage(s1)));
		
		function.add(new TransitionFunction(
			new PushdownDomain(s1, OPEN_BRACKET, OPEN_BRACKET), 
			new PushdownImage(s1, new Character[] { OPEN_BRACKET, OPEN_BRACKET })
		));
		function.add(new TransitionFunction(
			new PushdownDomain(s1, OPEN_BRACKET, null), 
			new PushdownImage(s1, OPEN_BRACKET)
		));
		
		function.addAll(functionWithOperations(s1, OPEN_BRACKET, s2, OPEN_BRACKET));
		function.addAll(functionWithOperations(s1, null, s2, null));
		
		function.add(new TransitionFunction(new PushdownDomain(s1, null, null), new PushdownImage(end)));
		
		// ***
		// State s2
		// ***
		function.add(new TransitionFunction(
			new PushdownDomain(s2, OPEN_BRACKET, OPEN_BRACKET), 
			new PushdownImage(s3, new Character[] { OPEN_BRACKET, OPEN_BRACKET })
		));
		function.add(new TransitionFunction(
			new PushdownDomain(s2, OPEN_BRACKET, null), 
			new PushdownImage(s3, OPEN_BRACKET)
		));
		
		function.addAll(functionWithNumbers(s2, OPEN_BRACKET, s1, OPEN_BRACKET));
		function.addAll(functionWithNumbers(s2, s1));
		
		// ***
		// State s3
		// ***
		function.add(new TransitionFunction(
			new PushdownDomain(s3, OPEN_BRACKET, OPEN_BRACKET), 
			new PushdownImage(s3, new Character[] { OPEN_BRACKET, OPEN_BRACKET })
		));
		
		function.add(new TransitionFunction(new PushdownDomain(s3, ADDITION, OPEN_BRACKET), new PushdownImage(s2, OPEN_BRACKET)));
		function.add(new TransitionFunction(new PushdownDomain(s3, SUBSTRACTION, OPEN_BRACKET), new PushdownImage(s2, OPEN_BRACKET)));
		
		function.addAll(functionWithNumbers(s3, OPEN_BRACKET, s1, OPEN_BRACKET));
		function.addAll(functionWithNumbers(s3, s1));
		
		machine = new PushdownAutomaton(function, s0);
	}
	
	private List<TransitionFunction> functionWithOperations(State state, Character popValue, State nextState, Character pushValue) {
		return Arrays.asList(new TransitionFunction[] {
			createFunctionWithOperation(state, popValue, nextState, pushValue, ADDITION),
			createFunctionWithOperation(state, popValue, nextState, pushValue, SUBSTRACTION),
			createFunctionWithOperation(state, popValue, nextState, pushValue, MULTIPLICATION),
			createFunctionWithOperation(state, popValue, nextState, pushValue, DIVISION),
		});
	}
	
	private TransitionFunction createFunctionWithOperation(State state, Character popValue, State nextState, Character pushValue, Character operation) {
		var domain = new PushdownDomain(state, operation, popValue);
		var image = new PushdownImage(nextState, pushValue);
		return new TransitionFunction(domain, image);
	}
	
	
	private List<TransitionFunction> functionWithNumbers(State state, Character popValue, State nextState, Character[] pushValues) {
		var array = new ArrayList<TransitionFunction>(10);
		
		for(int i = 0; i <= 9; i++) {
			var domain = new PushdownDomain(state, Integer.toString(i).charAt(0), popValue);
			var image = new PushdownImage(nextState, pushValues);
			
			array.add(new TransitionFunction(domain, image));
		}
		
		return array;
	}
	
	private List<TransitionFunction> functionWithNumbers(State state, Character popValue, State nextState, Character pushValue) {
		return functionWithNumbers(state, popValue, nextState, new Character[] { pushValue });
	}
	
	private List<TransitionFunction> functionWithNumbers(State state, State nextState) {
		return functionWithNumbers(state, null, nextState, new Character[] { });
	}
}
