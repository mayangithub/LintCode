/**
 * 
 */
package edu.pitt.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Permutation Index #197 --- Accepted
 * Given a permutation which contains no repeated number, 
 * find its index in all the permutations of these numbers, 
 * which are ordered in lexicographical order. The index begins at 1.
 * Example
 * Given [1,2,4], return 1.
 * @author yanma
 * @version 2015-10-12
 * @week11 1012-1018
 */
public class PermutationIndex_197 {
	/**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndex(int[] A) {
        // Write your code here
        
        if (A == null || A.length <= 1) {
            return 0;
        }
        
        int[] sorted = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            sorted[i] = A[i];
        }
        Arrays.sort(sorted);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < sorted.length; i++) {
            map.put(sorted[i], i);
        }
        
        long sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += (map.get(A[i]) - smaller(A, i)) * fac(sorted.length - (i + 1));
        }
        
        return sum + 1;
    }
    
    public long fac(int i) {
        if (i == 0) {
            return 1;
        }
        return i * fac(i - 1);
    }
    
    public int smaller(int[] A, int index) {
        int num = 0;
        for (int i = 0; i < index; i++) {
            if (A[i] < A[index]) {
                num++;
            }
        }
        return num;
    }
}
