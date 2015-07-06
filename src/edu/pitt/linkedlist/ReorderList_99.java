/**
 * 
 */
package edu.pitt.linkedlist;

/**
 * Reorder List  #99 --- Accepted
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * You must do this in-place without altering the nodes' values.
 * Example
 * For example,
 * Given 1->2->3->4->null, reorder it to 1->4->2->3->null.
 * @author yanma
 * @category Linked List
 * @version 2015-07-06
 * @class 6
 */
public class ReorderList_99 {
	
	/**
     * @param head: The head of linked list.
     * @return: void
     */
    public void reorderList(ListNode head) {  
        // write your code here
        if (head == null || head.next == null) {
            return;
        }
        
        ListNode mid = findMid(head);
        ListNode second = mid.next;
        mid.next = null;
        
        second = reverse(second);
        
        head = merge(head, second);
    }
    
    public ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        
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
    
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (l1 != null && l2 != null) {
            node.next = l1;
            node = node.next;
            l1 = l1.next;
            node.next = l2;
            node = node.next;
            l2 = l2.next;
        }
        
        if (l1 != null) {
            node.next = l1;
        }
        
        return dummy.next;
    }

}
