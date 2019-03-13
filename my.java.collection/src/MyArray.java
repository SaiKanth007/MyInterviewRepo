package src;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import src.Utilities.JavaUtility;;

/*
 * //*********************************************** // Copyright UNITEDHEALTH GROUP CORPORATION 2018. // This software
 * and documentation contain confidential and // proprietary information owned by UnitedHealth Group Corporation. //
 * Unauthorized use and distribution are prohibited. //***********************************************
 */

/**
 */
public class MyArray {

	public static void main(String[] args) {

		final int[] arrayForBubbleSort = { 4, 5, 3, 2, -1, -1 };
		JavaUtility.printBeforeSorting(arrayForBubbleSort);
		bubbleSort(arrayForBubbleSort);
		JavaUtility.printAfterSorting(arrayForBubbleSort, "bubble");

		final int[] arrayForSelectionSort = { -1, 0, -2, 5, 6, -1 };
		JavaUtility.printBeforeSorting(arrayForSelectionSort);
		selectionSort(arrayForSelectionSort);
		JavaUtility.printAfterSorting(arrayForSelectionSort, "selection");

		final int[] arrayForInsertionSort = { -1, 0, -2, 5, 6, -1 };
		JavaUtility.printBeforeSorting(arrayForInsertionSort);
		insertionSort(arrayForInsertionSort);
		JavaUtility.printAfterSorting(arrayForInsertionSort, "insertion");

		final int[] arrayForMergeSort = { 0, 5, -1, -2, 6, -1 };
		JavaUtility.printBeforeSorting(arrayForMergeSort);
		mergeSort(arrayForMergeSort, 0, arrayForMergeSort.length - 1);
		JavaUtility.printAfterSorting(arrayForMergeSort, "merge");

		final int[] arrayForHeapSort = { 12, 11, 10, 5, 13, 7 };
		JavaUtility.printBeforeSorting(arrayForHeapSort);
		heapSort(arrayForHeapSort);
		JavaUtility.printAfterSorting(arrayForHeapSort, "heap");

		final int[] arrayForQuickSort = { 12, 11, 10, 5, 13, 7, 7 };
		JavaUtility.printBeforeSorting(arrayForQuickSort);
		quickSort(arrayForQuickSort, 0, arrayForQuickSort.length - 1);
		JavaUtility.printAfterSorting(arrayForQuickSort, "quick");

		final int[] arrayForKthLargestElement = { 12, 5, 787, 1, 23 };
		System.out.println("The array for kth smallest element is: ");
		JavaUtility.print(arrayForKthLargestElement);
		final int k = 2;
		System.out.println(
				"The " + k + "th smallest element is: " + findKthSmallestElement(arrayForKthLargestElement, k));

		final int[] arrayForBinarySearch = { 1, 2 };
		selectionSort(arrayForBinarySearch);
		System.out.println("The index of the search is: "
				+ binarySearch(arrayForBinarySearch, 0, arrayForBinarySearch.length - 1, 2));

		final int[] arrayForBinarySearchForRepeated = { 0, 5, -1, -2, 6, -1 };
		selectionSort(arrayForBinarySearchForRepeated);
		System.out.println("The index of the search is: " + binarySearchWithRepeatedElements(
				arrayForBinarySearchForRepeated, 0, arrayForBinarySearchForRepeated.length - 1, -1));

		final int[] arrayForprintElementsWithGivenSum = { 0, 5, -1, -2, 6 };
		System.out.println("The Elements with the given sum are :");
		printElementsWithGivenSum(arrayForprintElementsWithGivenSum, 4);

		System.out.println("Number to words: " + convertNumberToWords(1000000));

		final int[] zeroOneTwoArray = { 2, 1, 0, 2, 1, 0, 1, 2, 0, 0, 2, 0, 1, 2 };
		sortZerosOnesTwos(zeroOneTwoArray);
		JavaUtility.print(zeroOneTwoArray);

		final Integer[] maxSumContigiousArray = { 12, -3, 4, -1, -2, 1, 5, 33 };
		System.out.println(
				"Maximum value of contigious sub arrays is:" + findLargetSumContiguousArray(maxSumContigiousArray));

		final int[] maxSumContigiousIncreasingArray = { -2, -3, 4, -1, -2, 1, 5, -3, 8 };
		System.out.println("Maximum value of increasing contigious sub arrays is:"
				+ findLargetSumContiguousIncreasingArray(maxSumContigiousIncreasingArray));

		final int[] arrayForReverse = { 1, 2, 3, 4, 5, 6, 7, 8 };
		JavaUtility.reverseArray(arrayForReverse);
		JavaUtility.print(arrayForReverse);
		JavaUtility.reverseArray(arrayForReverse, 2, 6);
		JavaUtility.print(arrayForReverse);

		final int[] arrayForRotate = { 1, 2, 3, 4, 5, 6, 7, 8 };
		rotateArray(arrayForRotate, 0);
		JavaUtility.print(arrayForRotate);

		final int[] arrayForRotatedBinarySearch = { 30, 40, 50, 10, 20 };
		binarySearchInSortedAndRotatedArray(arrayForRotatedBinarySearch, 0, arrayForRotatedBinarySearch.length - 1, 30);

		final int[] arrivalTimes = { 900, 940, 950, 1100, 1500, 1800 };
		final int[] deptTimes = { 910, 1200, 1120, 1130, 1900, 2000 };
		System.out.println("Total no of platforms required are:" + minNumberOfPlatforms(arrivalTimes, deptTimes));

		final int[] arrayForRightGreaterandLeftlesser = { 5, 1, 4, 4 };
		System.out.println("Finding the index for which left elements are smaller and right elemnents are larger: "
				+ findElementWithGivenCriteria(arrayForRightGreaterandLeftlesser));

		final int[] largestSubArrayWithEqualNumberOfOnesAndZeros = { 1, 0, 0, 0, 0, 1, 1 };
		System.out.println("The size of the largest sub array with equal numners of ones and zeros is: "
				+ maxLen(largestSubArrayWithEqualNumberOfOnesAndZeros));

		final int[] arrayOfWater = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println("The amount of water stored is: " + findAmountOfWater(arrayOfWater));

		final int[] minArrayLengthToMakeArraySorted = { 10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60 };
		System.out.println("The mimimum size of the array that is to be sorted is :"
				+ minArrayLengthToMakeArraySorted(minArrayLengthToMakeArraySorted));

		final int[] sortAlmostedSortedArray = { 2, 2, 2, 2, 0 };
		sortAlmostedSortedArray(sortAlmostedSortedArray);

		final int[] stocksValue = { 50, 100, 230, 321, 123, 111, 300, 500	 };
		System.out.println("The maximum profit from the stock sale is:" + stockSellProblem(stocksValue));
	}

