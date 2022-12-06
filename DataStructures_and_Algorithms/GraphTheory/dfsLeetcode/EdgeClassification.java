package dfsLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EdgeClassification {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		List<List<Integer>> adjList = new ArrayList<>();
		adjList.add(new ArrayList<>(Arrays.asList(1, 6))); // 0
		adjList.add(new ArrayList<>(Arrays.asList(2, 6))); // 1
		adjList.add(new ArrayList<>(Arrays.asList(0, 3))); // 2
		adjList.add(new ArrayList<>(Arrays.asList(1, 6))); // 3
		adjList.add(new ArrayList<>(Arrays.asList(2, 3, 5))); // 4
		adjList.add(new ArrayList<>()); // 5
		adjList.add(new ArrayList<>()); // 6
		printEdgeClass(adjList);
	}

	static int lastTime = 1;

	public static void printEdgeClass(List<List<Integer>> adjList) {
		int[] start = new int[adjList.size()]; // also use it to determine visited nodes
		int[] finished = new int[adjList.size()];
		for (int i = 0; i < adjList.size(); i++) {
			if (start[i] == 0) {
				DFS(adjList, i, start, finished, -1);
			}
		}
	}

	private static void DFS(List<List<Integer>> adjList, int node, int[] start, int[] finished, int parent) {
		if (start[node] == 0) { // not visited
			start[node] = lastTime++;
			if (parent != -1) {
				System.out.println(parent + " ==> " + node + " Tree Edge");
			}
			for (Integer i : adjList.get(node)) {
				DFS(adjList, i, start, finished, node);
			}
		} else {
			if (finished[node] == 0) {
				System.out.println(parent + " ==> " + node + " Back Edge");
			} else if (start[node] < start[parent]) {
				System.out.println(parent + " ==> " + node + " Cross Edge");
			} else
				System.out.println(parent + " ==> " + node + " Forward Edge");
		}
		finished[node] = lastTime++;
	}

}
