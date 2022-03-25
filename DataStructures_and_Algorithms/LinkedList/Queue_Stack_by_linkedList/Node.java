package Queue_Stack_by_linkedList;

/**
 * Node for Linked list implementation
 *
 * @AhmedHadaka
 */
public class Node {

    private int iData;
    private Node next;

    public Node(int iData) {
        this.iData = iData;
    }

    @Override
    public String toString() {
        return "iData= " + iData + ", ";
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public int getIData() {
        return iData;
    }

}
