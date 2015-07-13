/**
 * 
 */
package edu.pitt.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Combination Sum #135 --- Accepted
 * Given a set of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * For example, given candidate set 2,3,6,7 and target 7, 
 * A solution set is: 
 * [7] 
 * [2, 2, 3] 
 * Example
 * given candidate set 2,3,6,7 and target 7, 
 * A solution set is: 
 * [7] 
 * [2, 2, 3] 
 * Note
    All numbers (including target) will be positive integers.
    Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
    The solution set must not contain duplicate combinations.
 * @author yanma
 * @category Graph
 * @version 2015-07-13
 * @class 7
 */
public class CombinationSum_135 {
	
	/**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        
        helper(candidates, target, 0, result, new ArrayList<Integer>());
        
        return result;
    }
    
    public void helper(int[] candidates, int target, int start, List<List<Integer>> result, List<Integer> inner) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(inner));
            return;
        }
        
        if (target < candidates[start]) { // condition to avoid stack overflowing
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            inner.add(candidates[i]);
            helper(candidates, target - candidates[i], i, result, inner);
            inner.remove(inner.size() - 1);
        }
    }
    

}
