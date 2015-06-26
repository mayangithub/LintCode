/**
 * 
 */
package edu.pitt.binarytree;

/**
 * Maximum Depth of Binary Tree #97 --- Accepted
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Example
 * Given a binary tree as follow:
 *   1
 *  / \ 
 * 2   3
 *    / \
 *   4   5
 * The maximum depth is 3.
 * @author yanma
 * @category Binary Tree
 * @version 2015-06-26
 * @class 3
 */
public class MaximumDepthofBinaryTree_97 {

	/**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        return Math.max(left, right) + 1;
    }
    
	
	
}
