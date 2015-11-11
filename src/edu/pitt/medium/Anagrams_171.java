/**
 * 
 */
package edu.pitt.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Anagrams #171 --- Accepted
 * Given an array of strings, return all groups of strings that are anagrams.
 * Example
 * Given ["lint", "intl", "inlt", "code"], return ["lint", "inlt", "intl"].
 * Given ["ab", "ba", "cd", "dc", "e"], return ["ab", "ba", "cd", "dc"].
 * Note
 * All inputs will be in lower-case
 * @author yanma
 * @version 2015-11-11
 * @category HashMap 
 */
public class Anagrams_171 {
	/**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        List<String> result = new ArrayList<String>();
        
        boolean[] isAdded = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if (!isAdded[i]) {
                HashMap<Character, Integer> map = mapping(strs[i]);
                for (int j = i + 1; j < strs.length; j++) {
                    if (!isAdded[j] && isAnagram(strs[i], strs[j], map)) {
                        if (!isAdded[i]) {
                            result.add(strs[i]);
                            isAdded[i] = true;
                        } 
                        result.add(strs[j]);
                        isAdded[j] = true;
                    }
                }
            }
        }
        
        return result;
    }
    
    public boolean isAnagram(String word1, String word2, HashMap<Character, Integer> map) {
        if (word1 == null || word2 == null || word1.length() != word2.length()) {
            return false;
        }
        
        HashMap<Character, Integer> counts = new HashMap<Character, Integer>(map);
        
        for (int i = 0; i < word2.length(); i++) {
            if (!counts.containsKey(word2.charAt(i)) || counts.get(word2.charAt(i)) == 0) {
                return false;
            } 
            counts.put(word2.charAt(i), counts.get(word2.charAt(i)) - 1);
        }
        return true;
    }
    
    public HashMap<Character, Integer> mapping(String word) {
        if (word == null) {
            return null;
        }
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < word.length(); i++) {
            if (!map.containsKey(word.charAt(i))) {
                map.put(word.charAt(i), 1);
            } else {
                map.put(word.charAt(i), map.get(word.charAt(i)) + 1);
            }
        }
        
        return map;
    }

}
