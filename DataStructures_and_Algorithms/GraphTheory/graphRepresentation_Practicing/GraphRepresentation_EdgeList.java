package graphRepresentation_Practicing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Space: o(E)
 * Time: check if there is an edge(u, v) or not -> o(E)
 * Time: list all the neighbors of node u -> o(E)
 * Time: traverse the whole graph -> o(E)
 * Slow Algorithm
*/

public class GraphRepresentation_EdgeList {
	private class Edge implements Comparable<Edge> {
		int from;
		int to;
		int weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	// ----------
	List<Edge> edgeList;

	public GraphRepresentation_EdgeList() {
		edgeList = new ArrayList<>();
	}

	public void addEdge(int from, int to, int weight) {
		edgeList.add(new Edge(from, to, weight));
	}

	// print it ordered based on weight
	public void printGraph() {
		Collections.sort(edgeList);
		for (int i = 0; i < edgeList.size(); i++) { // o(E)
			System.out.println("Edge from " + edgeList.get(i).from + " to " + edgeList.get(i).to + " with weight "
					+ edgeList.get(i).weight);
		}
		System.out.println();
	}

}
