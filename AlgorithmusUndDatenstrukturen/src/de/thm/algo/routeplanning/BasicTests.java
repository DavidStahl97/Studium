package de.thm.algo.routeplanning;

import java.util.*;

import de.thm.algo.routeplanning.algorithms.*;
import de.thm.algo.routeplanning.graph.*;

public class BasicTests {
	
	private static final int N = 7; // no of nodes
	private static final int S = 0; // source
	private static final int T = 6; // target

	public static void main(String[] args) {
		readonlyTest();
		updateableTest();		
	}	
	
	/**
	 * Performs the example query in the example graph
	 * for three different graph representations and
	 * for four different algorithms.
	 */
	private static void readonlyTest() {
		System.out.println("Read-only Tests");
		final CompleteEdge[] edges = createEdges();
		final ReadOnlyGraph[] graphs = {
				new AdjacencyMatrix(N, edges), 
				new AdjacencyList(N, edges), 
				new AdjacencyArray(N, edges)};

		final List<SettleOnceSearch> algorithms = new ArrayList<>();
		for (ReadOnlyGraph g : graphs) {
			algorithms.add(new DepthFirstSearchRecursive(g));
			algorithms.add(new DepthFirstSearch(g));
			algorithms.add(new BreadthFirstSearch(g));
			algorithms.add(new Dijkstra(g));
		}

		for (SettleOnceSearch algo : algorithms) {
			System.out.println(algo);
			printPath(algo.query(S, T));
		}
	}
	
	/**
	 * The example graph is built step-by-step by using the add-method
	 * (which is available for the AdjacencyMatrix and AdjacencyList representation).
	 * Then, the edge (4, 6) is removed.
	 * Finally, the example query is performed.
	 */
	private static void updateableTest() {
		System.out.println("Updateable Test");
		final UpdateableGraph graph = createUpdateableTestGraph();
		final CompleteEdge[] edges = createEdges();
		for (CompleteEdge e : edges) graph.addEdge(e);
		
		Iterator<TargetEdge> it = graph.getEdges(4);
		while (it.hasNext()) {
			final TargetEdge e = it.next();
			if (e.getTarget() == 6) it.remove();
		}
		
		final SettleOnceSearch search = new Dijkstra(graph);
		printPath(search.query(S, T));
	}
	
	private static CompleteEdge[] createEdges() {
		List<CompleteEdge> edges = new ArrayList<>();
		addUndirected(edges, 0, 1, 2);
		addUndirected(edges, 0, 2, 3);
		addUndirected(edges, 1, 3, 4);
		addUndirected(edges, 1, 5, 7);
		addUndirected(edges, 2, 3, 2);
		addUndirected(edges, 2, 4, 2);
		addUndirected(edges, 3, 4, 1);
		addUndirected(edges, 3, 5, 3);
		addUndirected(edges, 4, 6, 2);
		addUndirected(edges, 5, 6, 2);
		return edges.toArray(new CompleteEdge[0]);
	}
	
	private static void addUndirected(final List<CompleteEdge> edges, int s, int t, int w) {
		edges.add(new CompleteEdge(s, t, w));
		edges.add(new CompleteEdge(t, s, w));
	}
	
	private static void printPath(final CompleteEdge[] path) {
		if (path == null) return;
		for (CompleteEdge e : path) System.out.print(e + " ");
		System.out.println("");
	}
	
	private static UpdateableGraph createUpdateableTestGraph() {
		final UpdateableGraph graph = new AdjacencyList(N, new CompleteEdge[0]);
		return graph;
	}

}
