/**
 * 
 */
package edu.pitt.greedy;

/**
 * Find the Missing Number #196 --- Accepted
 * Given an array contains N numbers of 0 .. N, find which number doesn't exist in the array.
 * Example
 * Given N = 3 and the array [0, 1, 3], return 2.
 * Challenge
 * Do it in-place with O(1) extra memory and O(n) time.
 * @author yanma
 * @version 2015-10-21
 * @category Greedy
 * @week 12 1019-1025
 */
public class FindtheMissingNumber_196 {
	/**    
     * @param nums: an array of integers
     * @return: an integer
     */
    public int findMissing(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i];
            while (index >= 0 && index < nums.length && nums[index] != index) {
                int temp = nums[index];
                nums[index] = index;
                index = temp;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }
        return nums.length;
    }

}
