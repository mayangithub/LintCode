/**
 * 
 */
package edu.pitt.linkedlist;

/**
 * Remove Nth Node From End of List #174 --- Accepted
 * Given a linked list, remove the nth node from the end of list and return its head.
 * Example
 * Given linked list: 1->2->3->4->5->null, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5->null.
 * Note
 * The minimum number of nodes in list is n.
 * Challenge
 * O(n) time
 * @author yanma
 * @category Linked List
 * @version 2015-07-06
 * @class 6
 */
public class RemoveNthNodeFromEndofList_174 {
	
	
	/**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        if (head == null || n < 0) {
            return null;
        }
        
        ListNode fast = head;
        ListNode slow = new ListNode(0);
        slow.next = head;
        head = slow;
        int move = 0;
        while (move < n) {
            fast = fast.next;
            move++;
        }
        
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        
        return head.next;
    }

}
