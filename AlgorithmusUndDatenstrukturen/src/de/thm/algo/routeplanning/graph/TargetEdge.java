package de.thm.algo.routeplanning.graph;

/**
 * Represents an edge, storing target and weight, but omitting the source (in order to reduce the memory consumption).
 */
public class TargetEdge extends BasicEdge {
	
	private int target;

	public TargetEdge(int target) {
		super();
		this.target = target;
	}

	public TargetEdge(int target, int weight) {
		super(weight);
		this.target = target;
	}
	
	public TargetEdge(int target, BasicEdge edge) {
		super(edge);
		this.target = target;
	}
	
	public TargetEdge(TargetEdge edge) {
		this(edge.getTarget(), edge.getWeight());
	}

	public int getTarget() {
		return target;
	}
	
	@Override
	public String toString() {
		return "target: " + target + ", " + super.toString();
	}

}
