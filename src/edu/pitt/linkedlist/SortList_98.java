/**
 * 
 */
package edu.pitt.linkedlist;

/**
 * Sort List #98 --- Accepted
 * Sort a linked list in O(n log n) time using constant space complexity.
 * Example
 * Given 1-3->2->null, sort it to 1->2->3->null.
 * @author yanma
 * @category Linked List
 * @version 2015-07-06
 * @class 6
 */
public class SortList_98 {
	
	/**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {  
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode mid = findMid(head);
        ListNode newhead = mid.next;
        mid.next = null;
        
        ListNode dummy1 = sortList(head);
        ListNode dummy2 = sortList(newhead);
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
        
        while (dummy1 != null && dummy2 != null) {
            if (dummy1.val <= dummy2.val) {
                ListNode next = dummy1.next;
                pointer.next = dummy1;
                pointer = pointer.next;
                dummy1 = next;
            } else {
                ListNode next = dummy2.next;
                pointer.next = dummy2;
                pointer = pointer.next;
                dummy2 = next;
            }
        }
        
        if (dummy1 == null) {
            pointer.next = dummy2;
        } else {
            pointer.next = dummy1;
        }
        
        return dummy.next;
    }
    
    public ListNode findMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = slow.next;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }

}
