/**
 * 
 */
package edu.pitt.dynamicprogrammingI;

/**
 * Climbing Stairs #111 --- Accepted
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Example
 * Given an example n=3 , 1+1+1=2+1=1+2=3
 * return 3
 * @author yanma
 * @category DPI
 * @version 2015-06-29
 * @class 4
 */
public class ClimbingStairs_111 {

	/**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        /**
         * state: f[i]表示到达i有多少种不同的方式
         * function: f[i] = f[i - 1] + f[f - 2]
         * initialization: f[0] = 1, f[1] = 1
         * answer: f[n]
         */
         if (n <= 1) {
             return 1;
         }
         
         int[] ways = new int[n + 1];
         ways[0] = 1;
         ways[1] = 1;
         
         for (int i = 2; i <= n; i++) {
             ways[i] = ways[i - 1] + ways[i - 2];
         }
         return ways[n];
    }
}
