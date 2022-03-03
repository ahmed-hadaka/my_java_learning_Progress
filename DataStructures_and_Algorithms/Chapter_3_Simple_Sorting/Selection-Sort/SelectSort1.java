/**
 * Selection Sort
 * Ahemd Hadaka
 * 
 * this class use the normal Selection sort to sort array of primitive types,
 * unlike SelectSort2.java class
 */

class SelectSort1 {
    private long[] a; // ref to array a
    private int nElems; // number of data items
    // --------------------------------------------------------------

    public SelectSort1(int max) // constructor
    {
        a = new long[max]; // create the array
        nElems = 0; // no items yet
    }

    // --------------------------------------------------------------
    public void insert(long value) // put element into array
    {
        a[nElems] = value; // insert it
        nElems++; // increment size
    }

    // --------------------------------------------------------------
    public void display() // displays array contents
    {
        for (int j = 0; j < nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println("");
    }

    // --------------------------------------------------------------
    public void selectSort() {
        int in, out;
        for (out = 0; out < nElems - 1; out++) {
            int min = out;
            for (in = out + 1; in < nElems; in++)
                if (a[in] < a[min])
                    min = in;
            swap(out, min);
        }
    }
    // --------------------------------------------------------------

    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}