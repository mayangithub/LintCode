/**
 * 
 */
package edu.pitt.highfrequency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 3 Sum #57 --- Accepted
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 *  Example
 * For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 * Note
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * @author yanma
 * @category High Frequency
 * @version 2015-08-08
 * @class 9
 */
public class ThreeSum_57 {
	/**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (numbers == null || numbers.length < 3) {
            return result;
        }
        
        Arrays.sort(numbers);
        
        for (int i = 0; i < numbers.length; i++) {
            ArrayList<Integer> inner = new ArrayList<Integer>();
            inner.add(numbers[i]);
            helper(numbers, -numbers[i], i + 1, numbers.length, result, inner);
        }
        
        return result;
    }
    
    public void helper(int[] numbers, int target, int start, int end, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> inner) {
        if (start >= numbers.length) {
            return;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = start; i < numbers.length; i++) {
            if (!map.containsKey(target - numbers[i])) {
                map.put(numbers[i], i);
            } else {
                inner.add(target - numbers[i]);
                inner.add(numbers[i]);
                if (!result.contains(inner)) {
                    result.add(new ArrayList<Integer>(inner));
                }
                inner.remove(inner.size() - 1);
                inner.remove(inner.size() - 1);
            }
        }
        
        
    }
    
    
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum1(int[] numbers) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (numbers == null || numbers.length < 3) {
            return result;
        }
        
        Arrays.sort(numbers);
        
        for (int i = 0; i < numbers.length; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int target = -numbers[i];
            int start = i + 1;
            int end = numbers.length - 1;
            while (start < end) {
                int sum = numbers[start] + numbers[end];
                if (sum == target) {
                    ArrayList<Integer> inner = new ArrayList<Integer>();
                    inner.add(numbers[i]);
                    inner.add(numbers[start]);
                    inner.add(numbers[end]);
                    result.add(inner);
                    start++; end--;
                    while (start < end && numbers[start] == numbers[start - 1]) { // limit condition
                        start++;
                    }
                    while (start < end && numbers[end] == numbers[end + 1]) {
                        end--;
                    }
                } else if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                }
            }
        }
        
        return result;
    }

}
