/**
 * 
 */
package edu.pitt.linkedlist;

/**
 * Remove Duplicates from Sorted List II  #113 --- Accepted
 * Given a sorted linked list, delete all nodes that have duplicate numbers, 
 * leaving only distinct numbers from the original list. 
 * Example
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * @author yanma
 * @category Linked List
 * @version 2015-07-04
 * @class 6
 */
public class RemoveDuplicatesfromSortedListII_113 {
	
	/**
	 * using one dummy node only and one variable to store duplicate value
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of the linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        while (head.next != null && head.next.next != null) {
            if (head.next.val == head.next.next.val) {
                int val = head.next.val;
                while (head.next != null && head.next.val == val) {
                    head.next = head.next.next;
                }
            } else {
                head = head.next;
            }
        }
        
        return dummy.next;
    }

	/**
	 * dummy node and two new pointers
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of the linked list
     */
    public static ListNode deleteDuplicates1(ListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        ListNode prev = head.next;
        ListNode curr = prev.next;
        while (curr != null) {
            if (prev.val == curr.val) {
                curr = curr.next;
            } else {
                if (prev.next == curr) {
                    head.next = prev;
                    head = head.next;
                } 
                prev = curr;
                curr = prev.next;
            }
        }
        
        if (prev.next == curr) {
            head.next = prev;
        } else {
            head.next = null;
        }
        
        return dummy.next;
    }
	
}
