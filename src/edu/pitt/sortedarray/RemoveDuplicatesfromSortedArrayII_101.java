/**
 * 
 */
package edu.pitt.sortedarray;

/**
 * Remove Duplicates from Sorted Array II #101 --- Accepted 
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * For example,
 * Given sorted array A = [1,1,1,2,2,3],
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 * @author yanma
 * @category Sorted Array
 * @version 2015-06-19
 * @class 2
 */
public class RemoveDuplicatesfromSortedArrayII_101 {

	
	/**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if (nums == null || nums.length < 3) {
            return nums.length;
        }
        
        int size = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] == nums[size] && nums[i] == nums[size - 1]) {
                continue;
            } else {
                nums[++size] = nums[i];
            }
        }
        return size + 1;
    }
    
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates1(int[] nums) {
        // write your code here
        if (nums == null || nums.length < 3) {
            return nums.length;
        }
        
        int i = 1;
        int j = i + 1;
        while (j < nums.length) {
            if (nums[j] == nums[i] && nums[j] == nums[i - 1]) {
                j++;
                continue;
            } else {
                nums[i + 1] = nums[j];
                i++;
                j++;
            }
        }
        return i + 1;
    }
    
    
	
}
