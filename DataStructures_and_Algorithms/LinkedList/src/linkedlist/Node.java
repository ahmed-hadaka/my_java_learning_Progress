package linkedlist;

/**
 * Node for Linked list implementation
 *
 * @AhmedHadaka
 */
public class Node {

    private int iData;
    private double dData;
    private Node next;

    public Node(int iData, double dData) { 
        this.iData = iData;
        this.dData = dData;
    }
@Override
    public String toString() {
        return "iData= " + iData + ", dData= " + dData;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getIData() {
        return iData;
    }

    public Node getNext() {
        return next;
    }

}
