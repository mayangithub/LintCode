/**
 * 
 */
package edu.pitt.twopointers;

import java.util.Arrays;

/**
 * Two Sum II #443 --- Accepted
 * Given an array of integers, 
 * find how many pairs in the array such that their sum is bigger than a specific target number. 
 * Please return the number of pairs.
 * Example
 * numbers=[2, 7, 11, 15], target=24
 * return 1
 * Challenge
 * Either of the following solutions are acceptable:
 * O(1) Space, O(nlogn) Time
 * @author yanma
 * @version 2015-11-06
 * @category Two Pointers
 * 
 */
public class TwoSumII_443 {
	/**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length < 2) {
            return 0;
        }
        
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int pairs = 0;
        while (i < j) {
            if (nums[i] + nums[j] <= target) {
                i++;
            } else {
                pairs += j - i;
                j--;
            }
        }
        
        return pairs;
    }

}
