package dfsLeetcode;

import java.util.Arrays;

// https://leetcode.com/problems/is-graph-bipartite/submissions/
public class GraphBipartite {

	boolean isBipartite = true;

	public boolean isBipartite(int[][] graph) {
		int[] color = new int[graph.length];
		Arrays.fill(color, -1);
		for (int i = 0; i < graph.length; i++) {
			if (color[i] == -1) {
				DFS(graph, color, i, 1);
				if (!isBipartite)
					return false;
			}
		}
		return true;
	}

	private void DFS(int[][] graph, int[] color, int node, int neWcolor) {
		if (color[node] == -1) {
			color[node] = neWcolor;
			for (int nei : graph[node]) {
				DFS(graph, color, nei, 1 - neWcolor);
			}
		} else if (color[node] != neWcolor) {
			isBipartite = false;
			return;
		}
	}

}
