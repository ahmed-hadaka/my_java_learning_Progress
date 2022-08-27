package problems_java_DS.PriorityQueueWithAVL;

import java.util.Queue;
import java.util.Stack;

public class PriorityQueue {

	private Node root;

	// ------------------------------

	private Node search(int target, Node root) {
		if (root == null)
			return null;
		if (root.getPriority() == target)
			return root;
		if (target < root.getPriority())
			return search(target, root.getLeft());

		return search(target, root.getRight());
	}

	public Node search(int target) {
		return search(target, root);
	}

	// -------------------------

	private Node rightRotation(Node node) {
		Node newRoot = node.getLeft();
		Node temp = newRoot.getRight();

		newRoot.setRight(node);
		node.setLeft(temp);

		return newRoot;
	}

//-------------------------
	private Node leftRotation(Node node) {
		Node newRoot = node.getRight();
		Node temp = newRoot.getLeft();

		newRoot.setLeft(node);
		node.setRight(temp);

		return newRoot;
	}

//-----------------------------
	private Node rebalance(Node node) {
		if (node.balanceFactor() == 2) {
			if (node.getLeft().balanceFactor() == -1)
				node.setLeft(leftRotation(node.getLeft()));
			node = rightRotation(node);

		} else if (node.balanceFactor() == -2) {
			if (node.getRight().balanceFactor() == 1)
				node.setRight(rightRotation(node.getRight()));
			node = leftRotation(node);
		}
		return node;
	}
	// -----------------------------

	private Node insert(int value, int Priority, Node node) {

		if (Priority < node.getPriority()) {
			if (node.getLeft() == null)
				node.setLeft(new Node(Priority, value));
			else
				node.setLeft(insert(value, Priority, node.getLeft()));
		} else if (Priority > node.getPriority()) {
			if (node.getRight() == null)
				node.setRight(new Node(Priority, value));
			else
				node.setRight(insert(value, Priority, node.getRight()));
		} else { // same priority
			node.addValue(value);
		}
		node.update_height();
		return rebalance(node);
	}

	public void enqueue(int value, int Priority) {
		if (root == null)
			root = new Node(Priority, value);
		else {
			Node temp = search(Priority);
			if (temp != null)
				temp.addValue(value);
			else
				root = insert(value, Priority, root);
		}
	}
	// -----------------------------

	private Node delete(int Priority, Node node) {
		if (node == null)
			return null;
		if (Priority < node.getPriority())
			node.setLeft(delete(Priority, node.getLeft()));
		if (Priority > node.getPriority())
			node.setRight(delete(Priority, node.getRight()));
		else { // we found it
			if (node.getLeft() == null || node.getRight() == null) // this handle case of having one child and case of
																	// no child
				node = node.getLeft() == null ? node.getRight() : node.getLeft();
			else { // have two child
				Node temp = getMin(node.getRight());
				node.setPriority(temp.getPriority());
				node.setRight(delete(temp.getPriority(), node.getRight()));
			}
		}
		if (node != null) {
			node.update_height();
			return rebalance(node);
		}
		return node;
	}

	private Node getMin(Node node) {
		while (node != null && node.getLeft() != null)
			node = node.getLeft();
		return node;
	}

	public int dequeue() {
		Node cur = root;
		while (cur != null && cur.getRight() != null)
			cur = cur.getRight();
		int temp = cur.getFirstValue();
		if (cur.isEmpty())
			root = delete(cur.getPriority(), root);
		return temp;
	}

	// -----------------------------
	public void printValues(int priority) {
		Queue<Integer> values = search(priority).getValues();
		for (Integer value : values) {
			System.out.print(value + " ");
		}
	}

	// -----------------------------
	private void inOrder(Node start) {
		if (start != null) {
			inOrder(start.getLeft());
			System.out.print(start.getPriority() + " ");
			inOrder(start.getRight());
		}
	}

	public void inOrder() {
		inOrder(root);
		System.out.println();
	}

	public boolean isEmpty() {
		return root == null;
	}

	// -----------------------------
	public void display() {
		Stack<Node> globalStack = new Stack<>();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println("......................................................");
		while (!isRowEmpty) {
			Stack<Node> localStack = new Stack<>();
			isRowEmpty = true;
			for (int j = 0; j < nBlanks; j++)
				System.out.print(' ');
			while (!globalStack.isEmpty()) {
				Node temp = globalStack.pop();
				if (temp != null) {
					System.out.print(temp.getPriority());
					localStack.push(temp.getLeft());
					localStack.push(temp.getRight());
					if (temp.getLeft() != null || temp.getRight() != null)
						isRowEmpty = false;
				} else {
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for (int j = 0; j < nBlanks * 2 - 2; j++)
					System.out.print(' ');
			}
			System.out.println();
			nBlanks /= 2;
			while (!localStack.isEmpty())
				globalStack.push(localStack.pop());
		}
		System.out.println("......................................................");
	}
}
