package DemonstratesBinaryTree;

import java.util.*;

public class BinaryTree {
    Node root;

    public void insert(int iData) {
        if (!isEmpty()) {
            this.root.insert(iData);
        } else
            this.root = new Node(iData);
    }

    public Node find(int iData) {
        if (!isEmpty())
            return root.find(iData);
        return null; // empty tree
    }

    public boolean delete(int iData) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = false;
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
        if (current != null) {
            if (current.getRightChild() == null && current.getLeftChild() == null) { // case 1
                if (current == root)
                    root = null;
                else if (isLeftChild)
                    parent.setLeftChild(null);
                else
                    parent.setRightChild(null);
            } else if (current.getLeftChild() == null) { // case 2 part 1
                if (current == root)
                    root = current.getRightChild();
                else if (isLeftChild)
                    parent.setLeftChild(current.getRightChild());
                else
                    parent.setRightChild(current.getRightChild());
            } else if (current.getRightChild() == null) { // case 2 part 2
                if (current == root)
                    root = current.getLeftChild();
                else if (isLeftChild)
                    parent.setLeftChild(current.getLeftChild());
                else
                    parent.setRightChild(current.getLeftChild());
            } else {                                                // case 3
                Node successor = getSuccessor(current);
                if (current == root)
                    root = successor;
                if (isLeftChild) {
                    parent.setLeftChild(successor);
                } else
                    parent.setRightChild(successor);
                successor.setLeftChild(current.getLeftChild());
            }
            return true;
        }
        return false;
    }

    public Node getSuccessor(Node deletedNode) {
        Node parent = deletedNode;
        Node successor = deletedNode;
        Node current = deletedNode.getRightChild();
        while (current != null) {
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

    public void traversal(int traversalType) {
        if (!isEmpty()) {
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

    public boolean isEmpty() {
        return (root == null);
    }

    /*
     *Write a Java program to create a Balanced Binary Search Tree (BST) using
     *an array (given) elements where array elements are sorted in ascending order
     */

  /*  public Node arrayToBST(int[] arr, int start, int end) {
        if (start > end) return null;
        mid = (start + end) / 2;
        Node newN = new Node(arr[mid]);
        newN.setLeftChild(arrayToBST(arr, start, mid - 1));
        newN.setRightChild(arrayToBST(arr, mid + 1, end));
        return newN;
    }
*/
}
