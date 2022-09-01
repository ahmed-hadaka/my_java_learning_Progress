package problems_java_DS.Demonstrates_Hash_Table_with_Linear_Probing;

public class DataItem {
	private int hashKey;
	private String Value;

	public DataItem(int hashKey, String value) {
		this.hashKey = hashKey;
		this.Value = value;
	}

	public String getValue() {
		return Value;
	}

	public void updateNode(int hashKey, String value) {
		this.hashKey = hashKey;
		this.Value = value;
	}

	public int getKey() {
		return hashKey;
	}
}
