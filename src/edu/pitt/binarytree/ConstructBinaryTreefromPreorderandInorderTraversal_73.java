/**
 * 
 */
package edu.pitt.binarytree;

/**
 * Construct Binary Tree from Preorder and Inorder Traversal #73 --- Accepted
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Example
 * Given in-order [1,2,3] and pre-order [2,1,3], return a tree:
 *   2
 *  / \
 * 1   3
 * Note
 * You may assume that duplicates do not exist in the tree.
 * @author yanma
 * @category Binary Tree
 * @version 2015-07-15
 * @class 3
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal_73 {
	
	/**
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        
        TreeNode root = helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        return root;
    }
    
    public TreeNode helper(int[] preorder, int[] inorder, int prestart, int preend, int instart, int inend) {
        if (prestart > preend || instart > inend) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[prestart]);
        int pos = search(inorder, instart, inend, preorder[prestart]);
        int size = pos - instart;
        root.left = helper(preorder, inorder, prestart + 1, prestart + size, instart, pos - 1);
        root.right = helper(preorder, inorder, prestart + size + 1, preend, pos + 1, inend);
        
        return root;
    }
    
    public int search(int[] inorder, int start, int end, int tofind) {
        if (start > end) {
            return -1;
        } 
        int pointer = start;
        while (pointer <= end) {
            if (inorder[pointer] == tofind) {
                return pointer;
            }
            pointer++;
        }
        return -1;
    }
	

}
