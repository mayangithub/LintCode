/**
 * 
 */
package edu.pitt.twopointers;

import java.util.HashMap;

/**
 * Longest Substring Without Repeating Characters #384 --- Accepted
 * Given a string, find the length of the longest substring without repeating characters. 
 * Example
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
 * For "bbbbb" the longest substring is "b", with the length of 1.
 * Challenge
 * O(n) time
 * @author yanma
 * @category Two Pointers
 * @version 2015-09-04
 * @class 5
 * @week5 0831-0906
 */
public class LongestSubstringWithoutRepeatingCharacters_384 {
	
	/**
     * @param s: a string
     * @return: an integer 
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int j = 0;
        int i = 0;
        while (j < s.length()) {
            if (!map.containsKey(s.charAt(j)) || map.get(s.charAt(j)) == -1) {
                map.put(s.charAt(j), j);
                length = Math.max(length, j - i + 1);
                j++;
            } else {
                int index = map.get(s.charAt(j));
                while (i <= index) {
                    map.put(s.charAt(i), -1);
                    i++;
                }
            }
        }
        
        return length;
    }
	/**
     * @param s: a string
     * @return: an integer 
     */
    public int lengthOfLongestSubstring1(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = 0;
        HashMap<Character, Boolean> map = new HashMap<Character, Boolean>();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && (!map.containsKey(s.charAt(j)) || !map.get(s.charAt(j)))) {
                map.put(s.charAt(j), true);
                j++;
            }
            if (j < s.length() && map.get(s.charAt(j))) {
                length = Math.max(length, j - i);
                map.put(s.charAt(i), false);
            } else if (j == s.length()) {
                length = Math.max(length, j - i);
                break;
            }
        }
        
        return length;
    }

}
