/**
 * 
 */
package edu.pitt.binarysearch;

/**
 * Search a 2D Matrix II #38 --- Accepted @note: need better solution
 * Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.
 * This matrix has the following properties:
    * Integers in each row are sorted from left to right.
    * Integers in each column are sorted from up to bottom.
    * No duplicate integers in each row or column.
 *  Example
 * Consider the following matrix:
 * [
    [1, 3, 5, 7],
    [2, 4, 7, 8],
    [3, 5, 9, 10]
 * ]
 * Given target = 3, return 2.
 * Challenge
 * O(m+n) time and O(1) extra space
 * @author yanma
 * @category Binary Search
 * @version 2015-06-19
 * @class 2
 */
public class Searcha2DMatrixII_38 {
	/**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[rows - 1][cols - 1]) {
            return 0;
        }
        int count = 0;
        for (int r = 0; r < rows; r++) {
            if (target >= matrix[r][0] && target <= matrix[r][cols - 1]) {
                count += findInrow(matrix, target, r);
            }
        }

        return count;
    }
    
    public int findInrow(int[][] matrix, int target, int row) {
        int left = 0;
        int right = matrix[0].length - 1;
        int start = 0;
        int end = right;
        //find left bound
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[row][mid] == target) {
                end = mid;
            } else if (matrix[row][mid] > target) {
                end = mid; 
            } else if (matrix[row][mid] < target) {
                start = mid;
            }
        }
        if (matrix[row][start] == target) {
            left = start;
        } else {
            left = end;
        }
        
        //find right bound
        start = 0;
        end = matrix[0].length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[row][mid] == target) {
                start = mid;
            } else if (matrix[row][mid] > target) {
                end = mid; 
            } else if (matrix[row][mid] < target) {
                start = mid;
            }
        }
        if (matrix[row][end] == target) {
            right = end;
        } else {
            right = start;
        }
        
        return right - left + 1;
    }
}
