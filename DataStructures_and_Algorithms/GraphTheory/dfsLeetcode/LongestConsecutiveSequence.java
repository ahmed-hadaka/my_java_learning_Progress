package dfsLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/longest-consecutive-sequence/

public class LongestConsecutiveSequence {

	public int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<>();
		Map<Integer, List<Integer>> adjList = new HashMap<>();

		for (int i : nums) {
			set.add(i);
		}

		buildGraph(adjList, set);

		set.clear(); // we will use it to mark visited items
		int LongestCS = 1;
		for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
			int key = entry.getKey();
			List<Integer> val = entry.getValue();
			if (!set.contains(key) && val.size() == 1) {
				int count = countConnectedComponentDFS(adjList, set, key);
				LongestCS = Math.max(LongestCS, count);
			}
		}
		return LongestCS;
	}

	private void buildGraph(Map<Integer, List<Integer>> adjList, Set<Integer> set) {
		for (Integer val : set) {
			if (set.contains(val + 1)) {
				addUndirectedEdge(adjList, val, val + 1);
			}
		}
	}

	private void addUndirectedEdge(Map<Integer, List<Integer>> adjList, int from, int to) {
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

	private int countConnectedComponentDFS(Map<Integer, List<Integer>> adjList, Set<Integer> set, int key) {
		set.add(key);
		List<Integer> val = adjList.get(key);
		for (int i : val) {
			if (!set.contains(i)) { // if not visited
				return 1 + countConnectedComponentDFS(adjList, set, i);
			}
		}
		return 1;
	}

}
