package topologicalSortingLeetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.ca/all/1136.html (hard)
public class ParallelCourses {
	public static void main(String[] args) {
		System.out.println(parallelCourses(3, new int[][] { { 1, 2 }, { 2, 3 }, { 3, 1 } }));
	}

	public static int parallelCourses(int n, int[][] prerequisites) {
		// convert values from 1 base to 0 base
		for (int i = 0; i < prerequisites.length; i++) {
			for (int j = 0; j < prerequisites[0].length; j++) {
				prerequisites[i][j] = prerequisites[i][j] - 1;
			}
		}

		int[] inDegree = new int[n];
		Map<Integer, List<Integer>> outDegreeAdjList = new HashMap<>();
		ArrayDeque<Integer> q = new ArrayDeque<>(); // for topological sort

		buildInDegreeOutDegreeAdjLists(n, prerequisites, inDegree, outDegreeAdjList);

		// initialize queue with nodes with in-degree equal zero
		for (int j = 0; j < inDegree.length; j++) {
			if (inDegree[j] == 0) {
				q.addLast(j);
			}
		}
		return topologicalSort(inDegree, outDegreeAdjList, q, n);
	}

	private static void buildInDegreeOutDegreeAdjLists(int numCourses, int[][] prerequisites, int[] inDegree,
			Map<Integer, List<Integer>> outDegreeAdjList) {
		// initialize adjList
		for (int i = 0; i < numCourses; i++) {
			outDegreeAdjList.put(i, new ArrayList<>());
		}

		// build
		for (int i = 0; i < prerequisites.length; i++) {
			inDegree[prerequisites[i][1]]++;
			outDegreeAdjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
		}
	}

	private static int topologicalSort(int[] inDegree, Map<Integer, List<Integer>> outDegreeAdjList,
			ArrayDeque<Integer> q, int numCourses) {
		int count = 0;
		int level = 0;
		for (int size = q.size(); !q.isEmpty(); level++, size = q.size()) {
			while (size-- > 0) { // process level by level like bfs
				int cur = q.pollFirst();
				count++;
				for (Integer neighbor : outDegreeAdjList.get(cur)) {
					inDegree[neighbor]--;
					if (inDegree[neighbor] == 0)
						q.addLast(neighbor);
				}
			}
		}

		return count == numCourses ? level : -1;
	}
}
