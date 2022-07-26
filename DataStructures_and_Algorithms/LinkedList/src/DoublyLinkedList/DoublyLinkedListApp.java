package DoublyLinkedList;

/**
 *
 * @AhmedHadaka
 */
public class DoublyLinkedListApp {

    public static void main(String[] args) {
        DoublyLinkedList theList = new DoublyLinkedList();
        theList.insertFirst(22); 
        theList.insertFirst(44);
        theList.insertFirst(66);
        
        theList.insertLast(11); 
        theList.insertLast(33);              
        theList.insertLast(55);
        
        System.out.println(theList.toString()); //  66, 44, 22, 11, 33, 55
        
        theList.deleteFirst(); 
        theList.deleteLast(); 
        
        theList.deleteKey(11); 
        
        System.out.println(theList.toString()); //  44, 22, 33,
        
        theList.insertAfter(22, 77); 
        theList.insertAfter(33, 88); 
        
        System.out.println(theList.toString()); //  44, 22, 77, 33, 88
    }
}
