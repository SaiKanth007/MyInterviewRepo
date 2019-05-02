package src;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import src.Utilities.JavaUtility;

// https://www.youtube.com/watch?v=KIQ6fZ4XRKs&list=PLF9tovyahfL020hGgLIsRMZY4bfSLCFUa
/**
 * Given two strings A and B, find the longest common prefix. Given two strings
 * A and B, what's the longest prefix of A which is suffix of B. Given a list of
 * strings, find number of unique prefixes of all the strings. Given a list of
 * string, find the longest common substring of all strings.
 *
 * @author sai_kanth
 *
 */
public class MyString {

	/***
	 * Google Interview links
	 * https://www.geeksforgeeks.org/software-engineer-interview-at-google-hyderabad/
	 * https://www.geeksforgeeks.org/software-engineer-interview-at-google-bangalore/
	 */
	public static void main(String[] args) {
		final String stringForPermutations = "abc";
		final String stringForCombinations = "abc";

		System.out.println("The combinations of the given string are:");
		printCombinations(stringForCombinations);
		System.out.println("The combinations of the given string using recursion are:");
		printCombinationsRecursive(stringForCombinations.toCharArray(), 0, "");
		final Set<String> stringStore = new LinkedHashSet();
		// printPermutations(stringForPermutations.toCharArray(), 0,
		// stringForPermutations.length() - 1);
		printPermutationsWithoutDuplicates(stringForPermutations.toCharArray(), 0, stringForPermutations.length() - 1,
				stringStore);

		System.out.println("The distinct permuations of the given string are:");
		final Iterator<String> iterator = stringStore.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		final String stringForPrimeNumberOfDistinctChar = "abcdef";

		System.out.println("String has prime number of distinct characters: "
				+ checkIfDistincCharacterCountIsPrime(stringForPrimeNumberOfDistinctChar));

		final String stringForMaxNoOfLamps = "...*..";

		System.out.println("Max no of lamps required is: "
				+ numberOfLamps(stringForMaxNoOfLamps, stringForMaxNoOfLamps.length() - 1));
		System.out.println("Next Smallest numbner for the given numners is: ");
		findNextSmallestNumberFromTheGivenNumber("534976");

		final String[] strings = { "54", "546", "548", "60" };
		System.out.println("Largest Number from the given array of strings is :");
		largestNumberFromGivenArrayOfStrings(strings);

		String stringForlexoGraphicallyLargestSubSequence = "geeksforgeeks";
		System.out.println("Lexographically largest subsequence is:"
				+ lexoGraphicallyLargestSubSequence(stringForlexoGraphicallyLargestSubSequence));

		System.out.println("Minimum no of splits is:" + printMinimumSplits("10001", 0));
		System.out.println("Print the lexographical order of the array");
		String[] array = { "33123", "15", "1", "0", "54215", "21", "12" };

		lexoGraphicalOrderOfString(Arrays.asList(array));

		String lexographicallyFirstPalindromeString = "aba";
		System.out.println("Lexographically first palindrome of the given strings is:"
				+ lexographicallyFirstPalindrome(lexographicallyFirstPalindromeString));

		String firstNonRepeatingCharacter = "iijjkkllmm";
		System.out.println(
				"The first non repeating character is: " + getFirstNonRepeatingCharacter(firstNonRepeatingCharacter));

		System.out.println("The reverse of the given string is:" + reveseString("abcde"));

	}

	// other approach would be to use hashmap
	// this assumes that the string is sorted
	public static char getFirstNonRepeatingCharacter(String input) {
		int length = input.length();
		for (int i = 0; i < length; i++) {
			if (i == 0 && input.charAt(0) != input.charAt(1)) {
				return input.charAt(0);
			} else if (i == length - 1 && input.charAt(length - 1) != input.charAt(length - 2)) {
				return input.charAt(length - 1);
			}
			if ((i > 0 && input.charAt(i) != input.charAt(i - 1))
					&& (i < length - 1 && input.charAt(i) != input.charAt(i + 1))) {
				return input.charAt(i);
			}
		}
		return (char) 48;

	}

