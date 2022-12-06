package dfsLeetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
public class ReorderRoutesToZero {

	int count = 0;

	public int minReorder(int n, int[][] connections) {
		List<List<Edge>> adjList = new ArrayList<>();
		boolean[] visited = new boolean[n];
		buildGraph(adjList, n, connections);

		DFS(adjList, visited, 0);
		return count;
	}

	private class Edge {
		int to;
		boolean isBuild;

		public Edge(int to, boolean isBuild) {
			this.to = to;
			this.isBuild = isBuild;
		}
	}

	private void buildGraph(List<List<Edge>> adjList, int n, int[][] connections) {
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}
		for (int i = 0; i < connections.length; i++) {
			adjList.get(connections[i][0]).add(new Edge(connections[i][1], true));
			adjList.get(connections[i][1]).add(new Edge(connections[i][0], false));
		}
	}

	private void DFS(List<List<Edge>> adjList, boolean[] visited, int node) {
		visited[node] = true;
		for (Edge edge : adjList.get(node)) {
			if (!visited[edge.to]) {
				if (edge.isBuild)
					count++;
				DFS(adjList, visited, edge.to);
			}
		}
	}
}
