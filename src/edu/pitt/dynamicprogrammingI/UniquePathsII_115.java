/**
 * 
 */
package edu.pitt.dynamicprogrammingI;

/**
 * Unique Paths II #115 --- Accepted
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * Example
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * [
	  [0,0,0],
	  [0,1,0],
	  [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * Note
 * m and n will be at most 100.
 * @author yanma
 * @category DPI
 * @version 2015-06-29
 * @class 4
 */
public class UniquePathsII_115 {

	/**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        /**
         * state: f[i][j]表示从[0][0]到[i][j]的独特路径数
         * function: f[i][j] = f[i][j - 1] + f[i - 1][j], 如果grid[i][j] == 1, f[i][j] = 0
         * initialization: f[0][0] = 1 || 0, f[0][col] = f[0][col - 1] || 0, f[row][0] = f[row - 1][0] || 0
         * answer: f[m - 1][n - 1]
         */
        if (obstacleGrid == null) {
            return 0;
        }
        
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        
        if (rows == 0 || cols == 0) {
           return 0; 
        }
        
        int[][] path = new int[rows][cols];
        path[0][0] = (obstacleGrid[0][0] == 1) ? 0: 1; //make sure to initialize first cell individually
        for (int col = 1; col < cols; col++) {
            if (obstacleGrid[0][col] == 1) {
                path[0][col] = 0;
            } else {
                path[0][col] = path[0][col - 1];
            }
        }
        
        for (int row = 1; row < rows; row++) {
            if (obstacleGrid[row][0] == 1) {
                path[row][0] = 0;
            } else {
                path[row][0] = path[row - 1][0];
            }
        }
        
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                if (obstacleGrid[row][col] == 1) {
                    path[row][col] = 0;
                } else {
                    path[row][col] = path[row - 1][col] + path[row][col - 1];
                }
            }
        }
        
        return path[rows - 1][cols - 1];
    }
	
}
