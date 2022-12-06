package dfsLeetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/kill-process/

public class KillProcess {
	public static void main(String[] args) {
		Map<Integer, List<Integer>> adjList = new HashMap<>();
		List<Integer> pid = List.of(2, 0, 1, 6, 3, 4);
		List<Integer> ppid = List.of(5, 5, 5, 2, 2, 1);
		System.out.println(killProcess(adjList, pid, ppid, 5));
		System.out.println(killProcess(adjList, pid, ppid, 2));
		System.out.println(killProcess(adjList, pid, ppid, 4));
	}

	public static void addEdge(Map<Integer, List<Integer>> adjList, int from, int to) {
		if (adjList.containsKey(from)) {
			adjList.get(from).add(to);
		} else {
			List<Integer> list = new ArrayList<>();
			list.add(to);
			adjList.put(from, list);
		}
	}

	public static List<Integer> killProcess(Map<Integer, List<Integer>> adjList, List<Integer> pid, List<Integer> ppid,
			int kill) { // o(maxVal) Space | o(N + M) Time, n = nodes, m = edges

		for (int i = 0; i < pid.size(); i++) { // construct the graph
			addEdge(adjList, ppid.get(i), pid.get(i));
		}

		int maxVal = Collections.max(pid);
		List<Boolean> visited = new ArrayList<>(Collections.nCopies(maxVal + 1, false));
		List<Integer> res = new ArrayList<>();
		res.add(kill);
		DFS(adjList, kill, visited, res);
		adjList.clear();
		return res;
	}

	// o(N + M) Space, o(N + M) Time, n = nodes, m = edges
	public static void DFS(Map<Integer, List<Integer>> adjList, int target, List<Boolean> visited, List<Integer> res) {
		if (adjList.containsKey(target)) {
			List<Integer> list = adjList.get(target);
			visited.set(target, true);
			for (int i = 0; i < list.size(); i++) {
				if (!visited.get(list.get(i))) {
					res.add(list.get(i));
					DFS(adjList, list.get(i), visited, res);
				}
			}
		}
	}
}
