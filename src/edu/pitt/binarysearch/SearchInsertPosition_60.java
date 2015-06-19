/**
 * 
 */
package edu.pitt.binarysearch;

/**
 * Search Insert Position #60 --- accepted
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * You may assume NO duplicates in the array.
 * Example
 * 	[1,3,5,6], 5 → 2
 * 	[1,3,5,6], 2 → 1
 * 	[1,3,5,6], 7 → 4
 * 	[1,3,5,6], 0 → 0
 * Challenge
 * 	O(log(n)) time
 * @author yanma
 * @category Binary Search
 * @version 2015-06-19
 * @class 2
 */
public class SearchInsertPosition_60 {
	
	/** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        } else if (target < A[0]) {
            return 0;
        } else if (target > A[A.length - 1]) {
            return A.length;
        }
        
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                start = mid;
            } else if (A[mid] > target) {
                end = mid;
            }
        }
        
        if (A[start] == target) {
            return start;
        } else {
            return end;
        } 
    }
	
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
