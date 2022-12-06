package bfsLeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSAlgorithm {

	public static void main(String[] args) {
		int numNodes = 9;
		int[][] cc = { { 1, 3 }, { 1, 5 }, { 1, 6 }, { 3, 5 }, { 4, 3 }, { 3, 7 }, { 5, 4 }, { 6, 0 }, { 2, 4 },
				{ 2, 8 }, { 0, 2 }, { 2, 8 }, { 2, 2 } };
		printPathesFromZeroBFS(cc, numNodes);
	}

	public static int[] BFS(int[][] cc, int start, int numNodes) { // O(V + E) Time, O(v) Space
		// shortestPath[i] == shortest path from the start to i
		List<List<Integer>> adjList = new ArrayList<>();
		buildGraph(cc, adjList, numNodes);

		int[] shortestPath = new int[adjList.size()];
		Arrays.fill(shortestPath, 00);
		Queue<Integer> queue = new LinkedList<>();
		shortestPath[start] = 0;
		queue.add(start);
		for (int level = 0, size = queue.size(); !queue.isEmpty(); level++, size = queue.size()) {
			// we will process each level by it self
			while (size-- > 0) {
				int temp = queue.poll();
				for (int neighbours : adjList.get(temp)) {
					if (shortestPath[neighbours] == 00) { // not visited
						queue.add(neighbours);
						shortestPath[neighbours] = level + 1;
					}
				}
			}
		}
		return shortestPath;
	}

	public static void printPathesFromZeroBFS(int[][] cc, int numNodes) { // O(V + E) Time, O(v) Space
		List<List<Integer>> adjList = new ArrayList<>();
		buildGraph(cc, adjList, numNodes);
		boolean[] visited = new boolean[adjList.size()];
		int[] parArr = new int[adjList.size()];
		Arrays.fill(parArr, -1);
		Queue<Integer> queue = new LinkedList<>();
		visited[0] = true;
		queue.add(0);
		for (int size = 1; !queue.isEmpty(); size = queue.size()) {
			// we will process each level by it self
			while (size-- > 0) {
				int cur = queue.poll();
				for (int neighbours : adjList.get(cur)) {
					if (!visited[neighbours]) {
						queue.add(neighbours);
						visited[neighbours] = true;
						parArr[neighbours] = cur;
					}
				}
			}
		}
		for (int i = 1; i < parArr.length; i++) {
			System.out.print("From 0 to " + i + ": ");
			helperMethod(parArr, i);
			System.out.println();
		}
	}

	private static void helperMethod(int[] parArr, int start) {
		if (parArr[start] == -1) {
			if (start == 0)
				System.out.print(start + " ");
			else
				System.out.print("not exist ");
		} else {
			helperMethod(parArr, parArr[start]);
			System.out.print(start + " ");
		}
	}

	private static void buildGraph(int[][] cc, List<List<Integer>> adjList, int numNodes) {
		for (int i = 0; i < numNodes; i++) {
			adjList.add(new ArrayList<>());
		}
		for (int i = 0; i < cc.length; i++) {
			adjList.get(cc[i][0]).add(cc[i][1]);
		}
	}
}
