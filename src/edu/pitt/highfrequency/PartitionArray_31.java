/**
 * 
 */
package edu.pitt.highfrequency;

/**
 * Partition Array #31 --- Accepted
 * Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:
    All elements < k are moved to the left
    All elements >= k are moved to the right
 * Return the partitioning index, i.e the first index i nums[i] >= k.
 *  Example
 * If nums = [3,2,2,1] and k=2, a valid answer is 1.
 * Note
 * You should do really partition in array nums instead of just counting the numbers of integers smaller than k.
 * If all elements in nums are smaller than k, then return nums.length
 * Challenge
 * Can you partition the array in-place and in O(n)?
 * @author yanma
 * @category High Frequency
 * @version 2015-08-09
 * @class 9
 */
public class PartitionArray_31 {
	
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
	    //write your code here
	    if (nums == null || nums.length == 0) {
	        return 0;
	    }
	    
	    int i = -1;
	    int j = 0;
	    while (j < nums.length) {
	        if (nums[j] >= k) {
	            j++;
	        } else {
	            int temp = nums[i + 1];
	            nums[i + 1] = nums[j];
	            nums[j] = temp;
	            i++;
	            j++;
	        }
	    }
	    
	    return i + 1;
    }

}
