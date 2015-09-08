/**
 * 
 */
package edu.pitt.twopointers;

import java.util.HashMap;

/**
 * Subarray Sum II #404 --- Accepted
 * Given an integer array, find a subarray where the sum of numbers is between two given interval. 
 * Your code should return the number of possible answer.
 * Example
 * Given [1,2,3,4] and interval = [1,3], return 4. The possible answers are:
 * [0, 0]
 * [0, 1]
 * [1, 1]
 * [2, 2]
 * @author yanma
 * @category Two Pointers
 * @version 2015-09-07
 * @class 5
 * @week 6 0907-0913
 */
public class SubarraySumII_404 {
	
	/**
	 * using hashmap and Element class to store previous sums
	 * O(n) time
     * @param A an integer array
     * @param start an integer
     * @param end an integer
     * @return the number of possible answer
     */
     
    class Element {
        int sum;
        int times;
        Element(int s, int t) {
            this.sum = s;
            this.times = t;
        }
    }
    public int subarraySumII(int[] A, int start, int end) {
        // Write your code here
        if (A == null || A.length == 0 || start > end) {
            return 0;
        }
        
        HashMap<Integer, Element> map = new HashMap<Integer, Element>(); 
        int sum = 0;
        int count = 0;
        map.put(0, new Element(0, 1));
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            for (Element e : map.values()) {
                if (sum - e.sum >= start && sum - e.sum <= end) {
                    count += e.times;
                }
            }
            if (!map.containsKey(sum)) {
                map.put(sum, new Element(sum, 1));
            } else {
                Element ele = map.get(sum);
                ele.times += 1;
            }
        }
        
        return count;
    }
	
	/**
	 * O(n ^ 2) basic solution
     * @param A an integer array
     * @param start an integer
     * @param end an integer
     * @return the number of possible answer
     */
    public int subarraySumII1(int[] A, int start, int end) {
        // Write your code here
        if (A == null || A.length == 0 || start > end) {
            return 0;
        }
        
        int count = 0;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = 0;
            for (int j = i; j < A.length; j++) {
                sum += A[j];
                if (sum >= start && sum <= end) {
                    count++;
                }
            }
        }
        
        return count;
    }

}
