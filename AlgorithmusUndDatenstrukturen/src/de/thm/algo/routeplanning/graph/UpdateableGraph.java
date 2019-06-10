package de.thm.algo.routeplanning.graph;

/**
 * Note that in addition to providing an addEdge-method an UpdateableGraph's getEdges-method
 * should return an iterator that supports the remove-method.
 */
public interface UpdateableGraph extends ReadOnlyGraph {
	void addEdge(final CompleteEdge edge);	
}
