package linkedlist;

/**
 *
 * @AhmedHadaka
 */
public class LinkedListApp {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertFirst(22, 2.99);
        list.insertFirst(44, 4.99);
        list.insertFirst(66, 6.99);
        list.insertFirst(88, 8.99);

        System.out.println(list.toString());

        Node f = list.find(44);
        if (f != null) {
            System.out.println("Found link with key " + f.getIData());
        } else {
            System.out.println("Can’t find link");
        }
        Node d = list.delete(66);
        if (d != null) {
            System.out.println("Deleted link with key " + d.getIData());
        } else {
            System.out.println("Can’t delete link");
        }
        System.out.println(list.toString());
    }
}
