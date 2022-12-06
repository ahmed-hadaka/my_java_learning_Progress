package topologicalSortingLeetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/largest-color-value-in-a-directed-graph

// topological sorting version
public class LargestColoredPathValueV2 {
	public int largestPathValue(String colors, int[][] edges) {
		int n = colors.length();
		List<List<Integer>> ourDegreeAdjList = new ArrayList<>();
		int[] inDegree = new int[n];
		ArrayDeque<Integer> q = new ArrayDeque<>();
		int[][] letters = new int[n][26];

		buildAdjList(edges, ourDegreeAdjList, inDegree, n);

		// initialize queue with node with in_degree zero
		for (int i = 0; i < inDegree.length; i++) {
			if (inDegree[i] == 0)
				q.addLast(i);
		}

		return getLargestPathTopoSorting(colors, ourDegreeAdjList, inDegree, q, letters, n);
	}

	private void buildAdjList(int[][] edges, List<List<Integer>> ourDegreeAdjList, int[] inDegree, int n) {
		// initialize outDegree
		for (int i = 0; i < n; i++) {
			ourDegreeAdjList.add(new ArrayList<>());
		}

		for (int i = 0; i < edges.length; i++) {
			ourDegreeAdjList.get(edges[i][0]).add(edges[i][1]);
			inDegree[edges[i][1]]++;
		}
	}

	private int getLargestPathTopoSorting(String colors, List<List<Integer>> ourDegreeAdjList, int[] inDegree,
			ArrayDeque<Integer> q, int[][] letters, int n) {
		int ans = 0, count = 0;
		while (!q.isEmpty()) {
			int value = q.pollFirst();
			int color = colors.charAt(value) - 'a';
			letters[value][color]++;
			ans = Math.max(ans, letters[value][color]);
			count++;
			for (int nodeVal : ourDegreeAdjList.get(value)) {
				if (--inDegree[nodeVal] == 0)
					q.addLast(nodeVal);
				for (int i = 0; i < 26; i++) {
					letters[nodeVal][i] = Math.max(letters[nodeVal][i], letters[value][i]);
				}
			}
		}
		return count == n ? ans : -1;
	}

}
