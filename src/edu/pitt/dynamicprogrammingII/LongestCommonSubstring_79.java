/**
 * 
 */
package edu.pitt.dynamicprogrammingII;

/**
 * Longest Common Substring #79 --- Accepted
 * Given two strings, find the longest common substring.
 * Return the length of it.
 * Example
 * Given A = "ABCD", B = "CBCE", return 2.
 * Note
 * The characters in substring should occur continuously in original string. This is different with subsequence.
 * Challenge
 * O(n x m) time and memory.
 * @author yanma
 * @category DP II
 * @version 2015-07-01
 * @class 5
 */
public class LongestCommonSubstring_79 {

	/**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        /**
         * state: f[i][j]表示A前i 个字符配上B前j个字符， 以A[i]和B[j]结尾的LCS的长度
         * function: f[i][j] = f[i - 1][j - 1] + 1, when A[i] = B[j]; f[i][j] = 0, when A[i] != B[j]; 
         * initialization: f[0][j] = 0, f[i][0] = 0
         * answer: max(f[0...A.len][0...B.len])
         */
         
        if (A == null || B == null || A.length() == 0 || B.length() == 0) {
            return 0;
        }
        
        int Alen = A.length();
        int Blen = B.length();
        
        int[][] length = new int[Alen + 1][Blen + 1];
        int max = 0;
        
        for (int i = 0; i <= Alen; i++) {
            length[i][0] = 0;
        }
        
        for (int j = 1; j <= Blen; j++) {
            length[0][j] = 0;
        }
        
        for (int i = 1; i <= Alen; i++) {
            for (int j = 1; j <= Blen; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    length[i][j] = length[i - 1][j - 1] + 1; // only with the same last letter will be add 1, else 0
                    max = Math.max(max, length[i][j]);
                }
            }
        }
        
        return max;
    }
	
}
