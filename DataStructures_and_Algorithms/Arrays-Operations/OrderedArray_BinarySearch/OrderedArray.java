public class OrderedArray {
    private long[] mainArr;
    private int mainNElems;

    public OrderedArray(int size) {
        mainArr = new long[size];
        mainNElems = 0;
    }

    // find
    public int find(long value) {
        int lowerBound = 0,
                upperBound = mainNElems - 1;
        int midPoint;

        while (lowerBound <= upperBound) {
            midPoint = (lowerBound + upperBound) / 2;

            if (mainArr[midPoint] == value) {
                return midPoint;

            } else if (mainArr[midPoint] > value)
                upperBound = midPoint - 1;

            else
                lowerBound = midPoint + 1;
        }

        return -1;
    }

    // insert
    public void insert(long value) {
        int j;
        for (j = 0; j < mainNElems; j++)
            if (mainArr[j] > value) // (linear search)
                break;
        for (int k = mainNElems; k > j; k--) // move bigger ones up
            mainArr[k] = mainArr[k - 1];
        mainArr[j] = value; // insert it
        mainNElems++; // increment size
    }

    // delete
    public void delete(long value) {
        int target = find(value);

        if (target != -1) {
            for (int i = target; i < mainNElems - 1; i++) {
                mainArr[i] = mainArr[i + 1];
            }
            mainNElems--;
            System.out.println("deleted successfully.");
        } else
            System.out.println("the item is not found!");

    }

    // display
    public void display() {
        for (int j = 0; j < mainNElems; j++)
            System.out.println(mainArr[j] + " ");
    }

    // merge
    public long[] merge(long[] arr) {
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
        return mainArr;
    }
}
