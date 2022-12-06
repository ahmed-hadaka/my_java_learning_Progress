package topologicalSortingLeetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopologicalSorting {

	public static void main(String[] args) {
		System.out.println(run(10, new int[][] { { 9, 5 }, { 4, 7 }, { 7, 1 }, { 2, 5 }, { 5, 6 }, { 5, 3 } }));
	}

	public static List<Integer> run(int numCourses, int[][] prerequisites) {
		int[] inDegree = new int[numCourses];
		Map<Integer, List<Integer>> outDegreeAdjList = new HashMap<>();
		ArrayDeque<Integer> q = new ArrayDeque<>(); // for topological sort
		PriorityQueue<Integer> pq = new PriorityQueue<>();// for lexicographical sort

		buildInDegreeOutDegreeAdjLists(numCourses, prerequisites, inDegree, outDegreeAdjList);

		// initialize queue with nodes with in-degree equal zero
		for (int j = 0; j < inDegree.length; j++) {
			if (inDegree[j] == 0) {
				pq.add(j);
				q.addLast(j);
			}
		}
		// [0, 2, 4, 8, 9, 7, 5, 1, 6, 3]
//		return orderTopological(inDegree, outDegreeAdjList, q, numCourses);
		// [0, 2, 4, 8, 9, 5, 7, 1, 3, 6]
		return orderLexicographical(inDegree, outDegreeAdjList, pq, numCourses);
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

	private static List<Integer> orderLexicographical(int[] inDegree, Map<Integer, List<Integer>> outDegreeAdjList,
			PriorityQueue<Integer> pq, int numCourses) {
		List<Integer> ans = new ArrayList<>();
		for (int size = pq.size(); !pq.isEmpty(); size = pq.size()) {
			while (size-- > 0) {
				int cur = pq.poll();
				ans.add(cur);
				for (Integer neighbor : outDegreeAdjList.get(cur)) {
					inDegree[neighbor]--;
					if (inDegree[neighbor] == 0)
						pq.add(neighbor);
				}
			}
		}
		return ans;
	}

//	private static List<Integer> orderTopological(int[] inDegree, Map<Integer, List<Integer>> outDegreeAdjList,
//			ArrayDeque<Integer> q, int numCourses) {
//		List<Integer> ans = new ArrayList<>();
//		for (int size = q.size(); !q.isEmpty(); size = q.size()) {
//			while (size-- > 0) {
//				int cur = q.pollFirst();
//				ans.add(cur);
//				for (Integer neighbor : outDegreeAdjList.get(cur)) {
//					inDegree[neighbor]--;
//					if (inDegree[neighbor] == 0)
//						q.addLast(neighbor);
//				}
//			}
//		}
//		return ans;
//	}
}
