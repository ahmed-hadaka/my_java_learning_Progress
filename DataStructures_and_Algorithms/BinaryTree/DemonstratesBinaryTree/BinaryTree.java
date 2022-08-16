package problems_java_DS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	Node root = new Node(1);

	public BinaryTree(int value) {
		root = new Node(value);
	}

	// ----------------------------

//	public BinaryTree(String posfix) { // build a postfix expression tree from a given postfix 
//		Stack<Node> st = new Stack<>();
//		for (int i = 0; i < posfix.length(); i++) {
//			char c = posfix.charAt(i);
//			Node newN = new Node(c);
//			if (!Character.isDigit(c)) {
//				newN.setRightChild(st.pop());
//				newN.setLeftChild(st.pop());
//			}
//			st.push(newN);
//		}
//		root = st.pop();
//	}

	// ----------temp fun------------
	public Node getRoot() {
		return this.root;
	}

	// ----------------------------

	public BinaryTree(int[] inOrder, int[] preOrder) { // build a tree from inorder and preorder
		Map<Integer, Integer> map = setup(inOrder);
		root = buildTree(inOrder, preOrder, 0, inOrder.length - 1, map);
	}

	// ----------------------------
	// build a full tree from preorder and map to maintain the leave nodes
	public BinaryTree(LinkedList<Integer> preorder, Map<Integer, Boolean> map) {
		root = generateFullBT(preorder, map);
	}

	// -------------------- to search HOW... -------------
