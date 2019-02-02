import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 */
// https://practice.geeksforgeeks.org/explore/?category%5B%5D=Linked+List&problemType=functional&difficulty%5B%5D=1&difficulty%5B%5D=2&page=1
public class MyLinkedList {

    Node head;

    public static class Node {
        Node next;

        Node prev;

        int data;

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

        final MyLinkedList LL = new MyLinkedList(new Node(3));
        LL.addNode(4);
        LL.addNode(5);
        LL.addNode(6);
        LL.addNode(7);
        LL.addNode(8);
        LL.addNode(9);
        LL.addNode(10);

        LL.printLL();
        // LL.swapNodes(3, 5);
        LL.reverseLL(LL.head);
        LL.printLL();
        LL.reverseLLUsingRecursion(LL.head, null);
        LL.printLL();
        System.out.println("List after rotating is");
        LL.printLL(LL.rotateLinkedList(LL.head, 2));

        final MyLinkedList sumLL1 = new MyLinkedList(new Node(8));
        sumLL1.addNode(4);
        sumLL1.addNode(5);
        final MyLinkedList sumLL2 = new MyLinkedList(new Node(2));
        sumLL2.addNode(4);
        sumLL2.addNode(9);
        sumLL2.addNode(9);
        sumLL2.addNode(2);
        sumLL2.addNode(5);
        sumLL2.addNode(-1);
        System.out.println("The sum of the two linked list are");
        printLL(addTwoLinkedList(sumLL1.head, sumLL2.head));
        final Node result = mergeSort(sumLL2.head);
        System.out.println("The linked list after merge sort is:");
        printLL(result);

        final MyLinkedList llForDuplicates = new MyLinkedList(new Node(4));
        llForDuplicates.addNode(4);
        llForDuplicates.addNode(5);
        llForDuplicates.addNode(8);
        llForDuplicates.addNode(6);
        llForDuplicates.removeDuplicatesFromLinkedList();
        llForDuplicates.printLL();

        final MyLinkedList orderedllForDuplicates = new MyLinkedList(new Node(11));
        orderedllForDuplicates.addNode(11);
        orderedllForDuplicates.addNode(11);
        orderedllForDuplicates.addNode(21);
        orderedllForDuplicates.addNode(43);
        orderedllForDuplicates.addNode(43);
        orderedllForDuplicates.removeDuplicatesFromOrderLinkedList();
        orderedllForDuplicates.printLL();

        final MyLinkedList llForRotateInGroups = new MyLinkedList(new Node(10));
        llForRotateInGroups.addNode(20);
        llForRotateInGroups.addNode(30);
        llForRotateInGroups.addNode(40);
        llForRotateInGroups.addNode(50);
        llForRotateInGroups.addNode(60);
        llForRotateInGroups.printLL();
        System.out.println("List after rotating in groups of 2");
        printLL(llForRotateInGroups.reverseLLInGroups(llForRotateInGroups.head, 2));

        final MyLinkedList llForNthNodeFromEnd = new MyLinkedList(new Node(10));
        llForNthNodeFromEnd.addNode(20);
        llForNthNodeFromEnd.addNode(30);
        llForNthNodeFromEnd.addNode(40);
        llForNthNodeFromEnd.addNode(50);
        llForNthNodeFromEnd.addNode(60);
        System.out.println(llForNthNodeFromEnd.findNthNodeFromEnd(llForNthNodeFromEnd.head, 3).data);
        System.out.println(llForNthNodeFromEnd.findMiddleOfNode(llForNthNodeFromEnd.head).data);
        System.out.println("After merging the two linked lists");
        // printLL(mergeTwoSortedLinkedLists(orderedllForDuplicates.head, llForNthNodeFromEnd.head));

        final MyLinkedList llForNSortedLists = new MyLinkedList(new Node(-1));
        llForNSortedLists.addNode(2);
        llForNSortedLists.addNode(15);
        llForNSortedLists.addNode(16);
        llForNSortedLists.addNode(55);
        llForNSortedLists.addNode(87);

