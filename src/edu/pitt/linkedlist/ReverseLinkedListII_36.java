/**
 * 
 */
package edu.pitt.linkedlist;

/**
 * Reverse Linked List II #36 --- Accepted
 * Reverse a linked list from position m to n.
 * Example
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4, return 1->4->3->2->5->NULL.
 * Note
 * Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.
 * Challenge
 * Reverse it in-place and in one-pass
 * @author yanma
 * @category Linked List
 * @version 2015-07-04
 * @class 6
 */
public class ReverseLinkedListII_36 {
	
	/**
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     * @thoughts: find start node and do simple reverse list until the end node
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        if (head == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        
        for (int pos = 1; pos < m; pos++) {
            head = head.next;
        }
        
        ListNode curr = head.next;
        ListNode prev = null;
        ListNode end = curr;
        
        for (int pos = m; pos <= n; pos++) {
            if (curr == null) {
                break;
            }
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        head.next = prev;
        end.next = curr;
        
        return dummy.next;
    }

}
