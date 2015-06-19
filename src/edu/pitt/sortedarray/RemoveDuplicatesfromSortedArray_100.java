/**
 * 
 */
package edu.pitt.sortedarray;

/**
 * Remove Duplicates from Sorted Array #100 --- Accepted
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * Example
 * Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 * @author yanma
 * @category Sorted Array
 * @version 2015-06-19
 * @class 2
 */
public class RemoveDuplicatesfromSortedArray_100 {

	
	/**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if (nums == null || nums.length < 2) {
            return nums.length;
        }
        
        int i = 0; //the position of inserting next unique item
        int j = i + 1; // the position of second pointer to compare items
        while (j < nums.length) {
            if (nums[j] == nums[i]) {
                j++;
            } else {
                nums[i + 1] = nums[j];
                i++;
                j++;
            }
        }
        
        return i + 1;
    }
	
}
