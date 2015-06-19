/**
 * 
 */
package edu.pitt.binarysearch;

/**
 * Binary Search #14 --- Accepted
 * For a given sorted array (ascending order) and a target number, 
 * find the first index of this number in O(log n) time complexity.
 * If the target number does not exist in the array, return -1.
 * Example
 * If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.
 * Challenge
 * If the count of numbers is bigger than 2^32, can your code work properly?
 * @author yanma
 * @category Binary Search
 * @version 2015-06-19
 * @class 2
 */
public class BinarySearch_14 {
	
	/**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        if (nums == null || nums.length < 1) {
            return -1;
        }
        
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                end = mid;
            } else if (target > nums[mid]) {
                start = mid;
            } else if (target < nums[mid]) {
                end = mid;
            }
        }
        if (nums[start] == target) {
            return start;
        } else if (nums[end] == target) {
            return end;
        }
        
        return -1;
    }
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
