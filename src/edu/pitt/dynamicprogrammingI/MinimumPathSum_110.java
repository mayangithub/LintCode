/**
 * 
 */
package edu.pitt.dynamicprogrammingI;

/**
 * Minimum Path Sum #110 --- Accepted
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Example
 * Note
 * You can only move either down or right at any point in time.
 * @author yanma
 * @category DPI
 * @version 2015-06-29
 * @class 4
 */
public class MinimumPathSum_110 {
	
	/**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here
        /**
         * state: f[i][j]表示从[0,0]走到[i,j]的最短路径
         * function: f[i][j] = Math.min(f[i][j - 1], f[i - 1][j]) + grid[i][j]
         * initilization: f[0,0] = grid[0][0]
         * answer: f[m - 1][n - 1]
         */
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        int[][] path = new int[rows][cols];
        path[0][0] = grid[0][0];
        
        for (int col = 1; col < cols; col++) {
            path[0][col] = grid[0][col] + path[0][col - 1];
        }
        
        for (int row = 1; row < rows; row++) {
            path[row][0] = grid[row][0] + path[row - 1][0];
        }
        
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                path[row][col] = Math.min(path[row][col - 1], path[row - 1][col]) + grid[row][col];
            }
        }
         
        return path[rows - 1][cols - 1];
    }
	

}
