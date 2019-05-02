package src;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://www.geeksforgeeks.org/stack-data-structure/
//any question related to balancing of expresison try to use stacks
public class MyStack {

	public static void main(String[] args) {
		Stack<Integer> inputStack = new Stack<Integer>();
		inputStack.push(2);
		inputStack.push(1);
		inputStack.push(3);
		inputStack.push(4);
		System.out.println(inputStack);
		sortStack(inputStack);
		System.out.println(inputStack);
		System.out.println(checkForBalanceParanthesis(""));

		int[] printNextGreatestElement = { 13, 7, 6, 12 };
		printNextGreatestElement(printNextGreatestElement);

		int[] ReplaceElementWithGreatestElementonRight = { 13, 50, 6, 12, 24 };
		replaceElementLargestElementOnRightSide(ReplaceElementWithGreatestElementonRight);

		int[] stockSpanProblem = { 100, 80, 60, 70, 60, 75, 85 };
		stockSpanProblem(stockSpanProblem);
		String stringForInfixToPostFix = "a+b*(c^d-e)^(f+g*h)-i";
		String stringForPostfixToInfix = "abcd^e-fgh*+^*+i-";
		String stringForPrefixToInfix = "*+AB-CD";
		System.out.println("Infix to postfix is:" + stringForInfixToPostFix + "->");
		System.out.println(infixToPostFix(stringForInfixToPostFix));
		System.out.println("postfix to infix is:" + stringForPostfixToInfix + "->");
		System.out.println(postfixToInfix(stringForPostfixToInfix));
		System.out.println("prefix to infix is:" + stringForPrefixToInfix + "->");
		System.out.println(prefixToInfix(stringForPrefixToInfix));

		int[] givenPreOrderCanRepresentBST = { 40, 30, 35, 20, 80, 100 };
		System.out.println("Given preorder can represent BST:" + checkIfGivenPreOrderCanRepresentBST(
				givenPreOrderCanRepresentBST, 0, givenPreOrderCanRepresentBST.length - 1));

		String minimumNumberFromGivenSeq = "DIDI";
		System.out.println(minimumNumberFromGivenSeq(minimumNumberFromGivenSeq));

		int[][] celebrityMatrix = { { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 } };
		System.out.println("The celebrity person is: " + celebrityProblem(celebrityMatrix));
	}

	// https://www.geeksforgeeks.org/reverse-stack-without-using-extra-space/ - read
	// this when u have time
	public static void reverseStack(Stack<Integer> input) {
		if (!input.isEmpty()) {
			int element = input.pop();
			reverseStack(input);
			reverseStackUtil(input, element);
		}
	}

	public static void reverseStackUtil(Stack<Integer> input, int element) {
		if (input.isEmpty()) {
			input.push(element);
		} else {
			int memoryElement = input.pop();
			reverseStackUtil(input, element);
			input.push(memoryElement);
		}
	}

	public static void sortStack(Stack<Integer> input) {
		if (!input.isEmpty()) {
			int element = input.pop();
			sortStack(input);
			sortStackUtil(input, element);
		}
	}

	public static void sortStackUtil(Stack<Integer> input, int element) {
		if (input.isEmpty() || input.peek() < element) {
			input.push(element);
		} else {
			int memoryElement = input.pop();
			sortStackUtil(input, element);
			input.push(memoryElement);
		}
	}

	// assuming the string contains only paranthesis
	// https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
	public static boolean checkForBalanceParanthesis(String input) {
		if (input.isEmpty())
			return true;
		else {
			char[] inputArray = input.toCharArray();
			int length = input.length();
			Stack<Character> stack = new Stack<Character>();
			for (int index = 0; index < length; index++) {

				char currentElement = inputArray[index];
				if (currentElement == '{' || currentElement == '[' || currentElement == '(') {
					stack.push(currentElement);
				} else {
					if (stack.isEmpty()) {
						return false;
					}
					char prevElement = (char) stack.pop();
					if (currentElement == '}' && prevElement != '{')
						return false;
					if (currentElement == ']' && prevElement != '[')
						return false;
					if (currentElement == ')' && prevElement != '(')
						return false;
				}
			}
			if (!stack.isEmpty())
				return false;
			return true;

		}
	}

