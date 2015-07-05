/**
 * 
 */
package edu.pitt.linkedlist;

import java.util.List;

/**
 * Merge k Sorted Lists #104 --- Accepted
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 * Example
 * Given lists:
 * [
  	2->4->null,
  	null,
  	-1->null
 * ],
 * return -1->2->4->null.
 * @author yanma
 * @category Linked List
 * @version 2015-07-04
 * @class 6
 */
public class MergekSortedLists_104 {
	
	
	/**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        
        if (lists == null || lists.size() == 0) {
            return null;
        }
        
        int size = lists.size();
        
        return splitMerge(lists, 0, size - 1);
    }
    
    /**
     * Divide and Conquer
     * @param lists
     * @param start
     * @param end
     * @return
     */
    public ListNode splitMerge(List<ListNode> lists, int start, int end) {
        if (start > end) {
            return null;
        }
        
        if (start + 1 < end) {
            int mid = start + (end - start) / 2;
            ListNode l1 = splitMerge(lists, start, mid);
            ListNode l2 = splitMerge(lists, mid + 1, end);
            return mergeTwoLists(l1, l2);
        }
        
        if (start == end) {
            return lists.get(start);
        }
        
        return mergeTwoLists(lists.get(start), lists.get(end));
    }
    
    /**
     * General Merge
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
