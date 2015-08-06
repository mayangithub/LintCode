/**
 * 
 */
package edu.pitt.easy;

import java.util.Stack;

import edu.pitt.binarytree.TreeNode;

/**
 * Invert Binary Tree #175 --- Accepted
 * Invert a binary tree.
 * Example
 *   1         1
 * 	 / \       / \
 * 	2   3  => 3   2
 * 	   /       \
 * 	  4         4
 * Challenge
 * Do it in recursion is acceptable, can you do it without recursion?
 * @author yanma
 * @category Easy Level
 * @version 2015-08-05
 * @week1 0803-0809
 */
public class InvertBinaryTree_175 {
	
	/**
	 * Non-recursive
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        // write your code here
        if (root != null) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode out = stack.pop();
                TreeNode temp = out.left;
                out.left = out.right;
                out.right = temp;
                if (out.left != null) {
                    stack.push(out.left);
                }
                if (out.right != null) {
                    stack.push(out.right);
                }
            }
        }
    }
    
    /**
     * Recursive
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree1(TreeNode root) {
        // write your code here
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertBinaryTree(root.left);
            invertBinaryTree(root.right);
        }
        
    }

}
