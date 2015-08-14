/**
 * 
 */
package edu.pitt.segmenttree;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Count of Smaller Number #248 --- Accepted
 * Give you an integer array (index from 0 to n-1, where n is the size of this array, value from 0 to 10000) and an query list. 
 * For each query, give you an integer, return the number of element in the array that are smaller that the given integer.
 * Example
 * For array [1,2,7,8,5], and queries [1,8,5], return [0,4,2]
 * Note
 * We suggest you finish problem Segment Tree Build and Segment Tree Query II first.
 * Challenge
 * Could you use three ways to do it.
    Just loop
    Sort and binary search
    Build Segment Tree and Search.
 * @author yanma
 * @category Segment Tree
 * @version 2015-08-13
 * @class 2,3
 * @week2 0810-0816
 */
public class CountofSmallerNumber_248 {
	
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
     * @return: The number of element in the array that 
     *          are smaller that the given integer
     */
    public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (A == null || queries == null || queries.length == 0) {
            return result;
        }
        
        //min & max: question provided, to avoid null pointer when A = []; empty array
        int max = 10000; 
        int min = 0;
        
        CountSegmentTreeNode root = build(A, min, max);
        //after build, then update from bottom to top
        for (int i = 0; i < A.length; i++) {
            insert(A[i], root);
        }
        
        for (int i = 0; i < queries.length; i++) {
            int count = query(root, min, queries[i] - 1);
            result.add(count);
        }
        
        return result;
    }
    
    public CountSegmentTreeNode build(int[] A, int start, int end) {
        if (start > end) {
            return null;
        }
        
        if (start == end) {
            return new CountSegmentTreeNode(start, end, 0);
        }
        
        int mid = (start + end) / 2;
        CountSegmentTreeNode root = new CountSegmentTreeNode(start, end, 0);
        root.left = build(A, start, mid);
        root.right = build(A, mid + 1, end);
        //don't include update in build, otherwise will update each time when create a node
        return root;
    }
    
    //insert/update from bottom to top, should be exclude from build
    public void insert(int num, CountSegmentTreeNode root) {
        if (root == null || num < root.start || num > root.end) {
            return;
        }
        if (root.start == num && root.end == num) {
            root.count += 1;
            return;
        }
        
        int mid = (root.start + root.end) / 2;
        if (num <= mid) {
            insert(num, root.left);
        } else if (num >= mid + 1) {
            insert(num, root.right);
        }
        root.count = root.left.count + root.right.count;
        
        //OR use stack to update
//        Stack<CountSegmentTreeNode> stack = new Stack<CountSegmentTreeNode>();
//        CountSegmentTreeNode node = root;
//        while (node.start != node.end) {
//            stack.push(node);
//            int mid = (node.start + node.end) / 2;
//            if (num <= mid) {
//                node = node.left;
//            } else if (num >= mid + 1) {
//                node = node.right;
//            }
//        }
//        
//        node.count += 1;
//        while (!stack.isEmpty()) {
//            node = stack.pop();
//            node.count = node.left.count + node.right.count;
//        }
    }
    
    public int query(CountSegmentTreeNode root, int start, int end) {
        if (start > end) {
            return 0;
        }
        
        if (start == root.start && end == root.end) {
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
	
	
	
	/**
	    * sort, and binary search
	     * @param A: An integer array
	     * @return: The number of element in the array that 
	     *          are smaller that the given integer
	     */
	    public ArrayList<Integer> countOfSmallerNumber2(int[] A, int[] queries) {
	        // write your code here
	        ArrayList<Integer> result = new ArrayList<Integer>();
	        if (A == null || queries == null || queries.length == 0) {
	            return result;
	        }
	        
	        Arrays.sort(A);
	        for (int i = 0; i < queries.length; i++) {
	            int pos = find(A, queries[i]);
	            if (pos == -1) {
	                result.add(0);
	            } else {
	                result.add(pos);
	            }
	        }
	        
	        return result;
	    }
	    
	    public int find(int[] A, int num) {
	        if (A == null || A.length == 0 || num < A[0] || num > A[A.length - 1]) {
	            return -1;
	        } // not found
	        
	        int start = 0;
	        int end = A.length - 1;
	        
	        while (start + 1 < end) {
	            int mid = start + (end - start) / 2;
	            if (A[mid] == num) {
	                end = mid;
	            } else if (A[mid] < num) {
	                start = mid;
	            } else if (A[mid] > num) {
	                end = mid;
	            }
	        }
	        
	        if (A[start] == num) {
	            return start;
	        } else if (A[end] == num) {
	            return end;
	        }
	        
	        if (A[start] > num) {
	            return start;
	        }
	        return end;
	    }
	
	
	/**
	    * just loop
	     * @param A: An integer array
	     * @return: The number of element in the array that 
	     *          are smaller that the given integer
	     */
	    public ArrayList<Integer> countOfSmallerNumber1(int[] A, int[] queries) {
	        // write your code here
	        ArrayList<Integer> result = new ArrayList<Integer>();
	        if (A == null || queries == null || queries.length == 0) {
	            return result;
	        }
	        
	        Arrays.sort(A);
	        for (int i = 0; i < queries.length; i++) {
	            int count = 0;
	            int num = queries[i];
	            for (int j = 0; j < A.length; j++) {
	                if (A[j] < num) {
	                    count++;
	                } else {
	                    break;
	                }
	            }
	            result.add(count);
	        }
	        
	        return result;
	    }

}
