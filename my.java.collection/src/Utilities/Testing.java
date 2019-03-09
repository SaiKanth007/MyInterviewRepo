package src.Utilities;

/* IMPORTANT: Multiple classes and nested static classes are supported */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.*;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class Testing {
	public static void main(String args[]) throws Exception {

		Parent parent = new Parent();
		// parent.getClass().getMethod("getName").setAccessible(true);
		Child child = new Child();
		Parent parent2 = new Child();
		String input = "011100";
		System.out.println(findLengthOfLargestSubString(input, input.length()));
		System.out.println(findLengthOfLargestSubString2(input, input.length()));
        System.out.println("Integer.MAX_VALUE+1 is " + (Integer.MAX_VALUE+1));
		System.out.println("The log value of the given number is:" + Math.log10(105));

		int[] array = { 10, 2, 3, 14, 12 };
		int[] coffArray = { 2, 1, -1, 3, 5 };
		System.out.println(findNumberOfPairs(array, coffArray));

		List<String> strings = new ArrayList();
		strings.add("sai");
		strings.add("kanth");
		strings.add("Joey");
		Iterator<String> it = strings.iterator();
		while (it.hasNext()) {
			if (it.next() == "sai") {
				// strings.remove(1); // here if we try to remove/add it will throw exception
				// in the beggining of the next iteration
				it.remove(); // safe to do it
				System.out.println("String removed");
				System.out.println("String at length 0 is: " + strings.get(0));
			}
		}

		if ('a' < 'b') {
			System.out.println("Character comparision can be done");
		}

	}

	public static int findLengthOfLargestSubString(String input, int length) {
		int maxCount = 0;
		char[] array = input.toCharArray();
		for (int i = 0; i < length; i++) {
			int[] zeros = new int[length - i];
			int[] ones = new int[length - i];
			int count = 0;
			if (array[i] == '1')
				ones[count]++;
			else
				zeros[count]++;
			count++;
			for (int j = i + 1; j < length; j++) {
				if (array[j] == '1') {
					ones[count] = ones[count - 1] + 1;
					zeros[count] = zeros[count - 1];
				} else {
					zeros[count] = zeros[count - 1] + 1;
					ones[count] = ones[count - 1];
				}
				if (zeros[count] > ones[count]) {
					if (j - i + 1 > maxCount) {
						maxCount = j - i + 1;
					}
				}
				count++;
			}
		}
		return maxCount;
	}

	public static int findNumberOfPairs(int[] array, int[] coffArray) {
		long count = 0;
		int length = array.length;
		long lhsValue = 0;
		long rhsValue = 0;
		int modNumber = (int) Math.round(Math.pow(10, 9)) + 7;

		Arrays.sort(array);
		Arrays.sort(coffArray);
		for (int i = 0; i < length; i++) {
			if (array[i] > -1) {
				for (int j = i; j < length; j++) {
					lhsValue = (long) (coffArray[0] * Math.pow(array[i], 3) + coffArray[1] * Math.pow(array[i], 2)
							+ coffArray[2] * array[i] + coffArray[3]);
					lhsValue = Math.floorMod((long) lhsValue, coffArray[4]);
					rhsValue = (long) Math.pow(array[j], 2);
					rhsValue = Math.floorMod(rhsValue, coffArray[4]);
					if (lhsValue == rhsValue)
						count++;
				}
			}
		}
		for (int i = 0; i < length; i++) {
			for (int j = i; j < length; j++) {
				if (array[j] > -1) {
					lhsValue = (long) (coffArray[0] * Math.pow(array[j], 3) + coffArray[1] * Math.pow(array[j], 2)
							+ coffArray[2] * array[j] + coffArray[3]);
					lhsValue = Math.floorMod((long) lhsValue, coffArray[4]);
					rhsValue = (long) Math.pow(array[i], 2);
					rhsValue = Math.floorMod(rhsValue, coffArray[4]);
					if (lhsValue == rhsValue && i != j)
						count++;
				}
			}
		}
		return (int) Math.floorMod(count, modNumber);
	}

	public static int findLengthOfLargestSubString2(String input, int length) {
		int maxCount = 0;
		int diffCount = 0;
		for (int i = 0; i < length; i++) {
			diffCount = 0;
			if (input.charAt(i) == '0') {
				diffCount++;
			} else {
				diffCount--;
			}
			for (int j = i + 1; j < length; j++) {
				if (input.charAt(j) == '0') {
					diffCount++;
				} else {
					diffCount--;
				}
				if (diffCount > 0) {
					if (j - i + 1 > maxCount) {
						maxCount = j - i + 1;
					}
				}
			}
		}

		return maxCount;
	}

}

class Parent {

}

class Child extends Parent {

}
