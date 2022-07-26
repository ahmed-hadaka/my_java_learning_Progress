package Exercises.PriorityQ_by_LinkedList;

/**
 * test priorityQ implemented with doubly Linked List.
 *
 * @AhmedHadaka
 */
public class PriorityQListApp {

    public static void main(String[] args) {
        PriorityQList priQ = new PriorityQList();
        priQ.insert(30);
        priQ.insert(35);
        priQ.insert(62);
        priQ.insert(75);
        priQ.insert(100);

        System.out.println(priQ.peek());

        priQ.display();
    }
}
