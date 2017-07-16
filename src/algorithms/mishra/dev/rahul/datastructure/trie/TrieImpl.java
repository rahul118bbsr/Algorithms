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
//		Trie trie = new TrieImpl().new Trie();
//		trie.insert("abc");
//		trie.insert("abgl");
//		trie.insert("cdf");
//		trie.insert("abcd");
//		trie.insert("lmn");
//		System.out.println(trie.search("cdf"));
	}

	class Trie {
		private TrieNode root = null;
		Trie() {
			root = new TrieNode();
		}

		public void insert(String word) {
			TrieNode current = root;
			for(int i = 0; i < word.length(); i++) {
				Character ch = word.charAt(i);
				TrieNode node = root.children.get(ch);
				if(node == null) {
					node = new TrieNode();
					root.children.put(ch, node);
				}
				current = node;
			}
			current.endOfWord = true;
		}

		public boolean search(String word) {
			TrieNode current = root;
			for(int i = 0; i < word.length(); i++) {
				Character ch = word.charAt(i);
				if(root.children.get(ch) == null) {
					return false;
				}
				current = root.children.get(ch);
			}
			return current.endOfWord;
		}
	}



	class TrieNode {
		private Map<Character, TrieNode> children = new HashMap<>();
		private boolean endOfWord;
	}

}
