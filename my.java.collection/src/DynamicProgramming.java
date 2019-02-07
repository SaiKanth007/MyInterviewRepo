package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import src.Utilities.JavaUtility;

public class DynamicProgramming {

	public static void main(String[] args) {
		int[][] goldMine = { { 10, 33, 13, 15 }, { 22, 21, 04, 1 }, { 5, 0, 2, 3 }, { 0, 6, 14, 2 } };
		System.out
				.println("The maximum amount of the gold that can be collecetd is: " + goldMineProblem(goldMine, 4, 4));
		int[] subSetWithSum = { 1, 2, 3, 56, 44 };
		System.out.println("There exists a subset with the given sum :"
				+ checkSubSetWithGivenSum(subSetWithSum, 100, subSetWithSum.length - 1));
		System.out.println("There exists a subset with the given sum :"
				+ checkSubSetWithGivenSumUsingMatrix(subSetWithSum, 100, subSetWithSum.length - 1));
		int[] printSubSetWithSum = { 4, 8, 1, 4, 2, 1 };
		List<Integer> result = new ArrayList();
		System.out.println("There exists a subset with the given sum :"
				+ checkSubSetWithGivenSum(printSubSetWithSum, 10, printSubSetWithSum.length - 1, result));
		System.out.println("The length of the result set is: " + result.size());
		System.out.println("The values are: ");
		for (Integer value : result) {
			System.out.println(value + " ");
		}
		System.out.println();
		int[] longestIncreasingSubSequence = { 3, 2 };
		System.out.println("The length of the longest increasing sub sequence is:"
				+ longestIncreasingSubSequence(longestIncreasingSubSequence));

		int[] longestIncreasingOddEvenSubSequence = { 5, 6, 9, 4, 7, 8 };
		System.out.println("The length of the longest increasing consecutive sub sequence is:"
				+ longestIncreasingOddEvenSubSequence(longestIncreasingOddEvenSubSequence));

		String longestPalindromicSubSequence = "GEEKSFORGEEKS";
		System.out
				.println("The length of longest increasing palindromic subsequence is:" + longestPalindromicSubSequence(
						longestPalindromicSubSequence.toCharArray(), 0, longestPalindromicSubSequence.length() - 1));

		int[][] minCostMatrix = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };

		System.out.println("The cost of minimum path matrix is:" + minCostpathInMatrix(minCostMatrix, 3, 3, 0, 0));

		int[][] minStepsToReachEndOfMatrix = { { 0, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 }, { 1, 0, 0, 0, 0 },
				{ 1, 1, 1, 1, 1 } };
		boolean[][] visited = new boolean[4][5];

		System.out.println("Minimum steps to reach the end of the matrix:"
				+ minStepsToReachEndOfMatrix(minStepsToReachEndOfMatrix, 4, 5, 1, 2, visited));

		int[] arrayForMinSteps = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		System.out.println("Number of steps to reach the end of the array");
		System.out.println(minNoOfSteps(arrayForMinSteps, 0, arrayForMinSteps.length - 1));

