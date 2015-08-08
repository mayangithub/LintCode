/**
 * 
 */
package edu.pitt.highfrequency;

/**
 * Sort Colors II #143 --- Accepted
 * Given an array of n objects with k different colors (numbered from 1 to k), 
 * sort them so that objects of the same color are adjacent, with the colors in the order 1, 2, ... k.
 * Example
 * Given colors=[3, 2, 2, 1, 4], k=4, your code should sort colors in-place to [1, 2, 2, 3, 4].
 * Note
 * You are not suppose to use the library's sort function for this problem.
 * Challenge
 * A rather straight forward solution is a two-pass algorithm using counting sort. 
 * That will cost O(k) extra memory. Can you do it without using extra memory?
 * @author yanma
 * @category High Frequency
 * @version 2015-08-07
 * @class 9
 */
public class SortColorsII_143 {
	
	/**
	 * Using Bucket Sort
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        
        if (colors == null || colors.length == 0) {
            return;
        }
        
        //bucket sort
        int i = 0;
        while (i < colors.length) {
            while (colors[i] > 0) {
                int pos = colors[i] - 1;
                if (colors[pos] >= 0) {
                    colors[i] = colors[pos];
                    colors[pos] = -1;
                } else {
                    colors[pos]--;
                    colors[i] = 0;
                }
            }
            i++;
        }
        
        //set count
        int start = colors.length - 1; 
        int num = k;
        while (num > 0) {
            int count = colors[num - 1] * (-1);
            while (count > 0) {
                colors[start] = num;
                start--;
                count--;
            }
            num--;
        }
        
    }

}
