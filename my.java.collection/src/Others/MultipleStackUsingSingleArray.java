package src.Others;

//https://www.youtube.com/watch?v=DxW7VAsdX0o
public class MultipleStackUsingSingleArray {

	int[] stackData;
	int[] nextIndex;
	int[] topOfStacks;

	int nextAvailable = 0;

	public MultipleStackUsingSingleArray(int numStacks, int capacity) {
		topOfStacks = new int[numStacks];
		for (int i = 0; i < topOfStacks.length; i++) {
			topOfStacks[i] = -1;
		}
		stackData = new int[capacity];
		nextIndex = new int[capacity];
		for (int i = 0; i < nextIndex.length - 1; i++) {
			nextIndex[i] = i + 1;
		}
		nextIndex[nextIndex.length - 1] = -1;
	}

	public void push(int stack, int data) {
		if (stack <= 0 || stack >= topOfStacks.length) {
			System.out.println("Returning since the id of the stack is not valid");
			return;
		}
		if (nextAvailable < 0) {
			System.out.println("Stack is full");
			return;
		}

		int currentIndex = nextAvailable;
		stackData[currentIndex] = data;
		nextAvailable = nextIndex[currentIndex];

		// this piece of line is used while popping
		nextIndex[currentIndex] = topOfStacks[stack];

		topOfStacks[stack] = currentIndex;
	}

	public int pop(int stack) {
		if (stack <= 0 || stack >= topOfStacks.length) {
			System.out.println("Returning since the id of the stack is not valid");
			return -1;
		}
		if (topOfStacks[stack] == -1) {
			System.out.println("Stack is empty");
			return -1;
		}

		int currentIndex = topOfStacks[stack];
		int value = stackData[currentIndex];
		topOfStacks[stack] = nextIndex[currentIndex];
		nextIndex[currentIndex] = nextAvailable;
		nextAvailable = currentIndex;

		return value;

	}

}
