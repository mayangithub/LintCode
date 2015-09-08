/**
 * 
 */
package edu.pitt.twopointers;

import java.util.HashMap;

/**
 * Longest Substring with At Most K Distinct Characters #386 --- Accepted
 * Given a string s, find the length of the longest substring T that contains at most k distinct characters.
 * Example
 * For example, Given s = "eceba", k = 3,
 * T is "eceb" which its length is 4.
 * Challenge
 * O(n), n is the size of the string s.
 * @author yanma
 * @category Two Pointers
 * @version 2015-09-07
 * @class 5
 * @week 6 0907-0913
 */
public class LongestSubstringwithAtMostKDistinctCharacters_386 {
	
	/**
     * @param s : A string
     * @return : The length of the longest substring 
     *           that contains at most k distinct characters.
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if (s == null || k == 0 || s.length() == 0) {
            return 0;
        }
        
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0;
        int end = 0;
        int uniq = 0;
        while (end < s.length()) {
            if (!map.containsKey(s.charAt(end))) {
                uniq += 1;
                map.put(s.charAt(end), 1);
            } else if (map.get(s.charAt(end)) == 0) {
                uniq += 1;
                map.put(s.charAt(end), map.get(s.charAt(end)) + 1);
            } else {
                map.put(s.charAt(end), map.get(s.charAt(end)) + 1);
            }
            
            while (uniq > k) {
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                if (map.get(s.charAt(start)) == 0) {
                    uniq -= 1;
                }
                start++;
            }
            max = Math.max(max, end - start + 1);
            end++;
        }
        
        return max;
    }

}
