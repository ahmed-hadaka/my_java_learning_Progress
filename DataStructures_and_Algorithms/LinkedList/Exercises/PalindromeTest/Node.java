package Exercises.PalindromeTest;

/**
 * Node for Linked list implementation
 *
 * @AhmedHadaka
 */
public class Node {

    private char iData;
    private Node next;

    public Node(char iData) {
        this.iData = iData;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public char getIData() {
        return iData;
    }

}
