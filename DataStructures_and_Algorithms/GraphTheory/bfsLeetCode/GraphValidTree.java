package bfsLeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/graph-valid-tree/
public class GraphValidTree {
	public static void main(String[] args) {
		int[][] edges = { { 1, 3 }, { 1, 5 }, { 1, 6 }, { 3, 5 }, { 4, 3 }, { 3, 7 }, { 5, 4 }, { 6, 0 }, { 2, 4 },
				{ 2, 8 }, { 0, 2 }, { 2, 8 }, { 2, 2 } };
//		int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 0 } };
		System.out.println(validTree(3, edges));
	}

	public static boolean validTree(int n, int[][] edges) {
		if (n > edges.length) {
			List<List<Integer>> adjList = new ArrayList<>();
			buildGraph(adjList, edges, n);
			boolean isOneComponent = BFS(adjList, n); // check if the graph is disconnected or not.
			return isOneComponent;
		}
		return false;
	}

	private static void buildGraph(List<List<Integer>> adjList, int[][] edges, int n) {
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}
		for (int i = 0; i < edges.length; i++) {
			adjList.get(edges[i][0]).add(edges[i][1]);
			adjList.get(edges[i][1]).add(edges[i][0]);
		}
	}

	// O(V + E) Time, O(v) Space
	public static boolean BFS(List<List<Integer>> adjList, int n) {
		boolean[] visited = new boolean[adjList.size()];
		Queue<Integer> queue = new LinkedList<>();
		int count = 1;
		visited[0] = true; // start from any node
		queue.add(0);
		for (int size = 1; !queue.isEmpty(); size = queue.size()) { // we will process each level by it self
			while (size-- > 0) {
				int temp = queue.poll();
				for (int neighbours : adjList.get(temp)) {
					if (!visited[neighbours]) { // not visited
						queue.add(neighbours);
						visited[neighbours] = true;
						count++;
					}
				}
			}
		}
		return count == n;
	}
}