	// doesn't scale for large strings
	public static void printCombinations(String input) {
		final char[] inputArray = input.toCharArray();
		final int length = inputArray.length;
		int quotient = 0;
		int j = 0;
		// this is used to find which element in the array has to be printed or not
		int count = 0;
		StringBuilder resultString = new StringBuilder();
		for (int i = 0; i < Math.pow(2.0, length); i++) {
			j = i;
			while (j != 0) {
				quotient = j % 2;
				if (quotient != 0) {
					resultString = resultString.append(inputArray[count]);
				}
				j = j / 2;
				count++;
			}
			System.out.println(resultString.toString());
			resultString = new StringBuilder();
			count = 0;

		}
	}

	// https://www.geeksforgeeks.org/print-sums-subsets-given-set/
	// working
	public static void printCombinationsRecursive(char[] array, int index, String result) {
		// Print current subset
		if (index >= array.length) {
			System.out.println(result + " ");
			return;
		}

		// Subset including arr[l]
		printCombinationsRecursive(array, index + 1, result + array[index]);

		// Subset excluding arr[l]
		printCombinationsRecursive(array, index + 1, result);
	}

	// doesn't scale for large strings
	// https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
	// http://blog.gainlo.co/index.php/2017/01/05/uber-interview-questions-permutations-array-arrays/

	public static void printPermutations(char[] inputArray, int lowerIndex, int upperIndex) {

		if (lowerIndex == upperIndex) {
			System.out.println(String.valueOf(inputArray));
		}
		for (int i = lowerIndex; i <= upperIndex; i++) {
			JavaUtility.swap(inputArray, lowerIndex, i);
			printPermutations(inputArray, lowerIndex + 1, upperIndex);
			JavaUtility.swap(inputArray, lowerIndex, i);
		}

	}

	// doesn't scale for large strings
	// https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
	// also think of printing it in alphabetical order
	public static void printPermutationsWithoutDuplicates(char[] inputArray, int lowerIndex, int upperIndex,
			Set<String> stringStore) {
		if (lowerIndex <= upperIndex) {
			if (lowerIndex == upperIndex) {
				stringStore.add(String.valueOf(inputArray));
			}
			for (int i = lowerIndex; i <= upperIndex; i++) {
				JavaUtility.swap(inputArray, lowerIndex, i);
				printPermutationsWithoutDuplicates(inputArray, lowerIndex + 1, upperIndex, stringStore);
				JavaUtility.swap(inputArray, lowerIndex, i);
			}
		}

	}

	public static boolean checkIfDistincCharacterCountIsPrime(String input) {
		final char[] inputArray = input.toCharArray();
		final int length = inputArray.length;
		final Set<String> set = new HashSet();
		for (int i = 0; i < length; i++) {
			set.add(String.valueOf(inputArray[i]));
		}
		return GeneralPrograms.checkIfPrime(set.size());
	}

	// https://www.geeksforgeeks.org/minimum-amount-of-lamps-needed-to-be-installed/
	// not working
	public static Integer numberOfLamps(String input, int upperIndex) {

		if (upperIndex >= 0) {
			final String subString = input.substring(0, upperIndex + 1);
			if (upperIndex == 0) {
				if (subString.contains(".")) {
					return 1;
				}
				return 0;

			} else if (upperIndex == 1) {
				if (subString.contains("*")) {
					return 0;
				}
				return 1;

			} else if (upperIndex == 2) {
				if (subString.contains("*")) {
					if (subString.charAt(1) == '*' || subString.charAt(0) == '*' && subString.charAt(2) == '*') {
						return 0;
					}
					return 1;
				}
				return 2;

			} else {
				if (input.charAt(upperIndex) == '*') {
					return numberOfLamps(input, upperIndex - 2);
				}
				final Integer first = 1 + numberOfLamps(input, upperIndex - 2);
				final Integer second = numberOfLamps(input, upperIndex - 1);
				return Math.min(first, second);
			}
		}
		return 0;

	}

