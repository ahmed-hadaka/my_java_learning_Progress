package SortedList;

/**
 *
 * @AhmedHadaka
 */
public class SortedListApp {

    public static void main(String[] args) {
        SortedList sortedList = new SortedList();
        sortedList.insert(20); 
        sortedList.insert(40);
        
        System.out.println(sortedList.toString()); 
        sortedList.insert(10); 
        sortedList.insert(30);
        sortedList.insert(50);
        System.out.println(sortedList.toString()); 
        
        sortedList.remove(); 
        System.out.println(sortedList.toString());
    }
}
