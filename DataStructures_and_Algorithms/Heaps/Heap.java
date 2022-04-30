public class Heap {
    private final Node[] heapArray;
    private final int maxSize;
    private int currentSize;

    public Heap(int maxSize) {
        this.maxSize = maxSize;
        this.currentSize = 0;
        heapArray = new Node[maxSize];
    }

    public boolean isEmpty() {
        return (currentSize == 0);
    }

    public boolean isFull() {
        return (currentSize == maxSize);
    }

    public boolean insert(int key) {
        if (isFull())
            return false;
        Node newN = new Node(key);
        heapArray[currentSize] = newN;
        trickleUp(currentSize++);
        return true;
    }

    public Node remove() {
        if (isEmpty())
            return null;
        Node removed = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return removed;
    }

    public boolean change(int index, int newValue) {
        if (index < 0 || index >= currentSize)
            return false;
        int oldValue = heapArray[index].getKey();
        heapArray[index].setKey(newValue);
        if (oldValue > newValue)
            trickleDown(index);
        else
            trickleUp(index);
        return true;
    }

    public void trickleUp(int index) {
        int parent = (index - 1) / 2;
        Node bottom = heapArray[index];
        while (index > 0 && heapArray[parent].getKey() < bottom.getKey()) {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (index - 1) / 2;
        }
        heapArray[index] = bottom;
    }

    public void trickleDown(int index) {
        int largestChild;
        Node top = heapArray[index];
        while (index < currentSize / 2) {  // if the node has at least one child
            int leftChild = index * 2 + 1;
            int rightChild = leftChild + 1;
            if (rightChild < currentSize && heapArray[rightChild].getKey() >= heapArray[leftChild].getKey())
                largestChild = rightChild;
            else
                largestChild = leftChild;
            if (top.getKey() >= heapArray[largestChild].getKey())
                break;
            heapArray[index] = heapArray[largestChild];
            index = largestChild;
        }
        heapArray[index] = top;
    }

    public void display() {
        System.out.print("heapArray: ");
        for (int m = 0; m < currentSize; m++)
            if (heapArray[m] != null)
                System.out.print(heapArray[m].getKey() + " ");
            else
                System.out.print("-- ");
        System.out.println();
        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;
        String dots = "...............................";
        System.out.println(dots + dots);
        while (currentSize > 0) {
            if (column == 0) // first item in row?
                for (int k = 0; k < nBlanks; k++) // preceding blanks
                    System.out.print(' ');
            System.out.print(heapArray[j].getKey());
            if (++j == currentSize) // done?
                break;
            if (++column == itemsPerRow) // end of row?
            {
                nBlanks /= 2; // half the blanks
                itemsPerRow *= 2; // twice the items
                column = 0; // start over on
                System.out.println(); // new row
            } else // next item on row
                for (int k = 0; k < nBlanks * 2 - 2; k++)
                    System.out.print(' '); // interim blanks
        }
        System.out.println("\n" + dots + dots);
    }
}
