package problems_java_DS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
	Node root;

// -----------------------------------------------

//	public BinarySearchTree(Queue<Integer> pre) {
//		root = buildBST_v2(pre, 0, 1000);
//	}
//	public BinarySearchTree(Queue<Integer> levelorder) {
//		root = BSTFromLeveleOrder(levelorder);
//	}

// -----------------------------------------------
	private void insert(int data, Node root) { // O(h)Time and memory, where h is the height of the tree
		if (data < root.getIData()) {
			if (root.getLeftChild() == null)
				root.setLeftChild(new Node(data));
			else
				insert(data, root.getLeftChild());
		} else if (data > root.getIData()) {
			if (root.getRightChild() == null)
				root.setRightChild(new Node(data));
			else
				insert(data, root.getRightChild());
		} // else : it's already exist
	}

	public void insert(int data) {
		if (root == null)
			root = new Node(data);
		else
			insert(data, root);
	}

// ------------------------------------------------
	// O(h)Time and memory where h is the height of the tree, and O(log(n)) in
	// balanced binary search tree

	private boolean find(int key, Node root) {
		if (root.getIData() == key)
			return true;
		if (root.getLeftChild() != null && key <= root.getIData())
			return find(key, root.getLeftChild());
		if (root.getRightChild() != null && key > root.getIData())
			return find(key, root.getRightChild());
		return false;
	}

	public boolean find(int key) {
		if (root == null)
			return false;
		return find(key, root);
	}

