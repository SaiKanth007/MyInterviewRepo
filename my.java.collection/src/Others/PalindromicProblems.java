package src.Others;

import java.util.HashSet;
import java.util.Set;

//Go through this class again, have many issues
public class PalindromicProblems {

	public static void main(String[] args) {
		String stringForlongestPalindromicSubString = "fodfvof";
		System.out.println("The longest possible palindromic substring length is: " + longestPalindromicSubStringLength(
				stringForlongestPalindromicSubString, 0, stringForlongestPalindromicSubString.length() - 1));
		System.out.println("The longest possible palindromic substring is: " + longestPalindromicSubString(
				stringForlongestPalindromicSubString, 0, stringForlongestPalindromicSubString.length() - 1));

		String stringForlongestPalindromicSubSequence = "forgeeksskeegofr";
		System.out.println("The longest possible palindromic sub sequence length is: "
				+ longestPalindromicSubSequenceLength(stringForlongestPalindromicSubSequence, 0,
						stringForlongestPalindromicSubSequence.length() - 1));

		String minInsertionsToFormPalindrome = "abcda";
		System.out.println("Minimum number of insertions required are: " + minInsertionsToFormPalindrome(
				minInsertionsToFormPalindrome, 0, minInsertionsToFormPalindrome.length() - 1));

		String minDeletionsToFormPalindrome = "geek";
		System.out.println("Minimum number of deletions required are: " + minNoOfDeletionToFormPalindrome(
				minDeletionsToFormPalindrome, 0, minDeletionsToFormPalindrome.length() - 1));

		String totalNumberOfPalindromicSubStrings = "ababa";
		System.out.println(
				"The total number of possible substrings are: " + totalNumberOfPalindromicSubStringsUsingRecursion(
						totalNumberOfPalindromicSubStrings, 0, totalNumberOfPalindromicSubStrings.length() - 1));
		System.out.println("The next longest palindrom is");
		printNextLargestPalindromicNumber("999");

	}

	public static int findMaximumPalindromeNumberInTheGivenRange(int lower, int upper) {
		return 0;
	}

	// https://www.geeksforgeeks.org/given-a-number-find-next-smallest-palindrome-larger-than-this-number/
	// working
	public static void printNextLargestPalindromicNumber(String number) {
		int length = number.length();
		char[] charArray = number.toCharArray();
		int[] numberArray = new int[length];
		for (int i = 0; i < length; i++) {
			numberArray[i] = (int) charArray[i] - 48;
		}
		int j = length / 2;
		int i = length % 2 == 0 ? length / 2 - 1 : length / 2;
		int carry = 0;
		boolean oneShouldBeAdded = false;
		while (i >= 0 && j < length && numberArray[i] == numberArray[j]) {
			i--;
			j++;
		}

		if (i < 0 || numberArray[i] < numberArray[j]) {
			oneShouldBeAdded = true;
		}

		if (oneShouldBeAdded) {
			carry = 1;
			if (length % 2 == 1) {
				int sum = numberArray[length / 2] + carry;
				carry = sum / 10;
				numberArray[length / 2] = sum % 10;
			}
			i = length / 2 - 1;
			j = length % 2 == 0 ? length / 2 : length / 2 + 1;
			while (i >= 0) {
				int sum = numberArray[i] + carry;
				numberArray[i] = sum % 10;
				carry = sum / 10;
				numberArray[j] = numberArray[i];
				i--;
				j++;
			}
		} else {
			while (i >= 0 && j < length) {
				numberArray[j] = numberArray[i];
				i--;
				j++;
			}
		}

		String result = "";
		if (carry == 1)
			result = result + "1";

		for (i = 0; i < length; i++) {
			result = result + numberArray[i];
		}
		if (carry == 1)
			result = result + "1";
		System.out.println(result);
	}

