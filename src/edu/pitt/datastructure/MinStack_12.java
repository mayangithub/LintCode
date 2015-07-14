/**
 * 
 */
package edu.pitt.datastructure;

import java.util.Stack;

/**
 * Min Stack #12 --- Accepted
 * Implement a stack with min() function, which will return the smallest number in the stack.
 * It should support push, pop and min operation all in O(1) cost.
 * Example
 * Operations: push(1), pop(), push(2), push(3), min(), push(1), min() Return: 1, 2, 1
 * Note
 * min operation will never be called if there is no number in the stack
 * @author yanma
 * @category Data Structure
 * @version 2015-07-13
 * @class 8
 */
public class MinStack_12 {
	
	public Stack<Integer> stacknormal = null;
    public Stack<Integer> stackmin = null;
    public MinStack_12() {
        // do initialize if necessary
        stacknormal = new Stack<Integer>();
        stackmin = new Stack<Integer>();
    }

    public void push(int number) {
        // write your code here
        stacknormal.push(number);
        if (stackmin.isEmpty()) {
            stackmin.push(number);
        } else {
            if (number <= stackmin.peek()) {
                stackmin.push(number);
            }
        }
    }

    public int pop() {
        // write your code here
        int num = 0;
        if (stacknormal.isEmpty()) {
            return 0;
        } else {
            num = stacknormal.pop();
            if (num <= stackmin.peek()) {
                stackmin.pop();
            }
            return num;
        }
    }

    public int min() {
        // write your code here
        if (stacknormal.isEmpty()) {
            return 0;
        }
        return stackmin.peek();
    }

}
