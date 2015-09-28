/**
 * 
 */
package edu.pitt.cc;

import java.util.ArrayList;
import java.util.List;

/**
 * Print Numbers by Recursion #371 --- Accepted
 * Print numbers from 1 to the largest number with N digits by recursion.
 * Example
 * Given N = 1, return [1,2,3,4,5,6,7,8,9].
 * Given N = 2, return [1,2,3,4,5,6,7,8,9,10,11,12,...,99].
 * Note
 * It's pretty easy to do recursion like:
 * 	recursion(i) {
 * 	    if i > largest number:
 * 	        return
 * 	    results.add(i)
 * 	    recursion(i + 1)
 * 	}
 * however this cost a lot of recursion memory as the recursion depth maybe very large. Can you do it in another way to recursive with at most N depth?
 * Challenge
 * Do it in recursion, not for-loop.
 * @author yanma
 * @version 2015-09-28
 * @category CC
 * @week 9 0928-1004
 */
public class PrintNumbersbyRecursion_371 {
	
	/**
     * @param n: An integer.
     * return : An array storing 1 to the largest number with n digits.
     */
    
    public List<Integer> numbersByRecursion(int n) {
        // write your code here
        List<Integer> result = new ArrayList<Integer>();
        if (n == 0) {
            return result;
        }
        
        for (int i = 1; i <= n; i++) {
            recursion(i, result);
        }
        
        return result;
    }
    
    public void recursion(int n, List<Integer> list) {
        if (n == 1) {
            for (int i = 1; i <= 9; i++) {
                list.add(i);
            }
            return;
        }
        if (n > 1) {
            int size = list.size();
            for (int i = 1; i<= 9; i++) {
                int big = i * (int) Math.pow(10, n - 1);
                list.add(big);
                for (int j = 0; j < size; j++) {
                    list.add(big + list.get(j));
                }
            }
        }
    }

}
