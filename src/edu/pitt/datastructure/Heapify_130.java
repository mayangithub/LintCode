/**
 * 
 */
package edu.pitt.datastructure;

/**
 * Heapify #130 --- accepted
 * Given an integer array, heapify it into a min-heap array.
 * For a heap array A, A[0] is the root of heap, and for each A[i], 
 * A[i * 2 + 1] is the left child of A[i] and A[i * 2 + 2] is the right child of A[i].
 *  Example
 * Given [3,2,1,4,5], return [1,2,3,4,5] or any legal heap array.
 * Challenge
 * O(n) time complexity
 * Clarification
 * What is heap?
    Heap is a data structure, which usually have three methods: push, pop and top. 
    where "push" add a new element the heap, "pop" delete the minimum/maximum element in the heap, 
    "top" return the minimum/maximum element.
 * What is heapify?
    Convert an unordered integer array into a heap array. 
    If it is min-heap, for each element A[i], we will get A[i * 2 + 1] >= A[i] and A[i * 2 + 2] >= A[i].
 * What if there is a lot of solutions?
    Return any of them.
 * @author yanma
 * @category Data Structure
 * @version 2015-07-20
 * @class 8
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
    }
    
    public void siftdown(int[] A, int i) {
        if (i >= A.length) {
            return;
        }
        
        int smallest = i;
        if (i * 2 + 1 < A.length && A[i * 2 + 1] < A[smallest]) {
            smallest = i * 2 + 1;
        }
        if (i * 2 + 2 < A.length && A[i * 2 + 2] < A[smallest]) {
            smallest = i * 2 + 2;
        }
        
        if (smallest == i) {
            return;
        }
        
        int temp = A[i];
        A[i] = A[smallest];
        A[smallest] = temp;
        
        siftdown(A, smallest);
    }

}
