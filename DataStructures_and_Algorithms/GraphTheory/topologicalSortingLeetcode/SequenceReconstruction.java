package topologicalSortingLeetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SequenceReconstruction {

	public static void main(String[] args) {
		List<List<Integer>> seqs = new ArrayList<>();
		seqs.add(new ArrayList<>(Arrays.asList(5, 2, 6, 3)));
		seqs.add(new ArrayList<>(Arrays.asList(4, 1, 5, 2)));
		int[] org = { 4, 1, 5, 2, 6, 3 };
		System.out.println(sequenceReconstruction(org, seqs));
	}

	public static boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
		Map<Integer, List<Integer>> outDegreeAdjList = new HashMap<>();
		Map<Integer, Integer> inDegreeAdjList = new HashMap<>();
		ArrayDeque<Integer> q = new ArrayDeque<>();

		buildAdjLists(org, outDegreeAdjList, inDegreeAdjList, seqs);

		for (Map.Entry<Integer, Integer> entry : inDegreeAdjList.entrySet()) {
			int key = entry.getKey();
			int val = entry.getValue();
			if (val == 0)
				q.addLast(key);
		}
		if (q.size() > 1 || q.size() == 0)
			return false; // if the graph has a cycle or queue has more than one node

		return isUnique_TopoSorting(inDegreeAdjList, outDegreeAdjList, q, org);

	}

	private static void buildAdjLists(int[] org, Map<Integer, List<Integer>> outDegreeAdjList,
			Map<Integer, Integer> inDegreeAdjList, List<List<Integer>> seqs) {
		// initialize adjLists
		for (int i = 1; i <= org.length; i++) {
			outDegreeAdjList.put(i, new ArrayList<>());
			inDegreeAdjList.put(i, 0);
		}

		for (List<Integer> list : seqs) {
			for (int i = 0; i < list.size() - 1; i++) {
				outDegreeAdjList.get(list.get(i)).add(list.get(i + 1));
				int oldVal = inDegreeAdjList.get(list.get(i + 1));
				inDegreeAdjList.replace(list.get(i + 1), oldVal + 1);
			}
		}
	}

	private static boolean isUnique_TopoSorting(Map<Integer, Integer> inDegreeAdjList,
			Map<Integer, List<Integer>> outDegreeAdjList, ArrayDeque<Integer> q, int[] org) {
		int[] ans = new int[org.length];
		int i = 0;
		for (int size = q.size(); !q.isEmpty(); size = q.size()) {
			if (size > 1)
				return false;
			int cur = q.poll();
			ans[i++] = cur;
			for (Integer neighbor : outDegreeAdjList.get(cur)) {
				int oldVal = inDegreeAdjList.get(neighbor);
				inDegreeAdjList.replace(neighbor, oldVal - 1);
				if (inDegreeAdjList.get(neighbor) == 0)
					q.add(neighbor);
			}

		}
		return Arrays.equals(org, ans);
	}

}
