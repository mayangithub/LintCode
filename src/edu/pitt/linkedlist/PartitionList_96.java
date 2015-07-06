/**
 * 
 */
package edu.pitt.linkedlist;

/**
 * Partition List #96 --- Accepted
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * For example,
 * Given 1->4->3->2->5->2->null and x = 3,
 * return 1->2->2->4->3->5->null.
 * @author yanma
 * @category Linked List
 * @version 2015-07-06
 * @class 6
 */
public class PartitionList_96 {
	
	/**
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        if (head == null) {
           return head; 
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        ListNode dummys = new ListNode(0);
        ListNode heads = dummys;
        
        while (head.next != null) {
            if (head.next.val >= x) {
                head = head.next;
            } else {
                heads.next = head.next;
                head.next = head.next.next;
                heads.next.next = null;
                heads = heads.next;
            }
        }
        
        heads.next = dummy.next;
        
        return dummys.next;
    }

}
