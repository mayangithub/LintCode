/**
 * 
 */
package edu.pitt.dynamicprogrammingII;

/**
 * Distinct Subsequences #118 --- Accepted
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) 
 * of the characters without disturbing the relative positions of the remaining characters. 
 * (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * Example
 * Given S = "rabbbit", T = "rabbit", return 3.
 * Challenge
 * Do it in O(n2) time and O(n) memory.
 * O(n2) memory is also acceptable if you do not know how to optimize memory.
 * @author yanma
 * @category DP II
 * @version 2015-07-02
 * @class 5
 */
public class DistinctSubsequences_118 {

	/**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
        /**
         * state: f[i][j] means how many distinct subsequences of first j letters in T are there in first i letters in S
         * function: if last letters are same, f[i][j] = f[i - 1][j - 1] + f[i - 1][j];
         *           if they different, f[i][j] = f[i - 1][j]
         * initialization: f[i][0] = 1, f[0][j] = 0
         * answer: f[S.length][T.length]
         */
        if (S == null || S.length() == 0) {
            return 0;
        }    
        if (T == null || T.length() == 0 || S.equals(T)) {
            return 1;
        }
        
        int slen = S.length();
        int tlen = T.length();
        
        int[][] num = new int[slen + 1][tlen + 1];
        
        for (int j = 1; j <= tlen; j++) {
            num[0][j] = 0;
        }
        
        for (int i = 0; i <= slen; i++) {
            num[i][0] = 1;
        }
        
        for (int i = 1; i <= slen; i++) {
            for (int j = 1; j <= tlen; j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    num[i][j] = num[i - 1][j - 1] + num[i - 1][j];
                } else {
                    num[i][j] = num[i - 1][j];
                }
            }
        }
        return num[slen][tlen];
    }
}
