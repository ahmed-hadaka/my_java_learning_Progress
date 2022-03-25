package Exercises.PalindromeTest;

/**
 *
 * @AhmedHadaka
 */
public class LinkList {

    private Node first;
    private Node last;

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(char iData) {
        Node newNode = new Node(iData);
        if (isEmpty()) {
            last = newNode;
        }
        newNode.setNext(first);
        first = newNode;
    }

    public void insertLast(char iData) {
        Node newNode = new Node(iData);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.setNext(newNode);
        }
        last = newNode;
    }

    public char deleteFirst() {  // assuming not empty
        Node temp = first;
        if (first.getNext() == null) {
            last = null;
        }
        first = first.getNext();
        return temp.getIData();
    }

    public int getLength() {
        Node current = first;
        int count = 0;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

}
