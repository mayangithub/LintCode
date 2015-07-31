/**
 * 
 */
package edu.pitt.highfrequency;

/**
 * Maximum Product Subarray #191 --- Accepted
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * Example
 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.
 * @author yanma
 * @category High Frequency
 * @version 2015-07-30
 * @class 9
 */
public class MaximumProductSubarray_191 {
	
	/**
	 * O(n) time and O(1) space
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        } 
        
        int max = Integer.MIN_VALUE;
        int minpos = 1;
        int maxneg = 1;
        int pro = 1;
        
        for (int i = 0; i < nums.length; i++) {
            pro *= nums[i];
            if (pro > 0) {
                max = Math.max(pro / minpos, max);
                minpos = Math.min(minpos, pro);
            } else if (pro < 0) {
                max = Math.max(max, pro / maxneg);
                maxneg = (maxneg > 0) ? pro: Math.max(maxneg, pro);
            } else {
                max = Math.max(pro, max);
                pro = 1;
                minpos = 1;
                maxneg = 1;
            }
        }
        
        return max;
    }
    
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct1(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        } 
        
        int max = nums[0]; // max not need to be positive
        int min = nums[0]; // min not need to be negative
        int result = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int temp = max; // caution!
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(min * nums[i], temp * nums[i]), nums[i]);
            result = Math.max(result, max);
        }
        
        return result;
    }
    
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct2(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        } 
        
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        
        max[0] = nums[0]; // max not need to be positive
        min[0] = nums[0]; // min not need to be negative
        int result = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]), nums[i]);
            min[i] = Math.min(Math.min(max[i - 1] * nums[i], min[i - 1] * nums[i]), nums[i]);
            result = Math.max(result, max[i]);
        }
        
        return result;
    }

}
