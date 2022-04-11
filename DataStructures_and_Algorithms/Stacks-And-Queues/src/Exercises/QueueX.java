package Exercises;

/**
 *
 * AhmedHadaka;
 */
public class QueueX {

    private int front = 0,
            rear = -1,
            nElems = 0;
    private int size;
    private long[] arr;

    public QueueX(int size) {
        this.size = size;
        arr = new long[size];
    }

    public void insert(long value) {
        if (!isFull()) {
            if (rear == size - 1) {
                rear = -1;
            }
            arr[++rear] = value;
            nElems++;
        } else {
            System.out.println("Can't add more items, The stack is full");
        }
    }

    public long remove() {
        if (!isEmpty()) {
            long removedValue = arr[front++];

            if (front == size) {
                front = 0;
            }
            nElems--;
            return removedValue;

        }
        return -1;
    }

    public long peakFront() {
        return arr[front];
    }

    public boolean isEmpty() {
        return (nElems == 0);
    }

    public boolean isFull() {
        return (nElems == size);
    }

}