	public static void bubbleSort(int[] inputArray) {
		final int length = inputArray.length;
		for (int index = 0; index < length; index++) {
			for (int innerIndex = 0; innerIndex < length - index - 1; innerIndex++) {
				if (inputArray[innerIndex] > inputArray[innerIndex + 1]) {
					JavaUtility.swap(inputArray, innerIndex + 1, innerIndex);
				}
			}
		}
	}

	public static void selectionSort(int[] inputArray) {
		final int length = inputArray.length;
		for (int index = 0; index < length; index++) {
			for (int innerIndex = index + 1; innerIndex < length; innerIndex++) {
				if (inputArray[index] > inputArray[innerIndex]) {
					JavaUtility.swap(inputArray, index, innerIndex);
				}
			}
		}
	}

	// working
	public static void mergeSort(int[] inputArray, int lowerIndex, int upperIndex) {
		if (lowerIndex < upperIndex) {
			final int midIndex = (lowerIndex + upperIndex) / 2;
			mergeSort(inputArray, lowerIndex, midIndex);
			mergeSort(inputArray, midIndex + 1, upperIndex);
			merge(inputArray, lowerIndex, midIndex, upperIndex);
		}
	}

	public static void merge(int[] inputArray, int lowerIndex, int midIndex, int upperIndex) {
		if (lowerIndex < upperIndex) {
			final int[] result = new int[upperIndex - lowerIndex + 1];
			int l = lowerIndex;
			int h = midIndex + 1;
			int index = 0;
			while (l <= midIndex && h <= upperIndex) {
				if (inputArray[l] < inputArray[h]) {
					result[index++] = inputArray[l++];
				} else {
					result[index++] = inputArray[h++];
				}
			}

			while (l <= midIndex) {
				result[index++] = inputArray[l++];
			}

			while (h <= upperIndex) {
				result[index++] = inputArray[h++];
			}
			for (int k = upperIndex; k >= lowerIndex; k--) {
				inputArray[k] = result[--index];
			}

		}
	}

