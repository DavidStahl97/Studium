package de.thm.machine.framework.machines.nondeterministic;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
	
	private Queue<ConfigurationTransitionRelation> queue;
	
	private int border = 0;
	private boolean reachedBorder;
	
	public BreadthFirstSearch() {
		queue = new LinkedList<ConfigurationTransitionRelation>();
	}
	
	public ConfigurationTransitionRelation getNextRelation() {
		reachedBorder = false;
		border--;
		return queue.poll();
	}
	
	public void pushRelations(List<ConfigurationTransitionRelation> relations) {
		queue.addAll(relations);
		if(border == 0) {
			border = queue.size();
			reachedBorder = true;
		}
	}
	
	public boolean reachedBorder() {
		return reachedBorder;
	}
}
