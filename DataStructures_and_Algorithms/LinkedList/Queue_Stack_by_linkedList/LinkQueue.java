package Queue_Stack_by_linkedList;

/**
 *
 * @AhmedHadaka
 */
public class LinkQueue {
    private LinkList theList;
    
    public LinkQueue() {
        theList = new LinkList();
    }
    
        public void insert(int iData) {
        theList.insertLast(iData);
    }

    // pop
    public int remove() {
       return theList.deleteFirst();
    }
    // isEmpty
    public boolean isEmpty() {
        return (theList.isEmpty());
    }
 @Override   
    public String toString() {
        return theList.toString();
    }
    
}
