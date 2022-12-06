package dfsLeetcode;

// https://leetcode.com/problems/detect-cycles-in-2d-grid/
public class DetectCycles_in2DGrid {
	public static void main(String[] args) {
		char[][] grid = { { 'a', 'a', 'a', 'a' }, { 'a', 'b', 'b', 'a' }, { 'a', 'b', 'b', 'a' },
				{ 'a', 'a', 'a', 'a' } };
		System.out.println(containsCycle(grid));
	}

	static boolean isCycled;

	public static boolean containsCycle(char[][] grid) {
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int[] count = { 0 };
		int[] dirR = { -1, 1, 0, 0 }; // up, down, right, left
		int[] dirC = { 0, 0, 1, -1 };
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (!visited[i][j]) {
					isCycled = false;
					findConectedCompoDFS(grid, visited, i, j, dirR, dirC, count, grid[i][j], -1, -1);
					count[0] = 0;
					if (isCycled)
						return true;
				}
			}
		}
		return false;
	}

	private static void findConectedCompoDFS(char[][] grid, boolean[][] visited, int row, int col, int[] dirR,
			int[] dirC, int[] count, char oldChar, int parR, int parC) {

		visited[row][col] = true;
		count[0]++;

		for (int i = 0; i < 4; i++) {

			int tempR = row + dirR[i];
			int tempC = col + dirC[i];

			if (isValid(grid, tempR, tempC) && grid[tempR][tempC] == oldChar) {
				if (!visited[tempR][tempC])
					findConectedCompoDFS(grid, visited, tempR, tempC, dirR, dirC, count, oldChar, row, col);
				// if he return again to un_parent position => it's a cycle
				else if (count[0] >= 4 && (tempR != parR || tempC != parC)) {
					isCycled = true;
					return;
				}
			}
		}
	}

	private static boolean isValid(char[][] grid, int r, int c) {
		if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length)
			return true;
		return false;
	}

}
