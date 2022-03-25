package Queue_Stack_by_linkedList;

/**
 *
 * @AhmedHadaka
 */
public class LinkStack {

    private  LinkList theList;

    public LinkStack() {
        theList = new LinkList();
    }

    public void push(int iData) {
        theList.insertFirst(iData);
    }

    public int pop() {
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
