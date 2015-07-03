/**
 * 
 */
package edu.pitt.dynamicprogrammingII;

import java.util.ArrayList;

/**
 * Minimum Adjustment Cost #91 --- Accepted
 * Given an integer array, adjust each integers so that the difference of every adjacent integers are not greater than a given number target.
 * If the array before adjustment is A, the array after adjustment is B, you should minimize the sum of |A[i]-B[i]|
 * Example
 * Given [1,4,2,3] and target = 1, one of the solutions is [2,3,2,3], the adjustment cost is 2 and it's minimal.
 * Return 2.
 * Note
 * You can assume each number in the array is a positive integer and not greater than 100.
 * @author yanma
 * @category DP II
 * @version 2015-07-03
 * @class 5
 */
public class MinimumAdjustmentCost_91 {
	
	/**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        /**
         * state: f[i][j] means first i letters, the minimum cost to change the ith letter to make the array meet the condition
         * function: 1 <= j + 1 <= 100, A[i - 1] - target <= A[i - 2] <= A[i - 1] + target
         *           f[i][j] = MIN{f[i - 1][A[i - 2]] + |A[i] - (j + 1)|}
         * initialization: f[A.len][100], f[0][j] = |j - A[0]|, f[i][j] = MAX_VALUE
         * answer: MIN(f[A.len][j])
         */
        if (A == null || A.size() <= 1) {
            return 0;
        }
        
        int size = A.size();
        int[][] adjust = new int[size][101];
        
        for (int i = 0; i <= 100; i++) {
            adjust[0][i] = Math.abs(i - A.get(0)); //first letter adjustment cost
        }
        
        for (int i = 1; i < size; i++) {
            for (int j = 0; j <= 100; j++) {
                adjust[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k <= 100; k++) { // k means A[i - 2], the number before ith number
                    if (Math.abs(j - k) <= target) {
                        adjust[i][j] = Math.min(adjust[i][j], adjust[i - 1][k] + Math.abs(j - A.get(i)));
                    }
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= 100; i++) {
            min = Math.min(min, adjust[size - 1][i]);
        } 
        return min;
    }

}
