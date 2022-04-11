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
            if (current.getNext() == null) {
                return null;
            }
            current = current.getNext();
        }
        return current;
    }

//delete
    public Node delete(int key) {
        Node previous = null, current = head;
        while (current.getIData() != key) {
            if (current.getNext() == null) {
                return null;
            }
            previous = current;
            current = current.getNext();
        }
        if (current == previous) {
            head = current.getNext();
        } else {
            previous.setNext(current.getNext());
        }
        return current;
    }

@Override
    public String toString() {
        Node current = head;
        String result = "{ ";
        while (current != null) {
           result += current.toString() + ", ";
            current = current.getNext();
        }
        result += " }";
        return result;
    }
}