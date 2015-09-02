/**
 * 
 */
package edu.pitt.twopointers;

import java.util.Arrays;

/**
 * Interleaving Positive and Negative Numbers #144 --- Accepted
 * Given an array with positive and negative integers. Re-range it to interleaving with positive and negative integers.
 * Example
 * Given [-1, -2, -3, 4, 5, 6], after re-range, it will be [-1, 5, -2, 4, -3, 6] or any other reasonable answer.
 * Note
 * You are not necessary to keep the original order of positive integers or negative integers.
 * Challenge
 * Do it in-place and without extra memory.
 * @author yanma
 * @category Two Pointers
 * @version 2015-09-01
 * @class 4
 * @week5 0831-0906
 */
public class InterleavingPositiveandNegativeNumbers_144 {
	
	/**
	 * Easiest way
     * @param A: An integer array.
     * @return: void
     */
    public void rerange(int[] A) {
        // write your code here
        if (A == null || A.length < 3) {
            return;
        }
        
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) count++;
        }
        
        if (Math.abs(2 * count - A.length) > 1) {
            return;
        }
        
        boolean positive = false;
        int pos = 0;
        int neg = 0;
        int index = 0;
        if (2 * count > A.length) {
            positive = true;
        }
        
        while (index < A.length) {
        	// find next first negative
            while (neg < A.length && A[neg] > 0) {
                neg++;
            }
            // find next first positive
            while (pos < A.length && A[pos] < 0) {
                pos++;
            }
            
            if (positive && A[index] < 0) {
                int temp = A[index];
                A[index] = A[pos];
                A[pos] = temp;
            } else if (!positive && A[index] > 0) {
                int temp = A[index];
                A[index] = A[neg];
                A[neg] = temp;
            }
            // right position with right value
            if (index == pos) {
                pos++;
            }
            if (index == neg) {
                neg++;
            }
            // change sign
            positive = !positive;
            index++;
        }
   }
	
	/**
	 * Too hard to think
     * @param A: An integer array.
     * @return: void
     */
    public void rerange2(int[] A) {
        // write your code here
        if (A == null || A.length < 3) {
            return;
        }
        Arrays.sort(A);
        int po = 0;
        while (po < A.length) {
            if (A[po] < 0) {
                po++;
            } else {
                break;
            }
        }
        
        if (Math.abs(A.length - po - po) > 1) { // can't have the interleaving arrangement
            return;
        } 
        
        int neg = 0;
        if (2 * po < A.length) { // positives are more
            int temp = A[0];
            A[0] = A[po];
            A[po] = temp;
            po = A.length - 2;
            neg = 2;
        } else if (2 * po > A.length) {
            int temp = A[A.length - 1];
            A[A.length - 1] = A[po - 1];
            A[po - 1] = temp;
            neg++;
            po = A.length - 3;
        } else {
            neg = 1;
            po = A.length - 2;
        }
        
        while (neg < po) {
            int temp = A[neg];
            A[neg] = A[po];
            A[po] = temp;
            neg += 2;
            po -= 2;
        }
   }

	
	/**
	 * Bad method
	 * O(n) extra space O(3n) time
     * @param A: An integer array.
     * @return: void
     */
    public void rerange1(int[] A) {
        // write your code here
        if (A == null || A.length < 3) {
            return;
        }
        Arrays.sort(A);
        int po = 0;
        while (po < A.length) {
            if (A[po] < 0) {
                po++;
            } else {
                break;
            }
        }
        
        if (Math.abs(A.length - po - po) > 1) { // can't have the interleaving arrangement
            return;
        } 
        
        int neg = 0;
        int[] B = new int[A.length];
        if (2 * po > A.length) {
            B[0] = A[0];
            neg++;
            int index = 1;
            while (index < A.length) {
                B[index] = A[po];
                if (index + 1 < A.length) B[index + 1] = A[neg];
                index += 2;
                po++;
                neg++;
            }
        } else {
            B[0] = A[po];
            po++;
            int index = 1;
            while (index < A.length) {
                B[index] = A[neg];
                if (index + 1 < A.length) B[index + 1] = A[po];
                index += 2;
                po++;
                neg++;
            }
        }
        
        for (int i = 0; i < A.length; i++) {
            A[i] = B[i];
        }
        return;
   }
}
