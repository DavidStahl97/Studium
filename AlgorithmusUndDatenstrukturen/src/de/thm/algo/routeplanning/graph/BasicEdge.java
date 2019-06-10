package de.thm.algo.routeplanning.graph;

/**
 * Represents an edge without explicitly storing source and target
 * (in order to reduce the memory consumption).
 * That means, only the weight is stored.
 */
public class BasicEdge {
	
	private int weight;

	/**
	 * We can deal with unweighted graphs as well.
	 * If no weight is provided, we use 1 as default weight.
	 */
	public BasicEdge() {
		this(1);
	}

	public BasicEdge(int weight) {
		this.weight = weight;
	}
	
	public BasicEdge(final BasicEdge edge) {
		this(edge.getWeight());
	}

	public int getWeight() {
		return weight;
	}	
	
	@Override
	public String toString() {
		return "weight: " + weight;
	}

}