	// https://www.geeksforgeeks.org/find-the-maximum-of-minimums-for-every-window-size-in-a-given-array/
	public static void printMaxOfMinForGivenWindow(int[] input, int windowSize) {

	}

	// //
	// https://stackoverflow.com/questions/21626439/how-to-implement-the-java-comparable-interface
	// static class IndexValue implements Comparable<IndexValue> {
	// public int getIndex() {
	// return index;
	// }
	//
	// public void setIndex(int index) {
	// this.index = index;
	// }
	//
	// public int getValue() {
	// return value;
	// }
	//
	// public void setValue(int value) {
	// this.value = value;
	// }
	//
	// public int getNextGreatest() {
	// return nextGreatest;
	// }
	//
	// public void setNextGreatest(int nextGreatest) {
	// this.nextGreatest = nextGreatest;
	// }
	//
	// int index;
	// int value;
	// int nextGreatest;
	//
	// public IndexValue(int index, int value) {
	// this.index = index;
	// this.value = value;
	// }
	//
	// public int compareTo(IndexValue o) {
	// // TODO Auto-generated method stub
	// return o.getIndex() > this.index ? 1 : -1;
	//
	// }
	// }

	// https://www.geeksforgeeks.org/next-greater-element/
	// https://www.geeksforgeeks.org/find-next-smaller-next-greater-array/
	// [4, 5, 2, 25},
	// working (also we can try using queue for maintaining order)
	public static void printNextGreatestElement(int[] input) {
		Stack<Integer> stack = new Stack<Integer>();

		// creating the comparator on the fly using Java8,
		// compare - compares first object with second object - to have comparision on
		// diff fields as per need
		// compareTo - compare the current object with the specified object - to provide
		// natural ordering for objects

		int length = input.length;
		stack.push(length - 1);
		int[] NGE = new int[length];
		NGE[length - 1] = -1;
		for (int i = length - 2; i >= 0; i--) {
			if (!stack.isEmpty()) {
				while (!stack.isEmpty() && input[stack.peek()] <= input[i]) {
					stack.pop();
				}
				if (stack.isEmpty()) {
					NGE[i] = -1;
				} else {
					NGE[i] = input[stack.peek()];
				}
			} else {
				NGE[i] = -1;
			}
			stack.push(i);
		}

		System.out.println();
		for (int i = 0; i < length; i++) {
			System.out.print(input[i] + " ");
		}
		System.out.println();

		for (int i = 0; i < length; i++) {
			System.out.print(NGE[i] + " ");
		}
		System.out.println();
	}

