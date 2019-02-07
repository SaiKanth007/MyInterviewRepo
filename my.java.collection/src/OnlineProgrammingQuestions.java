package src;

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
		System.out.println("Number of 2 digited numbers with the given sum is:" + printNoOfNumbers(n, sum));

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
}
