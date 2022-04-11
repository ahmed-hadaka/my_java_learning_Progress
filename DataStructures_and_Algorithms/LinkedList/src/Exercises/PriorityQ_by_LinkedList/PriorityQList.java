package Exercises.PriorityQ_by_LinkedList;

/**
 *
 * @AhmedHadaka
 */
public class PriorityQList {

    DoublyLinkedList list;

    public PriorityQList() {
        list = new DoublyLinkedList();
    }

    public void insert(int iData) {
        list.insert(iData);
    }

    public Node remove() {
        return list.deleteFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public String peek() {
        return list.getFirst();
    }
    
    public void display() {
        System.out.println(list.toString());
    }
}
