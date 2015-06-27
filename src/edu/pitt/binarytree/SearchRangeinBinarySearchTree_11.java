/**
 * 
 */
package edu.pitt.binarytree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Search Range in Binary Search Tree #11 --- Accepted
 * Given two values k1 and k2 (where k1 < k2) and a root pointer to a Binary Search Tree. 
 * Find all the keys of tree in range k1 to k2. i.e. print all x such that k1<=x<=k2 and x is a key of given BST. 
 * Return all the keys in ascending order.
 * Example
 * If k1 = 10 and k2 = 22, then your function should return [12, 20, 22].
 *     20
 *    /  \
 *   8   22
 *  / \
 * 4   12
 * @author yanma
 * @category Binary Tree
 * @version 2015-06-27
 * @class 3
 */
public class SearchRangeinBinarySearchTree_11 {
	
	/**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            
            node = stack.pop();
            if (node.val >= k1 && node.val <= k2) {
                result.add(node.val);
            }
            node = node.right;
        }
        
        return result;
    }
	

}
