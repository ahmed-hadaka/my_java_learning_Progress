package Exercises.ConcatenatingLists;

/**
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

    public char getiData() {
        return iData;
    }

    
    public char print() {
        return  iData;
    }
}
