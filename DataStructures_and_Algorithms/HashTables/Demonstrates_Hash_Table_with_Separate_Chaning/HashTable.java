package problems_java_DS.Demonstrates_Hash_Table_with_Separate_Chaning;

public class HashTable {
	private SortedList[] hashArray;
	private int maxSize;
	private int totalElem;
	private double loadFactor;

	public HashTable(int maxSize) {
		this.maxSize = maxSize;
		loadFactor = 0.75;
		hashArray = new SortedList[maxSize];
		for (int i = 0; i < this.maxSize; i++) {// fill array
			hashArray[i] = new SortedList();
		}
	}

	private void rehashing() {
		SortedList[] oldTableArray = hashArray;

		maxSize = 2 * maxSize;
		hashArray = new SortedList[maxSize];

		for (int i = 0; i < this.maxSize; i++) {// fill array
			hashArray[i] = new SortedList();
		}

		for (int i = 0; i < oldTableArray.length; i++) {// copy data array

			while (!oldTableArray[i].isEmpty()) {
				NodeItem temp = oldTableArray[i].deleteFirst();
				int hashKey = temp.getHashKey();
				String value = temp.getValue();
				int hashValue = hashFun(hashKey);
				hashArray[hashValue].insert(new NodeItem(hashKey, value));
			}
		}
	}

	public void insert(int hashKey, String value) {
		NodeItem newNode = new NodeItem(hashKey, value);
		int key = hashFun(hashKey);
		hashArray[key].insert(newNode);
		totalElem++;
		if (((double) totalElem / maxSize) > loadFactor) {
			rehashing();
		}
	}

	public NodeItem find(int hashKey) {
		int key = hashFun(hashKey);
		return hashArray[key].find(hashKey);
	}

	public NodeItem delete(int hashKey) {
		int key = hashFun(hashKey);
		totalElem--;
		return hashArray[key].delete(hashKey);
	}

	public int hashFun(int hashKey) {
		return hashKey % maxSize;
	}

	public void displayTable() {
		for (int j = 0; j < hashArray.length; j++) {
			System.out.print(j + ": "); // display cell number
			System.out.println(hashArray[j].toString() + "\n"); // display list
		}
	}

	// ----------- home work easy to medium --------------

	public int hashString(String value) {
		int hashValue = 0;
		for (char c : value.toCharArray()) {
			hashValue = (hashValue * 26 + c - 'a') % maxSize;
		}
		return hashValue;
	}

	// ---- hash_function handle upper and lower letters and digits ---

	public int generalHashFun(String value) {
		int hashValue = 0;
		int base = 2 * 26 + 10; // 2*26: for lower letters, 10 for digits
		int val = 0;

		for (char c : value.toCharArray()) {
			if (Character.isDigit(c)) {
				val = 26 + 26 + c - '0';
			} else if (Character.isUpperCase(c)) {
				val = 26 + c - 'A';
			} else if (Character.isLowerCase(c)) {
				val = c - 'a';
			} else {
				assert (false);
			}
			hashValue = (hashValue * base + val) % maxSize; // 24
		}

		return hashValue;
	}

	// --------------
	public int foldingHashFun(String value) {
		int hashValue = 0;
		int base = 2 * 26 + 10; // 2*26: for lower letters, 10 for digits
		int val = 0;
		int finalVal = 0;
		int counter = 0;

		for (char c : value.toCharArray()) {
			if (Character.isDigit(c)) {
				val = 26 + 26 + c - '0';
			} else if (Character.isUpperCase(c)) {
				val = 26 + c - 'A';
			} else if (Character.isLowerCase(c)) {
				val = c - 'a';
			} else {
				assert (false);
			}
			finalVal += val;
			counter++;
			if (counter == 4) {
				hashValue = (hashValue * base + finalVal) % maxSize; // 24
				counter = 0;
			}
		}
		if (counter != 0)
			hashValue = (hashValue * base + finalVal) % maxSize;
		return hashValue;
	}
}
