/**
 * 
 */
package edu.pitt.cc;

/**
 * Digit Counts #3 --- Accepted
 * Count the number of k's between 0 and n. k can be 0 - 9.
 * Example
 * if n=12, k=1 in [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12], we have FIVE 1's (1, 10, 11, 12)
 * @author yanma
 * @category CC
 * @version 2015-09-28
 * @week 9 0928-1004
 */
public class DigitCounts_3 {
	/*
     * param k : As description.
     * param n : As description.
     * return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here
        
        if (n < 0) {
            return 0;
        }
        
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            int temp = i;
            while (temp > 0) {
                if (temp % 10 == k) {
                    sum += 1;
                }
                temp /= 10;
            }
        }
        return sum;
    }

}
