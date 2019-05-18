package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import src.Utilities.JavaUtility;

/**
 */
// https://practice.geeksforgeeks.org/explore/?category%5B%5D=Linked+List&problemType=functional&difficulty%5B%5D=1&difficulty%5B%5D=2&page=1
public class MyLinkedList {

	Node head;

	public static class Node {
		Node next;

		Node prev;

		int data;

		Node arb;

		public Node(int pData) {
			this.data = pData;
			next = null;
			prev = null;
		}
	}

	public MyLinkedList(Node pHead) {
		this.head = pHead;
	}

	public void printLL() {
		Node temp = this.head;
		System.out.println("The members of the given linked list are:");
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void printLL(Node head) {
		Node temp = head;
		System.out.println("The members of the given linked list are:");
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();

	}

	public void addNode(int data) {
		if (this.head == null) {
			final Node node = new Node(data);
			this.head = node;
		} else {
			Node temp = this.head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node(data);
		}
	}

	public static void main(String[] args) {

		final MyLinkedList LL = JavaUtility.prepareLinkedListForGivenData("3,4,5,6,7,8,9,10");

		LL.printLL();
		LL.swapNodes(3, 5);
		System.out.println("LL after swapping");
		LL.printLL();
		LL.reverseLL(LL.head);
		LL.printLL();
		LL.reverseLLUsingRecursion(LL.head, null);
		LL.printLL();
		System.out.println("List after rotating is");
		LL.printLL(LL.rotateLinkedList(LL.head, 2));

		final MyLinkedList sumLL1 = JavaUtility.prepareLinkedListForGivenData("8,4,5");
		final MyLinkedList sumLL2 = JavaUtility.prepareLinkedListForGivenData("2,3,9,9,2,5,-1");
		System.out.println("The sum of the two linked list are");
		printLL(addTwoLinkedList(sumLL1.head, sumLL2.head));
		final Node result = mergeSort(sumLL2.head);
		System.out.println("The linked list after merge sort is:");
		printLL(result);

		final MyLinkedList llForDuplicates = JavaUtility.prepareLinkedListForGivenData("4,4,5,8,5,6,8");
		llForDuplicates.removeDuplicatesFromLinkedList();
		System.out.println("Members of linked list after removing duplicates");
		llForDuplicates.printLL();

		final MyLinkedList llForGroupingOddAndEvenNodes = JavaUtility.prepareLinkedListForGivenData("1,2,3,4,5,6");
		llForGroupingOddAndEvenNodes.groupOddAndEvenNodes(llForGroupingOddAndEvenNodes.head);
		System.out.println("Members of linked list after grouping odd and even nodes");
		llForGroupingOddAndEvenNodes.printLL();

		final MyLinkedList orderedllForDuplicates = JavaUtility.prepareLinkedListForGivenData("11,11,11,21,43,43");
		orderedllForDuplicates.removeDuplicatesFromOrderLinkedList();
		orderedllForDuplicates.printLL();

		final MyLinkedList llForRotateInGroups = JavaUtility.prepareLinkedListForGivenData("10,20,30,40,50,60");
		llForRotateInGroups.printLL();
		System.out.println("List after rotating in groups of 2");
		printLL(llForRotateInGroups.reverseLLInGroups(llForRotateInGroups.head, 2));
		llForRotateInGroups.printLL();

		final MyLinkedList llForNthNodeFromEnd = JavaUtility.prepareLinkedListForGivenData("10,20,30,40,50,60,70");
		System.out.println("Nth node from end of the given linked list is: ");
		System.out.println(llForNthNodeFromEnd.findNthNodeFromEnd(llForNthNodeFromEnd.head, 3).data);
		System.out.println("Middle node of the given linked list is: ");
		System.out.println(llForNthNodeFromEnd.findMiddleOfNode(llForNthNodeFromEnd.head).data);
		System.out.println("After merging the two linked lists");
		// printLL(mergeTwoSortedLinkedLists(orderedllForDuplicates.head,
		// llForNthNodeFromEnd.head));

		final MyLinkedList llForNSortedLists = JavaUtility.prepareLinkedListForGivenData("-1,2,15,16,55,87");
		final Node[] nSortedArray = { llForNthNodeFromEnd.head, llForNSortedLists.head, orderedllForDuplicates.head };
		System.out.println("After merging the three sorted linked lists");
		printLL(mergeNSortedLists(nSortedArray, 0, 2));

		final MyLinkedList llForIntersecting = JavaUtility.prepareLinkedListForGivenData("10,20,30,40,50,60");
		final MyLinkedList llForIntersecting2 = JavaUtility.prepareLinkedListForGivenData("80,50,60");
		llForIntersecting2.head.next.next.next = llForIntersecting.head.next.next;
		final Node intersectingNode = findIntersectingNode(llForIntersecting.head, llForIntersecting2.head);
		if (intersectingNode != null) {
			System.out.println("The intersecing node is: " + intersectingNode.data);
		}

		final MyLinkedList llForFindingLoop = JavaUtility.prepareLinkedListForGivenData("10,20,30,40,50,60");
		llForFindingLoop.head.next.next.next.next.next.next = llForFindingLoop.head.next.next;
		System.out.println("There is a loop present in the LL : " + checkLoopInLL(llForFindingLoop.head));
		Node loopNode = findLoopNode(llForFindingLoop.head);
		if (loopNode != null) {
			System.out.println("The loop node is:" + loopNode.data);
		} else {
			System.out.println("There is no loop node persent");
		}

		final MyLinkedList findFractionOfLinkedList = JavaUtility.prepareLinkedListForGivenData("2,7,9,3,5");
		System.out.println(
				"n/kth node of the given list is: " + findFractionOfLinkedList(findFractionOfLinkedList.head, 3).data);

		final MyLinkedList cloneLLWithNextAndArbitaryPointer = JavaUtility.prepareLinkedListForGivenData("1,2,3,4,5");
		Node root = cloneLLWithNextAndArbitaryPointer.head;
		root.arb = root.next.next;
		root.next.arb = root;
		root.next.next.arb = root.next.next.next.next;
		cloneLLWithNextAndArbitaryPointer(root);

		final MyLinkedList palindromeLL = JavaUtility.prepareLinkedListForGivenData("1,2,2,1");
		palindromeLL.isLLAPalindrome(palindromeLL.head);
	}

	public Node reverseLL(Node pRoot) {
		if (pRoot == null || pRoot.next == null) {
			return pRoot;
		}
		Node current = pRoot;
		Node prev = null;
		Node temp = null;
		while (current.next != null) {
			temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}
		current.next = prev;
		this.head = current;
		return current;
	}

	public Node reverseLLUsingRecursion(Node pRoot, Node prev) {
		if (pRoot == null) {
			this.head = prev;
			return pRoot;
		}
		final Node next = pRoot.next;
		pRoot.next = prev;
		return reverseLLUsingRecursion(next, pRoot);
	}

	public Node reverseLLInGroups(Node head, int groupSize) {
		final Node start = head;
		if (start == null || start.next == null) {
			return start;
		}
		Node current = start;
		Node prev = null;
		Node temp = null;
		int count = 0;
		while (current != null && count < groupSize) {
			temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
			count++;
		}
		start.next = reverseLLInGroups(current, groupSize);
		this.head = prev;
		return prev;
	}

	// not working for adjacent nodes
	public void swapNodes(int firstData, int secondData) {
		Node firstPrev = null;
		Node secondPrev = null;
		Node firstNode = null;
		Node secondNode = null;
		Node temp = this.head;
		while (temp.next != null) {
			if (temp.data == firstData) {
				firstNode = temp;
				break;
			}
			firstPrev = temp;
			temp = temp.next;
		}
		temp = this.head;
		while (temp.next != null) {
			if (temp.data == secondData) {
				secondNode = temp;
				break;
			}
			secondPrev = temp;
			temp = temp.next;
		}
		if (secondNode == null || firstNode == null) {
			return;
		}

		if (firstPrev != null)
			firstPrev.next = secondNode;
		else // make y the new head
			head = secondNode;

		// If y is not head of linked list
		if (secondPrev != null)
			secondPrev.next = firstNode;
		else // make x the new head
			head = firstNode;

		// Swap next pointers
		temp = firstNode.next;
		firstNode.next = secondNode.next;
		secondNode.next = temp;
	}

	// working
	public static Node addTwoLinkedList(Node pFirstLL, Node pSecondLL) {
		Node firstLL = pFirstLL;
		Node secondLL = pSecondLL;
		if (firstLL == null) {
			return secondLL;
		} else if (secondLL == null) {
			return firstLL;
		} else {
			int sum = 0;
			int carry = 0;
			int localSum = 0;
			Node result = null;
			Node head = null;
			while (firstLL != null || secondLL != null) {
				localSum = 0;
				if (firstLL != null) {
					localSum = localSum + firstLL.data;
					firstLL = firstLL.next;
				}
				if (secondLL != null) {
					localSum = localSum + secondLL.data;
					secondLL = secondLL.next;
				}
				localSum = localSum + carry;
				sum = localSum % 10;
				carry = localSum / 10;
				if (result == null) {
					result = new Node(sum);
					head = result;
				} else {
					result.next = new Node(sum);
					result = result.next;
				}
			}
			if (carry != 0) {
				result.next = new Node(carry);
			}
			return head;
		}
	}

	public Node rotateLinkedList(Node head, int m) {
		if (head == null || head.next == null) {
			return head;
		}
		Node root = head;
		int counter = 0;
		Node prev = head;
		while (root != null && counter != m) {
			prev = root;
			root = root.next;
			counter++;
		}
		prev.next = null;
		this.head = root;
		while (root != null && root.next != null) {
			root = root.next;
		}
		root.next = head;
		return this.head;
	}

	// yet to do
	// https://www.geeksforgeeks.org/rotate-linked-list-block-wise/
	public Node rotateLinkedListInBlocks(Node head, int blockSize, int noOfRotations) {
		if (head == null || head.next == null) {
			return head;
		}
		Node root = head;
		int counter = 0;
		Node prev = head;
		while (root.next != null && counter != noOfRotations) {
			prev = root;
			root = root.next;
			counter++;
		}
		prev.next = null;
		this.head = root;
		while (root.next != null) {
			root = root.next;
		}
		root.next = head;
		return this.head;
	}

	// https://www.geeksforgeeks.org/remove-duplicates-from-a-sorted-linked-list/
	public void removeDuplicatesFromLinkedList() {
		Node start = this.head;
		Node prev = null;
		final Map<Integer, Node> llMap = new HashMap();
		while (start != null) {
			if (llMap.get(start.data) == null) {
				llMap.put(start.data, start);
				prev = start;
			} else {
				prev.next = start.next;
			}
			start = start.next;
		}
	}

	public void removeDuplicatesFromOrderLinkedList() {
		final Node start = this.head;
		if (start == null || start.next == null) {
			return;
		}
		Node prev = start;
		Node current = start.next;
		while (current != null) {
			if (current.data == prev.data) {
				prev.next = current.next;
			} else {
				prev = current;
			}
			current = current.next;
		}
	}

	// for even nodes, it returns first of the two middle nodes
	public Node findMiddleOfNode(Node head) {
		Node slow = this.head;
		if (slow == null || slow.next == null) {
			return slow;
		}
		Node fast = slow.next;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	public Node findNthNodeFromEnd(Node head, int n) {
		Node start = head;
		if (start == null || start.next == null) {
			return start;
		}
		int count = 0;
		while (start != null && count < n) {
			start = start.next;
			count++;
		}
		if (start == null) {
			return null;
		}
		Node temp = head;
		while (start != null) {
			start = start.next;
			temp = temp.next;
		}
		return temp;
	}

	// https://www.geeksforgeeks.org/length-longest-palindrome-list-linked-list-using-o1-extra-space/
	// v.v.vimp
	public int findLargestPolindrome(Node head) {
		final Node start = this.head;
		if (start == null || start.next == null) {
			return 1;
		}
		return 0;
	}

	// working
	public static Node mergeNSortedLists(Node[] heads, int lowerIndex, int upperIndex) {
		// remember this, it is very important
		if (lowerIndex == upperIndex) {
			return heads[lowerIndex];
		} else if (lowerIndex < upperIndex) {
			final int mid = (upperIndex + lowerIndex) / 2;
			final Node head1 = mergeNSortedLists(heads, lowerIndex, mid);
			final Node head2 = mergeNSortedLists(heads, mid + 1, upperIndex);
			return mergeTwoSortedLinkedLists(head1, head2);
		}
		return null;
	}

	// working
	public static Node mergeTwoSortedLinkedLists(Node head1, Node head2) {

		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		Node temp1 = head1;
		Node temp2 = head2;
		Node temp = null;
		if (temp1.data < temp2.data) {
			temp = temp1;
			temp1 = temp.next;
		} else {
			temp = temp2;
			temp2 = temp2.next;
		}
		final Node result = temp;
		while (temp1 != null && temp2 != null) {
			if (temp1.data < temp2.data) {
				temp.next = temp1;
				temp1 = temp1.next;
			} else {
				temp.next = temp2;
				temp2 = temp2.next;
			}
			temp = temp.next;
		}
		if (temp1 == null) {
			temp.next = temp2;
		} else {
			temp.next = temp1;
		}
		return result;
	}

	// working
	// other approach would be finding the difference between the lengths of the two
	// linked list and then starting from the lists accordingly
	public static Node findIntersectingNode(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node temp1 = head1;
		Node temp2 = head2;
		final List<Node> list = new ArrayList();
		while (temp1 != null) {
			list.add(temp1);
			temp1 = temp1.next;
		}
		while (temp2 != null) {
			if (list.contains(temp2)) {
				return temp2;
			}
			temp2 = temp2.next;
		}
		return null;
	}

	public static boolean checkLoopInLL(Node head) {
		if (head == null || head.next == null) {
			return false;
		}
		Node temp1 = head;
		Node temp2 = head.next;
		while (temp1 != null && temp2 != null && temp2.next != null) {
			if (temp1 == temp2) {
				return true;
			}
			temp1 = temp1.next;
			temp2 = temp2.next.next;
		}
		return false;
	}

	// also check for the proof
	public static Node findLoopNode(Node head) {
		if (head == null || head.next == null) {
			return null;
		}
		Node temp1 = head;
		Node temp2 = head.next;
		Node loopNode = null;
		while (temp1 != null && temp2 != null && temp2.next != null) {
			if (temp1 == temp2) {
				loopNode = temp1;
				break;
			}
			temp1 = temp1.next;
			temp2 = temp2.next.next;
		}
		if (loopNode != null) {
			temp1 = head;
			while (true) {
				temp2 = loopNode.next;
				while (temp2 != temp1 && temp2 != loopNode) {
					temp2 = temp2.next;
				}
				if (temp2 == temp1)
					return temp1;
				temp1 = temp1.next;
			}
		} else {
			return null;
		}

	}

	public static Node mergeSort(Node head) {
		if (head != null) {
			if (head.next == null) {
				return head;
			}
			Node first = head;
			Node second = head.next;
			while (first != null && second != null && second.next != null) {
				first = first.next;
				second = second.next.next;
			}
			final Node middleNext = first.next;
			first.next = null;
			final Node firstResult = mergeSort(head);
			final Node secondResult = mergeSort(middleNext);
			return mergeTwoSortedLinkedLists(firstResult, secondResult);
		}
		return null;
	}

	// working
	// https://www.geeksforgeeks.org/rearrange-a-linked-list-such-that-all-even-and-odd-positioned-nodes-are-together/
	public static Node groupOddAndEvenNodes(Node head) {
		if (head == null || head.next == null)
			return head;
		Node first = head;
		Node second = head.next;
		Node temp = first;
		Node temp2 = second;
		while (first != null && second != null && first.next != null && second.next != null) {
			first.next = first.next.next;
			second.next = second.next.next;
			first = first.next;
			second = second.next;
		}
		first.next = temp2;
		return temp;
	}

	// https://www.geeksforgeeks.org/find-fractional-nk-th-node-linked-list/
	// working (n/k)th node
	public static Node findFractionOfLinkedList(Node head, int k) {
		if (k <= 0 || head == null)
			return null;
		Node slow = head;
		Node fast = head;
		int count = 0;
		while (slow != null && fast != null) {
			count = 0;
			while (fast != null && count != k) {
				fast = fast.next;
				count++;
			}
			if (fast == null) {
				break;
			}
			slow = slow.next;
		}
		return slow;
	}

	// https://www.geeksforgeeks.org/sorted-linked-list-to-balanced-bst/
	// v.v.vimp
	// one approach would be find middle node make it as root and Recursively do
	// same for left half and right half
	public static void LLToBST(Node head) {
	}

	// https://www.geeksforgeeks.org/a-linked-list-with-next-and-arbit-pointer/
	// working fine
	public static Node cloneLLWithNextAndArbitaryPointer(Node root) {
		if (root == null)
			return null;
		else {
			Node head = root;

			while (root != null) {
				Node temp = root.next;
				root.next = new Node(root.data);
				root.next.next = temp;
				root = temp;
			}
			root = head;
			Node newHead = head.next;
			Node newRoot = newHead;
			while (root != null) {
				if (root.arb != null)
					root.next.arb = root.arb.next;
				root = root.next.next;
			}
			root = head;

			while (root != null) {
				root.next = root.next.next;
				if (newRoot.next != null)
					newRoot.next = newRoot.next.next;
				root = root.next;
				newRoot = newRoot.next;

			}
			return newHead;

		}
	}

	// try to do it in O(n) space
	// https://leetcode.com/problems/palindrome-linked-list/
	public boolean isLLAPalindrome(Node head) {
		if (head == null || head.next == null)
			return true;
		Node first = head;
		Node second = head.next;
		while (first != null && second != null && second.next != null) {
			first = first.next;
			second = second.next.next;
		}
		Node middle = first;
		Node nextStart = first.next;
		first.next = reverseLL(nextStart);
		first = head;
		second = middle.next;
		while (first != null && second != null && first.data == second.data) {
			first = first.next;
			second = second.next;
		}
		if (second != null)
			return false;
		return true;
	}

	public void insertionSort(Node head) {

	}

}
