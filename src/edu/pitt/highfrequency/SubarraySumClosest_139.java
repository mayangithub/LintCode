/**
 * 
 */
package edu.pitt.highfrequency;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Subarray Sum Closest #139 --- Accepted
 * Given an integer array, find a subarray with sum closest to zero. 
 * Return the indexes of the first number and last number.
 *  Example
 * Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4]
 * Challenge
 * O(nlogn) time
 * @author yanma
 * @category High Frequency
 * @version 2015-08-08
 * @class 9
 */
public class SubarraySumClosest_139 {
	/**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySumClosest(int[] nums) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return result;
        } else if (nums.length == 1) {
            result.add(0);
            result.add(0);
            return result;
        }
        
        int[] sums = new int[nums.length + 1];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int min = Integer.MAX_VALUE;
        sums[0] = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
            if (map.containsKey(sums[i + 1])) {
                result.clear();
                result.add(map.get(sums[i + 1]) + 1);
                result.add(i);
                return result;
            } 
            
            map.put(sums[i + 1], i);
            
            int step = 1;
            while (step <= min) {
                if (map.containsKey(sums[i + 1] - step)) {
                    min = step;
                    result.clear();
                    result.add(map.get(sums[i + 1] - step) + 1);
                    result.add(i);
                    break;
                } else if (map.containsKey(sums[i + 1] + step)) {
                    min = step;
                    result.clear();
                    result.add(map.get(sums[i + 1] + step) + 1);
                    result.add(i);
                    break;
                }
                step++;
            }
        }
        
        return result;
    }

}
