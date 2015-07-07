/**
 * 
 */
package edu.pitt.linkedlist;

/**
 * Nth to Last Node in List #166 --- Accepted
 * Find the nth to last element of a singly linked list. 
 * The minimum number of nodes in list is n.
 * Example
 * Given a List  3->2->1->5->null and n = 2, return node  whose value is 1.
 * @author yanma
 * @category Linked List
 * @version 2015-07-06
 * @class 6
 */
public class NthtoLastNodeinList_166 {
	
	
	/**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: Nth to last node of a singly linked list. 
     */
    ListNode nthToLast(ListNode head, int n) {
        // write your code here
        if (head == null || n < 0) {
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        int i = 0;
        while (i < n) {
            fast = fast.next;
            i++;  // increment
        }
        
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

}
