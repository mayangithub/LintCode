/**
 * 
 */
package edu.pitt.binarytree;

/**
 * Minimum Depth of Binary Tree #155 --- Accepted
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * Example
 * Given a binary tree as follow:
 *         1
 *      /     \ 
 *     2       3
 *           /    \
 *          4      5  
 * The minimum depth is 2
 * @author yanma
 * @category Linked List
 * @version 2015-07-07
 * @class 3
 */
public class MinimumDepthofBinaryTree_155 {
	
	
	/**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int minDepth(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        
        if (left == 0) {
            return right + 1;
        } else if (right == 0) {
            return left + 1;
        }
        
        return Math.min(left, right) + 1;
    }

}
