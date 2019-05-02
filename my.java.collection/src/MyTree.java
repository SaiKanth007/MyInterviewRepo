package src;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

//https://stackoverflow.com/questions/9560600/java-no-enclosing-instance-of-type-foo-is-accessible
public class MyTree {

	Node root;
	Node head;

	public static class Node {
		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		Node left;
		Node right;
		int data;
		Node next;

		Node(int pData) {
			data = pData;
		}

		Node(Node node) {
			this.data = node.data;
			this.left = node.left;
			this.right = node.right;
		}
	}

	Node prev = null;

	// made static since all methods are static
	static class Storage {
		int value = 0;
	}

	public static void main(String[] args) {

		MyTree tree1 = new MyTree();
		tree1.root = new Node(5);
		tree1.root.left = new Node(6);
		tree1.root.left.right = new Node(8);
		tree1.root.left.right.left = new Node(9);
		tree1.root.left.right.right = new Node(2);
		tree1.root.left.right.left.right = new Node(10);
		tree1.root.left.right.left.right.right = new Node(11);
		tree1.root.right = new Node(7);
		tree1.root.right.right = new Node(3);
		tree1.root.right.left = new Node(1);
		tree1.root.right.left.right = new Node(4);

		// traversals
		System.out.println("in order traversal with recursion");
		inorderTraversal(tree1.root);
		System.out.println("in order traversal without recursion");
		inorderTraversalWithoutRecursion(tree1.root);
		System.out.println("In order travesal morris traversal");
		inorderTraversalWithoutRecursionWithoutStack(tree1.root);
		System.out.println("In order travesal with parent");
		printEveryNodeAlongWithItsParent(tree1.root, null);
		System.out.println("Pre order Morris Traversal");
		preorderTraversalWithoutRecursionWithoutStack(tree1.root);
		System.out.println("Pre order travesal");
		preorderTraversal(tree1.root);
		System.out.println();
		preorderTraversalWithoutRecursion(tree1.root);
		System.out.println("Post order travesal");
		postorderTraversal(tree1.root);
		System.out.println("Post order travesal with recursion");
		postorderTraversalWithoutRecursion(tree1.root);
		System.out.println("Level Order with recursion");
		levelOrder(tree1.root, false, true, false);
		System.out.println("Level order without recursion");
		levelOrderWithoutRecursion(tree1.root);

		printDiagonalTraversalOfTree(tree1.root);

		System.out.println("The depth wise traversal of the tree is:");
		printTreeDepthWise(tree1.root);

		// views
		int depthCoveredTillNow = -1;
		int currentDepth = 0;

		System.out.println("The right view of the Tree is: ");
		printRightViewOfTheTree(tree1.root, currentDepth, depthCoveredTillNow);

		depthCoveredTillNow = -1;
		currentDepth = 0;
		System.out.println("The left view of the Tree is: ");
		printLeftViewOfTheTree(tree1.root, currentDepth, depthCoveredTillNow);

		System.out.println();
		printTopViewOfTheTree(tree1.root);

		System.out.println();
		printBottomViewOfTheTree(tree1.root);

		System.out.println("The perimeter of the tree is:");
		printPerimeterOfTheTree(tree1.root);

		System.out.println("Distance Between Two Nodes is : " + findDistanceBetweenTwoNode(tree1.root,
				tree1.root.left.right.left.right, tree1.root.left.right.right));

		// distance
		System.out.println("The Height of the tree is: " + printHeightOfTree(tree1.root));
		System.out.println();

		System.out.println("The ancestors of the the given node are: ");
		printAncestorsOfNode(tree1.root, tree1.root.left.right.left.right);
		System.out.println("The ancestors of the the given node without recursion are: ");
		printAncestorsOfNodeWithoutRecursion(tree1.root, tree1.root.left.right.left.right);
		System.out.println();

		System.out.println("The first common ancestor for the the given nodes is: ");
		Node lca = printFirstCommonAncestorOfNodes(tree1.root, tree1.root.left.right.left.right,
				tree1.root.left.right.right);
		if (lca != null)
			System.out.println(lca.data);
		System.out.println();

		System.out.println("The Diameter of the given tree is: ");
		System.out.println(printDiameterOfTree(tree1.root));
		System.out.println(printDiameterOfTreeOptimized(tree1.root, new HeightWrapper()));

		// check
		System.out.println("Trees are identical " + checkIfTreesAreIndentical(tree1.root, tree1.root));
		System.out.println("Trees are identical " + checkIfTreesAreMirrorImages(tree1.root, tree1.root));

		System.out.println("Sum of all nodes in a tree are:" + findSumOfAllNodes(tree1.root));
		Storage sum = new Storage();
		findSumAlongLongestPathFromRoot(tree1.root, sum);
		System.out.println("Sum of all nodes along longest path in a tree are:" + sum.value);

		List<Node> nodes = new ArrayList();
		printPathToNode(tree1.root, tree1.root.left.right.right, nodes);
		System.out.println("The path from the root to the given node is:");
		nodes.stream().map(Node::getData).forEach(System.out::println);

		System.out.println("Nodes present at a given disntace from the given node are:");
		printNodesAtGivenDistanceFromAGivenNode(tree1.root, tree1.root.left.right, 3);

		System.out.println("Triplet found for the given sum in the tree");
		findTriplet(tree1.root, null, 16);

		MyTree bst = new MyTree();
		bst.root = new Node(5);
		bst.root.left = new Node(1);
		bst.root.right = new Node(4);
		bst.root.right.left = new Node(3);
		bst.root.right.right = new Node(6);
		bst.prev = null;
		System.out.println("Given tree is a BST: " + bst.checkIfGivenTreeIsBST(bst.root));

		bst.prev = null;
		bst.convertTreeToLinkedList(bst.root);
		System.out.println("Sai");

		int[] findAllPossibleBinaryTreesFromInorder = { 4, 5, 7 };
		System.out.println("The number of possible trees are: " + findAllPossibleBinaryTreesFromInorder(
				findAllPossibleBinaryTreesFromInorder, 0, findAllPossibleBinaryTreesFromInorder.length - 1));

		int[] inorderArray = { 4, 3, 1, 8, 2, 6, 9, 5, 7 };
		int[] preOrderArray = { 2, 3, 4, 8, 1, 5, 6, 9, 7 };
		Node result = getTreeFromPreorderAndInOrder(preOrderArray, inorderArray, 0, preOrderArray.length - 1, 0,
				inorderArray.length - 1);
		postorderTraversal(result);

		System.out.println();
		int[] postOrderArray = { 4, 1, 8, 3, 9, 6, 7, 5, 2 };
		Node result2 = getTreeFromPostorderAndInOrder(postOrderArray, inorderArray, 0, postOrderArray.length - 1, 0,
				inorderArray.length - 1);
		postorderTraversal(result2);
	}

