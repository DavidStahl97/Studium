package de.thm.algo.routeplanning.algorithms;

import java.util.Iterator;

import de.thm.algo.routeplanning.graph.ReadOnlyGraph;
import de.thm.algo.routeplanning.graph.TargetEdge;

/**
 * Abstract base class of all iterative algorithms.
 */
abstract class IterativeSearch<NE extends IterativeNodeElement> extends SettleOnceSearch {

	public IterativeSearch(ReadOnlyGraph graph) {
		super(graph);
	}

	/** Algorithmic core! */
	@Override
	protected void performQuery(int s, int t) {
		init(s);		
		while (!isEmpty()) {
			final NE u = remove(); // settle u
			if (u.id() == t) return;
			// relax all edges that leave u
			Iterator<TargetEdge> it = getGraph().getEdges(u.id());
			while (it.hasNext()) {
				final TargetEdge e = it.next();
				// process current edge (u, v)
				final NE v = createNodeElement(u, e);
				if (shouldBeUpdated(v)) {					
					update(u.id(), e);
					add(v);
				}
			}
		}
	}
	
	/** Initialize underlying data structures that keep track of the search process. */
	protected abstract void init(int s);
	
	/** Returns true iff there is no further node which should be considered during search. */
	protected abstract boolean isEmpty();
	
	/** Retrieve the node that should be considered next. ("settle node") */
	protected abstract NE remove();
	
	/** Construct (temporarily) a node element that represents the target v of the current edge e = (u, v). */
	protected abstract NE createNodeElement(NE u, TargetEdge e);
	
	/** Returns true iff the state of node v should be updated (because a (better) path has been found). */
	protected abstract boolean shouldBeUpdated(NE v);

	/** Adds the node v to the underlying data structure in order to be processed later. */
	protected abstract void add(NE v);

}
