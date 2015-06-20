/**
 * 
 */
package edu.pitt.sortedarray;

import java.util.ArrayList;

/**
 * Merge Sorted Array II  #6 --- Accepted 
 * Merge two given sorted integer array A and B into a new sorted integer array.
 * Example
 * A=[1,2,3,4]
 * B=[2,4,5,6]
 * return [1,2,2,3,4,4,5,6]
 * Challenge
 * How can you optimize your algorithm if one array is very large and the other is very small?
 * @author yanma
 * @category Sorted Array
 * @version 2015-06-19
 * @class 2
 */
public class MergeSortedArrayII_6 {

	
	/**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (A == null || A.size() == 0) {
            return B;
        } else if (B == null || B.size() == 0) {
            return A;
        }
        
        int i = 0;
        int j = 0;
        int Aend = A.size() - 1;
        int Bend = B.size() - 1;
        
        while (i <= Aend && j <= Bend) {
            if (A.get(i) <= B.get(j)) {
                result.add(A.get(i));
                i++;
            } else {
                result.add(B.get(j));
                j++;
            }
        }
        
        if (i == Aend + 1) {
            while (j <= Bend) {
                result.add(B.get(j));
                j++;
            }
        } else {
            while (i <= Aend) {
                result.add(A.get(i));
                i++;
            }
        }
        return result;
    }
	
}
