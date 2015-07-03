/**
 * 
 */
package edu.pitt.dynamicprogrammingII;

/**
 * k Sum  #89 --- Accepted
 * Given n distinct positive integers, integer k (k <= n) and a number target.
 * Find k numbers where sum is target. Calculate how many solutions there are?
 * Example
 * Given [1,2,3,4], k = 2, target = 5.
 * There are 2 solutions: [1,4] and [2,3].
 * Return 2.
 * @author yanma
 * @category DP II, Backpack
 * @version 2015-07-03
 * @class 5
 */
public class KSum_89 {
	
	/**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
    public int kSum(int A[], int k, int target) {
        // write your code here
        /**
         * state: f[i][j][t] means in first i integers, use j integers, how many solutins there are to make the sum is t
         * function: if A[i - 1] <= t, f[i][j][t] = f[i - 1][j - 1][t - A[i - 1]] + f[i - 1][j][t]
         *           else f[i][j][t] = f[i - 1][j][t]
         * initialization: f[0][j][t] = 0, f[i][0][t] = 0, f[i][0][0] = 1
         * answer: f[A.len][k][target]
         */
         
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int len = A.length;
        int[][][] num = new int[len + 1][k + 1][target + 1];
        for (int i = 0; i <= len; i++) {
                num[i][0][0] = 1; //only when k = 0, target = 0, the cells are 1
        }
        
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= k; j++) {
                for (int t = 1; t <= target; t++) {
                    if (A[i - 1] <= t) {
                        num[i][j][t] = num[i - 1][j - 1][t - A[i - 1]] + num[i - 1][j][t];
                    } else {
                        num[i][j][t] = num[i - 1][j][t];
                    }
                }
            }
        }
        
        return num[len][k][target];
    }

}