	public static void quickSort(int[] array, int lowerIndex, int upperIndex) {
		if (lowerIndex < upperIndex) {
			final int pivot = getPivot(array, lowerIndex, upperIndex);
			quickSort(array, lowerIndex, pivot - 1);
			quickSort(array, pivot + 1, upperIndex);

		}
	}

	public static int getPivot(int[] array, int lowerIndex, int upperIndex) {
		int k = lowerIndex;
		final int pivot = array[upperIndex];
		for (int i = lowerIndex; i < upperIndex; i++) {
			if (array[i] <= pivot) {
				JavaUtility.swap(array, k, i);
				k++;
			}
		}
		JavaUtility.swap(array, k, upperIndex);
		return k;
	}

	public static void insertionSort(int[] array) {
		final int length = array.length;
		int key = -1;
		int j = -1;
		for (int i = 1; i < length; i++) {
			key = array[i];
			j = i - 1;
			while (j >= 0 && array[j] > key) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = key;
		}
	}

	// other appraoch is to use minHeap and constructing the minheap for k elements
	// https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-2-expected-linear-time/
	public static int findKthSmallestElement(int[] array, int kthSmallest) {
		final int length = array.length;
		int lowerIndex = 0;
		int upperIndex = length - 1;
		while (lowerIndex <= upperIndex) {
			final int pivot = getPivot(array, lowerIndex, upperIndex);
			if (pivot + 1 == kthSmallest) {
				return array[pivot];
			} else if (kthSmallest > pivot) {
				lowerIndex = pivot + 1;
			} else {
				upperIndex = pivot - 1;
			}
		}
		return -1;
	}

	// yet to be done
	public static void findKthLargestElementUsingMaxHeap(int[] input, int kthSmallest) {
		final int length = input.length;
		//
	}

	// also do this, once heap sort is done
	// https://ideone.com/qFA0xX
	public static void heapSort(int[] input) {
		final int length = input.length;

		// this logic is basically for constructing the heap, takes O(n/2 * log(N) time
		// complexity)
		for (int i = length / 2 - 1; i >= 0; i--) {
			heapify(input, i, length);
		}

		for (int i = length - 1; i > 0; i--) {
			JavaUtility.swap(input, 0, i);
			heapify(input, 0, i);
		}
	}

	public static void heapify(int[] input, int i, int length) {
		final int x = 2 * i + 1;
		final int y = 2 * i + 2;
		int max = i;
		if (x < length && input[x] > input[max]) {
			max = x;
		}
		if (y < length && input[y] > input[max]) {
			max = y;

		}
		if (max != i) {
			JavaUtility.swap(input, i, max);
			heapify(input, max, length);
		}
	}

	public static int binarySearch(int[] inputArray, int lowerIndex, int upperIndex, int searchKey) {
		if (lowerIndex <= upperIndex) {
			final int midIndex = (lowerIndex + upperIndex) / 2;
			if (inputArray[midIndex] == searchKey) {
				return midIndex;
			}
			final int index = binarySearch(inputArray, lowerIndex, midIndex - 1, searchKey);
			if (index == -1) {
				return binarySearch(inputArray, midIndex + 1, upperIndex, searchKey);
			}
			return index;
		}
		return -1;
	}

	public static int binarySearchWithRepeatedElements(int[] inputArray, int lowerIndex, int upperIndex,
			int searchKey) {
		if (lowerIndex <= upperIndex) {
			final int midIndex = (lowerIndex + upperIndex) / 2;
			if (inputArray[midIndex] == searchKey) {
				if (lowerIndex < midIndex && inputArray[midIndex - 1] == searchKey) {
					return binarySearchWithRepeatedElements(inputArray, lowerIndex, midIndex - 1, searchKey);
				}
				return midIndex;
			}
			final int index = binarySearchWithRepeatedElements(inputArray, lowerIndex, midIndex - 1, searchKey);
			if (index == -1) {
				return binarySearchWithRepeatedElements(inputArray, midIndex + 1, upperIndex, searchKey);
			}
			return index;
		}
		return -1;
	}

