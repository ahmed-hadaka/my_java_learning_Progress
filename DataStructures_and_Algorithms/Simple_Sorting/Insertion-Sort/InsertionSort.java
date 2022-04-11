/*
 * Insertion Sort
 * Ahemd Hadaka
 * 
 * this class use the normal Insertion sort to sort array of primitive types
 * using arrays as a data storage
 */

public class InsertionSort {
    private long[] a;
    private int nElems;

    public InsertionSort(int max)
    {
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value)
    {
        a[nElems] = value;
        nElems++;

    public void display()
    {
        for (int j = 0; j < nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println("");
    }

    public void insertionSort() {
        int in, out, numCopys = 0, numComp = 0;
        for (out = 1; out < nElems; out++) {
            for (in = out; in > 0; in--) {
                numComp++;
                if (a[in] < a[in - 1]) {
                    swap(in, in - 1);
                    numCopys += 3;
                } else
                    break;
            }
        }
        System.out.print(
                "sorted sucessfully\n number of copys is: " + numCopys + "\n number of comparisons is: " + numComp
                        + "\n");
    }

    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }

    public double median() {
        double median;
        if (nElems % 2 == 0) {
            median = ((a[nElems / 2]) + (a[nElems / 2 - 1])) / 2d; // 2d prefix for double
            return median;
        } else
            return a[nElems / 2];
    }

    // --------------------------------------------------------------
    /**
     * Here’s an interesting way to remove duplicates from an array. The insertion
     * sort
     * uses a loop-within-a-loop algorithm that compares every item in the array
     * with
     * every other item. If you want to remove duplicates, this is one way to start.
     * Modify the insertionSort() method in
     * the
     * insertSort.java program so that it removes duplicates as it sorts. Here’s one
     * approach: When a duplicate is found, write over one of the duplicated items
     * with a key value less than any normally used (such as –1, if all the normal
     * keys
     * are positive). Then the normal insertion sort algorithm, treating this new
     * key
     * like any other item, will put it at index 0. From now on the algorithm can
     * ignore this item. The next duplicate will go at index 1, and so on. When the
     * sort is finished, all the removed dups (now represented by –1 values) will be
     * found at the beginning of the array. The array can then be resized and
     * shifted
     * down so it starts at 0
     */
    public void noDups_InSortedArr() {
        int nomOfDup = 0;
        for (int i = 0; i < nElems - 1; i++) { // find duplicated item and change it's value to -1.
            if (a[i] == a[i + 1]) {
                a[i + 1] = -1;
                nomOfDup++;
            }
        }
        int cons = nElems - nomOfDup;
        if (nomOfDup != 0) { // have duplicated item
            insertionSort(); // to make items with value -1 at first.
            for (int j = 0; j < cons; j++) { // shifting items
                a[j] = a[nomOfDup];
                nomOfDup++;
            }
            nElems = cons; // update nElems.
        }

    }
}
