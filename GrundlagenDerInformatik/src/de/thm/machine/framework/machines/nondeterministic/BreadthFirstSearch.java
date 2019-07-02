package de.thm.machine.framework.machines.nondeterministic;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import de.thm.machine.framework.configuration.Configuration;
import de.thm.machine.framework.machines.nondeterministic.capture.ConfigurationTransitionRelation;
import de.thm.machine.framework.tupleElements.Domain;
import de.thm.machine.framework.tupleElements.Transition;
import de.thm.machine.framework.tupleElements.TransitionFunction;

public class BreadthFirstSearch {
	
	private Queue<ConfigurationTransitionRelation> queue;
	private TransitionFunction function;
	
	private int border = 0;
	private boolean reachedBorder;
	
	public BreadthFirstSearch(TransitionFunction function) {
		this.function = function;
		queue = new LinkedList<ConfigurationTransitionRelation>();
	}
	
	public ConfigurationTransitionRelation getNextTransition() {
		reachedBorder = false;
		border--;
		return queue.poll();
	}
	
	public void captureTransitions(List<Domain> domain, Configuration configuration) {
		var transitions = function.getTransitions(domain);
		
		for(var t : transitions) {
			var capture = new ConfigurationTransitionRelation(t, configuration);
			queue.add(capture);
		}
		
		if(border == 0) {
			border = queue.size();
			reachedBorder = true;
		}
	}
	
	public boolean reachedBorder() {
		return reachedBorder;
	}
}
