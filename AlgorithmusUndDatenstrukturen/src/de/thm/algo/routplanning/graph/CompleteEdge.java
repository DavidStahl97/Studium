package de.thm.algo.routplanning.graph;

/**
 * Represents an edge storing source, target, and weight.
 */
public class CompleteEdge extends TargetEdge {
	
	private int source;

	public CompleteEdge(int source, int target) {
		super(target);
		this.source = source;
	}

	public CompleteEdge(int source, int target, int weight) {
		super(target, weight);
		this.source = source;
	}
	
	public CompleteEdge(int source, TargetEdge edge) {
		super(edge);
		this.source = source;
	}

	public int getSource() {
		return source;
	}

	@Override
	public String toString() {
		if (getWeight() == 1) {
			return getSource() + "-->" + getTarget();
		} else {
			return getSource() + "-(" + getWeight() + ")->" + getTarget();
		}
	}
	
	

}
