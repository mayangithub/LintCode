/**
 * 
 */
package edu.pitt.highfrequency;

/**
 * Single Number #82 --- Accepted
 * Given 2*n + 1 numbers, every numbers occurs twice except one, find it.
 * Example
 * Given [1,2,2,1,3,4,3], return 4
 * Challenge
 * One-pass, constant extra space.
 * @author yanma
 * @category High Frequency
 * @version 2015-07-21
 * @class 9
 */
public class SingleNumber_82 {
	
	/**
	 *@param A : an integer array
	 *return : a integer 
	 */
	public int singleNumber(int[] A) {
		if (A == null || A.length == 0) {
		    return 0;
		}
		int result = A[0];
		for (int i = 1; i < A.length; i++) {
		    result ^= A[i];
		}
		return result;
	}

}
