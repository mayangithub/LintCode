/**
 * 
 */
package edu.pitt.dynamicprogrammingIII;

/**
 * Maximal Square #436 --- Accepted
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.
 * Example
 * For example, given the following matrix:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * Return 4.
 * @author yanma
 * @category Dynamic Programming Advanced
 * @version 2015-09-13
 * @class 5
 * @week 6 0907-0913
 */
public class MaximalSquare_436 {
	/**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = 0;
        int[][] area = new int[2][matrix[0].length];
        for (int c = 0; c < matrix[0].length; c++) {
            area[0][c] = matrix[0][c];
            max = Math.max(max, area[0][c]);
        }
        for (int r = 1; r < matrix.length; r++) {
            area[1][0] = matrix[r][0];
            for (int c = 1; c < matrix[0].length; c++) {
                if (matrix[r][c] == 0) {
                    area[1][c] = 0;
                } else {
                    area[1][c] = Math.min(Math.min(area[0][c - 1], area[0][c]), area[1][c - 1]) + 1;
                }
                max = Math.max(max, area[1][c] * area[1][c]);
            }
            for (int c = 0; c < matrix[0].length; c++) {
                area[0][c] = area[1][c];
            }
        }
        
        return max;
    }

}
