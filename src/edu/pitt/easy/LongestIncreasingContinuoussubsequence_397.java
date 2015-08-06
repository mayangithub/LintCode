/**
 * 
 */
package edu.pitt.easy;

/**
 * Longest Increasing Continuous subsequence #397 --- Accepted
 * Give you an integer array (index from 0 to n-1, where n is the size of this array)，
 * find the longest increasing continuous subsequence in this array. 
 * (The definition of the longest increasing continuous subsequence here can be 
 * from right to left or from left to right)
 * Example
 * For [5, 4, 2, 1, 3], the LICS is [5, 4, 2, 1], return 4.
 * For [5, 1, 2, 3, 4], the LICS is [1, 2, 3, 4], return 4.
 * Note
 * O(n) time and O(1) extra space.
 * @author yanma
 * @category Easy Level
 * @version 2015-08-05
 * @week1 0803-0809
 */
public class LongestIncreasingContinuoussubsequence_397 {
	/**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // Write your code here
        if (A == null) {
            return 0;
        } else if (A.length <= 2) {
            return A.length;
        }
        
        int direction = (A[1] > A[0])? 1: -1; //1: increase -1: decrease
        int max = 2;
        int count = 2;
        int i = 2;
        
        while (i < A.length) {
            if (A[i] > A[i - 1] && direction == 1) {
                count++;
                i++; continue;
            } else if (A[i] < A[i - 1] && direction == -1) {
                count++;
                i++; continue;
            }
            
            max = Math.max(max, count);
            count = 2;
            direction = (A[i] > A[i - 1])? 1: -1;
            i++;
        }
        
        max = Math.max(max, count);
        
        return max;
    }

}
