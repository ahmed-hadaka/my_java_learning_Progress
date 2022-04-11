package Queue_Stack_by_linkedList;

/**
 *
 * @AhmedHadaka
 */
public class LinkQueueApp {

    public static void main(String[] args) {
        LinkQueue theQueue = new LinkQueue();
        theQueue.insert(20);
        theQueue.insert(40);
        System.out.println(theQueue.toString());

        theQueue.insert(60);
        theQueue.insert(80);

        System.out.println(theQueue.toString());
        theQueue.remove();
        theQueue.remove();
        System.out.println(theQueue.toString());
    }
}
