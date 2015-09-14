/**
 * 
 */
package edu.pitt.dynamicprogrammingIII;

/**
 * Longest Increasing Continuous subsequence II #398 --- Accepted
 * Give you an integer matrix (with row size n, column size m)，
 * find the longest increasing continuous subsequence in this matrix. 
 * (The definition of the longest increasing continuous subsequence here can start at any row or column 
 * and go up/down/right/left any direction).
 * Example
 * Given a matrix:
 * [
 *   [1 ,2 ,3 ,4 ,5],
 *   [16,17,24,23,6],
 *   [15,18,25,22,7],
 *   [14,19,20,21,8],
 *   [13,12,11,10,9]
 * ]
 * return 25
 * Challenge
 * O(nm) time and memory.
 * @author yanma
 * @category Dynamic Programming Advanced
 * @version 2015-09-13
 * @class 5
 * @week 6 0907-0913
 */
public class LongestIncreasingContinuousSubsequenceII_398 {

	
	/**
     * @param A an integer matrix
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        // Write your code here
        if (A == null || A.length == 0 || A.length == 0) {
            return 0;
        }
        
        int max = 0;
        int[][] flag = new int[A.length][A[0].length];
        int[][] dp = new int[A.length][A[0].length];
        
        for (int r = 0; r < A.length; r++) {
            for (int c = 0; c < A[0].length; c++) {
                search(r, c, A, flag, dp);
                max = Math.max(max, dp[r][c]);
            }
        }
        
        return max;
    }
    
    public void search(int r, int c, int[][] A, int[][] flag, int[][] dp) {
        if (r >= A.length || r < 0 || c >= A[0].length || c < 0) {
            return;
        }
        int[] row = {1,-1,0,0};
        int[] col = {0,0,1,-1};
        for (int i = 0; i < 4; i++) {
            if (valid(r + row[i], A.length) && valid(c + col[i], A[0].length) && A[r][c] > A[r + row[i]][c + col[i]]) {
                if (flag[r + row[i]][c + col[i]] == 0) {
                    search(r + row[i], c + col[i], A, flag, dp);
                }
                dp[r][c] = Math.max(dp[r + row[i]][c + col[i]] + 1, dp[r][c]);
            }
        }
        flag[r][c] = 1;
        dp[r][c] = Math.max(1, dp[r][c]);
    }
    
    public boolean valid(int n, int length) {
        if (n >= 0 && n < length) {
            return true;
        }
        return false;
    }
}
