/**
 * 
 */
package edu.pitt.linkedlist;

/**
 * Rotate List #170 --- Accepted
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * Example
 * Given 1->2->3->4->5 and k = 2, return 4->5->1->2->3.
 * @author yanma
 * @category Linked List
 * @version 2015-07-07
 * @class 6
 */
public class RotateList_170 {
	
	
	/**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        // write your code here
        // steps:
        // 1. find the last (k + 1)th node, 
        // 2. start a new list at the kth node
        // 3. add the new list infront of the first list
        
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        
        int size = getLength(head);
        k = k % size;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode slow = dummy;
        ListNode fast = slow.next;
        ListNode prev = slow; // end point
        
        for (int i = 1; i <= k; i++) { // condition
            fast = fast.next;
            prev = prev.next;
        }
        
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            prev = prev.next;
        }
        
        dummy.next = slow.next;
        slow.next = null;
        prev.next = head;
        
        return dummy.next;
    }
    
    public int getLength(ListNode head) {
        ListNode point = head;
        int size = 0;
        while (point != null) {
            point = point.next;
            size++;
        }
        return size;
    }
    

}
