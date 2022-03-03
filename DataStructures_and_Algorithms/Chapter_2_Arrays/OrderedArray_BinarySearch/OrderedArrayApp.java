import java.util.Arrays;

public class OrderedArrayApp {
    public static void main(String[] args) {
        OrderedArray fOrderdArray = new OrderedArray(50);
        long[] sOrderdArray = { 23, 32, 2, 6, 45, 3 };

        fOrderdArray.insert(76); // insert 10 items
        fOrderdArray.insert(99);
        fOrderdArray.insert(44);
        fOrderdArray.insert(55);
        fOrderdArray.insert(22);
        fOrderdArray.insert(88);
        fOrderdArray.insert(11);
        fOrderdArray.insert(00);
        fOrderdArray.insert(66);
        fOrderdArray.insert(33);
        fOrderdArray.display();

        int searchKey = 55; // search for item
        int index = fOrderdArray.find(searchKey);
        if (index != -1)
            System.out.println("Found " + searchKey + " at idex: " + index);
        else
            System.out.println("Can't find " + searchKey);
        fOrderdArray.display(); // display items
        fOrderdArray.delete(00); // delete 3 items
        fOrderdArray.delete(55);
        fOrderdArray.delete(99);
        fOrderdArray.display();
        System.out.println(" ");
        System.out.println(Arrays.toString(sOrderdArray) + "\n");
        System.out.println(Arrays.toString(fOrderdArray.merge(sOrderdArray)));
        ;

    }

}
