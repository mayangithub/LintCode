/**
 * 
 */
package edu.pitt.datastructure;

import java.util.PriorityQueue;

/**
 * Data Stream Median #81 --- Accepted
 * Numbers keep coming, return the median of numbers at every time a new number added.
 * Example
 * For numbers coming list: [1, 2, 3, 4, 5], return [1, 1, 2, 2, 3].
 * For numbers coming list: [4, 5, 1, 3, 2, 6, 0], return [4, 4, 4, 3, 3, 3, 3].
 * For numbers coming list: [2, 20, 100], return [2, 2, 20].
 * Challenge
 * Total run time in O(nlogn).
 * Clarification
 * What's the definition of Median? - Median is the number that in the middle of a sorted array. 
 * If there are n numbers in a sorted array A, the median is A[(n - 1) / 2]. 
 * For example, if A=[1,2,3], median is 2. If A=[1,19], median is 1.
 * @author yanma
 * @category Data Structure
 * @version 2015-07-20
 * @class 8
 */
public class DataStreamMedian_81 {
	/**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
    	if (nums == null) {
    		return null;
    	}
    	
    	int size = nums.length;
    	int[] medians = new int[size];
    	if (size == 0) {
    		return medians;
    	}
    	
    	PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>();
    	PriorityQueue<Integer> minheap = new PriorityQueue<Integer>();
    	
    	int median = nums[0];
    	medians[0] = median;
    	for (int i = 1; i < size; i++) {
    		if (nums[i] < median) {
    			maxheap.add(nums[i] * (-1));
    		} else {
				minheap.add(nums[i]);
			}
    		
    		while (maxheap.size() - minheap.size() > 1) {
    			minheap.add(median);
    			median = maxheap.poll() * (-1);
    		}
    		
    		while (minheap.size() - maxheap.size() > 1) {
    			maxheap.add(median * (-1));
    			median = minheap.poll();
    		}
    		
    		if (maxheap.size() == minheap.size()) {
    			medians[i] = median;
    			continue;
    		} 
    		
    		if (minheap.size() > maxheap.size()) {
    			medians[i] = median;
    		} else {
    			medians[i] = maxheap.peek() * (-1); // [1, 19], median = 1
    		}
    	}
    	
    	return medians;
    }
    
}
