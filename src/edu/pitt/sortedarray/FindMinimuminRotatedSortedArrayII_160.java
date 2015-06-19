/**
 * 
 */
package edu.pitt.sortedarray;

/**
 * Find Minimum in Rotated Sorted Array II #160
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * The array may contain duplicates.
 * Example
 * Given [4,4,5,6,7,0,1,2] return 0
 * @author yanma
 * @category Sorted Array
 * @version 2015-06-19
 * @class 2
 */
public class FindMinimuminRotatedSortedArrayII_160 {

	/**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        if (num == null || num.length == 0) {
            return -1;
        }
        
        int min = num[0];
        for (int digit: num) {
            if (digit < min) {
                min = digit;
            }
        }
        return min;
    }
	
	
}
