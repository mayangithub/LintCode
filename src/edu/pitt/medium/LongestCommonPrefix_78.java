/**
 * 
 */
package edu.pitt.medium;

/**
 * Longest Common Prefix #78 --- Accepted
 * @author yanma
 * @version 2015-11-14
 * @category String, Medium
 * Given k strings, find the longest common prefix (LCP).
 * Example
 * For strings "ABCD", "ABEF" and "ACEF", the LCP is "A"
 * For strings "ABCDEFG", "ABCEFG" and "ABCEFA", the LCP is "ABC"
 */
public class LongestCommonPrefix_78 {
	/**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        // write your code here
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        
        String LCP = strs[0];
        for (int i = 1; i < strs.length; i++) {
            LCP = helper(strs[i], LCP);
        }
        return LCP;
    }
    
    public String helper(String word, String LCP) {
        if (word == null || word.length() == 0) {
            return "";
        }
        
        int length = LCP.length();
        if (word.length() < length) {
            length = word.length();
        }
        
        for (int i = 0; i < length; i++) {
            if (word.charAt(i) != LCP.charAt(i)) {
                LCP = LCP.substring(0, i);
                break;
            }
        }
        
        return LCP;
    }
    
    

}
