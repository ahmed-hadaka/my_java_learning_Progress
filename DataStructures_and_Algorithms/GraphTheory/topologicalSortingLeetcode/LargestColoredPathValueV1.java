package topologicalSortingLeetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/largest-color-value-in-a-directed-graph

// DFS version
public class LargestColoredPathValueV1 {

	public int largestPathValue(String colors, int[][] edges) {
		int n = colors.length();
		ArrayDeque<Integer> q = new ArrayDeque<>();
		Map<Integer, List<Integer>> outDegree = new HashMap<>();
		int[][] letters = new int[n][26];
		int[] inDegree = new int[n];
		int[] tempInDegree = new int[n];
		int[] largestColorValue = new int[n];

		buildAdjList(colors, edges, outDegree, inDegree, tempInDegree);

		if (isCycling(tempInDegree, outDegree, q, n, colors))
			return -1;

		// initialize queue with nodes with in-degree equal zero
		for (int j = 0; j < inDegree.length; j++) {
			if (inDegree[j] == 0) {
				DFS(j, outDegree, largestColorValue, letters, colors);
			}
		}

		return max(largestColorValue);
	}

	private int[] DFS(Integer cur, Map<Integer, List<Integer>> outDegree, int[] largestColorValue, int[][] letters,
			String colors) {
		int[] lastLetters = new int[26];
		int maxVal = 0;
		List<Integer> curNodeList = outDegree.get(cur);

		for (int j = 0; j < curNodeList.size(); j++) {
			Integer nodeValue = curNodeList.get(j);
			if (largestColorValue[nodeValue] != 0)
				lastLetters = letters[nodeValue];
			else
				lastLetters = DFS(nodeValue, outDegree, largestColorValue, letters, colors);
			for (int i = 0; i < lastLetters.length; i++) {
				letters[cur][i] = Math.max(letters[cur][i], lastLetters[i]);
				maxVal = Math.max(maxVal, letters[cur][i]);
			}
		}

		int l = ++letters[cur][(int) colors.charAt(cur) - 'a'];
		if (l > maxVal)
			maxVal = l;
		largestColorValue[cur] = maxVal;
		return letters[cur];
	}

	private void buildAdjList(String colors, int[][] edges, Map<Integer, List<Integer>> outDegree, int[] inDegree,
			int[] tempInDegree) {
		for (int i = 0; i < colors.length(); i++) {
			outDegree.put(i, new ArrayList<>());
		}
		for (int i = 0; i < edges.length; i++) {
			outDegree.get(edges[i][0]).add(edges[i][1]);
			inDegree[edges[i][1]]++;
			tempInDegree[edges[i][1]]++;
		}

	}

	private boolean isCycling(int[] inDegree, Map<Integer, List<Integer>> outDegreeAdjList, ArrayDeque<Integer> q,
			int numCourses, String colors) {
		// initialize queue with nodes with in-degree equal zero
		for (int j = 0; j < inDegree.length; j++) {
			if (inDegree[j] == 0) {
				q.addLast(j);
			}
		}
		int count = 0;
		for (int size = q.size(); !q.isEmpty(); size = q.size()) {
			while (size-- > 0) {
				int curValue = q.pollFirst();
				count++;
				for (Integer neighbor : outDegreeAdjList.get(curValue)) {
					inDegree[neighbor]--;
					if (inDegree[neighbor] == 0)
						q.addLast(neighbor);
				}
			}
		}
		return !(count == numCourses);
	}

	private int max(int[] time) {
		int max = 0;
		for (int i : time) {
			if (i > max)
				max = i;
		}
		return max;
	}
}
