package MergeSort;
/*
 *
 * @author AhmedHadaka
 *
 * */

import java.util.Random;

public class MergeSortApp {
    public static void main(String[] args) {
        int randN;
        Random rand = new Random();
        int inputArray[] = new int[10];
        for (int i = 0; i < inputArray.length; i++) {  // fill array
            randN = rand.nextInt(10);
            inputArray[i] = randN;
        }

        System.out.println("Before");  // display before
        for (int item : inputArray) {
            System.out.print(item + ", ");
        }
        System.out.println();

        MergeSort Sort = new MergeSort();
        Sort.mergeSort(inputArray); // mergesort

        System.out.println("After");  //display after
        for (int item : inputArray) {
            System.out.print(item + ", ");
        }
    }
}
