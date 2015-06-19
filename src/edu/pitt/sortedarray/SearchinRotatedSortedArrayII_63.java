/**
 * 
 */
package edu.pitt.sortedarray;

/**
 * Search in Rotated Sorted Array II #63 --- accepted
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 * @author yanma
 * @category Sorted Array
 * @version 2015-06-19
 * @class 2
 */
public class SearchinRotatedSortedArrayII_63 {

	
	/** 
     * param A : an integer ratated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean 
     */
    public boolean search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return false;
        }
        
        for (int num: A) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
	
}
