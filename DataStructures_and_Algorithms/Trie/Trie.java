package problems_java_DS;

import java.util.List;

public class Trie {
	Node root;

	public Trie() {
		root = new Node();
	}

	public void clearTrie() {
		root.clear();
	}

	public void insert(String str) {
		Node cur = root;
		for (char c : str.toCharArray()) {
			if (cur.getChildren().get(c) == null)
				cur.addChildren(c);
			cur = cur.getChildren().get(c);
		}
		cur.setLeaf(true);
	}

	public boolean wordExist(String word) {
		Node cur = root;
		for (char c : word.toCharArray()) {
			if (cur.getChildren().get(c) == null)
				return false;
			cur = cur.getChildren().get(c);
		}
		return cur.isLeaf();
	}

	public boolean prefixExist(String prifix) {
		Node cur = root;
		for (char c : prifix.toCharArray()) {
			if (cur.getChildren().get(c) == null)
				return false;
			cur = cur.getChildren().get(c);
		}
		return true; // here, you don't care if it's a leaf of not. because in both cases it's
						// consider a prefix.
	}

	// ---------------- homework easy to medium -----------
	public String firstWordPrefix(String str) {
		Node cur = root;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (cur.getChildren().get(c) == null)
				break;
			if (cur.getChildren().get(c).isLeaf())
				return str.substring(0, i + 1);
			cur = cur.getChildren().get(c);
		}
		return str;
	}

	public String replaceWords(List<String> dictionary, String sentence) {
		for (String string : dictionary) {
			insert(string);
		}
		String ans = "";
		for (String string : sentence.split(" ")) {
			ans += firstWordPrefix(string) + " ";
		}
		return ans.substring(0, ans.length() - 1);
	}
	// --------- is suffix -----------

	public void insertSuffix(String str) { // o(str.length)
		// reverse the word
		StringBuilder s = new StringBuilder(str);
		s.reverse();
		// insert it
		insert(s.toString());
	}

	public boolean isSuffixExist(String suffix) { // o(suf.length)
		// reverse the suffix
		StringBuilder s = new StringBuilder(suffix);
		s.reverse();
		// get it as prefix
		return prefixExist(s.toString());
	}
// ------------ homework medium --------------------

	// --------- print tree sorted --------
	private void print(List<String> list, Node root, String temp) {

		for (int i = 0; i < 26; i++) {
			char key = (char) (i + 'a');
			if (root.getChildren().get(key) != null) {
				if (root.getChildren().get(key).isLeaf())
					list.add(temp + key);
				print(list, root.getChildren().get(key), temp + key);
			}
		}
	}

	public void print(List<String> list) {
		print(list, root, "");
	}

	// -------------- Auto complete ------------
	public void autoComplete(String input, List<String> list) {
		Node cur = root;
		for (int i = 0; i < input.length(); i++) {
			char key = input.charAt(i);
			if (cur.getChildren().get(key) == null)
				return;
			cur = cur.getChildren().get(key);
		}
		if (cur.isLeaf())
			list.add(input);
		print(list, cur, input);
	}

	// ------------ find all sub_string -------------

	// first approach => O(S*S + QL) where S the length of string str.
	public void listSubString_v1(String str, List<String> queries) {

		// O(SS)
		for (int i = 0; i < str.length(); i++) { // insert suffix
			insert(str.substring(i, str.length()));
		}
		// O(QL) Q -> num of queries, L -> length of query
		for (String query : queries) {
			if (prefixExist(query))
				System.out.println(query);
		}
	}

	// second approach => O(S*L + QL) vs O(S*S + QL)
	public void listSubString_v2(String str, List<String> queries) {

		// O(QL)
		for (String query : queries) { // insert queries in the trie
			insert(query);
		}

		Node cur = root;

		// o(SL)
		for (int i = 0; i < str.length(); i++) {
			int temp = i;

			while (cur.getChildren().get(str.charAt(temp)) != null) {
				cur = cur.getChildren().get(str.charAt(temp++));
				if (cur.isLeaf())
					System.out.println(str.substring(i, temp));
			}
			cur = root;
		}
	}
// ----------------
}
