/**
 * 
 */
package edu.pitt.highfrequency;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Majority Number III #48 --- Accepted
 * Given an array of integers and a number k, the majority number is the number that occurs more than 1/k of the size of the array.
 * Find it.
 *  Example
 * Given [3,1,2,3,2,3,3,4,4,4] and k=3, return 3.
 * Note
 * There is only one majority number in the array.
 * Challenge
 * O(n) time and O(k) extra space
 * @author yanma
 * @category High Frequency
 * @version 2015-08-08
 * @class 9
 */
public class MajorityNumberIII_48 {
	/**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int threshold = nums.size() / k;
        for (int i = 0; i < nums.size(); i++) {
            if (!map.containsKey(nums.get(i))) {
                map.put(nums.get(i), 1);
                if (threshold < 1) {
                    return nums.get(i);
                }
            } else {
                map.put(nums.get(i), map.get(nums.get(i)) + 1);
                if (map.get(nums.get(i)) > threshold) {
                    return nums.get(i);
                }
            }
        }
        
        return 0;
    }

}
