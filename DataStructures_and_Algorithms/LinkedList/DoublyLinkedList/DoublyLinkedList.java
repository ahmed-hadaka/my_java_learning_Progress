package DoublyLinkedList;

/**
 *
 * @AhmedHadaka
 */
public class DoublyLinkedList {

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
            first.setPrevious(newNode);
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
            newNode.setPrevious(last);
        }
        last = newNode;
    }

    public boolean insertAfter(int key, int iData) {
        Node newNode = new Node(iData);
        Node current = first;

        while (current.getiData() != key) {
            current = current.getNext();
            if (current == null) {
                return false;
            }
        }

        if (current == last) {
            last = newNode;
        } else {
            newNode.setNext(current.getNext());
            current.getNext().setPrevious(newNode);
        }
        newNode.setPrevious(current);
        current.setNext(newNode);

        return true;
    }

    public Node deleteFirst() {
        if (!isEmpty()) {
            Node temp = first;
            if (first.getNext() == null) {
                last = null;
            }
            first = first.getNext();
            first.setPrevious(null);
            return temp;
        }
        return null;
    }

    public Node deleteLast() {
        if (!isEmpty()) {
            Node temp = last;
            if (last.getPrevious() == null) {
                first = null;
            }
            last = last.getPrevious(); 
            last.setNext(null);
            return temp;
        }
        return null;
    }

    public Node deleteKey(int key) {
        if (!isEmpty()) {
            Node current = first;
            while (current.getiData() != key) {
                current = current.getNext();
                if (current == null) {
                    return null;
                }
            }
            if (current == first) {
                first = first.getNext();
            } else if (current == last) {
                last = last.getPrevious();
            } else {
                current.getPrevious().setNext(current.getNext());
                current.getNext().setPrevious(current.getPrevious());
            }
            return current;
        }
        return null;
    }

    @Override
    public String toString() {
        Node current = first;
        String result = "{ ";
        while (current != last) {
            result += current.toString();
            current = current.getNext();
        }
        result += current.toString();

        result += " }";
        return result;
    }
}
