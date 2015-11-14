/**
 * 
 */
package edu.pitt.binarysearch;

/**
 * Last Position of Target #458 --- Accepted
 * Find the last position of a target number in a sorted array. Return -1 if target does not exist.
 * Example
 * Given [1, 2, 2, 4, 5, 5].
 * For target = 2, return 2.
 * For target = 5, return 5.
 * For target = 6, return -1.
 * @author yanma
 * @version 2015-11-13
 * @category Binary Search, Easy
 */
public class LastPositionofTarget_458 {
	/**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int lastPosition(int[] A, int target) {
        // Write your code here
        if (A == null || A.length == 0 || target < A[0] || target > A[A.length - 1]) {
            return -1;
        }
        
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (A[end] == target) {
            return end;
        } else if (A[start] == target) {
            return start;
        }
        
        return -1;
    }

}
