package de.thm.algo.routeplanning.algorithms;

import de.thm.algo.routeplanning.graph.ReadOnlyGraph;

public class DepthFirstSearch extends DequeSearch {

	public DepthFirstSearch(ReadOnlyGraph graph) {
		super(graph);
	}
	
	@Override
	protected NodeElement remove() {
		return deque.removeLast();
	}

}
