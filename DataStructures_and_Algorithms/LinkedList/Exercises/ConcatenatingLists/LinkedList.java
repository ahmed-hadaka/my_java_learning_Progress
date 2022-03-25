package Exercises.ConcatenatingLists;

/**
 *
 * @AhmedHadaka
 */
public class LinkedList {

    private Node first;
    private Node last;

    public boolean isEmpty() {
        return (first == null);
    }

    public void insert(char iData) {
      Node newNode = new Node(iData);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.setNext(newNode);
        }
        last = newNode;
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    @Override
    public String toString() {
        Node current = first;
        String result = "";
        while (current != null) {
            result += current.print();
            current = current.getNext();
        }

        return result;
    }
}
