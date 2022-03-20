 package Stacks.ReversWord;

public class StackX {
    private char[] stackArray;
    int top = -1;
    int maxSize;

    // constructor
    public StackX(int size) {
        maxSize = size;
        stackArray = new char[maxSize];
    }

    // push
    public void push(char value) {
        stackArray[++top] = value;
        return;
    }

    // pop
    public char pop() {

        return stackArray[top--];
    }

    // peek
    public char peek() {
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
}
