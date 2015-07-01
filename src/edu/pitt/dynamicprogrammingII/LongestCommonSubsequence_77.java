/**
 * 
 */
package edu.pitt.dynamicprogrammingII;

/**
 * Longest Common Subsequence #77 --- Accepted
 * Given two strings, find the longest common subsequence (LCS).
 * Your code should return the length of LCS.
 * Example
 * For "ABCD" and "EDCA", the LCS is "A" (or "D", "C"), return 1.
 * For "ABCD" and "EACB", the LCS is "AC", return 2.
 * Clarification
 * What's the definition of Longest Common Subsequence?
 *     https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
 *     http://baike.baidu.com/view/2020307.htm
 * @author yanma
 * @category DP II
 * @version 2015-07-01
 * @class 5
 */
public class LongestCommonSubsequence_77 {
	
	/**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        /**
         * state: f[i][j]表示A的前i个字符和B的前j个字符的最长公共子序列的长度
         * function: A[i] == B[j], f[i][j] = f[i - 1][j - 1] + 1; 
         *           A[i] != B[j], f[i][j] = MAX(f[i][j - 1], f[i - 1][j]);
         * initialization: f[i][0] = 0, f[0][j] = 0
         * answer: f[A.len][B.len]
         */
        if (A == null || B == null || A.length() == 0 || B.length() == 0) {
            return 0;
        }
        
        int Alen = A.length();
        int Blen = B.length();
        
        int[][] lcs = new int[Alen + 1][Blen + 1];
        for (int i = 0; i <= Blen; i++) {
            lcs[0][i] = 0;
        }
        for (int j = 1; j <= Alen; j++) {
            lcs[j][0] = 0;
        }
        
        for (int i = 0; i < Alen; i++) {
            for (int j = 0; j < Blen; j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    lcs[i + 1][j + 1] = lcs[i][j] + 1; // be careful about the index
                } else {
                    lcs[i + 1][j + 1] = Math.max(lcs[i][j + 1], lcs[i + 1][j]); // drop last letter either of two strings
                }
            }
        }
        
        return lcs[Alen][Blen];
    }
	

}
