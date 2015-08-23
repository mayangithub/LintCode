/**
 * 
 */
package edu.pitt.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Sliding Window Median #360 --- Accepted
 * Given an array of n integer, and a moving window(size k), 
 * move the window at each iteration from the start of the array, 
 * find the median of the element inside the window at each moving. 
 * (If there are even numbers in the array, return the N/2-th number after sorting the element in the window. )
 *  Example
 * For array [1,2,7,8,5], moving window size k = 3. return [2,7,7]
 * At first the window is at the start of the array like this
 * [ | 1,2,7 | ,8,5] , return the median 2;
 * then the window move one step forward.
 * [1, | 2,7,8 | ,5], return the median 7;
 * then the window move one step forward again.
 * [1,2, | 7,8,5 | ], return the median 7;
 * Challenge
 * O(nlog(n)) time
 * @author yanma
 * @category Heap
 * @version 2015-08-23
 * @class 4
 * @week3 0817-0823
 */
public class SlidingWindowMedian_360 {

    public class MaxComparator implements Comparator<Integer> {
        public int compare(Integer int1, Integer int2) {
            if (int1.intValue() < int2.intValue()) {
                return 1;
            } else if (int1.intValue() == int2.intValue()) {
                return 0;
            } else {
                return -1;
            }
        }
    }
    
    /**
     * @param nums: A list of integers.
     * @return: The median of the element inside the window at each moving.
     */
    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length < k || k == 0) {
            return result;
        }
        
        PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(1, new MaxComparator());
        PriorityQueue<Integer> minheap = new PriorityQueue<Integer>();
        
        int median = nums[0];
        for (int i = 1; i < k; i++) {
            if (nums[i] < median) {
                maxheap.offer(nums[i]);
            } else {
                minheap.offer(nums[i]);
            }
            median = adjust(maxheap, median, minheap);
        }
        result.add(median);
        int i = 0;
        int j = k;
        while (j < nums.length) {
            if (nums[j] < median) {
                maxheap.offer(nums[j]);
            } else {
                minheap.offer(nums[j]);
            }
            if (nums[i] < median) {
                maxheap.remove(nums[i]);
            } else if (nums[i] == median) {
                if (minheap.size() > maxheap.size()) {
                    median = minheap.poll();
                } else {
                    median = maxheap.poll();
                }
            } else {
                minheap.remove(nums[i]);
            }
            median = adjust(maxheap, median, minheap);
            result.add(median);
            j++;
            i++;
        }
        
        return result;
    }
    
    public int adjust(PriorityQueue<Integer> maxheap, int median, PriorityQueue<Integer> minheap) {
        if (minheap.size() > maxheap.size() && minheap.size() - maxheap.size() <= 1) {
            return median;
        }
        
        if (maxheap.size() > minheap.size()) {
            while (maxheap.size() > minheap.size()) {
                minheap.offer(median);
                median = maxheap.poll();
            }
        } else {
            while (minheap.size() - maxheap.size() > 1) {
                maxheap.offer(median);
                median = minheap.poll();
            }
        }
        return median;
    }

}
