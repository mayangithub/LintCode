/**
 * 
 */
package edu.pitt.binarytree;

/**
 * Identical Binary Tree #469 --- Accepted
 * Check if two binary trees are identical. 
 * Identical means the two binary trees have the same structure and every identical position has the same value.
 * Example
 * 	    1             1
 * 	   / \           / \
 * 	  2   2   and   2   2
 * 	 /             /
 * 	4             4
 * are identical.
 * 	    1             1
 * 	   / \           / \
 * 	  2   3   and   2   3
 * 	 /               \
 * 	4                 4
 * are not identical.
 * @author yanma
 * @version 2015-11-13
 * @category Binary Tree, Easy
 */
public class IdenticalBinaryTree_469 {
	/**
     * @param a, b, the root of binary trees.
     * @return true if they are identical, or false.
     */
    public boolean isIdentical(TreeNode a, TreeNode b) {
        // Write your code here
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null || a.val != b.val) {
            return false;
        }
        
        return isIdentical(a.left, b.left) && isIdentical(a.right, b.right);
    }

}
