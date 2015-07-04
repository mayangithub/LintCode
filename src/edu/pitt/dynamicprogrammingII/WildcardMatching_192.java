/**
 * 
 */
package edu.pitt.dynamicprogrammingII;

/**
 * Wildcard Matching #192 --- Accepted
 * Implement wildcard pattern matching with support for '?' and '*'.
    '?' Matches any single character.
    '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * Example
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 * @author yanma
 * @category DP II, Backpack
 * @version 2015-07-03
 * @class 5
 */
public class WildcardMatching_192 {
	
	/**
     * @param s: A string 
     * @param p: A string includes "?" and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        // write your code here
        /**
         * state: f[i][j] means whether first i letters in s match with first j letters in p
         * function: f[i][j]
         *  if p[j - 1] is letter, f[i][j] = f[i - 1][j - 1] && (s[i - 1] == p[j - 1])
         *  if p[j - 1] is ?, f[i][j] = f[i - 1][j - 1]
         *  if p[j - 1] is *, 
         *  OR{  f[i][j - 1]; f[i - 1][j];
         *       if p[j - 2] = ?,  OR(f[0,..., i - 1][j - 1]), 
                 if p[j - 2] = letter, f[i - 1][j - 1] && s[i - 1] == p[j - 2]
            }
         * initialization: f[0][0] = true, f[i][0] = false, f[0][j] = f[0][j - 1] && p[j - 1] = *
         * answer: f[s.len][p.len]
         */
        
        if (s == null || p == null) {
            return false;
        } 
        
        int slen = s.length();
        int plen = p.length();
        
        boolean[][] truth = new boolean[slen + 1][plen + 1];
        truth[0][0] = true;
        for (int j = 1; j <= plen; j++) {
            truth[0][j] = truth[0][j - 1] && (p.charAt(j - 1) == '*');
        }
        
        for (int i = 1; i <= slen; i++) {
            for (int j = 1; j <= plen; j++) {
                if (p.charAt(j - 1) == '?') {
                    truth[i][j] = truth[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    if (truth[i][j - 1] || truth[i - 1][j]) { // condition
                        truth[i][j] = true;
                        continue;
                    }
                    if (p.charAt(j - 2) == '?') {
                        for (int k = i - 1; k >= 0; k--) {
                            if (truth[k][j - 1]) {
                                truth[i][j] = true; break;
                            }
                        }
                    } else {
                        truth[i][j] = truth[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 2));
                    }
                } else {
                    truth[i][j] = truth[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1));
                }
            }
        }
        
        return truth[slen][plen];
     }

}
