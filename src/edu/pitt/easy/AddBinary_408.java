/**
 * 
 */
package edu.pitt.easy;

/**
 * Add Binary #408 --- Accepted
 * Given two binary strings, return their sum (also a binary string).
 * Example
 * a = 11
 * b = 1
 * Return 100
 * @author yanma
 * @category Easy Level
 * @version 2015-08-03
 * @week 1 0803-0809
 */
public class AddBinary_408 {
	
	/**
     * @param a a number
     * @param b a number
     * @return the result
     */
    public String addBinary(String a, String b) {
        // Write your code here
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }
        
        int sizea = a.length();
        int sizeb = b.length();
        
        int carry = 0;
        String result = "";
        
        int i = sizea - 1;
        int j = sizeb - 1;
        
        while (i >= 0 && j >= 0) {
            int sum = a.charAt(i) - '0' + b.charAt(j) - '0' + carry;
            if (sum == 0) {
                result = "0" + result;
                carry = 0;
            } else if (sum == 1) {
                result = "1" + result;
                carry = 0;
            } else if (sum == 2) {
                result = "0" + result;
                carry = 1;
            } else {
                result = "1" + result;
                carry = 1;
            }
            
            i--;
            j--;
        }
        
        while (i >= 0) {
            int sum = a.charAt(i) - '0' + carry;
            if (sum == 0) {
                result = "0" + result;
                carry = 0;
            } else if (sum == 1) {
                result = "1" + result;
                carry = 0;
            } else if (sum == 2) {
                result = "0" + result;
                carry = 1;
            } else {
                result = "1" + result;
                carry = 1;
            }
            i--;
        }
        
        while (j >= 0) {
            int sum = b.charAt(j) - '0' + carry;
            if (sum == 0) {
                result = "0" + result;
                carry = 0;
            } else if (sum == 1) {
                result = "1" + result;
                carry = 0;
            } else if (sum == 2) {
                result = "0" + result;
                carry = 1;
            } else {
                result = "1" + result;
                carry = 1;
            }
            j--;
        }
        
        if (carry == 1) {
            result = "1" + result;
        }
        return result;
    }

}
