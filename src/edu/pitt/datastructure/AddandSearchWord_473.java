/**
 * 
 */
package edu.pitt.datastructure;

import java.util.HashMap;

/**
 * Add and Search Word #473 --- Accepted
 * Design a data structure that supports the following two operations:
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. 
 * A . means it can represent any one letter.
 * Example
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note
 * You may assume that all words are consist of lowercase letters a-z.
 * @author yanma 
 * @version 2015-11-11
 * @category Data Structures
 */
public class AddandSearchWord_473 {
	public class WordDictionary {
	    
	    private class WordNode {
	        private char character;
	        private boolean ending;
	        private HashMap<Character, WordNode> nextChar;
	    
	        public WordNode() {
	            character = ' ';
	            ending = false;
	            nextChar = new HashMap<Character, WordNode>();
	        }
	    }
	    
	    public WordNode root;
	    
	    public WordDictionary() {
	        root = new WordNode();
	    }

	    // Adds a word into the data structure.
	    public void addWord(String word) {
	        // Write your code here
	        if (word == null || word.length() == 0) {
	            return;
	        }
	        WordNode node = this.root;
	        for (int i = 0; i < word.length(); i++) {
	            if (node.nextChar.containsKey(word.charAt(i))) {
	                node = node.nextChar.get(word.charAt(i));
	            } else {
	                WordNode newnode = new WordNode();
	                newnode.character = word.charAt(i);
	                node.nextChar.put(word.charAt(i), newnode);
	                node = node.nextChar.get(word.charAt(i));
	            }
	            
	            if (i == word.length() - 1) {
	                node.ending = true;
	            }
	        }
	    }

	    // Returns if the word is in the data structure. A word could
	    // contain the dot character '.' to represent any one letter.
	    public boolean search(String word) {
	        // Write your code here
	        if (word == null || word.length() == 0) {
	            return false;
	        }
	        
	        return searchHelper(word, 0, this.root);
	    }
	    
	    public boolean searchHelper(String word, int index, WordNode node) {
	        if (index == word.length()) {
	            return node.ending;
	        }
	        if (node == null) {
	            return false;
	        }
	        
	        if (word.charAt(index) != '.' && !node.nextChar.containsKey(word.charAt(index))) {
	            return false;
	        } 
	            
	        if (word.charAt(index) == '.') {
	            for (WordNode next: node.nextChar.values()) {
	                node = next;
	                if (searchHelper(word, index + 1, node)) {
	                    return true;
	                }
	            }
	            return false;
	        }
	        
	        node = node.nextChar.get(word.charAt(index));
	        return searchHelper(word, index + 1, node);
	    }
	}

	// Your WordDictionary object will be instantiated and called as such:
	// WordDictionary wordDictionary = new WordDictionary();
	// wordDictionary.addWord("word");
	// wordDictionary.search("pattern");

}
