/**
 * 
 */
package edu.pitt.graph;

import java.util.ArrayList;

/**
 * k Sum II #90 --- Accepted
 * Given n unique integers, number k (1<=k<=n)  and target. Find all possible k integers where their sum is target.
 * Example
 * Given [1,2,3,4], k=2, target=5, [1,4] and [2,3] are possible solutions.
 * @author yanma
 * @category Graph and Search
 * @version 2015-07-16
 * @class 7
 */
public class KSumII_90 {
	
	/**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return a list of lists of integer 
     */ 
    public ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (A == null) {
            return result;
        }
        
        helper(A, k, target, 0, result, new ArrayList<Integer>());
        
        return result;
    }
    
    public void helper(int[] A, int k, int target, int start, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> inner) {
        if (target == 0 && inner.size() == k) {
            result.add(new ArrayList<Integer>(inner));
            return;
        }
        
        for (int i = start; i < A.length; i++) {
            inner.add(A[i]);
            helper(A, k, target - A[i], i + 1, result, inner);
            inner.remove(inner.size() - 1);
        }
    }

}
