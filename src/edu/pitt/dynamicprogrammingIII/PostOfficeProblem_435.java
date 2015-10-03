/**
 * 
 */
package edu.pitt.dynamicprogrammingIII;

import java.util.Arrays;

/**
 * Post Office Problem #435 --- Accepted
 * On one line there are n houses. 
 * Give you an array of integer means the the position of each house. 
 * Now you need to pick k position to build k post office, 
 * so that the sum distance of each house to the nearest post office is the smallest. 
 * Return the least possible sum of all distances between each village and its nearest post office. 
 * Example
 * Given array a = [1,2,3,4,5], k = 2. return 3.
 * Challenge
 * Could you solve this problem in O(n^2) time ?
 * Note
 * Remember to have the array sorted
 * @author yanma
 * @version 2015-10-03
 * @class 6 Dynamic Programming Advanced
 * @week 9 0928-1004
 */
public class PostOfficeProblem_435 {
	/**
     * @param A an integer array
     * @param k an integer
     * @return an integer
     */
    public int postOffice(int[] A, int k) {
        // Write your code here
        if (A == null || A.length == 0 || k == 0) {
            return 0;
        }
        Arrays.sort(A); // Caution!!!!
        int len = A.length;
        int[][] distances = new int[len + 1][len + 1];
        for (int i = 1; i <= len; i++) {
            for (int j = i + 1; j <= len; j++) {
                int mid = (i + j) / 2;
                int sum = 0;
                for (int point = i; point <= j; point++) {
                    sum += Math.abs(A[mid - 1] - A[point - 1]);
                }
                distances[i][j] = sum;
            }
        }
        
        int[][] dp = new int[k + 1][len + 1];
        for (int i = 0; i <= len; i++) {
            dp[1][i] = distances[1][i];
        }
        for (int p = 2; p <= k; p++) {
            for (int total = 2; total <= len; total++) {
                if (total <= p) continue;
                dp[p][total] = Integer.MAX_VALUE;
                for (int j = 1; j < total; j++) {
                    dp[p][total] = Math.min(dp[p][total], dp[p - 1][j] + distances[j + 1][total]);
                }
            }
        }
        
        return dp[k][len];
    }

}
