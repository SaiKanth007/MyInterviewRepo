package src;

import java.util.HashMap;
import java.util.Map;

import src.Utilities.JavaUtility;

public class MyMatrix {

	public static void main(String[] args) {

		int[][] mat = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };
		System.out.println("Key Found:" + findElementInRowAndColumnSortedMatrix(mat, 4, 4, 22));

		int mat1[][] = { { 2, 4 }, { 3, 4 } };
		int mat2[][] = { { 1, 2 }, { 1, 3 } };
		matrixMultiplication(mat1, mat2, 2, 2);
		int spiralMatrix[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 } };
		// printMatrixInSpiral(spiralMatrix, 3, 6);

		int uniqueMatrix[][] = { { 0, 1, 0, 0, 1 }, { 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 1 }, { 1, 1, 1, 0, 0 } };
		// printUniqueRowsInMatrix(uniqueMatrix, 4, 5);
		long[] array = { 3, 4, 5 };
		// System.out.println(solve(array, 3));
		int[] bitArray = { 0, 0, 1, 1, 1, 0, 0, 0, 0 };
		// method(bitArray, bitArray.length);
		findTransposeOfMatrix(mat, 4);
		JavaUtility.printMatrix(mat, 4, 4);
	}

	public static boolean findElementInRowAndColumnSortedMatrix(int[][] matrix, int length, int breadth, int key) {
		boolean keyFound = false;
		int k = breadth - 1;
		outerloop: for (int i = 0; i < length; i++) {
			for (int j = k; j > 0; j--) {
				if (matrix[i][j] == key) {
					keyFound = true;
					break outerloop;
				} else if (matrix[i][j] < key) {
					k = j;
					break;
				}
			}

		}
		return keyFound;
	}

	// https://www.geeksforgeeks.org/c-program-multiply-two-matrices/
	// https://www.geeksforgeeks.org/strassens-matrix-multiplication/ -
	// approximately O(N2.8074)

	public static int[][] matrixMultiplication(int[][] array1, int[][] array2, int length, int breadth) {
		int[][] result = new int[length][breadth];
		int sum = 0;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < breadth; j++) {
				sum = 0;
				for (int k = 0; k < length; k++) {
					sum = sum + array1[i][k] * array2[k][j];
				}
				result[i][j] = sum;
			}
		}
		return result;
	}

	// https://www.geeksforgeeks.org/inplace-m-x-n-size-matrix-transpose/
	public static void findTransposeOfMatrix(int[][] matrix, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

	}

	// https://www.geeksforgeeks.org/print-unique-rows/
	// think of other approaches as well
	public static void printUniqueRowsInMatrix(int[][] matrix, int length, int breadth) {
		Map<String, Integer> map = new HashMap();
		StringBuilder temp = new StringBuilder("");
		String value = "";
		for (int i = 0; i < length; i++) {
			temp = new StringBuilder("");
			for (int j = 0; j < breadth; j++) {
				temp = temp.append(matrix[i][j]);
			}
			value = temp.toString();
			if (map.containsKey(value)) {
				map.put(value, map.get(value) + 1);
			} else {
				map.put(value, 1);
			}
		}
		for (String key : map.keySet()) {
			if (map.get(key) == 1)
				System.out.println(key + " ");
		}
	}

	// https://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/ public
	// static void printMatrixInSpiral(int[][] matrix, int length, int breadth) {
	public static void printMatrixInSpiral(int[][] matrix, int length, int breadth) {
		int l = 0;
		int b = 0;
		while (l < length && b < breadth) {
			for (int i = b; i < breadth; i++) {
				System.out.print(matrix[l][i] + " ");
			}
			l++;
			for (int i = l; i < length; i++) {
				System.out.print(matrix[i][breadth - 1] + " ");
			}
			breadth--;
			if (l < length) {
				for (int i = breadth - 1; i >= b; i--) {
					System.out.print(matrix[length - 1][i] + " ");
				}
				length--;
			}
			if (b < breadth) {
				for (int i = length - 1; i >= l; i--) {
					System.out.print(matrix[i][l] + " ");
				}
				b++;
			}
			System.out.println();
		}
	}

	public static void rotateMatrixBy90() {

	}

	// https://www.geeksforgeeks.org/find-rectangle-binary-matrix-corners-1/
	public static void findRectangleInMatrix(int[][] matrix) {

	}
	// matrix rotation by 90 degrees
	// https://www.geeksforgeeks.org/find-median-row-wise-sorted-matrix/
}
