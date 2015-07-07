/**
 * 
 */
package edu.pitt.linkedlist;

/**
 * Add Two Numbers #167 --- Accepted
 * You have two numbers represented by a linked list, where each node contains a single digit. 
 * The digits are stored in reverse order, such that the 1's digit is at the head of the list. 
 * Write a function that adds the two numbers and returns the sum as a linked list.
 * Example
 * Given 7->1->6 + 5->9->2. That is, 617 + 295.
 * Return 2->1->9. That is 912.
 * Given 3->1->5 and 5->9->2, return 8->0->8.
 * @author yanma
 * @category Linked List
 * @version 2015-07-07
 * @class 6
 */
public class AddTwoNumbers_167 {
	
	/**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        
        while (l1 != null && l2 != null) {
            int sum = carry + l1.val + l2.val;
            carry = sum / 10;
            sum = sum % 10;
            ListNode digit = new ListNode(sum);
            head.next = digit;
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        if (l1 == null) {
            while (l2 != null) {
                int sum = carry + l2.val;
                carry = sum / 10;
                sum = sum % 10;
                ListNode digit = new ListNode(sum);
                head.next = digit;
                head = head.next;
                l2 = l2.next;
            }
        } else {
            while (l1 != null) {
                int sum = carry + l1.val;
                carry = sum / 10;
                sum = sum % 10;
                ListNode digit = new ListNode(sum);
                head.next = digit;
                head = head.next;
                l1 = l1.next;
            }
        }
        
        if (carry != 0) {
            ListNode digit = new ListNode(carry);
            head.next = digit; 
        }
        
        return dummy.next;
    }

}
