/**
 * 
 */
package edu.pitt.linkedlist;

/**
 * Palindrome Linked List Show result #223 --- Accepted
 * Implement a function to check if a linked list is a palindrome.
 * Example
 * Given 1->2->1, return true
 * Challenge
 * Could you do it in O(n) time and O(1) space?
 * @author yanma
 * @category Linked List
 * @version 2015-10-20
 * @week 12 1019-1025
 */
public class PalindromeLinkedList_223 {
	/**
     * @param head a ListNode
     * @return a boolean
     */
    public boolean isPalindrome(ListNode head) {
        // Write your code here
        // 1. find middle node, (if the fast is null, odd, if the fast.next is null, even)
        // 2. reverse the part after middle node, middle.next = null, 
        // 3. compare two linked list
        if (head == null || head.next == null) {
            return true;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode head2 = slow.next;
        slow.next = null;
        
        head2 = reverseList(head2);
        
        return compare(head, head2);
    }
    
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = head;
        ListNode next = curr.next;
        head.next = null;
        while (next != null) {
            curr = next;
            next = curr.next;
            curr.next = dummy.next;
            dummy.next = curr;
        }
        
        return dummy.next;
    }
    
    public boolean compare(ListNode head1, ListNode head2) {
        while (head1 != null && head2 != null) {
            if (head1.val != head2.val) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        
        return true;
    }

}
