/**
 * 
 */
package edu.pitt.datastructure;

import java.util.Stack;

/**
 * Implement Queue by Two Stacks #40 --- Accepted
 * As the title described, you should only use two stacks to implement a queue's actions.
 * The queue should support push(element), 
 * pop() and top() where pop is pop the first(a.k.a front) element in the queue.
 * Both pop and top methods should return the value of first element.
 * Example
 * For push(1), pop(), push(2), push(3), top(), pop(), you should return 1, 2 and 2
 * Challenge
 * implement it by two stacks, do not use any other data structure and push, pop and top should be O(1) by AVERAGE.
 * @author yanma
 * @category Data Structure
 * @version 2015-07-13
 * @class 8
 */
public class ImplementQueuebyTwoStacks_40 {
	
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public ImplementQueuebyTwoStacks_40() {
       // do initialization if necessary
       stack1 = new Stack<Integer>(); // for push
       stack2 = new Stack<Integer>(); // for pop
    }
    
    public void push(int element) {
        // write your code here
        stack1.push(element);
    }

    public int pop() {
        // write your code here
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public int top() {
        // write your code here
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.peek();
    }

}
