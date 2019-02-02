package src;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import src.Utilities.*;

public class MyString {

    public static void main(String[] args) {
        final String stringForPermutations = "abb";

        // printCombinations(stringForPermutations);
        final Set<String> stringStore = new HashSet();
        // printPermutations(stringForPermutations.toCharArray(), 0, stringForPermutations.length() - 1);
        printPermutationsWithoutDuplicates(stringForPermutations.toCharArray(), 0, stringForPermutations.length()
                        - 1, stringStore);
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

        final String[] strings = {"54", "546", "548", "60"};
        System.out.println("Largest Number from the given array of strings is :");
        largestNumberFromGivenArrayOfStrings(strings);
    }

    // doesn't scale for large strings
    public static void printCombinations(String input) {
        final char[] inputArray = input.toCharArray();
        final int length = inputArray.length;
        int quotient = 0;
        int j = 0;
        int count = 0;
        StringBuilder resultString = new StringBuilder();;
        for (int i = 0; i < Math.pow(2.0, length); i++) {
            j = i;
            while (j != 0) {
                quotient = j % 2;
                j = j / 2;
                if (quotient != 0) {
                    resultString = resultString.append(inputArray[count]);
                }
                count++;
            }
            System.out.println(resultString.toString());
            resultString = new StringBuilder();
            count = 0;

        }
    }

    // doesn't scale for large strings
    // https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
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
    public static void printPermutationsWithoutDuplicates(char[] inputArray, int lowerIndex, int upperIndex,
                    Set<String> stringStore) {

        if (lowerIndex == upperIndex) {
            stringStore.add(String.valueOf(inputArray));
        }
        for (int i = lowerIndex; i <= upperIndex; i++) {
            JavaUtility.swap(inputArray, lowerIndex, i);
            printPermutationsWithoutDuplicates(inputArray, lowerIndex + 1, upperIndex, stringStore);
            JavaUtility.swap(inputArray, lowerIndex, i);

        }

    }

    public static boolean checkIfDistincCharacterCountIsPrime(String input) {
        final char[] inputArray = input.toCharArray();
        final int length = inputArray.length;
        final Set<String> set = new HashSet();
        for (int i = 0; i < length; i++) {
            set.add(String.valueOf(inputArray[i]));
        }
        return CommonProblems.checkIfPrime(set.size());
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

}
