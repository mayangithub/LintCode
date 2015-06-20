/**
 * 
 */
package edu.pitt.sortedarray;

/**
 * Rotate String #8 --- Accepted 
 * Given a string and an offset, rotate string by offset. (rotate from left to right)
 * Example
 * Given "abcdefg"
 * for offset=0, return "abcdefg"
 * for offset=1, return "gabcdef"
 * for offset=2, return "fgabcde"
 * for offset=3, return "efgabcd"
 * ...
 * @author yanma
 * @category Sorted Array
 * @version 2015-06-19
 * @class 2
 */
public class RotateString_8 {

	
	/*
     * param A: A string
     * param offset: Rotate string with offset.
     * return: Rotated string.
     */
    public char[] rotateString(char[] A, int offset) {
        // wirte your code here
        if (A == null || A.length == 0 || offset == 0) {
            return A;
        }
        offset = offset % A.length;
        
        reverse(A, 0, A.length - 1 - offset);
        reverse(A, A.length - offset, A.length - 1);
        reverse(A, 0, A.length - 1);
        
        return A;
    }
    
    public void reverse(char[] A, int start, int end) {
        while (start < end) {
            char temp = A[start];
            A[start] = A[end];
            A[end] = temp;
            start++;
            end--;
        }
    }
	
}
