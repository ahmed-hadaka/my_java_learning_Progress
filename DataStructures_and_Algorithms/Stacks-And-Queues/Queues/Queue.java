package Queues;

public class Queue {

    private int front = 0,
            rear = -1,
            nElems = 0;
    private final int size;
    private final long[] arr;

    public Queue(int size) {
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
    
//Programmming Project 4.1
    public void displayContent() {
	
		int i;
		for(i=front; i!=rear; i=(i+1)%size) {
			System.out.println(arr[i] + " ");
		}
		System.out.print(arr[i] + " ");
		System.out.println();
    }
}
