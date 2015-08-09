/**
 * 
 */
package edu.pitt.highfrequency;

import java.util.ArrayList;

/**
 * Maximum Subarray Difference #45 --- Accepted
 * Given an array with integers.
 * Find two non-overlapping subarrays A and B, which |SUM(A) - SUM(B)| is the largest.
 * Return the largest difference.
 *  Example
 * For [1, 2, -3, 1], return 6
 * Note
 * The subarray should contain at least one number
 * Challenge
 * O(n) time and O(n) space.
 * @author yanma
 * @category High Frequency
 * @version 2015-08-08
 * @class 9
 */
public class MaximumSubarrayDifference_45 {
	/**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        int size = nums.size();
        int[] leftmax = new int[size];
        leftmax[0] = nums.get(0);
        int[] leftmin = new int[size];
        leftmin[0] = nums.get(0);
        int[] rightmin = new int[size];
        rightmin[size - 1] = nums.get(size - 1);
        int[] rightmax = new int[size];
        rightmax[size - 1] = nums.get(size - 1);
        
        for (int i = 1; i < size; i++) {
            leftmax[i] = Math.max(leftmax[i - 1] + nums.get(i),nums.get(i));
            leftmin[i] = Math.min(leftmin[i - 1] + nums.get(i),nums.get(i));
        }
        
        for (int i = size - 2; i >= 0; i--) {
            rightmax[i] = Math.max(rightmax[i + 1] + nums.get(i),nums.get(i));
            rightmin[i] = Math.min(rightmin[i + 1] + nums.get(i),nums.get(i));
        }
        
        int maxgap = 0;
        
        for (int i = 0; i < size - 1; i++) {
            maxgap = Math.max(maxgap, Math.abs(leftmax[i] - rightmin[i + 1])); // to make non-overlapping
            maxgap = Math.max(maxgap, Math.abs(rightmax[i + 1] - leftmin[i]));
        }
        
        return maxgap;
    }
    
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays1(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        int size = nums.size();
        int[] leftmax = new int[size];
        int[] leftmin = new int[size];
        int[] rightmin = new int[size];
        int[] rightmax = new int[size];
    
        int sum = 0;
        int minSum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            leftmax[i] = max;
            minSum = Math.min(minSum, sum);
        }
        
        sum = 0;
        int maxSum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            sum += nums.get(i);
            min = Math.min(min, sum - maxSum);
            leftmin[i] = min;
            maxSum = Math.max(maxSum, sum);
        }
        
        
        sum = 0;
        minSum = 0;
        max = Integer.MIN_VALUE;
        for (int i = size - 1; i >= 0; i--) {
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            rightmax[i] = max;
            minSum = Math.min(minSum, sum);
        }
        
        sum = 0;
        maxSum = 0;
        min = Integer.MAX_VALUE;
        for (int i = size - 1; i >= 0; i--) {
            sum += nums.get(i);
            min = Math.min(min, sum - maxSum);
            rightmin[i] = min;
            maxSum = Math.max(maxSum, sum);
        }
        
        int maxgap = 0;
        
        for (int i = 0; i < size - 1; i++) {
            maxgap = Math.max(maxgap, Math.abs(leftmax[i] - rightmin[i + 1]));
            maxgap = Math.max(maxgap, Math.abs(rightmax[i + 1] - leftmin[i]));
        }
        
        return maxgap;
    }

}
