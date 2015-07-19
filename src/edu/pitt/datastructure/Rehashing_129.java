/**
 * 
 */
package edu.pitt.datastructure;

import edu.pitt.linkedlist.ListNode;

/**
 * Rehashing #129 --- Accepted
 * Given the original hash table, return the new hash table after rehashing .
 * Example
 * Given [null, 21->9->null, 14->null, null],
 * return [null, 9->null, null, null, null, 21->null, 14->null, null]
 * Note
 * For negative integer in hash table, the position can be calculated as follow:
    C++/Java: if you directly calculate -4 % 3 you will get -1. 
    You can use function: a % b = (a % b + b) % b to make it is a non negative integer.
 * @author yanma
 * @category Data Structure
 * @version 2015-07-19
 * @class 8
 */
public class Rehashing_129 {
	
	/**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        if (hashTable == null) {
            return null;
        }
        ListNode[] newTable = new ListNode[hashTable.length * 2];
        int capacity = hashTable.length * 2;
        
        for (int i = 0; i < hashTable.length; i++) {
            ListNode head = hashTable[i];
            while (head != null) {
                ListNode next = head.next;
                int newpos = (head.val < 0) ? (head.val % capacity + capacity) % capacity : head.val % capacity;
                ListNode node = new ListNode(head.val);
                ListNode tail = newTable[newpos]; // keep the sequence of original hash table
                while (tail != null && tail.next != null) {
                    tail = tail.next;
                }
                if (tail == null) { // avoid null pointer exception
                    newTable[newpos] = node;
                } else {
                    tail.next = node;
                }
                head = next;
            }
        }
        
        return newTable;
    }

}
