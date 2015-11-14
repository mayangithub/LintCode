/**
 * 
 */
package edu.pitt.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Complete Binary Tree #467 --- Accepted
 * Check a binary tree is completed or not. 
 * A complete binary tree is not binary tree that every level is completed filled except the deepest level. 
 * In the deepest level, all nodes must be as left as possible. See more definition
 * Example
 *     1
 *    / \
 *   2   3
 *  /
 * 4
 * is a complete binary.
 *     1
 *    / \
 *   2   3
 *    \
 *     4
 * is not a complete binary.
 * Challenge
 * Do it in O(n) time
 * @author yanma 
 * @version 2015-11-13
 * @category Binary Tree, Easy
 */
public class CompleteBinaryTree_467 {
	/**
     * @param root, the root of binary tree.
     * @return true if it is a complete binary tree, or false.
     */
    public boolean isComplete(TreeNode root) {
        // Write your code here
        if (root == null) {
            return true;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean gap = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (gap && node.val != -1) {
                return false;
            }
            if (node.val == -1) {
                gap = true;
                continue;
            }
            if (node.left != null) {
                queue.offer(node.left);
            } else {
                queue.offer(new TreeNode(-1));
            }
            if (node.right != null) {
                queue.offer(node.right);
            } else {
                queue.offer(new TreeNode(-1));
            }
        }
        
        return true;
    }

}
