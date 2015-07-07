/**
 * 
 */
package edu.pitt.linkedlist;

import java.util.HashMap;

/**
 * Copy List with Random Pointer #105 --- Accepted
 * A linked list is given such that each node contains an additional random pointer 
 * which could point to any node in the list or null.
 * Return a deep copy of the list.
 * Example
 * Challenge
 * Could you solve it with O(1) space?
 * @author yanma
 * @category Linked List
 * @version 2015-07-06
 * @class 6
 */
public class CopyListwithRandomPointer_105 {
	
	/**
	 * Using hash map O(n) space
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }
        
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode pointer = head;
        
        while (pointer != null) {
            RandomListNode node = new RandomListNode(pointer.label);
            map.put(pointer, node);
            pointer = pointer.next;
        }
        
        pointer = head;
        while (pointer != null) {
            map.get(pointer).random = map.get(pointer.random); // two fields to copy
            map.get(pointer).next = map.get(pointer.next);
            pointer = pointer.next;
        }
        
        return map.get(head);
    }
    
    /**
     * using O(1) space
     * 1 -> 1` -> 2 -> 2` -> 3 -> 3` -> ..... -> null
     * 1` -> 2` -> 3` -> ..... -> null
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList1(RandomListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }
        
        RandomListNode pointer = head;
        while (pointer != null) {
            RandomListNode newnode = new RandomListNode(pointer.label);
            newnode.next = pointer.next;
            pointer.next = newnode;
            pointer = pointer.next.next;
        }
        
        pointer = head;
        while (pointer != null) {
            if (pointer.random != null) {
                pointer.next.random = pointer.random.next;
            }
            
            RandomListNode next = pointer.next.next;
            if (next != null) {
                pointer.next.next = next.next;
            }
            pointer = next;
        }
        
        return head.next;
    }

}
