package bfsLeetCode;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.ca/all/286.html
public class WallsAndGates {

	public static void main(String[] args) {
		int[][] rooms = { { Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE },
				{ Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1 },
				{ Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1 }, { 0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE } };

		wallsAndGates(rooms);

		for (int i = 0; i < rooms.length; i++) {
			for (int j : rooms[i]) {
				System.out.print(j + "   ");
			}
			System.out.println();
		}
	}

	static int[] dirR = { -1, 1, 0, 0 }; // up, down, right, left
	static int[] dirC = { 0, 0, 1, -1 };

	public static void wallsAndGates(int[][] rooms) { // o(nm)
		Queue<Pair> q = new LinkedList<>();
		boolean[][] visited = new boolean[rooms.length][rooms[0].length];
		for (int i = 0; i < rooms.length; i++) { // o(nm)
			for (int j = 0; j < rooms[0].length; j++) {
				if (rooms[i][j] == 0) {
					q.add(new Pair(i, j));
					visited[i][j] = true;
				}
			}
		}
		findNearestGateBFS(rooms, q, visited); // o(n + m)
	}

	private static void findNearestGateBFS(int[][] rooms, Queue<Pair> q, boolean[][] visited) {
		for (int level = 0, size = q.size(); !q.isEmpty(); level++, size = q.size()) {
			while (size-- > 0) {
				Pair cur = q.poll();
				int r = cur.first;
				int c = cur.second;
				for (int i = 0; i < 4; i++) {
					int tR = r + dirR[i];
					int tC = c + dirC[i];
					if (isValid(rooms, tR, tC) && !visited[tR][tC]) {
						rooms[tR][tC] = level + 1;
						q.add(new Pair(tR, tC));
						visited[tR][tC] = true;
					}
				}
			}
		}
	}

	private static class Pair {
		int first;
		int second;

		public Pair(int first, int secode) {
			this.first = first;
			this.second = secode;
		}
	}

	private static boolean isValid(int[][] grid, int r, int c) {
		if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] != -1)
			return true;
		return false;
	}
}
