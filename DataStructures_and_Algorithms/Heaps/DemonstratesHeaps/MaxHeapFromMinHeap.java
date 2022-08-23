package problems_java_DS;

public class MaxHeapFromMinHeap {

	MinHeap min;

	public MaxHeapFromMinHeap(int size) {
		min = new MinHeap(size);
	}

	public void insert(int data) {
		min.insert(-data);
	}

	public int remove() {
		return -min.remove();
	}

	public int peek() {
		return -min.peek();
	}

	public void display() {
		min.display();
	}

	public boolean isFull() {
		return min.isFull();
	}

	public boolean isEmpty() {
		return min.isEmpty();
	}

	// -------------- medium ---------

	public void KthSmallestNum(int val) {
		if (!isFull())
			insert(val);
		else if (val < peek()) {
			remove();
			insert(val);
		}
		System.out.println(peek());
	}

}