// ---------------- delete and successor ------------------------
	public boolean delete(int iData) {
		Node current = root;
		Node parent = root;
		boolean isLeftChild = false;
		// find the target node
		while (current != null && current.getIData() != iData) {
			parent = current;
			if (iData > current.getIData()) {
				current = current.getRightChild();
				isLeftChild = false;
			} else {
				current = current.getLeftChild();
				isLeftChild = true;
			}
		}
		// process if we find it
		if (current != null) {
			if (current.getRightChild() == null && current.getLeftChild() == null) { // leave node
				if (current == root)
					root = null;
				else if (isLeftChild)
					parent.setLeftChild(null);
				else
					parent.setRightChild(null);

			} else if (current.getLeftChild() == null) { // have one right child
				if (current == root)
					root = current.getRightChild();
				else if (isLeftChild)
					parent.setLeftChild(current.getRightChild());
				else
					parent.setRightChild(current.getRightChild());

			} else if (current.getRightChild() == null) { // have one left child
				if (current == root)
					root = current.getLeftChild();
				else if (isLeftChild)
					parent.setLeftChild(current.getLeftChild());
				else
					parent.setRightChild(current.getLeftChild());

			} else { // have two child (successor case)or(predecessor case)
				// ---------------- successor -------------
//				Node successor = getSuccessor(current);
//				if (current == root)
//					root = successor;
//				else if (isLeftChild) {
//					parent.setLeftChild(successor);
//				} else
//					parent.setRightChild(successor);
//				successor.setLeftChild(current.getLeftChild());

				// ----------------- predecessor ----------
				Node predecessor = getPredeccessor(current);
				if (current == root)
					root = predecessor;
				else if (isLeftChild) {
					parent.setLeftChild(predecessor);
				} else
					parent.setRightChild(predecessor);
				predecessor.setRightChild(current.getRightChild());

			}
			return true;
		}
		return false;
	}

	// here we applying the successor to the node which have two children
	// i.e, the node to be deleted does indeed have a right child
	private Node getSuccessor(Node deletedNode) {
		Node parent = deletedNode;
		Node successor = deletedNode;
		Node current = deletedNode.getRightChild();
		while (current != null) { // get min of the left
			parent = successor;
			successor = current;
			current = current.getLeftChild();
		}
		if (successor != deletedNode.getRightChild()) {
			parent.setLeftChild(successor.getRightChild());
			successor.setRightChild(deletedNode.getRightChild());
		}
		return successor;
	}

	private Node getPredeccessor(Node deletedNode) {
		Node parent = deletedNode;
		Node successor = deletedNode;
		Node current = deletedNode.getLeftChild();
		while (current != null) {// get max of the right
			parent = successor;
			successor = current;
			current = current.getRightChild();
		}
		if (successor != deletedNode.getLeftChild()) {
			parent.setRightChild(successor.getLeftChild());
			successor.setLeftChild(deletedNode.getLeftChild());
		}
		return successor;
	}
	// -------------------------- successor (General) ---------------

	private Node getMin(Node root) { // o(h)
		while (root != null && root.getLeftChild() != null) {
			root = root.getLeftChild();
		}
		return root;
	}

	private boolean findChain(Deque<Node> chainList, int target, Node root) { // o(h)
		chainList.offer(root);
		if (target == root.getIData())
			return true;
		if (target < root.getIData())
			return (root.getLeftChild() != null && findChain(chainList, target, root.getLeftChild()));
		return (root.getRightChild() != null && findChain(chainList, target, root.getRightChild()));
	}

	public Integer Successor(int target) {
		Deque<Node> chainList = new LinkedList<>();

		chainList.offer(null); // temp data

		if (!findChain(chainList, target, root))
			return null;
		Node child = chainList.pollLast();

		if (child.getRightChild() != null) { // have right child
			return getMin(child.getRightChild()).getIData();
		}

		Node parent = chainList.pollLast();

		while (parent != null && child.getIData() > parent.getIData()) {
			parent = chainList.pollLast();
		}

		if (parent != null)
			return parent.getIData();
		return -1;
	}

	// --------- first approach -> validate binary search tree (medium)----------

	private boolean isBST(Node root, int min, int max) {
		if (root == null)
			return true;
		if ((root.getIData() <= min) || (root.getIData() >= max))
			return false;
		return isBST(root.getLeftChild(), min, root.getIData()) && isBST(root.getRightChild(), root.getIData(), max);
	}

	public boolean isBST() {
		if (root == null)
			return true;
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	// -------- second approach -> using preorder ( for unique values only )---

	public boolean isValidBST() {
		if (root == null)
			return true;
		List<Integer> list = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		get_inorder(root, list);
		temp.addAll(list);
		Collections.sort(temp);
		return temp.equals(list);

	}

	private void get_inorder(Node root, List<Integer> values) {
		if (root.getLeftChild() != null)
			get_inorder(root.getLeftChild(), values);
		values.add(root.getIData());
		if (root.getRightChild() != null)
			get_inorder(root.getRightChild(), values);
	}

	// ---------------- build balance BST from sorted array --------

	private Node sortedArrayToBST(int[] nums, int start, int end) {
		if (start > end)
			return null;
		int mid = (start + end) / 2;
		Node root = new Node(nums[mid]);
		root.setLeftChild(sortedArrayToBST(nums, start, mid - 1));
		root.setRightChild(sortedArrayToBST(nums, mid + 1, end));
		return root;
	}

	public void sortedArrayToBST(int[] nums) {
		root = sortedArrayToBST(nums, 0, nums.length - 1);
	}

	// ---------- get smallest kth in BST O(k) inorder iterative -------
	private int inorderIterative(int k) {
		Node cur = root;
		Stack<Node> st = new Stack<>();
		int tempVal = 0;
		while (true) {
			if (cur != null) {
				st.push(cur);
				cur = cur.getLeftChild();
			} else if (!st.isEmpty()) {
				tempVal++;
				Node temp = st.pop();
				if (tempVal == k)
					return temp.getIData();
				cur = temp.getRightChild();
			} else {
				return -1;
			}
		}
	}

	public int getSmallestNum(int k) {
		return inorderIterative(k);
	}

	// ---------------- lowest common ancestor ( approach one )

	private void find_v2(int key, Node root, List<Node> list) {

		if (root.getIData() == key)
			return;
		if (root.getLeftChild() != null && key <= root.getIData()) {
			list.add(root);
			find_v2(key, root.getLeftChild(), list);
		} else if (root.getRightChild() != null && key > root.getIData()) {
			list.add(root);
			find_v2(key, root.getRightChild(), list);
		}
	}

	public int lowestCommonAncestor(int key1, int key2) {
		List<Node> list1 = new ArrayList<>();
		List<Node> list2 = new ArrayList<>();
		find_v2(key1, root, list1);
		find_v2(key2, root, list2);
		if (list1.isEmpty())
			list1.add(root);
		if (list2.isEmpty())
			list2.add(root);
		int len1 = list1.size();
		int len2 = list2.size();
		while (len1 > 0) {
			if (len1 == len2) {
				if (list1.get(len1 - 1).getIData() == key2)
					return key2;
				if (list2.get(len2 - 1).getIData() == key1)
					return key1;
				if (list1.get(len1 - 1) == list2.get(len2 - 1))
					return list1.get(len1 - 1).getIData();
				len1--;
				len2--;
			} else if (len2 > len1) {
				if (list1.get(len1 - 1).getIData() == key2)
					return key2;
				if (list2.get(len2 - 1).getIData() == key1)
					return key1;
				if (list1.get(len1 - 1) == list2.get(len2 - 1))
					return list1.get(len1 - 1).getIData();
				len2--;
			} else if (len1 > len2) {
				if (list1.get(len1 - 1).getIData() == key2)
					return key2;
				if (list2.get(len2 - 1).getIData() == key1)
					return key1;
				if (list1.get(len1 - 1) == list2.get(len2 - 1))
					return list1.get(len1 - 1).getIData();
				len1--;
			}
		}
		return -1;
	}

	// ---------------- lowest common ancestor ( Dr.mostafa approach)

	public int lca(int x, int y, Node root) {
		// if both on left or right subtree, then lca must be in the subtree
		// otherwise this node is lca: x is in a branch and y in another
		if (x < root.getIData() && y < root.getIData())
			return lca(x, y, root.getLeftChild());

		if (x > root.getIData() && y > root.getIData())
			return lca(x, y, root.getRightChild());

		return root.getIData();
	}
	// Tip: to find the path between any 2 nodes: you get their lca
	// then path (lca, a) + path(lca, b)

	// ---- queries of ancestor ( no parent pointer, no chain of ancestor, queries
	// must be sorted ) -----

	public void queriesOfAncestor(Queue<Integer> queries, Stack<Integer> traverse, List<Integer> ans, Node root) {
		// base case
		if (queries.isEmpty())
			return;

		// search on the left
		if (queries.peek() < root.getIData())
			queriesOfAncestor(queries, traverse, ans, root.leftChild);

		// process current node
		if (!traverse.isEmpty()) {
			if (queries.peek() == traverse.peek()) {
				ans.add(root.getIData());
				queries.poll();
			}
		}
		traverse.push(root.getIData());

		// search on the right
		if (queries.peek() >= root.getIData()) // notes the equal sign here
			queriesOfAncestor(queries, traverse, ans, root.getRightChild());

	}

	// -- is degenerate tree from preorder of BST list ( tackled with min_max
	// concept )---

	public boolean isDegenerateTree(Queue<Integer> values) {
		if (values.isEmpty())
			return false;
		Integer min = null;
		Integer max = null;
		int temp = values.poll();
		while (!values.isEmpty()) {
			int peek = values.peek();
			if (peek < temp) {
				max = temp;
				if (min != null && peek < min)
					return false;
				temp = values.poll();
			} else {
				min = temp;
				if (max != null && peek > max)
					return false;
				temp = values.poll();
			}
		}
		return true;
	}

	// ------- BST from preorder traversal v1 ------
	// not clear enough for me :(
	public Node buildBST(int[] pre, int start, int end) { // o(n^2)

		Node root = new Node(pre[start]);

		for (int spliter = start + 1; spliter <= end + 1; spliter++) {
			if (spliter == end + 1 || pre[spliter] > root.getIData()) {
				if (start + 1 <= spliter - 1)
					root.setLeftChild(buildBST(pre, start + 1, spliter - 1));
				if (spliter <= end)
					root.setRightChild(buildBST(pre, spliter, end));
				break;
			}
		}
		return root;
	}

	// -- BST from pre_order traversal_v2 ( tackled with min_max observation )---

	private Node buildBST_v2(Queue<Integer> pre, int min, int max) { // o(n)
		Node root = new Node(pre.poll());

		if (!pre.isEmpty() && pre.peek() < root.getIData() && pre.peek() > min && pre.peek() < root.getIData()) {
			root.setLeftChild(buildBST_v2(pre, min, root.getIData()));
		}
		if (!pre.isEmpty() && pre.peek() > root.getIData() && pre.peek() < max) {
			root.setRightChild(buildBST_v2(pre, root.getIData(), max));
		}

		return root;
	}

	// ----------- BST from level_order --------

	private class Pair<T1, T2> {
		T1 first;
		T2 second;

		public Pair(T1 first, T2 second) {
			this.first = first;
			this.second = second;
		}

		public T1 getFirst() {
			return first;
		}

		public T2 getSecond() {
			return second;
		}
	}

	public Node BSTFromLeveleOrder(Queue<Integer> levelorder) {
		if (levelorder.isEmpty())
			return null;

		Queue<Pair<Node, Pair<Integer, Integer>>> ourQueue = new LinkedList<>();
		Node root = new Node(levelorder.poll());

		ourQueue.offer(new Pair(root, new Pair(0, 1001)));

		while (!levelorder.isEmpty()) { // in every iteration we determine if left or right child and check the range
										// and check if it's already have left node or right node
			if (levelorder.peek() < ourQueue.peek().getFirst().getIData()
					&& levelorder.peek() > ourQueue.peek().getSecond().getFirst()
					&& ourQueue.peek().getFirst().getLeftChild() == null) {
				Node left = new Node(levelorder.peek());
				ourQueue.peek().getFirst().setLeftChild(left);
				int min = ourQueue.peek().getSecond().getFirst();
				int max = ourQueue.peek().getFirst().getIData();
				ourQueue.offer(new Pair(left, new Pair(min, max)));
				levelorder.poll();
			} else if (levelorder.peek() > ourQueue.peek().getFirst().getIData()
					&& levelorder.peek() < ourQueue.peek().getSecond().getSecond()
					&& ourQueue.peek().getFirst().getRightChild() == null) {
				Node right = new Node(levelorder.peek());
				ourQueue.peek().getFirst().setRightChild(right);
				int min = ourQueue.peek().getFirst().getIData();
				int max = ourQueue.peek().getSecond().getSecond();
				ourQueue.offer(new Pair(right, new Pair(min, max)));
				levelorder.poll();
			} else {
				ourQueue.poll();
			}
		}
		return root;
	}

	// -----------------------------------------
	public void traversal(int traversalType) {
		if (root != null) {
			switch (traversalType) {
			case 1 -> {
				System.out.println("\npreorder traversal: ");
				preOrder(root);
			}
			case 2 -> {
				System.out.println("\ninorder traversal: ");
				inOrder(root);
			}
			case 3 -> {
				System.out.println("\npostorder traversal: ");
				postOrder(root);
			}
			}
			System.out.println();
		}
	}

	public void inOrder(Node start) {
		if (start != null) {
			inOrder(start.getLeftChild());
			System.out.println(start.getIData());
			inOrder(start.getRightChild());
		}
	}

	public void preOrder(Node start) {
		if (start != null) {
			System.out.println(start.getIData());
			preOrder(start.getLeftChild());
			preOrder(start.getRightChild());
		}
	}

	public void postOrder(Node start) {
		if (start != null) {
			postOrder(start.getLeftChild());
			postOrder(start.getRightChild());
			System.out.println(start.getIData());
		}
	}
	// --------------------------------------------

	public void displayTree() {
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
					System.out.print(temp.iData);
					localStack.push(temp.leftChild);
					localStack.push(temp.rightChild);
					if (temp.leftChild != null || temp.rightChild != null)
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

	/*
	 * Write a Java program to create a Balanced Binary Search Tree (BST) using an
	 * array (given) elements where array elements are sorted in ascending order
	 */

	/*
	 * public Node arrayToBST(int[] arr, int start, int end) { if (start > end)
	 * return null; mid = (start + end) / 2; Node newN = new Node(arr[mid]);
	 * newN.setLeftChild(arrayToBST(arr, start, mid - 1));
	 * newN.setRightChild(arrayToBST(arr, mid + 1, end)); return newN; }
	 */
}
