/**
 * 
 */
package edu.pitt.highfrequency;

/**
 * Best Time to Buy and Sell Stock #149 --- Accepted
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
 * design an algorithm to find the maximum profit.
 * Example
 * Given an example [3,2,3,1,2], return 1
 * @author yanma
 * @category High Frequency
 * @version 2015-07-31
 * @class 9
 */
public class BestTimetoBuyandSellStock_149 {
	
	/**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int max = 0;
        int lowest = prices[0];
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - lowest); 
            lowest = Math.min(prices[i], lowest);
        }
        
        return max;
    }

}
