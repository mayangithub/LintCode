/**
 * 
 */
package edu.pitt.easy;

import java.util.ArrayList;

/**
 * Product of Array Exclude Itself #50 --- Accepted
 * Given an integers array A.
 * Define B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1], calculate B WITHOUT divide operation.
 *  Example
 * For A = [1, 2, 3], return [6, 3, 2].
 * @author yanma
 * @category Easy Level
 * @version 2015-08-09
 * @week1 0803-0809
 */
public class ProductofArrayExcludeItself_50 {
	/**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        // write your code
        ArrayList<Long> result = new ArrayList<Long>();
        if (A == null || A.size() == 0) {
            return result;
        }
        
        result.add((long)1);
        for (int i = 0; i < A.size() - 1; i++) {
            result.add(result.get(i) * A.get(i));
        }
        
        long time = 1;
        for (int i = A.size() - 2; i >= 0; i--) {
            time *= A.get(i + 1);
            result.set(i, result.get(i) * time);
        }
        
        return result;
    }
    
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself1(ArrayList<Integer> A) {
        // write your code
        ArrayList<Long> result = new ArrayList<Long>();
        if (A == null || A.size() == 0) {
            return result;
        }
        
        ArrayList<Long> left = new ArrayList<Long>();
        ArrayList<Long> right = new ArrayList<Long>();
        left.add((long)1);
        for (int i = 0; i < A.size() - 1; i++) {
            left.add(left.get(i) * A.get(i));
        }
        
        right.add((long)1);
        for (int i = A.size() - 1; i > 0; i--) {
            right.add(0, right.get(0) * A.get(i));
        }
        
        for (int i = 0; i < A.size(); i++) {
            result.add(left.get(i) * right.get(i));
        }
        
        return result;
    }

}
