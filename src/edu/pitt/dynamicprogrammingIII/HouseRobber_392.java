/**
 * 
 */
package edu.pitt.dynamicprogrammingIII;

/**
 * House Robber #392 --- Accepted
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, 
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system 
 * connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * Example
 * Given [3, 8, 4], return 8.
 * Challenge
 * O(n) time and O(1) memory.
 * @author yanma
 * @category Dynamic Programming Advanced
 * @version 2015-09-08
 * @class 5
 * @week 6 0907-0913
 */
public class HouseRobber_392 {
	
	/**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            return A[0];
        } else if (A.length == 2) {
            return Math.max(A[0], A[1]);
        } else if (A.length == 3) {
            return Math.max(A[0] + A[2], A[1]);
        }
        
        long[] dp = new long[4];
        dp[0] = A[0];
        long max = dp[0];
        dp[1] = A[1];
        max = Math.max(max, dp[1]);
        dp[2] = dp[0] + A[2];
        max = Math.max(max, dp[2]);
        dp[3] = Math.max(dp[0], dp[1]) + A[3];
        max = Math.max(max, dp[3]);
        for (int i = 4; i < A.length; i++) {
            long sum = Math.max(dp[1], dp[2]) + A[i];
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = dp[3];
            dp[3] = sum;
            max = Math.max(max, dp[3]);
        }
        
        return max;
    }

}
