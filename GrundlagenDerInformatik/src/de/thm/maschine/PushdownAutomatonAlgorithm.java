package de.thm.maschine;

import java.util.Arrays;

import de.thm.maschine.framework.PushdownAutomaton;
import de.thm.maschine.framework.tupleElements.PushdownDomain;
import de.thm.maschine.framework.tupleElements.PushdownImage;
import de.thm.maschine.framework.tupleElements.State;
import de.thm.maschine.framework.tupleElements.TransitionFunction;

public class PushdownAutomatonAlgorithm {
	
	public static void excerciseTwo() {
		
		var sa = new State("sa", true);
		var sb = new State("sb", true);
		var notAccepted = new State("notAccepted", false);
		
		var function = new TransitionFunction[] {
			new TransitionFunction(new PushdownDomain(sa, 'a', null), new PushdownImage(sa, null)),
			new TransitionFunction(new PushdownDomain(sa, 'b', null), new PushdownImage(sb, null)),
			new TransitionFunction(new PushdownDomain(sb, 'a', null), new PushdownImage(notAccepted, null)),
			new TransitionFunction(new PushdownDomain(sb, 'b', null), new PushdownImage(sb, null)),
			new TransitionFunction(new PushdownDomain(notAccepted, 'a', null), new PushdownImage(notAccepted, null)),
			new TransitionFunction(new PushdownDomain(notAccepted, 'b', null), new PushdownImage(notAccepted, null))
		};
		
		var maschine = new PushdownAutomaton(Arrays.asList(function), sa);
		var input = "aaaaabbbbbbbbbababab";
		
		System.out.println("Eingabe: " + input);
		var result = maschine.start(input);
		System.out.println(result);
	}
	
}
