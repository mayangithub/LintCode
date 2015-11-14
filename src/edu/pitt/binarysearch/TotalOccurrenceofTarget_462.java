/**
 * 
 */
package edu.pitt.binarysearch;

/**
 * Total Occurrence of Target #462 --- Accepted
 * Given a target number and an integer array sorted in ascending order. 
 * Find the total number of occurrences of target in the array.
 * Example
 * Given [1, 3, 3, 4, 5] and target = 3, return 2.
 * Given [2, 2, 3, 4, 6] and target = 4, return 1.
 * Given [1, 2, 3, 4, 5] and target = 6, return 0.
 * Challenge
 * Time complexity in O(logn)
 * @author yanma
 * @version 2015-11-13
 * @category Binary Search, Easy
 */
public class TotalOccurrenceofTarget_462 {
	/**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int totalOccurrence(int[] A, int target) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int len = A.length;
        if (target < A[0] || target > A[len - 1]) {
            return 0;
        }
        
        int first = findFirst(A, target);
        int last = findLast(A, target);
        
        return last - first + 1;
    }
    
    public int findFirst(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int start = 0;
        int end = A.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (A[start] == target) {
            return start;
        }
        return end;
    }
    
    public int findLast(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int start = 0;
        int end = A.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (A[end] == target) {
            return end;
        }
        return start;
    }
}
