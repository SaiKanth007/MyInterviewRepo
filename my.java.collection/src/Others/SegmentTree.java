package src.Others;

import src.Utilities.JavaUtility;

//https://www.hackerearth.com/practice/data-structures/advanced-data-structures/segment-trees/tutorial/
//https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/SegmentTreeMinimumRangeQuery.java
public class SegmentTree {

	public static void constructTree(int[] array, int[] segArray, int low, int high, int pos) {
		if (low <= high) {
			if (low == high) {
				segArray[pos] = array[low];
				return;
			} else {
				int mid = (low + high) / 2;
				constructTree(array, segArray, low, mid, 2 * pos + 1);
				constructTree(array, segArray, mid + 1, high, 2 * pos + 2);
				segArray[pos] = Math.min(segArray[2 * pos + 1], segArray[2 * pos + 2]);
			}
		}
	}

	public static void main(String[] args) {
		int[] array = { 0, 3, 4, 2, 1, 6, -1 };
		int[] segArray = createSegmentArrayForGivenArray(array);
		constructTree(array, segArray, 0, array.length - 1, 0);
		System.out.println("The segment array is");
		JavaUtility.print(segArray);
		System.out.println();
		System.out.println(
				"The minimu value in the given range is:" + rangeMinQuery(segArray, 0, 3, 0, array.length - 1, 0));
	}

	public static int[] createSegmentArrayForGivenArray(int[] array) {
		System.out.println("The power of 2 is" + Math.pow(2, (int) Math.ceil(Math.log(array.length) / Math.log(2))));
		int segArray[] = new int[2 * (int) Math.pow(2, (int) Math.ceil(Math.log(array.length) / Math.log(2))) - 1];
		for (int i = 0; i < segArray.length; i++) {
			segArray[i] = Integer.MAX_VALUE;
		}
		System.out.println("The segment array is");
		JavaUtility.print(segArray);
		return segArray;

	}

	public static int rangeMinQuery(int[] segArray, int qLow, int qHigh, int low, int high, int pos) {
		if (qLow > high || qHigh < low) {
			return Integer.MAX_VALUE;
		} else if (qLow <= low && qHigh >= high) {
			return segArray[pos];
		} else {
			int mid = (low + high) / 2;
			return Math.min(rangeMinQuery(segArray, qLow, qHigh, low, mid, 2 * pos + 1),
					rangeMinQuery(segArray, qLow, qHigh, mid + 1, high, 2 * pos + 2));
		}
	}

	// we have to update segment array on every update to the existing contents of
	// the actual array
	public static void updateSegmentArray() {

	}
}
