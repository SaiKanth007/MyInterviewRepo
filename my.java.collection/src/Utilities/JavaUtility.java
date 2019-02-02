package src.Utilities;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class JavaUtility {

	EnumSet<Values> enumSet = EnumSet.of(Values.HIGH, Values.MEDIUM);

	public static boolean checkIfIndexAreValid(int i, int j, int length, int breadth) {
		if (i >= length || j >= breadth || i < 0 || j < 0) {
			return false;
		}
		return true;
	}

	public static void printMatrix(int[][] matrix, int rowSize, int columnSize) {
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < columnSize; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void swap(int[] array, int i, int j) {
		int k = array[i];
		array[i] = array[j];
		array[j] = k;
	}

	public static void swap(char[] array, int i, int j) {
		char k = array[i];
		array[i] = array[j];
		array[j] = k;
	}

	public static void printBeforeSorting(int[] array) {
		System.out.println("The values of the array before sorting are:");
		int length = array.length;
		for (int index = 0; index < length; index++)
			System.out.print(array[index] + " ");
	}

	public static void printAfterSorting(int[] array, String sortName) {
		System.out.println("The values of the array after " + sortName + "sorting are:");
		int length = array.length;
		for (int index = 0; index < length; index++)
			System.out.print(array[index] + " ");
	}

	public static void print(int[] array) {
		int length = array.length;
		for (int i = 0; i < length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	public static Map<Integer, String> NumbersToWordsMap() {
		Map<Integer, String> numberWordMap = new HashMap<>();
		numberWordMap.put(0, "zero");
		numberWordMap.put(1, "one");
		numberWordMap.put(2, "two");
		numberWordMap.put(3, "three");
		numberWordMap.put(4, "four");
		numberWordMap.put(5, "five");
		numberWordMap.put(6, "six");
		numberWordMap.put(7, "seven");
		numberWordMap.put(8, "eight");
		numberWordMap.put(9, "nine");
		numberWordMap.put(10, "ten");
		numberWordMap.put(11, "eleven");
		numberWordMap.put(12, "twelve");
		numberWordMap.put(13, "thirteen");
		numberWordMap.put(14, "fourteen");
		numberWordMap.put(15, "fifteen");
		numberWordMap.put(16, "sixteen");
		numberWordMap.put(17, "seventeen");
		numberWordMap.put(18, "eighteen");
		numberWordMap.put(19, "ninteen");
		numberWordMap.put(20, "twenty");
		numberWordMap.put(30, "thirty");
		numberWordMap.put(40, "forty");
		numberWordMap.put(50, "fifty");
		numberWordMap.put(60, "sixty");
		numberWordMap.put(70, "seventy");
		numberWordMap.put(80, "eighty");
		numberWordMap.put(90, "ninty");
		return numberWordMap;
	}

	public static Map<String, Integer> getRomansToNumberMap() {
		Map<String, Integer> map = new HashMap<>();
		return map;
	}

	public static void reverseArray(int[] array) {
		int length = array.length;
		for (int index = 0; index < length / 2; index++) {
			swap(array, index, length - index - 1);
		}
	}

	public static void reverseArray(int[] array, int lowerIndex, int upperIndex) {
		for (int index = lowerIndex; index < (upperIndex + lowerIndex) / 2; index++) {
			swap(array, index, upperIndex - index - 1);
		}
	}

	public static String NumberToWordsUtil(int input) {
		Map<Integer, String> map = NumbersToWordsMap();
		if (input <= 20)
			return map.get(input);
		else
			return map.get((input / 10) * 10).concat("and").concat(map.get(input % 10));
	}

	public static <T> void swap(T[] array, T firstElement, T secondElement) {
		T buffer = firstElement;
		firstElement = secondElement;
		secondElement = buffer;
		int value = Values.HIGH.getLeveCode();
		String ValuestringLowerCase = Values.MEDIUM.asLowerCase();
	}

}

// http://tutorials.jenkov.com/java/enums.html#enum-fields
enum Values {
	HIGH(3) {
		@Override
		public String asLowerCase() {
			return HIGH.toString().toLowerCase();
		}
	},
	MEDIUM(2);

	private int levelCode;

	private Values(int levelCode) {
		this.levelCode = levelCode;
	}

	public String asLowerCase() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getLeveCode() {
		return levelCode;
	}
}