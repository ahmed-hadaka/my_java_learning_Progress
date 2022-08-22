package problems_java_DS;

import java.io.IOException;

/*
......................................................
                                50                                                              
                25                              75                              
        12              37              74              87              
    --      --      30      43      73      --      --      93      
  --  --  --  --  --  33  --  --  --  --  --  --  --  --  --  97  
......................................................

*/
public class BinarySearchTreeApp {
	public static void main(String[] args) throws IOException {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(50);
		tree.insert(25);
		tree.insert(75);
		tree.insert(12);
		tree.insert(74);
		tree.insert(73);
		tree.insert(37);
		tree.insert(43);
		tree.insert(30);
		tree.insert(33);
		tree.insert(87);
		tree.insert(93);
		tree.insert(97);

		tree.displayTree();
		tree.delete(37);
		tree.displayTree();
		tree.delete(50);
		tree.displayTree();

		// ---------- design two area -----------------------
//
//		BST_Design2 tree2 = new BST_Design2();
//
//		tree2.insert(50);
//		tree2.insert(25);
//		tree2.insert(75);
//		tree2.insert(12);
//		tree2.insert(74);
//		tree2.insert(73);
//		tree2.insert(37);
//		tree2.insert(43);
//		tree2.insert(30);
//		tree2.insert(33);
//		tree2.insert(87);
//		tree2.insert(93);
//		tree2.insert(97);
//
//		System.out.println(tree2.successor(43));
		// --------------------------------------------------
	}
}