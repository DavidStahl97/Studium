package de.thm.algo.routplanning;

import java.util.Iterator;

import de.thm.algo.routplanning.graph.AdjacencyMatrix;
import de.thm.algo.routplanning.graph.CompleteEdge;
import de.thm.algo.routplanning.graph.ReadOnlyGraph;
import de.thm.algo.routplanning.graph.TargetEdge;

public class Main {
	
	public static void main(String[] args) {
		var graph = createGraph();
		testGraph(graph);
	}
	
	private static void testGraph(ReadOnlyGraph graph) {
		for(int i = 0; i < graph.getNoOfNodes(); i++) {
			var iterator = graph.getEdges(i);
			
			System.out.println("Node: " + i);
			testNode(iterator);
			System.out.println();
		}
	}
	
	private static void testNode(Iterator<TargetEdge> iterator) {
		while(iterator.hasNext()) {
			var targetEdge = iterator.next();
			System.out.println(targetEdge);
		}
	}
	
	private static ReadOnlyGraph createGraph() {
		CompleteEdge[] edges = {
				new CompleteEdge(0, 1, 2),
				new CompleteEdge(0, 2, 3),
				new CompleteEdge(1, 3, 4),
				new CompleteEdge(1, 5, 7),
				new CompleteEdge(2, 3, 2),
				new CompleteEdge(2, 4, 2),
				new CompleteEdge(3, 4, 1),
				new CompleteEdge(3, 5, 3),
				new CompleteEdge(4, 6, 2),
				new CompleteEdge(5, 6, 2)
			};
		
		return new AdjacencyMatrix(7, edges);
	}
	
}
