package MergeSort;

/*
 *
 * @author AhmedHadaka
 *
 * */
public class MergeSort {

    public void mergeSort(int[] inputArr) {
        int inputLength = inputArr.length; // suppose n = 5
        if (inputLength < 2)
            return;
        else {
            int mid = inputLength / 2;
            int[] leftArr = new int[mid];  // n = 2
            int[] rightArr = new int[inputLength - mid]; // n = 3

            for (int i = 0; i < leftArr.length; i++) { // fill leftArray
                leftArr[i] = inputArr[i];
            }
            for (int j = mid; j < inputArr.length; j++) { // fill rightArray
                rightArr[j - mid] = inputArr[j];
            }

            mergeSort(leftArr);
            mergeSort(rightArr);

            merge(inputArr, leftArr, rightArr);
        }
    }

    public void merge(int[] inputArr, int[] leftArr, int[] rightArr) {
        int i = 0, j = 0, k = 0;
        while (i < leftArr.length && j < rightArr.length)

            if (leftArr[i] <= rightArr[j])
                inputArr[k++] = leftArr[i++];
            else if (rightArr[j] <= leftArr[i])
                inputArr[k++] = rightArr[j++];

        while (i < leftArr.length)  // handle the rest item(s)
            inputArr[k++] = leftArr[i++];
        while (j < rightArr.length)
            inputArr[k++] = rightArr[j++];
    }
}
