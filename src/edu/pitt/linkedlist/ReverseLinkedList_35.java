/**
 * 
 */
package edu.pitt.linkedlist;

/**
 * Reverse Linked List #35 --- Accepted
 * Reverse a linked list.
 * Example
 * For linked list 1->2->3, the reversed linked list is 3->2->1
 * Challenge
 * Reverse it in-place and in one-pass
 * @author yanma
 * @category Linked List
 * @version 2015-07-04
 * @class 6
 */
public class ReverseLinkedList_35 {
	
	/**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }

}
