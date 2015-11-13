/**
 * 
 */
package edu.pitt.greedy;

/**
 * Delete Digits #182 --- Accepted
 * Given string A representative a positive integer which has N digits, 
 * remove any k digits of the number, 
 * the remaining digits are arranged according to the original order to become a new positive integer.
 * Find the smallest integer after remove k digits.
 * N <= 240 and k <= N,
 * Example
 * Given an integer A = "178542", k = 4
 * return a string "12"
 * @author yanma
 * @version 2015-11-12
 * @category Greedy, Dynamic Programming
 */
public class DeleteDigits_182 {
	
	/**
     *@param A: A positive integer which has N digits, A is a string.
     *@param k: Remove k digits.
     *@return: A string
     */
    public String DeleteDigits(String A, int k) {
        // write your code here
        if (A == null || k >= A.length()) {
            return "";
        }
        
        int len = A.length();
        String[][] dp = new String[2][len + 1];
        for (int j = 0; j <= len; j++) {
            dp[0][j] = "";
        }
        
        for (int i = 1; i <= len - k; i++) {
            dp[1][i] = dp[0][i - 1] + A.substring(i - 1, i);
            for (int j = i + 1; j <= len; j++) {
                String cont = dp[0][j - 1] + A.substring(j - 1, j);
                if (cont.compareTo(dp[1][j - 1]) < 0) {
                    dp[1][j] = cont;
                } else {
                    dp[1][j] = dp[1][j - 1];
                }
            }
            for (int j = 0; j < len; j++) {
                dp[0][j] = dp[1][j];
            }
        }

        return trimZeros(dp[1][len]);
    }
    
    
    public String trimZeros(String str) {
        if (str.compareTo("0") == 0) {
            return "0";
        }
        
        if (str.charAt(0) == '0') {
            return trimZeros(str.substring(1));
        }
        return str;
    }

}
