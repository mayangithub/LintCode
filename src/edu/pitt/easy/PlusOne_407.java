/**
 * 
 */
package edu.pitt.easy;

/**
 * Plus One #407 --- Accepted
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 *  Example
 * Given [1,2,3] which represents 123, return [1,2,4].
 * Given [9,9,9] which represents 999, return [1,0,0,0].
 * @author yanma
 * @category Easy Level
 * @version 2015-08-09
 * @week1 0803-0809
 */
public class PlusOne_407 {
	/**
     * @param digits a number represented as an array of digits
     * @return the result
     */
    public int[] plusOne(int[] digits) {
        // Write your code here
        if (digits == null || digits.length == 0) {
            return digits;
        }
        
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            if (i == digits.length - 1) {
                sum += 1;
            }
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        
        if (carry == 0) {
            return digits;
        }
        
        int[] result = new int[digits.length + 1];
        for (int i = result.length - 1; i >= 1; i--) {
            result[i] = digits[i - 1];
        }
        result[0] = carry;
        
        return result;
    }

}
