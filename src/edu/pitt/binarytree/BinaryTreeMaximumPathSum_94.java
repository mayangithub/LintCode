/**
 * 
 */
package edu.pitt.binarytree;

/**
 * Binary Tree Maximum Path Sum #94 --- Accepted
 * Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 * Example
 * Given the below binary tree:
 *   1
 *  / \
 * 2   3
 * return 6.
 * @author yanma
 * @category Binary Tree
 * @version 2015-06-27
 * @class 3
 */
public class BinaryTreeMaximumPathSum_94 {

	private class ResultType {
        int singlePath;
        int maxPath;
        
        public ResultType(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }
    
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxPathSum(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        
        ResultType rt = helper(root);

        return rt.maxPath;
    }
    
    public ResultType helper(TreeNode node) {
        if (node == null) {
            return new ResultType(0, Integer.MIN_VALUE);
        }
        
        ResultType left = helper(node.left);
        ResultType right = helper(node.right);
        
        int singlepath = Math.max(left.singlePath, right.singlePath) + node.val;
        singlepath = Math.max(singlepath, 0);
        
        int maxpath = Math.max(left.maxPath, right.maxPath);
        maxpath = Math.max(maxpath, left.singlePath + right.singlePath + node.val);
        
        return new ResultType(singlepath, maxpath);
    }
	
}
