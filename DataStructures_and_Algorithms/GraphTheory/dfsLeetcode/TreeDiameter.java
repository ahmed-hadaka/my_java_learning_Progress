package dfsLeetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/tree-diameter/

/*
* my solution used a one call of DFS 
* another solution using two calls of BFS :- first call start from any node x,
* find the far node from x; called y then find the far node from y called z,
* with care of counting the edges we visit so far.*
*/
public class TreeDiameter {

	public static void main(String[] args) {
//		int[][] edges = { { 0, 1 }, { 0, 2 } };
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 4 }, { 4, 5 } };
		System.out.println(treeDiam(edges));
	}

	public static int treeDiam(int[][] edges) {
		int n = edges.length + 1;
		Map<Integer, List<Integer>> adjList = new HashMap<>();
		boolean[] visited = new boolean[n];
		List<List<Integer>> childrenHieght = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			childrenHieght.add(new ArrayList<>());
		}

		buildAdjList(adjList, edges, n);
		DFS(adjList, childrenHieght, visited, 0, adjList.get(0)); // start from any point
		return computeDiameter(adjList, childrenHieght);
	}

	private static void buildAdjList(Map<Integer, List<Integer>> adjList, int[][] edges, int n) {

		for (int i = 0; i < n; i++) {
			adjList.put(i, new ArrayList<>());
		}
		for (int i = 0; i < edges.length; i++) {
			adjList.get(edges[i][0]).add(edges[i][1]);
		}
	}

	private static int computeDiameter(Map<Integer, List<Integer>> adjList, List<List<Integer>> childrenHieght) {
		int max = 0;
		for (List<Integer> list : childrenHieght) {
			int sum = 0;
			for (Integer i : list) {
				sum += i;
			}
			if (sum > max)
				max = sum;
		}
		return max;
	}

	private static int DFS(Map<Integer, List<Integer>> adjList, List<List<Integer>> childrenHieght, boolean[] visited,
			int key, List<Integer> val) {
		visited[key] = true;
		for (int i = 0; i < val.size(); i++) {
			if (!visited[val.get(i)]) {
				childrenHieght.get(key)
						.add(DFS(adjList, childrenHieght, visited, val.get(i), adjList.get(val.get(i))) + 1);
			}
		}
		if (childrenHieght.get(key).isEmpty())
			return 0;
		return Collections.max(childrenHieght.get(key));
	}
}
