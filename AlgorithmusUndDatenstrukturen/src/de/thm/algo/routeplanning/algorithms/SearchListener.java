package de.thm.algo.routeplanning.algorithms;

import de.thm.algo.routeplanning.graph.CompleteEdge;

/** Can be used to visualize the search process, e.g., within the Hamster simulator. */
public interface SearchListener {
	void relax(final CompleteEdge edge);
}
