package de.thm.automat;

import java.util.Arrays;

import de.thm.automat.framework.FiniteStateMaschine;
import de.thm.automat.framework.tupleElements.State;
import de.thm.automat.framework.tupleElements.TransitionFunction;

public class FinitStateMachineAlgorithm {
	
	public static void excerciseOne() {
		
		var sa = new State("sa", true);
		var sb = new State("sb", true);
		var notAccepted = new State("notAccepted", false);
		
		var functions = new TransitionFunction[] {
			new TransitionFunction(sa, 'a', sa),
			new TransitionFunction(sa, 'b', sb),
			new TransitionFunction(sb, 'a', notAccepted),
			new TransitionFunction(sb, 'b', sb),
			new TransitionFunction(notAccepted, 'a', notAccepted),
			new TransitionFunction(notAccepted, 'b', notAccepted)
		};
		
		var maschine = new FiniteStateMaschine(Arrays.asList(functions), sa);
		var input = "aaaaabbbbbbbbbababab";
		
		System.out.println("Eingabe: " + input);
		var result = maschine.start(input);
		System.out.println(result);
	}
	
}
