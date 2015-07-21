/**
 * 
 */
package edu.pitt.highfrequency;

/**
 * O(1) Check Power of 2 #142 --- Accepted
 * Using O(1) time to check whether an integer n is a power of 2.
 * Example
 * For n=4, return true;
 * For n=5, return false;
 * Challenge
 * O(1) time
 * @author yanma
 * @category High Frequency
 * @version 2015-07-21
 * @class 9
 */
public class O1CheckPowerof2_142 {
	
	/*
	 * delete the first '1'
	 * https://en.wikipedia.org/wiki/Power_of_two
     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf2(int n) {
        // write your code here
        if (n <= 0) {
            return false;
        }
        
        int result = (n - 1) & n;
        return result == 0;
    }
	
	
	 /*
     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf22(int n) {
        // write your code here
        if (n <= 0) {
            return false;
        }
        
        String binary = Integer.toBinaryString(n);
        for (int i = binary.length() - 1; i >= 1; i--) {
            if (binary.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }
    
    /**
     * recursion
     * @param n
     * @return
     */
    public boolean checkPowerOf21(int n) {
        // write your code here
        if (n <= 0) {
            return false;
        }
        
        return n == 1 || (n % 2 == 0 && checkPowerOf21(n/2));
    }
    
    

}
