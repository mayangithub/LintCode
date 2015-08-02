/**
 * 
 */
package edu.pitt.highfrequency;

/**
 * Sort Colors #148 --- Accepted
 * Given an array with n objects colored red, white or blue, 
 * sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Example
 * Given [1, 0, 1, 2], return [0, 1, 1, 2].
 * Note	
 * You are not suppose to use the library's sort function for this problem.
 * Challenge	
 * A rather straight forward solution is a two-pass algorithm using counting sort. First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with an one-pass algorithm using only constant space?
 * @author yanma
 * @category High Frequency
 * @version 2015-08-01
 * @class 9
 */
public class SortColors_148 {
	/**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return;
        }
        
        int i = -1; // last 0
        int j = 0; // i + 1 to j - 1, are 1s
        int k = nums.length; // first 2
        
        while (j < k) {
            if (nums[j] == 1) {
                j++;
            } else if (nums[j] == 0) {
                nums[j] = 1;
                nums[i + 1] = 0;
                i++;
                j++;
            } else { // nums[j] == 2
                nums[j] = nums[k - 1]; 
                nums[k - 1] = 2;
                k--;
            }
        }
    }

}
