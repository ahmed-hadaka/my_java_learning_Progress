package Exercises.PalindromeTest;

/**
 *
 * @AhmedHadaka
 */
public class LinkStack {

    private LinkList theList;

    public LinkStack() {
        theList = new LinkList();
    }

    public void push(char iData) {
        theList.insertFirst(iData);
    }

    public char pop() {
        return theList.deleteFirst();
    }

    public boolean isEmpty() {
        return (theList.isEmpty());
    }

    public int getLength() {
        return theList.getLength();
    }
}
