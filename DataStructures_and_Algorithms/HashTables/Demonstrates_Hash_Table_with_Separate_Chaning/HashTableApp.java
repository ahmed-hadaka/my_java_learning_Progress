package problems_java_DS.Demonstrates_Hash_Table_with_Separate_Chaning;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashTableApp {
	public static void main(String[] args) {
//		HashTable ht = new HashTable(7);
//		"cbaebabacd"
//		"abc"
		System.out.println(findUniqueAnagrams("cbaebabacd"));

//		ht.insert(12, "one");
//		ht.insert(1, "two");
//		ht.insert(34, "three");
//		ht.insert(8, "four");
//		ht.insert(3, "five");
//		ht.insert(5, "six");
//		ht.insert(47, "one");
//		ht.insert(14, "two");
//		ht.insert(343, "three");
//		ht.insert(48, "four");
//		ht.insert(52, "five");
//		ht.insert(95, "six");
//
//		ht.displayTable();
	}

	// ---------- find Unique Anagrams (approach 1) -> O(L^3 logL) ---------

	public static int findUniqueAnagrams(String s) { // O(L^3 logL)
		Set<String> set = new HashSet<>();
		int len = s.length();
		int totalSubStrings = len * (len + 1) / 2;
		for (int i = len - 1; i >= 0; i--) {// generate all substrings o(l)
			for (int j = 0; j <= i; j++) { // o(l)
				String sorted = sort(s.substring(j, i + 1)); // sort -> o(l logl)
				set.add(sorted); // add -> o(l)
			}
		}
		return totalSubStrings - set.size();
	}

	private static String sort(String s) {
		char[] temp = s.toCharArray();
		Arrays.sort(temp);
		return new String(temp);
	}

}
