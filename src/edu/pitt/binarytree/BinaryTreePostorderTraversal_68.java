/**
 * 
 */
package edu.pitt.binarytree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Binary Tree Postorder Traversal #68 --- Accepted
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * Example
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [3,2,1].
 * Challenge
 * Can you do it without recursion?
 * @author yanma
 * @category Binary Tree
 * @version 2015-07-07
 * @class 3
 */
public class BinaryTreePostorderTraversal_68 {
	
	/**
	 * Iterative
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null;
        TreeNode curr = root;
        stack.push(root);
        while (!stack.isEmpty()) {
            curr = stack.peek();
            if (prev == null || prev.left == curr || prev.right == curr) {
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else if (curr.left == prev) {
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else {
                result.add(curr.val);
                stack.pop();
            }
            prev = curr;
        }
        return result;
    }
	
	/**
	 * Recursion
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal1(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        
        result.addAll(postorderTraversal1(root.left));
        result.addAll(postorderTraversal1(root.right));
        result.add(root.val);
        return result;
    }

}
