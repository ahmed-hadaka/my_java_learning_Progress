package bfsLeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/pacific-atlantic-water-flow/submissions/
public class PacificAtlanticWaterFlow {
// [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
	public static void main(String[] args) {
//		int[][] height = { { 1 } };
		int[][] height = { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 },
				{ 5, 1, 1, 2, 4 } };
		List<List<Integer>> l = pacificAtlantic(height);
		for (List<Integer> list : l) {
			System.out.println(list);
		}
	}

	static int[] dirR = { -1, 1, 0, 0 }; // up, down, right, left
	static int[] dirC = { 0, 0, 1, -1 };

	public static List<List<Integer>> pacificAtlantic(int[][] heights) {
		// initialize
		List<List<Integer>> res = new ArrayList<>();
		Queue<IntPair> qPacific = new LinkedList<>();
		Queue<IntPair> qAtlantic = new LinkedList<>();
		boolean[][] visitedPacific = new boolean[heights.length][heights[0].length];
		boolean[][] visitedAtlantic = new boolean[heights.length][heights[0].length];

		setup(visitedPacific, visitedAtlantic, heights, qPacific, qAtlantic);

		markCellsBFS(heights, visitedPacific, qPacific); // mark reachable cells to pacificOcean
		markCellsBFS(heights, visitedAtlantic, qAtlantic); // mark reachable cells to AtlanticOcean

		for (int i = 0; i < heights.length; i++) {
			for (int j = 0; j < heights[0].length; j++) {
				if (visitedAtlantic[i][j] && visitedPacific[i][j])
					res.add(new ArrayList<>(Arrays.asList(i, j)));
			}
		}
		return res;
	}

	private static void setup(boolean[][] visitedPacific, boolean[][] visitedAtlantic, int[][] heights,
			Queue<IntPair> qPacific, Queue<IntPair> qAtlantic) {
		int cols = heights.length;
		for (int i = 0; i < heights.length; i++) {// mark columns
			qPacific.add(new IntPair(i, 0));
			visitedPacific[i][0] = true;

			qAtlantic.add(new IntPair(i, cols - 1));
			visitedAtlantic[i][cols - 1] = true;
		}
		int rows = heights[0].length;
		for (int i = 0; i < heights[0].length; i++) {
			qPacific.add(new IntPair(0, i));
			visitedPacific[0][i] = true;

			qAtlantic.add(new IntPair(rows - 1, i));
			visitedAtlantic[rows - 1][i] = true;
		}
	}

	private static void markCellsBFS(int[][] heights, boolean[][] visited, Queue<IntPair> q) {
		for (int size = q.size(); !q.isEmpty(); size = q.size()) {
			while (size-- > 0) {
				IntPair cur = q.poll();
				int r = cur.first;
				int c = cur.second;
				for (int i = 0; i < 4; i++) {
					int tR = r + dirR[i];
					int tC = c + dirC[i];
					if (isValid(heights, tR, tC) && !visited[tR][tC] && heights[tR][tC] >= heights[r][c]) {
						q.add(new IntPair(tR, tC));
						visited[tR][tC] = true;
					}
				}
			}
		}

	}

	private static class IntPair {
		int first;
		int second;

		public IntPair(int first, int secode) {
			this.first = first;
			this.second = secode;
		}
	}

	private static boolean isValid(int[][] grid, int r, int c) {
		if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length)
			return true;
		return false;
	}
}
