import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortedMap {
	public static void main(String[] args) {
		Map<Integer, String> hashMap = new HashMap<Integer, String>();
		Map<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>();
		Map<Integer, String> treeMap = new TreeMap<Integer, String>();

		testMap(hashMap); // hashmap doesn't maintain the order
		System.out.println("---------");
		testMap(linkedHashMap); // linkedHashmap maintain the order that you put things in.
		System.out.println("---------");
		testMap(treeMap); // order the pears by its key
	}

	public static void testMap(Map<Integer, String> map) {
		map.put(9, "fox");
		map.put(4, "cat");
		map.put(8, "dog");
		map.put(1, "giraffe");
		map.put(0, "swan");
		map.put(15, "bear");
		map.put(6, "snake");

		for (Integer key : map.keySet()) {
			String value = map.get(key);

			System.out.println(key + ": " + value);
		}
	}

}