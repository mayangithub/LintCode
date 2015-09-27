/**
 * 
 */
package edu.pitt.dynamicprogrammingIII;

/**
 * Coins in a Line III #396 --- Accepted
 * There are n coins in a line. 
 * Two players take turns to take a coin from one of the ends of the line until there are no more coins left. 
 * The player with the larger amount of money wins.
 * Example
 * Given array A = [3,2,2], return true.
 * Given array A = [1,2,4], return true.
 * Given array A = [1,20,4], return false.
 * Challenge
 * Follow Up Question:
 * If n is even. 
 * Is there any hacky algorithm that can decide whether first player will win or lose in O(1) memory and O(n) time?
 * @author yanma
 * @version 2015-09-26
 * @category Dynamic Programming Advanced
 * @class 6
 * @week 7 0914-0920
 */
public class CoinsinaLineIII_396 {
	/**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        if (values == null || values.length == 0) {
            return false;
        }
        
        int len = values.length;
        int[][] matrix = new int[len][len];
        int sum = 0;
        
        for (int i = 0; i < len; i++) {
            matrix[i][i] = values[i];
            sum += values[i];
        }
        
        for (int i = 0; i < len - 1; i++) {
            matrix[i][i + 1] = Math.max(values[i], values[i + 1]);
        }
        
        for (int i = len - 3; i >= 0; i--) {
            for (int j = i + 2; j < len; j++) {
                matrix[i][j] = Math.max(Math.min(matrix[i + 2][j], matrix[i + 1][j - 1]) + values[i], Math.min(matrix[i + 1][j - 1], matrix[i][j - 2]) + values[j]); 
            }
        }
        
        return matrix[0][len - 1] > (sum / 2);
    }

}
