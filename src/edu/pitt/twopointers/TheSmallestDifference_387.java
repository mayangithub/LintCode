/**
 * 
 */
package edu.pitt.twopointers;

import java.util.Arrays;

/**
 * The Smallest Difference #387 --- Accepted 
 * Given two array of integers(the first array is array A, the second array is array B), 
 * now we are going to find a element in array A which is A[i], and another element in array B which is B[j], 
 * so that the difference between A[i] and B[j] (|A[i] - B[j]|) is as small as possible, 
 * return their smallest difference.
 * Example
 * For example, given array A = [3,6,7,4], B = [2,8,9,3], return 0
 * Challenge
 * O(n log n) time
 * @author yanma
 * @category Two Pointers
 * @version 2015-09-01
 * @class 4
 * @week5 0831-0906
 */
public class TheSmallestDifference_387 {
	/**
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     */
    public int smallestDifference(int[] A, int[] B) {
        // write your code here
        if (A == null || B == null) {
            return 0;
        }
        
        Arrays.sort(A);
        Arrays.sort(B);
        int gap = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] < B[j]) {
                gap = Math.min(gap, B[j] - A[i]);
                i++;
            } else {
                gap = Math.min(gap, A[i] - B[j]);
                j++;
            }
            if (gap == 0) {
                return 0;
            }
        }
        if (i < A.length) {
            gap = Math.min(gap, A[i] - B[j - 1]);
        } else if (j < B.length) {
            gap = Math.min(gap, B[j] - A[i - 1]);
        }
        return gap;
    }
    
    /**
     * To avoid unnecessary calculations
     * find the point of array B, B[j] < A[i] && B[j + 1] >= A[i]
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     */
    public int smallestDifference1(int[] A, int[] B) {
        // write your code here
        if (A == null || B == null) {
            return 0;
        }
        
        Arrays.sort(A);
        Arrays.sort(B);
        int gap = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        while (i < A.length && j < B.length) {
            while (j + 1 < B.length) {
                if (B[j + 1] > A[i]) {
                    break;
                }
                j++;
            }
            if (j < B.length) {
                gap = Math.min(gap, Math.abs(A[i] - B[j]));
            }
            if (j + 1 < B.length) {
                gap = Math.min(gap, Math.abs(A[i] - B[j + 1]));
            }
            i++;
        }
        return gap;
    }

}
