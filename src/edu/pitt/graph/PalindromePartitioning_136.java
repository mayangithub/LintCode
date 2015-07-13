/**
 * 
 */
package edu.pitt.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Palindrome Partitioning #136 --- Accepted
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * Example
 * given s = "aab",
 * Return
  [
    ["aa","b"],
    ["a","a","b"]
  ]
 * @author yanma
 * @category Graph and Search
 * @version 2015-07-13
 * @class 7
 */
public class PalindromePartitioning_136 {
	
	/**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> result = new ArrayList<List<String>>();
        if (s == null || s.length() == 0) {
            return result;
        }
        
        boolean[][] truth = isPalindrome(s);
        
        helper(s, 0, truth, result, new ArrayList<String>());

        return result;
    }
    
    public void helper(String s, int start, boolean[][] truth, List<List<String>> result, List<String> inner) {
        if (start == s.length()) {
            result.add(new ArrayList<String>(inner));
            return;
        }
        
        for (int i = start; i < s.length(); i++) { // i: end at index, inlcudes
            if (truth[start][i]) {
                inner.add(s.substring(start, i + 1));
                helper(s, i + 1, truth, result, inner);
                inner.remove(inner.size() - 1);
            }
        }
    }
    
    public boolean[][] isPalindrome(String s) {
        int n = s.length();
        boolean[][] truth = new boolean[n][n];
        for (int start = 0; start < n; start++) {
            truth[start][start] = true;
        }
        
        for (int start = 0; start < n - 1; start++) {
            if (s.charAt(start) == s.charAt(start + 1)) {
                truth[start][start + 1] = true;
            }
        }
        
        for (int length = 2; length < n; length++) {
            for (int start = 0; start + length < n; start++) {//start + length = end index
                truth[start][start + length] = (s.charAt(start) == s.charAt(start + length)) ? truth[start + 1][start + length - 1]: false;
            }
        }
        
        return truth;
    }

}
