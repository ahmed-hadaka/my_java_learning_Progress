package Exercises.MergeOrderdList;

/**
 *
 * @AhmedHadaka
 */
public class SortedList {

    private Node first;
    private Node last;

    public SortedList() {
    }

    ;

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
        while (current != null && current.getIData() < iData) {
            current = current.getNext();
        }

        if (current == null) { // at last
            last.setNext(newNode);
            newNode.setPrevious(last);
            last = newNode;
            return;
        } else if (current == first) { // at first
            first = newNode;
        } else { // in the middle
            current.getPrevious().setNext(newNode);
        }
        newNode.setNext(current);
        newNode.setPrevious(current.getPrevious());
        current.setPrevious(newNode);

    }

    public Node remove() {
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

    @Override
    public String toString() {
        Node current = first;
        String result = "{ ";
        while (current != null) {
            result += current.toString();
            current = current.getNext();
        }
        result += " }";
        return result;
    }
}
