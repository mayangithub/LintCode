/**
 * 
 */
package edu.pitt.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Combination Sum II #153 --- Accepted
 * Given a collection of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * Example
 * For example, given candidate set 10,1,6,7,2,1,5 and target 8,
 * A solution set is: 
 * [1,7]
 * [1,2,5]
 * [2,6]
 * [1,1,6]
 * Note
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * @author yanma
 * @version 2015-11-11
 * @category Backtracking
 */
public class CombinationSumII_153 {
	/**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) {
            return result;
        }
        
        Arrays.sort(num);
        
        helper(num, target, 0, 0, result, new ArrayList<Integer>());
        
        return result;
    }
    
    public void helper(int[] num, int target, int sum, int index, List<List<Integer>> result, List<Integer> innerlist) {
        if (sum == target) {
            if (!result.contains(innerlist)) {
                result.add(new ArrayList<Integer>(innerlist));
            }
            return;
        }
        
        if (index == num.length || num[index] > target - sum) {
            return;
        }
        
        for (int i = index; i < num.length; i++) {
            innerlist.add(num[i]);
            sum += num[i];
            helper(num, target, sum, i + 1, result, innerlist);
            sum -= num[i];
            innerlist.remove(innerlist.size() - 1);
        }
    }

}
