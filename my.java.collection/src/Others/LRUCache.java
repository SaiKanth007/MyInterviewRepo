package src.Others;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRUCache {

	Integer length;
	MyLinkedList myList;
	Map<Integer, Node> nodeMap;

	public LRUCache(int length) {
		this.length = length;
		nodeMap = new HashMap();
		myList = new MyLinkedList();
	}

	public class Node {
		Node next;
		int data;

		public Node(int data) {
			this.data = data;
		}
	}

	public class MyLinkedList {
		Node head;
		int value;

		public void addNodeToList(int data) {
			Node node = new Node(data);
			if (head == null) {
				this.head = node;
			}
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}

		public void addNodeToStartOfList(int data) {
			Node node = new Node(data);
			if (head == null) {
				this.head = node;
			} else {
				node.next = head;
				this.head = node;
			}
		}

		public void printList() {
			Node temp = this.head;
			while (temp != null) {
				System.out.print(temp.data + " ");
				temp = temp.next;
			}
		}

		public void moveNodeToStartOfList(Node node) {
			Node temp = this.head;
			while (temp.next != node) {
				temp = temp.next;
			}
			temp.next = node.next;
			node.next = this.head;
			this.head = node;
		}

		public Node getLastNode() {
			Node temp = this.head;
			while (temp.next != null) {
				temp = temp.next;
			}
			return temp;
		}

		public void removeLastNode() {
			Node temp = this.head;
			Node prev = this.head;
			while (temp.next != null) {
				prev = temp;
				temp = temp.next;
			}
			if (prev != null) {
				prev.next = null;
			}
		}
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(3);
		cache.add(4);
		cache.add(5);
		cache.add(6);
		cache.myList.printList();
		cache.add(7);
		System.out.println();
		cache.myList.printList();
		cache.add(6);
		System.out.println();
		cache.myList.printList();
	}

	public void add(int input) {
		if (this.nodeMap.containsKey(input)) {
			this.myList.moveNodeToStartOfList(this.nodeMap.get(input));
		} else {
			if (this.nodeMap.size() < length) {
				this.myList.addNodeToStartOfList(input);
				this.nodeMap.put(input, this.myList.head);
			} else {
				this.myList.addNodeToStartOfList((input));
				Node lastNode = this.myList.getLastNode();
				this.nodeMap.remove(lastNode.data);
				this.myList.removeLastNode();
				this.nodeMap.put(input, this.myList.head);
			}
		}
	}
}