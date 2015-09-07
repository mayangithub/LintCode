/**
 * 
 */
package edu.pitt.twopointers;

import java.util.Arrays;

/**
 * Remove Element #172 --- Accepted
 * Given an array and a value, remove all occurrences of that value in place and return the new length.
 * The order of elements can be changed, and the elements after the new length don't matter.
 * Example
 * Given an array [0,4,4,0,0,2,4,4], value=4
 * return 4 and front four elements of the array is [0,0,0,2]
 * @author yanma
 * @category Two Pointers
 * @version 2015-09-07
 * @class 5
 * @week 6 0907-0913
 */
public class RemoveElement_172 {
	
	/** 
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int non = 0; // next non-value position
        int index = 0;
        while (non < A.length) {
            while (non < A.length && A[non] == elem) {
                non++;
            }
            if (non == A.length) {
                break;
            }
            if (A[index] == elem) {
                A[index] = A[non];
                A[non] = elem;
            }
            non++;
            index++;
        }
        
        return index;
    }
    
    /** 
     * sort first
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    public int removeElement1(int[] A, int elem) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        Arrays.sort(A);
        int length = 0;
        int index = 0;
        while (index < A.length) {
            if (A[index] < elem) {
                length++;
            } else if (A[index] > elem) {
                A[length] = A[index];
                A[index] = elem;
                length++;
            }
            index++;
        }
        return length;
    }

}
