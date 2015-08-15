/**
 * 
 */
package edu.pitt.binarysearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Find Peak Element II #390 --- Accepted
 * There is an integer matrix which has the following features:
    The numbers in adjacent positions are different.
    The matrix has n rows and m columns.
    For all i < m, A[0][i] < A[1][i] && A[n - 2][i] > A[n - 1][i].
    For all j < n, A[j][0] < A[j][1] && A[j][m - 2] > A[j][m - 1].
 * We define a position P is a peek if:
 * A[j][i] > A[j+1][i] && A[j][i] > A[j-1][i] && A[j][i] > A[j][i+1] && A[j][i] > A[j][i-1]
 * Find a peak element in this matrix. Return the index of the peak.
 * Example
 * Given a matrix:
	[
	  [1 ,2 ,3 ,6 ,5],
	  [16,41,23,22,6],
	  [15,17,24,21,7],
	  [14,18,19,20,10],
	  [13,14,11,10,9]
	]
 * return index of 41 (which is [1,1]) or index of 24 (which is [2,2])
 * Note
 * The matrix may contains multiple peeks, find any of them.
 * Challenge
 * Solve it in O(n+m) time.
 * If you come up with an algorithm that you thought it is O(n log m) or O(m log n), can you prove it is actually O(n+m) or propose a similar but O(n+m) algorithm?
 * @author yanma
 * @category Binary Search
 * @version 2015-08-14
 * @class 2,3 Advanced
 * @week2 0810-0816
 */
public class FindPeakElementII_390 {
	
	/**
     * O(n * logm) : n: row number, m: col number
     * @param A: An integer matrix
     * @return: The index of the peak
     */
    public List<Integer> findPeakII2(int[][] A) {
        // write your code here
        List<Integer> result = new ArrayList<Integer>();
        if (A == null || A.length == 0 || A[0].length == 0) {
            return result;
        }
        
        for (int r = 1; r < A.length - 1; r++) {
            int start = 1;
            int end = A[0].length - 2;
            int maxcol = (start == end) ? start: -1;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (A[r][mid] > A[r][mid - 1] && A[r][mid] > A[r][mid + 1]) {
                    maxcol = mid;
                    break;
                } else if (A[r][mid] <= A[r][mid - 1]) {
                    end = mid;
                } else if (A[r][mid] <= A[r][mid + 1]) {
                    start = mid;
                }
            }
            if (maxcol == -1 && A[r][start] > A[r][end]) {
                maxcol = start;
            } else if (maxcol == -1 && A[r][start] < A[r][end]) {
                maxcol = end;
            }
            if (valid(A, r, maxcol)) {
                result.add(r);
                result.add(maxcol);
                return result;
            }
        }
        
        return result;
    }
    
    public boolean valid(int[][] A, int row, int col) {
        if (row >= 1 && A[row][col] <= A[row - 1][col]) {
            return false;
        }
        
        if (row < A.length - 1 && A[row][col] <= A[row + 1][col]) {
            return false;
        }
        
        if (col >= 1 && A[row][col] <= A[row][col - 1]) {
            return false;
        }
        
        if (col < A[0].length - 1 && A[row][col] <= A[row][col + 1]) {
            return false;
        }
        
        return true;
    }
	
	
	/**
     * O(n^2)
     * @param A: An integer matrix
     * @return: The index of the peak
     */
    public List<Integer> findPeakII1(int[][] A) {
        // write your code here
        List<Integer> result = new ArrayList<Integer>();
        if (A == null || A.length == 0 || A[0].length == 0) {
            return result;
        }
        
        for (int r = 0; r < A.length; r++) {
            for (int c = 0; c < A[0].length; c++) {
            	if (r + 1 < A.length && A[r][c] <= A[r + 1][c]) {
                    continue;
                }
                
                if (r >= 1 && A[r][c] <= A[r - 1][c]) {
                    continue;
                }
                
                if (c + 1 < A[0].length && A[r][c] <= A[r][c + 1]) {
                    continue;
                }
                
                if (c >= 1 && A[r][c] <= A[r][c - 1]) {
                    continue;
                }
                result.add(r);
                result.add(c);
                return result;
            }
        }
        
        return result;
    }

}
