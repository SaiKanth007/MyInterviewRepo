package src.Others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnapsackProblems {

	public static void main(String[] args) {

		int[] subSetWithSum = { 1, 3, 2, 44, 56 };
		System.out.println("There exists a subset with the given sum :"
				+ checkSubSetWithGivenSum(subSetWithSum, 100, subSetWithSum.length - 1));
		System.out.println("There exists a subset with the given sum :"
				+ checkSubSetWithGivenSumUsingMatrix(subSetWithSum, 100, subSetWithSum.length - 1));

		int[] printSubSetWithSum = { 4, 8, 1, 4, 2, 1, 7 };
		List<Integer> result = new ArrayList();
		System.out.println("There exists a subset with the given sum :"
				+ checkSubSetWithGivenSum(printSubSetWithSum, 10, printSubSetWithSum.length - 1, result));
		System.out.println("The length of the result set is: " + result.size());
		System.out.println("The values are: ");
		for (Integer value : result) {
			System.out.println(value + " ");
		}

		System.out.println("There exists a subset with the given sum for a given count:"
				+ checkSubSetWithGivenSumAndGivenCount(printSubSetWithSum, 10, printSubSetWithSum.length - 1, 3));

		result = new ArrayList();
		System.out.println("There exists a subset with the given sum for a given count:"
				+ checkSubSetWithGivenSumWithCount(printSubSetWithSum, 10, printSubSetWithSum.length - 1, result, 3));
		System.out.println("The length of the result set is: " + result.size());
		System.out.println("The values are: ");
		for (Integer value : result) {
			System.out.print(value + " ");
		}
	}

	// exponential time complextity
	public static boolean checkSubSetWithGivenSum(int[] inputArray, int sum, int index) {
		if (sum == 0)
			return true;
		if (index >= inputArray.length)
			return false;
		if (index < 0 && sum != 0)
			return false;
		if (inputArray[index] > sum)
			return checkSubSetWithGivenSum(inputArray, sum, index - 1);
		return checkSubSetWithGivenSum(inputArray, sum - inputArray[index], index - 1)
				|| checkSubSetWithGivenSum(inputArray, sum, index - 1);

	}

	// working
	// think of solve this using matrix appraoch as well
	public static boolean checkSubSetWithGivenSumAndGivenCount(int[] inputArray, int sum, int index, int count) {
		if (sum == 0) {
			if (count == 0)
				return true;
			return false;
		}
		if (index >= inputArray.length)
			return false;
		if ((count == 0 || index < 0) && sum != 0)
			return false;

		if (inputArray[index] > sum)
			return checkSubSetWithGivenSumAndGivenCount(inputArray, sum, index - 1, count);
		return checkSubSetWithGivenSumAndGivenCount(inputArray, sum - inputArray[index], index - 1, count - 1)
				|| checkSubSetWithGivenSumAndGivenCount(inputArray, sum, index - 1, count);
	}

	// https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/SubsetSum.java
	// O(sum.n) --> where n is the size of the array
	public static boolean checkSubSetWithGivenSumUsingMatrix(int[] inputArray, int sum, int index) {
		boolean sumMatrix[][] = new boolean[inputArray.length + 1][sum + 1];
		for (int i = 0; i <= inputArray.length; i++) {
			sumMatrix[i][0] = true;
		}
		for (int i = 1; i <= inputArray.length; i++) {
			for (int j = 1; j <= sum; j++) {
				if (j - inputArray[i - 1] >= 0) {
					sumMatrix[i][j] = sumMatrix[i - 1][j] || sumMatrix[i - 1][j - inputArray[i - 1]];
				} else {
					sumMatrix[i][j] = sumMatrix[i - 1][j];
				}
			}
		}
		return sumMatrix[inputArray.length][index];
	}

	// https://www.geeksforgeeks.org/maximum-size-subset-given-sum/
	// think of matrix approach as well
	public static boolean checkSubSetWithGivenSum(int[] inputArray, int sum, int index, List<Integer> result) {
		if (sum == 0) {
			return true;
		}
		if (index < 0 && sum != 0)
			return false;
		if (inputArray[index] > sum) {
			List<Integer> tempList = new ArrayList();
			if (checkSubSetWithGivenSum(inputArray, sum, index - 1, tempList)) {
				result.addAll(tempList);
				return true;
			}
			return false;

		} else {
			List<Integer> firstList = new ArrayList();
			List<Integer> secondList = new ArrayList();
			Boolean firstResult = checkSubSetWithGivenSum(inputArray, sum - inputArray[index], index - 1, firstList);
			Boolean secondResult = checkSubSetWithGivenSum(inputArray, sum, index - 1, secondList);

			if (firstResult && secondResult) {
				// uncomment this out if u do not want minimum numbers to get the required sum
				if (firstList.size() < secondList.size()) {
					result.addAll(firstList);
					if (firstResult && inputArray[index] != 0) {
						result.add(inputArray[index]);
					}
				} else {
					result.addAll(secondList);
				}
			} else if (firstResult) {
				result.addAll(firstList);
				if (inputArray[index] != 0) {
					result.add(inputArray[index]);
				}

			} else if (secondResult) {
				result.addAll(secondList);
			}
			return firstResult || secondResult;
		}

	}

	// https://www.geeksforgeeks.org/maximum-size-subset-given-sum/
	// returns sub set of given size for the given sum
	public static boolean checkSubSetWithGivenSumWithCount(int[] inputArray, int sum, int index, List<Integer> result,
			int count) {
		if (sum == 0) {
			if (count == 0)
				return true;
			return false;
		}
		if (count == 0 && sum != 0)
			return false;
		if (index < 0 && sum != 0)
			return false;
		if (inputArray[index] > sum) {
			List<Integer> tempList = new ArrayList();
			if (checkSubSetWithGivenSumWithCount(inputArray, sum, index - 1, tempList, count)) {
				result.addAll(tempList);
				return true;
			}
			return false;

		} else {
			List<Integer> firstList = new ArrayList();
			List<Integer> secondList = new ArrayList();
			Boolean firstResult = checkSubSetWithGivenSumWithCount(inputArray, sum - inputArray[index], index - 1,
					firstList, count - 1);
			Boolean secondResult = checkSubSetWithGivenSumWithCount(inputArray, sum, index - 1, secondList, count);

			if (firstResult && secondResult) {
				// uncomment this out if u do not want minimum numbers to get the required sum
				if (firstList.size() < secondList.size()) {
					result.addAll(firstList);
					if (firstResult && inputArray[index] != 0) {
						result.add(inputArray[index]);
					}
				} else {
					result.addAll(secondList);
				}
			} else if (firstResult) {
				result.addAll(firstList);
				if (firstResult && inputArray[index] != 0) {
					result.add(inputArray[index]);
				}

			} else if (secondResult) {
				result.addAll(secondList);
			}
			return firstResult || secondResult;
		}
	}

}
