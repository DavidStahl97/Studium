package de.thm.algo.routeplanning.algorithms;

import de.thm.algo.routeplanning.graph.ReadOnlyGraph;
import de.thm.algo.routeplanning.graph.TargetEdge;

/**
 * An implementation of A* Search based on the implementation of Dijkstra's Algorithm.
 */
public class Astar extends Dijkstra {

	final private LowerBoundProvider lowerBoundProvider;
	private int currentTargetId;

	public Astar(ReadOnlyGraph graph, LowerBoundProvider lbProvider) {		
		super(graph);
		this.lowerBoundProvider = lbProvider;
	}

	private int lowerBound(int v) {
		if (lowerBoundProvider == null) return 0;
		return lowerBoundProvider.getLowerBound(v, currentTargetId);
	}

	@Override
	protected void performQuery(int s, int t) {
		// We have to remember the current target in order to be able to conveniently access it by
		// the lowerBound method.
		currentTargetId = t;
		
		super.performQuery(s, t);
	}
	
	@Override
	protected NodeElement createNodeElement(NodeElement u, TargetEdge e) {
		final NodeElement v = super.createNodeElement(u, e);
		// correct the standard Dijkstra distance by employing the provided lower bound
		final int dist = v.getDistance() - lowerBound(u.id()) + lowerBound(v.id());
		v.setDistance(dist);
		return v;
	}

}
