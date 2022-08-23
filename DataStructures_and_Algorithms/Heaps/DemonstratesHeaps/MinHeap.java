package problems_java_DS;

/*
 * Heap implementation ( min heap )
 *
 * @ Ahmed_Hadaka
 * */

public class MinHeap {
	private Node[] heapArray;
	private int maxSize;
	private int currentSize;

	public MinHeap(int maxSize) {
		this.maxSize = maxSize;
		this.currentSize = 0;
		heapArray = new Node[maxSize];
	}

	public boolean isEmpty() {
		return (currentSize == 0);
	}

	public boolean isFull() {
		return (currentSize == maxSize);
	}

	public boolean insert(int key) { // o(h) ~ o(logn), because it's a complete tree
		if (isFull())
			return false;
		Node newN = new Node(key);
		heapArray[currentSize] = newN;
		trickleUp(currentSize++);
		return true;
	}

	public int remove() { // o(h) ~ o(logn)
		if (isEmpty())
			return -1;
		Node removed = heapArray[0];
		heapArray[0] = heapArray[--currentSize];
		trickleDown(0);
		return removed.getValue();
	}

	public int peek() {
		return heapArray[0].getValue();
	}

	public boolean change(int index, int newValue) {
		if (index < 0 || index >= currentSize)
			return false;
		int oldValue = heapArray[index].getValue();
		heapArray[index].setValue(newValue);
		if (oldValue < newValue)
			trickleDown(index);
		else
			trickleUp(index);
		return true;
	}

	private void trickleUp(int index) { // o(h) ~ o(logn)
		int parent = (index - 1) / 2;
		Node bottom = heapArray[index];
		while (index > 0 && heapArray[parent].getValue() > bottom.getValue()) {
			heapArray[index] = heapArray[parent];
			index = parent;
			parent = (parent - 1) / 2;
		}
		heapArray[index] = bottom;
	}

	private void trickleDown(int index) { // o(h) ~ o(logn)
		int smallestValue;
		Node top = heapArray[index];
		while (index < currentSize / 2) { // while the current node has at least one child
			int leftValue = index * 2 + 1;
			int rightValue = leftValue + 1;
			// (rightValue < currentSize) i.e, if has right child
			if (rightValue < currentSize && heapArray[rightValue].getValue() <= heapArray[leftValue].getValue())
				smallestValue = rightValue;
			else
				smallestValue = leftValue;
			if (top.getValue() <= heapArray[smallestValue].getValue())
				break;
			heapArray[index] = heapArray[smallestValue];
			index = smallestValue;
		}
		heapArray[index] = top;
	}

// -------------- homework ------------------------
	public void printLessThanMe(int val) {
		printLessThanMe(val, 0);
	}

	private void printLessThanMe(int val, int child) {
		if (child >= currentSize || heapArray[child].getValue() >= val)
			return;
		System.out.print(heapArray[child].getValue() + " ");
		printLessThanMe(val, 2 * child + 1);
		printLessThanMe(val, 2 * child + 2);
	}
//-----------------------------------------

	public boolean isMinHeap(int[] arr) {
		return isMinHeap(arr, 0);
	}

	private boolean isMinHeap(int[] arr, int parent) {
		if (parent >= arr.length)
			return true;

		int left = 2 * parent + 1;
		int right = left + 1;

		if (left < arr.length && arr[left] < arr[parent] || right < arr.length && arr[right] < arr[parent])
			return false;

		boolean l = isMinHeap(arr, left);
		if (!l)
			return l;
		boolean r = isMinHeap(arr, right);
		if (!r)
			return r;
		return l && r;
	}

	public void display() {
		System.out.print("heapArray: ");
		for (int m = 0; m < currentSize; m++)
			if (heapArray[m] != null)
				System.out.print(heapArray[m].getValue() + " ");
			else
				System.out.print("-- ");
		System.out.println();
		int nBlanks = 32;
		int itemsPerRow = 1;
		int column = 0;
		int j = 0;
		String dots = "...............................";
		System.out.println(dots + dots);
		while (currentSize > 0) {
			if (column == 0) // first item in row?
				for (int k = 0; k < nBlanks; k++) // preceding blanks
					System.out.print(' ');
			System.out.print(heapArray[j].getValue());
			if (++j == currentSize) // done?
				break;
			if (++column == itemsPerRow) // end of row?
			{
				nBlanks /= 2; // half the blanks
				itemsPerRow *= 2; // twice the items
				column = 0; // start over on
				System.out.println(); // new row
			} else // next item on row
				for (int k = 0; k < nBlanks * 2 - 2; k++)
					System.out.print(' '); // interim blanks
		}
		System.out.println("\n" + dots + dots);
	}
}
