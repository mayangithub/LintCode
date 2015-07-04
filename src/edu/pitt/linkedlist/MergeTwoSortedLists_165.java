/**
 * 
 */
package edu.pitt.linkedlist;

/**
 * Merge Two Sorted Lists #165 --- Accepted
 * Merge two sorted (ascending) linked lists and return it as a new sorted list. 
 * The new sorted list should be made by splicing together the nodes of the two lists and sorted in ascending order.
 * Example
 * Given 1->3->8->11->15->null, 2->null , return 1->2->3->8->11->15->null.
 * @author yanma
 * @category Linked List
 * @version 2015-07-04
 * @class 6
 */
public class MergeTwoSortedLists_165 {
	
	/**
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode end = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                end.next = l1;
                l1 = l1.next;
            } else {
                end.next = l2;
                l2 = l2.next;
            }
            end = end.next;
        }
        
        if (l1 == null) {
            end.next = l2;
        } else {
            end.next = l1;
        }
        
        return dummy.next;
    }

}
