class BubbleSortApp {
    public static void main(String[] args) {
        int maxSize = 100; // array size
        ArrayBub2 arr;
        arr = new ArrayBub2(maxSize); // create the array
        arr.insert(77); // insert 10 items
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);
        arr.display(); // display items
        // arr.bubbleSort(); // bubble sort option 1
        arr.oddEvenSort(); // Odd Even sort option 2
        arr.display();
    }
}