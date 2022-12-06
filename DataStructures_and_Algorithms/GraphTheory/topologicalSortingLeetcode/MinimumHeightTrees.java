package topologicalSortingLeetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/minimum-height-trees/
public class MinimumHeightTrees {
	public static void main(String[] args) {
//		int[][] edges = { { 3, 0 }, { 3, 1 }, { 3, 2 }, { 3, 4 }, { 5, 4 } };
		int[][] edges = { { 1, 0 }, { 1, 2 }, { 1, 3 } };
//		int[][] edges = { { 0, 1 }, { 0, 2 } };
		List<Integer> ans = findMinHeightTrees(4, edges);
		System.out.println(ans);
	}

	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
		// pre_checking_input
		if (n == 1)
			return new ArrayList<Integer>(Arrays.asList(0));
		else if (n == 2) {
			return new ArrayList<Integer>(Arrays.asList(0, 1));
		}

		// data storage
		Map<Integer, List<Integer>> outDegreeadjlist = new HashMap<>();
		Map<Integer, Integer> inDegreedjlist = new HashMap<>();
		ArrayDeque<Integer> q = new ArrayDeque<>();
		buildAdjList(n, edges, outDegreeadjlist, inDegreedjlist);

		// initialize q with nodes having in_degree as 1
		for (Map.Entry<Integer, Integer> entry : inDegreedjlist.entrySet()) {
			int key = entry.getKey();
			int val = entry.getValue();
			if (val == 1) {
				q.addLast(key);
				n--;
			}
		}

		return getMHTs_TopoSorting(inDegreedjlist, outDegreeadjlist, q, n);
	}

	private static List<Integer> getMHTs_TopoSorting(Map<Integer, Integer> inDegreedjlist,
			Map<Integer, List<Integer>> outDegreedjlist, ArrayDeque<Integer> q, int n) {
		for (int size = q.size(); n > 0 && size >= 2; size = q.size()) {
			while (size-- > 0) { // level by level like bfs
				int cur = q.pollFirst();
				for (Integer i : outDegreedjlist.get(cur)) {
					int oldVal = inDegreedjlist.get(i);
					inDegreedjlist.replace(i, --oldVal);
					if (inDegreedjlist.get(i) == 1) {
						q.addLast(i);
						n--;
					}
				}
			}
		}
		List<Integer> ans = new ArrayList<>();
		ans.addAll(q);
		return ans;
	}

	private static void buildAdjList(int n, int[][] edges, Map<Integer, List<Integer>> outDegreedjlist,
			Map<Integer, Integer> inDegreedjlist) {
		for (int i = 0; i < n; i++) {
			outDegreedjlist.put(i, new ArrayList<>());
			inDegreedjlist.put(i, 0);
		}
		for (int[] edge : edges) {
			addUndirecEdge_outDegree(outDegreedjlist, edge[0], edge[1]);
			addUndirecEdge_inDegree(inDegreedjlist, edge[0], edge[1]);
		}
	}

	private static void addUndirecEdge_inDegree(Map<Integer, Integer> inDegreedjlist, int i, int j) {
		int oldVal1 = inDegreedjlist.get(i);
		inDegreedjlist.replace(i, ++oldVal1);
		int oldVal2 = inDegreedjlist.get(j);
		inDegreedjlist.replace(j, ++oldVal2);
	}

	private static void addUndirecEdge_outDegree(Map<Integer, List<Integer>> outDegreedjlist, int i, int j) {
		outDegreedjlist.get(i).add(j);
		outDegreedjlist.get(j).add(i);
	}

}
