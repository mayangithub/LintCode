/**
 * 
 */
package edu.pitt.binarysearch;

/**
 * Search a 2D Matrix #28 --- Accepted
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 *     Integers in each row are sorted from left to right.
 *     The first integer of each row is greater than the last integer of the previous row.
 * Example
 * Consider the following matrix:
 * [
    [1, 3, 5, 7],
    [10, 11, 16, 20],
    [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 * Challenge
 * O(log(n) + log(m)) time
 * @author yanma
 * @category Binary Search
 * @version 2015-06-19
 * @class 2
 */
public class Searcha2DMatrix_28 {

	/**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[rows - 1][cols - 1]) {
            return false;
        }
        
        int start = 0;
        int end = rows - 1;
        //find the row
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][cols - 1] == target) {
                return true;
            } else if (matrix[mid][cols - 1] > target) {
                end = mid;
            } else if (matrix[mid][cols - 1] < target) {
                start = mid;
            }
        }
        
        int row = 0;
        if (target >= matrix[start][0] && target <= matrix[start][cols - 1]) {
            row = start;
        } else if (target >= matrix[end][0] && target <= matrix[end][cols - 1]) {
            row = end;
        } else {
            return false;
        }
        
        //find the col
        start = 0;
        end = cols - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                end = mid;
            } else if (matrix[row][mid] < target) {
                start = mid;
            }
        }
        
        if (matrix[row][start] == target || matrix[row][end] == target) {
            return true;
        }
        return false;
    }

}