	public static void inorderTraversal(Node root) {
		if (root != null) {
			inorderTraversal(root.left);
			System.out.print(root.data + " ");
			inorderTraversal(root.right);
		}
	}

	public static void inorderTraversalWithoutRecursion(Node root) {
		if (root != null) {
			Stack<Node> stack = new Stack<Node>();
			while (root.left != null) {
				stack.push(root);
				root = root.left;
			}
			stack.push(root);
			while (!stack.isEmpty()) {
				Node temp = stack.pop();
				System.out.print(temp.data + " ");
				root = temp.right;
				while (root != null) {
					stack.push(root);
					root = root.left;
				}
			}
		}
	}

	// Morris traversal
	// application - https://www.geeksforgeeks.org/find-median-bst-time-o1-space/
	public static void inorderTraversalWithoutRecursionWithoutStack(Node root) {
		Node node = new Node(root);
		while (node != null) {
			if (node.left == null) {
				System.out.print(node.data + " ");
				node = node.right;
			} else {
				Node current = node.left;
				while (current.right != null && current.right != node) {
					current = current.right;
				}
				if (current.right == node) {
					System.out.print(node.data + " ");
					current.right = null;
					node = node.right;
				} else {
					current.right = node;
					node = node.left;
				}
			}
		}
	}

	// Morris traversal
	// https://www.geeksforgeeks.org/morris-traversal-for-preorder/
	public static void preorderTraversalWithoutRecursionWithoutStack(Node root) {
		Node node = new Node(root);
		while (node != null) {
			if (node.left == null) {
				System.out.print(node.data + " ");
				node = node.right;
			} else {
				Node current = node.left;
				while (current.right != null && current.right != node) {
					current = current.right;
				}
				if (current.right == node) {
					current.right = null;
					node = node.right;
				} else {
					current.right = node;
					System.out.print(node.data + " ");
					node = node.left;
				}
			}
		}
	}

