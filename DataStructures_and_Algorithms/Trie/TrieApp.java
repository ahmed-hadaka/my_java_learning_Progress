package problems_java_DS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrieApp {
	public static void main(String[] args) {
		Trie trie = new Trie();
//		trie.insert("abcd");
//		trie.insert("ab");
//		trie.insert("abx");
//		trie.insert("abyz");
//		trie.insert("xyz");
//		trie.insert("a");
//		trie.insert("bcd");

		List<String> list = new ArrayList<>(Arrays.asList("xy", "ab", "t", "yz"));
		String str = "heyabcdtwxyw";
		trie.listSubString_v1(str, list);
		trie.clearTrie();
		System.out.println();
		trie.listSubString_v2(str, list);

	}
}
