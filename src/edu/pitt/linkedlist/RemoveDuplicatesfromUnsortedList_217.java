/**
 * 
 */
package edu.pitt.linkedlist;

import java.util.HashMap;

/**
 * Remove Duplicates from Unsorted List #217 --- Accepted
 * Write code to remove duplicates from an unsorted linked list.
 * Example
 * Given 1->3->2->1->4.
 * Return 1->3->2->4
 * Challenge
 * (hard) How would you solve this problem if a temporary buffer is not allowed? 
 * In this case, you don't need to keep the order of nodes.
 * @author yanma
 * @version 2015-11-14
 * @category Linked List, Easy
 */
public class RemoveDuplicatesfromUnsortedList_217 {
	 /**
     * @param head: The first node of linked list.
     * @return: head node
     */
    public ListNode removeDuplicates(ListNode head) { 
        // Write your code here
        if (head == null || head.next == null) {
            return head;
        }
        
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        ListNode node = head;
        map.put(node.val, true);
        while (node.next != null) {
            if (map.containsKey(node.next.val)) {
                node.next = node.next.next;
            } else {
                map.put(node.next.val, true);
                node = node.next;
            }
        }
        
        return head;
    }  
}
