/**
 * 
 */
package edu.pitt.dynamicprogrammingI;

/**
 * Jump Game #116 --- Accepted
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index. 
 * Example
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 * @author yanma
 * @category DPI
 * @version 2015-06-29
 * @class 4
 */
public class JumpGame_116 {
	
	/**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        /**
         * state: f[i]表示从A[0]能否跳到A[i]
         * function: OR(f[j] == true && j + A[j] >= i), 0 <= j < i
         * initialization: f[0] = true
         * answer: f[n - 1], n = A.length
         */
         if (A == null) {
             return false;
         }
         
         int n = A.length;
         
         boolean[] truthtable = new boolean[n];
         truthtable[0] = true;
         
         for (int i = 1; i < n; i++) {
             int j = i - 1;
             while (j >= 0) {
                 if (!truthtable[j]) {
                     j--;
                     continue;
                 }
                 if (j + A[j] >= i) {
                     truthtable[i] = true;
                     break;
                 }
                 j--;
             }
             if (j == -1) {
                 truthtable[i] = false;
             }
         }
         
         return truthtable[n - 1];
    }
	

}
