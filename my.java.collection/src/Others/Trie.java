package src.Others;

//https://www.geeksforgeeks.org/print-valid-words-possible-using-characters-array/
public class Trie {

	TrieNode root;

	public static class TrieNode {
		// never initialize is it here, always do a lazy loading
		TrieNode[] nodes;
		boolean isLeafNode;
		char content;

		public TrieNode(char inputArray) {
			this.content = inputArray;
			nodes = new TrieNode[26];
			isLeafNode = false;
		}

		public TrieNode() {
			nodes = new TrieNode[26];
			isLeafNode = false;
		}
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.root = new TrieNode('@');
		trie.inserString(trie.root, "Sasi");
		trie.inserString(trie.root, "SasiKanth");
		trie.inserString(trie.root, "Sashi");
		trie.inserString(trie.root, "Sasur");
		trie.inserString(trie.root, "SaiKanth");
		System.out.println("Given string is present in the tree: " + trie.checkIfStringIsPresent(trie.root, "Sai"));
		printAllRelatedStrings(trie.root, "Sas");
	}

	public void inserString(TrieNode root, String input) {
		if (root == null || input == null)
			return;
		input = input.toLowerCase();
		char[] inputArray = input.toCharArray();
		int length = inputArray.length;
		for (int index = 0; index < length; index++) {
			if (root.nodes[(int) inputArray[index] - 97] == null) {
				TrieNode node = new TrieNode(inputArray[index]);
				root.nodes[(int) inputArray[index] - 97] = node;
			}
			if (index == length - 1) {
				root.nodes[(int) inputArray[index] - 97].isLeafNode = true;
				return;
			}
			// if the character is already present, we just move to the next child node
			root = root.nodes[(int) inputArray[index] - 97];

		}
	}

	public boolean checkIfStringIsPresent(TrieNode node, String input) {
		if (node == null)
			return false;
		else if (input == null)
			return true;
		else {
			input = input.toLowerCase();
			char[] inputArray = input.toCharArray();
			int length = inputArray.length;
			for (int index = 0; index < length; index++) {
				TrieNode currentNode = node.nodes[(int) inputArray[index] - 97];
				if (currentNode == null || currentNode.content != inputArray[index]) {
					return false;
				} else {
					node = currentNode;
				}
				// use this condition if u want to search for complete string
				// if (index == length - 1 && !currentNode.isLeafNode) {
				// return false;
				// }
			}
			return true;
		}

	}

	// auto suggestion //working
	// try now printing only the top 10 words
	// https://www.geeksforgeeks.org/auto-complete-feature-using-trie/
	public static void printAllRelatedStrings(TrieNode node, String input) {
		if (node == null)
			return;
		else {
			TrieNode current = null;
			input = input.toLowerCase();
			int length = input.length();
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < length; i++) {
				current = node.nodes[(int) input.charAt(i) - 97];
				if (current != null && current.content == input.charAt(i)) {
					result = result.append(current.content);
					// input = input.concat(String.valueOf(current.content));
					node = current;
				} else {
					return;
				}
				if (i == length - 1) {
					if (current.isLeafNode) {
						System.out.println(result);
						return;
					}
					result.deleteCharAt(result.length() - 1);
					printAllNodesFromGiveNode(node, result);
				}
			}
		}
	}

	public static void printAllNodesFromGiveNode(TrieNode node, StringBuilder prefixString) {
		if (node == null)
			return;
		prefixString.append(node.content);
		System.out.println(prefixString);
		for (int i = 0; i < 26; i++) {
			printAllNodesFromGiveNode(node.nodes[i], new StringBuilder(prefixString));
		}

	}

}
