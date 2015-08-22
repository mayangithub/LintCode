/**
 * 
 */
package edu.pitt.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Trapping Rain Water II #364 --- Accepted
 * Given n x m non-negative integers representing an elevation map 2d where the area of each cell is 1 x 1, 
 * compute how much water it is able to trap after raining.
 * Example
 * Given 5*4 matrix
 * [12,13,0,12]
 * [13,4,13,12]
 * [13,8,10,12]
 * [12,13,12,12]
 * [13,13,13,13]
 * return 14.
 * @author yanma
 * @category Heap
 * @version 2015-08-22
 * @class 2,3
 * @week3 0817-0823
 */
public class TrappingRainWaterII_364 {
	
	/**
     * @param heights: a matrix of integers
     * @return: an integer
     */
     
    public class Element {
        public int x;
        public int y;
        public int value;
        public Element(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
    
    public class ElementComparator implements Comparator<Element> {
        public int compare(Element e1, Element e2) {
            return e1.value - e2.value;
        }
    }
    
    
    public int trapRainWater(int[][] heights) {
        // write your code here
        if (heights == null || heights.length <= 2 || heights[0].length <= 2) {
            return 0;
        }
        int cols = heights[0].length;
        int rows = heights.length;
        PriorityQueue<Element> minheap = new PriorityQueue<Element>(1, new ElementComparator()); // caution!! priorityqueue length
        boolean[][] flag = new boolean[rows][cols];
        int[] x = {1, -1, 0, 0};
        int[] y = {0, 0, 1, -1};
        
        for (int c = 0; c < cols; c++) {
            minheap.offer(new Element(0, c, heights[0][c]));
            minheap.offer(new Element(rows - 1, c, heights[rows - 1][c]));
            flag[0][c] = true;
            flag[rows - 1][c] = true;
        }
        
        for (int r = 1; r < rows - 1; r++) {
            minheap.offer(new Element(r, 0, heights[r][0]));
            minheap.offer(new Element(r, cols - 1, heights[r][cols - 1]));
            flag[r][0] = true;
            flag[r][cols - 1] = true;
        }
        int trap = 0;
        while (!minheap.isEmpty()) {
            Element out = minheap.poll(); // poll !! not pull!!
            int rx = out.x;
            int cy = out.y;
            int value = out.value;
            for (int i = 0; i < 4; i++) {
                int nx = rx + x[i];
                int ny = cy + y[i];
                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && !flag[nx][ny]) {
                    if (heights[nx][ny] < value) {
                        trap += value - heights[nx][ny];
                        heights[nx][ny] = value;
                    } 
                    minheap.offer(new Element(nx, ny, heights[nx][ny]));
                    flag[nx][ny] = true;
                }
            }
            
        }
        
        return trap;
    }

}