//	public BinaryTree(String s) {
//		String[] arr = s.split("");
//		LinkedList<String> list = new LinkedList<>(Arrays.asList(arr));
//		Stack<String> st = new Stack<>();
//		root = deseralization(list, st);
//	}

	// --------------------------------------
	public BinaryTree(String s) {
		Queue<String> q = new LinkedList<>();
		String[] str = s.split(",");
		for (int i = 0; i < str.length; i++) {
			q.offer(str[i]);
		}
		root = deserialize(q);
	}

	// ------------------------------------------------------
	private void printInOrder(Node start) {
		if (start == null)
			return;
		printInOrder(start.getLeftChild());
		System.out.print(start.getIData() + " ");
		printInOrder(start.getRightChild());
	}

	public void printInOrder() {
		printInOrder(root);
		System.out.println();
	}

	// ------------------

	private void printPostOrder(Node start) {
		if (start == null)
			return;
		printPostOrder(start.getLeftChild());
		printPostOrder(start.getRightChild());
		System.out.print(start.getIData() + " ");
	}

	public void printPostOrder() {
		printPostOrder(root);
		System.out.println();
	}

	// ------------------

	private void printPreOrder(Node start) {
		if (start == null)
			return;
		System.out.print(start.getIData() + " ");
		printPreOrder(start.getLeftChild());
		printPreOrder(start.getRightChild());
	}

	public void printPreOrder() {
		printPreOrder(root);
		System.out.println();
	}

	// ------------------

	public void add(List<Integer> values, List<Character> directions) {
		assert (values.size() == directions.size()) : "Invalied arguments";
		Node cur = root;
		// iterate on the path, create all necessary nodes
		for (int i = 0; i < values.size(); i++) {
			if (directions.get(i) == 'L') {
				if (cur.getLeftChild() == null) {
					cur.setLeftChild(new Node(values.get(i)));
				} else
					assert (cur.getLeftChild().getIData() == values.get(i));
				cur = cur.getLeftChild();
			} else {
				if (cur.getRightChild() == null) {
					cur.setRightChild(new Node(values.get(i)));
				} else
					assert (cur.getRightChild().getIData() == values.get(i));
				cur = cur.getRightChild();
			}
		}
	}

	// ******************** homework easy *****************************//
	// ------------------

	private int max(Node start) {
		if (start == null)
			return -1;

		int lMax = max(start.getLeftChild());
		int rMax = max(start.getRightChild());

		return Math.max(lMax, Math.max(rMax, start.getIData()));
	}

	public int getMax() {
		return max(root);
	}
	// ------------------

	private int findHeight(Node root) { // num of edges in the longest path
		// Base case:
		if (root == null)
			return -1;

		return Math.max(findHeight(root.getLeftChild()), findHeight(root.getRightChild())) + 1;
	}

	public int getHeight() {
		return findHeight(root);
	}
	// ------------------

	private int countNode(Node start) {
		if (start == null)
			return 0;

		return countNode(start.getLeftChild()) + countNode(start.getRightChild()) + 1;
	}

	public int countNodes() {
		return countNode(root);
	}

	// ------------------

	private int countLeaves(Node st) {
		if (st == null) {
			return 0;
		} else if (st.getLeftChild() == null && st.getRightChild() == null)
			return 1;
		return countLeaves(st.getLeftChild()) + countLeaves(st.getRightChild());
	}

	public int countLeaves() {
		return countLeaves(root);
	}
	// ------------------

	private boolean find(Node root, int val) {
		if (root == null)
			return false;
		if (root.getIData() == val)
			return true;

		boolean findLeft = find(root.getLeftChild(), val);
		if (findLeft)
			return true;

		boolean findRight = find(root.getRightChild(), val);
		if (findRight)
			return true;

		return false;
	}

	public boolean find(int val) {
		return find(root, val);
	}

	// ----- v1 -------------
	private int getWidth() {
		Node cur = root;
		int d = 0;
		while (cur != null) {
			d++;
			cur = cur.getLeftChild();
		}
		return d;
	}

	private boolean isPerfect(Node st, int p) {
		p++;
		if (st.getLeftChild() == null && st.getRightChild() == null) {
			if (p != getWidth())
				return false;
			return true;
		}
		if (st.getLeftChild() == null || st.getRightChild() == null)
			return false;
		return isPerfect(st.getLeftChild(), p) && isPerfect(st.getRightChild(), p);
	}

	public boolean isPerfect() {
		return isPerfect(root, 0);
	}

	// ----- v2 -------------
	public boolean isPerfect_v2() { // using this formula => Nodes = pow(2, levels) - 1
		if (countNode(root) == (int) Math.pow(2, getHeight() + 1) - 1)
			return true;
		return false;
	}

	// ******************** homework medium to hard *****************************//

	public void inorderIterative() {
		Node cur = root;
		Stack<Node> st = new Stack<>();
		while (true) {
			if (cur != null) {
				st.push(cur);
				cur = cur.getLeftChild();
			} else if (!st.isEmpty()) {
				Node temp = st.pop();
				System.out.print(temp.getIData() + " ");
				cur = temp.getRightChild();
			} else {
				return;
			}
		}
	}

	// ------------------
	private void leftBoundry(Node root) {
		if (root == null)
			return;

		System.out.print(root.getIData() + " ");

		if (root.getLeftChild() != null)
			leftBoundry(root.getLeftChild());
		else if (root.getRightChild() != null)
			leftBoundry(root.getRightChild());
	}

	public void printLeftBoundry() {
		leftBoundry(root);
	}

	// ------- Diameter of a binary tree -----------

	private int height_v2(Node root, int[] res) {
		if (root == null)
			return -1;

		int lH = height_v2(root.getLeftChild(), res) + 1;
		int rH = height_v2(root.getRightChild(), res) + 1;
		res[0] = Math.max(res[0], lH + rH);

		return Math.max(lH, rH);
	}

	public int gitDiameter() { // o(n) time
		int[] res = { 0 };
		height_v2(root, res); // array passes by reference
		return res[0];
	}

	// ------------------------------

	private void inorderExpression(Node root, boolean isFirst) { // method to return the infix expression with take care
																	// '()'

		if (root == null)
			return;
		if (Character.isDigit(root.getIData())) {
			System.out.print(root.getIData());
			return;
		}

		if (!isFirst && !Character.isDigit(root.getIData()))
			System.out.print("(");
		inorderExpression(root.getLeftChild(), false);
		System.out.print(root.getIData());
		inorderExpression(root.getRightChild(), false);
		if (!isFirst)
			System.out.print(")");
	}

	public void inorderExpression() {
		inorderExpression(root, true);
	}

	// ----------------------------------

	public void levelOrderTraversal() { // with considering the level
		Queue<Node> q = new LinkedList<>();
//		int level = 0;
		Node cur = root;
		q.offer(cur);
		while (!q.isEmpty()) {
			int size = q.size();

			while (size-- > 0) {
				Node temp = q.poll();
				System.out.print(temp.getIData() + " ");
				if (temp.getLeftChild() != null)
					q.offer(temp.getLeftChild());
				if (temp.getRightChild() != null)
					q.offer(temp.getRightChild());
			}
//			level++;
		}
		System.out.println();
	}

	// -----------------------------------------
	public void levelOrderTraversal_recursive() {
		int h = this.getHeight();
		for (int i = 0; i <= h; i++) {
			printLevel(i, root);
		}
		System.out.println();
	}

	private void printLevel(int level, Node root) {
		if (level == 0) {
			System.out.print(root.getIData() + " ");
			return;
		}
		printLevel(level - 1, root.getLeftChild());
		printLevel(level - 1, root.getRightChild());
	}

	// -----------------------------------------
	public void levelOrderSpiral() { // it's like zigzag traversal :)
		Deque<Node> q = new ArrayDeque<>();
		int level = 0;
		Node cur = root;
		q.offer(cur);
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				if (level == 0 || level % 2 != 0) { // odd level
					Node temp = q.pollLast();
					System.out.print(temp.getIData() + " ");
					if (temp.getRightChild() != null)
						q.offerFirst(temp.getRightChild());
					if (temp.getLeftChild() != null)
						q.offerFirst(temp.getLeftChild());
				} else if (level % 2 == 0) { // even level
					Node temp = q.pollFirst();
					System.out.print(temp.getIData() + " ");
					if (temp.getRightChild() != null)
						q.offerLast(temp.getRightChild());
					if (temp.getLeftChild() != null)
						q.offerLast(temp.getLeftChild());
				}
			}
			level++;
		}
		System.out.println();
	}

	// -----------------------------

	// if we face an empty node then, there shouldn't be any node after it to be
	// marked as an complete tree

	public boolean isComplete() {
		Queue<Node> q = new LinkedList<>();
		boolean isThereEmpty = false;
		Node cur = root;
		if (cur == null)
			return false;
		q.offer(cur);
		while (!q.isEmpty()) {
			Node temp = q.poll();
			if (temp.getLeftChild() != null) {
				if (isThereEmpty)
					return false;
				q.offer(temp.getLeftChild());
			} else {
				isThereEmpty = true;
			}
			if (temp.getRightChild() != null) {
				if (isThereEmpty)
					return false;
				q.offer(temp.getRightChild());
			} else {
				isThereEmpty = true;
			}
		}
		return true;
	}

	// ---------- hard --------------

	// build a tree from a given inorder and preorder
	private Map<Integer, Integer> setup(int[] in) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < in.length; i++) {
			map.put(in[i], i);
		}
		return map;
	}

	int ind = 0;

	public Node buildTree(int[] in, int[] pre, int inStrt, int inEnd, Map<Integer, Integer> map) {
		if (inStrt > inEnd)
			return null;

		Node tNode = new Node(pre[ind++]);

		// If this node has no children then return
		if (inStrt == inEnd)
			return tNode;

		// Else find the index of this node in Inorder traversal
		int inIndex = map.get(tNode.getIData());

		tNode.setLeftChild(buildTree(in, pre, inStrt, inIndex - 1, map));
		tNode.setRightChild(buildTree(in, pre, inIndex + 1, inEnd, map));

		return tNode;
	}

	// -----------------------------------

	Node generateFullBT(LinkedList<Integer> pre, Map<Integer, Boolean> map) {
		Node temp = new Node(pre.pop());
		if (map.get(temp.getIData()))
			return temp;
		temp.setLeftChild(generateFullBT(pre, map));
		temp.setRightChild(generateFullBT(pre, map));
		return temp;
	}

	// ------------- to search HOW... -----------------

