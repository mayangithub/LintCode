/**
 * 
 */
package edu.pitt.highfrequency;

import java.util.ArrayList;

/**
 * Minimum Subarray #44 --- Accepted
 * Given an array of integers, find the subarray with smallest sum.
 * Return the sum of the subarray.
 * Example
 * For [1, -1, -2, 1], return -3
 * Note
 * The subarray should contain at least one integer.
 * @author yanma
 * @category High Frequency
 * @version 2015-07-29
 * @class 9
 */
public class MinimumSubarray_44 {
	
	/**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        
        int global = Integer.MAX_VALUE;
        int local = 0;
        for (int i = 0; i < nums.size(); i++) {
            local = Math.min(nums.get(i), local + nums.get(i));
            global = Math.min(global, local);
        }
        
        return global;
    }
    
    
    /**
     * O(n) time and O(1) space
     * sum[i...j] = sum[0...j] - sum[0...i - 1]
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray1(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int maxsum = 0;
        
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
            min = Math.min(min, sum - maxsum);
            maxsum = Math.max(maxsum, sum);
        }
        
        return min;
    }

}
