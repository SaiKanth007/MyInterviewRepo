package src.Utilities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import org.json.simple.parser.JSONParser;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class Testing implements Serializable {

	/** * The serializable version Id */
	private static final long serialVersionUID = -3771755785034784363L;

	public static void main(String args[]) throws Exception {

		// maximum size of the string is Integer.MAX_VALUE;
		// think of converting byte to integer
		testPriorityQueue();
		// if(null==2) not allowed

		String parseExample = "\"" + "sai" + "testing";
		System.out.println(parseExample);

		String temp = new String(new String("Sai"));

		// ((long) x) & 0xffffffffL --> same as function
		final long unsignedValue = Integer.toUnsignedLong(-234);
		System.out.println("Unsinged values is" + unsignedValue);
		new Parent();
		new Child();
		new Child();
		final String input = "011100";
		System.out.println(findLengthOfLargestSubString(input, input.length()));
		System.out.println(findLengthOfLargestSubString2(input, input.length()));
		System.out.println("Integer.MAX_VALUE+1 is " + (Integer.MAX_VALUE + 1));
		System.out.println("The log value of the given number is:" + Math.log10(105));

		final List<String> strings = new ArrayList();
		strings.add("sai");
		strings.add("kanth");
		strings.add("Joey");
		final Iterator<String> it = strings.iterator();
		while (it.hasNext()) {
			if (it.next() == "sai") {
				// strings.remove(1); // here if we try to remove/add it will throw exception
				// in the beggining of the next iteration
				it.remove(); // safe to do it
				System.out.println("String removed");
				System.out.println("String at length 0 is: " + strings.get(0));
			}
		}

		if ('a' < 'b') {
			System.out.println("Character comparision can be done");
		}

		testingForHashCode();

		String s1 = "123";
		final String s2 = s1;
		s1 = "abc";
		System.out.println("String vlue is:" + s2);
		// passing capacity here, will not have any impact on behvaior of array list
		final List tempList = new ArrayList(1);
		tempList.add(2);
		tempList.add(3);
		tempList.add(4);
		System.out.println(tempList.size());

		final String s3 = new String("abc");
		final String s4 = new String("abc");

		final Set<String> set = new HashSet<>();
		set.add(s4);
		set.add(s3);
		// size would be 1 because string class override equalto and hashcode function
		System.out.println("The System size is:" + set.size());

	}

	public static int findLengthOfLargestSubString(String input, int length) {
		int maxCount = 0;
		final char[] array = input.toCharArray();
		for (int i = 0; i < length; i++) {
			final int[] zeros = new int[length - i];
			final int[] ones = new int[length - i];
			int count = 0;
			if (array[i] == '1') {
				ones[count]++;
			} else {
				zeros[count]++;
			}
			count++;
			for (int j = i + 1; j < length; j++) {
				if (array[j] == '1') {
					ones[count] = ones[count - 1] + 1;
					zeros[count] = zeros[count - 1];
				} else {
					zeros[count] = zeros[count - 1] + 1;
					ones[count] = ones[count - 1];
				}
				if (zeros[count] > ones[count]) {
					if (j - i + 1 > maxCount) {
						maxCount = j - i + 1;
					}
				}
				count++;
			}
		}
		return maxCount;
	}

	public static void testingForHashCode() {
		final Employee emp1 = new Employee("Sai", "001");
		final Employee emp2 = new Employee("Sai", "001");
		System.out.println("The Hashcode of the first object is:" + emp1.hashCode());
		System.out.println("The Hashcode of the second object is:" + emp2.hashCode());

		if (emp1.hashCode() == emp2.hashCode()) {
			System.out.println("Hashcodes are equal if objects content are same");
		} else {
			System.out.println("Hashcodes are not equal even if objects content are same");
		}

		if (emp1.equals(emp2)) {
			System.out.println("if Hashcodes are equal then equal functions return true for different objects");
		}

	}

	public static void testPriorityQueue() {
		final PriorityQueue<Employee> pq = new PriorityQueue<>((e1, e2) -> e1.getRank().compareTo(e2.getRank()));
		final Employee e1 = new Employee("Jack", "A124", 23);
		final Employee e2 = new Employee("Jack24", "A124", 24);
		pq.add(e2);
		pq.add(e1);
		System.out.println("Printing Employee's from Priority Queue");
		for (final Employee emp : pq) {
			System.out.println(emp.getName());
		}
		e2.setRank(2);
		pq.add(e2);
		System.out.println("Printing Employee's from Priority Queue");
		for (final Employee emp : pq) {
			System.out.println(emp.getName());
		}
		System.out.println(
				"Conclusion: The order of the objects inside the priority queue doesn't change even if the contents of the obects inside the queue are modified");

		final Map<Integer, Integer> treeMap = new TreeMap<>();
		treeMap.put(2, 200);
		treeMap.put(1, 100);
		System.out.println("Printing Values from Tree Map");
		for (final Map.Entry<Integer, Integer> emp : treeMap.entrySet()) {
			System.out.println(emp.getKey());
		}
		treeMap.put(2, 50);
		System.out.println("Printing Values from Tree Map");
		for (final Map.Entry<Integer, Integer> emp : treeMap.entrySet()) {
			System.out.println(emp.getKey());
		}

		final Map<Character, Integer> charMap = new LinkedHashMap<>();
		charMap.put('a', 1);
		charMap.put('b', 1);
		charMap.put('c', 1);
		charMap.put('b', 2); // the order will still be a,b,c and not a,c,b.
		charMap.keySet().stream().forEach(e -> System.out.println(e));
	}

	public static int findLengthOfLargestSubString2(String input, int length) {
		int maxCount = 0;
		int diffCount = 0;
		for (int i = 0; i < length; i++) {
			diffCount = 0;
			if (input.charAt(i) == '0') {
				diffCount++;
			} else {
				diffCount--;
			}
			for (int j = i + 1; j < length; j++) {
				if (input.charAt(j) == '0') {
					diffCount++;
				} else {
					diffCount--;
				}
				if (diffCount > 0) {
					if (j - i + 1 > maxCount) {
						maxCount = j - i + 1;
					}
				}
			}
		}

		return maxCount;
	}
}

class Parent {

}

class Child extends Parent {

}
