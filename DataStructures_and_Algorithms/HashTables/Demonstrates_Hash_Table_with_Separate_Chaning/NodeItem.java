package problems_java_DS.Demonstrates_Hash_Table_with_Separate_Chaning;

/**
 * @AhmedHadaka
 */
public class NodeItem {

	private final int HASH_KEY;
	private String value;
	private NodeItem next;

	public NodeItem(int hashKey, String value) {
		this.HASH_KEY = hashKey;
		this.value = value;
	}

	public int getHashKey() {
		return HASH_KEY;
	}

	public void setNext(NodeItem next) {
		this.next = next;
	}

	public NodeItem getNext() {
		return this.next;
	}

	public String getValue() {
		return this.value;
	}

	public void updateValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return HASH_KEY + ": " + value + ", ";
	}
}
