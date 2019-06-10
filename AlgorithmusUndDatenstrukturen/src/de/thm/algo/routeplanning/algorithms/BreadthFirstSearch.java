package de.thm.algo.routeplanning.algorithms;

import de.thm.algo.routeplanning.graph.ReadOnlyGraph;

public class BreadthFirstSearch extends DequeSearch {

	public BreadthFirstSearch(ReadOnlyGraph graph) {
		super(graph);		
	}
	
	@Override
	protected NodeElement remove() {
		return deque.removeFirst();
	}

}
