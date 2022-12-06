package bfsLeetCode;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/jump-game-iii/
public class JumpGameIII {

	public static void main(String[] args) {
		int[] grid = { 4, 2, 3, 0, 3, 1, 2 };
		System.out.println(canReach(grid, 5));
	}

	public static boolean canReach(int[] arr, int start) {
		if (arr[start] == 0)
			return true;
		boolean[] visited = new boolean[arr.length];
		return BFS(visited, arr, start);
	}

	private static boolean process(int[] arr, boolean[] visited, Queue<Integer> qu, int index) {
		if (index < arr.length && index >= 0) {
			if (!visited[index]) {
				if (arr[index] == 0)
					return true;
				qu.add(index);
				visited[index] = true;
			}
		}
		return false;
	}

	public static boolean BFS(boolean[] visited, int[] arr, int st) { // O(V + E) Time, O(v) Space
		Queue<Integer> queue = new LinkedList<>();
		queue.add(st);
		visited[st] = true;
		for (int size = 1; !queue.isEmpty(); size = queue.size()) {
			// we will process each level by it self
			while (size-- > 0) {
				int cur = queue.poll();
				if (process(arr, visited, queue, cur + arr[cur]) || process(arr, visited, queue, cur - arr[cur])) {
					return true;
				}
			}
		}
		return false;
	}

}
