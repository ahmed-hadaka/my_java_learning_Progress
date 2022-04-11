package Exercises.Copying_A_List_Backward;

/**
 * @AhmedHadaka
 */
public class LinkStack {

    private DoubleLinkedList theList;

    public LinkStack() {
        theList = new DoubleLinkedList();
    }

    public void push(Node iData) {
        theList.insertLast(iData.getIData());
    }

    public Node pop() {
        return theList.deleteFirst();
    }

    public boolean isEmpty() {
        return (theList.isEmpty());
    }

    @Override
    public String toString() {
        return theList.toString();
    }
}
