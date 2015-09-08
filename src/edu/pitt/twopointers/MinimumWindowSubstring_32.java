/**
 * 
 */
package edu.pitt.twopointers;

import java.util.HashMap;

/**
 * Minimum Window Substring #32 --- Accepted
 * Given a string source and a string target, 
 * find the minimum window in source which will contain all the characters in target.
 * Example
 * source = "ADOBECODEBANC" target = "ABC" Minimum window is "BANC".
 * Note
 * If there is no such window in source that covers all characters in target, return the emtpy string "".
 * If there are multiple such windows, 
 * you are guaranteed that there will always be only one unique minimum window in source.
 * Challenge
 * Can you do it in time complexity O(n) ?
 * Clarification
 * Should the characters in minimum window has the same order in target?
 *     - Not necessary.
 * @author yanma
 * @category Two Pointers
 * @version 2015-09-07
 * @class 5
 * @week 6 0907-0913
 */
public class MinimumWindowSubstring_32 {
	
	/**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        // write your code
        String answer = "";
        int length = Integer.MAX_VALUE;
        if (source == null || source.length() == 0 || target == null || target.length() == 0 || source.length() < target.length()) {
            return answer;
        }
        
        HashMap<Character, Integer> samplemap = new HashMap<Character, Integer>();
        for (int i = 0; i < target.length(); i++) {
            if (!samplemap.containsKey(target.charAt(i))) {
                samplemap.put(target.charAt(i), 1);
            } else {
                samplemap.put(target.charAt(i), samplemap.get(target.charAt(i)) + 1);
            }
        }
        
        int start = 0;
        while (start < source.length()) {
            if (samplemap.containsKey(source.charAt(start))) {
                break;
            }
            start++;
        }
        int end = start;
        int count = 0;
        while (end < source.length()) {
            if (samplemap.containsKey(source.charAt(end))) {
                samplemap.put(source.charAt(end), samplemap.get(source.charAt(end)) - 1);
                if (samplemap.get(source.charAt(end)) >= 0) { // pay attention HERE!
                    count++;
                }
                
                while (count >= target.length()) {
                    if (end - start + 1 < length) {
                        answer = source.substring(start, end + 1);
                        length = answer.length();
                    }
                    
                    if (samplemap.containsKey(source.charAt(start))) {
                        if (samplemap.get(source.charAt(start)) >= 0) { // pay attention HERE!
                            count--;
                        }
                        samplemap.put(source.charAt(start), samplemap.get(source.charAt(start)) + 1);
                    }
                    start += 1;
                }
            }
            end++;
        }
        
        return answer;
    }

}