	public static void preorderTraversal(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preorderTraversal(root.left);
			preorderTraversal(root.right);
		}
	}

	public static void preorderTraversalWithoutRecursion(Node root) {
		if (root != null) {
			Stack<Node> stack = new Stack<Node>();
			stack.push(root);
			while (!stack.isEmpty()) {
				Node preorderNode = stack.pop();
				System.out.print(preorderNode.data + " ");
				if (preorderNode.right != null)
					stack.push(preorderNode.right);
				if (preorderNode.left != null)
					stack.push(preorderNode.left);
			}
		}
	}

	public static void postorderTraversal(Node root) {
		if (root != null) {
			postorderTraversal(root.left);
			postorderTraversal(root.right);
			System.out.print(root.data + " ");

		}
	}

	public static void postorderTraversalWithoutRecursion(Node root) {
		if (root != null) {
			Stack<Node> stack = new Stack<Node>();
			Stack<Node> resultStack = new Stack<Node>();
			stack.push(root);
			while (!stack.isEmpty()) {
				Node postorderNode = stack.pop();
				resultStack.push(postorderNode);
				if (postorderNode.left != null)
					stack.push(postorderNode.left);
				if (postorderNode.right != null)
					stack.push(postorderNode.right);
			}
			while (!resultStack.isEmpty()) {
				System.out.print(resultStack.pop().data + " ");
			}
		}
	}

	// working for level order from top or bottom, left or right, spiral or
	// non-spiral
	// now think of linking nodes at the same level
	public static void levelOrder(Node root, boolean leftToRight, boolean isSpiral, boolean topToBottom) {
		if (root != null) {
			int height = printHeightOfTree(root);
			if (topToBottom) {
				for (int i = 0; i < height; i++) {
					levelOrder(root, i, leftToRight);
					leftToRight = isSpiral ? !leftToRight : leftToRight;
				}
			} else {
				for (int i = height - 1; i >= 0; i--) {
					levelOrder(root, i, leftToRight);
					leftToRight = isSpiral ? !leftToRight : leftToRight;
				}
			}
		}
	}

	public static void levelOrder(Node root, int height, boolean leftToRight) {
		// this null check is mandatory
		if (root != null) {
			if (height == 0)
				System.out.print(root.data + " ");
			else {
				if (leftToRight) {
					levelOrder(root.left, height - 1, leftToRight);
					levelOrder(root.right, height - 1, leftToRight);
				} else {
					levelOrder(root.right, height - 1, leftToRight);
					levelOrder(root.left, height - 1, leftToRight);
				}

			}
		}
	}

	public static void levelOrderWithoutRecursion(Node root) {
		if (root != null) {
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);
			while (!queue.isEmpty()) {
				Node levelorderNode = queue.poll();
				System.out.print(levelorderNode.data + " ");
				if (levelorderNode.left != null)
					queue.add(levelorderNode.left);
				if (levelorderNode.right != null)
					queue.add(levelorderNode.right);
			}

		}
	}

	// https://www.geeksforgeeks.org/diagonal-traversal-of-binary-tree/
	// working
	// check for iterative traversal -
	// https://www.geeksforgeeks.org/iterative-diagonal-traversal-binary-tree/
	public static void printDiagonalTraversalOfTree(Node root) {
		Map<Integer, LinkedList<Node>> map = new HashMap();
		printDiagonalTraversalOfTreeUtil(root, map, 0);
		System.out.println("Diagonal View of the tree is");
		for (Map.Entry<Integer, LinkedList<Node>> entry : map.entrySet()) {
			for (Node node : entry.getValue()) {
				System.out.print(node.data + " ");
			}
			System.out.println();
		}
	}

	public static void printDiagonalTraversalOfTreeUtil(Node root, Map<Integer, LinkedList<Node>> map,
			int diagonalDistance) {
		if (root == null)
			return;
		LinkedList<Node> list = map.get(diagonalDistance);
		if (list == null) {
			list = new LinkedList<Node>();
		}
		list.add(root);
		map.put(diagonalDistance, list);
		printDiagonalTraversalOfTreeUtil(root.left, map, diagonalDistance + 1);
		printDiagonalTraversalOfTreeUtil(root.right, map, diagonalDistance);
	}

	public static int printRightViewOfTheTree(Node root, int currentDepth, int depthCoveredTillNow) {
		if (root != null) {
			if (currentDepth > depthCoveredTillNow) {
				System.out.print(root.data + " ");
				depthCoveredTillNow = depthCoveredTillNow + 1;
			}
			depthCoveredTillNow = printRightViewOfTheTree(root.right, currentDepth + 1, depthCoveredTillNow);
			return printRightViewOfTheTree(root.left, currentDepth + 1, depthCoveredTillNow);
		}
		return depthCoveredTillNow;

	}

	public static int printLeftViewOfTheTree(Node root, int currentDepth, int depthCoveredTillNow) {
		if (root != null) {
			if (currentDepth > depthCoveredTillNow) {
				System.out.print(root.data + " ");
				depthCoveredTillNow = depthCoveredTillNow + 1;
			}
			depthCoveredTillNow = printLeftViewOfTheTree(root.left, currentDepth + 1, depthCoveredTillNow);
			return printLeftViewOfTheTree(root.right, currentDepth + 1, depthCoveredTillNow);
		}
		return depthCoveredTillNow;

	}

	public static void printTopViewOfTheTree(Node root) {
		if (root != null) {
			Map<Integer, Node> nodeDepthMap = new HashMap<Integer, Node>();
			Queue<Node> queue = new LinkedList<Node>();
			Queue<Integer> width = new LinkedList<Integer>();
			int currentWidth = -1;
			queue.add(root);
			width.add(0);
			while (!queue.isEmpty()) {
				Node node = queue.poll();
				currentWidth = width.poll();
				if (!nodeDepthMap.containsKey(currentWidth)) {
					nodeDepthMap.put(currentWidth, node);
				}
				if (node.left != null) {
					queue.add(node.left);
					width.add(currentWidth - 1);
				}
				if (node.right != null) {
					queue.add(node.right);
					width.add(currentWidth + 1);
				}
			}
			Set<Integer> widths = nodeDepthMap.keySet().stream().sorted().collect(Collectors.toSet());
			System.out.println("The top view of the tree is:");
			for (Integer nodeWidth : widths) {
				System.out.print(nodeDepthMap.get(nodeWidth).data + " ");
			}

		}
	}

	// https://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/
	public static void printVerticalViewOfTheTree(Node root) {
		if (root != null) {
		}

	}

	// working
	public static void printBottomViewOfTheTree(Node root) {
		if (root != null) {
			int height = printHeightOfTree(root);
			Map<Integer, LinkedList<Node>> nodeDepthMap = new LinkedHashMap<>();
			Map<Integer, Integer> utilityMap = new HashMap();
			for (int i = height; i > 0; i--) {
				printBottomViewOfTheTreeUtility(root, i, i, nodeDepthMap, utilityMap, 0);
			}
			System.out.println("The bottom view of the tree is:");
			Set<Integer> sortedKeySet = nodeDepthMap.keySet().stream().sorted().collect(Collectors.toSet());
			for (Integer depth : sortedKeySet) {
				nodeDepthMap.get(depth).stream().forEach(node -> System.out.print(node.data + " "));
			}
		}
	}

	public static void printBottomViewOfTheTreeUtility(Node root, int height, int actualHeight,
			Map<Integer, LinkedList<Node>> nodeDepthMap, Map<Integer, Integer> utilityMap, int width) {
		if (root != null) {
			if (height == 1) {
				if (!utilityMap.containsKey(width)) {
					utilityMap.put(width, actualHeight);
					nodeDepthMap.put(width, new LinkedList<Node>());
					nodeDepthMap.get(width).add(root);
					// this condition is because unvisited nodes in the same level and same widht
					// has to be covered
				} else if (utilityMap.get(width) == actualHeight) {
					nodeDepthMap.get(width).add(root);
				}
			} else {
				printBottomViewOfTheTreeUtility(root.left, height - 1, actualHeight, nodeDepthMap, utilityMap,
						width - 1);
				printBottomViewOfTheTreeUtility(root.right, height - 1, actualHeight, nodeDepthMap, utilityMap,
						width + 1);
			}
		}
	}

	// working
	public static void printPerimeterOfTheTree(Node root) {
		if (root != null) {
			System.out.println(root.data);
			printRightViewOfTheTree(root.right, 0, -1);
			printLeftViewOfTheTree(root.left, 0, -1);
		}
	}

	public static int printHeightOfTree(Node root) {
		if (root != null) {
			return 1 + Math.max(printHeightOfTree(root.left), printHeightOfTree(root.right));
		} else
			return 0;

	}

	public static int printDiameterOfTree(Node root) {
		if (root != null) {
			int leftHeight = printHeightOfTree(root.left);
			int rightHeight = printHeightOfTree(root.right);
			return Math.max(Math.max(printDiameterOfTree(root.left), printDiameterOfTree(root.right)),
					1 + leftHeight + rightHeight);
		}
		return 0;

	}

	static class HeightWrapper {
		Integer height = 0;
	}

	// https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
	// change the height to a custom object, it should work
	// think of scenario where diameter is not through the root
	public static int printDiameterOfTreeOptimized(Node root, HeightWrapper height) {
		if (root != null) {
			HeightWrapper lh = new HeightWrapper();
			HeightWrapper rh = new HeightWrapper();
			int leftDiameter = printDiameterOfTreeOptimized(root.left, lh);
			int rightDiameter = printDiameterOfTreeOptimized(root.right, rh);
			height.height = Math.max(lh.height, rh.height) + 1;
			return Math.max(Math.max(leftDiameter, rightDiameter), 1 + lh.height + rh.height);
		}
		return 0;

	}

	// https://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
	// path with maximum sum, path can start and end at any node
	public static int maxPathSumInBinaryTree(Node root) {
		Storage count = new Storage();
		maxPathSumInBinaryTree(root, count);
		return count.value;
	}

	// https://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
	// read it later thoroughly
	public static int maxPathSumInBinaryTree(Node root, Storage count) {
		if (root == null)
			return 0;
		int l = maxPathSumInBinaryTree(root.left, count);
		int r = maxPathSumInBinaryTree(root.right, count);
		// if this root is inlucde in the total path, then we can only take
		// either right or left of this child root and hence recMax
		int recMax = Math.max(Math.max(l, r) + root.data, root.data);
		int localMax = Math.max(recMax, l + r + root.data);
		count.value = Math.max(count.value, localMax);
		return recMax;
	}

	public static boolean printAncestorsOfNode(Node root, Node node) {
		if (root != null) {
			if (root == node) {
				return true;
			}
			if (printAncestorsOfNode(root.left, node) || printAncestorsOfNode(root.right, node)) {
				System.out.print(root.data + " ");
				return true;
			}
			return false;
		}
		return false;
	}

	// also try without recursion
	// working
	// same approach can be used for finding common ancestors of multiple nodes
	// (s1.retainAll(s2))
	public static void printAncestorsOfNodeWithoutRecursion(Node root, Node node) {
		if (root != null) {
			Map<Node, Node> childParentMap = new HashMap<Node, Node>();

			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);
			childParentMap.put(root, null);
			while (!queue.isEmpty()) {
				Node levelorderNode = queue.poll();
				if (levelorderNode.left != null) {
					queue.add(levelorderNode.left);
					childParentMap.put(levelorderNode.left, levelorderNode);
				}
				if (levelorderNode.right != null) {
					queue.add(levelorderNode.right);
					childParentMap.put(levelorderNode.right, levelorderNode);
				}
			}
			while (childParentMap.get(node) != null) {
				Node parent = childParentMap.get(node);
				System.out.print(parent.data + " ");
				node = parent;
			}
		}

	}

	// https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
	// assumes that both the nodes are present
	// https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
	// - BST
	public static Node printFirstCommonAncestorOfNodes(Node root, Node firstRoot, Node secondRoot) {
		if (root == null)
			return null;
		// we can have two separate boolean values to check if each of the two nodes are
		// present
		if (root == firstRoot || root == secondRoot) {
			return root;
		} else {
			Node left = printFirstCommonAncestorOfNodes(root.left, firstRoot, secondRoot);
			Node right = printFirstCommonAncestorOfNodes(root.right, firstRoot, secondRoot);
			if (left != null && right != null)
				return root;
			else if (left == null && right == null)
				return null;
			else
				return left != null ? left : right;
		}
	}

	public static boolean checkIfTreesAreIndentical(Node firstRoot, Node secondRoot) {
		if (firstRoot == null && secondRoot != null)
			return false;
		else if (firstRoot != null && secondRoot == null)
			return false;
		else if (firstRoot == null && secondRoot == null)
			return true;
		else
			return firstRoot.data == secondRoot.data && checkIfTreesAreIndentical(firstRoot.left, secondRoot.left)
					&& checkIfTreesAreIndentical(firstRoot.right, secondRoot.right);

	}

	// https://leetcode.com/problems/symmetric-tree/solution/
	// other approach would be to use two queue, to do level order processing
	public static boolean checkIfTreesAreMirrorImages(Node firstRoot, Node secondRoot) {
		if (firstRoot == null && secondRoot != null)
			return false;
		else if (firstRoot != null && secondRoot == null)
			return false;
		else if (firstRoot == null && secondRoot == null)
			return true;
		else
			return firstRoot.data == secondRoot.data && checkIfTreesAreIndentical(firstRoot.left, secondRoot.right)
					&& checkIfTreesAreIndentical(firstRoot.right, secondRoot.left);

	}

	// working
	public static int findSumOfAllNodes(Node root) {
		if (root == null)
			return 0;
		return findSumOfAllNodes(root.left) + root.data + findSumOfAllNodes(root.right);
	}

	// https://www.geeksforgeeks.org/sum-nodes-longest-path-root-leaf-node/
	// check for other related questions in the recommended posts section
	// working
	// should check again
	// check for sum along longest path and path with largest sum
	public static int findSumAlongLongestPathFromRoot(Node root, Storage sum) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null) {
			sum.value = sum.value + root.data;
			return 1;
		}
		Storage leftSum = new Storage();
		Storage rightSum = new Storage();

		int leftHeight = findSumAlongLongestPathFromRoot(root.left, leftSum);
		int rightHeight = findSumAlongLongestPathFromRoot(root.right, rightSum);
		if (leftHeight == rightHeight)
			sum.value = sum.value + root.data + (leftSum.value > rightSum.value ? leftSum.value : rightSum.value);
		else
			sum.value = sum.value + root.data + (leftHeight > rightHeight ? leftSum.value : rightSum.value);

		return 1 + Math.max(leftHeight, rightHeight);

	}

	public static boolean checkIfPathExistFromRootWithGivenSum(Node root, int sum) {

		if (root == null)
			return false;
		if (root.left == null && root.right == null)
			return root.data == sum;
		return checkIfPathExistFromRootWithGivenSum(root.left, sum - root.data)
				|| checkIfPathExistFromRootWithGivenSum(root.right, sum - root.data);
	}

	// working
	public static boolean printPathToNode(Node root, Node node, List<Node> nodes) {
		if (root == null)
			return false;
		else if (root == node) {
			nodes.add(node);
			return true;
		} else {
			List<Node> subRightNodes = new ArrayList();
			List<Node> subLeftNodes = new ArrayList();
			if (printPathToNode(root.left, node, subLeftNodes)) {
				nodes.add(root);
				nodes.addAll(subLeftNodes);
				return true;
			} else if (printPathToNode(root.right, node, subRightNodes)) {
				nodes.add(root);
				nodes.addAll(subRightNodes);
				return true;
			}
			return false;
		}

	}

	// working
	// https://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/
	// https://www.geeksforgeeks.org/sort-the-path-from-root-to-a-given-node-in-a-binary-tree/
	public static void printNodesAtGivenDistanceFromAGivenNode(Node root, Node node, int distance) {
		// both the below things can be done if we can built a map with nodes and their
		// depths, nodes and their sides (left or right to root)
		int distanceOfGiveNodeFromRoot = printDistanceFromRoot(root, node);
		Boolean nodePresentOnLeft = checkIfGivenNodeIsPresent(root.left, node);
		if (distance < distanceOfGiveNodeFromRoot) {
			// print nodes at distance of distanceOfGiveNodeFromRoot-distance from root in
			// the same branch as given node
			if (nodePresentOnLeft) {
				printAllNodesAtGivenDistanceFromRoot(root.left, distanceOfGiveNodeFromRoot - distance - 1);
			} else {
				printAllNodesAtGivenDistanceFromRoot(root.right, distanceOfGiveNodeFromRoot - distance - 1);
			}
		} else if (distance == distanceOfGiveNodeFromRoot) {
			// printing the root
			System.out.println(root.data);
		} else {
			// //print nodes at distance of distance-distanceOfGiveNodeFromRoot from root in
			// the the other branch as given nod
			if (nodePresentOnLeft) {
				printAllNodesAtGivenDistanceFromRoot(root.right, distance - distanceOfGiveNodeFromRoot - 1);
			} else {
				printAllNodesAtGivenDistanceFromRoot(root.left, distance - distanceOfGiveNodeFromRoot - 1);
			}
		}
		printAllNodesAtGivenDistanceFromRoot(node, distance);

	}

	// working
	// also check for distance between nodes
	public static int printDistanceFromRoot(Node root, Node node) {
		Storage distance = new Storage();
		printDistanceOfGivenNodeFromRoot(root, node, distance);
		return distance.value;
	}

	// working
	// can be done in other way by using maps with nodes as keys and depths
	// as values
	public static boolean printDistanceOfGivenNodeFromRoot(Node root, Node node, Storage distance) {
		if (root == null)
			return false;
		if (root == node)
			return true;
		Storage left = new Storage();
		Storage right = new Storage();
		boolean leftResult = printDistanceOfGivenNodeFromRoot(root.left, node, left);
		boolean rightResult = printDistanceOfGivenNodeFromRoot(root.right, node, right);
		if (leftResult) {
			distance.value = 1 + left.value;
			return true;
		} else if (rightResult) {
			distance.value = 1 + right.value;
			return true;
		}
		return false;
	}

	// working
	public static void printAllNodesAtGivenDistanceFromRoot(Node root, int k) {
		if (root == null)
			return;
		if (k == 0) {
			System.out.println(root.data + " ");
			return;
		}
		printAllNodesAtGivenDistanceFromRoot(root.left, k - 1);
		printAllNodesAtGivenDistanceFromRoot(root.right, k - 1);
	}

	// working
	public static boolean checkIfGivenNodeIsPresent(Node root, Node node) {
		if (root == null)
			return false;
		if (node == null || node == root)
			return true;
		return checkIfGivenNodeIsPresent(root.right, node) || checkIfGivenNodeIsPresent(root.left, node);
	}

	/**
	 * Print all three nodes in a binary tree such that sum of all these three nodes
	 * is greater than given x and these three nodes must hold the relationship of
	 * grandparent-parent-child. Expected Complexity – O(n) also solve the case when
	 * there is no parent-child-grand child relationship
	 */
	public static void findTriplet(Node root, Node parent, int tripletSum) {
		if (root == null)
			return;
		findTriplet(root.left, root, tripletSum);
		if (parent != null) {
			int rootAndParentData = root.data + parent.data;
			if (root.right != null && rootAndParentData + root.right.data == tripletSum) {
				System.out.print(parent.data + ", " + root.data + ", " + root.right.data);
			}
			if (root.left != null && rootAndParentData + root.left.data == tripletSum) {
				System.out.print(parent.data + ", " + root.data + ", " + root.left.data);

			}
		}

		findTriplet(root.right, root, tripletSum);
	}

	// working
	public static void printEveryNodeAlongWithItsParent(Node root, Node parent) {
		if (root == null)
			return;
		printEveryNodeAlongWithItsParent(root.left, root);
		System.out.println(root.data + "->" + (parent != null ? parent.data : null));
		printEveryNodeAlongWithItsParent(root.right, root);
	}

	// working
	// we can use prev as parameter as well
	//https://leetcode.com/problems/validate-binary-search-tree/solution/
	public boolean checkIfGivenTreeIsBST(Node root) {
		if (root == null) {
			return true;
		}
		Boolean leftBST = checkIfGivenTreeIsBST(root.left);
		if (leftBST) {
			if (prev != null && prev.data >= root.data) {
				return false;
			}
			prev = root;
			return checkIfGivenTreeIsBST(root.right);
		}
		return false;
	}

	// https://www.geeksforgeeks.org/find-all-possible-trees-with-given-inorder-traversal/
	// working
	public static int findAllPossibleBinaryTreesFromInorder(int[] inorder, int lowerIndex, int upperIndex) {
		if (lowerIndex <= upperIndex) {
			if (lowerIndex == upperIndex) {
				return 1;
			} else {
				int sum = 0;
				for (int i = lowerIndex; i <= upperIndex; i++) {
					sum = sum + (findAllPossibleBinaryTreesFromInorder(inorder, lowerIndex, i - 1)
							* findAllPossibleBinaryTreesFromInorder(inorder, i + 1, upperIndex));
				}
				return sum;
			}
		}
		return 1;
	}

	// working
	public static Node getTreeFromPreorderAndInOrder(int[] preOrder, int[] inOrder, int pStart, int pEnd, int iStart,
			int iEnd) {
		if (pStart <= pEnd && iStart <= iEnd) {

			int rootElement = preOrder[pStart];
			Node root = new Node(rootElement);
			if (pStart == pEnd)
				return root;
			int rootInInorderArray = -1;
			for (int index = iStart; index <= iEnd; index++) {
				if (inOrder[index] == rootElement) {
					rootInInorderArray = index;
					break;
				}
			}
			root.left = getTreeFromPreorderAndInOrder(preOrder, inOrder, pStart + 1,
					pStart + rootInInorderArray - iStart, iStart, rootInInorderArray - 1);
			root.right = getTreeFromPreorderAndInOrder(preOrder, inOrder, pStart + rootInInorderArray - iStart + 1,
					pEnd, rootInInorderArray + 1, iEnd);
			return root;
		}
		return null;
	}

	// working
	public static Node getTreeFromPostorderAndInOrder(int[] postOrder, int[] inOrder, int pStart, int pEnd, int iStart,
			int iEnd) {
		if (pStart <= pEnd && iStart <= iEnd) {

			int rootElement = postOrder[pEnd];
			Node root = new Node(rootElement);
			if (pStart == pEnd)
				return root;
			int rootInInorderArray = -1;
			for (int index = iStart; index <= iEnd; index++) {
				if (inOrder[index] == rootElement) {
					rootInInorderArray = index;
					break;
				}
			}
			root.left = getTreeFromPostorderAndInOrder(postOrder, inOrder, pStart,
					pStart + rootInInorderArray - iStart - 1, iStart, rootInInorderArray - 1);
			root.right = getTreeFromPostorderAndInOrder(postOrder, inOrder, pStart + rootInInorderArray - iStart,
					pEnd - 1, rootInInorderArray + 1, iEnd);
			return root;
		}
		return null;
	}

	// https://www.geeksforgeeks.org/convert-given-binary-tree-doubly-linked-list-set-3/
	// working perfectly fine
	public void convertTreeToLinkedList(Node root) {
		if (root == null)
			return;
		convertTreeToLinkedList(root.left);
		if (prev == null) {
			head = root;
		} else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;
		convertTreeToLinkedList(root.right);
	}

	// working
	public static void printTreeDepthWise(Node root) {
		if (root != null) {
			Map<Integer, LinkedList<Integer>> depthMap = new HashMap<>();
			printTreeDepthWise(root, depthMap);
			depthMap = depthMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(
					Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
			for (Map.Entry<Integer, LinkedList<Integer>> entry : depthMap.entrySet()) {
				entry.getValue().stream().forEach(item -> System.out.print(item + " "));
				System.out.println();
			}
		}
	}

	public static int printTreeDepthWise(Node root, Map<Integer, LinkedList<Integer>> depthMap) {
		if (root == null)
			return 0;
		else {
			int leftDepth = printTreeDepthWise(root.left, depthMap);
			int rightDepth = printTreeDepthWise(root.right, depthMap);
			int max = Math.max(leftDepth, rightDepth);
			if (depthMap.containsKey(max + 1)) {
				depthMap.get(max + 1).add(root.data);
			} else {
				LinkedList<Integer> nodesAtDepth = new LinkedList();
				nodesAtDepth.add(root.data);
				depthMap.put(max + 1, nodesAtDepth);
			}
			return max + 1;

		}
	}

	// working
	// can be done hy traversing the tree only once as well
	// https://www.geeksforgeeks.org/find-distance-between-two-nodes-of-a-binary-tree/
	public static int findDistanceBetweenTwoNode(Node root, Node first, Node second) {
		Node LCA = printFirstCommonAncestorOfNodes(root, first, second);
		if (LCA != null) {
			return printDistanceFromRoot(LCA, first) + printDistanceFromRoot(LCA, second);
		}
		return 0;
	}

	/***
	 * 1. two nodes of a BST are swapped, 2. find out the them
	 * https://www.geeksforgeeks.org/fix-two-swapped-nodes-of-bst/
	 * 
	 * 3. Find kth smallest element in BST 4. connect nodes at same level using
	 * constant extra space -
	 * https://www.geeksforgeeks.org/connect-nodes-at-same-level-with-o1-extra-space/
	 */

}
