/**
 * 
 */
package edu.pitt.highfrequency;

import java.util.ArrayList;

/**
 * Majority Number II #47 --- Accepted
 * Given an array of integers, the majority number is the number that occurs more than 1/3 of the size of the array.
 * Find it.
 *  Example
 * Given [1, 2, 1, 2, 1, 3, 3], return 1.
 * Note
 * There is only one majority number in the array.
 * Challenge
 * O(n) time and O(1) extra space.
 * @author yanma
 * @version 2015-08-08
 * @category High Frequency
 * @class 9
 */
public class MajorityNumberII_47 {
	
	/**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        
        int candidate1 = 0;
        int candidate2 = 0;
        int count1 = 0;
        int count2 = 0;
        
        for (int i = 0; i < nums.size(); i++) {
            if (count1 == 0) {
                candidate1 = nums.get(i);
                count1 = 1;
            } else if (nums.get(i) != candidate1 && count2 == 0) {
                candidate2 = nums.get(i);
                count2 = 1;
            } else {
                if (nums.get(i) == candidate1) {
                    count1++;
                } else if (nums.get(i) == candidate2) {
                    count2++;
                } else {
                    count1--;
                    count2--;
                }
            }
        }
        
        count1 = 0;
        count2 = 0;
        
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == candidate1) {
                count1++;
            } else if (nums.get(i) == candidate2) {
                count2++;
            }
        }
        
        return count1 > count2? candidate1: candidate2;
    }

}
