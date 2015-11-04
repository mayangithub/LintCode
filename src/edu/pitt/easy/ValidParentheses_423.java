/**
 * 
 */
package edu.pitt.easy;

import java.util.Stack;

/**
 * Valid Parentheses #423 --- Accepted
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 * Example
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * @author yanma
 * @version 2015-11-04
 * @category Easy
 */
public class ValidParentheses_423 {
	/**
     * @param s A string
     * @return whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return true;
        }
        
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && c == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (!stack.isEmpty() && c == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (!stack.isEmpty() && c == ']' && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }

}
