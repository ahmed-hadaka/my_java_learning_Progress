package QuickSort;

public class ArrayQuick {
    private int[] a;
    private int nElems;

    public ArrayQuick(int max) {
        a = new int[max];
        nElems = 0;
    }

    public void insert(int value) {
        a[nElems] = value;
        nElems++;
    }

    public int getSize() {
        return nElems;
    }

    public void display() {
        for (int j = 0; j < nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println();
    }

    public void quickSort(int start, int end) {
        if (start < end) {
            int pivotIndex = partitionIt(start, end);
            quickSort(start, pivotIndex - 1);
            quickSort(pivotIndex + 1, end);
        }

    }

    public int partitionIt(int start, int end) {
        int i = start;
        int pivot = end;
        for (int j = start; j < nElems - 1; j++) {
            if (a[j] < a[pivot]) {
                swap(j, i);
                i++;
            }
        }
        swap(i, pivot);
        return i;
    }

    public void swap(int i, int j) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
