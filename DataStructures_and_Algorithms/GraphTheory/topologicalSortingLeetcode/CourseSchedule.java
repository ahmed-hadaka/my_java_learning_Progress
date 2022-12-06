package topologicalSortingLeetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/course-schedule/
public class CourseSchedule {
	public static void main(String[] args) {

		System.out.println(canFinish(10, new int[][] { { 5, 9 }, { 7, 4 }, { 1, 7 }, { 5, 2 }, { 6, 5 }, { 3, 5 } }));
	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] inDegree = new int[numCourses];
		Map<Integer, List<Integer>> outDegreeAdjList = new HashMap<>();
		ArrayDeque<Integer> q = new ArrayDeque<>();

		buildInDegreeOutDegreeAdjLists(numCourses, prerequisites, inDegree, outDegreeAdjList);

		// initialize queue with nodes with in-degree equal zero
		for (int j = 0; j < inDegree.length; j++) {
			if (inDegree[j] == 0)
				q.addLast(j);
		}

		return canFinishKahnAlgo(inDegree, outDegreeAdjList, q, numCourses); // topological sorting
	}

	private static void buildInDegreeOutDegreeAdjLists(int numCourses, int[][] prerequisites, int[] inDegree,
			Map<Integer, List<Integer>> outDegreeAdjList) {
		// initialize adjList
		for (int i = 0; i < numCourses; i++) {
			outDegreeAdjList.put(i, new ArrayList<>());
		}

		// build
		for (int i = 0; i < prerequisites.length; i++) {
			inDegree[prerequisites[i][0]]++;
			outDegreeAdjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
		}
	}

	private static boolean canFinishKahnAlgo(int[] inDegree, Map<Integer, List<Integer>> outDegreeAdjList,
			ArrayDeque<Integer> q, int numCourses) {
		int count = 0;
		for (int size = q.size(); !q.isEmpty(); size = q.size()) {
			while (size-- > 0) {
				int cur = q.pollFirst();
				count++;
				for (Integer neighbor : outDegreeAdjList.get(cur)) {
					inDegree[neighbor]--;
					if (inDegree[neighbor] == 0)
						q.addLast(neighbor);
				}
			}
		}
		if (count != numCourses)
			return false;
		return true;
	}

}
