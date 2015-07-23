/**
 * 
 */
package edu.pitt.highfrequency;

import java.util.ArrayList;

/**
 * Majority Number #46 --- Accepted
 * Given an array of integers, the majority number is the number 
 * that occurs more than half of the size of the array. Find it.
 * Example
 * Given [1, 1, 1, 1, 2, 2, 2], return 1
 * Challenge
 * O(n) time and O(1) extra space
 * @author yanma
 * @category High Frequency
 * @version 2015-07-22
 * @class 9
 */
public class MajorityNumber_46 {
	
	/**
	 * Moore Voting Algorithm
	 * O(n) time and O(1) space
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        
        int candidate = 0;
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (count == 0) {
                candidate = nums.get(i);
                count = 1;
            } else {
                if (nums.get(i) == candidate) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        
        return candidate;
        
    }
    
    /**
     * Brute Force O(n^2) time and O(1) space
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber1(ArrayList<Integer> nums) {
        // write your code
        
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            count = 0;
            for (int j = 0; j < nums.size(); j++) {
                if (nums.get(j) == num) {
                    count++;
                }   
            }
            if (count > nums.size() / 2) {
                return num;
            }
        }
        
        return 0;
    }

}
