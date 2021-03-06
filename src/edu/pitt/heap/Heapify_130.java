/**
 * 
 */
package edu.pitt.heap;

/**
 * Heapify #130 --- Accepted
 * Given an integer array, heapify it into a min-heap array.
 * For a heap array A, A[0] is the root of heap, and for each A[i], 
 * A[i * 2 + 1] is the left child of A[i] and A[i * 2 + 2] is the right child of A[i].
 *  Example
 * Given [3,2,1,4,5], return [1,2,3,4,5] or any legal heap array.
 * Challenge
 * O(n) time complexity
 * Clarification
 * What is heap?
 *     Heap is a data structure, which usually have three methods: push, pop and top. 
 *     where "push" add a new element the heap, "pop" delete the minimum/maximum element in the heap, 
 *     "top" return the minimum/maximum element.
 * What is heapify?
 *     Convert an unordered integer array into a heap array. 
 *     If it is min-heap, for each element A[i], we will get A[i * 2 + 1] >= A[i] and A[i * 2 + 2] >= A[i].
 * What if there is a lot of solutions?
 *     Return any of them.
 * @author yanma
 * @category Heap
 * @version 2015-08-22
 * @class 2,3
 * @week3 0817-0823
 */
public class Heapify_130 {
	
	/**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        // write your code here
        if (A == null || A.length <= 1) {
            return;
        }
        
        for (int i = A.length / 2; i >= 0; i--) {
            siftdown(A, i);
        }
        return;
    }
    
    public void siftdown(int[] A, int pos) {
        if (pos < 0 || pos >= A.length) {
            return;
        }
        
        int smaller = pos;
        if (2 * pos + 1 < A.length && A[2 * pos + 1] < A[smaller]) {
            smaller = 2 * pos + 1;
        }
        if (2 * pos + 2 < A.length && A[2 * pos + 2] < A[smaller]) {
            smaller = 2 * pos + 2;
        }
        
        if (smaller == pos) {
            return;
        }
        
        int temp = A[pos];
        A[pos] = A[smaller];
        A[smaller] = temp;
        siftdown(A, smaller);
    }

}
