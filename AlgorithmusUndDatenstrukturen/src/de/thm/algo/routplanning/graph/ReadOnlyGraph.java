package de.thm.algo.routplanning.graph;

import java.util.Iterator;

public interface ReadOnlyGraph {
	int getNoOfNodes();
	Iterator<TargetEdge> getEdges(int u);
}
