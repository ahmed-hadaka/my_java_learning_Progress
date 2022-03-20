package Exercises;

/**
 * Write a program with a revised PriorityQ that has fast O(1) insertion time
 * but slower removal of the high priority item (highest priority is the
 * smallest one )
 *
 * @AhmedHadaka
 */
public class Reversed_PriorityQueueApp {

    public static void main(String[] args) {
        Reversed_PriorityQueue ReversedPQ = new Reversed_PriorityQueue(5);

        ReversedPQ.insert(11);
        ReversedPQ.insert(8);
        ReversedPQ.insert(7);
        ReversedPQ.insert(9);
        ReversedPQ.insert(12);

        ReversedPQ.display();
        System.out.println();

        while(!ReversedPQ.isEmpty()) {
            System.out.println( ReversedPQ.remove());
        }
    }
}

class Reversed_PriorityQueue {

    private int nElems = 0, size;
    private int arr[];

    public Reversed_PriorityQueue(int size) {
        this.size = size;
        arr = new int[size];
    }

//insert O(1)
    public void insert(int value) {
        if (!isFull()) {
            arr[nElems++] = value;
        } else {
            System.out.println("Array is full");
        }
    }

    // remove O(n)
    public int remove() {
        if (!isEmpty()) {
            int index = 0, temp = arr[0];
            for (int i = 1; i < nElems; i++) { // find the smallest item
                if (arr[i] < temp) {
                    temp = arr[i];
                    index = i;
                }
            }
            for (int j = index; j < nElems - 1; j++) { // shifting items
                arr[j] = arr[j + 1];
            }
            nElems--;
            return temp;
        }
        return -1;
    }

    public boolean isFull() {
        return (nElems == size);
    }

    public boolean isEmpty() {
        return (nElems == 0);
    }

    public void display() {
        if (!isEmpty()) {
            for (int i = 0; i < nElems; i++) {
                System.out.println(arr[i]);
            }
        }
    }
}
