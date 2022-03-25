package Exercises.Copying_A_List_Backward;

/**
 *
 * AhmedHadaka;
 */
public class CopyBackwardApp {

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();  // target double linkedList
        CopyBackward cb = new CopyBackward(); // which have reverse copy method
        list.insertFirst(10);
        list.insertFirst(20);
        list.insertFirst(30);
        list.insertFirst(40);
        list.insertFirst(50);
        list.insertFirst(60);

        System.out.println(list.toString());

        cb.reverseCopy(list);

        System.out.println(list.toString());

    }
}
