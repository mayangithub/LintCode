/**
 * 
 */
package edu.pitt.twopointers;

/**
 * Trapping Rain Water #363 --- Accepted
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 * Example
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * Challenge
 * O(n) time and O(1) memory
 * O(n) time and O(n) memory is also acceptable.
 * @author yanma
 * @category Two Pointers
 * @version 2015-08-22
 * @class 2,3
 * @week3 0817-0823
 */
public class TrappingRainWater_363 {
	/**
	 * scan once and use O(1) space
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        // write your code here
        if (heights == null || heights.length < 3) {
            return 0;
        }
        
        int i = 0; 
        int j = heights.length - 1;
        int left = heights[i];
        int right = heights[j];
        int trap = 0;
        while (i + 1 < j) {
            if (left < right) {
                if (heights[i + 1] < left) {
                    trap += left - heights[i + 1];
                } else {
                    left = heights[i + 1];
                }
                i++;
            } else {
                if (heights[j - 1] < right) {
                    trap += right - heights[j - 1];
                } else {
                    right = heights[j - 1];
                }
                j--;
            }
        }
        
        return trap;
    }
    
    /**
     * scan 4 time, use O(3n) space
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater1(int[] heights) {
        // write your code here
        if (heights == null || heights.length < 3) {
            return 0;
        }
        
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        int[] compare = new int[heights.length];
        
        left[0] = Math.max(0, heights[0]);
        right[heights.length - 1] = Math.max(0, heights[heights.length - 1]);
        
        for (int i = 1; i < heights.length; i++) {
            left[i] = Math.max(left[i - 1], heights[i]);
        }
        
        for (int i = heights.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], heights[i]);
        }
        
        for (int i = 0; i < heights.length; i++) {
            compare[i] = Math.min(left[i], right[i]);
        }
        
        int trap = 0;
        for (int i = 0; i < heights.length; i++) {
            if (compare[i] > heights[i]) {
                trap += compare[i] - heights[i];
            }
        }
        return trap;
    }
}
