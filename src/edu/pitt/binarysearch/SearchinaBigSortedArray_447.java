/**
 * 
 */
package edu.pitt.binarysearch;

/**
 * Search in a Big Sorted Array #447 --- Accepted
 * Given a big sorted array, find the first index of a target number. 
 * Your algorithm should be in O(log k), where k is the first index of the target number.
 * Return -1, if the number doesn't exist in the array.
 * Example
 * Given [1, 3, 6, 9, 21], and target = 3, return 1.
 * Given [1, 3, 6, 9, 21], and target = 4, return -1.
 * Challenge
 * O(log k), k is the first index of the given target number.
 * @author yanma
 * @version 2015-10-05
 * @week 10 1015-1011
 */
public class SearchinaBigSortedArray_447 {
	/**
     * @param A: An integer array
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        } else if (target < A[0] || target > A[A.length - 1]) {
            return -1;
        }
        
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (A[mid] >= target) {
                end = mid;
            } else {
                start = mid;
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
