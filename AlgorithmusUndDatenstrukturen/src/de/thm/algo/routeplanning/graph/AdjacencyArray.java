package de.thm.algo.routeplanning.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class AdjacencyArray implements ReadOnlyGraph {
	
	final int[] firstEdge; // node array
	final TargetEdge[] edges; // edge array

	public AdjacencyArray(final int noOfNodes, final CompleteEdge[] completeEdges) {
		// Create node and edge array
		firstEdge = new int[noOfNodes+1];
		edges = new TargetEdge[completeEdges.length];
		
		// Sort all edges by (source, target)
		Arrays.sort(completeEdges, new Comparator<CompleteEdge>() {
			@Override
			public int compare(CompleteEdge e1, CompleteEdge e2) {
				if (e1.getSource() == e2.getSource()) return e1.getTarget() - e2.getTarget();
				return e1.getSource() - e2.getSource();
			}});
		
		// Fill arrays
		int lastSource = -1;
		int edgeIndex = 0;
		for (CompleteEdge edge : completeEdges) {
			for (int i = lastSource+1; i <= edge.getSource(); i++) firstEdge[i] = edgeIndex;
			edges[edgeIndex++] = new TargetEdge(edge);
			lastSource = edge.getSource();
		}
		for (int i = lastSource+1; i <= noOfNodes; i++) firstEdge[i] = edgeIndex;
	}

	@Override
	public int getNoOfNodes() {
		return firstEdge.length-1;
	}

	@Override
	public Iterator<TargetEdge> getEdges(int u) {
		return new AdjArrayIterator(u);
	}

	
	private class AdjArrayIterator implements Iterator<TargetEdge> {
		
		private int current;
		private final int last;
		
		public AdjArrayIterator(int u) {
			current = firstEdge[u];
			last = firstEdge[u+1];
		}

		@Override
		public boolean hasNext() {
			return current < last;
		}

		@Override
		public TargetEdge next() {
			return edges[current++];
		}
		
	}
}
