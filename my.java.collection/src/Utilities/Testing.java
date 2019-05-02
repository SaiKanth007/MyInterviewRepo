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

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class Testing implements Serializable {

    /** * The serializable version Id */
    private static final long serialVersionUID = -3771755785034784363L;

    public static void main(String args[]) throws Exception {

        // think of converting byte to integer
        testPriorityQueue();
        // if(null==2) not allowed

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
        System.out.println("Patter for Inc and Dec is : " + patternForIncAndDec("MMM"));

        final int[] array = {2, 3, 10, 10, 14, 12};
        Arrays.binarySearch(array, 10);
        final int[] coffArray = {2, 1, -1, 3, 5};
        System.out.println(findNumberOfPairs(array, coffArray));

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
        final List temp = new ArrayList(1);
        temp.add(2);
        temp.add(3);
        temp.add(4);
        System.out.println(temp.get(2));

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

    public static int findNumberOfPairs(int[] array, int[] coffArray) {
        long count = 0;
        final int length = array.length;
        long lhsValue = 0;
        long rhsValue = 0;
        final int modNumber = (int) Math.round(Math.pow(10, 9)) + 7;

        Arrays.sort(array);
        Arrays.sort(coffArray);
        for (int i = 0; i < length; i++) {
            if (array[i] > -1) {
                for (int j = i; j < length; j++) {
                    lhsValue = (long) (coffArray[0] * Math.pow(array[i], 3) + coffArray[1] * Math.pow(array[i], 2)
                                    + coffArray[2] * array[i] + coffArray[3]);
                    lhsValue = Math.floorMod(lhsValue, coffArray[4]);
                    rhsValue = (long) Math.pow(array[j], 2);
                    rhsValue = Math.floorMod(rhsValue, coffArray[4]);
                    if (lhsValue == rhsValue) {
                        count++;
                    }
                }
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (array[j] > -1) {
                    lhsValue = (long) (coffArray[0] * Math.pow(array[j], 3) + coffArray[1] * Math.pow(array[j], 2)
                                    + coffArray[2] * array[j] + coffArray[3]);
                    lhsValue = Math.floorMod(lhsValue, coffArray[4]);
                    rhsValue = (long) Math.pow(array[i], 2);
                    rhsValue = Math.floorMod(rhsValue, coffArray[4]);
                    if (lhsValue == rhsValue && i != j) {
                        count++;
                    }
                }
            }
        }
        return (int) Math.floorMod(count, modNumber);
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
        final PriorityQueue<Employee> pq =
                        new PriorityQueue<>((e1, e2) -> e1.getRank().compareTo(e2.getRank()));
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
        System.out
            .println("Conclusion: The order of the objects inside the priority queue doesn't change even if the contents of the obects inside the queue are modified");

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

    static int patternForIncAndDec(String pattern) {

        final char[] array = pattern.toCharArray();
        final int length = array.length;
        String result = "";
        int currentNumber = findInitNumber(array);
        result = result.concat(Integer.toString(currentNumber));
        int firstAscFromdesc = -1;
        int countFromFirstAscFromDesc = 0;
        for (int i = 0; i < length; i++) {
            if (array[i] == 'M') {
                while (result.contains(Integer.toString(currentNumber - 1))) {
                    currentNumber--;
                }
                if (currentNumber != 0) {
                    result = result.concat(Integer.toString(currentNumber - 1));
                    currentNumber--;
                } else {
                    i = firstAscFromdesc - 1;
                    currentNumber = countFromFirstAscFromDesc + 1;
                    result = result.substring(0, firstAscFromdesc + 1);
                    System.out.println("Going to index " + i + " with current number " + currentNumber
                                    + " and result string " + result);
                }

            } else {
                while (result.contains(Integer.toString(currentNumber + 1))) {
                    currentNumber++;
                }
                result = result.concat(Integer.toString(currentNumber + 1));
                currentNumber++;
                if (firstAscFromdesc != -1) {
                    firstAscFromdesc = i;
                    countFromFirstAscFromDesc = currentNumber;
                }
            }

        }

        return result == "" ? Integer.parseInt(result) : -1;

    }

    public static int findInitNumber(char[] array) {
        final int length = array.length;
        int index = 0;
        while (index < length && array[index] == 'M') {
            index++;
        }
        if (index > 0) {
            return index + 1;
        }
        return 1;
    }
}


class Parent {

}


class Child extends Parent {

}
