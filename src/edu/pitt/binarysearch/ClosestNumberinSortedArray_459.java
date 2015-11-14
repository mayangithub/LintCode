/**
 * 
 */
package edu.pitt.binarysearch;

/**
 * Closest Number in Sorted Array #459 --- Accepted
 * Given a target number and an integer array A sorted in ascending order, 
 * find the index i in A such that A[i] is closest to the given target.
 * Return -1 if there is no element in the array.
 * Example
 * Given [1, 2, 3] and target = 2, return 1.
 * Given [1, 4, 6] and target = 3, return 1.
 * Given [1, 4, 6] and target = 5, return 1 or 2.
 * Given [1, 3, 3, 4] and target = 2, return 0 or 1 or 2.
 * Note
 * There can be duplicate elements in the array, and we can return any of the indices with same value.
 * Challenge
 * O(logn) time complexity.
 * @author yanma
 * @category Binary Search, Easy
 * @version 2015-11-13
 */
public class ClosestNumberinSortedArray_459 {
	/**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int closestNumber(int[] A, int target) {
        // Write your code here
        if (A == null || A.length == 0) {
            return -1;
        }
        
        int len = A.length; 
        int start = 0; 
        int end = len - 1;
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
        
        if (Math.abs(A[start] - target) < Math.abs(A[end] - target)) {
            return start;
        }
        return end;
    }

}
