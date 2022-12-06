package dfsLeetcode;

// https://leetcode.com/problems/flood-fill/

public class FloodFill {

	public int[][] floodFill(int[][] image, int sr, int sc, int color) {
		boolean[][] visited = new boolean[image.length][image[0].length]; // initial false
		int[] dirR = { -1, 1, 0, 0 }; // up, down, right, left
		int[] dirC = { 0, 0, 1, -1 };
		findReachable(image, sr, sc, dirR, dirC, visited, image[sr][sc], color);
		return image;
	}

	private void findReachable(int[][] image, int sr, int sc, int[] dirR, int[] dirC, boolean[][] visited, int oldColor,
			int newColor) { // o(n + path.length)
		visited[sr][sc] = true;
		image[sr][sc] = newColor;
		for (int i = 0; i < 4; i++) {
			int tempR = sr + dirR[i];
			int tempC = sc + dirC[i];
			if (isValid(image, tempR, tempC) && !visited[tempR][tempC] && image[tempR][tempC] == oldColor) {
				findReachable(image, tempR, tempC, dirR, dirC, visited, oldColor, newColor);
			}
		}
	}

	private boolean isValid(int[][] image, int r, int c) {
		if (r >= 0 && r < image.length && c >= 0 && c < image[0].length)
			return true;
		return false;
	}
}
