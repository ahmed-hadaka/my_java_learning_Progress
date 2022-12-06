package bfsLeetCode;

import java.util.ArrayDeque;

// https://leetcode.com/problems/shortest-bridge/
public class ShortestBridge {

	public int shortestBridge(int[][] grid) {
		ArrayDeque<Pair> qDriver = new ArrayDeque<>();

		// to color the two islands with different colors (cell = 2 as orange,
		// boundaries with 3 as heavy orange, cell = 1 as blue) and fill qDriver with
		// the boundaries of the first cell to act as
		// multi-src in the last call.
		colorIslandsBFS(grid, qDriver);
		return findShortestBridgeBFS(grid, qDriver);
	}

	int[] dirR = { -1, 1, 0, 0 }; // up, down, right, left
	int[] dirC = { 0, 0, 1, -1 };

	private void colorIslandsBFS(int[][] grid, ArrayDeque<Pair> qDriver) {
		ArrayDeque<Pair> q = new ArrayDeque<>();
		boolean flag = false;
		// find entry point for the first island
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					flag = true;
					q.addLast(new Pair(i, j));
					grid[i][j] = 2; // orange
					break;
				}
			}
			if (flag)
				break;
		}

		for (int size = q.size(); !q.isEmpty(); size = q.size()) {
			while (size-- > 0) {
				Pair pair = q.pollFirst();
				int f = pair.first;
				int s = pair.second;
				for (int i = 0; i < 4; i++) {
					int r = f + dirR[i];
					int c = s + dirC[i];
					if (isValid(grid, r, c)) {
						if (grid[r][c] == 1) {
							q.addLast(new Pair(r, c));
							grid[r][c] = 2; // orange
						} else if (grid[r][c] == 0 && grid[f][s] == 2) {
							qDriver.addLast(new Pair(f, s)); // add boundries only
							grid[f][s] = 3; // boundaries with heavy orange
						}
					}
				}
			}
		}
	}

	private int findShortestBridgeBFS(int[][] grid, ArrayDeque<Pair> qDriver) {
		boolean[][] visited = new boolean[grid.length][grid[0].length];

		for (int level = 0, size = qDriver.size(); !qDriver.isEmpty(); level++, size = qDriver.size()) {
			while (size-- > 0) {
				Pair pair = qDriver.pollFirst();
				int f = pair.first;
				int s = pair.second;
				for (int i = 0; i < 4; i++) {
					int r = f + dirR[i];
					int c = s + dirC[i];
					if (isValid(grid, r, c)) {
						if (grid[r][c] == 1)
							return level;
						if (grid[r][c] == 0 && !visited[r][c]) {
							qDriver.addLast(new Pair(r, c));
							visited[r][c] = true;
						}
					}
				}
			}
		}
		return -1; // just for completeness
	}

	private class Pair {
		int first;
		int second;

		public Pair(int first, int secode) {
			this.first = first;
			this.second = secode;
		}
	}

	private boolean isValid(int[][] grid, int r, int c) {
		if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length)
			return true;
		return false;
	}
}
