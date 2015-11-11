/**
 * 
 */
package edu.pitt.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Combinations #152 --- Accepted
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * Example
 * For example,
 * If n = 4 and k = 2, a solution is:
 * [[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]
 * @author yanma
 * @category Backtracking
 * @version 2015-11-11
 */
public class Combinations_152 {
	/**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
		// write your code here
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (n < 1 || k == 0) {
		    return result;
		}
		
		helper(n, k, 1, result, new ArrayList<Integer>());
		
		return result;
    }
    
    public void helper(int n, int k, int num, List<List<Integer>> result, List<Integer> inner) {
        if (inner.size() == k) {
            result.add(new ArrayList<Integer>(inner));
            return;
        }
        if (num > n) {
            return;
        }
        
        for (int i = num; i <= n; i++) {
            inner.add(i);
            helper(n, k, i + 1, result, inner);
            inner.remove(inner.size() - 1);
        }
    }

}
