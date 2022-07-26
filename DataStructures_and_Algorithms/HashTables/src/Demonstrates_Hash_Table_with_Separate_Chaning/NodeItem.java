package Demonstrates_Hash_Table_with_Separate_Chaning;

/**
 * @AhmedHadaka
 */
public class NodeItem {

    private final int HASH_KEY;
    private final String VALUE;
    private NodeItem next;

    public NodeItem(int hashKey, String value) {
        this.HASH_KEY = hashKey;
        this.VALUE = value;
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

    @Override
    public String toString() {
        return HASH_KEY + ": " + VALUE + ", ";
    }
}
