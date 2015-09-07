/**
 * 
 */
package edu.pitt.twopointers;

/**
 * Container With Most Water #383 --- Accepted
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * Example
 * Given [1,3,2], the max area of the container is 2.
 * Note
 * You may not slant the container.
 * @author yanma
 * @category Two Pointers
 * @version 2015-09-07
 * @class 5
 * @week 6 0907-0913
 */
public class ContainerWithMostWater_383 {
	
	/**
	 * O(n) time better solution
     * @param heights: an array of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        // write your code here
        if (heights == null || heights.length < 2) {
            return 0;
        }
        
        int maxarea = 0;
        int left = 0;
        int right = heights.length - 1;
        while (left < right) {
            maxarea = Math.max(maxarea, (right - left) * Math.min(heights[left], heights[right]));
            //the following part can be prooved
            if (heights[left] <= heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxarea;
    }
	
	/**
	 * most basic solution
	 * O(n ^ 2) time
     * @param heights: an array of integers
     * @return: an integer
     */
    public int maxArea1(int[] heights) {
        // write your code here
        if (heights == null || heights.length < 2) {
            return 0;
        }
        
        int maxarea = 0;
        for (int i = 0; i < heights.length - 1; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                int area = (j - i) * Math.min(heights[i], heights[j]);
                maxarea = Math.max(maxarea, area);
            }
        }
        return maxarea;
    }

}
