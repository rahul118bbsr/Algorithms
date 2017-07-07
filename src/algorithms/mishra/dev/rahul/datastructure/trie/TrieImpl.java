/**
 * 
 */
package algorithms.mishra.dev.rahul.datastructure.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 28-Jun-2017 9:47:48 AM
 *
 */
public class TrieImpl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Trie trie = new TrieImpl().new Trie();
		trie.insert("abc");
		trie.insert("abgl");
		trie.insert("cdf");
		trie.insert("abcd");
		trie.insert("lmn");
		System.out.println(trie.search("cdf"));
	}

	class TrieNode {
		private Map<Character, TrieNode> children = new HashMap<>();
		private boolean isEndOfWord = false;
	}

	class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		public void insert(String word) {
			TrieNode current = root;
			for (int i = 0; i < word.length(); i++) {
				TrieNode node = current.children.get(word.charAt(i));
				if (node == null) {
					node = new TrieNode();
					current.children.put(word.charAt(i), node);
				}
				current = node;
			}
			current.isEndOfWord = true;
		}

		public boolean search(String word) {
			TrieNode current = root;
			for (int i = 0; i < word.length(); i++) {
				TrieNode node = current.children.get(word.charAt(i));
				if (node == null) {
					return false;
				}
				current = node;
			}
			return current.isEndOfWord;
		}
	}

}
