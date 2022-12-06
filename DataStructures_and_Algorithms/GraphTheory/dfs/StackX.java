package dfs;

public class StackX {

	private final int[] stackArray;
	private int top = -1;

	public StackX(int maxSiz) {
		stackArray = new int[maxSiz];
	}

	public void push(int value) {
		stackArray[++top] = value;
	}

	public int pop() {
		return stackArray[top--];
	}

	public int peek() {
		return stackArray[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

}
