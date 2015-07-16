/**
 * 
 */
package edu.pitt.binarytree;

/**
 * Construct Binary Tree from Inorder and Postorder Traversal #72 --- Accepted
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Example
 * Given inorder [1,2,3] and postorder [1,3,2], return a tree:
 * 	  2
 * 	 / \
 * 	1   3
 * Note
 * You may assume that duplicates do not exist in the tree.
 * @author yanma
 * @category Binary Tree
 * @version 2015-07-15
 * @class 3
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal_72 {
	
	/**
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    
    public TreeNode helper(int[] inorder, int[] postorder, int instart, int inend, int postart, int poend) {
        if (instart > inend || postart > poend) {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[poend]);
        int pos = search(inorder, instart, inend, postorder[poend]);
        int size = pos - instart;
        root.left = helper(inorder, postorder, instart, pos - 1, postart, postart + size - 1);
        root.right = helper(inorder, postorder, pos + 1, inend, postart + size, poend  - 1);
        
        return root;
    }
    
    public int search(int[] inorder, int start, int end, int toFind) {
        if (start > end) {
            return -1;
        }
        
        int pos = start;
        while (pos <= end) {
            if (inorder[pos] == toFind) {
                return pos;
            }
            pos++;
        }
        return -1;
    }

}
