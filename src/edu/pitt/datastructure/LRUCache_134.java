/**
 * 
 */
package edu.pitt.datastructure;

import java.util.HashMap;

/**
 * LRU Cache #134 --- Accepted
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and set.
	get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
	set(key, value) - Set or insert the value if the key is not already present. 
		When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * @author yanma
 * @category Data Structure
 * @version 2015-07-19
 * @class 8
 */
public class LRUCache_134 {
	
	/**
	 * using single linked list
	 */
    
    class Node {
        int key;
        int value;
        Node next;
        
        Node(int k, int v) {
            this.key = k;
            this.value = v;
            this.next = null;
        }
    }
    
    int cap;
    int size;
    Node head;
    Node tail;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();

    // @param capacity, an integer
    public LRUCache_134(int capacity) {
        // write your code here
        this.cap = capacity;
        size = 0;
        head = new Node(-1, -1);
        tail = head;
    }

    // @return an integer
    public int get(int key) {
        // write your code here
        if (!map.containsKey(key)) {
            return -1;
        }
        
        Node prev = map.get(key);
        Node curr = prev.next;
        
        if (tail != curr) {
            prev.next = curr.next;
            map.put(prev.next.key, prev);
            tail.next = curr;
            curr.next = null;
            map.put(curr.key, tail);
            tail = tail.next;
        }
        
        return curr.value;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // write your code here
        if (get(key) != -1) {
            map.get(key).next.value = value;
            return;
        }
        
        if (size == cap) {
            map.remove(head.next.key);
            head.next = head.next.next;
            if (head.next != null) {
                map.put(head.next.key, head);
            }
            size -= 1;
        } 
        
        Node curr = new Node(key, value);
        tail.next = curr;
        map.put(key, tail);
        tail = tail.next;
        
        size += 1;
        
    }
    
    /**
     * using double linked list
     */
    
//    public class Node {
//        int key;
//        int value;
//        Node prev;
//        Node next;
//        
//        Node(int k, int v) {
//            this.key = k;
//            this.value = v;
//            this.prev = null;
//            this.next = null;
//        }
//        
//    }
//    
//    
//    int cap;
//    int size;
//    Node head;
//    Node tail;
//    HashMap<Integer, Node> map;
//
//    // @param capacity, an integer
//    public Solution(int capacity) {
//        // write your code here
//        this.cap = capacity;
//        this.size = 0;
//        head = new Node(-1, -1);
//        tail = new Node(-1, -1);
//        head.next = tail;
//        tail.prev = head;
//        map = new HashMap<Integer, Node>();
//    }
//
//    // @return an integer
//    public int get(int key) {
//        // write your code here
//        if (!map.containsKey(key) || map.get(key) == null) {
//            return -1;
//        }
//        
//        Node node = map.get(key);
//        
//        node.prev.next = node.next;
//        node.next.prev = node.prev;
//        
//        moveToTail(node);
//        
//        return node.value;
//    }
//
//    // @param key, an integer
//    // @param value, an integer
//    // @return nothing
//    public void set(int key, int value) {
//        // write your code here
//        if (get(key) == -1) { // not exist
//            if (size == cap) {
//                map.put(head.next.key, null);
//                head.next = head.next.next;
//                head.next.prev = head;
//                size--;
//            }   
//            Node node = new Node(key, value);
//            moveToTail(node);
//            map.put(key, node);
//            size++;
//        } else {
//            Node temp = map.get(key);
//            temp.value = value;
//        }
//    }
//    
//    public void moveToTail(Node node) {
//        node.next = tail;
//        node.prev = tail.prev;
//        tail.prev = node;
//        node.prev.next = node;
//    }

}
