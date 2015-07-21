/**
 * 
 */
package edu.pitt.highfrequency;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Subarray Sum #138 --- Accepted
 * Given an integer array, find a subarray where the sum of numbers is zero. 
 * Your code should return the index of the first number and the index of the last number.
 * Example
 * Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].
 * Note
 * There is at least one subarray that it's sum equals to zero.
 * @author yanma
 * @category High Frequency
 * @version 2015-07-21
 * @class 9
 */
public class SubarraySum_138 {
	
	/**
	 * O(n) time and O(n) space
	 * f[i][j] 前i个数之和， 前j个数之和，sum[i] = sum[j] => sum[i, j] = 0
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0; 
        map.put(0, 0); // key: sum, value: first key numbers
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!map.containsKey(sum)) {
                map.put(sum, i + 1);
                continue;
            }
            
            result.add(map.get(sum));
            result.add(i);
            break;
        }
        
        return result;
    }
	
	
	/**
	 * O(n^2) time
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum1(int[] nums) {
        // write your code here
        // brute force
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        for (int start = 0; start < nums.length; start++) {
            int sum = nums[start];
            if (sum == 0) {
                result.add(start);
                result.add(start);
                break;
            }
            for (int end = start + 1; end < nums.length; end++) {
                sum += nums[end];
                if (sum == 0) {
                    result.add(start);
                    result.add(end);
                    return result;
                }
            }
        }
        
        return result;
    }

}
