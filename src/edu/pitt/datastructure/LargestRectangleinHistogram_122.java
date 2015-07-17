/**
 * 
 */
package edu.pitt.datastructure;

import java.util.Stack;

/**
 * Largest Rectangle in Histogram #122 --- Accepted
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
 * find the area of largest rectangle in the histogram.
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * Example
 * Given height = [2,1,5,6,2,3],
 * return 10.
 * @author yanma
 * @category Data Structure
 * @version 2015-07-16
 * @class 8
 */
public class LargestRectangleinHistogram_122 {
	
	/**
	 * using linear stack
	 * O(n) time
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        // write your code here
        if (height == null || height.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.empty() && height[stack.peek().intValue()] >= height[i]) {
                int pos = stack.pop().intValue(); // min height in the range
                int width = (stack.empty()) ? i: i - stack.peek().intValue() - 1; //left: peek() index, right: i
                int high = height[pos];
                max = Math.max(max, width * high);
            }
            stack.push(i);
        }
        
        while (!stack.empty()) {
            int pos = stack.pop().intValue();
            int width = (stack.empty()) ? height.length: height.length - stack.peek().intValue() - 1;
            int high = height[pos];
            max = Math.max(max, width * high);
        }
        
        return max;   
    }
	
	/**
     * for each index position, find the first rectangle lower than itself in both sides
     * O(n^2) time Accepted
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea2(int[] height) {
        // write your code here
        if (height == null || height.length == 0) {
            return 0;
        }
        
        int max = 0;
        for (int pos = 0; pos < height.length; pos++) {
            int left = pos;
            int right = pos;
            for (; left >= 0; left--) {
                if (height[left] < height[pos]) {
                    left += 1;
                    break;
                }
            }
            if (left == -1) left = 0;
            
            for (; right < height.length; right++) {
                if (height[right] < height[pos]) {
                    right -= 1;
                    break;
                }
            }
            if (right == height.length) right = height.length - 1;
            
            int width = right - left + 1;
            max = Math.max(max, width * height[pos]);
        }
        
        return max;
    }
	
	
	
	
	/**
     * brute force solution --- Time Limit Exceeded 11/18 test cases passed
     * O(n^3) time
     * step1: find a start and a end
     * step2: find the min height in this range
     * step3: calculate area and compare with the max
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea1(int[] height) {
        // write your code here
        if (height == null || height.length == 0) {
            return 0;
        }
        int max = 0;
        for (int start = 0; start < height.length; start++) {
            for (int end = start; end < height.length; end++) {
                int high = findMin(height, start, end);
                int width = end - start + 1;
                max = Math.max(max, high * width);
            }
        }
        
        return max;
    }
    
    public int findMin(int[] height, int start, int end) {
        if (start > end) {
            return 0;
        }
        int min = height[start];
        while (start <= end) {
            min = Math.min(min, height[start]);
            start++;
        }
        return min;
    }

}