//	Node deseralization(LinkedList<String> str, Stack<String> st) { 
//		String c = str.pop();
//		if (c.equals("(")) {
//			st.push(c);
//			while (str.peek().equals("("))
//				st.push(str.pop());
//			c = str.pop();
//		}
//		if (c.equals(")")) {
//			st.pop();
//			while (str.peek().equals(")")) {
//				st.pop();
//			}
//			return null;
//		}
//		Node temp = new Node(Integer.parseInt(c));
//		temp.setLeftChild(deseralization(str, st));
//		temp.setRightChild(deseralization(str, st));
//		return temp;
//	}

	// ------------------------------------------------
	private String serialize(Node root) {
		String str = ',' + Integer.toString(root.getIData());
		if (root.getLeftChild() != null)
			str += serialize(root.getLeftChild());
		else
			str += ",x";
		if (root.getRightChild() != null)
			str += serialize(root.getRightChild());
		else
			str += ",x";
		return str;
	}

	public String serialize() {

		if (root == null)
			return "";
		return serialize(root).substring(1);
	}

	// --------------------------------

	private Node deserialize(Queue<String> s) {

		if (!s.peek().equals("x")) {
			int val = Integer.parseInt(s.poll());
			Node temp = new Node(val);
			temp.setLeftChild(deserialize(s));
			temp.setRightChild(deserialize(s));
			return temp;
		}
		s.poll();
		return null;
	}

