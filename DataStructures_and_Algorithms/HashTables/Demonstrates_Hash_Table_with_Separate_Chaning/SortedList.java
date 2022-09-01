package problems_java_DS.Demonstrates_Hash_Table_with_Separate_Chaning;

/**
 * @AhmedHadaka
 */
public class SortedList {

	private NodeItem head;

	public void insert(NodeItem newNode) {
		int hashKey = newNode.getHashKey();
		NodeItem current = head;
		NodeItem previous = null;
		boolean update = false;

		while (current != null && hashKey > current.getHashKey()) {
			previous = current;
			current = current.getNext();
		}

		if (previous == null) { // there is no head or our hash_key < head.hash_key
			head = newNode;

		} else if (current == null || current.getHashKey() != hashKey) {// found appropriate position
			previous.setNext(newNode);
		}

		else { // exist => update value
			current.updateValue(newNode.getValue());
			update = true;
		}

		if (!update)
			newNode.setNext(current);
	}

	public NodeItem delete(int hashKey) {
		if (!isEmpty()) {
			NodeItem current = head;
			NodeItem previous = current;

			while (current.getHashKey() != hashKey) {
				previous = current;
				current = current.getNext();
				if (current == null)
					return null;
			}
			if (current == previous) {
				head = current.getNext();
			} else {
				previous.setNext(current.getNext());
			}
			return current;
		}
		return null;
	}

	public NodeItem deleteFirst() {
		NodeItem temp = head;
		head = head.getNext();
		return temp;
	}

	public NodeItem find(int hashKey) {
		if (!isEmpty()) {
			NodeItem current = head;
			while (current.getHashKey() != hashKey) {
				current = current.getNext();
				if (current == null)
					return null;
			}
			return current;
		}
		return null;
	}

	public boolean isEmpty() {
		return (head == null);
	}

	@Override
	public String toString() {
		NodeItem current = head;
		String result = "{ ";
		while (current != null) {
			result += current.toString();
			current = current.getNext();
		}
		result += " }";
		return result;
	}
}
