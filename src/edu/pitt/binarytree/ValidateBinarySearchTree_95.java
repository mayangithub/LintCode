/**
 * 
 */
package edu.pitt.binarytree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Validate Binary Search Tree #95 --- Accepted
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 *     The left subtree of a node contains only nodes with keys less than the node's key.
 *     The right subtree of a node contains only nodes with keys greater than the node's key.
 *     Both the left and right subtrees must also be binary search trees.
 * Example
 * An example:
 *   2
 *  / \
 * 1   3
 *    /
 *   4
 *    \
 *     5
 * The above binary tree is serialized as {2,1,3,#,#,4,#,#,5} (in level order).
 * @note: valid BST < = > inorder traversal in strict ascending order
 * @author yanma
 * @category Binary Tree
 * @version 2015-06-26
 * @class 3
 * 
 */
public class ValidateBinarySearchTree_95 {

	 /**
	  * Non Recursion
	  * only using prenode variable
	  * @Trick: the global variable will change all the time, will always be the previous node
	  * @Note: all right-side nodes should have value greater than left-side nodes, vice versa
	  * @param root: The root of binary tree.
	  * @return: True if the binary tree is BST, or false
	  */
    public TreeNode prenode = null;
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        
        if (!isValidBST(root.left)) {
            return false;
        }
        
        if (prenode != null && root.val <= prenode.val) {
            return false;   
        }
        
        prenode = root;
        if (!isValidBST(root.right)) {
            return false;
        }

        return true;
    }
    
	
	
	
	/**
	 * Non Recursion
	 * using stack to inorder traversal, not using array list
	 * compare with prenode variable value
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST3(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        
        TreeNode pre = null;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode temp = root;
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            
            temp = stack.pop();
            if (pre != null && temp.val <= pre.val) {
                return false;
            }
            pre = temp;
            temp = temp.right;
        }

        return true;
    }
    
    
	
	
	
	/**
	 * Recursion 
	 * using inorder traversal 
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST2(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        
        ArrayList<Integer> result = inorderTraversal2(root);
        
        for (int i = 1; i < result.size(); i++) {
            if (result.get(i) <= result.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
    
    public ArrayList<Integer> inorderTraversal2(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode temp = root;
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            
            temp = stack.pop();
            result.add(temp.val);
            temp = temp.right;
        }
        
        return result;
    }
	
	
	
	
	/**
	 * Recursion 
	 * using Inorder Traversal Program
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST1(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        
        ArrayList<Integer> result = inorderTraversal(root);
        
        for (int i = 1; i < result.size(); i++) {
            if (result.get(i) <= result.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
    
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        traverse(root, result);
        return result;
    }
    
    public void traverse(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        
        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
    }
}
