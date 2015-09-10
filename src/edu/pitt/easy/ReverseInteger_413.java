/**
 * 
 */
package edu.pitt.easy;

/**
 * Reverse Integer #413 --- Accepted
 * Reverse digits of an integer. Returns 0 when the reversed integer overflows (signed 32-bit integer).
 * Example
 * Given x = 123, return 321
 * Given x = -123, return -321
 * @author yanma
 * @version 2015-09-09
 * @category Easy
 * @week 6 0907-0913
 */
public class ReverseInteger_413 {
	
	/**
     * @param n the integer to be reversed
     * @return the reversed integer
     */
    public int reverseInteger(int n) {
        // Write your code here
        if (n == 0 || n == Integer.MIN_VALUE) {
            return 0;
        }
        boolean pos = true;
        if (n < 0) {
            pos = false;
        }
        
        n = Math.abs(n);
        String num = "" + n;
        char[] array = num.toCharArray();
        StringBuffer bf = new StringBuffer();
        boolean digit = false;
        for (int i = array.length - 1; i >= 0; i--) {
            if (!digit && array[i] == '0') {
                continue;
            }
            bf.append(array[i]);
            digit = true;
            if (i == 1 && bf.length() > 0) {
                bf.append('.');
            }
        }
        num = bf.toString();
        double number = Double.parseDouble(num);
        if (number > Integer.MAX_VALUE / 10) {
            return 0;
        }
        
        if (num.length() > 1) {
            number = number * 10;
        }
        if (!pos) {
            number *= -1;
        }

        return (int) number;
    }

}
