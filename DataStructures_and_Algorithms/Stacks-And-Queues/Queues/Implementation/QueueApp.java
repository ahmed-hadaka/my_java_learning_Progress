package Queues;

public class QueueApp {

    public static void main(String[] args) {
        Queue theQueue = new Queue(5);

        theQueue.insert(0);
        theQueue.insert(1);
        theQueue.insert(-1);
        theQueue.insert(5);
        theQueue.insert(7);
        theQueue.remove();
        theQueue.remove();
        theQueue.insert(11);
        theQueue.displayContent();

    }

}
