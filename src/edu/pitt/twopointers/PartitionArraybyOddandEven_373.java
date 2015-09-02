/**
 * 
 */
package edu.pitt.twopointers;

/**
 * Partition Array by Odd and Even #373 --- Accepted
 * Partition an integers array into odd number first and even number second.
 * Example
 * Given [1, 2, 3, 4], return [1, 3, 2, 4]
 * Challenge
 * Do it in-place.
 * @author yanma
 * @category Two Pointers -- collision
 * @version 2015-09-01
 * @class 4
 * @week5 0831-0906
 */
public class PartitionArraybyOddandEven_373 {
	/**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        // write your code here;
        if (nums == null || nums.length <= 1) {
            return;
        }
        int even = nums.length;
        // not required
//        while (nums[even - 1] % 2 == 0) {
//            even--;
//        }
        int i = 0;
        while (i < even - 1) {
            if (nums[i] % 2 == 0) {
                int temp = nums[even - 1];
                nums[even - 1] = nums[i];
                nums[i] = temp;
                even--;
                // not required
//                while (nums[even - 1] % 2 == 0) {
//                    even--;
//                }
            } else {
                i++;
            }
        }
    }

}
