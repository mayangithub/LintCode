/**
 * 
 */
package edu.pitt.highfrequency;

/**
 * Fast Power #140 --- Accepted
 * Calculate the a^n % b where a, b and n are all 32bit integers.
 * Example
 * For 231 % 3 = 2
 * For 1001000 % 1000 = 0
 * Challenge
 * O(logn)
 * @author yanma
 * @category High Frequency
 * @version 2015-08-07
 * @class 9
 */
public class FastPower_140 {
	/*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        // write your code here
        if (n == 0) {
            return 1 % b;
        } 
        if (n == 1) {
            return a % b;
        }
        
        long result = fastPower(a, b, n / 2); //long type
        result = (result * result) % b;
        if (n % 2 == 1) {
            result = (result * a) % b;
        }
        
        return (int) result;
    }

}
