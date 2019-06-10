package de.thm.algo.routeplanning.algorithms;

/** Needed by Astar (A* Search). */
public interface LowerBoundProvider {
	int getLowerBound(int u, int v);
}
