/**
 * 
 */
package edu.pitt.highfrequency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 4 Sum #58 --- Accepted
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
 * Find all unique quadruplets in the array which gives the sum of target.
 *  Example
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0. A solution set is:
 * (-1, 0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2, 0, 0, 2)
 * Note
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * @author yanma
 *
 */
public class FourSum_58 {
	/**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {   
        //write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (numbers == null || numbers.length < 4) {
            return result;
        }
        
        Arrays.sort(numbers);
        HashMap<Integer, ArrayList<int[]>> map = new HashMap<Integer, ArrayList<int[]>>(); //key: 2 sum, value: index pair list
        
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                if (!map.containsKey(sum)) {
                    ArrayList<int[]> list = new ArrayList<int[]>();
                    int[] pair = new int[2];
                    pair[0] = i;
                    pair[1] = j;
                    list.add(pair);
                    map.put(sum, list);
                } else {
                    int[] pair = new int[2];
                    pair[0] = i;
                    pair[1] = j;
                    map.get(sum).add(pair);
                }
            }
        }
        
        for (int i = 0; i < numbers.length - 3; i++) {
            for (int j = i + 1; j < numbers.length - 2; j++) {
                int sum = numbers[i] + numbers[j];
                if (map.containsKey(target - sum)) {
                    ArrayList<int[]> list = map.get(target - sum);
                    for (int[] pair: list) {
                        if (pair[0] > j) {
                            ArrayList<Integer> inner = new ArrayList<Integer>();
                            inner.add(numbers[i]);
                            inner.add(numbers[j]);
                            inner.add(numbers[pair[0]]);
                            inner.add(numbers[pair[1]]);
                            if (!result.contains(inner)) {
                                result.add(inner);
                            }
                        }
                    }
                }
                while (j + 1 < numbers.length && numbers[j + 1] == numbers[j]) {
                    j++;
                }
            }
            while (i + 1 < numbers.length && numbers[i + 1] == numbers[i]) {
                i++;
            }
        }
        
        return result;
    }

}
