package dfsLeetcode;

// https://leetcode.com/problems/path-with-minimum-effort/

// we will solve this problem with two techniques: binarySearch on the minimum valid effort and DFS (floodFill).
public class Path_With_Minimum_Effort {

	public int minimumEffortPath(int[][] heights) {
		int st = 0, end = (int) 1e6, mid, minEffort = heights[0][0];
		while (st <= end) {
			mid = st + (end - st) / 2;
			if (validLimit(heights, mid)) {
				minEffort = mid;
				end = mid - 1;
			} else {
				st = mid + 1;
			}
		}
		return minEffort;
	}

	private boolean validLimit(int[][] heights, int limit) {
		boolean[][] visited = new boolean[heights.length][heights[0].length]; // initial false
		int[] dirR = { -1, 1, 0, 0 }; // up, down, right, left
		int[] dirC = { 0, 0, 1, -1 };
		return findReachableDFS(heights, 0, 0, limit, dirR, dirC, visited);
	}

	private boolean findReachableDFS(int[][] heights, int sr, int sc, int limit, int[] dirR, int[] dirC,
			boolean[][] visited) {
		visited[sr][sc] = true;
		if (sr == heights.length - 1 && sc == heights[0].length - 1)
			return true;
		for (int i = 0; i < 4; i++) {
			int tempR = sr + dirR[i];
			int tempC = sc + dirC[i];
			if (isValid(heights, tempR, tempC) && !visited[tempR][tempC]
					&& Math.abs(heights[tempR][tempC] - heights[sr][sc]) <= limit) {
				if (findReachableDFS(heights, tempR, tempC, limit, dirR, dirC, visited))
					return true;
			}
		}
		return false;
	}

	private boolean isValid(int[][] heights, int r, int c) {
		if (r >= 0 && r < heights.length && c >= 0 && c < heights[0].length)
			return true;
		return false;
	}

}
