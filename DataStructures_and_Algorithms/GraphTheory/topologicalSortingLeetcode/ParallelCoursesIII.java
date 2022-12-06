package topologicalSortingLeetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/parallel-courses-iii/

public class ParallelCoursesIII {

	public int minimumTime(int n, int[][] relations, int[] time) {

		int[] inDegree = new int[n + 1];
		Map<Integer, List<Integer>> outDegreeAdjList = new HashMap<>();
		ArrayDeque<Integer> q = new ArrayDeque<>(); // for topological sort
		int[] completionTime = new int[n + 1];

		buildInDegreeOutDegreeAdjLists(n, relations, inDegree, outDegreeAdjList);

		// initialize queue with nodes with in-degree equal zero
		for (int j = 1; j < inDegree.length; j++) {
			if (inDegree[j] == 0) {
				q.addLast(j);
			}
		}
		return topologicalSort(inDegree, outDegreeAdjList, q, n, time, completionTime);
	}

	private void buildInDegreeOutDegreeAdjLists(int numCourses, int[][] relations, int[] inDegree,
			Map<Integer, List<Integer>> outDegreeAdjList) {
		// initialize adjList
		for (int i = 1; i <= numCourses; i++) {
			outDegreeAdjList.put(i, new ArrayList<>());
		}

		// build
		for (int i = 0; i < relations.length; i++) {
			inDegree[relations[i][1]]++;
			outDegreeAdjList.get(relations[i][0]).add(relations[i][1]);
		}
	}

	private int topologicalSort(int[] inDegree, Map<Integer, List<Integer>> outDegreeAdjList, ArrayDeque<Integer> q,
			int numCourses, int[] time, int[] completionTime) {

		while (!q.isEmpty()) {
			int cur = q.pollFirst();
			completionTime[cur] += time[cur - 1];
			for (Integer neighbor : outDegreeAdjList.get(cur)) {
				completionTime[neighbor] = Math.max(completionTime[neighbor], completionTime[cur]);
				if (--inDegree[neighbor] == 0)
					q.addLast(neighbor);
			}
		}

		return max(completionTime);
	}

	private int max(int[] time) {
		int max = 0;
		for (int i : time) {
			if (i > max)
				max = i;
		}
		return max;
	}
}
