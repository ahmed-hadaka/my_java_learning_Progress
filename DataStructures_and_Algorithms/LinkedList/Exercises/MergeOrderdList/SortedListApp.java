  package Exercises.MergeOrderdList;

/**
 *
 * @AhmedHadaka
 */
public class SortedListApp {

    public static void main(String[] args) {

        SortedList list1 = new SortedList();
        SortedList list2 = new SortedList();
        Merge mergeList = new Merge();

        list1.insert(6);
        list1.insert(5);
        list1.insert(2);
        list1.insert(38);
        list1.insert(19);

        System.out.println(list1.toString()); // 2 5 6 38 19

        list2.insert(8);
        list2.insert(9);
        list2.insert(4);
        list2.insert(72);
        list2.insert(77);
        list2.insert(98);

        System.out.println(list2.toString()); // 4 8 9 72 77 98

        mergeList.merge(list1, list2);

        System.out.println(list1.toString());

    }
}
