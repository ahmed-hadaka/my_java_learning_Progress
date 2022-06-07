package linkedlist;

/**
 *
 * @AhmedHadaka
 */
public class LinkedList {

    private Node head;

    public void insertFirst(int iData, double dData) {
        Node newNode = new Node(iData, dData);
        newNode.setNext(head);
        head = newNode;
    }

    // find
    public Node find(int key) {
        Node current = head;
        while (current.getIData() != key) {
            current = current.getNext();
            if (current == null) {
                return null;
            }
        }
        return current;
    }

//delete
    public Node delete(int key) {
        Node current = head, previous = current;
        while (current.getIData() != key) {
            previous = current;
            current = current.getNext();
            if (current == null) {
                return null;
            }
        }
        if (current == previous) {
            head = current.getNext();
        }else {
            previous.setNext(current.getNext());
        }
        return current;
    }

@Override
    public String toString() {
        Node current = head;
        StringBuilder result = new StringBuilder("{ ");
        while (current != null) {
           result.append(current).append(", ");
            current = current.getNext();
        }
        result.append(" }");
        return result.toString();
    }
}
