package dfsLeetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/

public class NumberOfConnectedComponents {

	public static void main(String[] args) {
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 3, 4 } };
		System.out.println(countComponents(6, edges));
	}

	public static int countComponents(int n, int[][] edges) { // o(N + M)
		List<List<Integer>> adjList = new ArrayList<>();
		return countComponents(adjList, n, edges);
	}

	public static void buildGraph(List<List<Integer>> adjList, int n, int[][] edges) {
		for (int i = 0; i < n; i++)
			adjList.add(new ArrayList<>());

		for (int i = 0; i < edges.length; i++)
			adjList.get(edges[i][0]).add(edges[i][1]);
	}

	public static int countComponents(List<List<Integer>> adjList, int n, int[][] edges) {
		buildGraph(adjList, n, edges);
		int count = 0;
		List<Boolean> visited = new ArrayList<>(Collections.nCopies(n, false));
		for (int i = 0; i < adjList.size(); i++) {
			if (!visited.get(i)) {
				count++;
				DFS(adjList, i, visited);
			}
		}
		return count;
	}

	public static void DFS(List<List<Integer>> adjList, int target, List<Boolean> visited) { // o(N + M), n = nodes, m =
																								// edges
		List<Integer> list = adjList.get(target);
		visited.set(target, true);
		for (int i = 0; i < list.size(); i++) {
			if (!visited.get(list.get(i))) {
				DFS(adjList, list.get(i), visited);
			}
		}
	}
}
