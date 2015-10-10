/**
 * 
 */
package edu.pitt.followupI;

import java.util.PriorityQueue;

/**
 * Kth Smallest Number in Sorted Matrix #401 --- Accepted
 * Find the kth smallest number in at row and column sorted matrix.
 * Example
 * Given k = 4 and a matrix:
 * [
 *   [1 ,5 ,7],
 *   [3 ,7 ,8],
 *   [4 ,8 ,9],
 * ]
 * return 5
 * Challenge
 * O(k log n), n is the maximal number in width and height.
 * @author yanma
 * @version 2015-10-09
 * @category Follow Up I
 * @week 10 1005-1011
 */
public class KthSmallestNumberinSortedMatrix_401 {
	
	/**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (rows * cols < k) {
            return 0;
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        insert(heap, matrix, k);
        
        int index = 1;
        while (index < k) {
            heap.poll();
            index++;
        }
        
        return heap.poll();
    }
    
    public void insert(PriorityQueue<Integer> heap, int[][] matrix, int k) {
        for (int r = 0; r < matrix.length; r++) {
            int c = Math.min(matrix[0].length, k);
            for (int co = 0; co < c; co++) {
                heap.offer(matrix[r][co]);
            }
        }
    }

}
