package de.thm.algo.routeplanning.graph;

import java.util.Iterator;

public class AdjacencyMatrix implements UpdateableGraph {
	
	public final Integer[][] matrix;
	
	public AdjacencyMatrix(final int noOfNodes, final CompleteEdge[] completeEdges) {
		
		matrix = new Integer[noOfNodes][noOfNodes];
		
		for(var edge : completeEdges) {
			addEdge(edge);
		}
	}
	
	@Override
	public int getNoOfNodes() {
		return matrix.length;
	}

	@Override
	public Iterator<TargetEdge> getEdges(int u) {
		return new AdjacencyMatrixIterator(u);
	}

	@Override
	public void addEdge(CompleteEdge edge) {
		matrix[edge.getSource()][edge.getTarget()] = edge.getWeight();
	}
	
	private class AdjacencyMatrixIterator implements Iterator<TargetEdge> {
		
		private final int source;
		private int nextTarget;
		
		public AdjacencyMatrixIterator(int source) {
			this.source = source;
		}
		
		@Override
		public boolean hasNext() {
			for(var i : matrix[source]) {
				if(i != null) {
					nextTarget = i;
					return true;
				}
			}
			
			return false;
		}

		@Override
		public TargetEdge next() {
			return new TargetEdge(nextTarget, matrix[source][nextTarget]);
		}
		
	}

}
