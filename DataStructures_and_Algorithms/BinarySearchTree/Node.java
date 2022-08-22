package problems_java_DS;

public class Node {
	int iData;
	Node leftChild;
	Node rightChild;

	public Node(int iData) {
		this.iData = iData;
	}

	public int getIData() {
		return iData;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

}
