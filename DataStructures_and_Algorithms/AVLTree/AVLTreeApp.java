package problems_java_DS;

public class AVLTreeApp {
	public static void main(String[] args) {
		AVLTree tree = new AVLTree();
		tree.insert(1);
		tree.insert(3);
		tree.insert(2);
		tree.display();

		tree.insert(3);
//		tree.insert(12);
//		tree.insert(6);

		tree.inOrder();
		tree.display();
	}
}
