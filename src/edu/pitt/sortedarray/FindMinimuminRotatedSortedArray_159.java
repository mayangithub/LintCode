/**
 * 
 */
package edu.pitt.sortedarray;

/**
 * Find Minimum in Rotated Sorted Array #159 --- Accepted
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 *  Example
 * Given [4, 5, 6, 7, 0, 1, 2] return 0
 * Note
 * You may assume no duplicate exists in the array.
 * @author yanma
 * @category Sorted Array
 * @version 2015-06-19
 * @class 2
 */
public class FindMinimuminRotatedSortedArray_159 {

	
	/**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        if (num == null || num.length == 0) {
            return -1;
        }
        
        int start = 0;
        int end = num.length - 1;
        if (num[start] < num[end]) {
            return num[start];
        }
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (num[mid] < num[mid - 1] && num[mid] < num[mid + 1]) {
                return num[mid];
            } 
            if (num[mid] > num[start]) {
                start = mid;
            } else if (num[end] > num[mid]) {
                end = mid;
            }
        }
        
        if (num[start] < num[end]) {
            return num[start];
        }
        return num[end];
    }
	
}
