package dfsLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/

public class RestoreArrayFromAdjacentPairs {

	public static void main(String[] args) {
		int[][] adjPairs = { { 4, -2 }, { 1, 4 }, { -3, 1 } };
		int[] res = restoreArray(adjPairs);
		for (int i : res) {
			System.out.print(i);
		}
	}

	static int i = 0;

	public static int[] restoreArray(int[][] adjacentPairs) {
		Map<Integer, List<Integer>> adjList = new HashMap<>();
		int[] res = new int[adjacentPairs.length + 1];
		Map<Integer, Boolean> visited = new HashMap<>();
		buildGraph(adjList, adjacentPairs);
		for (Map.Entry<Integer, List<Integer>> entery : adjList.entrySet()) {
			int key = entery.getKey();
			List<Integer> val = entery.getValue();
			if (val.size() == 1) {
				RestorArrayDFS(adjList, key, val, visited, res);
				break;
			}
		}
		return res;
	}

	private static void buildGraph(Map<Integer, List<Integer>> adjList, int[][] adjPairs) {
		for (int i = 0; i < adjPairs.length; i++) {
			addUndirectedEdge(adjList, adjPairs[i][0], adjPairs[i][1]);
		}
	}

	private static void addUndirectedEdge(Map<Integer, List<Integer>> adjList, int from, int to) {
		if (adjList.containsKey(from)) {
			adjList.get(from).add(to);
		} else {
			List<Integer> list = new ArrayList<>(Arrays.asList(to));
			adjList.put(from, list);
		}
		if (adjList.containsKey(to)) {
			adjList.get(to).add(from);
		} else {
			List<Integer> list = new ArrayList<>(Arrays.asList(from));
			adjList.put(to, list);
		}
	}

	private static void RestorArrayDFS(Map<Integer, List<Integer>> adjList, int key, List<Integer> val,
			Map<Integer, Boolean> visited, int[] res) {

		visited.put(key, true);
		res[i] = key;
		i++;
		for (Integer i : val) {
			if (!visited.containsKey(i)) {
				RestorArrayDFS(adjList, i, adjList.get(i), visited, res);
			}
		}
	}
}
