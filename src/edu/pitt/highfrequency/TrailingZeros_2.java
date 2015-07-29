/**
 * 
 */
package edu.pitt.highfrequency;

/**
 * Trailing Zeros #2 --- Accepted
 * Write an algorithm which computes the number of trailing zeros in n factorial.
 * Example
 * 11! = 39916800, so the out should be 2
 * Challenge
 * O(log N) time
 * @author yanma
 * @category High Frequency
 * @version 2015-07-29
 * @class 9
 */
public class TrailingZeros_2 {
	
	/*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        // write your code here
        if (n <= 4) {
            return 0;
        }
        
        long num5 = 0; //
        long num2 = 0;
        
        long divide5 = n; // n can be long, more than Integer.MAX_VALUE
        long divide2 = n;
        while (divide5 >= 5) {
            divide5 = divide5 / 5;
            num5 += divide5;
        }
        
        while (divide2 >= 2) {
            divide2 = divide2 / 2;
            num2 += divide2;
        }

        return Math.min(num2, num5);
    }

}
