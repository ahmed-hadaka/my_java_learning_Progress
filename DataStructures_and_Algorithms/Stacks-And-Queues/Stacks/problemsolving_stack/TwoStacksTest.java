package problems_java_DS;

/*
 * Change our class to be able to perform the stack operations but simulating 2
stacks in same time. Consider the following constraints
 Use only the same single array
 All operations should have the same old time/memory complexity
 Each stack can use as much as possible of available array
 For example, assume we created stack of 100 elements
 The first stack used 20 elements so far
 Then the second stack can use up to 80 elements and so on
 Change functions similar to following: void push(int id, int x)
 Id either 1 or 2 to refer to the stack itself
*/

// all functions O(1) Time and space complexity except display fun has O(n) Time
// constructor have O(n) memory complexity

public class TwoStacksTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoStacks ts = new TwoStacks(10);
		ts.push(2, 5);
		ts.push(2, 6);
		ts.push(2, 4);
		ts.pop(2);
		ts.push(1, 9);
		ts.push(1, 10);

		ts.display();
	}
}

class TwoStacks {
	private int[] stackArray;
	int top;
	int last;
	int maxSize;

	public TwoStacks(int size) {
		top = -1;
		last = size;
		maxSize = size;
		stackArray = new int[maxSize];
	}

	public void push(int id, int value) {
		if (!isFull()) {
			if (id == 1)
				stackArray[++top] = value;
			else {
				stackArray[--last] = value;
			}
		}
	}

	public int pop(int id) {
		if (!isEmpty()) {
			if (id == 1)
				return stackArray[top--];
			return stackArray[last++];
		}
		return -1;
	}

	public int peek(int id) {
		if (!isEmpty()) {
			if (id == 1)
				return stackArray[top];
			return stackArray[last];
		}
		return -1;
	}

	public boolean isEmpty() {
		return (top == -1 && last == maxSize);
	}

	public boolean isFull() {
		return (top + 1 == last);
	}

	public void display() {
		while (top >= 0) {
			System.out.print(stackArray[top--] + " ");
		}

		System.out.println();
		while (last < maxSize) {
			System.out.print(stackArray[last++] + " ");
		}
	}
}
