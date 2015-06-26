/**
 * 
 */
package edu.pitt.binarytree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Binary Tree Preorder Traversal #66 --- Accepted
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * Example
 * Given binary tree {1,#,2,3}:
 * 1
 *  \
 *   2
 *  /
 * 3
 * return [1,2,3].
 * Challenge
 * Can you do it without recursion?
 * @author yanma
 * @category Binary Tree
 * @version 2015-06-26
 * @class 3
 */
public class BinaryTreePreorderTraversal_66 {
	
	/**
	 * Recursion
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		// write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        
        result.add(root.val);
        ArrayList<Integer> left = preorderTraversal(root.left);
        ArrayList<Integer> right = preorderTraversal(root.right);
        
        result.addAll(left);
        result.addAll(right);
        
        return result;
    }
	
	
	/**
	 * Non recursion
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal1(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            result.add(top.val);
            if (top.right != null) {
                stack.push(top.right);
            }
            if (top.left != null) {
                stack.push(top.left);
            }
        }

        return result;
    }
	
	

}
