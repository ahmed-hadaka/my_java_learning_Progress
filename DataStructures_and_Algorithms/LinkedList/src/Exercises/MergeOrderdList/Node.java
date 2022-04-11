  package Exercises.MergeOrderdList;

/**
 *
 * @AhmedHadaka
 */
public class Node {

    private int iData;
    private Node next;
    private Node previous;

    public Node(int iData) {
        this.iData = iData;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getIData() {
        return iData;
    }

    @Override
    public String toString() {
        return iData + ", ";
    }
}
