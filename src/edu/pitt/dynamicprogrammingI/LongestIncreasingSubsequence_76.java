/**
 * 
 */
package edu.pitt.dynamicprogrammingI;

/**
 * Longest Increasing Subsequence  #76 --- Accepted
 * Given a sequence of integers, find the longest increasing subsequence (LIS).
 * Example
 * For [5, 4, 1, 2, 3], the LIS  is [1, 2, 3], return 3
 * For [4, 2, 4, 5, 3, 7], the LIS is [4, 4, 5, 7], return 4
 * Challenge
 * Time complexity O(n^2) or O(nlogn)
 * Clarification
 * What's the definition of longest increasing subsequence?
    * The longest increasing subsequence problem is to find a subsequence of a given sequence in which the 
    * subsequence's elements are in sorted order, lowest to highest, and in which the subsequence is as long as possible. 
    * This subsequence is not necessarily contiguous, or unique.  
    * https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
 * @author yanma
 * @category DPI
 * @version 2015-06-30
 * @class 4
 */
public class LongestIncreasingSubsequence_76 {
	
	/**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        /**
         * 表示状态：以nums[i]作为最后一个数的升序序列的最长长度 
         * state: f[i] means the longest increasing subsequence which has nums[i] as the last element
         * function: MAX{f[j] + 1}, 0 <= j <= i - 1 and nums[j] <= nums[i], nums[i] can be added to ascending sequence
         * initialization: f[i] = 1
         * answer: MAX{f[0] ..... f[n]}
         */
        
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        int[] length = new int[n];
        
        for (int i = 0; i < n; i++) {
            length[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] <= nums[i]) {
                    length[i] = Math.max(length[i], length[j] + 1);
                }
            }
        }
        
        int max = 1;
        for (int len: length) {
            max = Math.max(max, len);
        }
        return max;
    }
	
	

}
