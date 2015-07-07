/**
 * 
 */
package edu.pitt.linkedlist;

import java.util.HashMap;

/**
 * Linked List Cycle II #103 --- Accepted
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * Example
 * Given -21->10->4->5, tail connects to node index 1，返回10
 * Challenge
 * Follow up:
 * Can you solve it without using extra space?
 * @author yanma
 * @category Linked List
 * @version 2015-07-06
 * @class 6
 */
public class LinkedListCycleII_103 {
	
	/**
	 * Nine Chapter Method
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins. 
     *           if there is no cycle, return null
     */
    public ListNode detectCycle1(ListNode head) {  
        // write your code here
        if (head == null || head.next == null) {
            return null;
        }
        
        //find whether there's a cycle
        ListNode slow = head;
        ListNode fast = slow.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // assume one-way part path is x long, cycle part is y long,
        // when slow pass z long in cycle, slow and fast meet
        // y - z = x
        // when slow and head pointer go in same velocity,  
        // at some time, they will meet at the node where cycle begins
        // head the next node of slow
        while (head != slow.next) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
    
    /**
     * Using O(n) space hash map
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins. 
     *           if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {  
        // write your code here
        if (head == null || head.next == null) {
            return null;
        }
        
        HashMap<ListNode, Boolean> map = new HashMap<ListNode, Boolean>();
        while (head != null) {
            if (!map.containsKey(head)) {
                map.put(head, true);
                head = head.next;
            } else {
                return head;
            }
        }
        
        return null;
    }

}
