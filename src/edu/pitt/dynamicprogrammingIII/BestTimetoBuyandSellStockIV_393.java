/**
 * 
 */
package edu.pitt.dynamicprogrammingIII;

/**
 * Best Time to Buy and Sell Stock IV #393 --- Accepted
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * Example
 * Given prices = [4,4,6,1,1,4,2,5], and k = 2, return 6.
 * Note
 * You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 * Challenge
 * O(nk) time.
 * @author yanma
 * @version 2015-10-01
 * @class 6 Dynamic Programming Advanced
 * @week 9 0928-1004
 */
public class BestTimetoBuyandSellStockIV_393 {
	
	/**
     * @param k: An integer
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int k, int[] prices) {
        // write your code here
        if (prices == null || prices.length < 2 || k == 0) {
            return 0;
        }
        
        if (k > prices.length / 2) {
            int sum = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    sum += prices[i] - prices[i - 1];
                }
            }
            return sum;
        }
        
        int len = prices.length;
        int[][] local = new int[len + 1][k + 1];
        int[][] global = new int[len + 1][k + 1];
        for (int i = 1; i < len; i++) {
            int gain = prices[i] - prices[i - 1];
            for (int j = 1; j <= k; j++) {
                local[i][j] = Math.max(local[i - 1][j] + gain, global[i - 1][j - 1] + gain);
                global[i][j] = Math.max(local[i][j], global[i - 1][j]);
            }
        }
        
        return global[len - 1][k];
    }

}
