package problems_java_DS;

import java.util.Stack;

public class InfixToPrefix {
	public static void main(String[] args) {
		System.out.println(infixToPrefix("4^3^2")); // +-923 => our => -9+23
	}

	/*
	 * 9-2+3 4^3^2. (A - B/C) * (A/K-L) => *-A/BC-/AKL . (P+(Q*R)/(S-T)) =>
	 * +P/*QR-ST.
	 */
	private static String revese(String s) {
		String ans = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			if (c == '(')
				ans += ')';
			else if (c == ')')
				ans += '(';
			else {
				ans += c;
			}
		}
		return ans;
	}

	private static int getPriority(char c) {
		if (c == '^')
			return 3;
		if (c == '*' || c == '/')
			return 2;
		if (c == '+' || c == '-')
			return 1;
		return 0;
	}

	private static String infixToPostfix(String infix) { // handle ^ operator
		String postfix = "";
		Stack<Character> st = new Stack<>();
		char[] arr = infix.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (Character.isDigit(arr[i]) || Character.isAlphabetic(arr[i])) {
				postfix += arr[i];
			} else {
				if (arr[i] == '(')
					st.push(arr[i]);
				else if (arr[i] == ')') {
					while (st.peek() != '(')
						postfix += st.pop();
					st.pop();
				} else {
					while (!st.isEmpty() && getPriority(st.peek()) >= getPriority(arr[i])
							&& (getPriority(st.peek()) == getPriority(arr[i]) && arr[i] == '^'))
						postfix += st.pop();
					st.push(arr[i]);
				}
			}
		}
		while (!st.isEmpty())
			postfix += st.pop();
		return postfix;
	}

	public static String infixToPrefix(String prefix) {
		String s = revese(prefix);
		System.out.println(s);
		s = infixToPostfix(s);
		return revese(s);
	}

}
