/**
 * 
 */
package edu.pitt.medium;

import java.util.ArrayList;

/**
 * Continuous Subarray Sum II #403 --- Accepted
 * Given an integer array, find a continuous rotate subarray where the sum of numbers is the biggest. 
 * Your code should return the index of the first number and the index of the last number. 
 * (If their are duplicate answer, return anyone. The answer can be rorate array or non- rorate array)
 * Example
 * Give [3, 1, -100, -3, 4], return [4,1].
 * @author yanma
 * @version 2015-11-11
 * @category Dynamic Programming
 */
public class ContinuousSubarraySumII_403 {
	/**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySumII(int[] A) {
        // Write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (A == null || A.length == 0) {
            return result;
        }
        int start = 0;
        int end = 0;
        
        result.add(start);
        result.add(end);
        
        int global = Integer.MIN_VALUE;
        int local = 0;
        
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (local + A[i] >= A[i]) {
                local += A[i];
                end = i;
            } else {
                local = A[i];
                start = i; end = i;
            }
            
            if (local >= global) {
                global = local;
                result.set(0, start);
                result.set(1, end);
            }
        }
        
        local = 0;
        start = 0;
        end = -1;
        for (int i = 0; i < A.length; i++) {
            if (local + A[i] <= A[i]) {
                local += A[i];
                end = i;
            } else {
                local = A[i];
                start = i;
                end = i;
            }
            if (start == 0 && end == A.length - 1) continue; //total is the smallest, single item is larger
            if (sum - local >= global) {
                global = sum - local;
                result.set(0, (end + 1) % A.length);
                result.set(1, (start - 1 + A.length) % A.length);
            }
        }
        
        return result;
    }

}
