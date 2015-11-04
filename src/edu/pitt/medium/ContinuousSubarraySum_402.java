/**
 * 
 */
package edu.pitt.medium;

import java.util.ArrayList;

/**
 * Continuous Subarray Sum #402 --- Accepted
 * Given an integer array, find a continuous subarray where the sum of numbers is the biggest. 
 * Your code should return the index of the first number and the index of the last number. 
 * (If their are duplicate answer, return anyone)
 * Example
 * Give [-3, 1, 3, -3, 4], return [1,4].
 * @author yanma
 * @version 2015-11-03
 * @category Medium
 */
public class ContinuousSubarraySum_402 {
	 /**
	  * Accepted
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        // Write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (A == null || A.length == 0) {
            return result;
        }
        result.add(0);
        result.add(0);
        int max = A[0];
        int[] sum = new int[A.length];
        sum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            sum[i] = sum[i - 1] + A[i];
            if (sum[i] > max) {
                max = sum[i];
                result.set(1, i);
            }
        }
        
        for (int start = 0; start < A.length; start++) {
            if (A[start] >= 0) {
                continue;
            }
            for (int end = start + 1; end < A.length; end++) {
                int diff = sum[end] - sum[start];
                if (diff > max) {
                    max = diff;
                    result.set(0, start + 1);
                    result.set(1, end);
                }
            }
        }
        
        return result;
    }
	
	/**
	 * Time Limit Exceed 75% accepted
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySum1(int[] A) {
        // Write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (A == null || A.length == 0) {
            return result;
        }
        
        result.add(0); result.add(0);
        int max = Integer.MIN_VALUE;
        for (int start = 0; start < A.length; start++) {
            for (int end = start; end < A.length; end++) {
                int sum = sum(A, start, end);
                if (sum > max) {
                    max = sum;
                    result.set(0, start);
                    result.set(1, end);
                }
            }
        }
        
        return result;
    }
    
    public int sum(int[] A, int start, int end) {
        if (A == null || A.length == 0 || start > end) {
            return 0;
        }
        
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += A[i];
        }
        return sum;
    }

}
