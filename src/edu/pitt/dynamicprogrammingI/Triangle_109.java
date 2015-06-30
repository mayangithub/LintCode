/**
 * 
 */
package edu.pitt.dynamicprogrammingI;

import java.util.ArrayList;

/**
 * Triangle #109 --- accepted
 * Given a triangle, find the minimum path sum from top to bottom. 
 * Each step you may move to adjacent numbers on the row below.
 * Example
 * For example, given the following triangle
 * [
 * 	     [2],
 * 	    [3,4],
 * 	   [6,5,7],
 * 	  [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * Note
 * Bonus point if you are able to do this using only O(n) extra space, 
 * where n is the total number of rows in the triangle.
 * @author yanma
 * @category DPI
 * @version 2015-06-29
 * @class 4
 */
public class Triangle_109 {
	
	/**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // write your code here
        if (triangle == null) {
           return 0; 
        }
        
        int level = triangle.size();
        int[] sum = new int[triangle.get(level - 1).size()];
        for (int l = level; l >= 1; l--) {
            for (int i = 0; i < l; i++) {
                if (l == level) {
                    sum[i] = triangle.get(l - 1).get(i);
                } else {
                    sum[i] = Math.min(sum[i], sum[i + 1]) + triangle.get(l - 1).get(i);
                }
            }
        }
        
        return sum[0];
    }

}
