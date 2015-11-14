/**
 * 
 */
package edu.pitt.binarysearch;

/**
 * Classical Binary Search #457 --- Accepted
 * Find any position of a target number in a sorted array. Return -1 if target does not exist.
 * Example
 * Given [1, 2, 2, 4, 5, 5].
 * For target = 2, return 1 or 2.
 * For target = 5, return 4 or 5.
 * For target = 6, return -1.
 * Challenge
 * O(logn) time
 * @author yanma
 * @category Binary Search, Easy
 * @version 2015-11-13
 */
public class ClassicalBinarySearch_457 {
	/**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int findPosition(int[] A, int target) {
        // Write your code here
        if (A == null || A.length == 0 || target < A[0] || target > A[A.length - 1]) {
            return -1;
        }
        
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[start] == target) {
            return start;
        } else if (A[end] == target) {
            return end;
        }
        return -1;
    }

}
