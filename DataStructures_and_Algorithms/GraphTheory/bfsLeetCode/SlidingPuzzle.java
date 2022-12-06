package bfsLeetCode;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/sliding-puzzle/
public class SlidingPuzzle {

	public int slidingPuzzle(int[][] board) {
		int[][] goal = { { 1, 2, 3 }, { 4, 5, 0 } };
		if (isEqual(board, goal))
			return 0;

		Set<int[][]> visited = new HashSet<>();
		ArrayDeque<int[][]> q = new ArrayDeque<>();

		visited.add(board);
		q.addLast(board);
		return BFS(q, visited, goal, board);
	}

	private int BFS(ArrayDeque<int[][]> q, Set<int[][]> visited, int[][] goal, int[][] board) {
		int[] dirI = { -1, 1, 0, 0 }; // up, down, right, left
		int[] dirJ = { 0, 0, 1, -1 };
		for (int level = 0, size = q.size(); !q.isEmpty(); level++, size = q.size()) {
			while (size-- > 0) {
				int[][] curBoard = q.pollFirst();
				int[] zeroInd = getZeroInd(curBoard);
				for (int i = 0; i < 4; i++) {
					int r = zeroInd[0] + dirI[i];
					int c = zeroInd[1] + dirJ[i];
					if (isValid(curBoard.length, curBoard[0].length, r, c)) {
						int[][] tempBoard = swap(curBoard, zeroInd, r, c); // return new board after swapping
						if (!isVisited(tempBoard, visited)) {
							if (isEqual(tempBoard, goal)) {
								return level + 1;
							}
							visited.add(tempBoard);
							q.addLast(tempBoard);
						}
					}
				}
			}
		}
		return -1;
	}

	private boolean isEqual(int[][] board, int[][] goal) { // o(1)
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				if (goal[i][j] != board[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean isVisited(int[][] tempBoard, Set<int[][]> visited) { // o(visited.size())
		for (int[][] board : visited) {
			if (isEqual(tempBoard, board))
				return true;
		}
		return false;
	}

	private int[][] swap(int[][] curBoard, int[] zeroInd, int r, int c) { // o(1)
		// deep copy
		int[][] res = new int[2][3];
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[0].length; j++) {
				res[i][j] = curBoard[i][j];
			}
		}

		int temp = res[zeroInd[0]][zeroInd[1]];
		res[zeroInd[0]][zeroInd[1]] = res[r][c];
		res[r][c] = temp;
		return res;
	}

	private int[] getZeroInd(int[][] curBoard) { // o(1)
		for (int i = 0; i < 2; i++) { // we guaranteed that there is always zero
			for (int j = 0; j < 3; j++) {
				if (curBoard[i][j] == 0)
					return new int[] { i, j };
			}
		}
		return null;
	}

	private boolean isValid(int rows, int cols, int r, int c) {
		if (r >= 0 && r < rows && c >= 0 && c < cols)
			return true;
		return false;
	}

}
