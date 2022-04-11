package Exercises.Deque;

/**
 *
 * @AhmedHadaka
 */
public class DequeList {

    DoublyLinkedList list;

    public DequeList(int size) {
        list = new DoublyLinkedList();
    }

    public void insertRight(int value) {
        list.insertFirst(value);
    }

    public void insertLeft(int value) {
        list.insertLast(value);
    }

    public Node deleteLeft() {
        return list.deleteLast();
    }

    public Node deleteRight() {
        return list.deleteFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void display() {
        System.out.println(list.toString());
    }
}
