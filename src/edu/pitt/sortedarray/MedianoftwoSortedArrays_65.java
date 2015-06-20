/**
 * 
 */
package edu.pitt.sortedarray;

/**
 * Median of two Sorted Arrays #65 --- Accepted
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.
 * Example
 * Given A=[1,2,3,4,5,6] and B=[2,3,4,5], the median is 3.5.
 * Given A=[1,2,3] and B=[4,5], the median is 3.
 * Challenge
 * The overall run time complexity should be O(log (m+n)).
 * @author yanma
 * @category Sorted Array
 * @version 2015-06-20
 * @class 2
 */
public class MedianoftwoSortedArrays_65 {
	
	/**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        if (A == null || A.length == 0) {
            if (B.length % 2 == 0) {
                return (B[B.length / 2 - 1] + B[B.length / 2]) / 2.0;
            } else {
                return B[B.length / 2];
            }
        }
        if (B == null || B.length == 0) {
            if (A.length % 2 == 0) {
                return (A[A.length / 2 - 1] + A[A.length / 2]) / 2.0;
            } else {
                return A[A.length / 2];
            }
        }
        int size = A.length + B.length;
        if (size % 2 == 0) {
            return (findKth(A, 0, B, 0, size / 2) + findKth(A, 0, B, 0, size / 2 + 1)) / 2.0;
        } else {
            return findKth(A, 0, B, 0, size / 2 + 1);
        }
    }
    
    public double findKth(int[] A, int Astart, int[] B, int Bstart, int k) {
        if (Astart >= A.length) {
            return B[Bstart + k - 1];
        }
        if (Bstart >= B.length) {
            return A[Astart + k - 1];
        }
        if (k == 1) {
            return Math.min(A[Astart], B[Bstart]);
        }
        
        int Amid = (Astart + k / 2 - 1 >= A.length) ? Integer.MAX_VALUE: A[Astart + k / 2 - 1];
        int Bmid = (Bstart + k / 2 - 1 >= B.length) ? Integer.MAX_VALUE: B[Bstart + k / 2 - 1];
        
        if (Amid <= Bmid) {
            return findKth(A, Astart + k / 2, B, Bstart, k - k / 2);
        } else {
            return findKth(A, Astart, B, Bstart + k / 2, k - k / 2);
        }
        
    }
	
	

}
