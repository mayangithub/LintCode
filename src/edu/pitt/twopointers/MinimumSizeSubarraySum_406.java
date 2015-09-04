/**
 * 
 */
package edu.pitt.twopointers;

/**
 * Minimum Size Subarray Sum #406 --- Accepted
 * Given an array of n positive integers and a positive integer s, 
 * find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return -1 instead.
 * Example
 * Given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length under the problem constraint.
 * Challenge
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 * @author yanma
 * @category Two Pointers
 * @version 2015-09-03
 * @class 5
 * @week5 0831-0906
 */
public class MinimumSizeSubarraySum_406 {
	
	/**
	 * O(n) time
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int minSize = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = nums[start];
        while (start <= end && end < nums.length) {
            if (sum >= s) {
                minSize = Math.min(minSize, end - start + 1);
                sum -= nums[start];
                start++;
            } else {
                end++;
                if (end < nums.length) {
                    sum += nums[end];
                }
            }
        }
        
        return (minSize == Integer.MAX_VALUE) ? -1 : minSize;
    }
	/**
	 * O(n ^ 2) time
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize1(int[] nums, int s) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int minSize = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s) {
                    minSize = Math.min(minSize, j - i + 1);
                    break;
                }
            }
        }
        
        return (minSize == Integer.MAX_VALUE) ? -1 : minSize;
    }

}
