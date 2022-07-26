package Demonstrates_Hash_Table_with_Separate_Chaning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HashTableApp {
    public static void main(String[] args) throws IOException {
        NodeItem aDataItem;
        int aKey, size, n, keysPerCell;
        String value;

        System.out.print("Enter size of hash table: ");
        size = getInt();
        System.out.print("Enter initial number of items: ");
        n = getInt();
        keysPerCell = 10;
        HashTable theHashTable = new HashTable(size);
        for (int j = 0; j < n; j++) {
            aKey = (int) (java.lang.Math.random() * keysPerCell * size);
            theHashTable.insert(aKey, null);
        }
        while (true) {
            boolean exit = false;
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, delete, or find: else to exit");
            char choice = getChar();
            switch (choice) {
                case 's' -> theHashTable.displayTable();
                case 'i' -> {
                    System.out.print("Enter key to insert: ");
                    aKey = getInt();
                    System.out.print("Enter value to insert: ");
                    value = getString();
                    theHashTable.insert(aKey, value);
                }
                case 'd' -> {
                    System.out.print("Enter key value to delete: ");
                    aKey = getInt();
                    NodeItem deleted = theHashTable.delete(aKey);
                    if (deleted != null)
                        System.out.println(aKey + ": deleted");
                    else
                        System.out.println("can't find");
                }
                case 'f' -> {
                    System.out.print("Enter key value to find: ");
                    aKey = getInt();
                    aDataItem = theHashTable.find(aKey);
                    if (aDataItem != null) {
                        System.out.println("Found " + aKey);
                    } else
                        System.out.println("can't find ");
                }
                default -> exit = true;
            }
            if (exit) break;
        }
    }

    public static String getString() throws IOException {
        InputStreamReader ins = new InputStreamReader(System.in);
        BufferedReader buf = new BufferedReader(ins);
        String str = buf.readLine();
        return str;
    }

    public static int getInt() throws IOException {
        int n = Integer.parseInt(getString());
        return n;
    }

    public static char getChar() throws IOException {
        char ch = getString().charAt(0);
        return ch;
    }
}
