package src;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import src.Utilities.JavaUtility;;

/*
 * When to use which sorting algorithm - https://stackoverflow.com/questions/1933759/when-is-each-sorting-algorithm-used
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

		final int[] arrayForMergeSortInplace = { 0, 5, -1, -2, 6, -1 };
		JavaUtility.printBeforeSorting(arrayForMergeSortInplace);
		mergeSortInPlace(arrayForMergeSortInplace, 0, arrayForMergeSortInplace.length - 1,
				JavaUtility.findMaxElement(arrayForMergeSortInplace));
		JavaUtility.printAfterSorting(arrayForMergeSort, "mergeInplace");

		final int[] arrayForHeapSort = { 12, 11, 10, 5, 13, 7 };
		JavaUtility.printBeforeSorting(arrayForHeapSort);
		heapSort(arrayForHeapSort);
		JavaUtility.printAfterSorting(arrayForHeapSort, "heap");

		final int[] arrayForQuickSort = { 12, 11, 10, 5, 13, 7, 7 };
		JavaUtility.printBeforeSorting(arrayForQuickSort);
		quickSort(arrayForQuickSort, 0, arrayForQuickSort.length - 1);
		JavaUtility.printAfterSorting(arrayForQuickSort, "quick");

		final int[] arrayForCoutingSort = { 1, 4, 1, 2, 7, 5, 2 };
		JavaUtility.printBeforeSorting(arrayForCoutingSort);
		CountingSort(arrayForCoutingSort);
		JavaUtility.printAfterSorting(arrayForCoutingSort, "Couting Sort");

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

		final int[] arrayForBinarySearchForRepeated = { 0, 5, -1, -2, 6, -1, -10 };
		selectionSort(arrayForBinarySearchForRepeated);
		System.out
				.println("The index of the search in sorted and repated arary is: " + binarySearchWithRepeatedElements(
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

		final int[] arrayForSortedIfNegativeMadePositive = { 10, -20, 20, -20, 20, 30, 30, -30, -40, -50, -60, 70, 90 };
		System.out
				.println("The index for a given key in the array that will be sorted when negatives made positive is : "
						+ getSearchIndex(arrayForSortedIfNegativeMadePositive, 0,
								arrayForSortedIfNegativeMadePositive.length - 1, 20));

		final int[] arrivalTimes = { 900, 940, 950, 1100, 1500, 1800 };
		final int[] deptTimes = { 910, 1200, 1120, 1130, 1900, 2000 };
		System.out.println("Total no of platforms required are:" + minNumberOfPlatforms(arrivalTimes, deptTimes));

		final int[] arrayForRightGreaterandLeftlesser = { 5, 1, 4, 4 };
		System.out.println("Finding the index for which left elements are smaller and right elemnents are larger: "
				+ findElementWithGivenCriteria(arrayForRightGreaterandLeftlesser));

		// { 1, 0, 0, 0, 0, 1, 1 };
		final int[] largestSubArrayWithEqualNumberOfOnesAndZeros = { 1, 0, 1, 1, 0, 0, 1 };
		System.out.println("The size of the largest sub array with equal numners of ones and zeros is: "
				+ maxLen(largestSubArrayWithEqualNumberOfOnesAndZeros));

		final int[] arrayOfWater = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println("The amount of water stored is: " + findAmountOfWater(arrayOfWater));

		final int[] minArrayLengthToMakeArraySorted = { 10, 12, 20, 30, 16, 14, 40, 32, 31, 35, 50, 60 };
		System.out.println("The mimimum size of the array that is to be sorted is :"
				+ minArrayLengthToMakeArraySorted(minArrayLengthToMakeArraySorted));

		final int[] sortAlmostedSortedArray = { 2, 2, 2, 2, 0 };
		sortAlmostedSortedArray(sortAlmostedSortedArray);

		final int[] stocksValue = { 50, 100, 230, 321, 123, 111, 300, 500 };
		System.out.println("The maximum profit from the stock sale is:" + stockSellProblem(stocksValue));

		int[] sortedArray1 = { 1, 12, 15, 26, 38 };
		int[] sortedArray2 = { 2, 13, 17, 30, 45 };
		System.out.println(
				"Median of the sorted arrays is" + medianOfTwoSortedArraysOfSameLength(sortedArray1, sortedArray2));

		int[] arrayForCountSubArrays = { 9, 4, 20, 3, 10, 5 };
		System.out.println("Number of Sub Sequence is:"
				+ findNoOfSubarraySum(arrayForCountSubArrays, arrayForCountSubArrays.length, 33));
		findSubarrayWithGivenSum(arrayForCountSubArrays, arrayForCountSubArrays.length, 33);

		int[] arrayToFindMinNoOfSwaps = { 4, 3, 2, -1 };
		System.out.println("Minimum no of swaps required to sort the array is:"
				+ minNoOfSwapsRequiredToSortArray(arrayToFindMinNoOfSwaps));

		int[] arrayOneForMedian = { 1, 3 };
		int[] arrayTwoForMedian = { 2 };
		System.out.println("The median of the two sorted arrays is:"
				+ findMedianOfTwoSortedArrays(arrayOneForMedian, arrayTwoForMedian));
		int[] findMaxSubArray = { -2, -3, -5, -2, -40 };
		System.out.println("Max product sub array is:" + findMaxSubArray(findMaxSubArray));

		int[] binarySearchToFindNearestElementLowerThanOrEqualToKey = { 1, 2, 4, 6, 6, 8, 9, 25, 36 };
		System.out.println("The index of the nearest element to the given key is:"
				+ binarySearchToFindNearestElementLowerThanOrEqualToKey(
						binarySearchToFindNearestElementLowerThanOrEqualToKey, 0,
						binarySearchToFindNearestElementLowerThanOrEqualToKey.length - 1, 26));
		int nearestNumberWithOnlyOnesAndZeros = 800;
		System.out.println("The nearest number with only ones and zeros is: "
				+ nearestNumberWithOnlyOnesAndZeros(nearestNumberWithOnlyOnesAndZeros));

		int[] arrayForRearranging = { 1, 3, 5, 7, 2, 4, 6, 8 };
		rearrangeArray(arrayForRearranging);
		System.out.println("Array after rearranging is");
		JavaUtility.print(arrayForRearranging);
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

	// https://www.geeksforgeeks.org/merge-sort-with-o1-extra-space-merge-and-on-lg-n-time/
	// other approach would be shifting the array, but it will time complexity would
	// be O(n^2)
	// https://www.geeksforgeeks.org/merge-one-array-of-size-n-into-another-one-of-size-mn/
	// if one of the array has sufficient empty space, we can make use of it instead
	// of creating a new array
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

	static void mergeSortInPlace(int[] arr, int beg, int mid, int end, int maxele) {
		int i = beg;
		int j = mid + 1;
		int k = beg;
		while (i <= mid && j <= end) {
			if (arr[i] % maxele <= arr[j] % maxele) {
				arr[k] = arr[k] + (arr[i] % maxele) * maxele;
				k++;
				i++;
			} else {
				arr[k] = arr[k] + (arr[j] % maxele) * maxele;
				k++;
				j++;
			}
		}
		while (i <= mid) {
			arr[k] = arr[k] + (arr[i] % maxele) * maxele;
			k++;
			i++;
		}
		while (j <= end) {
			arr[k] = arr[k] + (arr[j] % maxele) * maxele;
			k++;
			j++;
		}

		// Obtaining actual values
		for (i = beg; i <= end; i++) {
			arr[i] = arr[i] / maxele;
		}
	}

	// Recursive merge sort
	// with extra parameter, naxele
	// https://www.geeksforgeeks.org/merge-sort-with-o1-extra-space-merge-and-on-lg-n-time/
	static void mergeSortInPlace(int[] arr, int beg, int end, int maxele) {
		if (beg < end) {
			int mid = (beg + end) / 2;
			mergeSortInPlace(arr, beg, mid, maxele);
			mergeSortInPlace(arr, mid + 1, end, maxele);
			mergeSortInPlace(arr, beg, mid, end, maxele);
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

	// https://www.geeksforgeeks.org/counting-sort/
	// does not work for negative numbers so think once, go through this later
	// thoroughly
	public static void CountingSort(int[] array) {
		int length = array.length;
		int[] count = new int[256];
		int[] output = new int[length];
		for (int i = 0; i < length; i++) {
			count[array[i]]++;
		}
		for (int i = 1; i < 256; i++)
			count[i] += count[i - 1];

		for (int i = length - 1; i >= 0; i--) {
			output[count[array[i]] - 1] = array[i];
			--count[array[i]];
		}
		for (int i = 0; i < length; ++i)
			array[i] = output[i];
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
			if (searchKey < inputArray[midIndex])
				return binarySearch(inputArray, lowerIndex, midIndex - 1, searchKey);
			else
				return binarySearch(inputArray, midIndex + 1, upperIndex, searchKey);
		}
		return -1;
	}

	// has to check for all scenario's
	// also think of finding k nearest elements
	public static int binarySearchToFindNearestElementLowerThanOrEqualToKey(int[] inputArray, int lowerIndex,
			int upperIndex, int searchKey) {
		if (lowerIndex <= upperIndex) {
			if (searchKey >= inputArray[upperIndex])
				return upperIndex;
			else if (searchKey <= inputArray[lowerIndex])
				return lowerIndex;
			final int midIndex = (lowerIndex + upperIndex) / 2;
			if (inputArray[midIndex] == searchKey) {
				return midIndex;
			} else if (midIndex > lowerIndex && inputArray[midIndex] > searchKey
					&& inputArray[midIndex - 1] < searchKey) {
				// instead of returning this, we have to find out which one to return
				return midIndex - 1;
			} else if (midIndex < upperIndex && inputArray[midIndex] < searchKey
					&& inputArray[midIndex + 1] > searchKey) {
				return midIndex + 1;
			}
			if (searchKey < inputArray[midIndex])
				return binarySearchToFindNearestElementLowerThanOrEqualToKey(inputArray, lowerIndex, midIndex - 1,
						searchKey);
			else
				return binarySearchToFindNearestElementLowerThanOrEqualToKey(inputArray, midIndex + 1, upperIndex,
						searchKey);
		}
		return -1;
	}

	// the element before which its an increasing array and after which its a
	// decreasing array
	public static void findPeakElement() {

	}

	// https://leetcode.com/problems/find-k-closest-elements/
	// https://leetcode.com/problems/k-closest-points-to-origin/ - k closest points
	// to origin
	public static void findKClosestNumbersToaGivenElement() {

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
			if (searchKey < inputArray[midIndex]) {
				return binarySearchWithRepeatedElements(inputArray, lowerIndex, midIndex - 1, searchKey);
			} else {
				return binarySearchWithRepeatedElements(inputArray, midIndex + 1, upperIndex, searchKey);
			}
		}
		return -1;
	}

	// https://www.geeksforgeeks.org/find-four-elements-that-sum-to-a-given-value-set-2/
	// in case of 4 numbers we can reduce complexity to O(n^2log(n)) by using an
	// extra hashmap
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

	// if two numbers or strings may be are given and asked to check if is a rotated
	// version of the
	// other
	// we can use circular linked list to check this and it takes O(n) time and O(n)
	// space complexity
	public static void rotateArray(int[] array, int noOfRotations) {
		JavaUtility.reverseArray(array, 0, noOfRotations - 1);
		JavaUtility.reverseArray(array, noOfRotations, array.length - 1);
		JavaUtility.reverseArray(array, 0, array.length - 1);

	}

	// working
	// we can also make it non-recursive to improve space and time complexity
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
	// check for example 1,0,1,1,0 for better understanding
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
	// in two dimension - https://leetcode.com/problems/trapping-rain-water-ii/
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
	// perfectly working
	// { 10, 12, 20, 30, 16, 40, 32, 31, 35, 50, 60 };
	// https://leetcode.com/problems/shortest-unsorted-continuous-subarray/submissions/
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
	// https://leetcode.com/problems/maximum-product-subarray/submissions/ - go
	// through this thoroughly
	public static int findMaxSubArray(int[] array) {
		int length = array.length;
		int maxTillNow = 0;
		int minTillNow = 0;
		int globalMax = Integer.MIN_VALUE;
		for (int i = 0; i < length; i++) {
			if (array[i] > 0) {
				maxTillNow = maxTillNow == 0 ? 1 : maxTillNow;
				minTillNow = minTillNow == 0 ? 1 : minTillNow;

				maxTillNow = maxTillNow * array[i];
				minTillNow = Math.min(minTillNow * array[i], 1);
			} else if (array[i] == 0) {
				maxTillNow = 0;
				minTillNow = 0;
			} else {
				int temp = maxTillNow;
				if (minTillNow != 0)
					maxTillNow = Math.max(minTillNow * array[i], 1);
				else
					maxTillNow = 0;
				if (temp != 0)
					minTillNow = temp * array[i];
				else
					minTillNow = array[i];
			}

			if (maxTillNow > globalMax) {
				globalMax = maxTillNow;
			}
		}
		return globalMax;
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
		if (rightElementToBeSwapped != -1 && leftElementToBeSwapped != -1) {
			System.out.println("Elements to be sorted are " + array[leftElementToBeSwapped] + " "
					+ array[rightElementToBeSwapped]);
			JavaUtility.swap(array, rightElementToBeSwapped, leftElementToBeSwapped);
		}
	}

	// https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
	// https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k-using-stack-in-on-time/
	// https://java2blog.com/sliding-window-maximum-java/
	public static void slidingWindowMaximum(int arr[], int n, int k) {
		Deque<Integer> Qi = new LinkedList<Integer>();
		int i;
		// processing the first K elements
		for (i = 0; i < k; ++i) {
			while (!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()])
				Qi.removeLast(); // Remove from rear
			Qi.addLast(i);
		}

		// Process rest of the elements, i.e., from arr[k] to arr[n-1]
		for (; i < n; ++i) {
			System.out.print(arr[Qi.peek()] + " ");

			// Remove the elements which are out of this window
			while ((!Qi.isEmpty()) && Qi.peek() <= i - k)
				Qi.removeFirst();

			// Remove all elements smaller than the currently
			// being added element (remove useless elements)
			while ((!Qi.isEmpty()) && arr[i] >= arr[Qi.peekLast()])
				Qi.removeLast();

			Qi.addLast(i);
		}
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

	public static int getSearchIndex(int[] array, int lowerIndex, int upperIndex, int key) {
		if (lowerIndex > upperIndex) {
			return -1;
		} else {
			int mid = (upperIndex + lowerIndex) / 2;
			if (array[mid] == key) {
				if (mid > 0 && Math.abs(array[mid - 1]) == key) {
					int index = getSearchIndex(array, lowerIndex, mid - 1, key);
					if (index != -1)
						return index;
					return mid;
				}
				return mid;
			} else {
				// this logic will almost lead to O(N) time complexity, so think of better
				// solution
				int index = getSearchIndex(array, lowerIndex, mid - 1, key);
				if (index == -1) {
					return getSearchIndex(array, mid + 1, upperIndex, key);
				}
				return index;

			}
		}
	}

	// https://www.geeksforgeeks.org/median-of-two-sorted-arrays/
	public static double medianOfTwoSortedArraysOfSameLength(int[] array1, int[] array2) {
		int length = array1.length;
		if (length == 0)
			return 0;
		else if (length == 1)
			return (array1[0] + array2[0]) / 2;
		else if (length == 2)
			return (Math.max(array1[0], array2[0]) + Math.min(array1[1], array2[1])) / 2;
		else {
			int size = array1.length;
			int low1 = 0, low2 = 0, high2 = size - 1, high1 = size - 1;
			while (size > 2) {

				int m1 = findMedian(low1, high1);
				int m2 = findMedian(low2, high2);

				double median1 = 0.0;
				double median2 = 0.0;
				if ((high1 - low1 + 1) % 2 == 0) {
					median1 = (array1[m1] + array1[m1 + 1]) / 2.0;
					median2 = (array2[m1] + array2[m1 + 1]) / 2.0;
				} else {
					median1 = array1[m1];
					median2 = array2[m2];
				}
				if (median1 == median2) {
					return median1;
				}

				else if (median1 > median2) {
					size = size / 2;
					high1 = m1;
					low2 = m2;
				} else {
					size = size / 2;
					low1 = m1;
					high2 = m2;
				}

			}
			return (Math.max(array1[low1], array2[low2]) + Math.min(array1[high1], array2[high2])) / 2.0;

		}
	}

	// https://www.youtube.com/watch?v=LPFhl65R7ww
	// working as well
	// read properly when free
	public static int findMedianOfTwoSortedArrays(int[] nums1, int[] nums2) {
		int size1 = nums1.length;
		int size2 = nums2.length;
		if (size1 > size2)
			return findMedianOfTwoSortedArrays(nums2, nums1);
		int lowerIndex = 0;
		int upperIndex = Math.min(size1, size2);
		while (lowerIndex <= upperIndex) {
			int i = (lowerIndex + upperIndex) / 2;
			int j = (size1 + size2 + 1) / 2 - i; // think of why adding one here ?
			int firstMaxLeft = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
			int firstMinRight = i == size1 ? Integer.MAX_VALUE : nums1[i];
			int secondMaxLeft = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
			int secondMinRight = j == size2 ? Integer.MAX_VALUE : nums2[j];
			if (firstMaxLeft <= secondMinRight && secondMaxLeft <= firstMinRight) {
				if ((size1 + size2) % 2 == 0)
					return (Math.max(firstMaxLeft, secondMaxLeft) + Math.min(firstMinRight, secondMinRight)) / 2;
				else
					return Math.max(firstMaxLeft, secondMaxLeft);
			} else if (firstMaxLeft > secondMinRight) {
				upperIndex = i - 1;
			} else {
				lowerIndex = i + 1;
			}

		}
		// reaches here when array is not sorted
		throw new IllegalArgumentException();
	}

	public static int findMedian(int low, int high) {
		int median = (low + high) / 2;
		return median;
	}

	// https://www.geeksforgeeks.org/k-th-element-two-sorted-arrays/
	public static int kthElementInTwoSortedArrays() {
		return -1;
	}

	// https://www.geeksforgeeks.org/number-subarrays-sum-exactly-equal-k/
	// v.v.imp
	// https://auth.geeksforgeeks.org/user/nik1996/articles
	static int findNoOfSubarraySum(int arr[], int n, int sum) {
		HashMap<Integer, Integer> prevSum = new HashMap<>();
		int res = 0;
		int currsum = 0;
		for (int i = 0; i < n; i++) {
			currsum += arr[i];
			if (currsum == sum)
				res++;
			// search for a sum if removed from the currentsum can given us the required sum
			if (prevSum.containsKey(currsum - sum))
				res += prevSum.get(currsum - sum);
			Integer count = prevSum.get(currsum);
			if (count == null)
				prevSum.put(currsum, 1);
			else
				prevSum.put(currsum, count + 1);
		}
		return res;
	}

	// https://algorithms.tutorialhorizon.com/in-an-array-find-the-subarray-with-sum-to-a-given-value/
	// working, also for finding no of subarrays with the given sum
	static void findSubarrayWithGivenSum(int arr[], int n, int sum) {
		int currSum = 0;
		int start = 0;
		for (int i = 0; i < n; i++) {
			if (currSum < sum)
				currSum = currSum + arr[i];
			else if (currSum == sum) {
				System.out.println("The subarray for the given sum starts from " + start + " and ends at " + (i - 1));
				// we can remove this break statement and reduce the currSum by arr[start++] to
				// find out all possible subArrays
				break;
			} else {
				while (currSum > sum)
					currSum = currSum - arr[start++];
			}
		}
	}

	// https://www.careercup.com/question?id=5698133541519360
	public static void method(int[] array) {

	}

	// https://www.geeksforgeeks.org/minimum-number-swaps-required-sort-array/
	// https://stackoverflow.com/questions/15152322/compute-the-minimal-number-of-swaps-to-order-a-sequence/15152602#15152602
	// think of scenario's with negative members as well
	public static int minNoOfSwapsRequiredToSortArray(int[] array) {
		int length = array.length;
		Map<Integer, Integer> valueIndicesMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < length; i++) {
			valueIndicesMap.put(array[i], i);
		}
		Arrays.sort(array);
		for (int i = 0; i < length; i++) {
			array[i] = valueIndicesMap.get(array[i]);
		}
		int noOfSwaps = 0;
		for (int i = 0; i < length; i++) {
			if (i == array[i])
				continue;
			else {
				JavaUtility.swap(array, i, array[i]);
				noOfSwaps++;
			}
		}
		return noOfSwaps;
	}

	// think of priority queue whenever we come across k nearest elements
	public static void printNClosestKumbersToN(int[] array, int n, int k) {

	}

	// https://www.geeksforgeeks.org/find-next-greater-number-set-digits/
	// think of the algo very carefully
	// https://leetcode.com/problems/next-permutation/solution/
	public static void nextHighestNumber() {

	}

	// https://www.interviewbit.com/problems/merge-overlapping-intervals/
	public static void mergeOverlappingIntervals() {

	}

	// https://www.geeksforgeeks.org/largest-rectangle-under-histogram/
	public static void maxRectanuglarArea(int[] array) {

	}

	// three possible solutions O(n), O(n); O(kLog(n)), O(1); O(n), O(1)
	// https://www.interviewbit.com/problems/intersection-of-sorted-arrays/
	public void intersectionOfTwoSortedArrays() {

	}

	// https://www.interviewbit.com/problems/points-on-the-straight-line/
	public void pointOnAStraightLine() {

	}

	public static void createNewArrayFromProductOfAllOtherElmenets(int a[]) {

	}

	// working
	public static int nearestNumberWithOnlyOnesAndZeros(int number) {
		if (number <= 9) {
			if (number < 5)
				return 1;
			else
				return 10;
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(10);
		queue.add(11);
		int element = -1;
		while (!queue.isEmpty()) {

			if (number > queue.peek()) {
				element = queue.poll();
				queue.add(element * 10);
				queue.add(element * 10 + 1);
			} else if (number == element) {
				return number;
			} else {
				if (Math.abs(number - element) > Math.abs(number - queue.peek())) {
					return queue.peek();
				}
				return element;
			}
		}
		return -1;
	}

	// {a0, a1, a2, a3, a4, b0, b1, b2, b3, b4} to alternate numbers
	// working
	/*      -- for reference - https://www.careercup.com/question?id=7528760
		Better time complexity => O(nlog(n))
		n = 1: a1 b1
		n = 2: 
		a1 a2 b1 b2 => a1 b1 a2 b2
		n = 4:
		a1 a2 a3 a4 b1 b2 b3 b4 =>  a1 a2 b1 b2 a3 a4 b3 b4 
					=>  a1 b1 a2 b2 a3 b3 a4 b4 
		n = 8:
		   a1 a2 a3 a4 a5 a6 a7 a8 b1 b2 b3 b4 b5 b6 b7 b8 
		=> a1 a2 a3 a4 b1 b2 b3 b4 a5 a6 a7 a8 b5 b6 b7 b8 
		=> a1 b1 a2 b2 a3 b3 a4 b4 a5 b5 a6 b6 a7 b7 a8 b8
	/*
	public static void rearrangeArray(int[] input) {
		int length = input.length;
		if (length == 0 || length == 2 || length % 2 != 0)
			return;

		for (int i = 1; i < Math.ceil(Math.log(length)); i++) {
			int l = length / 2 - 1;
			int m = length / 2;
			JavaUtility.swap(input, l, m);
			while (l >= 2 * i && m <= length - 1 - 2 * i) {
				JavaUtility.swap(input, l, l - 1);
				JavaUtility.swap(input, m, m + 1);
				l--;
				m++;
			}
		}
	}

	// https://www.geeksforgeeks.org/print-all-jumping-numbers-smaller-than-or-equal-to-a-given-value/
	public void printJumpingNumbers(int num) {

	}
	// array rotation
	// finding square root
	// next smallest palindrome
	// merge k sorted arrays

}
