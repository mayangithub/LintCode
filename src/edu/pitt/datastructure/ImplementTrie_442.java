/**
 * 
 */
package edu.pitt.datastructure;

import java.util.HashMap;

/**
 * Implement Trie #442 --- Accepted
 * Implement a trie with insert, search, and startsWith methods.
 * Note
 * You may assume that all inputs are consist of lowercase letters a-z.
 * @author yanma
 * @category Data Structures
 * @version 2015-10-27
 * @week 13 1026-1101
 */

class TrieNode {
    // Initialize your data structure here.
    boolean ending;
    char character;
    HashMap<Character, TrieNode> nextChar;
    public TrieNode() {
        this.ending = false;
        this.character = ' ';
        this.nextChar = new HashMap<Character, TrieNode>();
    }
}
public class ImplementTrie_442 {
	private TrieNode root;

    public Solution() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.nextChar.containsKey(word.charAt(i))) {
                TrieNode newnode = new TrieNode();
                newnode.character = word.charAt(i);
                node.nextChar.put(word.charAt(i), newnode);
                node = newnode;
            } else {
                node = node.nextChar.get(word.charAt(i));
            }
            
        }
        node.ending = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.nextChar.containsKey(word.charAt(i))) {
                node = node.nextChar.get(word.charAt(i));
            } else {
                return false;
            }
        }
        
        if (node.ending) {
            return true;
        }
        
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return true;
        }
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (node.nextChar.containsKey(prefix.charAt(i))) {
                node = node.nextChar.get(prefix.charAt(i));
            } else {
                return false;
            }
        }
        
        return true;
    }

}
