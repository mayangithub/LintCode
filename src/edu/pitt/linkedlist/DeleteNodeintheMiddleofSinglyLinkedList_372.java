/**
 * 
 */
package edu.pitt.linkedlist;

/**
 * Delete Node in the Middle of Singly Linked List #372 --- Accepted
 * Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.
 * Example
 * Given 1->2->3->4, and node 3. return 1->2->4
 * @author yanma
 * @category Linked List
 * @version 2015-07-14
 */
public class DeleteNodeintheMiddleofSinglyLinkedList_372 {

	/**
     * @param node: the node in the list should be deleted
     * @return: nothing
     */
    public void deleteNode(ListNode node) {
        // write your code here
        if (node == null) {
            return;
        }
        
        ListNode next = node.next;
        if (next != null) {
            node.val = next.val;
            node.next = next.next;
        } else {
            node = null;
        }
        
    }
	
}
