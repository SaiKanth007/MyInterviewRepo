package src;

import org.apache.commons.lang3.StringUtils;

/*
 * //*********************************************** // Copyright UNITEDHEALTH GROUP CORPORATION 2019. // This software
 * and documentation contain confidential and // proprietary information owned by UnitedHealth Group Corporation. //
 * Unauthorized use and distribution are prohibited. //***********************************************
 */

/**
 */
// https://www.geeksforgeeks.org/bitwise-algorithms/
// https://www.geeksforgeeks.org/bitwise-hacks-for-competitive-programming/
// vvv imp
// https://www.hackerearth.com/practice/basic-programming/bit-manipulation/basics-of-bit-manipulation/tutorial/
public class MyBinaryOperators {

	public static void main(String args[]) {
		final int[] arrayForRepeatingNumber = { 1, 2, 1, 3, 5, 4 };
		findRepeatingAndMissingNumber(arrayForRepeatingNumber);

		final int[] arrayForFinidngRepeatedNumberInSortedArray = { 3, 4, 4, 5, 6 };
		System.out.println("The index of the repeated number is:" + findRepeatingNumber(
				arrayForFinidngRepeatedNumberInSortedArray, 0, arrayForFinidngRepeatedNumberInSortedArray.length - 1));

		System.out.println("The sum of given two numbers is: " + findSumOfTwoNumbersWithoutUsingAddOperator(41, 4));

	}

	// not working - go thorugh the below link for better approach
	// https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/
	// use a bucker sort approach
	public static void findRepeatingAndMissingNumber(int[] array) {
		int result = 0;
		final int length = array.length;
		int actualSum = 0;
		for (int index = 1; index <= length; index++) {
			result = result ^ index;
		}
		for (int index = 0; index < length; index++) {
			result = result ^ array[index];
			actualSum = actualSum + array[index];
		}

		System.out.println("The repeating numbers is :" + result);
		// try finding this using only binary operators
		final int expectedSum = length * (length + 1) / 2;

		System.out.println("The missing numbers is :" + (result + expectedSum - actualSum));

	}

	public static int findMissingNumber(int[] array) {
		int result = 0;
		final int length = array.length;
		for (int index = 0; index < length; index++) {
			result = result ^ index;
		}
		for (int index = 0; index < length; index++) {
			result = result ^ array[index];
		}
		return result;
	}

	// find repeating number in sorted array
	// https://www.geeksforgeeks.org/find-repeating-element-sorted-array-size-n/
	public static int findRepeatingNumber(int[] array, int lowerIndex, int upperIndex) {
		if (lowerIndex > upperIndex) {
			return -1;
		} else {
			int mid = (lowerIndex + upperIndex) / 2;
			if (mid > 0 && array[mid] == array[mid - 1])
				return mid - 1;
			else {
				int leftIndex = findRepeatingNumber(array, lowerIndex, mid - 1);
				if (leftIndex != -1) {
					return leftIndex;
				}
				return findRepeatingNumber(array, mid + 1, upperIndex);
			}
		}
	}

	// https://www.geeksforgeeks.org/find-one-multiple-repeating-elements-read-array/
	public static int findOneOfMultipleRepeatingNumber(int[] array) {
		int result = 0;
		final int length = array.length;
		for (int index = 0; index < length; index++) {
			result = result ^ index;
		}
		for (int index = 0; index < length; index++) {
			result = result ^ array[index];
		}
		return result;
	}

	// working
	public static String findSumOfTwoNumbersWithoutUsingAddOperator(int a, int b) {
		StringBuilder actualSum = new StringBuilder("");
		int localSum = 0;
		int prevCarry = 0;
		while (a > 0 || b > 0) {
			localSum = a % 2 ^ b % 2 ^ prevCarry % 2;
			prevCarry = a % 2 & b % 2 | prevCarry % 2 & (a % 2 ^ b % 2);
			actualSum = actualSum.append(localSum);
			a = a >> 1;
			b = b >> 1;

		}
		actualSum = actualSum.append(prevCarry != 0 ? String.valueOf(prevCarry) : "");
		return actualSum.reverse().toString();
	}

	// https://www.geeksforgeeks.org/find-the-two-repeating-elements-in-a-given-array/
	public static void findTwoRepeatingNumbers(int[] array) {

	}

	// https://www.geeksforgeeks.org/find-two-non-repeating-elements-in-an-array-of-repeating-elements/
	public static void findTwoNonRepeatingElementsInArrayOfRepatingElements() {

	}

	// https://www.geeksforgeeks.org/find-two-non-repeating-elements-in-an-array-of-repeating-elements/
	public static void minValueToAddToMakeArrayBalanced() {

	}

	// https://www.geeksforgeeks.org/find-sum-non-repeating-distinct-elements-array/
	public static void sumOfDistinctElementsInArray() {

	}

	// https://www.geeksforgeeks.org/find-first-repeating-element-array-integers/
	public static void findFirstRepeatingElementInArray() {

	}

	// https://www.geeksforgeeks.org/find-the-first-missing-number/
	public static void findFirstMissingElementInArray() {

	}

	// https://github.com/mission-peace/interview/tree/master/src/com/interview/bits
	public static void swapOddEvenBits() {

	}

	public static String numberToBinaryString() {
		return "";
	}
}
