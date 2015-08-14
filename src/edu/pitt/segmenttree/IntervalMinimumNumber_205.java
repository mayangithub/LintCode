/**
 * 
 */
package edu.pitt.segmenttree;

import java.util.ArrayList;

/**
 * Interval Minimum Number #205 --- Accepted
 * Given an integer array (index from 0 to n-1, where n is the size of this array), and an query list. 
 * Each query has two integers [start, end]. 
 * For each query, calculate the minimum number between index start and end in the given array, 
 * return the result list.
 *  Example
 * For array [1,2,7,8,5], and queries [(1,2),(0,4),(2,4)], return [2,1,5]
 * Note
 * We suggest you finish problem Segment Tree Build, Segment Tree Query and Segment Tree Modify first.
 * Challenge
 * O(logN) time for each query
 * @author yanma
 * @category Segment Tree
 * @version 2015-08-13
 * @class 2,3
 * @week2 0810-0816
 */
public class IntervalMinimumNumber_205 {
	public class SegmentTreeNode {
        public int start;
        public int end;
        public int min;
        public SegmentTreeNode left;
        public SegmentTreeNode right;
        
        public SegmentTreeNode(int s, int e, int min) {
            this.start = s;
            this.end = e;
            this.min = min;
            this.left = this.right = null;
        }
    }
	
	public class Interval {
		public int start;
		public int end;
		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
    
    
    
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    public ArrayList<Integer> intervalMinNumber(int[] A, ArrayList<Interval> queries) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (queries == null || queries.size() == 0) {
            return result;
        }
        
        SegmentTreeNode root = build(A, 0, A.length - 1);
        for (Interval interval: queries) {
            int min = query(root, interval.start, interval.end);
            result.add(min);
        }
        
        return result;
    }
    
    public SegmentTreeNode build(int[] A, int start, int end) {
        if (start > end) {
            return null;
        }
        
        if (start == end) {
            SegmentTreeNode node = new SegmentTreeNode(start, end, A[start]);
            return node;
        }
        
        int mid = (start + end) / 2;
        SegmentTreeNode root = new SegmentTreeNode(start, end, Integer.MAX_VALUE);
        root.left = build(A, start, mid);
        root.right = build(A, mid + 1, end);
        root.min = Math.min(root.left.min, root.right.min);
        
        return root;
    }
    
    public int query(SegmentTreeNode root, int start, int end) {
        if (start > end) {
            return Integer.MAX_VALUE;
        }
        
        if (start == root.start && end == root.end) {
            return root.min;
        }
        
        int mid = (root.start + root.end) / 2;
        int minleft = Integer.MAX_VALUE;
        int minright = Integer.MAX_VALUE;
        if (start <= mid) {
            if (end > mid) {
                minleft = query(root.left, start, mid);
            } else {
                minleft = query(root.left, start, end);
            }
        }
        
        if (end >= mid + 1) {
            if (start <= mid + 1) {
                minright = query(root.right, mid + 1, end);
            } else {
                minright = query(root.right, start, end);
            }
        }
        
        return Math.min(minleft, minright);
    }
}
