/**
 * 
 */
package edu.pitt.linkedlist;

import edu.pitt.binarytree.TreeNode;

/**
 * Convert Sorted List to Binary Search Tree #106 --- Accepted
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * Example
 *                    2
 * 1 -> 2 -> 3  =>   / \
 *                  1   3
 * @author yanma
 * @category Linked List
 * @version 2015-07-07
 * @class 6
 */
public class ConvertSortedListtoBinarySearchTree_106 {
	
	/**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {  
        // write your code here
        if (head == null) {
            return null;
        }
        
        int size = getSize(head);
        
        return helper(head, size);
    }
    
    public TreeNode helper(ListNode head, int size) {
        if (size == 0) {
            return null;
        }
        
        int mid = 0;
        if (size % 2 == 0) { // even
            mid = size / 2;
        } else {
            mid = (size + 1) / 2;
        }
        
        ListNode point = new ListNode(0); // the end node before mid
        point.next = head;
        for (int i = 1; i < mid; i++) {
            point = point.next;
        }
        
        TreeNode left = helper(head, mid - 1);
        point = point.next;
        TreeNode root = new TreeNode(point.val);
        TreeNode right = helper(point.next, size - mid);
        
        root.left = left;
        root.right = right;
        
        return root;
    }
    
    public int getSize(ListNode head) {
        ListNode point = head;
        int size = 0;
        while (point != null) {
            size++;
            point = point.next;
        }
        return size;
    }

}
