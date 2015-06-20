/**
 * 
 */
package edu.pitt.sortedarray;

/**
 * Merge Sorted Array #64 --- Accepted 
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * Example
 * A = [1, 2, 3, empty, empty], B = [4, 5]
 * After merge, A will be filled as [1, 2, 3, 4, 5]
 * Note
 * You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. 
 * The number of elements initialized in A and B are m and n respectively.
 * @author yanma
 * @category Sorted Array
 * @version 2015-06-19
 * @class 2
 */
public class MergeSortedArray_64 {

	/**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        if (B == null || n == 0) {
            return;
        }
        
        int pos = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        
        while (pos >= 0) {
            if (i >= 0 && j >= 0) {
                if (A[i] >= B[j]) {
                    A[pos] = A[i];
                    i--;
                } else if (B[j] > A[i]) {
                    A[pos] = B[j];
                    j--;
                }
            } else if (i >= 0) {
                A[pos] = A[i];
                i--;
            } else if (j >= 0) {
                A[pos] = B[j];
                j--;
            }
            pos--;
        }
        
    }
}
