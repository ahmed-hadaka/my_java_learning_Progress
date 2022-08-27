package problems_java_DS;

import java.util.Stack;

public class AVLTree {

	private Node root;

	// ----------------

	private boolean search(int target, Node root) {
		if (root == null)
			return false;
		if (root.getData() == target)
			return true;
		if (target < root.getData())
			return search(target, root.getLeft());

		return search(target, root.getRight());
	}

	public boolean search(int target) {
		return search(target, root);
	}
	// ---------------------------------

	public Node rightRotation(Node node) {
		Node newRoot = node.getLeft();
		Node temp = newRoot.getRight();

		newRoot.setRight(node);
		node.setLeft(temp);

		return newRoot;
	}

//---------------------------------
	public Node leftRotation(Node node) {
		Node newRoot = node.getRight();
		Node temp = newRoot.getLeft();

		newRoot.setLeft(node);
		node.setRight(temp);

		return newRoot;
	}

//-----------------------------
	public Node rebalance(Node node) {
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

	private Node insert(int data, Node node) {

		if (data < node.getData()) {
			if (node.getLeft() == null)
				node.setLeft(new Node(data));
			else
				node.setLeft(insert(data, node.getLeft()));
		} else if (data > node.getData()) {
			if (node.getRight() == null)
				node.setRight(new Node(data));
			else
				node.setRight(insert(data, node.getRight()));
		}
		node.update_height();
		return rebalance(node);
	}

	public void insert(int data) {
		if (root == null)
			root = new Node(data);
		else
			root = insert(data, root);
	}
	// -----------------------------

	private Node delete(int data, Node node) {
		if (node == null)
			return null;
		if (data < node.getData())
			node.setLeft(delete(data, node.getLeft()));
		if (data > node.getData())
			node.setRight(delete(data, node.getRight()));
		else { // we found it
			if (node.getLeft() == null || node.getRight() == null) // this handle case of having one child and case of
																	// no child
				node = node.getLeft() == null ? node.getRight() : node.getLeft();
			else { // have two child
				Node temp = getMin(node.getRight());
				node.setData(temp.getData());
				node.setRight(delete(temp.getData(), node.getRight()));
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

	public void delete(int iData) {
		root = delete(iData, root);
	}

	// -----------------------------
	private int lowerBound(int val, Node root) {
		if (root == null)
			return -1;
		if (val < root.getData()) {
			int l = lowerBound(val, root.getLeft());
			if (l != -1)
				return l;
		} else if (val > root.getData()) {
			int r = lowerBound(val, root.getRight());
			if (r != -1)
				return r;
		}
		if (root.getData() >= val)
			return root.getData();
		return -1;
	}

	public int lowerBound(int val) {
		return lowerBound(val, root);
	}
	// ----------------

	private int upperBound(int val, Node root) {
		if (root == null)
			return -1;
		if (val < root.getData()) {
			int l = upperBound(val, root.getLeft());
			if (l != -1)
				return l;
		} else if (val > root.getData()) {
			int r = upperBound(val, root.getRight());
			if (r != -1)
				return r;
		}
		if (root.getData() > val)
			return root.getData();
		return -1;
	}

	public int upperBound(int val) {
		return upperBound(val, root);
	}

	// -----------------------------
	private void inOrder(Node start) {
		if (start != null) {
			inOrder(start.getLeft());
			System.out.print(start.getData() + " ");
			inOrder(start.getRight());
		}
	}

	public void inOrder() {
		inOrder(root);
		System.out.println();
	}

	// -----------------------------

	public int countInversion(int[] arr) {
		int c = 0;
		for (int i = 0; i < arr.length; i++) {
			insert(arr[i]);
			c += countGreater(arr[i], root);
		}
		return c;
	}

	private int countGreater(int val, Node node) {
		int c = 0;
		while (val != node.getData()) {
			if (val < node.getData()) {
				c += (count(node.getRight()) + 1);
				node = node.getLeft();
			} else if (val > node.getData()) {
				node = node.getRight();
			}
		}
		if (val == node.getData() && node.getRight() != null)
			c += count(node.getRight());
		return c;
	}

	private int count(Node node) {
		if (node == null)
			return 0;
		return 1 + count(node.getLeft()) + count(node.getRight());
	}

	// -----------------------------

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
					System.out.print(temp.getData());
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
