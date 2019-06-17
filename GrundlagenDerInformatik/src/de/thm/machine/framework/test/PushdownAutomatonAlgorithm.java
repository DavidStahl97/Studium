package de.thm.machine.framework.test;

import java.util.Arrays;

import de.thm.machine.framework.machines.PushdownAutomaton;
import de.thm.machine.framework.tupleElements.PushdownDomain;
import de.thm.machine.framework.tupleElements.PushdownImage;
import de.thm.machine.framework.tupleElements.State;
import de.thm.machine.framework.tupleElements.TransitionFunction;

public class PushdownAutomatonAlgorithm {
	
	public static void excerciseTwo() {
		
		var sa = new State("sa", true);
		var sb = new State("sb", true);
		var notAccepted = new State("notAccepted", false);
		
		var function = new TransitionFunction[] {
			new TransitionFunction(new PushdownDomain(sa, 'a', null), new PushdownImage(sa)),
			new TransitionFunction(new PushdownDomain(sa, 'b', null), new PushdownImage(sb)),
			new TransitionFunction(new PushdownDomain(sb, 'a', null), new PushdownImage(notAccepted)),
			new TransitionFunction(new PushdownDomain(sb, 'b', null), new PushdownImage(sb)),
			new TransitionFunction(new PushdownDomain(notAccepted, 'a', null), new PushdownImage(notAccepted)),
			new TransitionFunction(new PushdownDomain(notAccepted, 'b', null), new PushdownImage(notAccepted))
		};
		
		var maschine = new PushdownAutomaton(Arrays.asList(function), sa);
		var input = "aaaaabbbbbbbbbababab";
		
		System.out.println("Eingabe: " + input);
		var result = maschine.start(input);
		System.out.println(result);
	}
	
	public static void excerciseFour() {
		var s0 = new State("s0");
		var s1 = new State("s1");
		
		
	}
	
}
