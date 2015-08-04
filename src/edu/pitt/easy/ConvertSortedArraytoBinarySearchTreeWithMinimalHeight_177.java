/**
 * 
 */
package edu.pitt.easy;

import edu.pitt.binarytree.TreeNode;

/**
 * Convert Sorted Array to Binary Search Tree With Minimal Height #177 --- Accepted
 * Given a sorted (increasing order) array, Convert it to create a binary tree with minimal height.
 * Example
 * Given [1,2,3,4,5,6,7], return
	     4
	   /   \
	  2     6
	 / \    / \
	1   3  5   7
 * Note
 * There may exist multiple valid solutions, return any of them.
 * @author yanma
 * @category Easy Level
 * @version 2015-08-03
 * @week 1 0803-0809
 */
public class ConvertSortedArraytoBinarySearchTreeWithMinimalHeight_177 {
	/**
     * @param A: an integer array
     * @return: a tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {  
        // write your code here
        if (A == null || A.length == 0) {
            return null;
        }
        
        return helper(A, 0, A.length - 1);
    }  
    
    public TreeNode helper(int[] A, int start, int end) {
        if (start > end) {
            return null;
        }
        
        if (start == end) {
            return new TreeNode(A[start]);
        }
        
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(A[mid]);
        root.left = helper(A, start, mid - 1);
        root.right = helper(A, mid + 1, end);
        return root;
    }

}
