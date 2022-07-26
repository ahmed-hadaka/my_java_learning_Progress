package Exercises.Deque;

/**
 *
 * @AhmedHadaka
 */
public class DoublyLinkedList {

    private Node first;
    private Node last;

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(int iData) {
        Node newNode = new Node(iData);
        if (isEmpty()) {
            last = newNode;
        } else {
            first.setPrevious(newNode);
            newNode.setNext(first);
        }
        first = newNode;
    }

    public void insertLast(int iData) {
        Node newNode = new Node(iData);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.setNext(newNode);
            newNode.setPrevious(last);
        }
        last = newNode;
    }

    public Node deleteFirst() {
        if (!isEmpty()) {
            Node temp = first;
            if (first.getNext() == null) {
                last = null;
            }
            first = first.getNext();
            if (first != null) {
                first.setPrevious(null);
            }
            return temp;
        }
        return null;
    }

    public Node deleteLast() {
        if (!isEmpty()) {
            Node temp = last;
            if (last.getPrevious() == null) {
                first = null;
            }
            last = last.getPrevious();
            if (last != null) {  // not reach the head.next yet.
                last.setNext(null);
            }
            return temp;
        }
        return null;
    }

    @Override
    public String toString() {
        Node current = first;
        String result = "{ ";
        while (current != last) {
            result += current.toString();
            current = current.getNext();
        }
        result += current.toString();

        result += " }";
        return result;
    }
}
