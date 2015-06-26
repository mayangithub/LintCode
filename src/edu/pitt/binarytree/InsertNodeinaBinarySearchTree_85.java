/**
 * 
 */
package edu.pitt.binarytree;

/**
 * Insert Node in a Binary Search Tree #85 --- Accepted 
 * Given a binary search tree and a new tree node, insert the node into the tree. 
 * You should keep the tree still be a valid binary search tree.
 * Example
 * Given binary search tree as follow, after Insert node 6, the tree should be:
 *   2             2
 *  / \           / \
 * 1   4   -->   1   4
 *    /             / \ 
 *   3             3   6
 * Challenge
 * Can you do it without recursion?
 * @author yanma
 * @category Binary Tree
 * @version 2015-06-26
 * @class 3
 */
public class InsertNodeinaBinarySearchTree_85 {
	
	/**
	 * Recursion
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if (root == null) {
            return node;
        }
        
        if (node.val < root.val) {
            root.left = insertNode(root.left, node);
        }
        
        if (node.val > root.val) {
            root.right = insertNode(root.right, node);
        }
        
        return root;
    }
	
	
	
	
	 /**
	 * Non-Recursion
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode1(TreeNode root, TreeNode node) {
        // write your code here
        if (root == null) {
            return node;
        }
        
        TreeNode parent = root;
        while ((node.val < parent.val && parent.left != null) || (node.val > parent.val && parent.right != null)) {
            if (node.val < parent.val) {
               parent = parent.left;
               continue;
            }
            
            if (node.val > parent.val) {
                parent = parent.right;
                continue;
            }
        }
        
        if (node.val < parent.val) {
            parent.left = node;
        } else {
            parent.right = node;
        }
        
        return root;
    }
	

}
