package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//do not use static variables in case of competitive programing
//think of overflow scenario's
public class OnlineCodingQuestions {

	public static void main(String[] args) {
		System.out.println(myAtoi("2147483646"));
		System.out.println("Patter for Inc and Dec is : " + patternForIncAndDec("MMM"));

		int[] nums = { 4, 2, 0, 2, 3, 2, 0 };
		nextPermutation(nums);

		int[] gas = { 6, 3, 7 };
		int[] cost = { 4, 6, 3 };
		System.out.println(canCompleteCircuit(gas, cost));

		final int[] array = { 2, 3, 10, 10, 14, 12 };
		Arrays.binarySearch(array, 10);
		final int[] coffArray = { 2, 1, -1, 3, 5 };
		System.out.println(findNumberOfPairs(array, coffArray));

		int n = 94;
		int sum = 336;
		System.out.println("Number of 2 digited numbers with the given sum is:" + printNoOfNumbersUsingMatrix(n, sum));
		// System.out.println("Number of 2 digited numbers with the given sum is:" +
		// printNoOfNumbers(n, sum));

		int[] arrayForSubSets = { 1, 2, 3, 4 };
		Set<List<Integer>> resultSet = new HashSet();
		getAllSubSets(arrayForSubSets, 0, resultSet);
		List<List<Integer>> resultList = new ArrayList<>();
		resultList.addAll(resultSet);
		Collections.sort(resultList, new Comparator<List<Integer>>() {

			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				// TODO Auto-generated method stub
				int size = Math.min(o1.size(), o2.size());
				for (int i = 0; i < size; i++) {
					if (o1.get(i) < o2.get(i))
						return -1;
					else if (o1.get(i) > o2.get(i))
						return 1;
				}
				return o1.size() < o2.size() ? -1 : 1;
			}
		});
		System.out.println("the size of the result set is: " + resultList.size());
		for (List set : resultList) {
			System.out.println(set);
		}
	}

	public static int myAtoi(String str) {
		if ("".equals(str) || str == null)
			return 0;
		String[] array = str.split("\\s+");
		if (array.length == 0)
			return 0;
		String result = array[0];
		if ("".equals(result))
			result = array[1];
		boolean isNegativeNumber = false;
		// System.out.println(result);
		if (result.charAt(0) == '-') {
			isNegativeNumber = true;
			result = result.substring(1, result.length());
		}

		else if (result.charAt(0) == '+') {
			result = result.substring(1, result.length());
		}

		char[] resultArray = result.toCharArray();
		int length = resultArray.length;
		if (length > 0 && resultArray[0] >= 48 && resultArray[0] <= 57) {
			int sum = 0;
			int prevSum = 0;
			for (int i = 0; i < length; i++) {
				if (resultArray[i] < 48 || resultArray[i] > 57) {
					if (isNegativeNumber)
						return sum * -1;
					return sum;
				}
				prevSum = sum;
				sum = sum * 10 + ((int) resultArray[i] - 48);
				if (sum >= 2147483647 / 10 && ((i == length - 2 && (int) resultArray[i + 1] - 48 > 7)
						|| (i <= length - 2 && sum != 214748364)))
					if (isNegativeNumber) {
						return Integer.MIN_VALUE;
					} else
						return Integer.MAX_VALUE;
			}
			if (isNegativeNumber)
				return sum * -1;
			return sum;
		} else
			return 0;

	}

	public static void nextPermutation(int[] nums) {

		int length = nums.length;
		boolean matchNotFound = true;
		outerloop: for (int i = length - 1; i > 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] <= nums[j])
					continue;
				else {
					matchNotFound = false;
					swap(nums, i, j);
					Arrays.sort(nums, j + 1, length);
					break outerloop;
				}
			}
		}
		if (matchNotFound) {
			for (int i = 0; i < length / 2; i++) {
				swap(nums, i, length - i - 1);
			}
		}
	}

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	// https://www.geeksforgeeks.org/find-a-tour-that-visits-all-stations/
	// think of better solution
	public static int canCompleteCircuit(int[] gas, int[] cost) {

		int startIndex = -1;
		int length = gas.length;
		for (int i = 0; i < length; i++) {
			if (gas[i] >= cost[i]) {
				startIndex = i;
				break;
			}
		}

		if (startIndex == -1)
			return -1;

		int totalGas = 0;
		int count = 0;
		while (startIndex < length) {
			count = 0;
			for (int j = startIndex; j < length + startIndex + 1; j++) {
				if (j >= length) {
					j = j - length;
				}
				if (j == startIndex && count != 0) {
					return startIndex;
				}
				totalGas = totalGas + gas[j];
				if (totalGas >= cost[j]) {
					totalGas = totalGas - cost[j];
				} else {
					break;
				}
				count++;
				totalGas = 0;
			}
			startIndex++;
		}
		return -1;

	}

	public static int findNumberOfPairs(int[] array, int[] coffArray) {
		long count = 0;
		final int length = array.length;
		long lhsValue = 0;
		long rhsValue = 0;
		final int modNumber = (int) Math.round(Math.pow(10, 9)) + 7;

		Arrays.sort(array);
		Arrays.sort(coffArray);
		for (int i = 0; i < length; i++) {
			if (array[i] > -1) {
				for (int j = i; j < length; j++) {
					lhsValue = (long) (coffArray[0] * Math.pow(array[i], 3) + coffArray[1] * Math.pow(array[i], 2)
							+ coffArray[2] * array[i] + coffArray[3]);
					lhsValue = Math.floorMod(lhsValue, coffArray[4]);
					rhsValue = (long) Math.pow(array[j], 2);
					rhsValue = Math.floorMod(rhsValue, coffArray[4]);
					if (lhsValue == rhsValue) {
						count++;
					}
				}
			}
		}
		for (int i = 0; i < length; i++) {
			for (int j = i; j < length; j++) {
				if (array[j] > -1) {
					lhsValue = (long) (coffArray[0] * Math.pow(array[j], 3) + coffArray[1] * Math.pow(array[j], 2)
							+ coffArray[2] * array[j] + coffArray[3]);
					lhsValue = Math.floorMod(lhsValue, coffArray[4]);
					rhsValue = (long) Math.pow(array[i], 2);
					rhsValue = Math.floorMod(rhsValue, coffArray[4]);
					if (lhsValue == rhsValue && i != j) {
						count++;
					}
				}
			}
		}
		return (int) Math.floorMod(count, modNumber);
	}

	public static int printNoOfNumbers(int n, int sum) {
		if (sum < 0)
			return 0;
		if (n == 1) {
			if (sum < 10)
				return 1;
			return 0;
		}
		if (sum > n * 9)
			return 0;
		int localSum = 0;
		for (int i = 1; i < 10; i++) {
			localSum = localSum + printNoOfNumbers(n - 1, sum - i);
		}
		return localSum;

	}

	// https://practice.geeksforgeeks.org/problems/count-of-n-digit-numbers-whose-sum-of-digits-equals-to-given-sum/0
	public static long printNoOfNumbersUsingMatrix(int n, int sum) {
		long[][] matrix = new long[n + 1][sum + 1];

		for (int i = 1; i < 10 && i <= sum; i++) {
			matrix[1][i] = 1;
		}
		long modNumber = (long) Math.round(Math.pow(10, 9)) + 7;
		long localSum = 0;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (j == 9 * i) {
					matrix[i][j] = 1;
					break;
				} else {
					localSum = 0;
					for (int k = 0; k <= j; k++) {
						localSum = localSum + matrix[i - 1][j - k];
					}
					matrix[i][j] = localSum;
				}
			}
		}
		if (matrix[n][sum] == 0)
			return -1;
		return Math.floorMod(matrix[n][sum], modNumber);
	}

	public static void getAllSubSets(int[] array, int index, Set<List<Integer>> resultSet) {
		Arrays.sort(array);
		List storage = new ArrayList<>();
		getAllSubSets(array, index, storage, resultSet);
	}

	// https://mail.google.com/mail/u/0/#inbox/FMfcgxwBVqQBjmCsxFWlcVWnqhjRHbKq
	// working
	// other approach - this essentially boils down to printing combinations
	public static void getAllSubSets(int[] array, int index, List storage, Set<List<Integer>> resultSet) {

		if (index < array.length) {
			List firstList = new ArrayList<>();
			List secondList = new ArrayList<>();
			Set<List<Integer>> firstResultSet = new HashSet<>();
			Set<List<Integer>> secondResultSet = new HashSet<>();

			firstList.addAll(storage);
			secondList.addAll(storage);
			firstList.add(array[index]);
			getAllSubSets(array, index + 1, firstList, firstResultSet);
			getAllSubSets(array, index + 1, secondList, secondResultSet);

			resultSet.add(firstList);
			resultSet.add(secondList);
			for (List list : firstResultSet) {
				resultSet.add(list);
			}
			for (List list : secondResultSet) {
				resultSet.add(list);
			}

		}

	}

	static int patternForIncAndDec(String pattern) {

		final char[] array = pattern.toCharArray();
		final int length = array.length;
		String result = "";
		int currentNumber = findInitNumber(array);
		result = result.concat(Integer.toString(currentNumber));
		int firstAscFromdesc = -1;
		int countFromFirstAscFromDesc = 0;
		for (int i = 0; i < length; i++) {
			if (array[i] == 'M') {
				while (result.contains(Integer.toString(currentNumber - 1))) {
					currentNumber--;
				}
				if (currentNumber != 0) {
					result = result.concat(Integer.toString(currentNumber - 1));
					currentNumber--;
				} else {
					i = firstAscFromdesc - 1;
					currentNumber = countFromFirstAscFromDesc + 1;
					result = result.substring(0, firstAscFromdesc + 1);
					System.out.println("Going to index " + i + " with current number " + currentNumber
							+ " and result string " + result);
				}

			} else {
				while (result.contains(Integer.toString(currentNumber + 1))) {
					currentNumber++;
				}
				result = result.concat(Integer.toString(currentNumber + 1));
				currentNumber++;
				if (firstAscFromdesc != -1) {
					firstAscFromdesc = i;
					countFromFirstAscFromDesc = currentNumber;
				}
			}

		}

		return result == "" ? Integer.parseInt(result) : -1;

	}

	public static int findInitNumber(char[] array) {
		final int length = array.length;
		int index = 0;
		while (index < length && array[index] == 'M') {
			index++;
		}
		if (index > 0) {
			return index + 1;
		}
		return 1;
	}

}
