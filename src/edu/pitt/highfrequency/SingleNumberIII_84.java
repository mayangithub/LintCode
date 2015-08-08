/**
 * 
 */
package edu.pitt.highfrequency;

import java.util.ArrayList;
import java.util.List;

/**
 * Single Number III #84 --- Accepted
 * Given 2*n + 2 numbers, every numbers occurs twice except two, find them.
 *  Example
 * Given [1,2,2,3,4,4,5,3] return 1 and 5
 * Challenge
 * O(n) time, O(1) extra space.
 * @author yanma
 * @category High Frequency
 * @version 2015-08-08
 * @class 9
 */
public class SingleNumberIII_84 {
	/**
     * @param A : An integer array
     * @return : Two integers
     */
    public List<Integer> singleNumberIII(int[] A) {
        // write your code here
        List<Integer> result = new ArrayList<Integer>();
        if (A == null || A.length == 0) {
            return result;
        }
        
        int xor = A[0];
        for (int i = 1; i < A.length; i++) {
            xor ^= A[i];
        }
        
        int last = xor - ((xor - 1) & xor); // (xor - 1) & xor: delete last 1
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < A.length; i++) {
            if ((A[i] & last) == 0) { // & == 0, means different, 
                num1 ^= A[i];
            } else {
                num2 ^= A[i];
            }
        }
        
        result.add(num1);
        result.add(num2);
        
        return result;
    }
}
