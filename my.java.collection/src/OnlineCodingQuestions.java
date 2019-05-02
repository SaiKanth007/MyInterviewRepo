package src;

import java.util.Arrays;

//do not use static variables in case of competitive programing
//think of overflow scenario's
public class OnlineCodingQuestions {

	public static void main(String[] args) {
		System.out.println(myAtoi("2147483646"));
		int[] nums = { 4, 2, 0, 2, 3, 2, 0 };
		nextPermutation(nums);
	}

	public static int myAtoi(String str) {
		if ("".equals(str) || str == null)
			return 0;
		String[] array = str.split("\\s+");
		if (array.length == 0)
			return 0;
		String result = array[0];
		if ("".equals(result))
			result = array[1];
		boolean isNegativeNumber = false;
		// System.out.println(result);
		if (result.charAt(0) == '-') {
			isNegativeNumber = true;
			result = result.substring(1, result.length());
		}

		else if (result.charAt(0) == '+') {
			result = result.substring(1, result.length());
		}

		char[] resultArray = result.toCharArray();
		int length = resultArray.length;
		if (length > 0 && resultArray[0] >= 48 && resultArray[0] <= 57) {
			int sum = 0;
			int prevSum = 0;
			for (int i = 0; i < length; i++) {
				if (resultArray[i] < 48 || resultArray[i] > 57) {
					if (isNegativeNumber)
						return sum * -1;
					return sum;
				}
				prevSum = sum;
				sum = sum * 10 + ((int) resultArray[i] - 48);
				if (sum >= 2147483647 / 10 && ((i == length - 2 && (int) resultArray[i + 1] - 48 > 7)
						|| (i <= length - 2 && sum != 214748364)))
					if (isNegativeNumber) {
						return Integer.MIN_VALUE;
					} else
						return Integer.MAX_VALUE;
			}
			if (isNegativeNumber)
				return sum * -1;
			return sum;
		} else
			return 0;

	}

	public static void nextPermutation(int[] nums) {

		int length = nums.length;
		boolean matchNotFound = true;
		outerloop: for (int i = length - 1; i > 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] <= nums[j])
					continue;
				else {
					matchNotFound = false;
					swap(nums, i, j);
					Arrays.sort(nums, j + 1, length);
					break outerloop;
				}
			}
		}
		if (matchNotFound) {
			for (int i = 0; i < length / 2; i++) {
				swap(nums, i, length - i - 1);
			}
		}
	}

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
