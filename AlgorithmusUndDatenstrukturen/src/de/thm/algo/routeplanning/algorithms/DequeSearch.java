package de.thm.algo.routeplanning.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

import de.thm.algo.routeplanning.graph.ReadOnlyGraph;
import de.thm.algo.routeplanning.graph.TargetEdge;

/**
 * Abstract base class of BreadthFirstSearch (BFS) and DepthFirstSearch (DFS).
 */
abstract class DequeSearch extends IterativeSearch<DequeSearch.NodeElement> {

	/** Data structure (deque) that can be used as queue (BFS) or as stack (DFS). */
	protected Deque<NodeElement> deque;

	public DequeSearch(ReadOnlyGraph graph) {
		super(graph);
	}

	@Override
	protected void init(int s) {
		deque = new ArrayDeque<NodeElement>();
		deque.addLast(new NodeElement(s));		
	}

	@Override
	protected boolean isEmpty() {
		return deque.isEmpty();
	}
	
	@Override
	protected NodeElement createNodeElement(NodeElement u, TargetEdge e) {
		return new NodeElement(e.getTarget());
	}

	@Override
	protected boolean shouldBeUpdated(NodeElement v) {
		return !hasBeenReached(v.id);
	}

	@Override
	protected void add(final NodeElement v) {
		deque.addLast(v);		
	}


	/** Simple NodeElement that just stores the id of a node. */
	static class NodeElement implements IterativeNodeElement {
		
		private int id;

		public NodeElement(int id) {
			this.id = id;
		}

		@Override
		public int id() {
			return id;
		}
		
	}
}
