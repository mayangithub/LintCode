/**
 * 
 */
package edu.pitt.highfrequency;

import java.util.HashMap;

/**
 * 2 Sum #56 --- Accepted
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, 
 * where index1 must be less than index2. 
 * Please note that your returned answers (both index1 and index2) are NOT zero-based.
 *  Example
 * numbers=[2, 7, 11, 15], target=9
 * return [1, 2]
 * Note
 * You may assume that each input would have exactly one solution
 * Challenge
 * Either of the following solutions are acceptable:
    O(1) Space, O(nlogn) Time
    O(n) Space, O(n) Time
 * @author yanma
 * @category High Frequency
 * @version 2015-08-08
 * @class 9
 */
public class TwoSum_56 {
	/*
     * O(n) space
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        if (numbers == null || numbers.length < 2) {
            return null;
        }
        
        int[] indices = new int[2];
        HashMap<Integer, Integer> map= new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (!map.containsKey(target - numbers[i])) {
                map.put(numbers[i], i);
            } else {
                indices[0] = map.get(target - numbers[i]) + 1;
                indices[1] = i + 1;
                break;
            }
        }
        
        return indices;
    }

}
