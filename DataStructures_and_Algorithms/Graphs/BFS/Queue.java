package BFS;

public class Queue {

    private int front = 0,
            rear = -1,
            nElems = 0;
    private final int SIZE;
    private final int[] ARRAY;

    public Queue(int SIZE) {
        this.SIZE = SIZE;
        ARRAY = new int[SIZE];
    }

    public void insert(int value) {
        if (!isFull()) {
            if (rear == SIZE - 1) {
                rear = -1;
            }
            ARRAY[++rear] = value;
            nElems++;
        }
    }

    public int remove() {
        if (!isEmpty()) {
            int removedValue = ARRAY[front++];

            if (front == SIZE) {
                front = 0;
            }
            nElems--;
            return removedValue;

        }
        return -1;
    }

    public boolean isEmpty() {
        return (nElems == 0);
    }

    public boolean isFull() {
        return (nElems == SIZE);
    }

}
