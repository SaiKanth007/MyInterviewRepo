import java.util.EnumSet;

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
	
	public static void print(int[] array) {
		int length = array.length;
		for(int i=0;i<length;i++) {
			System.out.print(array[i] + " ");
		}
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
