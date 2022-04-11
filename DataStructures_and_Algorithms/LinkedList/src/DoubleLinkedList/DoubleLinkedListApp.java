package DoubleLinkedList;

/**
 *
 * @AhmedHadaka
 */
public class DoubleLinkedListApp {

    public static void main(String[] args) {
        DoubleLinkedList theList = new DoubleLinkedList();
        theList.insertFirst(22);
        theList.insertFirst(44);
        theList.insertFirst(66);

        theList.insertLast(11);
        theList.insertLast(33);
        theList.insertLast(55);

        System.out.println(theList.toString());

        theList.deleteFirst();
        theList.deleteFirst();
        
        System.out.println(theList.toString());
    }
}
