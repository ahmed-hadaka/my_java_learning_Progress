package Demonstrates_Hash_Table_with_Linear_Probing;

public class HashTable {
    private DataItem[] hashArray;
    private DataItem nonItem;
    private int size;

    public HashTable(int size) {
        this.size = size;
        hashArray = new DataItem[size];
        nonItem = new DataItem(-1, null);
    }

    public void insert(int hashKey, String value) { // assumes not full
        DataItem newItem = new DataItem(hashKey, value);
        int key = hashFun(hashKey);
        while (hashArray[key] != null && hashArray[key].getKey() != -1) {
            key++;
//          key += step(key);   in double hashing
            key %= size;    // wraparound
        }
        hashArray[key] = newItem;
    }

    public DataItem find(int hashKey) {
        int key = hashFun(hashKey);
        while (hashArray[key] != null) {
            if (hashArray[key].getKey() == hashKey)
                return hashArray[key];
            key++;
//          key += step(key);   in double hashing
            key %= size;
        }
        return null; // not found
    }

    public DataItem delete(int hashKey) {
        int key = hashFun(hashKey);
        DataItem temp = null;
        while (hashArray[key] != null) {
            if (hashArray[key].getKey() == hashKey) {
                temp = hashArray[key];
                hashArray[key] = nonItem;
                break;
            }
            ++key;
//          key += step(key);   in double hashing
            key %= size;
        }
        return temp; // not found
    }

    public int hashFun(int hashKey) {
        return hashKey % size;
    }

    /* in double hashing, you would like add this method */

//    public int step(int hashKey) {
//        return 5 - hashKey % 5;
//    }

    /*

   in hashing Strings, you would like use this method

//    public int hashFunStr(String key) {
//        int hashV = 0, charC;
//        double p = 0;
//        for (int i = key.length() - 1; i >= 0; i--) {
//            charC = key.charAt(i);
//            hashV += (charC * Math.pow(p, 27d) % size);
//            p++;
//        }
//        return hashV;
//    }

   */

    public void displayTable() {
        StringBuilder str = new StringBuilder("[ ");
        for (DataItem dataItem : hashArray) {
            if (dataItem != null)
                str.append(dataItem.getKey()).append(":").append(dataItem.getValue()).append(", ");
            else
                str.append("__, ");
        }
        str.append("]");
        System.out.println(str);
    }
}
