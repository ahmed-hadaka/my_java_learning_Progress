package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortingAlgorithmsAndPractice {
	public static void main(String[] args) {
		int[] diff = { 66, 1, 28, 73, 53, 35, 45, 60, 100, 44, 59, 94, 27, 88, 7, 18, 83, 18, 72, 63 };
		int[] profit = { 66, 20, 84, 81, 56, 40, 37, 82, 53, 45, 43, 96, 67, 27, 12, 54, 98, 19, 47, 77 };
		int[] worker = { 61, 33, 68, 38, 63, 45, 1, 10, 53, 23, 66, 70, 14, 51, 94, 18, 28, 78, 100, 16 };
		System.out.println(maxProfitAssignment(diff, profit, worker));
	}

	// Comparison based sorting algorithms
// ------- Bubble_sort -------------
	public static void bubbleSort(int[] arr) { // o(n^2)
		if (arr.length < 2)
			return;

		for (int i = arr.length - 1; i > 0; i--) // count iterations
			for (int j = 0; j < i; j++)
				if (arr[j] > arr[j + 1])
					swap(arr, j, j + 1);
	}

	private static void swap(int[] arr, int one, int two) {
		int temp = arr[one];
		arr[one] = arr[two];
		arr[two] = temp;
	}

	// ---------- insertion_sort -------

	public static void insertionSort(int[] nums) {// o(n^2)
		if (nums.length < 2)
			return;

		int temp;
		int j;
		for (int i = 0; i < nums.length; i++) {
			temp = nums[i];
			j = i - 1;
			while (j >= 0 && nums[j] > temp) {
				nums[j + 1] = nums[j];
				j--;
			}
			nums[j + 1] = temp;
		}
	}

//	public staticdouble median() {
//		double median;
//		if (nElems % 2 == 0) {
//			median = ((arr[nElems / 2]) + (arr[nElems / 2 - 1])) / 2d; // 2d prefix for double
//			return median;
//		} else
//			return arr[nElems / 2];
//	}

	// ---------- selction_sort -----------

	public static void selectSort(int[] arr) { // o(n^2)
		if (arr.length < 2)
			return;

		int in, out;
		for (out = 0; out < arr.length; out++) {
			int minIndex = out;
			for (in = out + 1; in < arr.length; in++)
				if (arr[in] < arr[minIndex])
					minIndex = in;
			swap(arr, out, minIndex);
		}
	}

	// ------- count_sort ( not comparison based) -----------------

	public static void countSort(int[] arr) { // o(n) -> where n is the max value in arr
		if (arr.length < 2)
			return;
		// Find the largest element of the array
		int size = arr.length, mxValue = arr[0];
		for (int i = 1; i < size; ++i)
			if (arr[i] > mxValue)
				mxValue = arr[i];

		// Compute Frequency
		int[] count = new int[mxValue + 1]; // zeros
		for (int i = 0; i < size; ++i)
			count[arr[i]] += 1;

		// Put the values back to the array
		int idx = 0;
		for (int i = 0; i < count.length; ++i) {
			for (int j = 0; j < count[i]; ++j, ++idx)
				arr[idx] = i;
		}
	}

	// ------- homeWork ( medium ) -----------

	// -------- count sort for negative values --------
	// Boundary ( -50000 <= nums[i] <= 50000 )
	public static int[] countSort_v2(int[] nums) {
		// count sort
		int max = 0;
		final int SHIFT = 50_000;

		for (int c = 0; c < nums.length; c++) { // compute frequency
			nums[c] += SHIFT; // shifting values
			if (nums[c] > max)
				max = nums[c];
		}

		int[] buckets = new int[max + 1];
		for (int i = 0; i < nums.length; i++) {
			buckets[nums[i]]++;
		}
		int i = 0;
		for (int j = 0; j < buckets.length; j++) {
			while (buckets[j]-- > 0) {
				nums[i++] = j - SHIFT;
			}
		}
		return nums;
	}

	// ------- count sort for strings with maintaining the input order ( stable )---

	public static void countSortStirng(String[] arr) { // o(n) -> where n is the max value in arr
		if (arr.length < 2)
			return;
		// Find the largest element of the array
		int mxValue = 0;
		for (String s : arr) {
			int c = s.charAt(0) - 'a'; // convert to integer
			if (c > mxValue)
				mxValue = c;
		}

		List<List<String>> freqArr = new ArrayList<>();

		for (int i = 0; i < mxValue + 1; i++) { // create frequency List 2D
			freqArr.add(new ArrayList<>());
		}

		for (String s : arr) { // Compute Frequency
			int c = s.charAt(0) - 'a';
			freqArr.get(c).add(s);
		}

		// Put the values back to the array
		int idx = 0, j;
		for (int i = 0; i < freqArr.size(); ++i) {
			List<String> list = freqArr.get(i);
			j = 0;
			int len = list.size();
			while (len-- > 0)
				arr[idx++] = list.get(j++);
		}
	}

	// -------- wigglesSort (medium) ---------------
	public static int[] wiggleSort(int[] arr) { // O(nlogn) Time, O(n) Space
		if (arr.length == 1)
			return arr;
		Arrays.sort(arr);// o(nlogn)
		int len = arr.length;

		int[] res = new int[len];
		int i = 0, j = len - 1;

		for (int k = 0; k < len; k++) { // o(n)
			if (k % 2 == 0 && i < len / 2) {
				res[k] = arr[i++];
			} else {
				res[k] = arr[j--];
			}
		}
		return res;
	}

	// --------- eliminateMaximum monsters ----
	public static int eliminateMaximum(int[] dist, int[] speed) {
		double[] min = new double[dist.length];
		for (int i = 0; i < dist.length; i++) {
			min[i] = (double) dist[i] / speed[i];
		}
		Arrays.sort(min);
		int count = 0, j = 0;
		for (int i = 1; i < min.length; i++) {
			count++;
			j++;
			min[i] -= j;
			if (min[i] < 0)
				return count;
		}
		return count + 1;
	}

	// ------- 1005. Maximize Sum Of Array After K Negations -------
	public static int largestSumAfterKNegations(int[] nums, int k) { // o(nlogn)
		Arrays.sort(nums);
		boolean firstItem = true;
		for (int i = -1; i < nums.length - 1 && k > 0; i++) {
			if (nums[i + 1] < 0) {
				nums[i + 1] *= -1;
				k--;
				firstItem = false;
			} else {
				if (!firstItem) {
					if (i < 0 || nums[i] >= nums[i + 1]) {
						nums[i + 1] = applayK(k, nums[i + 1]);
					} else {
						nums[i] = applayK(k, nums[i]);
					}
				} else { // first tiem
					nums[i + 1] = applayK(k, nums[i + 1]);
				}
				break;
			}
			if (k > 0 && i == nums.length - 2) {// cycle
				i = -2;
				Arrays.sort(nums);
			}
		}

		int sum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sum += nums[i];
		}
		return sum;
	}

	private static int applayK(int k, int num) {
		if (k % 2 != 0) {
			return -num;
		}
		return num;
	}

	// ---------------------------
	public static int findUnsortedSubarray(int[] nums) {
		if (nums.length == 1)
			return 0;
		int[] arr = nums.clone();// deep copy

		Arrays.sort(arr); // o(nlogn)

		int i = 0, j = arr.length - 1;
		boolean stopI = false, stopJ = false;

		while (i < j) {
			if (arr[i] != nums[i]) {
				stopI = true;
			}
			if (arr[j] != nums[j]) {
				stopJ = true;
			}
			if (stopI && stopJ)
				return (j - i) + 1;
			if (!stopI)
				i++;
			if (!stopJ)
				j--;
		}
		return 0;
	}

	// -----------
	// there is a bug :), kindly implement it with c++. way easer.
	public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
		Map<Integer, Integer> map = new TreeMap<>();

		for (int i = 0; i < difficulty.length; i++) { // o(nlogn), where n = diff.length
			map.put(difficulty[i], profit[i]); // treeMap insertion => o(logn)
		}
		int k = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) { // o(n) get back
			Integer key = entry.getKey();
			Integer val = entry.getValue();
			difficulty[k] = key;
			profit[k++] = val;
		}
		map.clear();
		Arrays.sort(worker); // o(nlogn)

		int j = 0, sum = 0;
		int maxValue = 0;
		for (int i = 0; i < worker.length; i++) { // o(n+m)
			for (; j < difficulty.length; j++) {
				if (difficulty[j] > worker[i])
					break;
				if (profit[j] > maxValue)
					maxValue = profit[j];
			}
			sum += maxValue;
		}
		return sum;
	}

// ---------------
	public int reductionOperations(int[] nums) {
		if (nums.length == 1)
			return 0;
		Arrays.sort(nums);
		int k = 0;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] != nums[i + 1])
				k += (nums.length - i - 1);
		}
		return k;
	}
	// ------------------

}