package algorithms.mishra.dev.rahul.leetcode.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by aleesha on 20/07/17.
 */
public class TrieImpl {



    class Trie {
        private TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            if(Objects.isNull(word) || Objects.equals(" ", word)) {
                return;
            }

            TrieNode current = root;
            for(Character character : word.toCharArray()) {
                TrieNode node = current.children.get(character);
                if(Objects.isNull(node)) {
                    node = new TrieNode();
                    node.children.put(character, node);
                }
                current = node;
            }
            current.isEndOfWord = true;
        }

        public boolean search(String word) {
            if(Objects.isNull(word) || Objects.equals(" ", word)) {
                return false;
            }
            TrieNode current = root;
            for(Character character : word.toCharArray()) {
                TrieNode node = current.children.get(character);
                if(Objects.isNull(node)) {
                    return false;
                }
                current = node;
            }
            return current.isEndOfWord;
        }

        public boolean delete(String word) {
            if(Objects.isNull(word) || Objects.equals(" ", word)) {
                return false;
            }
            TrieNode current = root;
            return false;
        }




        class TrieNode {
            Map<Character, TrieNode> children;
            boolean isEndOfWord;

            TrieNode() {
                children = new HashMap<>();
                isEndOfWord = false;
            }
        }
    }
}
