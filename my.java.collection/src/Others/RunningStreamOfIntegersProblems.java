package src.Others;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import src.Utilities.JavaUtility;

/**
 * 1. If the two elements have same priority, priority queue doesn't gaurantee
 * the order of insertion while doing a heapify 2. If an element priority is
 * modified, priority queue will not be aware of it and hence we have to remove
 * the element and add it with new priority for priority queue to run the
 * heapify function or other solution is to have a timestamp and add a custom
 * comparator to consider timestamp if the priorites are equal
 * 
 * @author sai_kanth
 *
 */
public class RunningStreamOfIntegersProblems {

	public static int[] leftArray = new int[100];
	public static int leftArrayLength = 0;
	public static int rightArrayLength = 0;

	public static int[] rightArray = new int[100];

	public static void main(String[] args) {
		int[] array = { 3, 1, 4, 2, -1, 0 };
		// System.out.println(Arrays.toString(array));
		heapSort(array);
		// System.out.println(Arrays.toString(array));

		PriorityQueue<Integer> minQueue = new PriorityQueue();
		PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>((o1, o2) -> o2.compareTo(o1));
		PriorityQueue<Integer> minQueueForNthMax = new PriorityQueue();

		int[] runningStreamOfIntegers = { 5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4 };

		for (int i = 0; i < runningStreamOfIntegers.length; i++) {
			System.out.print(medianOfRunningStreamOfIntegers(runningStreamOfIntegers[i], minQueue, maxQueue) + " ");
		}
		System.out.println();
		for (int i = 0; i < runningStreamOfIntegers.length; i++) {
			System.out.print(
					nThGreatestInRunningStreamOfIntegers(minQueueForNthMax, runningStreamOfIntegers[i], 4) + " ");
		}

		 KthMostRepeatedWordFromRunningStreamOfWords();
		// findFirstNonRepeatingCharacter();

	}

	// not working yet to do
	public static void KthMostRepeatedWordFromRunningStreamOfWords() {
		String input = "If you like Geeks for Geeks and would like to contribute \n"
				+ "mail your article to contribute at \n"
				+ "geeksforgeeks org and See your article appearing on the Geeks for Geeks main page, also help \n"
				+ "thousands of other Geeks";
		String[] inputArray = input.split(" ");
		int length = inputArray.length;
		PriorityQueue<StringWithFreq> minQueueForKMostFreqWords = new PriorityQueue<StringWithFreq>(
				(s1, s2) -> s1.getFrequency().compareTo(s2.getFrequency()));
		Map<String, StringWithFreq> stringMap = new HashMap<String, StringWithFreq>();
		for (int i = 0; i < length; i++) {
			String result = kMostFreqWords(minQueueForKMostFreqWords, stringMap, inputArray[i], 2);
			System.out.println("Kth Most Freq Word is: " + result);
		}
	}

	// working
	public static int medianOfRunningStreamOfIntegers(int input, PriorityQueue<Integer> minQueue,
			PriorityQueue<Integer> maxQueue) {
		if (maxQueue.size() == 0) {
			maxQueue.add(input);
			return input;
		}
		if (input < maxQueue.peek()) {
			maxQueue.add(input);
		} else {
			minQueue.add(input);
		}
		if (maxQueue.size() - minQueue.size() >= 2) {
			minQueue.add(maxQueue.poll());
		} else if (minQueue.size() - maxQueue.size() >= 2) {
			maxQueue.add(minQueue.poll());
		}
		if (maxQueue.size() == minQueue.size()) {
			return (maxQueue.peek() + minQueue.peek()) / 2;
		} else if (maxQueue.size() > minQueue.size()) {
			return maxQueue.peek();
		} else {
			return minQueue.peek();
		}

	}

	public static void heapSort(int[] array) {
		int length = array.length;
		minHeapConstruction(array);
		for (int index = length - 1; index > 0; index--) {
			JavaUtility.swap(array, 0, index);
			minHeapify(array, 0, index);
		}
	}

	public static void minHeapConstruction(int[] array) {
		int length = array.length;
		for (int index = length / 2; index >= 0; index--) {
			minHeapify(array, index, length);
		}
	}

	public static void minHeapify(int[] array, int index, int length) {
		if (index >= length)
			return;
		int i = 2 * index + 1;
		int j = 2 * index + 2;
		int min = index;
		if (i < length && array[i] < array[min])
			min = i;
		if (j < length && array[j] < array[min])
			min = j;
		if (min != index) {
			JavaUtility.swap(array, min, index);
			minHeapify(array, min, length);
		}
	}

	public static void minMapHeapify(int[] array, boolean isMinHeap) {
		int length = array.length;
		for (int index = length / 2; index >= 0; index--) {
			minMaxHeapifyUtil(array, index, length, isMinHeap);
		}
	}

	public static void minMaxHeapifyUtil(int[] array, int index, int length, boolean isMinHeap) {
		if (index >= length)
			return;
		int i = 2 * index + 1;
		int j = 2 * index + 2;
		int min = index;
		if (i < length && ((isMinHeap && array[i] < array[min])) || (!isMinHeap && array[i] > array[min]))
			min = i;
		if (j < length && ((isMinHeap && array[j] < array[min])) || (!isMinHeap && array[j] > array[min]))
			min = j;
		if (min != index) {
			JavaUtility.swap(array, min, index);
			minHeapify(array, min, length);
		}
	}

	// similar we can go for nthSmallest as well
	public static int nThGreatestInRunningStreamOfIntegers(PriorityQueue minQueue, int input, int n) {
		minQueue.add(input);
		if (minQueue.size() < n)
			return Integer.MIN_VALUE;
		else if (minQueue.size() > n) {
			minQueue.poll();
		}
		return (int) minQueue.peek();
	}

	// using hashmap will not scale since words can be huge, we should better go for
	// Trie
	// Not Working, yet to do
	public static String kMostFreqWords(PriorityQueue<StringWithFreq> minQueue,
			Map<String, StringWithFreq> stringFreqMap, String input, int n) {
		if (stringFreqMap.containsKey(input)) {
			StringWithFreq newStringWithFreq = new StringWithFreq(input, 1 + stringFreqMap.get(input).getFrequency());
			minQueue.remove(stringFreqMap.get(input));
			minQueue.add(newStringWithFreq);
		} else {
			StringWithFreq stringFrqObject = new StringWithFreq(input, 1);
			stringFreqMap.put(input, stringFrqObject);
			minQueue.add(stringFrqObject);
		}
		if (minQueue.size() < n)
			return "";
		else if (minQueue.size() > n) {
			minQueue.poll();
		}
		return minQueue.peek().getInput();
	}

	// https://www.geeksforgeeks.org/find-first-non-repeating-character-stream-characters/
	public static void findFirstNonRepeatingCharacter() {

		boolean[] appearedAlready = new boolean[256];
		String stream = "geeksforgeeksandgeeksquizfor";
		// can also be done using a linked hashmap
		List<Character> nodes = new LinkedList<>();
		int length = stream.length();
		for (int index = 0; index < length; index++) {
			Character currentChar = stream.charAt(index);
			if (appearedAlready[(int) currentChar]) {
				nodes.remove(currentChar);
			} else {
				appearedAlready[(int) currentChar] = true;
				nodes.add(currentChar);
			}
			if (!nodes.isEmpty())
				System.out.println("The first repeatring character till " + index + " th element is" + nodes.get(0));
		}
	}
}

class StringWithFreq {
	String input;

	public StringWithFreq(String input, Integer frequency) {
		super();
		this.input = input;
		this.frequency = frequency;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public Integer getFrequency() {
		return frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}

	Integer frequency;
}
