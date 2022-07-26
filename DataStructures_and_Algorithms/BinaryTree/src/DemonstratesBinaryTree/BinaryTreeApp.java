package DemonstratesBinaryTree;

import java.io.IOException;
import java.io.*;

public class BinaryTreeApp {
    public static void main(String[] args) throws IOException {
        int value;
        BinaryTree theTree = new BinaryTree();
        theTree.insert(50);
        theTree.insert(25);
        theTree.insert(75);
        theTree.insert(12);
        theTree.insert(37);
        theTree.insert(43);
        theTree.insert(30);
        theTree.insert(33);
        theTree.insert(87);
        theTree.insert(93);
        theTree.insert(97);
        while (true) { // you would like to stop the program from the entire compiler.
            System.out.print("Enter first letter of: show, insert, find, delete, or traverse: \n");
            char choice = getChar();
            switch (choice) {
                case 's' -> theTree.displayTree();
                case 'i' -> {
                    System.out.print("Enter value to insert: ");
                    value = getInt();
                    theTree.insert(value);
                }
                case 'f' -> {
                    System.out.print("Enter value to find: ");
                    value = getInt();
                    Node found = theTree.find(value);
                    if (found != null) {
                        System.out.print("Found: ");
                    } else
                        System.out.print("Could not find ");
                    System.out.print(value + "\n");
                }
                case 'd' -> {
                    System.out.print("Enter value to delete: ");
                    value = getInt();
                    boolean didDelete = theTree.delete(value);
                    if (didDelete)
                        System.out.print("Deleted: ");
                    else
                        System.out.print("Could not delete: ");
                    System.out.print(value + "\n");
                }
                case 't' -> {
                    System.out.print("Enter type 1, 2or 3: ");
                    value = getInt();
                    theTree.traversal(value);
                }
                default -> System.out.print("Invalid entry\n");
            }
        }

    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }

    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}