/**
 * 
 */
package edu.pitt.binarytree;

import java.util.Stack;

/**
 * Binary Search Tree Iterator #86 --- Accepted
 * Design an iterator over a binary search tree with the following rules:
 *     Elements are visited in ascending order (i.e. an in-order traversal)
 *     next() and hasNext() queries run in O(1) time in average.
 * Example
 * For the following binary search tree, in-order traversal by using iterator is [1, 6, 10, 11, 12]
 *    10
 *  /    \
 * 1      11
 *  \       \
 *   6       12
 * Challenge
 * Extra memory usage O(h), h is the height of the tree.
 * Super Star: Extra memory usage O(1)
 * @author yanma
 * @category Binary Tree
 * @version 2015-06-27
 * @class 3
 */
public class BinarySearchTreeIterator_86 {
	
	
	 	/** Example of iterate a tree:
		 * Solution iterator = new Solution(root);
		 * while (iterator.hasNext()) {
		 *    TreeNode node = iterator.next();
		 *    do something for node
		 * } 
		 */
		    Stack<TreeNode> stack;
		    TreeNode pointer;
		    //@param root: The root of binary tree.
		    public BinarySearchTreeIterator_86(TreeNode root) {
		        // write your code here
		        stack = new Stack<TreeNode>();
		        pointer = root;
		    }

		    //@return: True if there has next node, or false
		    public boolean hasNext() {
		        // write your code here
		        return (pointer != null) || (!stack.isEmpty());
		    }
		    
		    //@return: return next node
		    public TreeNode next() {
		        // write your code here
		        while (pointer != null) {
		            stack.push(pointer);
		            pointer = pointer.left;
		        }
		        pointer = stack.pop();
		        TreeNode result = pointer; // important: !!! Here!!! 
		        pointer = pointer.right;   // don't forget to  update pointer
		        return result;
		    }

}
