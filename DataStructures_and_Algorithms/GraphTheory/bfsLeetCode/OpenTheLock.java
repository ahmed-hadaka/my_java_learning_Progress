package bfsLeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// https://leetcode.com/problems/open-the-lock/
public class OpenTheLock {

	public static void main(String[] args) {
		String[] deadends = { "0201", "0101", "0102", "1212", "2002" };
		System.out.println(openLock(deadends, "0202"));
	}

	public static int openLock(String[] deadends, String target) {
		Set<String> visited = new HashSet<>();
		for (int i = 0; i < deadends.length; i++) {
			visited.add(deadends[i]);
		}
		return BFS(deadends, visited, target);
	}

	private static char getNext(char c) {
		if (c == '9')
			return '0';
		return (char) (c + 1);
	}

	private static char getPrev(char c) {
		if (c == '0')
			return '9';
		return (char) (c - 1);
	}

	private static int BFS(String[] deadends, Set<String> visited, String target) {
		if (visited.contains("0000"))
			return -1;
		Queue<String> q = new LinkedList<>();
		q.add("0000");
		visited.add("0000");
		for (int level = 0, size = 1; !q.isEmpty(); level++, size = q.size()) {
			while (size-- > 0) {
				char[] cur = q.poll().toCharArray();
				for (int i = 0; i < 4; i++) {
					cur[i] = getNext(cur[i]);
					if (String.valueOf(cur).equals(target))
						return level + 1;
					if (!visited.contains(String.valueOf(cur))) {
						visited.add(String.valueOf(cur));
						q.add(String.valueOf(cur));
					}
					cur[i] = getPrev(getPrev(cur[i]));
					if (String.valueOf(cur).equals(target))
						return level + 1;
					if (!visited.contains(String.valueOf(cur))) {
						visited.add(String.valueOf(cur));
						q.add(String.valueOf(cur));
					}
					cur[i] = getNext(cur[i]);
				}
			}
		}
		return -1;
	}

}
