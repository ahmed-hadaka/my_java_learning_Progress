package topologicalSortingLeetcode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/strange-printer-ii/
public class StrangegePrinterII {
	int[][] minRC = new int[61][2];
	int[][] maxRC = new int[61][2];
	boolean[] visited = new boolean[61];
	Map<Integer, Set<Integer>> outDegree = new HashMap<>();
	Map<Integer, Integer> inDegree = new HashMap<>();

	public boolean isPrintable(int[][] targetGrid) {
		// initialize minRC, maxRC
		for (int[] arr : minRC) {
			arr[0] = Integer.MAX_VALUE;
			arr[1] = Integer.MAX_VALUE;
		}
		for (int[] arr : maxRC) {
			arr[0] = -1;
			arr[1] = -1;
		}
		// fill minRC, maxRC
		getBoundaries(targetGrid);

		buildAdjList(targetGrid);

		return !isCyclingTopoSorting();
	}

	private void getBoundaries(int[][] targetGrid) {
		int n = targetGrid.length, m = targetGrid[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int cur = targetGrid[i][j];
				minRC[cur][0] = Math.min(minRC[cur][0], i);
				minRC[cur][1] = Math.min(minRC[cur][1], j);
				maxRC[cur][0] = Math.max(maxRC[cur][0], i);
				maxRC[cur][1] = Math.max(maxRC[cur][1], j);
			}
		}
	}

	private void buildAdjList(int[][] targetGrid) {
		for (int i = 0; i <= 60; i++) {
			if (minRC[i][0] != Integer.MAX_VALUE) {
				outDegree.put(i, new HashSet<>());
				inDegree.put(i, 0);
			}
		}
		for (int i = 0; i <= 60; i++) {
			for (int j = minRC[i][0]; j <= maxRC[i][0]; j++) {
				for (int k = minRC[i][1]; k <= maxRC[i][1]; k++) {
					if (targetGrid[j][k] != i & !visited[targetGrid[j][k]]) {
						addDirectedEdge(i, targetGrid[j][k]);
						visited[targetGrid[j][k]] = true;
					}
				}
			}
		}

	}

	private void addDirectedEdge(int i, int j) {
		outDegree.get(i).add(j);

		int oldValue = inDegree.get(j);
		inDegree.replace(j, ++oldValue);
	}

	private boolean isCyclingTopoSorting() {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		int originalSize = inDegree.size(), count = 0;
		// initialize q with in_degree zero
		for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
			int key = entry.getKey();
			int val = entry.getValue();
			if (val == 0)
				q.addLast(key);
		}
		while (!q.isEmpty()) {
			int cur = q.pollFirst();
			count++;
			if (!outDegree.get(cur).isEmpty()) {
				for (Integer i : outDegree.get(cur)) {
					int oldVal = inDegree.get(i);
					inDegree.replace(i, --oldVal);
					if (inDegree.get(i) == 0)
						q.addLast(i);
				}
			}
		}
		return originalSize != count;
	}
}
