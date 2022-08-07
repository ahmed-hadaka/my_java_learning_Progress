package problems_java_DS;

/*
 *
 * @AhmedHadaka;
 */
public class StackX {

	private int[] stackArray;
	int top;
	int maxSize;

	public StackX(int size) {
		top = -1;
		maxSize = size;
		stackArray = new int[maxSize];
	}

	public void push(int value) {
		if (!isFull())
			stackArray[++top] = value;
	}

	public int pop() {
		if (!isEmpty())
			return stackArray[top--];
		return -1;
	}

	public int peek() {
		if (!isEmpty())
			return stackArray[top];
		return -1;
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top == maxSize - 1);
	}

	public void display() {
		while (!isEmpty()) {
			System.out.println(pop());
		}
	}
	// ************* extend functionality ******************//

	public void insertBottom(int val) {
		if (isEmpty()) {
			push(val);
			return;
		}

		int cur = pop();
		insertBottom(val);
		push(cur);
	}

	public void reverse() {
		if (isEmpty())
			return;

		int cur = pop();
		reverse();
		insertBottom(cur);
	}

}