	// not working, just go for matrix approach
	// https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
	public static int longestPalindromicSubStringLength(String input, int l, int h) {
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

	// https://www.geeksforgeeks.org/count-palindrome-sub-strings-string/
	// go through the solution for lesser time complexity later
	public static int totalNumberOfPalindromicSubStrings(String input) {
		int length = input.length();
		StringBuilder temp = new StringBuilder("");
		Set<String> palindromicSubStrings = new HashSet<String>();
		for (int i = 0; i < length; i++) {
			for (int j = i + 2; j <= length; j++) {
				temp = new StringBuilder("");
				;
				temp = temp.append(input.substring(i, j));
				if (temp.toString().compareTo(temp.reverse().toString()) == 0) {
					palindromicSubStrings.add(temp.toString());
				}
			}
		}
		System.out.println("The Palindromic sub strings are: ");
		for (String subString : palindromicSubStrings) {
			System.out.print(subString + " ");
		}
		return palindromicSubStrings.size();
	}

	// working but cannot check for duplicates and also cannot print list of
	// substrings, this is much worst than the two for loops appraoch
	// also try to implement this using matrix approach
	// // https://leetcode.com/problems/longest-palindromic-substring/solution/
	// manacher's algorithm - solves in O(n)
	// https://www.geeksforgeeks.org/longest-palindromic-substring-set-2/
	public static int totalNumberOfPalindromicSubStringsUsingRecursion(String input, int l, int h) {
		if (l <= h && l < input.length() && h >= 0) {
			if (l == h)
				return 0;
			else if ((h == l + 1 || h == l + 2) && (input.charAt(l) == input.charAt(h))) {
				return 1;
			} else {
				if (input.charAt(l) == input.charAt(h)) { // we should check for palindrome rather than just checking
															// ends
					return 1 + totalNumberOfPalindromicSubStringsUsingRecursion(input, l + 1, h)
							+ totalNumberOfPalindromicSubStringsUsingRecursion(input, l, h - 1)
							- totalNumberOfPalindromicSubStringsUsingRecursion(input, l + 1, h - 1);
				} else {
					// u can avoid dupl
					return totalNumberOfPalindromicSubStringsUsingRecursion(input, l + 1, h)
							+ totalNumberOfPalindromicSubStringsUsingRecursion(input, l, h - 1)
							- totalNumberOfPalindromicSubStringsUsingRecursion(input, l + 1, h - 1);

				}
			}
		}
		return 0;
	}

	// https://www.geeksforgeeks.org/count-palindromic-subsequence-given-string/
	public static int totalNumberOfPalindromsFromGivenCharacters(char[] input) {
		return 0;
	}

	// https://www.geeksforgeeks.org/minimum-insertions-to-form-a-palindrome-dp-28/
	public static int minInsertionsToFormPalindrome(String input, int low, int high) {

		if (low <= high) {
			if (low == high)
				return 0;
			if (low + 1 == high) {
				if (input.charAt(low) == input.charAt(high))
					return 0;
				return 1;
			}
			if (input.charAt(low) == input.charAt(high)) {
				return minInsertionsToFormPalindrome(input, low + 1, high - 1);

			}
			return 1 + Math.min(minInsertionsToFormPalindrome(input, low + 1, high),
					minInsertionsToFormPalindrome(input, low, high - 1));
		}
		return Integer.MAX_VALUE;
	}

	// go through thoroughly
	public static int minInsertionsToFormPalindromeWithouRecursion(String input, int low, int high) {
		return 0;
	}

	// https://www.geeksforgeeks.org/minimum-number-deletions-make-string-palindrome-set-2/
	public static int minNoOfDeletionToFormPalindrome(String input, int low, int high) {
		if (low <= high) {
			if (low == high)
				return 0;
			else if (low + 1 == high) {
				if (input.charAt(low) == input.charAt(high)) {
					return 0;
				} else {
					return 1;
				}
			} else {
				int firstResult = minNoOfDeletionToFormPalindrome(input, low + 1, high);
				int secondResult = minNoOfDeletionToFormPalindrome(input, low, high - 1);
				return 1 + Math.min(firstResult, secondResult);
			}

		}
		return Integer.MAX_VALUE;
	}
}
