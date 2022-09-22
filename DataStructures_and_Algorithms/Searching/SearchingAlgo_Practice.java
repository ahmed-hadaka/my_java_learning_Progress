package problems;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class SearchingAlgo_Practice {
	public static void main(String[] args) {
//		System.out.println(mySqrt(8, 1e-9));
		System.out.println(mySqrtd(8));
	}

	// binary search iterative
	public static int binarySearch(int[] arr, int target) {
		int lowerBound = 0, upperBound = arr.length - 1, midPoint;

		while (lowerBound <= upperBound) {
			midPoint = (lowerBound + upperBound) / 2;

			if (arr[midPoint] == target) {
				return midPoint;

			} else if (arr[midPoint] > target)
				upperBound = midPoint - 1;

			else
				lowerBound = midPoint + 1;
		}
		return -1;
	}

	// binary search recursive
	public static int binarySearchReccursive(int[] nums, int target) { // o(logn)
		return find(nums, 0, nums.length - 1, target);
	}

	private static int find(int[] nums, int st, int end, int target) {
		if (st > end)
			return -1;
		int mid = st + (end - st) / 2; // notice: Avoid OverFlow
		if (nums[mid] == target)
			return mid;
		else if (nums[mid] > target)
			return find(nums, st, mid - 1, target);
		else
			return find(nums, mid + 1, end, target);

	}

	// Binary Search for Real Value

	// https://leetcode.com/problems/sqrtx/
	public static int mySqrtd(int x) {
		double start = 0, end = x, mid;

		while (end - start > 1e-9) {
			mid = start + (end - start) / 2;
			if (mid * mid < x)
				start = mid;
			else
				end = mid;
		}
		return (int) (start + 1e-9); // if start == 1.99999, this would make it 2
	}

	// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
	public static int[] searchRange(int[] nums, int target) {
		int[] res = new int[2];
		res[0] = findFirst(nums, target);
		res[1] = findLast(nums, target);
		return res;
	}

	private static int findFirst(int[] nums, int target) {
		int lowerBound = 0, upperBound = nums.length - 1, mid, position = -1;

		while (lowerBound <= upperBound) {
			mid = (lowerBound + upperBound) / 2;

			if (nums[mid] > target)
				upperBound = mid - 1;
			else if (nums[mid] == target) {
				position = mid;
				upperBound = mid - 1;
			} else
				lowerBound = mid + 1;
		}
		return position;
	}

	private static int findLast(int[] nums, int target) {
		int lowerBound = 0, upperBound = nums.length - 1, mid, position = -1;

		while (lowerBound <= upperBound) {
			mid = (lowerBound + upperBound) / 2;

			if (nums[mid] < target)
				lowerBound = mid + 1;
			else if (nums[mid] == target) {
				lowerBound = mid + 1;
				position = mid;
			} else
				upperBound = mid - 1;
		}
		return position;
	}

	// https://leetcode.com/problems/find-right-interval/

	public static int[] findRightInterval(int[][] intervals) {
		if (intervals.length == 1)
			return new int[] { -1 };
		// setup...
		Map<Integer, Integer> map = new TreeMap<>();
		// add every start of an interval mapped to it's index in treemap to sort them
		for (int i = 0; i < intervals.length; i++) { // o(nlogn)
			map.put(intervals[i][0], i);
		}
		int[] data = new int[intervals.length];
		int[] indeces = new int[intervals.length];
		int i = 0;
		// back them again to array data storage
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			data[i] = entry.getKey();
			indeces[i++] = entry.getValue();
		}
		map.clear();
		// process...
		int[] res = new int[intervals.length];
		for (int j = 0; j < intervals.length; j++) {
			res[j] = findFirst(intervals[j][1], data, indeces);
		}
		return res;
	}

	private static int findFirst(int target, int[] data, int[] indeces) {
		int lowerBound = 0, upperBound = data.length - 1, mid, position = -1;

		while (lowerBound <= upperBound) {
			mid = (lowerBound + upperBound) / 2;

			if (data[mid] >= target) {
				position = mid;
				upperBound = mid - 1;
			} else
				lowerBound = mid + 1;
		}
		return position == -1 ? -1 : indeces[position];
	}

	// https://leetcode.com/problems/valid-triangle-number/
	// --------- approach 1-----
	public static int triangleNumber(int[] nums) { // o(n^3)
		if (nums.length < 2)
			return 0;
		Arrays.sort(nums); // o(nlogn)
		int sum = 0, count = 0;
		for (int i = 0; i < nums.length - 2; i++) { // o(n^3)
			for (int j = i + 1; j < nums.length - 1; j++) {
				sum = nums[i] + nums[j];
				for (int j2 = j + 1; j2 < nums.length && nums[j2] < sum; j2++) {
					count++;
				}
			}
		}
		return count;
	}

	// ------ approach 2
	public static int triangleNumber_v2(int[] nums) { // o(n^2 log n)
		if (nums.length < 2)
			return 0;
		Arrays.sort(nums); // o(nlogn)
		int sum = 0, count = 0, k;
		for (int i = 0; i < nums.length - 2; i++) {// o(n^2 log n)
			for (int j = i + 1; j < nums.length - 1; j++) {
				if (nums[i] == 0 || nums[j] == 0)
					break;
				sum = nums[i] + nums[j];
				k = findFirst(sum, nums, j + 1);// find first value <= sum
				count += (k - j - 1);
			}
		}
		return count;
	}

	private static int findFirst(int target, int[] nums, int lowerBound) {
		int upperBound = nums.length - 1, mid, position = nums.length - 1;

		while (lowerBound <= upperBound) {
			mid = (lowerBound + upperBound) / 2;

			if (nums[mid] >= target) {
				position = mid;
				upperBound = mid - 1;
			} else
				lowerBound = mid + 1;
		}
		return position;
	}

	// ----- approach 3
	public static int triangleNumber_v3(int[] nums) { // o(n^2)
		if (nums.length < 2)
			return 0;
		Arrays.sort(nums); // o(nlogn)
		int sum = 0, count = 0, k = 0;
		for (int i = 0; i < nums.length - 2; i++) { // o(n^2)
			k = i + 2;
			for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
				sum = nums[i] + nums[j];
				while (k < nums.length && nums[k] < sum) {
					k++;
				}
				count += k - j - 1;
			}
		}
		return count;
	}

	// https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/

	public static int smallestDivisor(int[] nums, int threshold) { // o(n log mxVal)
		Arrays.sort(nums);
		int len = nums.length;
		int max = nums[len - 1];
		return BSFindFirst(max, nums, threshold);
	}

	private static int BSFindFirst(int max, int[] nums, int threshold) {
		int st = 0, end = max, pos = end, mid;
		while (st <= end) {
			mid = st + (end - st) / 2;
			if (getSum(mid, nums) <= threshold) {
				pos = mid;
				end = mid - 1;
			} else
				st = mid + 1;
		}
		return pos;
	}

	private static int getSum(int divisor, int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += (int) Math.ceil((double) nums[i] / divisor);
		}
		return sum;
	}

	// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/

	public static int minDays(int[] bloomDay, int m, int k) { // o(n log maxVal)
		if (bloomDay.length < m * k)
			return -1;
		int max = 1;
		// find max
		for (int i = 0; i < bloomDay.length; i++) { // o(n)
			if (bloomDay[i] > max)
				max = bloomDay[i];
		}
		int st = 1, end = max, mid, minDay = 1;
		while (st <= end) { // o(n log maxVal)
			mid = st + (end - st) / 2;
			if (possible(bloomDay, mid, m, k)) {
				minDay = mid;
				end = mid - 1;
			} else
				st = mid + 1;
		}
		return minDay;
	}

	private static boolean possible(int[] bloomDay, int minDay, int maxBouquets, int maxFlourPerBouquet) { // o(n)
		int curBouquets = 0, curFlowers = 0;
		for (int i = 0; i < bloomDay.length; i++) {
			if (bloomDay[i] <= minDay) {
				curFlowers++;
				if (curFlowers == maxFlourPerBouquet) {
					curFlowers = 0;
					curBouquets++;
				}
				if (curBouquets == maxBouquets)
					return true;
			} else
				curFlowers = 0;
		}
		return false;
	}

	// https://leetcode.com/problems/heaters/

	public static int findRadius(int[] houses, int[] heaters) {
		Arrays.sort(heaters); // o(mlogm)
		Arrays.sort(houses);// o(nlogn)

		int st = 0, end = (int) 1e9, mid, radius = 0;
		while (st <= end) { // o(nlogk + mlogk), while n => houses - m => heaters - k => limit of the
							// problem
			mid = st + (end - st) / 2;
			if (possible(houses, heaters, mid)) {
				end = mid - 1;
				radius = mid;
			} else {
				st = mid + 1;
			}
		}
		return radius;
	}

	private static boolean possible(int[] houses, int[] heaters, int radius) {
		int i = 0;
		for (int heater : heaters) { // o(m + n)
			int left = heater - radius, right = heater + radius;
			while (i < houses.length && houses[i] >= left && houses[i] <= right) {
				i++;
			}
		}
		return i == houses.length;
	}

	// https://techiedelight.com/practice/?problem=SmallestMissingNumber

	public static int findSmallestMissingNumber(int[] nums) {
		int st = 0, end = (int) 1e8, mid, missingNum = -1;

		while (st <= end) {
			mid = st + (end - st) / 2;

			if (mid > nums.length - 1 || nums[mid] != mid) {
				missingNum = mid;
				end = mid - 1;
			} else
				st = mid + 1;
		}
		return missingNum;
	}

	// https://leetcode.ca/all/1060.html ----- ( hard )

	public static int missingElement(int[] arr, int k) {
		int st = 0, end = (int) arr.length - 1, mid, missingElementIndex = arr.length - 1;

		int temp = numOfMissingElement(arr, missingElementIndex);
		if (k > temp) {
			return arr[missingElementIndex] + (k - temp);
		}

		while (st <= end) {
			mid = st + (end - st) / 2;
			if (numOfMissingElement(arr, mid) >= k) {
				missingElementIndex = mid;
				end = mid - 1;
			} else {
				st = mid + 1;
			}
		}

		temp = numOfMissingElement(arr, missingElementIndex - 1);
		return arr[missingElementIndex - 1] + (k - temp);
	}

	private static int numOfMissingElement(int[] nums, int index) {
		return nums[index] - nums[0] - index;
	}

	// https://leetcode.com/problems/kth-missing-positive-number/

	public int findKthPositive(int[] arr, int k) {
		int st = 0, end = (int) arr.length - 1, mid, missingElementIndex = arr.length - 1;

		int temp = numOfMissingElem(arr, missingElementIndex);
		if (k > temp) {
			return arr[missingElementIndex] + (k - temp);
		}

		while (st <= end) {
			mid = st + (end - st) / 2;
			if (numOfMissingElem(arr, mid) >= k) {
				missingElementIndex = mid;
				end = mid - 1;
			} else {
				st = mid + 1;
			}
		}

		temp = numOfMissingElem(arr, missingElementIndex - 1);
		return arr[missingElementIndex - 1] + (k - temp);
	}

	private static int numOfMissingElem(int[] nums, int index) {
		return nums[index] - 1 - index;
	}
}
