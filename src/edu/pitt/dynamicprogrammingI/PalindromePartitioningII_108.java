/**
 * 
 */
package edu.pitt.dynamicprogrammingI;

/**
 * Palindrome Partitioning II #108 --- Accepted
 * Given a string s, cut s into some substrings such that every substring is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * Example
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * @author yanma
 * @category DPI
 * @version 2015-06-30
 * @class 4
 */
public class PalindromePartitioningII_108 {
	
	/**
     * @param s a string
     * @return an integer
     */
    public int minCut(String s) {
        // write your code here
        /**
         * state: f[i]表示前i个字符需要多少个回文串切分
         * function: f[i] = MIN(f[j]) + 1, index j ~ i - 1是回文字符串, 0 <= j <= i - 1
         * initialization: f[0] = -1, f[1] = 0
         * answer: f[n]
         */
         
         /**
          * 判断是否是回文串
          * f[j][i] = f[j + 1][i - 1] && s.charAt(j) == s.charAt(i)
          */
        
        if (s == null || s.length() <= 1) {
            return 0;
        }
        
        boolean[][] isPalin = isPalindrome(s);
        int n = s.length();
        int[] cuts = new int[n + 1];
        cuts[0] = -1; cuts[1] = 0;
        for (int i = 2; i <= n; i++) {
            cuts[i] = i - 1;
            for (int j = i - 1; j >= 0; j--) {
                if (isPalin[j][i - 1]) {
                    cuts[i] = Math.min(cuts[i], cuts[j] + 1);
                }
            }
        }
        
        return cuts[n];
    }
    
    public boolean[][] isPalindrome(String s) {
        int n = s.length();
        boolean[][] isPalin = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            isPalin[i][i] = true;
        }
        
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                isPalin[i][i + 1] = true;
            }
        }
        //can use this method to fill in the isPalin matrix
        for (int length = 2; length < n; length++) {
            for (int start = 0; start < n - length; start++) {
                if (isPalin[start + 1][start + length - 1] && s.charAt(start) == s.charAt(start + length)) {
                        isPalin[start][start + length] = true;
                }
            }
        }
        
        //can't use start and end to fill in palindrome matrix, because it will depend on unprocessed cells
//        for (int start = 0; start < n; start++) {
//            for (int end = start; end < n; end++) {
//                if (start == end) {
//                   isPalin[start][end] = true; 
//                } else if (start + 1 == end) {
//                    isPalin[start][end] = (s.charAt(start) == s.charAt(end));
//                } else if (isPalin[start + 1][end - 1] && s.charAt(start) == s.charAt(end)) {
//                    isPalin[start][end] = true;
//                }
//            }
//        }
        
        return isPalin;
    }

}
