/**
 * 
 */
package edu.pitt.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import edu.pitt.binarytree.TreeNode;

/**
 * Symmetric Binary Tree #468 --- Accepted
 * Given a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 * Example
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * is a symmetric binary tree.
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * is not a symmetric binary tree.
 * Challenge
 * Can you solve it both recursively and iteratively?
 * @author yanma 
 * @version 2015-11-14
 * @category Binary Tree, Easy
 */
public class SymmetricBinaryTree_468 {
	
	/**
	 * Recursively
     * @param root, the root of binary tree.
     * @return true if it is a mirror of itself, or false.
     */
    public boolean isSymmetric(TreeNode root) {
        // Write your code here
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        return helper(root.left, root.right);
    }
    
    public boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        
        if (left == null || right == null) {
            return false;
        }
        
        if (left.val != right.val) {
            return false;
        }
        
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
	
	/**
	 * Iteratively
     * @param root, the root of binary tree.
     * @return true if it is a mirror of itself, or false.
     */
    public boolean isSymmetric2(TreeNode root) {
        // Write your code here
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root.left);
        queue.offer(root.right);
        
        if ((root.left == null && root.right != null) || (root.left != null && root.right == null)) {
            return false;
        }
        
        if (root.left.val != root.right.val) {
            return false;
        }
        
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            
            if (left.val != right.val) {
                return false;
            }
            
            if (left.left != null && right.right != null) {
                queue.offer(left.left);
                queue.offer(right.right);
            } else if ((left.left == null && right.right != null) || (left.left != null && right.right == null)) {
                return false;
            }
            if (left.right != null && right.left != null) {
                queue.offer(left.right);
                queue.offer(right.left);
                continue;
            } else if ((left.right == null && right.left != null) || (left.right != null && right.left == null)) {
                return false;
            }
        }
        
        return true;
    }
	/**
	 * Iteratively
     * @param root, the root of binary tree.
     * @return true if it is a mirror of itself, or false.
     */
    public boolean isSymmetric1(TreeNode root) {
        // Write your code here
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        ArrayList<Integer> level = new ArrayList<Integer>();
        level.add(root.val);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int i = 0;
            int j = size - 1;
            while (i <= j) {
                if (level.get(i) != level.get(j)) {
                    return false;
                }
                i++;
                j--;
            }
            level = new ArrayList<Integer>();
            for (int k = 1; k <= size; k++) {
                TreeNode pop = queue.poll();
                if (pop != null) {
                    queue.offer(pop.left);
                    queue.offer(pop.right);
                    if (pop.left == null) {
                        level.add(0);
                    } else {
                        level.add(pop.left.val);
                    }
                    if (pop.right == null) {
                        level.add(0);
                    } else {
                        level.add(pop.right.val);
                    }
                }
            }
        }
        
        return true;
    }

}
