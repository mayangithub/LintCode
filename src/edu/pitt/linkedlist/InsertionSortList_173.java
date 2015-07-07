/**
 * 
 */
package edu.pitt.linkedlist;

/**
 * Insertion Sort List #173 --- Accepted
 * Sort a linked list using insertion sort.
 * Example
 * Given 1->3->2->0->null, return 0->1->2->3->null.
 * @author yanma
 * @category Linked List
 * @version 2015-07-07
 * @class 6
 */
public class InsertionSortList_173 {
	
	/**
	 * use 2 linked list, to avoid more pointers
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        
        while (head != null) {
            ListNode node = dummy;
            while (node.next != null && node.next.val <= head.val) { // while loop, not if condition
                node = node.next;
            }
            ListNode next = head.next;
            head.next = node.next;
            node.next = head;
            head = next;
        }
        
        return dummy.next;
    }
	
	
	/**
	 * in one list
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */
    public ListNode insertionSortList1(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode pointer = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        
        while (pointer != null) {
            ListNode comp = dummy.next;
            ListNode front = dummy;
            while (comp != pointer) {
                if (pointer.val < comp.val) {
                    pre.next = pointer.next;
                    front.next = pointer;
                    pointer.next = comp;
                    pointer = pre.next;
                    break;
                } else {
                    comp = comp.next;
                    front = front.next;
                }
            }
            if (comp == pointer) {
                pointer = pointer.next;
                pre = pre.next;
            }
        }
        
        return dummy.next;
    }

}
