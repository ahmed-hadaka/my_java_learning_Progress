package Demonstrates_Hash_Table_with_Separate_Chaning;

public class HashTable {
    private final SortedList[] hashArray;
    private final int size;

    public HashTable(int size) {
        this.size = size;
        hashArray = new SortedList[size];
        for (int i = 0; i < this.size; i++) {
            hashArray[i] = new SortedList();
        }
    }

    public void insert(int hashKey, String value) {
        NodeItem newNode = new NodeItem(hashKey, value);
        int key = hashFun(hashKey);
        hashArray[key].insert(newNode);
    }

    public NodeItem find(int hashKey) {
        int key = hashFun(hashKey);
        return hashArray[key].find(hashKey);
    }

    public NodeItem delete(int hashKey) {
        int key = hashFun(hashKey);
        return hashArray[key].delete(hashKey);
    }

    public int hashFun(int hashKey) {
        return hashKey % size;
    }

    public void displayTable() {
        for (int j = 0; j < hashArray.length; j++) {
            System.out.print(j + ": "); // display cell number
            System.out.println(hashArray[j].toString() + "\n"); // display list
        }
    }
}
