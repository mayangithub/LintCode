/**
 * 
 */
package edu.pitt.easy;

/**
 * Flip Bits #181 --- Accepted
 * Determine the number of bits required to flip if you want to convert integer n to integer m.
 * Example
 * Given n = 31 (11111), m = 14 (01110), return 2.
 * Note
 * Both n and m are 32-bit integers.
 * @author yanma
 * @category Easy Level
 * @version 2015-08-04
 * @week1 0803-0809
 */
public class FlipBits_181 {
	
	/**
     *@param a, b: Two integer
     *return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
        // write your code here
        
        int xor = a ^ b;
        
        int count = 0;
        String binary = Integer.toBinaryString(xor);
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                count++;
            }
        }
        
        return count;
    }

}
