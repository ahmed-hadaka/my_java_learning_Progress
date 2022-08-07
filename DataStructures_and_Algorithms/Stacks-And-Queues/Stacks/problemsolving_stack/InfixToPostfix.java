package problems_java_DS;

/*
 * single digit, no unary operators
*/

import java.util.Stack;

public class InfixToPostfix {
	public static void main(String[] args) {
//		System.out.println(infixToPostfix_v1("1+3*5-8/2")); // 135*+82/-
//		System.out.println(infixToPostfix_v2("2+3-((5+2)*3)"));// 23+52+3*-
		System.out.println(infixToPostfix_v3("1+2^3^4*5-6"));//
	}

	/*
	 * a+b*(c^d-e)^(f+G*h)-i === 5+4^3^2-9
	 */
	private static int getPriority(char c) {
		if (c == '^')
			return 3;
		if (c == '*' || c == '/')
			return 2;
		if (c == '+' || c == '-')
			return 1;
		return 0;
	}

// o(n) Time complexity, every operators in the worst case will be removed once and added once in the stack
// it's like a parallel loops

	public static String infixToPostfix_v1(String infix) {
		String postfix = "";
		Stack<Character> st = new Stack<>();
		char[] arr = infix.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (Character.isDigit(arr[i])) {
				postfix += arr[i];
			} else {
				while (!st.isEmpty() && getPriority(st.peek()) >= getPriority(arr[i]))
					postfix += st.pop();
				st.push(arr[i]);
			}
		}
		while (!st.isEmpty())
			postfix += st.pop();
		return postfix;
	}

	public static String infixToPostfix_v2(String infix) { // handle ()
		String postfix = "";
		Stack<Character> st = new Stack<>();
		char[] arr = infix.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (Character.isDigit(arr[i])) {
				postfix += arr[i];
			} else {
				if (arr[i] == '(')
					st.push(arr[i]);
				else if (arr[i] == ')') {
					while (st.peek() != '(')
						postfix += st.pop();
					st.pop();
				} else {
					while (!st.isEmpty() && getPriority(st.peek()) >= getPriority(arr[i]))
						postfix += st.pop();
					st.push(arr[i]);
				}
			}
		}
		while (!st.isEmpty())
			postfix += st.pop();
		return postfix;
	}

	public static String infixToPostfix_v3(String infix) { // handle ^ operator
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
							&& !(st.peek() == arr[i] && arr[i] == '^'))
						postfix += st.pop();
					st.push(arr[i]);
				}
			}
		}
		while (!st.isEmpty())
			postfix += st.pop();
		return postfix;
	}

}
