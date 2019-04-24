package src;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
		int breadth = spiralMatrix.length;
		int length = spiralMatrix[0].length;
		System.out.println("Length and breadth are:" + breadth + length);

		int uniqueMatrix[][] = { { 0, 1, 0, 0, 1 }, { 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 1 }, { 1, 1, 1, 0, 0 } };
		System.out.println("Unique rows in the matrix are:");
		printUniqueRowsInMatrix(uniqueMatrix, 4, 5);
		long[] array = { 3, 4, 5 };
		// System.out.println(solve(array, 3));
		int[] bitArray = { 0, 0, 1, 1, 1, 0, 0, 0, 0 };
		// method(bitArray, bitArray.length);
		findTransposeOfMatrix(mat, 4);
		JavaUtility.printMatrix(mat, 4, 4);

		int[][] matrixForDiagonalView = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		printDiagonalViewOfMatrix(matrixForDiagonalView, 3, 3);

		int[][] matrixForMaxOnes = { { 0, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 0 }, { 0, 1, 1, 1 } };
		System.out.println("Maximum number of ones present in any row is: "
				+ findRowWithMaximumNumberOfOnes(matrixForMaxOnes, 4, 4));

		int[][] matrixForRectangle = { { 1, 0, 0, 1, 0 }, { 0, 0, 1, 0, 1 }, { 0, 0, 0, 1, 0 }, { 1, 0, 1, 0, 1 } };
		System.out.println("There is a matrix with rectangle:" + findRectangleInMatrix(matrixForRectangle));

		int[][] updateMatrix = { { 1, 0, 1, 1, 0, 0, 1, 0, 0, 1 }, { 0, 1, 1, 0, 1, 0, 1, 0, 1, 1 },
				{ 0, 0, 1, 0, 1, 0, 0, 1, 0, 0 }, { 1, 0, 1, 0, 1, 1, 1, 1, 1, 1 }, { 0, 1, 0, 1, 1, 0, 0, 0, 0, 1 },
				{ 0, 0, 1, 0, 1, 1, 1, 0, 1, 0 }, { 0, 1, 0, 1, 0, 1, 0, 0, 1, 1 }, { 1, 0, 0, 0, 1, 1, 1, 1, 0, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 0, 1, 0 }, { 1, 1, 1, 1, 0, 1, 0, 0, 1, 1 } };
		updateMatrix(updateMatrix);

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
	// think of other approaches as well, like inserting rows in a tree and if path
	// is already present
	public static void printUniqueRowsInMatrix(int[][] matrix, int length, int breadth) {
		Set<String> map = new HashSet();
		StringBuilder temp = new StringBuilder("");
		for (int i = 0; i < length; i++) {
			temp = new StringBuilder("");
			for (int j = 0; j < breadth; j++) {
				temp = temp.append(matrix[i][j]);
			}
			if (!map.contains(temp.toString()))
				map.add(temp.toString());
			else
				map.remove(temp.toString());
		}
		for (String key : map) {
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

	// https://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/
	// can be achieved by rear and front column swapping and then swappng the mirror
	// elements
	public static void rotateMatrixBy90() {

	}

	// https://www.geeksforgeeks.org/find-rectangle-binary-matrix-corners-1/
	// working
	public static boolean findRectangleInMatrix(int[][] matrix) {
		int rows = matrix.length;
		int columns = matrix[0].length;
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns - 1; j++) {
				for (int k = j + 1; k < columns; k++) {
					if (matrix[i][j] == 1 && matrix[i][k] == 1) {
						if (map.containsKey(j) && map.get(j).contains(k)) {
							System.out.println("The vertices are: " + i + " " + j + " " + k);
							return true;
						}
						if (map.containsKey(k) && map.get(k).contains(j)) {
							return true;
						}
						if (!map.containsKey(j)) {
							Set<Integer> set = new HashSet<>();
							set.add(k);
							map.put(j, set);
						} else {
							map.get(j).add(k);
						}
						if (!map.containsKey(k)) {
							Set<Integer> set = new HashSet<>();
							set.add(j);
							map.put(k, set);
						} else {
							map.get(k).add(j);
						}
					}
				}
			}
		}
		return false;
	}

	// https://www.geeksforgeeks.org/find-row-number-binary-matrix-maximum-number-1s/
	public static int findRowWithMaximumNumberOfOnes(int[][] matrix, int length, int breadth) {
		int i = 0;
		int j = breadth - 1;
		int maxOnesSize = Integer.MIN_VALUE;
		while (i < length && j >= 0) {
			if (matrix[i][j] == 1)
				j--;
			else {
				maxOnesSize = Math.max(maxOnesSize, breadth - j - 1);
				i++;
			}
		}
		return maxOnesSize;
	}

	// https://www.geeksforgeeks.org/print-matrix-diagonal-pattern/
	// problem makes sense only for square matrix, so don't think of rectangular
	// matrix and can be easily modified for diagonal view
	public static void printDiagonalViewOfMatrix(int[][] matrix, int length, int breadth) {
		int x = -1;
		int y = -1;
		for (int i = 0; i < length + breadth; i++) {
			if (i < length) {
				x = 0;
				y = i;
			} else {
				x = i - length + 1;
				y = length - 1;
			}
			for (int j = Math.max(length, breadth); j >= 0
					&& JavaUtility.checkIfIndexAreValid(x, y, length, breadth); j--) {
				System.out.print(matrix[x][y] + " ");
				x++;
				y--;
			}
		}
	}

	// https://www.geeksforgeeks.org/find-median-row-wise-sorted-matrix/
	public static int medianInRowWiseSortedMatrix(int[][] matrix, int rows, int columns) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < rows; i++) {
			min = Math.min(min, matrix[i][0]);
			max = Math.max(max, matrix[i][columns - 1]);
		}
		int mid = min + (max - min) / 2;
		int medIndex = -1;
		for (int i = 0; i < rows; i++) {
			medIndex = MyArray.binarySearch(matrix[0], 0, rows - 1, mid);
			if (medIndex == -1) {

			}
		}
		return 0;
	}

	// for working solution - look at my submissions -
	// https://leetcode.com/problems/01-matrix/submissions/
	public static int[][] updateMatrix(int[][] matrix) {

		int length = matrix.length;
		int breadth = matrix[0].length;
		int[][] result = new int[length][breadth];
		int[] xvalues = { 1, -1, 0, 0 };
		int[] yvalues = { 0, 0, 1, -1 };
		int nextXValue = -1;
		int nextYValue = -1;
		boolean adjacentZeroFound = false;

		for (int x = 0; x < length; x++) {
			if (x == 9)
				System.out.println("break");
			for (int y = 0; y < breadth; y++) {
				if (matrix[x][y] == 0)
					result[x][y] = 0;
				else {
					for (int k = 0; k < 4; k++) {
						nextXValue = x + xvalues[k];
						nextYValue = y + yvalues[k];
						if (JavaUtility.checkIfIndexAreValid(matrix, nextXValue, nextYValue)
								&& matrix[nextXValue][nextYValue] == 0) {
							adjacentZeroFound = true;
							break;
						}
					}
					if (adjacentZeroFound) {
						result[x][y] = 1;
						adjacentZeroFound = false;
					} else {
						int min = Integer.MAX_VALUE;
						for (int k = 0; k < 4; k++) {
							nextXValue = x + xvalues[k];
							nextYValue = y + yvalues[k];
							if (JavaUtility.checkIfIndexAreValid(matrix, nextXValue, nextYValue)) {
								min = Math.min(min, result[nextXValue][nextYValue]);
							}
							matrix[x][y] = min;
						}

					}
				}
			}
		}
		return result;
	}
}
