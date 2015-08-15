/**
 * 
 */
package edu.pitt.segmenttree;

import java.util.ArrayList;

/**
 * Count of Smaller Number before itself #249 --- Accepted
 * Give you an integer array (index from 0 to n-1, where n is the size of this array, value from 0 to 10000) . 
 * For each element Ai in the array, count the number of element before this element Ai is smaller than it and return count number array.
 *  Example
 * For array [1,2,7,8,5], return [0,1,2,3,2]
 * Note
 * We suggest you finish problem Segment Tree Build, Segment Tree Query II and Count of Smaller Number before itself I first.
 * @author yanma
 * @category Segment Tree
 * @version 2015-08-14
 * @class 2,3
 * @week2 0810-0816
 */
public class CountofSmallerNumberbeforeitself_249 {
	
	public class CountSegmentTreeNode {
        public int start, end, count;
        public CountSegmentTreeNode left, right;
        public CountSegmentTreeNode(int start, int end, int count) {
            this.start = start;
            this.end = end;
            this.count = count;
            this.left = this.right = null;
        }
    }
   /**
     * @param A: An integer array
     * @return: Count the number of element before this element 'ai' is 
     *          smaller than it and return count number array
     */ 
    public ArrayList<Integer> countOfSmallerNumberII(int[] A) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (A == null || A.length == 0) {
            return result;
        }
        
        int min = 0;
        int max = 10000;
        CountSegmentTreeNode root = build(min, max);
        for (int i = 0; i < A.length; i++) {
            int num = query(root, min, A[i] - 1);
            result.add(num);
            insert(root, A[i]);
        }
        
        return result;
    }
    
    public CountSegmentTreeNode build(int start, int end) {
        if (start > end) {
            return null;
        }
        
        if (start == end) {
            return new CountSegmentTreeNode(start, end, 0);
        }
        
        int mid = (start + end) / 2;
        CountSegmentTreeNode root = new CountSegmentTreeNode(start, end, 0);
        root.left = build(start, mid);
        root.right = build(mid + 1, end);
        return root;
    }
    
    public void insert(CountSegmentTreeNode root, int value) {
        if (value < root.start || value > root.end) {
            return;
        }
        
        if (root.start == value && root.end == value) {
            root.count += 1;
            return;
        }
        
        int mid = (root.start + root.end) / 2;
        if (value <= mid) {
            insert(root.left, value);
        } else if (value >= mid + 1) {
            insert(root.right, value);
        }
        
        root.count = root.left.count + root.right.count;
    }
    
    public int query(CountSegmentTreeNode root, int start, int end) {
        if (start > end) {
            return 0;
        }
        
        if (root.start == start && root.end == end) {
            return root.count;
        }
        
        int mid = (root.start + root.end) / 2;
        int countleft = 0;
        int countright = 0;
        
        if (start <= mid) {
            if (end > mid) {
                countleft = query(root.left, start, mid);
            } else {
                countleft = query(root.left, start, end);
            }
        }
        
        if (end >= mid + 1) {
            if (start < mid + 1) {
                countright = query(root.right, mid + 1, end);
            } else {
                countright = query(root.right, start, end);
            }
        }
        
        return countleft + countright;
    }

}
