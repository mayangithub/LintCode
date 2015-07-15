/**
 * 
 */
package edu.pitt.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Binary Tree Zigzag Level Order Traversal  #71 --- Accepted
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (ie, from left to right, then right to left for the next level and alternate between).
 * Example
 * Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
 * return its zigzag level order traversal as:
 * [
  	[3],
  	[20,9],
  	[15,7]
 * ]
 * @author yanma
 * @category Binary Tree
 * @version 2015-07-15
 * @class 3
 */
public class BinaryTreeZigzagLevelOrderTraversal_71 {
	
	/**
     * @param root: The root of binary tree.
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean flag = false;
        
        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                if (flag) {
                    level.add(0,head.val);
                } else {
                    level.add(head.val);
                }
                if (head.left != null) {
                    queue.offer(head.left);
                } 
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            flag = (flag) ? false: true;
            result.add(level);
        }
        
        return result;
    }
	
	

}
