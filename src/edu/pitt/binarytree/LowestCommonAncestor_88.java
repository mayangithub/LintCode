/**
 * 
 */
package edu.pitt.binarytree;

/**
 * Lowest Common Ancestor #88 --- Accepted
 * Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
 * The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
 * Example
 * For the following binary tree:
 *   4
 *  / \
 * 3   7
 *    / \
 *   5   6
 * LCA(3, 5) = 4
 * LCA(5, 6) = 7
 * LCA(6, 7) = 7
 * @author yanma
 * @category Binary Tree
 * @version 2015-06-27
 * @class 3
 */
public class LowestCommonAncestor_88 {
	
	/**
	 * Faster solution
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root == null) {
            return null;
        } else if (root == A || root == B) {
            return root;
        }
        
        TreeNode aroot = null;
        TreeNode broot = null;
        
        if (isInTree(root.left, A)) {
            aroot = root.left;
        } else if (isInTree(root.right, A)) {
            aroot = root.right;
        }
        
        if (isInTree(root.left, B)) {
            broot = root.left;
        } else if (isInTree(root.right, B)) {
            broot = root.right;
        }
        
        if (aroot == broot) {
            return lowestCommonAncestor(aroot, A, B);
        } else if (aroot != null && broot != null) {
            return root;
        } else if (aroot != null) {
            return aroot;
        } else if (broot != null) {
            return broot;
        }
        
        return null;
    }
	
	/**
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root == null || A == null || B == null) {
            return null;
        }
        
        if (!isInTree(root, A) && !isInTree(root, B)) {
            return null;
        }
        
        if ((isInTree(root.left, A) && isInTree(root.right, B)) || (isInTree(root.right, A) && isInTree(root.left, B))) {
            return root;
        }
        
        if (isInTree(root.left, A) && isInTree(root.left, B)) {
            return lowestCommonAncestor(root.left, A, B);
        }
        
        if (isInTree(root.right, A) && isInTree(root.right, B)) {
            return lowestCommonAncestor(root.right, A, B);
        }
        
        return root;
    }
    
    public boolean isInTree(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }
        
        if (root.val == node.val) {
            return true;
        }
        
        return isInTree(root.left, node) || isInTree(root.right, node);
    }
	

}
