package problems_java_DS;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
//		BinaryTree tree = new BinaryTree(1);
//		BinaryTree tree1 = new BinaryTree(1);
		BinaryTree tree2 = new BinaryTree(1);
//		BinaryTree tree = new BinaryTree("534*2^+");


		tree2.add(Arrays.asList(2, 3), Arrays.asList('L', 'L'));
		tree2.add(Arrays.asList(4, 5, 6, 8, 9), Arrays.asList('R', 'R', 'R', 'R', 'R'));
		tree2.add(Arrays.asList(4, 2, 3), Arrays.asList('R', 'L', 'L'));
		tree2.add(Arrays.asList(4, 5, 6, 7), Arrays.asList('R', 'R', 'L', 'L'));
		tree2.add(Arrays.asList(4, 5, 6, 8, 9), Arrays.asList('R', 'R', 'L', 'R', 'R'));
		tree2.add(Arrays.asList(4, 5, 6, 7), Arrays.asList('R', 'R', 'R', 'L'));

		tree2.printDup();
//		System.out.println(tree.isComplete());
//		tree.levelOrderTraversal();
//		tree.levelOrderTraversal_recursive();
//		tree.levelOrderSpiral();
//		tree.inorderExpression();
//		tree.printLeftBoundry();
//		System.out.println(tree.countLeaves());
//		System.out.println(tree.gitDiameter());
//		System.out.println(tree.isPerfect_v2());
//		System.out.println(tree.isPerfect());
//		System.out.println(tree.getMax());
//		System.out.println(tree.getHeight());
//		System.out.println(tree.find(2));
//		System.out.println(tree.countNodes());
	}

}
