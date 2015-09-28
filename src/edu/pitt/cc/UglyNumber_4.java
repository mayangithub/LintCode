/**
 * 
 */
package edu.pitt.cc;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Ugly Number #4 --- Accepted
 * Ugly number is a number that only have factors 3, 5 and 7.
 * Design an algorithm to find the Kth ugly number. The first 5 ugly numbers are 3, 5, 7, 9, 15 ...
 * Example
 * If K=4, return 9.
 * Challenge
 * O(K log K) or O(K) time.
 * @author yanma
 * @category CC
 * @version 2015-09-28
 * @week 9 0928-1004
 */
public class UglyNumber_4 {
	/**
     * @param k: The number k.
     * @return: The kth prime number as description.
     */
    public long kthPrimeNumber(int k) {
        // write your code here
        if (k == 0) {
            return 0;
        }
        
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        long[] primes = {3,5,7};
        HashMap<Long, Boolean> map = new HashMap<Long, Boolean>();
        
        for (int i = 0; i < 3; i++) {
            heap.offer(primes[i]);
            map.put(primes[i], true);
        }
        
        for (int i = 0; i < k - 1; i++) {
            long out = heap.poll();
            
            for (int j = 0; j < 3; j++) {
                if (!map.containsKey(out * primes[j])) {
                    heap.offer(out * primes[j]);
                    map.put(out * primes[j], true);
                }
            }
        }
        
        return heap.poll();
    }

}
