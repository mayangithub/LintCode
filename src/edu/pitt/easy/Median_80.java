/**
 * 
 */
package edu.pitt.easy;

/**
 * Median #80 --- Accepted
 * Given a unsorted array with integers, find the median of it. 
 * A median is the middle number of the array after it is sorted. 
 * If there are even numbers in the array, return the N/2-th number after sorted.
 * Example
 * Given [4, 5, 1, 2, 3], return 3
 * Given [7, 9, 4, 5], return 5
 * Challenge
 * O(n) time.
 * @author yanma
 * @version 2015-10-12
 * @category Follow Up I
 * @week11 1012-1018
 */
public class Median_80 {
	/**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        
        int median = (nums.length - 1) / 2;
        int low = 0;
        int hi = nums.length - 1;
        int p = partition(nums, low, hi);
        while (p != median) {
            if (p > median) {
                hi = p - 1;
            } else {
                low = p + 1;
            }
            p = partition(nums, low, hi);
        }
        return nums[p];
    }
    
    
    
    public int partition(int[] nums, int low, int hi) {
        int pivot = nums[hi];
        int i = low;
        for (int j = i; j < hi; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, hi);
        return i;
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
