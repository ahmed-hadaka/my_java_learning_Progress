package LeetCode;

import java.util.Scanner;
import java.util.Stack;

// abbaca
public class remove_all_adj_duplicated {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char[] arr = s.toCharArray();
		Stack<Character> st = new Stack<>();
		st.push(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			if (!st.isEmpty())
				if (arr[i] == st.peek()) {
					st.pop();
					continue;
				}

			st.push(arr[i]);
		}

		String string = "";
		for (Character character : st) { // this iterator start from the first input
			string += character;
		}
		System.out.println(string);
		sc.close();
	}

}
