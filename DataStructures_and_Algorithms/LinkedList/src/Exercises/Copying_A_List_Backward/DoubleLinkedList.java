package Exercises.Copying_A_List_Backward;

/**
 *
 * @AhmedHadaka
 */
public class DoubleLinkedList {

    private Node first;
    private Node last;

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(int iData) {
        Node newNode = new Node(iData);
        if (isEmpty()) {
            last = newNode;
        } else {
            newNode.setNext(first);
        }
        first = newNode;
    }


        public void insertLast(int iData) {
        Node newNode = new Node(iData);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.setNext(newNode);
        }
        last = newNode;
    }

    public Node deleteFirst() {
        if (!isEmpty()) {
            Node temp = first;
            if (first.getNext() == null) {
                last = null;
            }
            first = first.getNext();
            return temp;
        }
        return null;
    }

    
    public int getLength() {
        Node current = first;
        int count = 0;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }
    @Override
    public String toString() {
        Node current = first;
        String result = "{ ";
        while (current != null) {
            result += current.toString();
            current = current.getNext();
        }
        result += " }";
        return result;
    }
}
