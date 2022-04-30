package Demonstrates_Hash_Table_with_Separate_Chaning;

/**
 * @AhmedHadaka
 */
public class SortedList {

    private NodeItem first;

    public void insert(NodeItem newNode) {
        int hashKey = newNode.getHashKey();
        NodeItem current = first;
        NodeItem previous = null;

        while (current != null && hashKey > current.getHashKey()) {
            previous = current;
            current = current.getNext();
        }
        if (previous == null) { // can't enter the loop coz, key < current.idata || array is empty
            first = newNode;
        } else { // exit from the loop with (current = null || current hold a node) & previous hold a node
            previous.setNext(newNode);
        }
        newNode.setNext(current);
    }

    public NodeItem delete(int hashKey) {
        if (!isEmpty()) {
            NodeItem current = first;
            NodeItem previous = current;
            while (current.getHashKey() != hashKey) {
                previous = current;
                current = current.getNext();
                if (current == null)
                    return null;
            }
            if (current == previous) {
                first = current.getNext();
            } else {
                previous.setNext(current.getNext());
            }
            return current;
        }
        return null;
    }

    public NodeItem find(int hashKey) {
        if (!isEmpty()) {
            NodeItem current = first;
            while (current != null && current.getHashKey() != hashKey) {
                current = current.getNext();
                if (current == null)
                    return null;
            }
            return current;
        }
        return null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    @Override
    public String toString() {
        NodeItem current = first;
        String result = "{ ";
        while (current != null) {
            result += current.toString();
            current = current.getNext();
        }
        result += " }";
        return result;
    }
}
