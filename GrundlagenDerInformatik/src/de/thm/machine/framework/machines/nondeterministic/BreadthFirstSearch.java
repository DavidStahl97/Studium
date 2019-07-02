package de.thm.machine.framework.machines.nondeterministic;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import de.thm.machine.framework.configuration.Configuration;
import de.thm.machine.framework.tupleElements.Domain;
import de.thm.machine.framework.tupleElements.Transition;
import de.thm.machine.framework.tupleElements.TransitionFunction;

public class BreadthFirstSearch {
	
	private Queue<Capture> queue;
	private TransitionFunction function;
	
	public BreadthFirstSearch(TransitionFunction function) {
		queue = new LinkedList<Capture>();
	}
	
	public Capture getNextTransition() {
		return queue.poll();
	}
	
	public void captureTransitions(List<Domain> domain, Configuration configuration) {
		for(var transition : function.getTransitions(domain)) {
			var capture = new Capture(transition, configuration);
			queue.add(capture);
		}
	}
	
}
