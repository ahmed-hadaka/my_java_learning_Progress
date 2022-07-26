  package Exercises.MergeOrderdList;

/**
 *
 * @AhmedHadaka
 */
public class Merge {

    public Merge() {
    }

    public void merge(SortedList list1, SortedList list2) {
        while (!list2.isEmpty()) {
            list1.insert(list2.remove().getIData());
        }
    }
}
