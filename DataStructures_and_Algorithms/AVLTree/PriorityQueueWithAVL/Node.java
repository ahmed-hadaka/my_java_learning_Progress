package problems_java_DS.PriorityQueueWithAVL;

import java.util.LinkedList;
import java.util.Queue;

public class Node {
	private int priority;
	private Node left;
	private Node right;
	private int height;
	private Queue<Integer> queue;

	public Node(int priority, int value) {
		this.priority = priority;
		this.height = 0;
		queue = new LinkedList<>();
		queue.add(value);
	}

	private int childHeight(Node node) { // child height
		return node != null ? node.getHeight() : -1;
	}

	public void update_height() { // call in end of insert function
		height = 1 + Math.max(childHeight(left), childHeight(right));
	}

	public int balanceFactor() {
		return childHeight(left) - childHeight(right);
	}

	public int getPriority() {
		return priority;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int getHeight() {
		return height;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public void addValue(int value) {
		queue.add(value);
	}

	public int getFirstValue() {
		return queue.poll();
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}

	public Queue<Integer> getValues() {
		return queue;
	}

}