	public static void printElementsWithGivenSum(int[] inputArray, int sum) {
		final int size = inputArray.length;
		mergeSort(inputArray, 0, size - 1);
		int upperIndex = size - 1;
		int index = 0;
		System.out.println("The elements with the given sum are: ");
		while (index < size && index < upperIndex) {
			if (sum == inputArray[index] + inputArray[upperIndex]) {
				System.out.println(inputArray[index] + " " + inputArray[upperIndex]);
				index++;
			} else if (sum < inputArray[index] + inputArray[upperIndex]) {
				upperIndex--;
			} else {
				index++;
			}
		}
	}

	// print numbers in words
	public static String convertNumberToWords(Integer number) {
		final Map<Integer, String> map = JavaUtility.NumbersToWordsMap();
		StringBuilder result = new StringBuilder();
		Integer dividend = 0;
		if (number <= 20) {
			return map.get(number);
		}

		if (number / 100000 != 0) {
			dividend = number / 100000;
			result = result.append(JavaUtility.NumberToWordsUtil(dividend)).append(" lakhs ");
			number = number % 100000;
		}
		if (number / 1000 != 0) {
			dividend = number / 1000;
			result = result.append(JavaUtility.NumberToWordsUtil(dividend)).append(" thousands ");
			number = number % 1000;
		}
		if (number / 100 != 0) {
			dividend = number / 100;
			result = result.append(JavaUtility.NumberToWordsUtil(dividend)).append(" hundred and ");
			number = number % 100;
		}
		if (number != 0) {
			result = result.append(JavaUtility.NumberToWordsUtil(number));
		}

		return result.toString();
	}

	// https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
	// kadanesAlgorithm
	public static Integer findLargetSumContiguousArray(Integer[] array) {
		int localSum = 0;
		int globalSum = 0;
		for (final Integer element : array) {
			localSum = localSum + element;
			localSum = Math.max(localSum, 0);
			globalSum = Math.max(localSum, globalSum);
		}
		return globalSum;
	}

	// https://www.geeksforgeeks.org/largest-sum-contiguous-increasing-subarray/
	// working for negative numbers also need to check for more cases
	public static Integer findLargetSumContiguousIncreasingArray(int[] array) {
		int localSumStartIndex = 0;
		int globalSumStartIndex = 0;
		int gloablSumEndIndex = 0;
		int localSum = array[0];
		int globalSum = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[i - 1]) {
				if (localSum > globalSum) {
					globalSum = localSum;
					globalSumStartIndex = localSumStartIndex;
					gloablSumEndIndex = i - 1;
				}
				localSumStartIndex = i;
				localSum = array[i];
			} else {
				localSum = localSum + array[i];
			}

