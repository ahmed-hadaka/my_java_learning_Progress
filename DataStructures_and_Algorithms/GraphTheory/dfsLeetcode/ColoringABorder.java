package dfsLeetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/coloring-a-border/

public class ColoringABorder {

	public int[][] colorBorder(int[][] grid, int row, int col, int color) {
		List<Pair> conectedComponent = new ArrayList<>();
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int[] dirR = { -1, 1, 0, 0 }; // up, down, right, left
		int[] dirC = { 0, 0, 1, -1 };

		findConectedCompoDFS(grid, row, col, dirR, dirC, visited, conectedComponent, grid[row][col], color);
		removeUnBorderdCell(grid, conectedComponent, dirR, dirC, grid[row][col]);

		for (int i = 0; i < conectedComponent.size(); i++) { // update border color
			Pair pair = conectedComponent.get(i);
			int r = pair.first;
			int c = pair.second;
			grid[r][c] = color;
		}

		return grid;
	}

	private void removeUnBorderdCell(int[][] grid, List<Pair> conectedComponent, int[] dirR, int[] dirC, int oldColor) {
		for (int i = 0; i < conectedComponent.size(); i++) { // remove un_border cell from connected components
			Pair pair = conectedComponent.get(i);
			int r = pair.first;
			int c = pair.second;
			boolean isBorder = false;
			for (int j = 0; j < 4; j++) {
				int tempR = r + dirR[j];
				int tempC = c + dirC[j];
				if (isValid(grid, tempR, tempC) && grid[tempR][tempC] == oldColor) {

				} else {
					isBorder = true;
					break;
				}
			}
			if (!isBorder) {
				conectedComponent.remove(pair);
				i--;
			}
		}
	}

	// o(N + M)Time
	private void findConectedCompoDFS(int[][] grid, int row, int col, int[] dirR, int[] dirC, boolean[][] visited,
			List<Pair> conectedComponent, int oldColor, int newColor) {
		visited[row][col] = true;
		conectedComponent.add(new Pair(row, col));//
		for (int i = 0; i < 4; i++) {
			int tempR = row + dirR[i];
			int tempC = col + dirC[i];
			if (isValid(grid, tempR, tempC) && !visited[tempR][tempC] && grid[tempR][tempC] == oldColor) {
				findConectedCompoDFS(grid, tempR, tempC, dirR, dirC, visited, conectedComponent, oldColor, newColor);
			}
		}
	}

	private boolean isValid(int[][] grid, int r, int c) {
		if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length)
			return true;
		return false;
	}

	private class Pair {
		int first;
		int second;

		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
}
