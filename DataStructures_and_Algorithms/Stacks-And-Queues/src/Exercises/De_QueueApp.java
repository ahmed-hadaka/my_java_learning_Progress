package Exercises;

/**
 * DEQueue_implementaion
 *
 * @AhmedHadaka
 */
public class De_QueueApp {

    public static void main(String[] args) {

        De_Queue dc = new De_Queue(6);
        dc.insertLeft(1);
        dc.insertLeft(4);
        dc.insertLeft(9);
        dc.insertLeft(14);
        dc.insertLeft(8);

        dc.display();

    }
}

class De_Queue {

    int head = -1, tail = -1, size, nElems = 0;
    int[] arr;

    public De_Queue(int size) {
        this.size = size; // don't forget this
        arr = new int[size];
    }

    public void insertRight(int value) {
        if (!isFull()) {
            if (head == -1) {
                head = tail = 0;
            } else {
                tail = ++tail % size;
            }
            arr[tail] = value;
            nElems++;
        } else {
            System.out.println("The Queue Is Full");
        }
    }

    public void insertLeft(int value) {
        if (!isFull()) {
            switch (head) {
                case -1:
                    head = tail = 0;
                    break;
                case 0:
                    head = (size - 1);
                    break;
                default:
                    head--;
            }
            arr[head] = value;
            nElems++;
        } else {
            System.out.println("The Queue Is Full");
        }
    }

    public int deleteLeft() {
        if (!isEmpty()) {
            int deletedItem = arr[head];
            head = ++head % size;
            nElems--;
            return deletedItem;
        }
        return -1;
    }

    int deleteRight() {
        if (!isEmpty()) {
            int deletedItem = arr[tail];
            if (tail == 0) {
                tail = size;
            }
            tail--;
            nElems--;
            return deletedItem;
        }
        return -1;
    }

    public boolean isFull() {
        return (nElems == size);
    }

    boolean isEmpty() {
        return (nElems == 0);
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.println(arr[head]);
            head++;
            if (head == size) {
                head = 0;
            }
        }
    }
}
