/**
 * 
 */
package edu.pitt.highfrequency;

import java.util.ArrayList;

/**
 * Maximum Subarray #41 --- Accepted
 * Given an array of integers, find a contiguous subarray which has the largest sum.
 * Example
 * Given the array [−2,2,−3,4,−1,2,1,−5,3], the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * Note
 * The subarray should contain at least one number.
 * Challenge
 * Can you do it in time complexity O(n)?
 * @author yanma
 * @category High Frequency
 * @version 2015-07-28
 * @class 9
 */
public class MaximumSubarray_41 {
	
	/**
	 * O(n) time and O(1) space
	 * sum[i...j] = sum[j] - sum[i - 1]
	 * sum[j] - min(sum[0,.., j - 1])
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray2(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int minsum = 0;
        
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
            max = Math.max(max, sum - minsum);
            minsum = Math.min(minsum, sum);
        }
        
        return max;
        
    }
    
    /**
     * O(n) time and O(1) space
     * using local and global
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray3(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        
        int global = Integer.MIN_VALUE;
        int local = 0;
        for (int i = 0; i < nums.size(); i++) {
            local = Math.max(nums.get(i),local + nums.get(i));
            global = Math.max(global, local);
        }
        
        return global;
    }
	
	
	
	/**
	 * using O(n^2 + n) time and O(n) space
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray1(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        
        int[] sums = new int[nums.size() + 1];
        sums[0] = 0;
        for (int i = 0; i < nums.size(); i++) {
            sums[i + 1] = sums[i] + nums.get(i);
        }
        
        int max = nums.get(0);
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j <= nums.size(); j++) {
                max = Math.max(max, sums[j] - sums[i]);
            }
        }
        
        return max;
    }
    
    /**
     * Accepted but hard to remember
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        
        int maxsum = nums.get(0);
        int minsum = Math.min(0, nums.get(0));
        int max = nums.get(0);
        int sum = nums.get(0);
        
        for (int i = 1; i < nums.size(); i++) {
            sum += nums.get(i); 
            if (sum < minsum) {
                minsum = sum;
                maxsum = sum;
            } else if (sum > maxsum) {
                maxsum = sum;
                max = Math.max(max, maxsum - minsum);
            }
        }
        
        return max;
    }

}
