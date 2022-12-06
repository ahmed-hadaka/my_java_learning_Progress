package topologicalSortingLeetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
public class LongestIncreasingPathV1 {

	public int longestIncreasingPath(int[][] matrix) {

		Map<Node, List<Node>> outDegree = new HashMap<>();
		int[][] inDegree = new int[matrix.length][matrix[0].length];
		ArrayDeque<Node> q = new ArrayDeque<>();

		buildAdjList(outDegree, inDegree, matrix);

		for (int i = 0; i < inDegree.length; i++) {
			for (int j = 0; j < inDegree[0].length; j++) {
				if (inDegree[i][j] == 0)
					q.addLast(new Node(i, j));
			}
		}
		return topoSorting(outDegree, inDegree, q);
	}

	private void buildAdjList(Map<Node, List<Node>> outDegree, int[][] inDegree, int[][] matrix) {
		int[] dirR = { -1, 1, 0, 0 }; // up, down, right, left
		int[] dirC = { 0, 0, 1, -1 };

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				for (int k = 0; k < 4; k++) {
					int r = i + dirR[k];
					int c = j + dirC[k];
					if (isWithinBoundaries(matrix, r, c) && matrix[r][c] > matrix[i][j]) {
						Node curNode = new Node(i, j);
						if (outDegree.containsKey(curNode)) {
							outDegree.get(curNode).add(new Node(r, c));
						} else {
							List<Node> list = new ArrayList<>();
							list.add(new Node(r, c));
							outDegree.put(curNode, list);
						}
						inDegree[r][c]++;
					}
				}
			}
		}

	}

	// Note: it's NOT recommended to use map with key-value from the same type(Node)
	// in case of you want to manipulating with data.
	// but here, you don't manipulating with data.
	private int topoSorting(Map<Node, List<Node>> outDegree, int[][] inDegree, ArrayDeque<Node> q) {
		int level = 0, size = q.size();
		while (!q.isEmpty()) {
			while (size-- > 0) { // level by level, like bfs
				Node cur = q.pollFirst();
				if (outDegree.containsKey(cur)) {
					for (Node node : outDegree.get(cur)) {
						if (--inDegree[node.r][node.c] == 0) {
							q.addLast(node);
						}
					}
				}
			}
			level++;
			size = q.size();
		}
		return level;
	}

	private boolean isWithinBoundaries(int[][] grid, int r, int c) {
		if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length)
			return true;
		return false;
	}

	private class Node {
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + Objects.hash(c, r);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			return c == other.c && r == other.r;
		}

		private LongestIncreasingPathV1 getEnclosingInstance() {
			return LongestIncreasingPathV1.this;
		}

	}

}
