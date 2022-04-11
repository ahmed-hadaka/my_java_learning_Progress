package SortedList;

/**
 *
 * @AhmedHadaka
 */
public class ListInsertionSortApp {

    public static void main(String[] args) {
        int size = 10;
        Node[] linkArray = new Node[size];
        
        for (int j = 0; j < size; j++) {  // fill array
            int n = (int) (java.lang.Math.random() * 99);
            Node newLink = new Node(n);
            linkArray[j] = newLink;
        }
        System.out.print("Unsorted array: "); // display unsorted array
        for (int j = 0; j < size; j++) {
            System.out.print(linkArray[j].getIData() + " ");
        }
        System.out.println("");

        SortedList theSortedList = new SortedList(linkArray); // sort array
        for (int j = 0; j < size; j++) { // move sorted array to linkArray
            linkArray[j] = theSortedList.remove();
        }
        System.out.print("Sorted Array: "); // display sorted array
        for (int j = 0; j < size; j++) {
            System.out.print(linkArray[j].getIData() + " ");
        }
        System.out.println("");

    }
}
