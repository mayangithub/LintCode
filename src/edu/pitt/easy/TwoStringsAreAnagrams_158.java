/**
 * 
 */
package edu.pitt.easy;

import java.util.HashMap;

/**
 * Two Strings Are Anagrams #158 --- Accepted
 * Write a method anagram(s,t) to decide if two strings are anagrams or not.
 * Example
 * Given s="abcd", t="dcab", return true.
 * Challenge
 * O(n) time, O(1) extra space
 * @author yanma
 * @version 2015-10-21
 * @category Easy
 * @week12 1019-1025
 */
public class TwoStringsAreAnagrams_158 {
	/**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        
        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i)) || map.get(t.charAt(i)).intValue() == 0) {
                return false;
            } else {
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            }
        }
        return true;
    }
    
    

}
