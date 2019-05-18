package src.Others;

//https://www.geeksforgeeks.org/print-valid-words-possible-using-characters-array/
/**
 * Think of infix search as well names = ['rahul', 'rohit', 'varun', 'mohit']
 * search_string = 'r' --> expected_search_result = ['rahul', 'rohit', 'varun']
 * -> Might have to use suffix array search_string = 'ra' -->
 * expected_search_result = ['rahul'] search_string = 'hit' -->
 * expected_search_result = ['rohit', 'mohit']
 * 
 * Size of Trie - Complexity In a way, yes, O(n**m) is a correct boundary too.
 * It's just pretty useless in most cases. For example, w = 200 words with an
 * average length of m = 100 in an alphabet size of n = 50 would result in
 * O(50**100), woo, doesn't fit in the universe! ...while the other boundary
 * would be O(200*100).
 * 
 * Also read suggest tree, ternary tree, segment tree
 * http://dhruvbird.blogspot.com/2010/09/very-fast-approach-to-search.html
 * https://en.wikipedia.org/wiki/Suffix_tree
 * https://en.wikipedia.org/wiki/Suffix_array
 * https://www.geeksforgeeks.org/pattern-searching-using-suffix-tree/
 * 
 * 
 * 
 * v.v.v.imp -> Before thinking of Trie, check for no of strings (Trie makes
 * sense only when there are large no of strings)
 * 
 * @author sai_kanth
 *
 */
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

	// also prefix and suffix search -
	// https://leetcode.com/problems/prefix-and-suffix-search/
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
	// https://www.youtube.com/watch?v=us0qySiUsGU - getting suggestions from
	// multiple Trie's in case of huge data
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
			if (node.nodes[i] != null)
				printAllNodesFromGiveNode(node.nodes[i], new StringBuilder(prefixString));
		}

	}

}
