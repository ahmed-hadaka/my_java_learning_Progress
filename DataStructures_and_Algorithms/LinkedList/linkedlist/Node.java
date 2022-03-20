package linkedlist;

/**
 * Node for Linked list implementation
 *
 * @AhmedHadaka
 */
public class Node {

    private final int iData;
    private final double dData;
    private Node next;

    public Node(int iData, double dData) {  // not necessery
        this.iData = iData;
        this.dData = dData;
    }

    public void displayNode() {
        System.out.println("{ " + "iData= " + iData + ", dData= " + dData + " }");
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getIData() {
        return iData;
    }

    public double getdData() {
        return dData;
    }

    public Node getNext() {
        return next;
    }

}
