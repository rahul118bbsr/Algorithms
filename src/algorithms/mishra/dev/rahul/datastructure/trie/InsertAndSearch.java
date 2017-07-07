/**
 * 
 */
package algorithms.mishra.dev.rahul.datastructure.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 28-Jun-2017 7:33:45 AM
 *
 */
public class InsertAndSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("abc");
		trie.insert("abgl");
		trie.insert("cdf");
		trie.insert("abcd");
		trie.insert("lmn");
		System.out.println(trie.search("cdf"));
	}

}

class TrieNode {
	Map<Character, TrieNode> children;
	boolean endOfWord;

	public TrieNode() {
		children = new HashMap<>();
		endOfWord = false;
	}
}

class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if (node == null) {
				node = new TrieNode();
				current.children.put(ch, node);
			}
			current = node;
		}
		// mark the current nodes endOfWord as true
		current.endOfWord = true;
	}

	/**
	 * Iterative implementation of search into trie.
	 */
	public boolean search(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			// if node does not exist for given char then return false
			if (node == null) {
				return false;
			}
			current = node;
		}
		// return true of current's endOfWord is true else return false.
		return current.endOfWord;
	}

	/**
	 * Returns true if parent should delete the mapping
	 */
	private boolean delete(TrieNode current, String word, int index) {
		if (index == word.length()) {
			// when end of word is reached only delete if currrent.endOfWord is true.
			if (!current.endOfWord) {
				return false;
			}
			current.endOfWord = false;
			// if current has no other mapping then return true
			return current.children.size() == 0;
		}
		char ch = word.charAt(index);
		TrieNode node = current.children.get(ch);
		if (node == null) {
			return false;
		}
		boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

		// if true is returned then delete the mapping of character and trienode reference from map.
		if (shouldDeleteCurrentNode) {
			current.children.remove(ch);
			// return true if no mappings are left in the map.
			return current.children.size() == 0;
		}
		return false;
	}
}