package de.thm.maschine;

import java.util.Arrays;

import de.thm.maschine.framework.TuringAcceptorMaschine;
import de.thm.maschine.framework.Util;
import de.thm.maschine.framework.tupleElements.Domain;
import de.thm.maschine.framework.tupleElements.ReadDirection;
import de.thm.maschine.framework.tupleElements.State;
import de.thm.maschine.framework.tupleElements.TransitionFunction;
import de.thm.maschine.framework.tupleElements.TuringImage;

public class TuringMaschineAlgorithm {
	
	public static void addition() {
		
		var s0 = new State("s0", false);
		var s1 = new State("s1", false);
		var end = new State("end", true);
		
		var function = new TransitionFunction[] {
			new TransitionFunction(new Domain(s0, '1'), new TuringImage(s1, ' ', ReadDirection.RIGHT)),
			new TransitionFunction(new Domain(s1, '1'), new TuringImage(s1, '1', ReadDirection.RIGHT)),
			new TransitionFunction(new Domain(s1, Util.SPACE), new TuringImage(end, '1', ReadDirection.NEUTRAL))
		};
		
		var maschine = new TuringAcceptorMaschine(Arrays.asList(function), s0);
		var input = "1111 11";
		
		System.out.println("Eingabe: " + input);
		var result = maschine.start(input);
		System.out.println(result);
	}
	
}
