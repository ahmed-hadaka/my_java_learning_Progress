package graphRepresentation_Practicing;

import java.util.ArrayList;
import java.util.List;

/*
 * Space: o(V+E)
 * Time: check if there is an edge(u, v) or not -> o(Degree), where degree = neighbors 
 * Time: list all the neighbors of node u -> o(Degree)
 * Time: traverse the whole graph -> o(V+E)
 * Good for Sparse Graph
*/

public class GraphRepresentation_adjList {
	int numVertices;
	List<List<Integer>> adjList;
	List<List<Edge>> adjListWeighted;

	public GraphRepresentation_adjList(int numVertices, boolean weighted) {
		this.numVertices = numVertices;
		if (!weighted) {
			adjList = new ArrayList<>();
			for (int i = 0; i < numVertices; i++) {
				adjList.add(new ArrayList<>());
			}
		} else {
			adjListWeighted = new ArrayList<>();
			for (int i = 0; i < numVertices; i++) {
				adjListWeighted.add(new ArrayList<>());
			}
		}
	}

	// un_weighted graph

	public void addDirectedEdge(int from, int to) {
		adjList.get(from).add(to);
	}

	public void addUnDirectedEdge(int from, int to) {
		adjList.get(from).add(to);
		adjList.get(to).add(from);
	}

	public void printAdjList() {
		for (int i = 0; i < adjList.size(); i++) {
			System.out.print("Node " + i + " has neibours ");
			for (int j = 0; j < adjList.get(i).size(); j++) {
				System.out.print(adjList.get(i).get(j) + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	// weighted graph

	private class Edge {
		int to;
		int cost;

		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}

	public void addDirectedEdgeWeighted(int from, int to, int cost) {
		adjListWeighted.get(from).add(new Edge(to, cost));
	}

	public void addUnDirectedEdgeWeighted(int from, int to, int cost) {
		adjListWeighted.get(from).add(new Edge(to, cost));
		adjListWeighted.get(to).add(new Edge(from, cost));
	}

	public void printAdjListWeighted() {
		for (int i = 0; i < adjListWeighted.size(); i++) {
			System.out.print("Node " + i + " has neibours ");
			for (int j = 0; j < adjListWeighted.get(i).size(); j++) {
				System.out.print(adjListWeighted.get(i).get(j).to + " (" + adjListWeighted.get(i).get(j).cost + "), ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
