package LeetCode;

import java.util.Stack;

public class Score_of_Parentheses {
	public static void main(String[] args) {

	}

	public int scoreOfParentheses(String s) {
		char[] arr = s.toCharArray();
		Stack<Integer> st = new Stack<>();
		st.push(0); // temp value to help us.
		for (char c : arr) {
			if (c == '(') {
				st.push(0);
			} else {
				int temp = 0;
				if (st.peek() == 0) {
					temp = 1;
				} else {
					temp = 2 * st.peek();
				}
				st.pop();
				int parent = temp + st.pop();
				st.push(parent);
			}
		}
		return st.pop();
	}

}
