public class HighArray {
    private long[] a;
    private int nElems;

    public HighArray(int size) {
        a = new long[size];
        nElems = 0;
    }

    // main find()
    public Integer find(long value) {
        for (int i = 0; i < nElems; i++) {
            if (a[i] == value)
                return i;
        }

        return null;
    }

    // special find()

    public Integer findDuplicated(long value, int startInd) {
        for (int i = startInd; i < nElems; i++) {
            if (a[i] == value)
                return i;
        }

        return null;
    }

    public void insert(long value) {
        if (nElems == a.length) {
            System.out.println("Array is full, can't insert!");
        } else {
            a[nElems] = value;
            nElems++;
            System.out.println("Added Successfully.");
        }
    }

    // main delete
    public String delete(long value) {
        Integer result = find(value);
        if (result != null) {
            for (int i = result; i < nElems - 1; i++) {
                a[i] = a[i + 1];
            }
            nElems--;
            return (value + " was Deleted.");
        } else
            return ("The Value: " + value + " Not Found.");

    }

    // special delete method
    public String deleteDuplicated(long value, int startInd) {
        Integer result = findDuplicated(value, startInd);
        if (result != null) {
            for (int i = result; i < nElems - 1; i++) {
                a[i] = a[i + 1];
            }
            nElems--;
            return (value + " was Deleted.");
        } else
            return ("The Value: " + value + " Not Found.");

    }

    public void display() {
        for (int j = 0; j < nElems; j++)
            System.out.println(a[j] + " ");
    }

    public long getMax() {
        long max = 0;
        for (int j = 0; j < nElems - 1; j++)
            if (a[j] > a[j + 1] && a[j] > max) {
                max = a[j];
            } else if (a[j] < a[j + 1] && a[j + 1] > max) {
                max = a[j + 1];
            }
        return max;
    }

    public void removeMax() {
        long max = getMax();
        delete(max);
    }

    public void noDups() {
        for (int j = 0; j < nElems - 1; j++) {
            for (int i = j + 1; i < nElems; i++) {
                if (a[j] == a[i]) {
                    deleteDuplicated(a[i], i);
                    i--;
                }

            }

        }
    }

}
