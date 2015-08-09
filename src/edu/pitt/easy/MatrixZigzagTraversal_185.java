/**
 * 
 */
package edu.pitt.easy;

/**
 * Matrix Zigzag Traversal #185 --- Accepted
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in ZigZag-order.
 *  Example
 * Given a matrix:
	[
	  [1, 2,  3,  4],
	  [5, 6,  7,  8],
	  [9,10, 11, 12]
	]
 * return [1, 2, 5, 9, 6, 3, 4, 7, 10, 11, 8, 12]
 * @author yanma
 * @category Easy Level
 * @version 2015-08-09
 * @week1 0803-0809
 */
public class MatrixZigzagTraversal_185 {
	/**
     * @param matrix: a matrix of integers
     * @return: an array of integers
     */ 
    public int[] printZMatrix(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] traversal = new int[rows * cols];
        traversal[0] = matrix[0][0];
        int sum = rows + cols - 2;
        boolean flag = false; //descend
        int line = 1;
        int index = 1;
        while (line <= sum) {
            if (flag) {
                int row = line;
                while (row >= 0) {
                    if (line - row < cols  && row < rows) {
                        traversal[index] = matrix[row][line - row];
                        index++;
                    }
                    row--;
                }
                flag = false; // ascend
            } else {
                int col = line;
                while (col >= 0) {
                    if (line - col < rows && col < cols) {
                        traversal[index] = matrix[line - col][col];
                        index++;
                    }
                    col--;
                }
                
                flag = true;
            }
            line++;
        }
        
        return traversal;
    }

}
