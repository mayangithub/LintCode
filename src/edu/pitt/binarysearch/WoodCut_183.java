/**
 * 
 */
package edu.pitt.binarysearch;

/**
 * Wood Cut #183 --- Accepted
 * Given n pieces of wood with length L[i] (integer array). 
 * Cut them into small pieces to guarantee you could have equal or more than k pieces with the same length. 
 * What is the longest length you can get from the n pieces of wood? Given L & k, 
 * return the maximum length of the small pieces.
 * Example
 * For L=[232, 124, 456], k=7, return 114.
 * Note
 * You couldn't cut wood into float length.
 * Challenge
 * O(n log Len), where Len is the longest length of the wood.
 * @author yanma
 * @category Binary Search
 * @version 2015-10-06
 * @week 10 1005-1011
 */
public class WoodCut_183 {
	/** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if (L == null || L.length == 0) {
            return 0;
        }
        
        int max = L[0];
        for (int i = 1; i < L.length; i++) {
            max = (L[i] > max) ? L[i]: max; // O(n) time
        }
        
        int start = 1;  // make sure the wood piece has length more than or equal to 1
        int end = max;
        int longest = 0;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int count = count(L, mid); // mid means the length
            if (count >= k) {
                longest = (longest > mid) ? longest: mid;
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (count(L, end) >= k) {
            return end;
        } else if (count(L, start) >= k) {
            return start;
        }
        return 0;
    }
    
    public int count(int[] L, int length) {
        int count = 0;
        for (int i = 0; i < L.length; i++) {
            count += L[i] / length;
        }
        return count;
    }

}