	// https://www.geeksforgeeks.org/given-a-string-find-its-first-non-repeating-character/
	public static void findFirstNonRepeatingCharacter() {

	}

	// https://www.geeksforgeeks.org/print-longest-substring-without-repeating-characters/
	// -- v.v.imp
	public static void largestSubStringWithNoRepatingCharacters() {

	}

	// https://www.geeksforgeeks.org/find-next-greater-number-set-digits/
	// working
	public static void findNextSmallestNumberFromTheGivenNumber(String input) {
		final int length = input.length();
		final char[] inputArray = input.toCharArray();
		int i = length - 2;
		for (; i >= 0; i--) {
			if (inputArray[i] < inputArray[i + 1]) {
				JavaUtility.swap(inputArray, i, length - 1);
				break;
			}
		}
		if (i == -1) {
			return;
		}

		Arrays.sort(inputArray, i + 1, length);
		for (int j = 0; j < length; j++) {
			System.out.print(inputArray[j]);
		}

	}

	// https://www.geeksforgeeks.org/given-an-array-of-numbers-arrange-the-numbers-to-form-the-biggest-number/
	public static void largestNumberFromGivenArrayOfStrings(String[] array) {

		Arrays.asList(array).sort(new Comparator<String>() {
			@Override
			public int compare(String X, String Y) {
				final String XY = X + Y;
				final String YX = Y + X;
				return YX.compareTo(XY);
			}

		});
		final int length = array.length;

		for (int i = 0; i < length; i++) {
			System.out.print(array[i]);
		}

	}

	public static String lexoGrphicallyLargestSubString(String input) {
		return input;
	}

	// https://www.geeksforgeeks.org/lexicographically-largest-sub-sequence-of-the-given-string/
	// working (GO through it later)
	public static String lexoGraphicallyLargestSubSequence(String input) {
		char[] inputArray = input.toCharArray();
		int length = inputArray.length;
		StringBuilder sb = new StringBuilder();
		sb.append(inputArray[0]);
		for (int i = 1; i < length; i++) {
			if (inputArray[i] > sb.charAt(0)) {
				sb = new StringBuilder();
			} else if (inputArray[i] > sb.charAt(sb.length() - 1)) {
				sb.delete(1, sb.length());
			}
			sb.append(inputArray[i]);
		}
		return sb.toString();
	}

	/***
	 * Given a string of 0 and 1, if possible, tell that how many splits would be
	 * required such that each split part is a number which can be represented as
	 * power of 5 in binary and tell the least number of splits.
	 */
	// working
	public static int printMinimumSplits(String input, int startIndex) {
		if (startIndex < input.length()) {
			Map<String, String> power5BinaryMap = new HashMap<>();
			for (Integer i = 1; i > 0 && i < Integer.MAX_VALUE; i = i * 5) {
				power5BinaryMap.put(Integer.toBinaryString(i), "1");
			}
			// have to account for all these cases
			power5BinaryMap.put("01", "1");
			power5BinaryMap.put("001", "1");
			power5BinaryMap.put("0001", "1");

			if (startIndex == input.length() - 1) {
				if (input.charAt(input.length() - 1) == '1') {
					return 1;
				} else {
					return 0;
				}
			}
			Integer returnValue = Integer.MAX_VALUE;
			Integer localMin = Integer.MAX_VALUE;
			for (int i = startIndex; i < input.length(); i++) {
				if (power5BinaryMap.containsKey(input.substring(startIndex, i + 1))) {
					returnValue = printMinimumSplits(input, i + 1);
					if (returnValue != Integer.MAX_VALUE && returnValue < localMin) {
						localMin = returnValue;
					}
				}
			}
			if (localMin != Integer.MAX_VALUE)
				return 1 + localMin;
			return Integer.MAX_VALUE;
		}
		return 0;
	}

	// https://www.geeksforgeeks.org/allocate-minimum-number-pages/
	// https://www.geeksforgeeks.org/software-engineer-interview-at-google-bangalore/
	public static void allocateMinNoOfPages(int[] input) {

	}

