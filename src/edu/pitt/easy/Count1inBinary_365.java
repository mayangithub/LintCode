/**
 * 
 */
package edu.pitt.easy;

/**
 * Count 1 in Binary #365 --- Accepted
 * Count how many 1 in binary representation of a 32-bit integer.
 * Example
 * Given 32, return 1
 * Given 5, return 2
 * Given 1023, return 9
 * Challenge
 * If the integer is n bits with m 1 bits. Can you do it in O(m) time?
 * @author yanma
 * @category Easy Level
 * @version 2015-08-03
 * @week 1 0803-0809
 */
public class Count1inBinary_365 {
	/**
     * @param num: an integer
     * @return: an integer, the number of ones in num
     */
    public int countOnes(int num) {
        // write your code here
        if (num == 0) {
            return 0;
        } else if (num == Integer.MIN_VALUE) {
            return 1;
        }
        
        int count = 0;
        if (num > 0) {
            while (num > 0) {
                int temp = num;
                if (temp != 2 * (num >> 1)) {
                    count++;
                    num = (num - 1) / 2;
                } else {
                    num /= 2;
                }
            }
        } else {
            int pos = num * (-1);
            int length = Integer.toBinaryString(pos).length();
            int poscount = countOnes(pos);
            count = 32 - length + poscount;
        }
        
        return count;
    }

}
