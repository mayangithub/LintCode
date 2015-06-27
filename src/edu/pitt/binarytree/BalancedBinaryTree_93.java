/**
 * 
 */
package edu.pitt.binarytree;

/**
 * Balanced Binary Tree #93 --- Accepted
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree 
 * in which the depth of the two subtrees of every node never differ by more than 1.
 * Example
 * Given binary tree A={3,9,20,#,#,15,7}, B={3,#,20,15,7}
 * A)  3            B)    3 
 *    / \                  \
 *   9  20                 20
 *     /  \                / \
 *    15   7              15  7
 * The binary tree A is a height-balanced binary tree, but B is not.
 * @author yanma
 * @category Binary Tree
 * @version 2015-06-27
 * @class 3
 */
public class BalancedBinaryTree_93 {
	
	/**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        
        if (maxDepth(root) == -1) {
            return false;
        }
        
        return true;
    }
    
    public int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1; //make -1 as the signal of unbalanced tree 
        }
        
        return Math.max(left, right) + 1;
    }
	

}
