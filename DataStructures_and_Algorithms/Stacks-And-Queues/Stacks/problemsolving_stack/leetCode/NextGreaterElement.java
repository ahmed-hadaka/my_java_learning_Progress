package LeetCode;

import java.util.Arrays;
/*
 * https://leetcode.com/problems/daily-temperatures/
 */
import java.util.Stack;

public class NextGreaterElement {
	public static void main(String[] args) {
	}

	public int[] dailyTemperatures(int[] temperatures) {
		Stack<Integer> st = new Stack<>();
		int[] ans = new int[temperatures.length]; // default is zero

		for (int i = 0; i < temperatures.length; i++) {
			while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()])
				ans[st.peek()] = i - st.pop();
			st.push(i);
		}
		return ans;
	}

	public static int[] nextGreaterElements11(int[] nums) {
		Stack<Integer> st = new Stack<>();
		int[] ans = new int[nums.length * 2];
		int j;
		for (int i = 0; i < ans.length; i++) {
			j = i % nums.length;
			ans[i] = nums[j];
		}

		for (int i = 0; i < ans.length; i++) {
			while (!st.isEmpty() && ans[i] > ans[st.peek()])
				ans[st.pop()] = ans[i];
			st.push(i);
		}
		while (!st.isEmpty()) {
			ans[st.pop()] = -1;
		}
		nums = Arrays.copyOfRange(ans, 0, nums.length);
		return nums;
	}
}