	public static void lexoGraphicalOrderOfString(List<String> input) {
		// Collections.sort(input);
		Collections.sort(input, new Comparator<String>() {

			public int compare2(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				char[] firstArray = o1.toCharArray();
				char[] secondArray = o2.toCharArray();
				int length = Math.min(firstArray.length, secondArray.length);
				for (int i = 0; i < length; i++) {
					if (o1.charAt(i) < o2.charAt(i))
						return -1;
					else if (o1.charAt(i) > o2.charAt(i))
						return 1;
				}
				return o1.length() < o2.length() ? -1 : 1;
			}

		});
		for (String string : input)
			System.out.println(string);
	}

	public static void printAllPalindromicPermutationsLexoGraphically() {

	}

	// https://www.geeksforgeeks.org/lexicographically-first-palindromic-string/
	public static String lexographicallyFirstPalindrome(String input) {
		// or use a char array of size 256 instead of tree map
		Map<Character, Integer> freqMap = new TreeMap<>();
		boolean isPalindoromePossible = checkIfPalindromePossible(input, freqMap);
		if (!isPalindoromePossible) {
			return "Palindrome Not Possible";
		} else {
			String odd = getOddString(freqMap);
			String rear = "";
			String front = "";
			char inputChar;
			for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
				if (entry.getValue() % 2 == 0) {
					inputChar = entry.getKey();
					String temp = "";
					for (int index = 0; index < entry.getValue() / 2; index++) {
						temp = temp + inputChar;
					}
					front = front + temp;
					rear = temp + rear;
				}
			}
			return front + odd + rear;
		}

	}

	public static String getOddString(Map<Character, Integer> freqMap) {
		String result = "";
		for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
			if (entry.getValue() % 2 != 0) {
				result = result + entry.getKey();
			}
		}
		return result;
	}

	public static boolean checkIfPalindromePossible(String input, Map<Character, Integer> freqMap) {
		int length = input.length();
		char currentChar = 0;
		for (int index = 0; index < length; index++) {
			currentChar = input.charAt(index);
			if (freqMap.containsKey(currentChar)) {
				freqMap.put(currentChar, 1 + freqMap.get(currentChar));
			} else {
				freqMap.put(currentChar, 1);
			}
		}
		int oddCount = 0;
		for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
			if (entry.getValue() % 2 != 0) {
				oddCount++;
			}
		}

		if (length % 2 == 0) {
			if (oddCount > 0)
				return false;
			return true;
		} else {
			if (oddCount != 1)
				return false;
			return true;
		}
	}

	// https://www.geeksforgeeks.org/next-higher-palindromic-number-using-set-digits/
	public void nextHighestPalindromeUsingSameSetOfNumbers(String number) {

	}

	public void nextHighestPalindromeOfString(String number) {

	}

	public void printAllPossiblePalindromicSubStrings() {

	}

	// https://stackoverflow.com/questions/35918762/make-the-all-of-combination-from-palindrome
	public void printAllPossiblePalindromesForGivenString(String input) {

	}

	public static void dictionaryProblemWithDiffOrder() {

	}

	public static String reveseString(String input) {
		char[] inputArray = input.toCharArray();
		int length = inputArray.length;
		for (int i = 0; i < length / 2; i++) {
			JavaUtility.swap(inputArray, i, length - i - 1);
		}
		return new String(inputArray);
	}

	// v.v.v.imp -
	// https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
	// https://www.geeksforgeeks.org/smallest-window-contains-characters-string/
	public static void minLengthContainingPattern() {

	}

	// https://code.dennyzhang.com/next-closest-time
	// v.v.v.imp
	public static String nextClosestTime() {
		return "";
	}

	// https://leetcode.com/problems/edit-distance/
	public static void editDistanceToMatchWords() {

	}

	/***
	 * Google Interview links
	 * https://www.geeksforgeeks.org/software-engineer-interview-at-google-hyderabad/
	 * https://www.geeksforgeeks.org/software-engineer-interview-at-google-bangalore/
	 */
}
