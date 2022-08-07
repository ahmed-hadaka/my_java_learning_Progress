package Exercises;

/**
 *
 * AhmedHadaka;
 */
public class StackX {

    private int[] stackArray;
    int top = -1;
    int maxSize;

    // constructor
    public StackX(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
    }

    // push
    public void push(int value) {
            stackArray[++top] = value;
    }

    // pop
    public int pop() {
            return stackArray[top--];    
    }

    // peek
    public int peek() {
        return stackArray[top];
    }

    // isEmpty
    public boolean isEmpty() {
        return (top == -1);
    }

    // isFull
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    // display
    public void display() {
        while (!isEmpty()) {
            System.out.println(pop());
        }
    }
}
