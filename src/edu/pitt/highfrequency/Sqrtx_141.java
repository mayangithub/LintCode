/**
 * 
 */
package edu.pitt.highfrequency;

/**
 * Sqrt(x) #141 --- Accepted
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 * Example
 * sqrt(3) = 1
 * sqrt(4) = 2
 * sqrt(5) = 2
 * sqrt(10) = 3
 * Challenge
 * O(log(x))
 * @author yanma
 * @category High Frequency
 * @version 2015-07-21
 * @class 9
 */
public class Sqrtx_141 {
	
	/**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        if (x < 0) {
            return -1;
        }
        
        if (x <= 1) {
            return x;
        }
        
        int start = 1;
        int end = x / 2;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mid == x / mid) { // mid * mid will be overflowing
                return mid;
            } else if (mid < x / mid) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (end <= x / end) {
            return end;
        }
        
        return start;
    }
	

}
