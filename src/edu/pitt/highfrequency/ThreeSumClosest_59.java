/**
 * 
 */
package edu.pitt.highfrequency;

/**
 * 3 Sum Closest #59 --- Accepted
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
 * Return the sum of the three integers. 
 *  Example
 * For example, given array S = {-1 2 1 -4}, and target = 1. 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * Note
 * You may assume that each input would have exactly one solution.
 * Challenge
 * O(n^2) time, O(1) extra space
 * @author yanma
 * @category High Frequency
 * @version 2015-08-08
 * @class 9
 */
public class ThreeSumClosest_59 {
	
	/**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers ,int target) {
        // write your code here
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        
        Arrays.sort(numbers);
        
        int closest = numbers[0];
        int mingap = Integer.MAX_VALUE;
        int start = 0;
        int end = numbers.length - 1;
        
        while (start + 1 < end) {
            int mid = start + 1;
            while (mid < end) {
                int sum = numbers[start] + numbers[mid] + numbers[end];
                int gap = Math.abs(sum - target);
                if (gap < mingap) {
                    mingap = gap;
                    closest = sum;
                }
                mid++;
            }
            if (numbers[start] + numbers[end - 1] + numbers[end] > target) {
                end--;
            } else if (numbers[start] + numbers[start + 1] + numbers[end] < target) {
                start++;
            }
            if (mingap == 0) {
                break;
            }
        }
        
        return closest;
    }

}
