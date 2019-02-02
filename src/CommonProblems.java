import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import static java.util.Map.Entry.*;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Because of String immutability, string pool is possible. Strings are used in
 * java classloader and immutability provides security that correct class is
 * getting loaded by Classloader.
 * 
 * @author sai_kanth
 *
 */
public class CommonProblems {

	public static void main(String[] args) {

		System.out.println("Through Recursion: The luck person is:" + getLuckyPerson(7, 3));
		System.out.println("Through Iteration: The luck person is:" + josephusIteration(7, 3));
		int[] arrayForNegaiveAndPositive = { -12, 11, -13, -5, 6, -7, 5, -3, -6 };
		System.out.println("Array after grouping negative numbers before positives");
		groupNegativeBeforePositive(arrayForNegaiveAndPositive);
		JavaUtility.print(arrayForNegaiveAndPositive);

		Map<Integer, Integer> store = new HashMap<>();
		store.put(123, 12);
		store.put(12, 124);
		store.put(-1, 100);
		// store = store.entrySet().stream().sorted(Map.Entry.comparingByValue())
		// .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) ->
		// e1, LinkedHashMap::new));

		List<Map.Entry<Integer, Integer>> sets = new ArrayList(store.entrySet());
		Collections.sort(sets, new Comparator<Map.Entry<Integer, Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				// TODO Auto-generated method stub
				return o1.getValue().compareTo(o2.getValue());
			}

		});
		store = new LinkedHashMap<Integer, Integer>();
		for (Map.Entry<Integer, Integer> map : sets) {
			store.put(map.getKey(), map.getValue());
		}
		store.entrySet().stream().forEach(System.out::println);

		// cannot pass compartor as a constructor argument
		List<String> list = new ArrayList<String>();

		// comparator has to be passed while sorting
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});

		// no method to remove char at a particular index, we have to manually
		// split the string into before and after the char and merge it back
		// or use string builder
		String abc = "abcd";

		int[] sortedArrayWithDuplicates = { 1, 2, 2, 3, 3, 3, 4 };
		System.out.println("Array after removing duplicates are: ");
		removeDuplicatesFromSortedArray(sortedArrayWithDuplicates);
		JavaUtility.print(sortedArrayWithDuplicates);

		String stringForlongestPalindromicSubString = "forgeeksskeegfor";
		System.out.println("The longest possible palindromic substring length is: " + longestPalindromicSubStringLength(
				stringForlongestPalindromicSubString, 0, stringForlongestPalindromicSubString.length() - 1));
		System.out.println("The longest possible palindromic substring is: " + longestPalindromicSubString(
				stringForlongestPalindromicSubString, 0, stringForlongestPalindromicSubString.length() - 1));

		String stringForlongestPalindromicSubSequence = "GEEKSFORGEEKS";
		System.out.println("The longest possible palindromic sub sequence length is: "
				+ longestPalindromicSubSequenceLength(stringForlongestPalindromicSubSequence, 0,
						stringForlongestPalindromicSubSequence.length() - 1));

	}

	public static int findGCD(int a, int b) {
		if (a == 1)
			return b;
		else if (b == 1)
			return a;
		else {
			return findGCD(b / a, a);
		}
	}

	// working
	public static void groupNegativeBeforePositive(int[] array) {
		int j = -1;
		int length = array.length;
		for (int i = 0; i < length; i++) {
			if (array[i] < 0) {
				j++;
				JavaUtility.swap(array, i, j);
			}
		}
	}

	/**
	 * Let me explained it in another way:
	 * 
	 * There are n people in a circle, and people counts from 1 to k, and the person
	 * who count k will be eliminated. And we keep this process until there is only
	 * 1 person left in the circle.
	 * 
	 * Let's first number position of these n people: 0, 1, 2, ..., n-1. You notice
	 * that we change number from [1,2...n] to [0,1,...n-1], this is because of
	 * module operation. Likewise, people will now count from 0 to k-1, and the
	 * person who count k-1 will be eliminated.
	 * 
	 * The first person to be eliminated is in position (k-1)%n. After the first
	 * person has been eliminated, the circle now has only n-1 people left. One key
	 * discovery is that the last person who is finally eliminated(we call him lucky
	 * guy) is the same one to be eliminated in n-1 people circle!
	 * 
	 * Now we begin eliminate the second person:
	 * 
	 * Since (k-1)%n is the position that the first person got eliminated, then k%n
	 * must be the 0-th position for this round.
	 * 
	 * So we can number accordingly in the following table:
	 * 
	 * Position in first round ----------Position in second round k%n
	 * ----------------------------- 0 k%n+1 -------------------------- 1 k%n+2
	 * -------------------------- 2
	 * 
	 * ....
	 * 
	 * Let's assume the lucky guy in the first round in position: f(n, k). Then the
	 * same lucky guy in the second round in position: f(n-1, k)
	 * 
	 * So, based on the table, we know the lucky guy in second round who is in
	 * position f(n-1, k), must be in position k%n+f(n-1,k) in the first round.
	 * 
	 * Position in first round ----------Position in second round k%n
	 * ----------------------------- 0 k%n+1 -------------------------- 1 k%n+2
	 * -------------------------- 2 ...
	 * 
	 * k%n+f(n-1,k) ------------------- f(n-1,k)
	 * 
	 * 
	 * @param totalNoOfPersons
	 * @param k
	 * @return
	 */
	// https://www.geeksforgeeks.org/josephus-problem-set-1-a-on-solution/
	public static int getLuckyPerson(int totalNoOfPersons, int k) {
		if (totalNoOfPersons == 1)
			return 0;
		else
			return (getLuckyPerson(totalNoOfPersons - 1, k) + k % totalNoOfPersons) % totalNoOfPersons;
	}

	// thin through it later
	public static int josephusIteration(int n, int k) {
		int result = 0; // when n = 1
		for (int i = 2; i <= n; i++) {
			result = (result + k) % i;
		}
		return result;
	}

	// working
	public static void removeDuplicatesFromSortedArray(int[] array) {
		int length = array.length;
		int index = 0;
		for (int i = 1; i < length; i++) {
			if (array[i] != array[i - 1]) {
				index++;
				array[index] = array[i];

			}
		}
		System.out.println("index is:" + index);
	}

	// https://www.geeksforgeeks.org/largest-subarray-with-equal-number-of-0s-and-1s/
	public static void findLengthOfMaxSubArrayWithEqualOnesAndZeros() {

	}

	// working
	// https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
	public static int longestPalindromicSubStringLength(String input, int l, int h) {
		if (l <= h) {
			if (l == h)
				return 1;
			if (input.charAt(l) == input.charAt(h) && l + 1 == h)
				return 2;
			if (input.charAt(l) == input.charAt(h) && l + 2 == h)
				return 3;
			if (input.charAt(l) == input.charAt(h)) {
				if (l < input.length() - 1 && h > 0 && input.charAt(l + 1) == input.charAt(h - 1)) {
					return 2 + longestPalindromicSubStringLength(input, l + 1, h - 1);
				} else {
					return Math.max(longestPalindromicSubStringLength(input, l + 1, h),
							longestPalindromicSubStringLength(input, l, h - 1));
				}
			}
			if (input.charAt(l) != input.charAt(h))
				return Math.max(longestPalindromicSubStringLength(input, l + 1, h),
						longestPalindromicSubStringLength(input, l, h - 1));
		}
		return 0;
	}

	// working
	// https://www.geeksforgeeks.org/longest-palindromic-subsequence-dp-12/
	// also learn about the matrix approach
	public static int longestPalindromicSubSequenceLength(String input, int l, int h) {
		if (l <= h) {
			if (l == h)
				return 1;
			if (input.charAt(l) == input.charAt(h) && l + 1 == h)
				return 2;
			if (input.charAt(l) == input.charAt(h) && l + 2 == h)
				return 3;
			if (input.charAt(l) == input.charAt(h)) {
				return 2 + longestPalindromicSubSequenceLength(input, l + 1, h - 1);
			}
			if (input.charAt(l) != input.charAt(h))
				return Math.max(longestPalindromicSubSequenceLength(input, l + 1, h),
						longestPalindromicSubSequenceLength(input, l, h - 1));
		}
		return 0;
	}

	// working
	// https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
	public static String longestPalindromicSubString(String input, int l, int h) {
		if (l <= h) {
			if (l == h) {
				return String.valueOf(input.charAt(l));
			}
			String result1 = "";
			String result2 = "";
			if (input.charAt(l) == input.charAt(h) && (l + 1 == h || l + 2 == h))
				return input.substring(l, h + 1);
			if (input.charAt(l) == input.charAt(h)) {
				if (l < input.length() - 1 && h > 0 && input.charAt(l + 1) == input.charAt(h - 1)) {
					return String.valueOf(input.charAt(l)) + longestPalindromicSubString(input, l + 1, h - 1)
							+ String.valueOf(input.charAt(h));
				} else {
					result1 = longestPalindromicSubString(input, l + 1, h);
					result2 = longestPalindromicSubString(input, l, h - 1);
					return result1.length() > result2.length() ? result1 : result2;
				}
			}
			if (input.charAt(l) != input.charAt(h))
				result1 = longestPalindromicSubString(input, l + 1, h);
			result2 = longestPalindromicSubString(input, l, h - 1);
			return result1.length() > result2.length() ? result1 : result2;
		}
		return "";
	}

	  public static String covertNumberToRomans(Integer Number) {
	        return "";
	    }

	    public static Integer covertRomansToNumber(String romanNumber) {
	        if (romanNumber == null || romanNumber == " ") {
	            return 0;
	        }
	        final char[] array = romanNumber.toCharArray();
	        final int length = array.length;
	        final Map<String, Integer> romantToNumberMap = MyJavaUtils.getRomansToNumberMap();
	        if (length == 1) {
	            return romantToNumberMap.get(String.valueOf(array[0]));
	        }
	        Integer sum = romantToNumberMap.get(String.valueOf(array[length - 1]));
	        for (int i = length - 2; i >= 0; i--) {
	            if (romantToNumberMap.get(String.valueOf(array[i])) < romantToNumberMap.get(String.valueOf(array[i + 1]))) {
	                sum = sum - romantToNumberMap.get(String.valueOf(array[i]));
	            } else {
	                sum = romantToNumberMap.get(String.valueOf(array[i])) + sum;

	            }

	        }
	        return sum;

	    }

	    public static boolean checkIfPrime(Integer number) {
	        for (int index = 2; index < Math.sqrt(number); index++) {
	            if (number % index == 0) {
	                return false;
	            }
	        }
	        return true;
	    }

	    public static int choclateWrapperProblem(int money, int price, int wrapper) {
	        return 0;
	    }

	/**
	 * length of maximum sub array with equal ones and zeros
	 */
}
