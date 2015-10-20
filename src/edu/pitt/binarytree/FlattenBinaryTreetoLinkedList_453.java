/**
 * 
 */
package edu.pitt.binarytree;

import java.util.Stack;

/**
 * Flatten Binary Tree to Linked List Show result #453 --- Accepted
 * Flatten a binary tree to a fake "linked list" in pre-order traversal.
 * Here we use the right pointer in TreeNode as the next pointer in ListNode.
 * Example
 * 	              1
 * 	               \
 * 	     1          2
 * 	    / \          \
 * 	   2   5    =>    3
 * 	  / \   \          \
 * 	 3   4   6          4
 * 	                     \
 * 	                      5
 * 	                       \
 * 	                        6
 * Note
 * Don't forget to mark the left child of each node to null. Or you will get Time Limit Exceeded or Memory Limit Exceeded.
 * Challenge
 * Do it in-place without any extra memory.
 * @author yanma
 * @version 2015-10-20
 * @category Binary Tree, DFS
 * @week 12 1019-1025
 */
public class FlattenBinaryTreetoLinkedList_453 {
	/**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        // write your code here
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        TreeNode dummy = new TreeNode(-1);
        TreeNode pre = dummy;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode out = stack.pop();
            if (out.right != null) {
                stack.push(out.right);
                out.right = null;
            }
            if (out.left != null) {
                stack.push(out.left);
                out.left = null;
            }
            pre.right = out;
            pre = out;
        }
        root = dummy.right;
    }
    
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     * Traversal
     */
     
    public TreeNode prev = null;
    public void flatten1(TreeNode root) {
        // write your code here
        if (root == null) {
            return;
        }
        if (prev != null) {
            prev.right = root;
        }
        prev = root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        prev.left = null;
        prev.right = null;
        flatten(left);
        flatten(right);
    }
    
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
     
    public void flatten2(TreeNode root) {
        // write your code here
        if (root == null) {
            return;
        }
        if (root.right == null) {
            root.right = root.left;
            root.left = null;
        }
        
        if (root.left == null) {
            flatten(root.right);
            return;
        }
        
        TreeNode right = root.right;
        TreeNode left = root.left;
        root.left = null;
        root.right = left;
        TreeNode lastnode = lastNode(left);
        lastnode.right = right;
        flatten2(right);
    }
    
    public TreeNode lastNode(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        
        if (root.right == null) {
            root.right = root.left;
            root.left = null;
        }
        if (root.left == null) {
            return lastNode(root.right);
        }
        
        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode last = lastNode(root.right);
        last.right = right;
        return lastNode(right);
    }

}
