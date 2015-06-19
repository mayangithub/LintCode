/**
 * 
 */
package edu.pitt.binarysearch;

import java.util.ArrayList;

/**
 * Search for a Range #61 --- Accepted
 * Given a sorted array of n integers, find the starting and ending position of a given target value.
 * If the target is not found in the array, return [-1, -1].
 * Example
 * Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 * Challenge
 * O(log n) time.
 * @author yanma
 * @category Binary Search
 * @version 2015-06-19
 * @class 2
 */
public class SearchforaRange_61 {
	
	
	/** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (A == null || A.size() == 0) {
            result.add(-1);
            result.add(-1);
            return result;
        }
        
        if (A.get(0) == target && A.get(A.size() - 1) == target) {
            result.add(0);
            result.add(A.size() - 1);
            return result;
        }
        
        int start = 0;
        int end = A.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A.get(mid) == target) {
                result.add(findStart(A, target, start, mid));
                result.add(findEnd(A, target, mid, end));
                return result;
            } else if (A.get(mid) < target) {
                start = mid;
            } else if (A.get(mid) > target) {
                end = mid;
            }
        }
        
        if (A.get(start) == target && A.get(end) == target) {
            result.add(start);
            result.add(end);
            return result;
        } else if (A.get(start) == target && A.get(end) != target) {
            result.add(start);
            result.add(start);
            return result;
        } else if (A.get(start) != target && A.get(end) == target) {
            result.add(end);
            result.add(end);
            return result;
        }
        
        result.add(-1);
        result.add(-1);
        return result;
        
    }
    
    public int findStart(ArrayList<Integer> A, int target, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A.get(mid) == target) {
                if (A.get(mid - 1) == target) {
                    end = mid;
                } else {
                    return mid;
                }
            } else if (A.get(mid) > target) {
                end = mid;
            } else if (A.get(mid) < target) {
                start = mid;
            }
        }
        
        if (A.get(start) == target) {
            return start;
        } else if (A.get(end) == target) {
            return end;
        }
        return -1;
    }
    
    public int findEnd(ArrayList<Integer> A, int target, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A.get(mid) == target) {
                if (A.get(mid + 1) == target) {
                    start = mid;
                } else {
                    return mid;
                }
            } else if (A.get(mid) > target) {
                end = mid;
            } else if (A.get(mid) < target) {
                start = mid;
            }
        }
        
        if (A.get(end) == target) {
            return end;
        } else if (A.get(start) == target) {
            return start;
        }
        return -1;
    }
    
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
