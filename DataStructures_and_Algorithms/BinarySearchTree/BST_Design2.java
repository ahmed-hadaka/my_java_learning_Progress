package problems_java_DS;

public class BST_Design2 {

	class Node {
		int data;
		Node left;
		Node right;
		Node parent; // new

		public Node(int data, Node parent) {
			this.data = data;
			this.parent = parent;
		}
	}

	Node root;
	// ------------------------------------------

	private void insert(int data, Node root) { // O(h)Time and memory, where h is the height of the tree
		if (data < root.data) {
			if (root.left == null)
				root.left = new Node(data, root);
			else
				insert(data, root.left);
		} else if (data > root.data) {
			if (root.right == null)
				root.right = new Node(data, root);
			else
				insert(data, root.right);
		} // else : it's already exist
	}

	public void insert(int data) {
		if (root == null)
			root = new Node(data, null);
		else
			insert(data, root);
	}

// ------------------------------------------------
	private Node find(int key, Node root) {
		if (root.data == key)
			return root;
		if (root.left != null && key <= root.data)
			return find(key, root.left);
		if (root.right != null && key > root.data)
			return find(key, root.right);
		return null;
	}

	public Node find(int key) {
		if (root == null)
			return null;
		return find(key, root);
	}
// ------------------------------------------------

	public int successor(int key) { // assumes that target is exist
		Node target = find(key);
		if (target == null)
			return -1;
		if (target.right != null)
			return getMin(target.right).data;
		while (target.parent != null && target.parent.data < target.data)
			target = target.parent;
		if (target.parent != null)
			return target.parent.data;
		return -1;

	}

	private Node getMin(Node root) {
		while (root != null && root.left != null) {
			root = root.left;
		}
		return root;
	}

}
