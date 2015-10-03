/**
 * 
 */
package edu.pitt.dynamicprogrammingIII;

/**
 * Copy Books #437 --- Accepted
 * Given an array A of integer with size of n( means n books and number of pages of each book) 
 * and k people to copy the book. You must distribute the continuous id books to one people to copy. 
 * (You can give book A[1],A[2] to one people, but you cannot give book A[1], A[3] to one people, 
 * because book A[1] and A[3] is not continuous.) Each person have can copy one page per minute. 
 * Return the number of smallest minutes need to copy all the books.
 * Example
 * Given array A = [3,2,4], k = 2.
 * Return 5( First person spends 5 minutes to copy book 1 and book 2 and second person spends 4 minutes to copy book 3. )
 * @author yanma 
 * @version 2015-10-02
 * @class 6 Dynamic Programming Advanced
 * @week 9 0928-1004
 */
public class CopyBooks_437 {
	/**
     * @param pages: an array of integers
     * @param k: an integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        if (pages == null || pages.length == 0 || k == 0) {
            return 0;
        }
        
        int len = pages.length;
        int sum = 0;
        int[][] dp = new int[k + 1][len + 1];
        for (int i = 1; i <= len; i++) {
            dp[1][i] = dp[1][i - 1] + pages[i - 1];
        }
        
        for (int p = 2; p <= k; p++) {
            for (int i = 2; i <= len; i++) { // i total num of books
                dp[p][i] = Integer.MAX_VALUE;
                for (int j = 1; j < i; j++) {
                    int last = dp[1][i] - dp[1][j];
                    dp[p][i] = Math.min(dp[p][i], Math.max(dp[p - 1][j], last));
                }
            }
        }
        
        return dp[k][len];
    }

}
