package problems_java_DS;

import java.util.HashMap;
import java.util.Map;

public class Node {
	private Map<Character, Node> children;
	private boolean isLeaf;

	public Node() {
		children = new HashMap<>();
		isLeaf = false;
	}

	public Map<Character, Node> getChildren() {
		return this.children;
	}

	public void setLeaf(boolean flag) {
		this.isLeaf = flag;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public void addChildren(char key) {
		children.put(key, new Node());
	}

	public void clear() {
		children.clear();
	}

}
