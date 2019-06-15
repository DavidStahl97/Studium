package de.thm.maschine;

import java.util.Arrays;

import de.thm.maschine.framework.FiniteStateMaschine;
import de.thm.maschine.framework.tupleElements.Domain;
import de.thm.maschine.framework.tupleElements.Image;
import de.thm.maschine.framework.tupleElements.State;
import de.thm.maschine.framework.tupleElements.TransitionFunction;

public class FinitStateMachineAlgorithm {
	
	public static void excerciseOne() {
		
		var sa = new State("sa", true);
		var sb = new State("sb", true);
		var notAccepted = new State("notAccepted", false);
		
		var function = new TransitionFunction[] {
			new TransitionFunction(new Domain(sa, 'a'), new Image(sa)),
			new TransitionFunction(new Domain(sa, 'b'), new Image(sb)),
			new TransitionFunction(new Domain(sb, 'a'), new Image(notAccepted)),
			new TransitionFunction(new Domain(sb, 'b'), new Image(sb)),
			new TransitionFunction(new Domain(notAccepted, 'a'), new Image(notAccepted)),
			new TransitionFunction(new Domain(notAccepted, 'b'), new Image(notAccepted))
		};
		
		var maschine = new FiniteStateMaschine(Arrays.asList(function), sa);
		var input = "aaaaabbbbbbbbbababab";
		
		System.out.println("Eingabe: " + input);
		var result = maschine.start(input);
		System.out.println(result);
	}
	
}
