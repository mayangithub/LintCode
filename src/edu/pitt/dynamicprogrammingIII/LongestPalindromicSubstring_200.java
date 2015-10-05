/**
 * 
 */
package edu.pitt.dynamicprogrammingIII;

/**
 * Longest Palindromic Substring #200 --- Accepted
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 * Example
 * Given the string = "abcdzdcab", return "cdzdc".
 * Challenge
 * O(n^2) time is acceptable. Can you do it in O(n) time.
 * @author yanma
 * @version 2015-10-05
 * @category Dynamic Programming Advanced
 * @class 6
 * @week 10 1005-1011
 */
public class LongestPalindromicSubstring_200 {
	
	/**
	 * O(n^2)
     * @param s input string
     * @return the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return "";
        } else if (s.length() == 1) {
            return s;
        }
        
        boolean[][] truth = isPalindrome(s);
        String longest = "";
        for (int start = 0; start < s.length(); start++) {
            for (int end = start; end < s.length(); end++) {
                if (truth[start][end]) {
                    if (longest.length() < end - start + 1) {
                        longest = s.substring(start, end + 1);
                    }
                }
            }
        }
        
        return longest;
    }
    
    public boolean[][] isPalindrome(String s) {
        boolean[][] truth = new boolean[s.length()][s.length()];
        int length = 1;
        for (; length <= s.length(); length++) {
            for (int start = 0; start <= s.length() - length; start++) {
                if (length == 1) {
                    truth[start][start] = true;
                } else if (length == 2) {
                    truth[start][start + 1] = (s.charAt(start) == s.charAt(start + 1));
                } else {
                    truth[start][start + length - 1] = (s.charAt(start) == s.charAt(start + length - 1)) ? truth[start + 1][start + length - 2]: false;
                }
            }
        }
        
        return truth;
    }
	
	
	
	/**
	 * O(n^3) method
     * @param s input string
     * @return the longest palindromic substring
     */
    public String longestPalindrome1(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return "";
        } else if (s.length() == 1) {
            return s;
        }
        
        String longest = "";
        for (int start = 0; start < s.length(); start++) {
            for (int end = start; end < s.length(); end++) {
                if (isPalindrome(s, start, end)) {
                    if (longest.length() < end - start + 1) {
                        longest = s.substring(start, end + 1);
                    }
                }
            }
        }
        
        return longest;
    }
    
    public boolean isPalindrome(String s, int start, int end) {
        if (start > end) {
            return true;
        } 
        if (start == end) {
            return true;
        }
        
        if (s.charAt(start) != s.charAt(end)) {
            return false;
        }
        return isPalindrome(s, start + 1, end - 1);
    }

}
