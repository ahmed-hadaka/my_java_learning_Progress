package SortedList;

/**
 *
 * @AhmedHadaka
 */
public class SortedList {

    private Node first;

    public SortedList() {
        this.first = null;
    }
  
    public SortedList(Node [] arr) {
        for (Node item : arr) {
            insert(item.getIData());
        }
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insert(int key) {
        Node newNode = new Node(key);
        Node current = first;
        Node previos = null;

        while (current != null && key > current.getIData()) {
            previos = current;
            current = current.getNext();
        }
        if (previos == null) { // can't enter the loop coz, key < current.idata || array is empty
            first = newNode;

        } else { // exit from the loop with (current = null || current hold a node) & previos hold a node
            previos.setNext(newNode);
        }
        newNode.setNext(current);

    }

    public Node remove() {
        if (!isEmpty()) {
            Node temp = first;
            first = first.getNext();
            return temp;
        }
        return null;
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
