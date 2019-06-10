package de.thm.algo.routeplanning.algorithms;

import java.util.Iterator;

import de.thm.algo.routeplanning.graph.*;

public class DepthFirstSearchRecursive extends SettleOnceSearch {
	
	private boolean targetFound = false;

	public DepthFirstSearchRecursive(ReadOnlyGraph graph) {
		super(graph);
	}

	@Override
	protected void performQuery(int s, int t) {
		// relax all edges of s
		Iterator<TargetEdge> it = getGraph().getEdges(s);
		while (it.hasNext()) {
			if (targetFound) return;
			final TargetEdge e = it.next();
			final int v = e.getTarget();
			if (hasBeenReached(v)) continue;
			update(s, e);
			if (v == t) {targetFound = true; return;}			
			performQuery(v, t); // recursive call
		}
	}

}
