package problems_java_DS.Demonstrates_Hash_Table_with_Linear_Probing;

public class HashTable {
	private DataItem[] hashArray;
	private final DataItem DELETED;
	private int size;

	public HashTable(int size) {
		this.size = size;
		hashArray = new DataItem[size];
		DELETED = new DataItem(-1, null);
	}

	public boolean insert(int hashKey, String value) {
		int key = hashFun(hashKey);

		for (int i = 0; i < size; i++) {
			if (hashArray[key] == null || hashArray[key].getKey() == -1) {
				DataItem newItem = new DataItem(hashKey, value);
				hashArray[key] = newItem;
				return true;
			} else if (hashArray[key].getKey() == hashKey) { // exist -> update
				hashArray[key].updateNode(hashKey, value);
				return true;
			}
			key++;
//          key += step(key);   in double hashing
			key %= size; // wrap_around
		}
		return false;
	}

	public DataItem delete(int hashKey) {
		int key = hashFun(hashKey);

		for (int i = 0; i < size; i++) {
			if (hashArray[key] == null) // can't found it
				break;
			if (hashArray[key].getKey() == hashKey) {// found it
				DataItem temp = hashArray[key];
				hashArray[key] = DELETED;
				return temp;
			}
			key++;
//        key += step(key);   in double hashing
			key %= size;
		}
		return null;
	}

	public DataItem find(int hashKey) {
		int key = hashFun(hashKey);

		for (int i = 0; i < size; i++) {
			if (hashArray[key] == null) // can't found it
				break;
			if (hashArray[key].getKey() == hashKey) {// found it
				return hashArray[key];
			}
			key++;
//        key += step(key);   in double hashing
			key %= size;
		}
		return null;
	}

	public int hashFun(int hashKey) {
		return hashKey % size;
	}

	/* in double hashing, you would like add this method */

//    public int step(int hashKey) {
//        return 5 - hashKey % 5;
//    }

	public void displayTable() {
		StringBuilder str = new StringBuilder("[ ");
		for (DataItem dataItem : hashArray) {
			if (dataItem != null)
				str.append(dataItem.getKey()).append(":").append(dataItem.getValue()).append(", ");
			else
				str.append("__, ");
		}
		str.append("]");
		System.out.println(str);
	}
}
