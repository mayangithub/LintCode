/**
 * 
 */
package edu.pitt.datastructure;

import java.util.Stack;

import edu.pitt.binarytree.TreeNode;

/**
 * Max Tree #126 --- Accepted
 * Given an integer array with no duplicates. A max tree building on this array is defined as follow:
    The root is the maximum number in the array
    The left subtree and right subtree are the max trees of the subarray divided by the root number.
 * Construct the max tree by the given array.
 * Example
 * Given [2, 5, 6, 0, 3, 1], the max tree constructed by this array is:
 * 	    6
 * 	   / \
 * 	  5   3
 * 	 /   / \
 * 	2   0   1
 * Challenge
 * O(n) time and memory.
 * @author yanma
 * @category Data Structure
 * @version 2015-07-19
 * @class 8
 */
public class MaxTree_126 {
	
	/**
	 * using stack
	 * find the first larger number on the left and find the first larger number on the right
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return null;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(new TreeNode(A[0]));
        TreeNode root = null;
        int index = 1;
        while (index < A.length) {
            if (A[index] < stack.peek().val) {
                stack.push(new TreeNode(A[index]));
                index++;
            } else {
                TreeNode node = new TreeNode(A[index]);
                while (!stack.empty()) {
                    if (stack.peek().val > A[index]) {
                        stack.push(node);
                        break;
                    }
                    
                    TreeNode temp = stack.pop();
                    if (!stack.empty() && stack.peek().val < node.val) {
                        stack.peek().right = temp;
                    } else {
                        node.left = temp;
                    }
                    
                }
                if (stack.empty()) {
                    stack.push(node);
                }
                index++;
            }
        }
        
        while (!stack.empty()) {
            TreeNode pop = stack.pop();
            if (stack.empty()) {
                root = pop;
                break;
            }
            stack.peek().right = pop;
        }
        
        return root;
    }
    
    /**
     * Stack Overflow 14/16 passed
     * using recursion
     * O(n^2) time worst time occurs
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree1(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return null;
        }
        
        return helper(A, 0, A.length - 1);
    }
    
    public TreeNode helper(int[] A, int start, int end) {
        if (A == null || A.length == 0 || start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(A[start]); 
        }
        
        int maxIndex = start;
        
        for (int i = start + 1; i <= end; i++) {
            if (A[i] > A[maxIndex]) {
                maxIndex = i;
            }
        }
        
        TreeNode root = new TreeNode(A[maxIndex]);
        root.left = helper(A, start, maxIndex - 1);
        root.right = helper(A, maxIndex + 1, end);
        
        return root;
    }

}
