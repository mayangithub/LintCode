/**
 * 
 */
package edu.pitt.segmenttree;

import java.util.ArrayList;

import edu.pitt.segmenttree.IntervalMinimumNumber_205.Interval;

/**
 * Interval Sum #206 --- Accepted
 * Given an integer array (index from 0 to n-1, where n is the size of this array), and an query list. 
 * Each query has two integers [start, end]. 
 * For each query, calculate the sum number between index start and end in the given array, return the result list.
 * Example
 * For array [1,2,7,8,5], and queries [(0,4),(1,2),(2,4)], return [23,9,20]
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
public class IntervalSum_206 {
	
	public class SumSegmentTreeNode {
        public int start, end;
        public long sum;
        public SumSegmentTreeNode left, right;
        public SumSegmentTreeNode(int start, int end, long sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
            this.left = this.right = null;
        }
    }
    
    
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    public ArrayList<Long> intervalSum(int[] A, 
                                       ArrayList<Interval> queries) {
        // write your code here
        ArrayList<Long> result = new ArrayList<Long>();
        if (A == null || A.length == 0 || queries == null || queries.size() == 0) {
            return result;
        }
        
        SumSegmentTreeNode root = build(A, 0, A.length - 1);
        
        for (Interval interval: queries) {
            long sum = query(root, interval.start, interval.end);
            result.add(sum);
        }
        
        return result;
    }
    
    public SumSegmentTreeNode build(int[] A, int start, int end) {
        if (start > end) {
            return null;
        }
        
        if (start == end) {
            return new SumSegmentTreeNode(start, end, A[start]);
        }
        
        int mid = (start + end) / 2;
        SumSegmentTreeNode root = new SumSegmentTreeNode(start, end, 0);
        root.left = build(A, start, mid);
        root.right = build(A, mid + 1, end);
        root.sum = root.left.sum + root.right.sum;
        return root;
    }
    
    public long query(SumSegmentTreeNode root, int start, int end) {
        if (start > end) {
            return 0;
        }
        
        if (root.start == start && root.end == end) {
            return root.sum;
        }
        
        int mid = (root.start + root.end) / 2;
        long sumleft = 0;
        long sumright = 0;
        
        if (start <= mid) {
            if (end >= mid) {
                sumleft = query(root.left, start, mid);
            } else {
                sumleft = query(root.left, start, end);
            }
        }
        
        if (end >= mid + 1) {
            if (start < mid + 1) {
                sumright = query(root.right, mid + 1, end);
            } else {
                sumright = query(root.right, start, end);
            }
        }
        
        return sumleft + sumright;
    }

}
