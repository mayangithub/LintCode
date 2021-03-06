/**
 * 
 */
package edu.pitt.binarytree;

/**
 * Remove Node in Binary Search Tree #87 --- Accepted
 * Given a root of Binary Search Tree with unique value for each node.  
 * Remove the node with given value. If there is no such a node with given value in the binary search tree, do nothing. 
 * You should keep the tree still a binary search tree after removal.
 * Example
 * 	Given binary search tree:
 * 	      5
 * 	    /   \
 * 	   3     6
 * 	 /   \
 * 	2     4
 * 	Remove 3, you can either return:
 * 	         5
 * 	       /   \
 * 	      2     6
 * 	       \
 * 	        4
 * 	or :
 * 	      5
 * 	    /   \
 * 	   4     6
 * 	 /   
 * 	2
 * @author yanma
 * @category Binary tree
 * @version 2015-07-15
 * @class 3
 */
public class RemoveNodeinBinarySearchTree_87 {
	
	/**
	 * nine chapter method
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        if (root == null) {
            return null; 
        }
        
        TreeNode dummy = new TreeNode(-1);
        dummy.left = root;
        TreeNode parent = dummy;
        // find the node with value
        parent = findNode(root, value, parent);
        TreeNode node = root;
        if (parent.left != null && parent.left.val == value) {
            node = parent.left;
        } else if (parent.right != null && parent.right.val == value) {
            node = parent.right;
        } else {
            return dummy.left;
        }
        
        // find the node to replace with
        // remove leaf node
        if (node.left == null && node.right == null) {
            if (parent.left == node) {
                parent.left = null;
            } else if (parent.right == node) {
                parent.right = null;
            }
            return dummy.left;
        }
        
        if (node.right == null) {
            if (node == parent.left) {
                parent.left = node.left;
            } else {
                parent.right = node.left;
            }
        } else {
            TreeNode temp = node.right;
            TreeNode father = node;
            
            while (temp.left != null) {
                father = temp;
                temp = temp.left;
            }
            
            if (temp == father.left) {
                father.left = temp.right;
            } else {
                father.right = temp.right;
            }
            
            if (node == parent.left) {
                parent.left = temp;
            } else {
                parent.right = temp;
            }
            
            temp.left = node.left;
            temp.right = node.right;
        }
        
        return dummy.left;
    }
    
    public TreeNode findNode(TreeNode node, int value, TreeNode parent) {
        if (node == null) {
            return parent;
        }
        if (value == node.val) {
            return parent;
        }else if (value < node.val) {
            return findNode(node.left, value, node);
        } else {
            return findNode(node.right, value, node);
        }
    }
    
	
	
	/**
	 * my method
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode1(TreeNode root, int value) {
        // write your code here
        if (root == null) {
            return null;
        }
        
        TreeNode node = findNode1(root, value);
        if (node == null) {
            return root; // do nothing
        } 
        // if node.left == null, find Min in right subtree
        // if node.right == null, find Max in left subtree
        // else, node = null
        TreeNode pre = null;
        if (node.right != null) {
            pre = findMinRight(node.right, node);
            if (pre != node) {
                node.val = pre.left.val;
                pre.left = pre.left.right;
            } else {
                pre.val = node.right.val;
                pre.right = node.right.right;
            }
        } else if (node.left != null) {
            pre = findMaxLeft(node.left, node);
            if (pre != node) {
                node.val = pre.right.val;
                pre.right = pre.right.left;
            } else {
                pre.val = node.left.val;
                pre.left = node.left.left;
            }
        } 
        
        return (pre == null) ? null : root;
    }
    
    public TreeNode findNode1(TreeNode root, int value) {
        if (root == null) {
            return null;
        }
        if (root.val == value) {
            return root;
        }
        
        if (value < root.val) { // find in left subtree
            return findNode1(root.left, value);
        } else {
            return findNode1(root.right, value);
        }
    }
    
    public TreeNode findMinRight(TreeNode node, TreeNode pre) {
        if (node.left == null) {
            return pre;
        } else {
            return findMinRight(node.left, node);
        }
    }
    
    public TreeNode findMaxLeft(TreeNode node, TreeNode pre) {
        if (node.right == null) {
            return pre;
        } else {
            return findMaxLeft(node.right, node);
        }
    }

}
