package de.thm.machine.framework.machines.nondeterministic;

import java.util.ArrayList;
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
import de.thm.machine.framework.tupleElements.TransitionFunction;

public class NDPushdownAutomaton extends NDFiniteStateMachine {

	public NDPushdownAutomaton(TransitionFunction function, State start) {
		super(function, start);
	}
	
	
}
