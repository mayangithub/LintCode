/**
 * 
 */
package edu.pitt.sortedarray;

import java.util.ArrayList;

/**
 * Recover Rotated Sorted Array #39 --- accepted
 * Given a rotated sorted array, recover it to sorted array in-place.
 *  Example
 * [4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]
 * Challenge
 * In-place, O(1) extra space and O(n) time.
 * Clarification
 * What is rotated array?
 *     For example, the orginal array is [1,2,3,4], 
 *     The rotated array of it can be [1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]
 * @author yanma
 * @category Sorted Array
 * @version 2015-06-19
 * @class 2
 */
public class RecoverRotatedSortedArray_39 {

	/**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                reverse(nums, 0, i);
                reverse(nums, i + 1, nums.size() - 1);
                reverse(nums, 0, nums.size() - 1);
                return;
            }
        }
        
        
    }
    
    public void reverse(ArrayList<Integer> nums, int start, int end) {
        while (start < end) {
            int temp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, temp);
            start++;
            end--;
        }
    }
	
	
}
