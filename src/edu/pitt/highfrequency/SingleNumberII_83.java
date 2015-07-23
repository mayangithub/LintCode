/**
 * 
 */
package edu.pitt.highfrequency;

/**
 * Single Number II #83 --- Accepted
 * Given 3*n + 1 numbers, every numbers occurs triple times except one, find it.
 * Example
 * Given [1,1,2,3,3,3,2,2,4,1] return 4
 * Challenge
 * One-pass, constant extra space.
 * @author yanma
 * @category High Frequency
 * @version 2015-07-21
 * @class 9
 */
public class SingleNumberII_83 {
	
	/**
	 * @param A : An integer array
	 * @return : An integer 
	 */
    public int singleNumberII(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int[] pow3 = new int[20]; //3^20 <= Integer.MAX_VALUE
        pow3[0] = 1;
        for (int i = 1; i < 20; i++) {
            pow3[i] = pow3[i - 1] * 3;
        }
        
        int[] bits = new int[20];
        
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < 20; j++) {
                if (A[i] < pow3[j]) break;
                bits[j] += A[i] / pow3[j] % 3; // 十进制 => 三进制
            }
        }
        
        int result = 0;
        for (int i = 0; i < 20; i++) {
            result += (bits[i] % 3) * pow3[i]; // 三进制 => 十进制
        }
        
        return result;
    }
    
    public void main(String[] args) {
    	System.out.println(Math.pow(3, 20));
    }

}
