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

	public void setData(int data) {
		iData = data;
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

//	public void insert(int iData) {
//		if (iData >= this.iData) {
//			if (this.getRightChild() == null) { // base case
//				this.setRightChild(new Node(iData));
//			} else
//				this.getRightChild().insert(iData);
//		} else {
//			if (this.getLeftChild() == null) { // base case
//				this.setLeftChild(new Node(iData));
//			} else
//				this.getLeftChild().insert(iData);
//		}
//	}

//	public Node find(int iData) {
//		if (iData == this.iData)
//			return this;
//		if (iData > this.iData && this.getRightChild() != null)
//			return this.getRightChild().find(iData);
//		if (iData < this.iData && this.getLeftChild() != null)
//			return this.getLeftChild().find(iData);
//		return null; // not found
//	}

}
