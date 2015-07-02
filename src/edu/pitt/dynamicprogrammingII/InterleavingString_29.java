/**
 * 
 */
package edu.pitt.dynamicprogrammingII;

/**
 * Interleaving String #29 --- Accepted
 * Given three strings: s1, s2, s3, determine whether s3 is formed by the interleaving of s1 and s2.
 * Example
 * For s1 = "aabcc", s2 = "dbbca"
    When s3 = "aadbbcbcac", return true.
    When s3 = "aadbbbaccc", return false.
 * Challenge
 * O(n2) time or better
 * @author yanma
 * @category DP II
 * @version 2015-07-02
 * @class 5
 */
public class InterleavingString_29 {
	
	/**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        /**
         * state: f[i][j] means whether first i letters in s1 and first j letters in s2 compose first i + j letters in s3
         * function: f[i][j] = OR{(s3[i + j] == s1[i] && f[i - 1][j]), (s3[i + j] == s2[j] && f[i][j - 1])}
         * initialization: f[0][0] = true, f[0][j] = (s2[j - 1] == s3[j - 1]); f[i][0] = (s1[i - 1] == s3[i - 1]);
         * answer: f[s1.len][s2.len]
         */
         
        if (s3 == null || s3.length() == 0) return true;
        if (s1 == null || s1.length() == 0) {
            if (s2 != null && s2.equals(s3)) {
                return true;
            }
            return false;
        }
        if (s2 == null || s2.length() == 0) {
            if (s1 != null && s1.equals(s3)) {
                return true;
            }
            return false;
        }
        
        int s1len = s1.length();
        int s2len = s2.length();
        int s3len = s3.length();
        if (s1len + s2len != s3len) return false;
        
        boolean[][] truth = new boolean[s1len + 1][s2len + 1];
        truth[0][0] = true;
        for (int i = 1; i <= s1len; i++) {
            if (s3.charAt(i - 1) == s1.charAt(i - 1) && truth[i - 1][0]) {
                truth[i][0] = true;
            }
        }
        for (int j = 1; j <= s2len; j++) {
            if (s3.charAt(j - 1) == s2.charAt(j - 1) && truth[0][j - 1]) {
                truth[0][j] = true;
            }
        }
        
        for (int i = 1; i <= s1len; i++) {
            for (int j = 1; j <= s2len; j++) {
                if (truth[i][j]) continue;
                if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && truth[i - 1][j]) {
                    truth[i][j] = true;
                } else if (s2.charAt(j - 1) == s3.charAt(i + j - 1) && truth[i][j - 1]) {
                    truth[i][j] = true;
                }
            }
        }
        
        return truth[s1len][s2len];
    }

}
