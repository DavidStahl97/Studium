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
		
		private final Integer[] array;
		private int currentNode = -1;
		private int nextNode = -1;
		
		public AdjacencyMatrixIterator(int source) {
			array = matrix[source];
		}
		
		@Override
		public boolean hasNext() {
			updateNextNode();
			return nextNode < array.length;
		}

		@Override
		public TargetEdge next() {
			updateNextNode();
			currentNode = nextNode;
			return new TargetEdge(currentNode, array[currentNode]);
		}
		
		private void updateNextNode() {
			if(currentNode == nextNode) {
				for(nextNode = currentNode + 1; nextNode < array.length; nextNode++) {
					if(array[nextNode] != null) {
						return;
					}
				}
			}
		}
		
	}

}