	// https://www.geeksforgeeks.org/the-stock-span-problem/
	// for each of the given day, span defines the number of consecutive days
	// for which the stock price was less than or equal to the current day
	public static void stockSpanProblem(int[] input) {
		int length = input.length;
		int[] span = new int[length];
		int[] NGE = new int[length];
		NGE[0] = -1;
		Arrays.fill(span, 1);
		int j = -1;
		for (int i = 1; i < length; i++) {
			for (j = i - 1; j >= 0 && input[j] < input[i]; j--)
				span[i]++;
			if (j < 0)
				NGE[i] = -1;
			else
				NGE[i] = input[j];
		}
		for (int i = 0; i < length; i++) {
			System.out.print(span[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < length; i++) {
			System.out.print(NGE[i] + " ");
		}
	}

	// https://www.geeksforgeeks.org/replace-every-element-with-the-greatest-on-right-side/
	public static void replaceElementLargestElementOnRightSide(int[] array) {
		int length = array.length;
		int maxOnRight = array[length - 1];
		array[length - 1] = -1;
		int temp = -1;
		for (int i = length - 2; i >= 0; i--) {
			temp = array[i];
			array[i] = maxOnRight;
			if (temp > maxOnRight)
				maxOnRight = temp;
		}
		System.out.println("Array after replacing with next greatest elements");
		for (int i = 0; i < length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	// https://www.geeksforgeeks.org/postfix-to-infix/
	public static String postfixToInfix(String exp) {
		StringBuilder sb = new StringBuilder();
		char[] array = exp.toCharArray();
		int length = exp.length();
		Stack stack = new Stack();
		for (int index = 0; index < length; index++) {
			String element = String.valueOf(array[index]);
			if ("+".equals(element) || "-".equals(element) || "*".equals(element) || "/".equals(element)
					|| "^".equals(element)) {
				if (stack.isEmpty()) {
					return "Invalid Expression";
				}
				String a = (String) stack.pop();
				if (stack.isEmpty()) {
					return "Invalid Expression";
				}
				String b = (String) stack.pop();
				stack.push(sb.append(b).append(element).append(a).toString());
				sb = new StringBuilder();
			} else {
				stack.push(element);
			}
		}
		if (!stack.isEmpty())
			return (String) stack.pop();
		else
			return null;
	}

	// https://www.geeksforgeeks.org/stack-set-2-infix-to-postfix/
	// working
	public static String infixToPostFix(String exp) {
		Map<Character, Integer> priorityMap = new HashMap();
		priorityMap.put('-', 1);
		priorityMap.put('+', 2);
		priorityMap.put('*', 3);
		priorityMap.put('/', 4);
		priorityMap.put('^', 5);
		Stack<Character> stack = new Stack<Character>();
		char prevElement = ' ';
		StringBuilder result = new StringBuilder();
		char[] array = exp.toCharArray();
		int length = array.length;
		for (int i = 0; i < length; i++) {
			int element = (int) array[i];
			if ((element >= 48 && element <= 57) || (element >= 97 && element <= 122)
					|| (element >= 65 && element <= 90)) {
				result = result.append(array[i]);
			} else {
				if (stack.isEmpty() || array[i] == '(') {
					stack.push(array[i]);
				} else if (array[i] == ')') {
					while (!stack.isEmpty() && (char) stack.peek() != '(') {
						result = result.append(stack.pop());
					}
					if (stack.isEmpty()) {
						return "Expression is invalid";
					} else {
						stack.pop();
					}
				} else {
					prevElement = (char) stack.peek();
					if (prevElement == '(')
						stack.push(array[i]);
					else if (priorityMap.get(array[i]) > priorityMap.get(prevElement)) {
						stack.push(array[i]);
					} else {
						while (prevElement != '(' && priorityMap.get(array[i]) < priorityMap.get(prevElement)) {
							result = result.append(stack.pop());
							if (stack.isEmpty())
								break;
							else
								prevElement = (char) stack.peek();
						}
						stack.push(array[i]);
					}
				}
			}

		}
		while (!stack.isEmpty()) {
			result = result.append(stack.pop());
		}
		return result.toString();
	}

	// https://www.geeksforgeeks.org/prefix-infix-conversion/
	public static String prefixToInfix(String exp) {
		StringBuilder sb = new StringBuilder();
		char[] array = exp.toCharArray();
		int length = exp.length();
		Stack<String> stack = new Stack<String>();
		for (int index = length - 1; index >= 0; index--) {
			String element = String.valueOf(array[index]);
			if ("+".equals(element) || "-".equals(element) || "*".equals(element) || "/".equals(element)
					|| "^".equals(element)) {
				if (stack.isEmpty()) {
					return "Invalid Expression";
				}
				String a = (String) stack.pop();
				if (stack.isEmpty()) {
					return "Invalid Expression";
				}
				String b = (String) stack.pop();
				stack.push(sb.append(a).append(element).append(b).toString());
				sb = new StringBuilder();
			} else {
				stack.push(element);
			}
		}
		if (!stack.isEmpty())
			return (String) stack.pop();
		else
			return null;
	}

	public static String infixToPrefixExpression() {
		return "";
	}

	// yet to check
	// https://www.geeksforgeeks.org/expression-evaluation/
	public static Integer evaluateInfixExpression(String input) {
		Map<String, Integer> priorityMap = new HashMap<String, Integer>();
		priorityMap.put("-", 1);
		priorityMap.put("+", 2);
		priorityMap.put("*", 3);
		priorityMap.put("/", 4);
		priorityMap.put("^", 5);
		Stack<Integer> stack = new Stack<Integer>();
		char[] array = input.toCharArray();
		int length = array.length;
		int a = 0, b = 0;
		for (int i = 0; i < length; i++) {
			char element = array[i];
			if (element >= 48 && element <= 57) {
				stack.push((int) element);
			} else {
				if (stack.size() < 2) {
					// throw error
					return 0;
				}
				a = (int) stack.pop();
				b = (int) stack.pop();
				if ('+' == element) {
					stack.push(a + b);
				} else if ('-' == element) {
					stack.push(b - a);
				} else if ('*' == element) {
					stack.push(b * a);
				} else if ('/' == element) {
					stack.push(b / a);
				} else if ('^' == element) {
					stack.push(b ^ a);
				}

			}
		}
		return (int) stack.pop();
	}

	// https://www.geeksforgeeks.org/check-if-a-given-array-can-represent-preorder-traversal-of-binary-search-tree/
	// not working, refer to the link for the correct solution
	public static boolean checkIfGivenPreOrderCanRepresentBST(int[] a, int l, int u) {
		if (l < u) {
			Boolean isBST = false;

			for (int i = 0; i < u - l - 1; i++) {

				isBST = isBST || (a[l] > a[l + 1] && a[l] < a[l + 1 + i + 1] && a[l + 1 + i] < a[l + i + 2]
						&& checkIfGivenPreOrderCanRepresentBST(a, l + 1, l + 1 + i)
						&& checkIfGivenPreOrderCanRepresentBST(a, l + i + 2, u));
				// even if one BST combination is found we return true
				if (isBST)
					break;
			}
			if (!isBST) {
				isBST = isBST || (a[l] < a[l + 1] && a[l] < a[u] && checkIfGivenPreOrderCanRepresentBST(a, l + 1, u))
						|| (a[l] > a[l + 1] && a[l] > a[u] && checkIfGivenPreOrderCanRepresentBST(a, l + 1, u));
			}

			return isBST;

		} else {
			return true;
		}
	}

	// https://www.geeksforgeeks.org/form-minimum-number-from-given-sequence/
	// yet to go through
	public static String minimumNumberFromGivenSeq(String seq) {
		int n = seq.length();
		if (n >= 9)
			return "-1";
		char result[] = new char[n + 1];
		int count = 1;

		// The loop runs for each input character as well as
		// one additional time for assigning rank to each remaining characters
		for (int i = 0; i <= n; i++) {
			if (i == n || seq.charAt(i) == 'I') {
				for (int j = i - 1; j >= -1; j--) {
					result[j + 1] = (char) ((int) '0' + count++);
					if (j >= 0 && seq.charAt(j) == 'I')
						break;
				}
			}
		}
		return new String(result);
	}

	// https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/
	public static int getMinimumElementFromStack() {
		return 0;
	}

	// https://www.geeksforgeeks.org/the-celebrity-problem/
	public static int celebrityProblem(int[][] input) {
		int length = input[0].length;
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < length; i++) {
			stack.push(i);
		}

		while (stack.size() > 1) {
			int a = stack.pop();
			int b = stack.pop();
			if (input[a][b] == 1) {
				stack.push(b);
			} else {
				stack.push(a);
			}
		}

		int a = stack.pop();
		for (int i = 0; i < length; i++) {
			if (i != a && (input[i][a] == 0 || input[a][i] == 1))
				return -1;
		}
		return a;
	}

	// https://leetcode.com/problems/longest-valid-parentheses/
	public static void longestValidParanthesis() {

	}

	// postfix -> prefix = postfix -> infix + infix -> prefix

	// Things to do
	/**
	 * Implement a stack using two queues Design a stack to get the minimum element
	 * with O(1) time and O(1) extra space
	 * https://www.geeksforgeeks.org/queue-using-stacks/
	 * 
	 * 1. Tower of Hanoi 2. Celebrity problem 3. Infix to Prefix 4. Reverse stack
	 * without extra space and also sorting using two stacks 5. reverse a number
	 * using stack
	 * 
	 * 4. Multiple Stack using single Array
	 */

}
