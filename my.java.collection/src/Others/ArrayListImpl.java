package src.Others;

public class ArrayListImpl {

	int[] array;
	// 2^31 = 2,147,483,648 max value
	int capacity;
	double loadFactor;
	int currentSize;

	public ArrayListImpl() {
		capacity = 16;
		array = new int[capacity];
		loadFactor = 0.7;
	}

	public void add(int input) {
		array[currentSize] = input;
		currentSize = currentSize + 1;
		if ((double) currentSize / capacity > loadFactor)
			doubleArray();
		System.out.println("Size of the array after adding element " + input + " is " + currentSize);
	}

	public void doubleArray() {
		System.out.println("Doubling the array");
		capacity = capacity * 2;
		int[] newArray = new int[capacity];
		for (int i = 0; i < currentSize; i++) {
			newArray[i] = array[i];
		}

		array = newArray;
	}

	public int get(int index) throws Exception {
		if (index < currentSize) {
			return array[index];
		}
		throw new Exception();
	}

	public static void main(String[] args) {
		ArrayListImpl list = new ArrayListImpl();
		for (int i = 0; i < 30; i++) {
			list.add(i);
		}
	}
}
