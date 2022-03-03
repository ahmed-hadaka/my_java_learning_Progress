/**
 * advanced Bubble sort
 * Ahemd Hadaka
 * 
 * this class use the Bubble sort to sort array of primitive types,
 * unlike ArrayBub1 class, this class give a solution for this problem:
 * 
 * Q:- In the ArrayBub1.java program the in index always goes from left to
 * right, finding the largest item
 * and
 * carrying it toward out on the right. Modify the bubbleSort() method so that
 * it’s
 * bidirectional. This means the in index will first carry the largest item from
 * left
 * to right as before, but when it reaches out, it will reverse and carry the
 * smallest
 * item from right to left. You’ll need two outer indexes, one on the right (the
 * old
 * out) and another on the left
 */
class ArrayBub2 {
    private long[] a; // ref to array a
    private int nElems; // number of data items
    // --------------------------------------------------------------

    public ArrayBub2(int max) // constructor
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

    // Option 1 --------------------------------------------------
    public void bubbleSort() {
        int k = 0;
        for (int out = nElems - 1; out > k; out--) { // outer loop (backward)
            for (int in1 = out; in1 > k; in1--) { // first inner loop
                if (a[in1] < a[in1 - 1]) // finding the smallest item from rtl
                    swap(in1, in1 - 1);
            }
            k++; // decrement the area we search into
            for (int in2 = k; in2 < out; in2++) // second inner loop (forward)
                if (a[in2] > a[in2 + 1]) // out of order?
                    swap(in2, in2 + 1); // swap them

        }
    }

    // Option 2 --------------------------------------------------
    public void oddEvenSort() {
        boolean isFinished;
        do {
            isFinished = false;
            for (int i = 1; i < nElems - 1; i += 2) {
                if (a[i] > a[i + 1]) {
                    swap(i, i + 1);
                    isFinished = true;
                }
            }
            for (int j = 0; j < nElems; j += 2) {
                if (a[j] > a[j + 1]) {
                    swap(j, j + 1);
                    isFinished = true;
                }
            }

        } while (isFinished);
    }

    // --------------------------------------------------------------

    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }

}