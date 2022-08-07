package problems_java_DS;

import java.util.Stack;

public class RemoveBrackets {

	public static void main(String[] args) {
		System.out.println(removeBrackets("(9+1-(2-3-(4+5)-6)-7)"));
	}

	private static char getSign(char sign1, char sign2) {
		if (sign1 == sign2)
			return '+';
		return '-';
	}

	public static String removeBrackets(String s) {
		String ans = "";
		Stack<Character> st = new Stack<>();
		st.push('+');
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' && i == 0)
				continue;
			if (Character.isDigit(c))
				ans += c;
			else if (c == '+' || c == '-') {
				ans += getSign(st.peek(), c);
			} else if (c == '(') {
				if (s.charAt(i - 1) != '(')
					st.push(getSign(s.charAt(i - 1), st.peek()));
				else
					st.push(st.peek());
			} else {
				st.pop();
			}
		}
		return ans;
	}
}
