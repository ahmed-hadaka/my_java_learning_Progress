package Exercises.ConcatenatingLists;

/**
 *
 * @AhmedHadaka
 */
public class ListConcatenate {
    
    public void concatenate(LinkedList list1, LinkedList list2) {
        list1.getLast().setNext(list2.getFirst());
        list1.setLast(list2.getLast());
        list2.setFirst(null);
        list2.setLast(null);
    }
 
}