// ---------------------------------
	private String parenthesize(Node root) {
		String repr = "(" + root.getIData();

		if (root.getLeftChild() != null)
			repr += parenthesize(root.getLeftChild());
		else
			repr += "()"; // null: no child

		if (root.getRightChild() != null)
			repr += parenthesize(root.getRightChild());
		else
			repr += "()"; // null: no child
		repr += ")";

		return repr;
	}

	public String parenthesize() {
		return parenthesize(root);
	}
// -------- Advanced ---------------

	private String parenthesize_canonical(Node root) { // o(n) Time and Memory
		String repr = "(" + root.getIData();

		ArrayList<String> v = new ArrayList<>();

		if (root.getLeftChild() != null)
			v.add(parenthesize_canonical(root.getLeftChild())); // o(left_subTree)
		else
			v.add("()");

		if (root.getRightChild() != null)
			v.add(parenthesize_canonical(root.getRightChild())); // o(right_subTree)
		else
			v.add("()");

		// o(n)
		Collections.sort(v); // o(n logn )
		for (int i = 0; i < (int) v.size(); ++i) // o(n)
			repr += v.get(i);

		repr += ")";

		return repr;
	}

	private String parenthesize_canonical_1() {
		return parenthesize_canonical(root.getLeftChild());
	}

	private String parenthesize_canonical_2() {
		return parenthesize_canonical(root.getRightChild());
	}

	private String parenthesize_canonical_1e(Node root1) {
		return parenthesize_canonical(root1);
	}

	private String parenthesize_canonical_2e(Node root2) {
		return parenthesize_canonical(root2);
	}

// --------------------- medium -----------------------------
	private boolean is_symmetric_v1(Node first, Node second) { // o(n)
		if (first == null && second == null)
			return true;
		if (first.getIData() != second.getIData())
			return false;
		boolean f = is_symmetric_v1(first.getRightChild(), second.getLeftChild());
		boolean s = is_symmetric_v1(first.getLeftChild(), second.getRightChild());
		return f && s;
	}

	public boolean is_symmetric_v1() {
		return is_symmetric_v1(root.getLeftChild(), root.getRightChild());
	}

	/*
	 * another approach -> using parenthesize_canonical concept
	 */
	public boolean is_symmetric_v2() { // o(n) Time and Memory
		String left = parenthesize_canonical_1();
		String right = parenthesize_canonical_2();
		return left.equals(right);
	}

	/*
	 * however the two approach are the same, the constant in second approach is
	 * greater than in the first one
	 */

	// ----------- Flip Equivalent problem ------------------

	// recursive approach
	public boolean flipEquiv(Node root1, Node root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;
		if (root1.getIData() != root2.getIData())
			return false;
		return (flipEquiv(root1.getLeftChild(), root2.getLeftChild())
				&& flipEquiv(root1.getRightChild(), root2.getRightChild()))
				|| (flipEquiv(root1.getLeftChild(), root2.getRightChild())
						&& flipEquiv(root1.getRightChild(), root2.getLeftChild()));
	}

	// -----------------------------------
	// canonical approach

	public boolean flipEquiv_v2(Node root1, Node root2) {
		String s1 = parenthesize_canonical_1e(root1);
		String s2 = parenthesize_canonical_2e(root2);
		return s1.equals(s2);
	}

	// --------------- print All duplicated subtree -------------------
	private String parenthesizeAll(Node root, List<String> list) {
		String s = "(" + root.getIData();
		if (root.getLeftChild() != null)
			s += parenthesizeAll(root.getLeftChild(), list);
		else
			s += "()";
		if (root.getRightChild() != null)
			s += parenthesizeAll(root.getRightChild(), list);
		else
			s += "()";

		s += ")";
		if (root.getLeftChild() != null || root.getRightChild() != null)
			list.add(s);
		return s;
	}

	public void printDup() {
		List<String> list = new ArrayList<>();
		parenthesizeAll(root, list);
		Collections.sort(list);
		int i;
		for (i = 0; i < list.size() - 1; i++) {
			boolean flag = false;
			while (i < list.size() - 1 && list.get(i).equals(list.get(i + 1))) {
				i++;
				flag = true;
			}
			if (flag)
				System.out.println(list.get(i));

		}
	}
}
