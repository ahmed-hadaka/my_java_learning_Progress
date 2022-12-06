package bfsLeetCode;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/minimum-operations-to-convert-number/submissions/
public class Minimum_Operations_to_Convert_Number {

	public int minimumOperations(int[] nums, int start, int goal) {
		boolean[] visited = new boolean[nums.length];
		return BFS(visited, nums, start, goal);
	}

	private boolean process(int[] arr, boolean[] visited, Queue<Integer> qu, int x, int goal) {
		if (x == goal)
			return true;
		if (0 <= x && x <= 1000 && !visited[x]) {
			visited[x] = true;
			qu.add(x);
		}
		return false;
	}

	public int BFS(boolean[] visited, int[] arr, int st, int goal) { // O(V + E) Time, O(v) Space
		Queue<Integer> queue = new LinkedList<>();
		queue.add(st);
		visited[st] = true;
		for (int level = 0, size = 1; !queue.isEmpty(); size = queue.size(), level++) {
			// we will process each level by it self
			while (size-- > 0) {
				int cur = queue.poll();
				for (int i = 0; i < arr.length; i++) {
					if (process(arr, visited, queue, cur + arr[i], goal)
							|| process(arr, visited, queue, cur - arr[i], goal)
							|| process(arr, visited, queue, cur ^ arr[i], goal)) {
						return level + 1;
					}
				}
			}
		}
		return -1;
	}

}
