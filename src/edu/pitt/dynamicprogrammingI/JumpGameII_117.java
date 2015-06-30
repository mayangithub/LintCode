/**
 * 
 */
package edu.pitt.dynamicprogrammingI;

/**
 * Jump Game II #117 --- Accepted
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps. 
 * Example
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. 
 * (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * @author yanma
 * @category DPI
 * @version 2015-06-29
 * @class 4
 */
public class JumpGameII_117 {
	
	/**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        /**
         * state: f[i]表示从A[0]跳到f[i]最少跳几步
         * function: 跳不到存0, j == 0, A[j] >= i; j > 0, f[j] != 0 && j + A[j] >= i, 
         *           f[i] = (f[i] == 0) ? f[j] + 1 : MIN(f[j] + 1, f[i]),   0 <= j < i
         * initialization: f[0] = 0; 
         * answer: f[A.length - 1]
         */
         if (A == null) {
             return 0;
         }
         
         int n = A.length;
         int[] jumps = new int[n];
         jumps[0] = 0;
         for (int i = 1; i < n; i++) {
             for (int j = i - 1; j >= 0; j--) {
                 if ((jumps[j] > 0 && j + A[j] >= i) || (j == 0 && A[j] >= i)) {
                     jumps[i] = (jumps[i] == 0) ? jumps[j] + 1: Math.min(jumps[i], jumps[j] + 1);
                 }
             }
         }
         return jumps[n - 1];
    }
	
	

}
