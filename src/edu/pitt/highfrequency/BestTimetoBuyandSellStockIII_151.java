/**
 * 
 */
package edu.pitt.highfrequency;

/**
 * Best Time to Buy and Sell Stock III #151 --- Accepted
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * Example
 * Given an example [4,4,6,1,1,4,2,5], return 6.
 * Note
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * @author yanma
 * @category High Frequency
 * @version 2015-07-31
 * @class 9
 */
public class BestTimetoBuyandSellStockIII_151 {
	
	/**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        int lowest = prices[0];
        int highest = prices[prices.length - 1];
        
        left[0] = 0;
        right[prices.length - 1] = 0;
        
        for (int i = 1; i < prices.length; i++) {
            lowest = Math.min(lowest, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - lowest);
        }
        
        for (int i = prices.length - 2; i >= 0; i--) {
            highest = Math.max(highest, prices[i]);
            right[i] = Math.max(right[i + 1], highest - prices[i]);
        }
        
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            max = Math.max(max, left[i] + right[i]);
        }
        return max;
    }

}
