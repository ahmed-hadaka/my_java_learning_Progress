package bfsLeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://www.interviewbit.com/problems/stepping-numbers/
public class SteppingNumber {
// 10  35 => 

	public static void main(String[] args) {
		System.out.println(stepnum(10, 20));
	}

	public static List<Integer> stepnum(int A, int B) {

		Queue<Integer> q = new LinkedList<>();
		ArrayList<Integer> ans = new ArrayList<>();

		if (inRange(0, A, B)) // handle 0 as special case
			ans.add(0);

		for (int i = 1; i <= 9; i++) { // put initial starts
			q.add(i);
			if (inRange(i, A, B))
				ans.add(i);
		}

		findStepNumsBFS(A, B, q, ans);
		return ans;
	}

	private static void findStepNumsBFS(int a, int b, Queue<Integer> q, ArrayList<Integer> ans) {
		for (int size = q.size(); !q.isEmpty(); size = q.size()) {
			while (size-- > 0) {
				int cur = q.poll();
				int lastDigite = cur % 10;

				if (lastDigite != 0 && !process(cur, lastDigite - 1, a, b, q, ans))
					break;
				if (lastDigite != 9 && !process(cur, lastDigite + 1, a, b, q, ans))
					break;
			}
		}
	}

	private static boolean process(int cur, int lastDigigit, int a, int b, Queue<Integer> q, ArrayList<Integer> ans) {
		int temp = cur * 10 + lastDigigit;

		if (temp > b)
			return false;
		if (inRange(temp, a, b)) {
			ans.add(temp);
		}
		q.add(temp);
		return true;
	}

	private static boolean inRange(int i, int low, int heigh) {
		if (i >= low && i <= heigh)
			return true;
		return false;
	}
}
