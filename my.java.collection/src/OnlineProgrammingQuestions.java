package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Input: 94 336
 * 
 * Its Correct output is: 444354365
 * 
 * And Your Code's output is: 855229333
 * 
 * @author sai_kanth
 *
 */
public class OnlineProgrammingQuestions {

	public static void main(String[] args) {
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

}
