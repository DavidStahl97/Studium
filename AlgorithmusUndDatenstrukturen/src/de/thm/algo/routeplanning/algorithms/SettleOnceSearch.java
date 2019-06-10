package de.thm.algo.routeplanning.algorithms;

import java.util.ArrayList;

import de.thm.algo.routeplanning.graph.*;

/** 
 * Abstract base class of all implemented algorithms.
 * The common aspect of all algorithms is the fact that each node is settled at most once.
 * For each reached node a (tentative) predecessor (the edge that led to the node) can be stored.
 * When a node is settled, the last stored predecessor becomes final. Using the stored predecessors,
 * a path can be retrieved backwards from target to source.
 */
public abstract class SettleOnceSearch {
	
	private final ReadOnlyGraph graph;
	private CompleteEdge[] predecessors;
	private SearchListener searchListener;

	public SettleOnceSearch(final ReadOnlyGraph graph) {
		this.graph = graph;
	}
	
	protected ReadOnlyGraph getGraph() {
		return graph;
	}
	
	protected boolean hasBeenReached(final int u) {
		return predecessors[u] != null;
	}
	
	/** 
	 * Stores the given predecessor edge e = (u, v) at the target v of the edge.
	 * Calls the searchListener (if available).
	 */
	protected void update(final int u, final TargetEdge e) {
		final CompleteEdge completeEdge = new CompleteEdge(u, e);
		if (searchListener != null) searchListener.relax(completeEdge);
		predecessors[e.getTarget()] = completeEdge;
	}

	public void setSearchListener(SearchListener searchListener) {
		this.searchListener = searchListener;
	}

	/**
	 * Main entry point for any source-target-query.
	 * @param s the source (starting point) of the query
	 * @param t the target of the query
	 * @return a path (as a sequence of edges) that leads from s to t, or null (if no path has been found).
	 */
	public CompleteEdge[] query(final int s, final int t) {
		// Initialize predecessors, in particular add special source node marker.
		predecessors = new CompleteEdge[graph.getNoOfNodes()];
		final CompleteEdge sourceMarker = new CompleteEdge(s, s);
		predecessors[s] = sourceMarker;
		
		// Perform actual query
		performQuery(s, t);
		
		// Retrieve path backwards
		int u = t;
		if (predecessors[u] == null) return null; // If target has not been reached --> no path has been found.
		final ArrayList<CompleteEdge> reversePath = new ArrayList<>();
		while (predecessors[u] != sourceMarker) {
			reversePath.add(predecessors[u]);
			u = predecessors[u].getSource();
		}
		// Reverse path (in order to get the edges in the right order)
		final CompleteEdge[] result = new CompleteEdge[reversePath.size()];
		int index = reversePath.size()-1;
		for (CompleteEdge e : reversePath) result[index--] = e;
		
		return result;
	}
	
	protected abstract void performQuery(final int s, final int t);

	@Override
	public String toString() {
		return getClass().getSimpleName() + " (" + graph.getClass().getSimpleName() + ")";
	}

	
}
