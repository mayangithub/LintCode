/**
 * 
 */
package edu.pitt.binarytree;

/**
 * Binary Tree Maximum Path Sum II #475 --- Accepted
 * Given a binary tree, find the maximum path sum from root.
 * The path may end at any node in the tree.
 * Example
 * Given the below binary tree:
 *   1
 *  / \
 * 2   3
 * return 4. (1->3)
 * @author yanma
 * @version 2015-11-14
 * @category Binary Tree, Medium
 */
public class BinaryTreeMaximumPathSumII_475 {
	
	/**
     * @param root the root of binary tree.
     * @return an integer
     */
    
    public int max = Integer.MIN_VALUE;
     
    public int maxPathSum2(TreeNode root) {
        // Write your code here
        if (root == null) {
            return 0;
        }
        
        max = root.val;
        int sum = 0;
        helper(root, sum);
        
        return max;
    }
    
    public void helper(TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        
        sum += node.val;
        if (sum > max) {
            max = sum;
        }
        
        helper(node.left, sum);
        helper(node.right, sum);
    }

}
