/**
 * 
 */
package edu.pitt.cc;

import java.util.ArrayList;

/**
 * Kth Largest Element #5 --- Accepted
 * Find K-th largest element in an array.
 * Example
 * In array [9,3,2,4,8], the 3rd largest element is 4.
 * In array [1,2,3,4,5], the 1st largest element is 5, 2nd largest element is 4, 3rd largest element is 3 and etc.
 * Note
 * You can swap elements in the array
 * Challenge
 * O(n) time, O(1) extra memory.
 * @author yanma
 * @version 2015-09-28
 * @category CC
 * @week 9 0928-1004
 */
public class KthLargestElement_5 {
	//param k : description of k
    //param numbers : array of numbers
    //return: description of return
	// using quick sort
    public int kthLargestElement(int k, ArrayList<Integer> numbers) {
        // write your code here
        if (numbers == null || numbers.size() < k) {
            return 0;
        }
        
        return helper(k, numbers, 0, numbers.size() - 1);
    }
    
    public int helper(int k, ArrayList<Integer> numbers, int low, int hi) {
        if (low > hi || k > hi - low + 1 || k <= 0) {
            return 0;
        }
        if (low == hi) {
            return numbers.get(low);
        }
        
        int pivot = numbers.get(low);
        int i = low;
        int j = i + 1;
        while (j <= hi) {
            if (numbers.get(j) < pivot) {
                int temp = numbers.get(j);
                numbers.set(j, numbers.get(i + 1));
                numbers.set(i + 1, temp);
                j++;
                i++;
            } else {
                j++;
            }
        }
        int temp = numbers.get(i);
        numbers.set(i, pivot);
        numbers.set(low, temp);
        
        if (k == hi - i + 1) {
            return numbers.get(i);
        } else if (k > hi - i + 1) {
            return helper(k - (hi - i + 1), numbers, low, i - 1);
        } else {
            return helper(k, numbers, i + 1, hi);
        }
    }

}
