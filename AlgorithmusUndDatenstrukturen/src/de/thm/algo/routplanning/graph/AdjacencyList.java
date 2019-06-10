package de.thm.algo.routplanning.graph;

import java.util.Iterator;

public class AdjacencyList implements UpdateableGraph {
	
	private final ListElement[] heads;

	public AdjacencyList(final int noOfNodes, final CompleteEdge[] edges) {
		heads = new ListElement[noOfNodes];
		for (int i = 0; i < noOfNodes; i++) heads[i] = new ListElement(null);
		for (CompleteEdge edge : edges) addEdge(edge);
	}

	@Override
	public int getNoOfNodes() {
		return heads.length;
	}

	@Override
	public Iterator<TargetEdge> getEdges(int u) {
		return new AdjListIterator(u);
	}

	@Override
	public void addEdge(CompleteEdge edge) {
		heads[edge.getSource()].insertAfter(new ListElement(new TargetEdge(edge)));
	}
	
	/** Represents an element of a doubly-linked list. */
	private class ListElement {
		private ListElement prev, next;
		private TargetEdge edge;
		
		public ListElement(TargetEdge edge) {
			this.edge = edge;
		}
		public ListElement getNext() {
			return next;
		}
		public void insertAfter(ListElement succ) {
			succ.next = next;
			if (next != null) next.prev = succ;
			next = succ;
			succ.prev = this;
		}
		public void remove() {
			prev.next = next;
			if (next != null) next.prev = prev;
		}
		public TargetEdge getEdge() {
			return edge;
		}
	}
	
	private class AdjListIterator implements Iterator<TargetEdge> {
		
		private ListElement e;
		
		public AdjListIterator(int u) {
			e = heads[u];
		}

		@Override
		public boolean hasNext() {
			return e.getNext() != null;
		}

		@Override
		public TargetEdge next() {
			e = e.getNext();
			return e.getEdge();
		}

		@Override
		public void remove() {
			e.remove();
		}		
		
	}

}
