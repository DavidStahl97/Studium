package de.thm.machine.framework.machines.nondeterministic.capture;

import de.thm.machine.framework.configuration.Configuration;
import de.thm.machine.framework.tupleElements.Transition;

public class ConfigurationTransitionRelation {
	
	private Transition transition;
	private Configuration configuration;
	
	public ConfigurationTransitionRelation(Transition transition, Configuration configuration) {
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
	
	@Override
	public String toString() {
		return "(" + transition + ", " + configuration + ")";
	}
	
}
