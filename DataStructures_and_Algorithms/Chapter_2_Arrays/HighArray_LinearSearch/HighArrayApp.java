public class HighArrayApp {
    public static void main(String[] args) {
        int maxSize = 100; // array size
        HighArray arr; // reference to array
        arr = new HighArray(maxSize); // create the array
        arr.insert(77);
        arr.insert(99);
        arr.insert(77);
        arr.insert(55);
        arr.insert(2);
        arr.insert(88);
        arr.insert(99);
        arr.insert(55);
        arr.insert(0);
        arr.insert(99);
        arr.insert(66);
        arr.insert(88);
        arr.insert(77);
        arr.insert(88);
        arr.display();
        int searchKey = 99; // search for item
        if (arr.find(searchKey) != null)
            System.out.println(searchKey + " Is Found " + "In index: " + arr.find(searchKey));
        else
            System.out.println("Can't find " + searchKey);
        arr.delete(0);

        arr.display(); // display items again
        System.out.println(arr.getMax());
        arr.removeMax();
        System.out.println(" ");
        arr.display();
        System.out.println(" ");
        arr.noDups();
        arr.display();
    } // end main()
} // end class HighArrayApp
