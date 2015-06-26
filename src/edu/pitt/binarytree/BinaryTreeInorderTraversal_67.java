/**
 * 
 */
package edu.pitt.binarytree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Binary Tree Inorder Traversal #67 --- Accepted
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * Example
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [1,3,2].
 * Challenge
 * Can you do it without recursion?
 * @author yanma
 * @category Binary Tree
 * @version 2015-06-26
 * @class 3
 */
public class BinaryTreeInorderTraversal_67 {
	
	/**
	 * Non Recursion
     * @param root: The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pointer = root;
        while (pointer != null || !stack.isEmpty()) {
            while (pointer != null) {
                stack.push(pointer);
                pointer = pointer.left;
            }
            pointer = stack.pop();
            result.add(pointer.val);
            pointer = pointer.right;
        }
        
        return result;
    }
	
	
	/**
	 * Recursion Traverse
     * @param root: The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal1(TreeNode root) {
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
	
	
	/**
	 * Recursion Divide and Conquer
     * @param root: The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal2(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        
        if (root.left != null) {
            ArrayList<Integer> left = inorderTraversal(root.left);
            result.addAll(left);
        }
        result.add(root.val);
        if (root.right != null) {
            ArrayList<Integer> right = inorderTraversal(root.right);
            result.addAll(right);
        }
        
        return result;
    }
    
    
    
    /**
     * usefull for #95
     * @param root: The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     */
    public boolean firstNode = true;
    public TreeNode lastNode = null;
     
    public ArrayList<Integer> inorderTraversal3(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        
        if (root.left != null) {
           ArrayList<Integer> left = inorderTraversal(root.left); 
           result.addAll(left);
        }
        
        result.add(root.val);
        firstNode = false;
        if (root.right != null) {
            ArrayList<Integer> right = inorderTraversal(root.right);
            result.addAll(right);
        }
        return result;
    }

	
}
