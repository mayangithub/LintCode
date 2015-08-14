/**
 * 
 */
package edu.pitt.segmenttree;

import java.util.Stack;

/**
 * Interval Sum II #207 --- Accepted
 * Given an integer array in the construct method, implement two methods query(start, end) and modify(index, value):

    For query(start, end), return the sum from index start to index end in the given array.
    For modify(index, value), modify the number in the given index to value
 * Example
 * Given array A = [1,2,7,8,5].
    query(0, 2), return 10.
    modify(0, 4), change A[0] from 1 to 4.
    query(0, 1), return 6.
    modify(2, 1), change A[2] from 7 to 1.
    query(2, 4), return 14.
 * Note
 * We suggest you finish problem Segment Tree Build, Segment Tree Query and Segment Tree Modify first.
 * Challenge
 * O(logN) time for query and modify.
 * @author yanma
 * @category Segment Tree
 * @version 2015-08-14
 * @class 2,3
 * @week2 0810-0816
 */
public class IntervalSumII_207 {
/* you may need to use some attributes here */
    
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
    public SumSegmentTreeNode root;
    /**
     * @param A: An integer array
     */
    public IntervalSumII_207(int[] A) {
        // write your code here
        this.root = build(A, 0, A.length - 1);
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
    
    /**
     * @param start, end: Indices
     * @return: The sum from start to end
     */
    public long query(int start, int end) {
        // write your code here
        if (start > end) {
            return 0;
        }
        
        SumSegmentTreeNode node = root;
        return queryhelper(node, start, end);
    }
    
    public long queryhelper(SumSegmentTreeNode root, int start, int end) { // because root is not included in query method
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
            if (end > mid) {
                sumleft = queryhelper(root.left, start, mid);
            } else {
                sumleft = queryhelper(root.left, start, end);
            }
        }
        
        if (end >= mid + 1) {
            if (start < mid + 1) {
                sumright = queryhelper(root.right, mid + 1, end);
            } else {
                sumright = queryhelper(root.right, start, end);
            }
        }
        
        return sumleft + sumright;
    }
    
    /**
     * @param index, value: modify A[index] to value.
     */
    public void modify(int index, int value) {
        // write your code here
        if (index < root.start || index > root.end) {
            return;
        }
        
        Stack<SumSegmentTreeNode> stack = new Stack<SumSegmentTreeNode>();
        SumSegmentTreeNode node = root;
        while (node.start != node.end) {
            stack.push(node);
            int mid = (node.start + node.end) / 2;
            if (index <= mid) {
                node = node.left;
            } else if (index >= mid + 1) {
                node = node.right;
            }
        }
        
        node.sum = value;
        while (!stack.isEmpty()) {
            node = stack.pop();
            node.sum = node.left.sum + node.right.sum;
        }
    }

}
