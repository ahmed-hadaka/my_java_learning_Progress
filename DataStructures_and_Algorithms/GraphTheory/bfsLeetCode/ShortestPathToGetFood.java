package bfsLeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.ca/all/1730.html
public class ShortestPathToGetFood {

	public static void main(String[] args) {
		char[][] grid = { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, { 'X', '*', 'O', 'X', 'O', '#', 'O', 'X' },
				{ 'X', 'O', 'O', 'X', 'O', 'O', 'X', 'X' }, { 'X', 'O', 'O', 'O', 'O', '#', 'O', 'X' },
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };
		System.out.println(getFood(grid));
	}

	public static int getFood(char[][] grid) {
		int i = 0, j = 0;
		boolean flag = false;

		for (; i < grid.length; i++) {
			for (j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '*') {
					flag = true;
					break;
				}
			}
			if (flag)
				break;
		}

		return BFS(grid, i, j);
	}

	public static int BFS(char[][] grid, int rs, int cs) { // O(V + E) Time, O(v) Space
		int[] dirR = { -1, 1, 0, 0 }; // up, down, right, left
		int[] dirC = { 0, 0, 1, -1 };
		// shortestPath[i] == shortest path from the start to i
		int[][] shortestPath = new int[grid.length][grid[0].length];
		for (int i = 0; i < shortestPath.length; i++) {
			Arrays.fill(shortestPath[i], -1);
		}
		Queue<Pair> queue = new LinkedList<>();
		shortestPath[rs][cs] = 0;
		queue.add(new Pair(rs, cs));
		for (int level = 0, size = 1; !queue.isEmpty(); level++, size = queue.size()) {
			// we will process each level by it self
			while (size-- > 0) {
				Pair cur = queue.poll();
				for (int k = 0; k < 4; k++) {
					int tempR = cur.r + dirR[k];
					int tempC = cur.c + dirC[k];
					if (isValid(grid, tempR, tempC) && shortestPath[tempR][tempC] == -1) { // not visited
						queue.add(new Pair(tempR, tempC));
						shortestPath[tempR][tempC] = level + 1;
						if (grid[tempR][tempC] == '#') { // a pie
							return level + 1;
						}
					}
				}
			}
		}
		return -1;
	}

	private static class Pair {
		int r, c;

		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	private static boolean isValid(char[][] grid, int r, int c) {
		if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] != 'X')
			return true;
		return false;
	}
}
