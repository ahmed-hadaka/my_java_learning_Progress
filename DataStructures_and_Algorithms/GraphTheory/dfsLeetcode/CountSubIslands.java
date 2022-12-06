package dfsLeetcode;

// https://leetcode.com/problems/count-sub-islands/
public class CountSubIslands {
	boolean isSubIsland = true;

	public int countSubIslands(int[][] grid1, int[][] grid2) {
		boolean[][] visited = new boolean[grid1.length][grid1[0].length];
		int[] dirR = { -1, 1, 0, 0 }; // up, down, right, left
		int[] dirC = { 0, 0, 1, -1 };
		int count = 0;
		for (int i = 0; i < grid2.length; i++) {
			for (int j = 0; j < grid2[0].length; j++) {
				if (grid2[i][j] == 1 && grid1[i][j] == 1 && !visited[i][j]) {
					findReachableDFS(grid2, grid1, dirR, dirC, i, j, visited);
					if (isSubIsland)
						count++;
				}
			}
		}
		return count;
	}

	private void findReachableDFS(int[][] grid2, int[][] grid1, int[] dirR, int[] dirC, int i, int j,
			boolean[][] visited) {
		visited[i][j] = true;
		for (int k = 0; k < 4; k++) {
			int tempR = i + dirR[k];
			int tempC = j + dirC[k];
			if (isValid(grid2, tempR, tempC) && grid2[tempR][tempC] == 1 && !visited[tempR][tempC]) {
				if (grid1[tempR][tempC] != 1)
					isSubIsland = false;
				findReachableDFS(grid2, grid1, dirR, dirC, tempR, tempC, visited);
			}
		}
	}

	private boolean isValid(int[][] grid2, int r, int c) {
		if (r >= 0 && r < grid2.length && c >= 0 && c < grid2[0].length)
			return true;
		return false;
	}
}
