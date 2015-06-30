/**
 * 
 */
package edu.pitt.dynamicprogrammingI;

/**
 * Unique Paths #114 --- Accepted
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. 
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 * Note
 * m and n will be at most 100.
 * @author yanma
 * @category DPI
 * @version 2015-06-29
 * @class 4
 */
public class UniquePaths_114 {
	
	/**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here 
        /**
         * state: f[i][j]表示从起点[0][0]走到[i][j]有多少种可能的独特路线
         * function:f[i][j] = f[i][j - 1] + f[i - 1][j]
         * initilization: f[0][0] = 1, f[0][col] = 1, f[row][0] = 1
         * answer: f[m - 1][n - 1]
         */
        if (m == 0 || n == 0) {
            return 0;
        }
        
        int[][] path = new int[m][n];
        path[0][0] = 1;
        for (int col = 1; col < n; col++) {
            path[0][col] = 1;
        }
        for (int row = 1; row < m; row++) {
            path[row][0] = 1;
        }
        
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                path[row][col] = path[row][col - 1] + path[row - 1][col];
            }
        }
        
        return path[m - 1][n - 1];
    }
	
	

}