		int[] coinDenominations = { 86, 7, 43, 67, 6 };
		System.out.println("Number of coins required for the given sum is:" + minCoinProblem(coinDenominations, 8777));
	}

	// https://www.geeksforgeeks.org/gold-mine-problem/
	// working
	public static int goldMineProblem(int[][] goldMine, int length, int breadth) {
		int maxGoldCollected = 0;
		for (int i = 0; i < length; i++) {
			maxGoldCollected = Math.max(maxGoldCollected, goldMineProblem(goldMine, i, 0, length, breadth));
		}
		return maxGoldCollected;
	}

	public static int goldMineProblem(int[][] goldMine, int i, int j, int length, int breadth) {
		if (JavaUtility.checkIfIndexAreValid(i, j, length, breadth)) {
			int rightSum = goldMineProblem(goldMine, i - 1, j + 1, length, breadth);
			int leftSum = goldMineProblem(goldMine, i + 1, j + 1, length, breadth);
			int middleSum = goldMineProblem(goldMine, i, j + 1, length, breadth);
			return goldMine[i][j] + Math.max(middleSum, Math.max(leftSum, rightSum));
		}
		return 0;
	}

	public static boolean checkSubSetWithGivenSum(int[] inputArray, int sum, int index) {
		if (sum == 0)
			return true;
		if (index < 0 && sum != 0)
			return false;
		if (inputArray[index] > sum)
			return checkSubSetWithGivenSum(inputArray, sum, index - 1);
		return checkSubSetWithGivenSum(inputArray, sum - inputArray[index], index - 1)
				|| checkSubSetWithGivenSum(inputArray, sum, index - 1);

	}

	// https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/SubsetSum.java
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
				// uncomment this out if u want minimum numbers to get the required sum
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

	// https://www.geeksforgeeks.org/puzzle-set-35-2-eggs-and-100-floors/
	public static int solveEggFloorProblem(int noOfFloors, int noOfEggs) {
		if (noOfEggs == 1 || noOfFloors == 0)
			return noOfFloors;
		if (noOfFloors == 1)
			return 1;
		int min = Integer.MAX_VALUE, localmin;
		for (int i = 1; i < noOfFloors; i++) {
			localmin = Math.max(solveEggFloorProblem(i - 1, noOfEggs - 1),
					solveEggFloorProblem(noOfFloors - i, noOfEggs));
			min = localmin < min ? localmin : min;
		}
		return min + 1;
	}

	// also check the below link for O(NlogN) solution in below link
	// https://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
	public static int longestIncreasingSubSequence(int[] array) {
		int length = array.length;
		if (length <= 1)
			return length;
		int[] lis = new int[length];
		Arrays.fill(lis, 1);
		for (int i = 1; i < length; i++) {
			for (int j = 0; j < i; j++) {
				if (array[i] > array[j] && lis[i] < lis[j] + 1)
					lis[i] = lis[j] + 1;
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < length; i++) {
			System.out.print(lis[i] + " ");
			if (lis[i] > max)
				max = lis[i];
		}
		return max;
	}

	public static int longestIncreasingOddEvenSubSequence(int[] array) {
		int length = array.length;
		if (length <= 1)
			return length;
		int[] lis = new int[length];
		Arrays.fill(lis, 1);
		for (int i = 1; i < length; i++) {
			for (int j = 0; j < i; j++) {
				if (array[i] > array[j] && array[i] % 2 != array[j] % 2 && lis[i] < lis[j] + 1)
					lis[i] = lis[j] + 1;
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < length; i++) {
			System.out.print(lis[i] + " ");
			if (lis[i] > max)
				max = lis[i];
		}
		return max;
	}

	// https://www.geeksforgeeks.org/longest-palindromic-subsequence-dp-12/
	public static int longestPalindromicSubSequence(char[] array, int i, int j) {
		if (i == j)
			return 1;
		else if (array[i] == array[j] && j == i + 1)
			return 2;
		else if (array[i] == array[j])
			return longestPalindromicSubSequence(array, i + 1, j - 1) + 2;
		else
			return Math.max(longestPalindromicSubSequence(array, i + 1, j),
					longestPalindromicSubSequence(array, i, j - 1));

	}

	// https://www.geeksforgeeks.org/min-cost-path-dp-6/
	// also check for matrix solution
	public static int minCostpathInMatrix(int[][] matrix, int length, int breadth, int i, int j) {
		if (i < 0 || j < 0 || i >= length || j >= breadth)
			return Integer.MAX_VALUE;
		if (i == length - 1 && j == breadth - 1)
			return matrix[i][j];
		return matrix[i][j] + Math.min(
				Math.min(minCostpathInMatrix(matrix, length, breadth, i, j + 1),
						minCostpathInMatrix(matrix, length, breadth, i + 1, j)),
				minCostpathInMatrix(matrix, length, breadth, i + 1, j + 1));

	}

	// also think of the matrix solution
	public static int minStepsToReachEndOfMatrix(int[][] grid, int length, int breadth, int i, int j,
			boolean[][] visited) {
		if (i == length - 1 && j == breadth - 1)
			return 0;
		if (JavaUtility.checkIfIndexAreValid(i, j, length, breadth) && grid[i][j] == 1 && !visited[i][j]) {
			visited[i][j] = true;
			int localSum = 0;
			int actualSum = Integer.MAX_VALUE;
			int[] xvalues = { 1, -1, 0, 0 };
			int[] yvalues = { 0, 0, 1, -1 };
			for (int l = 0; l < 4; l++) {
				localSum = minStepsToReachEndOfMatrix(grid, length, breadth, i + xvalues[l], j + yvalues[l], visited);
				if (localSum != Integer.MAX_VALUE && localSum < actualSum)
					actualSum = localSum;
			}
			if (actualSum != Integer.MAX_VALUE)
				return 1 + actualSum;
			return Integer.MAX_VALUE;
		} else {
			return Integer.MAX_VALUE;
		}
	}

	// do this for sure --
	// https://www.geeksforgeeks.org/minimum-number-jumps-reach-endset-2on-solution/
	public static int minNoOfSteps(int[] array, int currentIndex, int upperIndex) {
		if (currentIndex > upperIndex)
			return 0;
		if (currentIndex == upperIndex)
			return array[currentIndex];
		int localSum = 0;
		int actualSum = Integer.MAX_VALUE;
		for (int l = 1; l <= array[currentIndex]; l++) {
			localSum = 1 + minNoOfSteps(array, currentIndex + l, upperIndex);
			if (localSum < actualSum)
				actualSum = localSum;
		}
		return actualSum;
	}

	// https://practice.geeksforgeeks.org/problems/word-boggle/0
	public static int noOfWordsFromDictionary(int[][] boggle, String[] words) {
		return 0;
	}

	public static int minCoinProblem(int[] coinValues, int sum) {
		Arrays.sort(coinValues);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		return minCoinProblem(coinValues, sum, map);
		// return minCoinProblem(coinValues, coinValues.length - 1, sum);
	}

	// working
	public static int minCoinProblem(int[] coinValues, int sum, Map<Integer, Integer> map) {

		if (sum == 0)
			return 0;
		Integer localCoins = 0;
		Integer globalCount = Integer.MAX_VALUE;
		int length = coinValues.length;
		for (int i = 0; i < length; i++) {
			if (sum < coinValues[i]) {
				continue;
			} else if (map.containsKey(sum)) {
				return map.get(sum);
			} else {
				localCoins = minCoinProblem(coinValues, sum - coinValues[i], map);
				if (localCoins < globalCount) {
					globalCount = localCoins;
				}
			}
		}
		globalCount = globalCount == Integer.MAX_VALUE ? globalCount : globalCount + 1;
		map.put(sum, globalCount);
		return globalCount;
	}

	/**
	 * Yet to do: 1.
	 * https://www.geeksforgeeks.org/minimum-cost-make-two-strings-identical/ total
	 * no of path from top left to bottom right of a matrix
	 * 
	 * nimsum problem :
	 * https://www.geeksforgeeks.org/combinatorial-game-theory-set-2-game-nim/
	 * https://www.geeksforgeeks.org/painters-partition-problem-set-2/ longest
	 * common subsequence -
	 * https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/ minimum coin
	 * change problem -
	 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/CoinChangingMinimumCoin.java
	 */
}
