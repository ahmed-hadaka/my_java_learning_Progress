package problems_java_DS;

import java.util.Stack;

public class PostfixEvaluation {
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		System.out.println(evaluate("432^^"));
	}

	public static double evaluate(String postfix) {
		Stack<Double> st = new Stack<>();
		for (int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);
			if (Character.isDigit(c)) {
				st.push(Double.parseDouble(String.valueOf(c)));
			} else {
				if (c == '+') {
					Double second = st.pop();
					Double first = st.pop();
					st.push(first + second);
				} else if (c == '-') {
					Double second = st.pop();
					Double first = st.pop();
					st.push(first - second);
				} else if (c == '*') {
					Double second = st.pop();
					Double first = st.pop();
					st.push(first * second);
				} else if (c == '/') {
					Double second = st.pop();
					Double first = st.pop();
					st.push(first / second);
				} else if (c == '^') {
					Double second = st.pop();
					Double first = st.pop();
					st.push(Math.pow(first, second));
				}
			}
		}
		return st.pop();
	}
}
