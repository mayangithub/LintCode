/**
 * 
 */
package edu.pitt.highfrequency;

/**
 * Best Time to Buy and Sell Stock II #150 --- Accepted
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. 
 * You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). 
 * However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * Example
 * Given an example [2,1,2,0,1], return 2
 * @author yanma
 * @category High Frequency
 * @version 2015-07-31
 * @class 9
 */
public class BestTimetoBuyandSellStockII_150 {
	
	/**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                result += prices[i] - prices[i - 1];
            }
        }
        
        return result;
    }

}
