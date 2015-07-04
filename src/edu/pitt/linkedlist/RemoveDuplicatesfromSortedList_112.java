/**
 * 
 */
package edu.pitt.linkedlist;

/**
 * Remove Duplicates from Sorted List #112 --- Accepted
 * Given a sorted linked list, delete all duplicates such that each element appear only once. 
 * Example
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * @author yanma
 * @category Linked List
 * @version 2015-07-04
 * @class 6
 */
public class RemoveDuplicatesfromSortedList_112 {

	/**
	 * Using 1 pointer
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) { 
        // write your code here
        if (head == null) {
            return head;
        }
        
        ListNode node = head;
        while (node.next != null) {
            if (node.next.val == node.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        
        return head;
    }  
	
	
	
	/**
	 * Using 2 pointers
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates1(ListNode head) { 
        // write your code here
        if (head == null) {
            return head;
        }
        
        ListNode prev = head;
        ListNode curr = prev.next;
        while (curr != null) {
            if (curr.val == prev.val) {
                curr = curr.next;
                prev.next.next = null;
                prev.next = curr;
            } else {
                prev = curr;
                curr = prev.next;
            }
        }
        
        prev.next = null;
        
        return head;
    } 
	
}
