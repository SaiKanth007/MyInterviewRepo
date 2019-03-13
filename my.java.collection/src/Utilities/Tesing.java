
package src.Utilities;

import java.util.HashMap;
import java.util.Map;

public class Tesing {

	public static void main(String[] args) {
		// stackOverFlowMethod(); // causes stack over flow error
		// remove all characters other than alphabets from the given string
		System.out.println("Sai".replaceAll("[^a-zA-Z]", ""));

		System.out.println("Hello World");
		String string = "string";
		String[] abc = "I am good".split(" ");
		System.out.println(abc.length);
		System.out.println(string.matches("[^0-9]+"));
		System.out.println(Integer.MAX_VALUE);
		Integer a = 127;
		Integer b = 127;
		if (a == b) {
			System.out.println("Integer objects less than 127 will have same reference, like string pool");
		}

		System.out.println(Integer.toBinaryString(20));
		Map<String, String> power5BinaryMap = new HashMap<>();
		for (Integer i = 1; i > 0 && i < Integer.MAX_VALUE; i = i * 5) {
			power5BinaryMap.put(Integer.toBinaryString(i), "1");
		}
		System.out.println(power5BinaryMap.size());

		outOfMemoryMethod();

		int[] temp = new int[9];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = i++;
		}
		for (int i = 0; i < temp.length; i++) {
			System.out.print(temp[i] + " ");
		}
	}

	public static void stackOverFlowMethod() {
		stackOverFlowMethod();
	}

	public static void outOfMemoryMethod() {
		
		 int[] array = new int[Integer.MAX_VALUE];
	}

	// https://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together/

}
