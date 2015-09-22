/**
 * 
 */
package edu.pitt.cc;

import edu.pitt.tree.TreeNode;

/**
 * Subtree #245 --- Accepted
 * You have two every large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes. 
 * Create an algorithm to decide if T2 is a subtree of T1. 
 * Example
 * T2 is a subtree of T1 in the following case:
          1                3
         / \              / 
 * T1 = 2   3      T2 =  4
           /
          4
 * T2 isn't a subtree of T1 in the following case:
          1               3
         / \               \
 * T1 = 2   3       T2 =    4
           /
          4
 * Note
 * A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2. 
 * That is, if you cut off the tree at node n, the two trees would be identical.
 * @author yanma
 * @version 2015-09-21
 * @category CC
 * @week 8 0921-0927
 */
public class Subtree_245 {
	
	 /**
	  * compare root is different from comparing between branches
	  * an empty root can be a subtree of any tree
	  * if the root is same, the children must be identicle, anyone can't be null
     * @param T1, T2: The roots of binary tree.
     * @return: True if T2 is a subtree of T1, or false.
     */
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        // write your code here
        if (T1 == null && T2 == null) {
            return true;
        } else if (T1 == null) {
            return false;
        } else if (T2 == null) {
            return true;
        }
        if (T1.val == T2.val) {
            if (isSame(T1.left, T2.left) && isSame(T1.right, T2.right)) {
                return true;
            }
        } 
        
        if (isSubtree(T1.left, T2)) {
            return true;
        } else if (isSubtree(T1.right, T2)) {
            return true;
        }
        return false;
    }
    
    public boolean isSame(TreeNode T1, TreeNode T2) {
        if (T1 == null && T2 == null) {
            return true;
        } else if (T1 == null && T2 != null) {
            return false;
        } else if (T1 != null && T2 == null) {
            return false;
        }
        if (T1.val != T2.val) {
            return false;
        }
        return isSame(T1.left, T2.left) && isSame(T1.right, T2.right);
    }

}
