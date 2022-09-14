package QuickSort;

public class QuickSortApp {
    public static void main(String[] args) {
        int maxSize = 16;
        ArrayQuick arr;
        arr = new ArrayQuick(maxSize);
        for (int j = 0; j < maxSize; j++) {
            int n = (int) (java.lang.Math.random() * 99);
            arr.insert(n);
        }
        arr.display();
        arr.quickSort(0, arr.getSize() - 1);
        arr.display();
    }
}