			if (localSum < 0) {
				localSum = 0;
				localSumStartIndex++;
			}
		}

		if (localSum > globalSum) {
			globalSum = localSum;
			globalSumStartIndex = localSumStartIndex;
			gloablSumEndIndex = array.length - 1;
		}

		for (int i = globalSumStartIndex; i <= gloablSumEndIndex; i++) {
			System.out.print(array[i] + " ");
		}
		return globalSum;
	}

	// https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
	public static void sortZerosOnesTwos(int[] array) {

		final int length = array.length;
		int j = length - 1;
		int k = 0;
		for (int i = 0; i < length && i <= j; i++) {
			switch (array[i]) {
			case 0:
				JavaUtility.swap(array, i, k);
				k++;
				break;
			case 2:
				JavaUtility.swap(array, i, j);
				i--;
				j--;
				break;
			default:

			}
		}
	}

	public static void rotateArray(int[] array, int noOfRotations) {
		JavaUtility.reverseArray(array, 0, noOfRotations - 1);
		JavaUtility.reverseArray(array, noOfRotations, array.length - 1);
		JavaUtility.reverseArray(array, 0, array.length - 1);

	}

	// working
	public static void binarySearchInSortedAndRotatedArray(int[] array, int lowerIndex, int upperIndex, int key) {
		if (lowerIndex <= upperIndex) {

			final int midIndex = (lowerIndex + upperIndex) / 2;
			if (array[midIndex] == key) {
				System.out.println("Element found at index in sorted and rotated array: " + midIndex);
				return;
			}

			if (array[lowerIndex] <= array[midIndex]) {
				if (array[lowerIndex] <= key && key < array[midIndex]) {
					binarySearchInSortedAndRotatedArray(array, lowerIndex, midIndex - 1, key);
				} else {
					binarySearchInSortedAndRotatedArray(array, midIndex + 1, upperIndex, key);
				}

			} else {
				if (array[midIndex] < key && key <= array[upperIndex]) {
					binarySearchInSortedAndRotatedArray(array, midIndex + 1, upperIndex, key);
				} else {
					binarySearchInSortedAndRotatedArray(array, lowerIndex, midIndex - 1, key);
				}
			}
		} else {
			return;
		}
	}

	public static int minNumberOfPlatforms(int[] arrivalTimes, int[] deptTimes) {
		Arrays.sort(arrivalTimes);
		Arrays.sort(deptTimes);
		int noOfPlatforms = 1;
		int totalNumberOfPlatforms = 0;
		final int length = arrivalTimes.length;
		int j = 0, i = 1;
		while (i < length && j < length) {
			if (arrivalTimes[i] <= deptTimes[j]) {
				noOfPlatforms = noOfPlatforms + 1;
				if (noOfPlatforms > totalNumberOfPlatforms) {
					totalNumberOfPlatforms = noOfPlatforms;
				}
				i++;
			} else {
				noOfPlatforms--;
				j++;
			}
		} // plat_needed indicates number of platforms

		return totalNumberOfPlatforms;

	}

	// https://www.geeksforgeeks.org/find-the-element-before-which-all-the-elements-are-smaller-than-it-and-after-which-all-are-greater-than-it/
	// working
	public static int findElementWithGivenCriteria(int[] array) {
		final int length = array.length;
		final boolean[] rightMaxArray = new boolean[length];
		final boolean[] leftMaxArray = new boolean[length];

		int rightMax = Integer.MIN_VALUE;
		int rightMin = Integer.MAX_VALUE;
		for (int i = length - 1; i >= 0; i--) {
			if (array[i] < rightMax && array[i] < rightMin) {
				rightMaxArray[i] = true;
			}
			rightMax = Math.max(rightMax, array[i]);
			rightMin = Math.min(rightMin, array[i]);

		}

		int leftMax = Integer.MIN_VALUE;
		int leftMin = Integer.MAX_VALUE;
		for (int i = 0; i < length; i++) {
			if (array[i] > leftMax && array[i] > leftMin) {
				leftMaxArray[i] = true;
			}
			leftMax = Math.max(leftMax, array[i]);
			leftMin = Math.min(leftMin, array[i]);

		}

		for (int i = length - 1; i >= 0; i--) {
			if (leftMaxArray[i] && rightMaxArray[i]) {
				return i;
			}
		}
		return -1;
	}

	// https://www.geeksforgeeks.org/largest-subarray-with-equal-number-of-0s-and-1s/
	// similary we can print the sub array
	// v.v.v imp
	static int maxLen(int arr[]) {
		// Creates an empty hashMap hM
		final int n = arr.length;
		final HashMap<Integer, Integer> hM = new HashMap();

		int sum = 0; // Initialize sum of elements
		int max_len = 0; // Initialize result
		int ending_index = -1;

		for (int i = 0; i < n; i++) {
			arr[i] = arr[i] == 0 ? -1 : 1;
		}

		for (int i = 0; i < n; i++) {

			sum += arr[i];

			if (sum == 0) {
				max_len = i + 1;
				ending_index = i;
			}

			if (hM.containsKey(sum + n)) {
				if (max_len < i - hM.get(sum + n)) {
					max_len = i - hM.get(sum + n);
					ending_index = i;
				}
			} else {
				hM.put(sum + n, i);
			}
		}

		for (int i = 0; i < n; i++) {
			arr[i] = arr[i] == -1 ? 0 : 1;
		}

		final int end = ending_index - max_len + 1;
		System.out.println(end + " to " + ending_index);

		return max_len;
	}

	// rain water problem
	// https://www.geeksforgeeks.org/trapping-rain-water/
	public static int findAmountOfWater(int[] array) {
		final int length = array.length;
		final int[] leftMax = new int[length];
		final int[] rightMax = new int[length];

		leftMax[0] = array[0];
		for (int i = 1; i < length; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], array[i]);
		}

		rightMax[length - 1] = array[length - 1];
		for (int i = length - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], array[i]);
		}

		int water = 0;
		for (int i = 1; i < length; i++) {
			water = water + Math.min(leftMax[i], rightMax[i]) - array[i];
		}
		return water;

	}

	// https://www.geeksforgeeks.org/minimum-length-unsorted-subarray-sorting-which-makes-the-complete-array-sorted/
	// working
	public static int minArrayLengthToMakeArraySorted(int[] array) {

		final int length = array.length;

		int lowerIndex = -1, upperIndex = -1;
		int lowerIndexValue = Integer.MAX_VALUE;
		int upperIndexValue = Integer.MIN_VALUE;

		for (int i = 1; i < length; i++) {
			if (array[i] < array[i - 1] && array[i] < lowerIndexValue) {
				lowerIndex = i;
				lowerIndexValue = array[lowerIndex];
			}
		}

		lowerIndexValue = array[lowerIndex];
		while (lowerIndex > 0 && lowerIndexValue < array[lowerIndex - 1]) {
			lowerIndex--;
		}

		for (int i = length - 2; i >= 0; i--) {
			if (array[i] > array[i + 1] && array[i] > upperIndexValue) {
				upperIndex = i;
				upperIndexValue = array[upperIndex];
			}
		}

		while (upperIndex < length - 1 && upperIndexValue > array[upperIndex + 1]) {
			upperIndex++;
		}

		return upperIndex - lowerIndex + 1;
	}

	// https://www.geeksforgeeks.org/maximum-product-subarray/
	// contains both positive and negative integers, yet to do
	public static int findMaxSubArray(int[] array) {
		int length = array.length;
		int maxTillNow = 1;
		int minTillNow = 1;
		int globalMax = 1;
		for (int i = 0; i < length; i++) {
			if (array[i] > 0) {
				maxTillNow = maxTillNow * array[i];
				minTillNow = Math.min(minTillNow * array[i], 1);
			} else if (array[i] == 0) {
				maxTillNow = 1;
				minTillNow = 1;
			} else {
				int temp = maxTillNow;
				maxTillNow = Math.max(minTillNow * array[i], 1);
				minTillNow = temp * array[i];
			}

			if (maxTillNow > globalMax) {
				globalMax = maxTillNow;
			}
		}
		return 0;
	}

	// https://www.geeksforgeeks.org/sort-an-almost-sorted-array-where-only-two-elements-are-swapped/
	// working
	public static void sortAlmostedSortedArray(int[] array) {
		int length = array.length;
		int leftElementToBeSwapped = -1;
		int rightElementToBeSwapped = -1;
		for (int i = 0; i < length - 2; i++) {
			// "=" check is to cover corner scenario's like [2,2,2,0]
			if (array[i] >= array[i + 1]) {
				leftElementToBeSwapped = i;
				break;
			}
		}
		for (int i = length - 1; i > 0; i--) {
			if (array[i] <= array[i - 1]) {
				rightElementToBeSwapped = i;
				break;
			}
		}
		System.out.println(
				"Elements to be sorted are " + array[leftElementToBeSwapped] + " " + array[rightElementToBeSwapped]);
		if (rightElementToBeSwapped != -1 && leftElementToBeSwapped != -1)
			JavaUtility.swap(array, rightElementToBeSwapped, leftElementToBeSwapped);
	}

	// https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
	public static void slidingWindowMaximum() {

	}

	// https://www.geeksforgeeks.org/find-the-maximum-repeating-number-in-ok-time/
	// when ever it is said that array contains elements only less than k or some
	// value
	// try to think of bucket sort where we can make use of the input condition,
	// array[i]%k<=k
	public static int findMostRepeatedElementInArray() {
		return 0;
	}

	// https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
	public static void printMaxInSlidingWindow() {

	}

	// https://www.geeksforgeeks.org/stock-buy-sell/
	// working
	public static int stockSellProblem(int[] stocks) {
		int length = stocks.length;
		int buy = -1;
		int sell = -1;
		Integer profit = 0;
		if (length == 0 || length == 1)
			return 0;
		else {
			int i = 0;
			while (i < length - 1) {
				while (i < length - 1 && stocks[i + 1] <= stocks[i]) {
					i++;
				}
				if (i == length - 1)
					break;
				buy = i++;
				while (i < length && stocks[i] >= stocks[i - 1]) {
					i++;
				}
				sell = i - 1;
				profit = profit + stocks[sell] - stocks[buy];
			}
		}
		return profit;
	}
	// array rotation
	// stocks buy
	// max incresing sub sequence
	// finding square root
	// next smallest polindrome

}