        final Node[] nSortedArray = {llForNthNodeFromEnd.head, llForNSortedLists.head, orderedllForDuplicates.head};
        System.out.println("After merging the three sorted linked lists");
        printLL(mergeNSortedLists(nSortedArray, 0, 2));

        final MyLinkedList llForIntersecting = new MyLinkedList(new Node(10));
        llForIntersecting.addNode(20);
        llForIntersecting.addNode(30);
        llForIntersecting.addNode(40);
        llForIntersecting.addNode(50);
        llForIntersecting.addNode(60);
        final MyLinkedList llForIntersecting2 = new MyLinkedList(new Node(80));
        llForIntersecting2.addNode(50);
        llForIntersecting2.addNode(60);
        llForIntersecting2.head.next.next.next = llForIntersecting.head.next.next;
        final Node intersectingNode = findIntersectingNode(llForIntersecting.head, llForIntersecting2.head);
        if (intersectingNode != null) {
            System.out.println("The intersecing node is: " + intersectingNode.data);
        }

        final MyLinkedList llForFindingLoop = new MyLinkedList(new Node(10));
        llForFindingLoop.addNode(20);
        llForFindingLoop.addNode(30);
        llForFindingLoop.addNode(40);
        llForFindingLoop.addNode(50);
        llForFindingLoop.addNode(60);
        llForFindingLoop.head.next.next.next.next.next.next = llForFindingLoop.head.next.next;
        System.out.println("There is a loop present in the LL : " + checkLoopInLL(llForFindingLoop.head));
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

        temp = firstNode.next;
        firstNode.next = secondNode.next;
        secondNode.next = temp;
        secondNode.next = firstNode;
        if (firstPrev != null) {
            firstPrev.next = secondNode;
        }
        secondPrev.next = firstNode;

        // remember this point strongly
        if (firstPrev == null) {
            this.head = secondNode;
        }

    }

    public void sortLL() {

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
        while (root.next != null && counter != m) {
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

    // not working yet
    // https://www.geeksforgeeks.org/remove-duplicates-from-an-unsorted-linked-list/
    public Node rotateLinkedListInGroups(Node head, int m) {
        if (head == null || head.next == null) {
            return head;
        }
        Node root = head;
        int counter = 0;
        Node prev = head;
        while (root.next != null && counter != m) {
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
        final Map<Integer, Node> llMap = new LinkedHashMap<>();
        while (start != null) {
            if (llMap.get(start.data) == null) {
                llMap.put(start.data, start);
            }
            start = start.next;
        }

        for (final Map.Entry<Integer, Node> entry : llMap.entrySet()) {
            if (start == null) {
                start = entry.getValue();
                this.head = start;
            } else {
                start.next = entry.getValue();
                start = start.next;
            }
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

    public Node findMiddleOfNode(Node head) {
        Node start = this.head;
        if (start == null || start.next == null) {
            return start;
        }
        Node temp = this.head;
        while (start != null && start.next != null) {
            start = start.next.next;
            temp = temp.next;
        }
        return temp;
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
        }

        else if (lowerIndex < upperIndex) {

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
    public static Node findIntersectingNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node temp1 = head1;
        Node temp2 = head2;
        final List<Node> list = new ArrayList<>();
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
            final Node middle = first;
            final Node middleNext = middle.next;
            middle.next = null;
            final Node firstResult = mergeSort(head);
            final Node secondResult = mergeSort(middleNext);
            return mergeTwoSortedLinkedLists(firstResult, secondResult);
        }
        return null;
    }

    // not working
    public static Node groupOddAndEvenNodes(Node head) {
        if (head != null) {
            Node first = head;
            Node second = head.next;
            while (first != null && second != null && first.next != null && second.next != null) {
                first.next = first.next.next;
                second.next = second.next.next;
                first = first.next;
                second = second.next;
            }
        }
        return null;
    }

    public static void LLToBST(Node head) {}

    // merge n sorted linked lists

}
