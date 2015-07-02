/**
 * 
 */
package edu.pitt.dynamicprogrammingII;

/**
 * Edit Distance #119 --- Accepted
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. 
 * (each operation is counted as 1 step.)
 * You have the following 3 operations permitted on a word:
 *     Insert a character
 *     Delete a character
 *     Replace a character
 * Example
 * Given word1 = "mart" and word2 = "karma", return 3.
 * @author yanma
 * @category DP II
 * @version 2015-07-01
 * @class 5
 */
public class EditDistance_119 {
	
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        // write your code here
        /**
         * state: f[i][j] means the minimum number of steps to convert word1's first i letters to word2's first j letters
         * function: 
         *      (1) replace = f[i - 1][j - 1] + 1
         *      (2) insert = f[i][j - 1] + 1
         *      (3) delete = f[i - 1][j] + 1
         *      (4) same = f[i - 1][j - 1]
         *  f[i][j] = MIN(replace, insert, delete) || same
         * initialization: f[0][j] = j, f[i][0] = i
         * answer: f[word1.length][word2.length]
         */
        if (word2 == null || word2.length() == 0) {
            return word1.length();
        }
        
        if (word1 == null || word1.length() == 0) {
            return word2.length();
        }
         
        if (word1.equals(word2)) {
            return 0;
        }
        
        int length1 = word1.length();
        int length2 = word2.length();
        
        int[][] edit = new int[length1 + 1][length2 + 1];
        
        //don't forget to do the initialization
        for (int i = 0; i <= length1; i++) {
            edit[i][0] = i;
        }
        
        for (int j = 1; j <= length2; j++) {
            edit[0][j] = j;
        }
        
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    edit[i][j] = edit[i - 1][j - 1];
                } else {
                    int replace = edit[i - 1][j - 1] + 1;
                    int insert = edit[i][j - 1] + 1;
                    int delete = edit[i - 1][j] + 1;
                    edit[i][j] = Math.min(replace, Math.min(insert, delete));
                }
            }
        }
        return edit[length1][length2];
    }

}
