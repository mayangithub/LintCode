/**
 * 
 */
package edu.pitt.dynamicprogrammingIII;

/**
 * Coins in a Line II #395 --- Accepted
 * There are n coins with different value in a line. 
 * Two players take turns to take one or two coins from left side until there are no more coins left. 
 * The player who take the coins with the most value wins.
 * Could you please decide the first player will win or lose?
 * Example
 * Given values array A = [1,2,2], return true.
 * Given A = [1,2,4], return false.
 * @author yanma
 * @version 2015-09-20
 * @category Dynamic Programming Advanced
 * @class 6
 * @week 7 0914-0920
 */
public class CoinsinaLineII_395 {
	/**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        if (values == null || values.length == 0) {
            return false;
        } else if (values.length < 3) {
            return true;
        }
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        
        if (values.length == 3) {
            return (values[0] + values[1]) > (sum / 2) ;
        }
        
        if (values.length == 4) {
            int sumfirstone = values[0] + values[3];
            int sumfirsttwo = values[0] + values[1];
            return Math.max(sumfirstone, sumfirsttwo) > (sum / 2) ;
        }
        
        int[] coins = new int[values.length + 1];
        coins[0] = 0;
        coins[1] = values[0];
        coins[2] = values[0] + values[1];
        coins[3] = values[0] + values[1];
        coins[4] = Math.max(values[0] + values[3], values[0] + values[1]);
        for (int i = 5; i < values.length + 1; i++) {
            coins[i] = Math.max(Math.min(coins[i - 2], coins[i - 3]) + values[i - 4], 
                Math.min(coins[i - 3], coins[i - 4]) + values[i - 4] + values[i - 3]);
        }
        
        return coins[values.length] > (sum / 2);
    }

}
