package LeetCode;

import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isValid(String s) {
		char[] arr = s.toCharArray();
		Stack<Character> st = new Stack<>();
		for (char c : arr) {
			if (c == '[' || c == '{' || c == '(') {
				st.push(c);
			} else {
				if (!st.isEmpty()) {
					if (c == '}' && st.peek() == '{' || c == ']' && st.peek() == '[' || c == ')' && st.peek() == '(') {
						st.pop();
						continue;
					}
				}
				return false;
			}
		}

		return st.isEmpty();
	}

}
