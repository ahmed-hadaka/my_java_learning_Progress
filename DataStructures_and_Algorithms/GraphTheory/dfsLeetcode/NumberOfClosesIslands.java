package dfsLeetcode;

// https://leetcode.com/problems/number-of-closed-islands/
public class NumberOfClosesIslands {

	public static void main(String[] args) {
		int[][] grid = { { 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 }, { 0, 0, 1, 0, 0, 1, 0, 1, 1, 1 },
				{ 1, 0, 1, 0, 0, 0, 1, 0, 1, 0 }, { 1, 1, 1, 1, 1, 0, 0, 1, 0, 0 }, { 1, 0, 1, 0, 1, 1, 1, 1, 1, 0 },
				{ 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 }, { 1, 0, 1, 0, 0, 0, 0, 1, 1, 0 }, { 1, 1, 0, 0, 1, 1, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 1, 0, 1, 1, 1, 0 }, { 1, 1, 0, 1, 0, 1, 0, 0, 1, 0 } };
		System.out.println(closedIsland(grid));
	}

	static boolean isCloseIsland;

	public static int closedIsland(int[][] grid) {
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int count = 0;
		int[] dirR = { -1, 1, 0, 0 }; // up, down, right, left
		int[] dirC = { 0, 0, 1, -1 };
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0 && !visited[i][j]) {
					isCloseIsland = true;
					findConectedCompoDFS(grid, visited, i, j, dirR, dirC);
					if (isCloseIsland)
						count++;
				}
			}
		}
		return count;
	}

	private static void findConectedCompoDFS(int[][] grid, boolean[][] visited, int row, int col, int[] dirR,
			int[] dirC) {
		visited[row][col] = true;
		for (int i = 0; i < 4; i++) {
			int tempR = row + dirR[i];
			int tempC = col + dirC[i];
			boolean isValid = isValid(grid, tempR, tempC);
			if (isValid && !visited[tempR][tempC] && grid[tempR][tempC] == 0) {
				findConectedCompoDFS(grid, visited, tempR, tempC, dirR, dirC);
			} else if (!isValid) {
				isCloseIsland = false;
			}
		}
	}

	private static boolean isValid(int[][] grid, int r, int c) {
		if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length)
			return true;
		return false;
	}
}
