package problems_java_DS;

public class Node {
	private int data;
	private Node left;
	private Node right;
	private int height;

	public Node(int key) {
		this.data = key;
		this.height = 0;
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

	public int getData() {
		return data;
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

	public void setData(int data) {
		this.data = data;
	}

}
