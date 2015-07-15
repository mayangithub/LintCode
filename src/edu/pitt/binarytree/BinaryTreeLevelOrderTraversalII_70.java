/**
 * 
 */
package edu.pitt.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Binary Tree Level Order Traversal II #70 --- Accepted
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
 * (ie, from left to right, level by level from leaf to root).
 *  Example
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 * 	   / \
 * 	  9  20
 * 	    /  \
 * 	   15   7
 * 	return its bottom-up level order traversal as:	
 *	[
 * 	  [15,7],
 * 	  [9,20],
 * 	  [3]
 * 	]
 * @author yanma 
 * @category Binary Tree
 * @version 2015-07-15
 * @class 3
 */
public class BinaryTreeLevelOrderTraversalII_70 {
	
	/**
     * @param root: The root of binary tree.
     * @return: buttom-up level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                level.add(head.val);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            result.add(0, level);
        }
        return result;
    }

}
