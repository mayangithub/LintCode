/**
 * 
 */
package edu.pitt.linkedlist;

import java.util.HashMap;

/**
 * Linked List Cycle #102 --- Accepted
 * Given a linked list, determine if it has a cycle in it.
 * Example
 * Given -21->10->4->5, tail connects to node index 1, return true
 * Challenge
 * Follow up:
 * Can you solve it without using extra space?
 * @author yanma
 * @category Linked List
 * @version 2015-07-06
 * @class 6
 */
public class LinkedListCycle_102 {
	
	/**
	 * my submission
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {  
        // write your code here
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = slow.next;
        
        while (fast != null && fast.next != null) {
            if (fast == slow) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return false;
    }
    
    /**
     * Nine Chapter submission
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle1(ListNode head) {  
        // write your code here
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = slow.next;
        
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return true;
    }
    
    /**
     * Using O(n) space Hash Map
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle2(ListNode head) {  
        // write your code here
        if (head == null || head.next == null) {
            return false;
        }
        
        HashMap<ListNode, Boolean> map = new HashMap<ListNode, Boolean>();
        while (head != null) {
            if (!map.containsKey(head)) {
                map.put(head, true);
                head = head.next;
            } else {
                return true;
            }
        }
        
        return false;
    }

}
