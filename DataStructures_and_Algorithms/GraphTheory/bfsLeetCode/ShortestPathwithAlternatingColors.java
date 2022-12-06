package bfsLeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/shortest-path-with-alternating-colors/  
public class ShortestPathwithAlternatingColors { // (NOT EASY)

	final int RED = 1;
	final int BLUE = 0;
	final int START = -1;

	class Edge {
		int to;
		int color;

		public Edge(int to, int color) {
			this.to = to;
			this.color = color;
		}
	}

	public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
		ArrayDeque<Edge> q = new ArrayDeque<>();
		int[] res = new int[n];
		List<List<Edge>> adjList = new ArrayList<>();
		boolean[][] len = new boolean[n][2]; ///////
		for (int i = 0; i < len.length; i++) {
			Arrays.fill(len[i], false);
		}
		Arrays.fill(res, -1);
		buildGraph(adjList, n, redEdges, blueEdges);
		// initial starting
		len[0][RED] = true;
		len[0][BLUE] = true;
		res[0] = 0;
		q.addLast(new Edge(0, RED));
		q.addLast(new Edge(0, BLUE));

		for (int level = 0, sz = q.size(); !q.isEmpty(); level++, sz = q.size()) {
			while (sz-- > 0) {
				Edge cur = q.pollFirst();
				int curV = cur.to, color = cur.color;
				for (Edge e : adjList.get(curV))
					if (color != e.color && len[e.to][e.color] == false) {
						q.addLast(e);
						len[e.to][e.color] = true; // ==> why not boolean!
						if (res[e.to] == -1) // to get shortest path
							res[e.to] = level + 1;
					}
			}
		}
		return res;
	}

	private void buildGraph(List<List<Edge>> adjList, int n, int[][] red, int[][] blue) {
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}
		for (int i = 0; i < red.length; i++) {
			addDirectedEdge(adjList, red[i][0], new Edge(red[i][1], RED));
		}
		for (int i = 0; i < blue.length; i++) {
			addDirectedEdge(adjList, blue[i][0], new Edge(blue[i][1], BLUE));
		}
	}

	private void addDirectedEdge(List<List<Edge>> adjList, int from, Edge to) {
		adjList.get(from).add(to);
	}

}
