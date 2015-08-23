/**
 * 
 */
package edu.pitt.deque;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Sliding Window Maximum #362 --- Accepted
 * Given an array of n integer with duplicate number, and a moving window(size k), 
 * move the window at each iteration from the start of the array, 
 * find the maximum number inside the window at each moving. 
 * Example
 * For array [1, 2, 7, 7, 8], moving window size k = 3. return [7, 7, 8]
 * At first the window is at the start of the array like this
 * [|1, 2, 7| ,7, 8] , return the maximum 7;
 * then the window move one step forward.
 * [1, |2, 7 ,7|, 8], return the maximum 7;
 * then the window move one step forward again.
 * [1, 2, |7, 7, 8|], return the maximum 8;
 * Challenge
 * o(n) time and O(k) memory
 * @author yanma
 * @category Deque
 * @version 2015-08-23
 * @class 4
 * @week3 0817-0823
 */
public class SlidingWindowMaximum_362 {
	
	/**
	 * using Deque -- Accepted
     * @param nums: A list of integers.
     * @return: The maximum number inside the window at each moving.
     */
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length < k || k == 0) {
            return result;
        }
        Deque<Integer> deque = new LinkedList<Integer>();
        deque.offerLast(nums[0]);
        for (int i = 1; i < k; i++) {
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.pollLast();
            }
            deque.offerLast(nums[i]);
        }
        result.add(deque.peekFirst());
        
        int j = k;
        int i = 0;
        while (j < nums.length) {
            while (!deque.isEmpty() && nums[j] > deque.peekLast()) {
                deque.pollLast();
            }
            deque.offerLast(nums[j]);
            if (nums[i] == deque.peekFirst()) {
                deque.pollFirst();
            }
            i++;
            j++;
            result.add(deque.peekFirst());
        }
        
        return result;
    }
	

    public class MaxComparator implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            if (a.intValue() > b.intValue()) {
                return -1;
            } else if (a.intValue() == b.intValue()) {
                return 0;
            } else {
                return 1;
            }
        }
    }
    
    /**
     * Using maxheap
     * will exceed time limits
     * @param nums: A list of integers.
     * @return: The maximum number inside the window at each moving.
     */
    public ArrayList<Integer> maxSlidingWindow1(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length < k || k == 0) {
            return result;
        }
        PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(1, new MaxComparator());
        
        for (int i = 0; i < k; i++) {
            maxheap.offer(nums[i]);
        }
        result.add(maxheap.peek());
        int i = 0; 
        int j = k;
        while (j < nums.length) {
            maxheap.offer(nums[j]);
            maxheap.remove(nums[i]);
            result.add(maxheap.peek());
            j++;
            i++;
        }
        return result;
    }

}
