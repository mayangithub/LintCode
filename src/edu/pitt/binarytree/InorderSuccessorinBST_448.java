/**
 * 
 */
package edu.pitt.binarytree;

import java.util.Stack;

/**
 * Inorder Successor in BST #448 --- Accepted
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 * Example
 * Given tree = [2,1] and node = 1:
	  2
	 /
	1
 * return node 2.
 * Given tree = [2,1,3] and node = 2:
	  2
	 / \
	1   3
 * return node 3.
 * Note
 * If the given node has no in-order successor in the tree, return null.
 * Challenge
 * O(h), where h is the height of the BST.
 * @author yanma
 * @category Binary Tree
 * @version 2015-10-06
 * @week 10 1005-1011
 */
public class InorderSuccessorinBST_448 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        if (root == null || p == null) {
            return null;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.peek();
            if (p.val > top.val) {
                stack.push(top.right);
            } else if (p.val < top.val) {
                stack.push(top.left);
            } else {
                if (top.right != null) {
                    return findLeft(top.right);
                } 
                TreeNode out = stack.pop();
                return next(out, stack);
            }
        }
        return null;
    }
    
    public TreeNode next(TreeNode out, Stack<TreeNode> stack) {
        if (stack.isEmpty()) {
            return null;
        }
        
        TreeNode peek = stack.peek();
        if (peek.left == out) {
            return peek;
        }
        
        out = stack.pop();
        return next(out, stack);
    }
    
    public TreeNode findLeft(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

}
