/**
 * 
 */
package edu.pitt.dynamicprogrammingIII;

/**
 * Coins in a Line #394 --- Accepted
 * There are n coins in a line. 
 * Two players take turns to take one or two coins from right side until there are no more coins left. 
 * The player who take the last coin wins.
 * Could you please decide the first play will win or lose?
 * Example
 * n = 1, return true.
 * n = 2, return true.
 * n = 3, return false.
 * n = 4, return true.
 * n = 5, return true.
 * Challenge
 * O(n) time and O(1) memory
 * @category Dynamic Programming Advanced
 * @author yanma
 * @version 2015-09-20
 * @class 6 
 * @week 7 0914-0920
 */
public class CoinsinaLine_394 {
	
	/**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        // write your code here
        if (n == 3 || n == 0) {
            return false;
        } else if (n < 5) {
            return true;
        }
        
        boolean[] truthbox = new boolean[n];
        truthbox[0] = true;
        truthbox[1] = true;
        truthbox[2] = false;
        truthbox[3] = true;
        for (int i = 4; i < n; i++) {
            truthbox[i] = (truthbox[i - 2] && truthbox[i - 3]) || (truthbox[i - 3] && truthbox[i - 4]);
        }
        return truthbox[n - 1];
    }

}
