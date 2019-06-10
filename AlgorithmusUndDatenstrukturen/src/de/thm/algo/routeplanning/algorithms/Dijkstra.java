package de.thm.algo.routeplanning.algorithms;

import de.thm.algo.routeplanning.graph.ReadOnlyGraph;
import de.thm.algo.routeplanning.graph.TargetEdge;
import de.thm.algo.routeplanning.helper.AbstractPQueueElement;
import de.thm.algo.routeplanning.helper.PQueue;

public class Dijkstra extends IterativeSearch<Dijkstra.NodeElement> {
	
	/**
	 * Stores for each node id the associated NodeElement if the node has been reached (added to the pqueue).
	 * An entry is null if the node has not been reached, yet.
	 */
	private NodeElement[] nodeElements;
	
	private PQueue<NodeElement> pqueue;

	
	public Dijkstra(ReadOnlyGraph graph) {
		super(graph);
		nodeElements = new NodeElement[graph.getNoOfNodes()];
	}

	@Override
	protected void init(int s) {
		pqueue = new PQueue<>();
		pqueue.insert(new NodeElement(s, 0));
		nodeElements[s] = new NodeElement(s, 0);
	}
	
	@Override
	protected boolean isEmpty() {
		return pqueue.isEmpty();
	}
	
	@Override
	protected NodeElement remove() {
		return pqueue.deleteMin();
	}
	
	@Override
	protected NodeElement createNodeElement(NodeElement u, TargetEdge e) {
		// computes the new distance (= old distance plus length/weight of the edge)
		return new NodeElement(e.getTarget(), u.getDistance() + e.getWeight());
	}
	
	@Override
	protected boolean shouldBeUpdated(NodeElement v) {
		return (!hasBeenReached(v.id())) || (v.getDistance() < nodeElements[v.id()].getDistance());
	}

	@Override
	protected void add(NodeElement v) {
		final int vID = v.id();
		if (nodeElements[vID] == null) {
			// Case 1: Reached for the first time (-> insert).
			nodeElements[vID] = v;
			pqueue.insert(nodeElements[vID]);
		} else {
			// Case 2: Already reached. Distance improved (-> decreaseKey).
			nodeElements[vID].setDistance(v.getDistance());
			pqueue.decreaseKey(nodeElements[vID]);
		}	
	}
	


	
	
	/** Encapsulates node id and best known distance. */
	static class NodeElement extends AbstractPQueueElement<NodeElement> implements IterativeNodeElement {
		private final int id;
		private int distance;
		
		public NodeElement(int id, int distance) {
			this.id = id;
			this.distance = distance;
		}

		public int id() {
			return id;
		}

		public int getDistance() {
			return distance;
		}

		public void setDistance(int distance) {
			this.distance = distance;
		}

		@Override
		public int compareTo(NodeElement o) {
			return distance - o.distance;
		}
		
	}

}
