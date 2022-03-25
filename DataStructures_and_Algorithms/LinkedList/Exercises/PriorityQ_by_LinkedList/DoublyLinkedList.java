package Exercises.PriorityQ_by_LinkedList;

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

    public void insert(int iData) {
        Node newNode = new Node(iData);
        if (isEmpty()) {
            first = last = newNode;
            return;
        }
        Node current = first;
        while (current != null && current.getiData() < iData) {
            current = current.getNext();
        }

        if (current == null) {  //at the last
            last.setNext(newNode);
            newNode.setPrevious(last);
            last = newNode;
            return;
        } else if (current == first) { // at first
            first = newNode;
        } else { // at the middle
            current.getPrevious().setNext(newNode);
        }
        newNode.setNext(current);
        newNode.setPrevious(current.getPrevious());
        current.setPrevious(newNode);
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

    public String getFirst() {
        return first.toString();
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
