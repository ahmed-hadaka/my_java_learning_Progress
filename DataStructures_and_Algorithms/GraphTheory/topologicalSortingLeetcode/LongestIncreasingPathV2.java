package topologicalSortingLeetcode;

import java.util.ArrayDeque;

// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
public class LongestIncreasingPathV2 {
	public int longestIncreasingPathV2(int[][] matrix) {
		if (matrix == null || (matrix.length == 0 && matrix[0].length == 0))
			return 0;
		// data storage
		int[][] inDegree = new int[matrix.length][matrix[0].length];
		ArrayDeque<int[]> q = new ArrayDeque<>();
		int[] dirR = { -1, 1, 0, 0 }; // up, down, right, left
		int[] dirC = { 0, 0, 1, -1 };

		// initialize in_degree
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				for (int k = 0; k < 4; k++) {
					int r = i + dirR[k];
					int c = j + dirC[k];
					if (isWithinBoundaries(matrix, r, c) && matrix[r][c] > matrix[i][j]) {
						inDegree[r][c]++;
					}
				}
			}
		}
		// initialize q
		for (int i = 0; i < inDegree.length; i++) {
			for (int j = 0; j < inDegree[0].length; j++) {
				if (inDegree[i][j] == 0)
					q.addLast(new int[] { i, j });
			}
		}

		// process topological ordering
		int longestPath = 0, size = q.size();
		while (!q.isEmpty()) {
			while (size-- > 0) { // process level by level like bfs
				int[] cur = q.pollFirst();
				int i = cur[0];
				int j = cur[1];
				for (int k = 0; k < 4; k++) {
					int r = i + dirR[k];
					int c = j + dirC[k];
					if (isWithinBoundaries(matrix, r, c) && matrix[r][c] > matrix[i][j]) {
						if (--inDegree[r][c] == 0)
							q.addLast(new int[] { r, c });
					}
				}
			}
			longestPath++;
			size = q.size();
		}
		return longestPath;
	}

	private boolean isWithinBoundaries(int[][] grid, int r, int c) {
		if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length)
			return true;
		return false;
	}

}
