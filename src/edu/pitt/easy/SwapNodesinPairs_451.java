/**
 * 
 */
package edu.pitt.easy;

import edu.pitt.linkedlist.ListNode;

/**
 * Swap Nodes in Pairs #451 --- Accepted
 * Given a linked list, swap every two adjacent nodes and return its head.
 * Example
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Challenge
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 * @author yanma
 *
 */
public class SwapNodesinPairs_451 {
	 /**
     * @param head a ListNode
     * @return a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        // Write your code here
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode front = dummy;
        ListNode first = head;
        ListNode second = head.next;
        ListNode next = second.next;
        
        while (first != null && second != null) {
            next = second.next;
            front.next = second;
            second.next = first;
            first.next = next;
            front = first;
            first = next;
            second = (first == null)? null: first.next; //trick
        }
        
        return dummy.next;
    }

}
