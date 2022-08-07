package LeetCode;

import java.util.Stack;

public class Asteroid_Collision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = asteroidCollision(new int[] { 10, 2, -5 });
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	public static int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> st = new Stack<>();
		st.push(asteroids[0]);
		for (int i = 1; i < asteroids.length; i++) {
			if (asteroids[i] > 0)
				st.push(asteroids[i]);
			else {
				boolean flag = false;
				while (!st.isEmpty() && st.peek() > 0) {
					if (Math.abs(asteroids[i]) > st.peek())
						st.pop();
					else {
						flag = true;
						break;
					}

				}
				if (st.peek() == Math.abs(asteroids[i]))
					st.pop();
				else if (!flag)
					st.push(asteroids[i]);
			}
		}
		int[] ans = new int[st.size()];
		int i = ans.length - 1;
		while (!st.isEmpty()) {
			ans[i--] = st.pop();
		}
		return ans;
	}

}
