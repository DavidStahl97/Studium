package de.thm.machine.framework.machines.nondeterministic;

import de.thm.machine.framework.configuration.Configuration;
import de.thm.machine.framework.tupleElements.Transition;

public class Capture {
	
	private Transition transition;
	private Configuration configuration;
	
	public Capture(Transition transition, Configuration configuration) {
		super();
		this.transition = transition;
		this.configuration = configuration;
	}

	public Transition getTransition() {
		return transition;
	}

	public Configuration getConfiguration() {
		return configuration;
	}
	
}
