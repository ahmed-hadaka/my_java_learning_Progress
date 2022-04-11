package RecBinarySearch;

public class OrderedArray {

    private long[] arr;
    private int nElms;

    public OrderedArray(int size) {
        arr = new long[size];
        nElms = 0;
    }

    public int find(long searchKey) {
        return reFind(searchKey, 0, nElms - 1);
    }

    public int reFind(long value, int lowerBound, int upperBound) {
        int midPoint;
        midPoint = (lowerBound + upperBound) / 2;

        if (arr[midPoint] == value) {
            return midPoint;

        } else if (lowerBound == upperBound) {
            return -1;
        } else {

            if (arr[midPoint] > value)
                return reFind(value, lowerBound, midPoint - 1);
            else
                return reFind(value, midPoint + 1, upperBound);
        }

    }

    // insert
    public void insert(long value) {
        int j;
        for (j = 0; j < nElms; j++)
            if (arr[j] > value) // (linear search)
                break;
        for (int k = nElms; k > j; k--) // move bigger ones up
            arr[k] = arr[k - 1];
        arr[j] = value; // insert it
        nElms++; // increment size
    }

    // delete
    public void delete(long value) {
        int target = find(value);

        if (target != -1) {
            for (int i = target; i < nElms - 1; i++) {
                arr[i] = arr[i + 1];
            }
            nElms--;
            System.out.println("deleted successfully.");
        } else
            System.out.println("the item is not found!");

    }

    // display
    public void display() {
        for (int j = 0; j < nElms; j++)
            System.out.println(arr[j] + " ");
    }



}
