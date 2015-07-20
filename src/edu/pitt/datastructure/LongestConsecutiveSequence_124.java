/**
 * 
 */
package edu.pitt.datastructure;

import java.util.HashMap;

/**
 * Longest Consecutive Sequence #124 --- Accepted
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence. 
 * Example
	Given [100, 4, 200, 1, 3, 2],
	The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * Clarification
	Your algorithm should run in O(n) complexity.
 * @author yanma
 * @category Data Structure
 * @version 2015-07-20
 * @class 8
 */
public class LongestConsecutiveSequence_124 {
	
	/**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        // write you code here
        if (num == null || num.length == 0) {
            return 0;
        }
        
        int max = 1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < num.length; i++) {
            if (map.containsKey(num[i])) {
                continue;
            }
            
            int left = (map.containsKey(num[i] - 1)) ? map.get(num[i] - 1): 0;
            int right = (map.containsKey(num[i] + 1)) ? map.get(num[i] + 1): 0;
            int sum = left + right + 1;
            map.put(num[i], sum);
            if (left != 0) {
                map.put(num[i] - map.get(num[i] - 1), sum);
            }
            if (right != 0) {
                map.put(num[i] + map.get(num[i] + 1), sum);
            }
            max = Math.max(max, sum);
        }
        
        return max;
    }

}
