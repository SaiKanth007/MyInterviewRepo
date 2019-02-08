package src.Others;

import src.Utilities.JavaUtility;

public class MySudoku {

	public static void main(String[] args) {
		int[][] matrix = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
				{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
		JavaUtility.printMatrix(matrix, 9, 9);
		solveSudoku(matrix);
		System.out.println();
		JavaUtility.printMatrix(matrix, 9, 9);
	}

	public static boolean solveSudoku(int[][] matrix) {

		for (int rowIndex = 0; rowIndex < 9; rowIndex++) {
			for (int columnIndex = 0; columnIndex < 9; columnIndex++) {
				if (matrix[rowIndex][columnIndex] == 0) {
					return solveSudoku(matrix, rowIndex, columnIndex);
				}
			}
		}
		return true;
	}

	public static boolean solveSudoku(int[][] matrix, int rowIndex, int columnIndex) {
		for (int index = 1; index <= 9; index++) {
			if (checkForNumber(matrix, rowIndex, columnIndex, index)) {
				matrix[rowIndex][columnIndex] = index;
				if (solveSudoku(matrix)) {
					return true;
				} else {
					matrix[rowIndex][columnIndex] = 0;
				}
			}
		}
		return false;
	}

	public static boolean checkForNumber(int[][] matrix, int i, int j, int input) {
		return checkRow(matrix, i, input) && checkColumn(matrix, j, input) && checkGrid(matrix, i, j, input);
	}

	public static boolean checkRow(int[][] matrix, int i, int input) {
		for (int index = 0; index < 9; index++) {
			if (matrix[i][index] == input)
				return false;
		}
		return true;
	}

	public static boolean checkColumn(int[][] matrix, int j, int input) {
		for (int index = 0; index < 9; index++) {
			if (matrix[index][j] == input)
				return false;
		}
		return true;
	}

	public static boolean checkGrid(int[][] matrix, int i, int j, int input) {
		int gridRow = (i / 3) * 3;
		int gridColumn = (j / 3) * 3;
		for (int rowIndex = gridRow; rowIndex < gridRow + 3; rowIndex++) {
			for (int columnIndex = gridColumn; columnIndex < gridColumn + 3; columnIndex++) {
				if (matrix[rowIndex][columnIndex] == input)
					return false;
			}
		}
		return true;
	}

}