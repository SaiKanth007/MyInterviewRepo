package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import src.Utilities.JavaUtility;

//yet to learn about the matrix approach of DP
public class DynamicProgramming {

	public static void main(String[] args) {
		int[][] goldMine = { { 10, 33, 13, 15 }, { 22, 21, 04, 1 }, { 5, 0, 2, 3 }, { 0, 6, 14, 2 } };
		System.out
				.println("The maximum amount of the gold that can be collecetd is: " + goldMineProblem(goldMine, 4, 4));
		int[] longestIncreasingSubSequence = { 2, 5, 3, 7, 11, 8, 10, 13, 6 };
		System.out.println("The length of the longest increasing sub sequence is:"
				+ longestIncreasingSubSequence(longestIncreasingSubSequence));

		int[] longestIncreasingOddEvenSubSequence = { 5, 6, 9, 4, 7, 8 };
		System.out.println("The length of the longest increasing consecutive sub sequence is:"
				+ longestIncreasingOddEvenSubSequence(longestIncreasingOddEvenSubSequence));

		int[][] minCostMatrix = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };

		System.out.println("The cost of minimum path matrix is:" + minCostpathInMatrix(minCostMatrix, 3, 3, 0, 0));

		int[][] minStepsToReachEndOfMatrix = { { 0, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 }, { 1, 0, 0, 0, 1 },
				{ 1, 1, 1, 1, 1 } };
		boolean[][] visited = new boolean[4][5];

		System.out.println("Minimum steps to reach the end of the matrix:"
				+ minStepsToReachEndOfMatrix(minStepsToReachEndOfMatrix, 4, 5, 1, 2, visited));

		int[] arrayForMinSteps = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		System.out.println("Number of steps to reach the end of the array");
		System.out.println(minNoOfSteps(arrayForMinSteps, 0, arrayForMinSteps.length - 1));

		int[] coinDenominations = { 86, 7, 43, 67, 6 };
		System.out.println("Number of coins required for the given sum is:" + minCoinProblem(coinDenominations, 8777));

		int[] maxSumOfNonAdjacentElements = { 1, 0, 3, 9, 2, 10 };
		System.out.println("The max sum of non adjancent elements is: "
				+ maxSumOfNonAdjacentElements(maxSumOfNonAdjacentElements, maxSumOfNonAdjacentElements.length - 1));

		int nthStair = 3;
		System.out.println("No of ways reaching nth stair is: " + noOfWaysToReachGivenNumberOfSteps(nthStair));

		int targetPositionToReach = 9;
		System.out.println("Minimum no of steps to reach the target:" + infineteLineProblem(targetPositionToReach));

