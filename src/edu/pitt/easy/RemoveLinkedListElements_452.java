/**
 * 
 */
package edu.pitt.easy;

import edu.pitt.linkedlist.ListNode;

/**
 * Remove Linked List Elements #452 --- Accepted
 * Remove all elements from a linked list of integers that have value val.
 * Example
 * Given 1->2->3->3->4->5->3, val = 3, you should return the list as 1->2->4->5
 * @author yanma
 * @category Easy
 * @version 2015-10-20
 * @week 12 1019-1025
 */
public class RemoveLinkedListElements_452 {
	/**
     * @param head a ListNode
     * @param val an integer
     * @return a ListNode
     */
    public ListNode removeElements(ListNode head, int val) {
        // Write your code here
        if (head == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        while (head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        
        return dummy.next;
    }

}