		int[][] matrixForLargestRegion = { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 0, 1 } };
		System.out.println("The length of the largest region is:" + findLargestRegion(matrixForLargestRegion, 5, 5));
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

	// https://www.geeksforgeeks.org/puzzle-set-35-2-eggs-and-100-floors/
	public static int solveEggFloorProblem(int noOfFloors, int noOfEggs) {
		if (noOfEggs == 1)
			return noOfFloors;
		if (noOfFloors == 1 || noOfFloors == 0)
			return noOfFloors;
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
		if (!JavaUtility.checkIfIndexAreValid(i, j, length, breadth)) {
			return Integer.MAX_VALUE;
		} else {
			if (i == length - 1 && j == breadth - 1)
				return 0;
			if (grid[i][j] == 1 && !visited[i][j]) {
				visited[i][j] = true;
				int localSum = 0;
				int actualSum = Integer.MAX_VALUE;
				int[] xvalues = { 1, -1, 0, 0 };
				int[] yvalues = { 0, 0, 1, -1 };
				for (int l = 0; l < 4; l++) {
					localSum = minStepsToReachEndOfMatrix(grid, length, breadth, i + xvalues[l], j + yvalues[l],
							visited);
					if (localSum != Integer.MAX_VALUE && localSum < actualSum)
						actualSum = localSum;
				}
				return actualSum != Integer.MAX_VALUE ? 1 + actualSum : Integer.MAX_VALUE;
			} else {
				return Integer.MAX_VALUE;
			}

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
			localSum = minNoOfSteps(array, currentIndex + l, upperIndex);
			if (localSum < actualSum)
				actualSum = localSum;
		}
		return localSum != Integer.MAX_VALUE ? localSum + 1 : actualSum;
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

	public static int minNoStepsForKnightToReachDestination() {
		return 0;
	}

	// http://blog.gainlo.co/index.php/2016/12/02/uber-interview-question-maximum-sum-non-adjacent-elements/
	public static int maxSumOfNonAdjacentElements(int[] array, int index) {
		if (index >= 0 && index < array.length) {
			if (index == 0) {
				if (array[0] >= 0)
					return array[0];
				else
					return 0;
			} else {
				return Math.max(array[index] + maxSumOfNonAdjacentElements(array, index - 2),
						maxSumOfNonAdjacentElements(array, index - 1));
			}
		}
		return 0;
	}

	// https://www.geeksforgeeks.org/c-program-for-tower-of-hanoi/
	// also think of the iterative approach
	public static void towerOfHanoi(int n, char from, char to, char aux) {
		if (n == 1)
			System.out.println("Move disk from: " + from + " to " + to);
		else {
			towerOfHanoi(n - 1, from, aux, to);
			System.out.println("Move disk from: " + from + " to " + to);
			towerOfHanoi(n - 1, aux, to, from);
		}
	}

	// https://www.geeksforgeeks.org/count-ways-reach-nth-stair-using-step-1-2-3/
	// try to print those possible paths also - imp
	public static int noOfWaysToReachGivenNumberOfSteps(int totalSteps) {
		if (totalSteps == 0)
			return 0;
		else if (totalSteps == 1)
			return 1;
		else if (totalSteps == 2)
			return 2;
		else if (totalSteps == 3)
			return 4;
		else
			return noOfWaysToReachGivenNumberOfSteps(totalSteps - 1) + noOfWaysToReachGivenNumberOfSteps(totalSteps - 2)
					+ noOfWaysToReachGivenNumberOfSteps(totalSteps - 3);

	}

	// http://blog.gainlo.co/index.php/2017/01/05/uber-interview-questions-permutations-array-arrays/
	public static void printPermutations() {

	}

	public static void fibonacciNumbers() {

	}

	public static void knightsProblem() {

	}

	// https://www.geeksforgeeks.org/find-minimum-moves-reach-target-infinite-line/
	// -- imp
	public static int infineteLineProblem(int currentPost, int target, int step) {
		if (currentPost == target)
			return step;
		if (Math.abs(currentPost) > Math.abs(target)) {
			return Integer.MAX_VALUE;
		}
		int leftSteps = infineteLineProblem(currentPost - step - 1, target, step + 1);
		int rightSteps = infineteLineProblem(currentPost + step + 1, target, step + 1);
		return Math.min(leftSteps, rightSteps);
	}

	public static int infineteLineProblem(int target) {
		// starting from origin and with prev steps =0;
		return infineteLineProblem(0, target, 0);
	}

	// // https://www.geeksforgeeks.org/find-length-largest-region-boolean-matrix/
	// slight variation of the above problem -
	// https://www.geeksforgeeks.org/find-number-of-islands/
	public static int findLargestRegion(int[][] matrix, int length, int breadth) {
		int localMax = Integer.MIN_VALUE;
		int globalMax = Integer.MIN_VALUE;
		boolean visited[][];
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < breadth; j++) {
				visited = new boolean[length][breadth];
				localMax = findLargestRegion(matrix, length, breadth, i, j, visited);
				globalMax = Math.max(localMax, globalMax);
			}
		}
		return globalMax;
	}

	public static int findLargestRegion(int[][] matrix, int length, int breadth, int i, int j, boolean[][] visited) {
		if (!JavaUtility.checkIfIndexAreValid(i, j, length, breadth)) {
			return 0;
		}
		if (visited[i][j] || matrix[i][j] == 0) {
			return 0;
		}
		visited[i][j] = true;
		int sum = 1;
		int[] xaxis = { -1, -1, -1, 0, 0, 1, 1, 1, };
		int[] yaxis = { -1, 0, 1, -1, 1, -1, 0, 1 };
		for (int index = 0; index < 8; index++) {
			sum = sum + findLargestRegion(matrix, length, breadth, i + xaxis[index], j + yaxis[index], visited);
		}
		return sum;
	}

	// https://www.geeksforgeeks.org/find-rectangle-binary-matrix-corners-1/
	public static boolean isRectangularMatrixPresent() {
		return false;
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
	 * https://www.geeksforgeeks.org/hungarian-algorithm-assignment-problem-set-1-introduction/
	 */
}
