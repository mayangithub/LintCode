/**
 * 
 */
package edu.pitt.stack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Convert Expression to Reverse Polish Notation #370 --- Accepted
 * Given an expression string array, return the Reverse Polish notation of this expression. (remove the parentheses)
 * Example
 * For the expression [3 - 4 + 5] (which denote by ["3", "-", "4", "+", "5"]), 
 * return [3 4 - 5 +] (which denote by ["3", "4", "-", "5", "+"])
 * @author yanma
 * @version 2015-08-30
 * @category Stack
 * @class 4
 * @week4 0824-0830
 */
public class ConvertExpressiontoReversePolishNotation_370 {

	public class ExpressionTreeNode {
        String expression;
        ExpressionTreeNode left, right;
        public ExpressionTreeNode(String s) {
            this.expression = s;
            this.left = this.right = null;
        }
    } 
    
    public class TreeNode {
        int priority;
        ExpressionTreeNode node;
        public TreeNode(int prio, String s) {
            this.priority = prio;
            this.node = new ExpressionTreeNode(s);
        }
    }
    
    public ArrayList<String> convertToRPN(String[] expression) {
        // write your code here
        ArrayList<String> result = new ArrayList<String>();
        if (expression == null || expression.length == 0) {
            return result;
        }
        
        ExpressionTreeNode root = build(expression);
        Stack<ExpressionTreeNode> stack = new Stack<ExpressionTreeNode>();
        ExpressionTreeNode curr = null;
        ExpressionTreeNode prev = null;
        if (root == null) { // take care of here, null root can also be pushed to stack
            return result;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            curr = stack.peek();
            if (prev == null || prev.left == curr || prev.right == curr) {
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else if (curr.left == prev) {
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else {
                result.add(stack.pop().expression);
            }
            prev = curr;
        }
        
        return result;
    }
    
    public ExpressionTreeNode build(String[] expression) {
        if (expression == null || expression.length == 0) {
            return null;
        }
        
        ExpressionTreeNode root = null;
        int base = 0;
        int index = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while (index < expression.length) {
            if (expression[index].equals("(")) {
                base += 10;
                index++;
                continue;
            } else if (expression[index].equals(")")) {
                base -= 10;
                index++;
                continue;
            }
            
            int priority = getPriority(expression[index], base);
            TreeNode node = new TreeNode(priority, expression[index]);
            while (!stack.isEmpty()) {
                if (priority > stack.peek().priority) {
                    stack.push(node);
                    break;
                }
                
                TreeNode out = stack.pop();
                if (!stack.isEmpty() && priority <= stack.peek().priority) {
                    stack.peek().node.right = out.node;
                } else {
                    node.node.left = out.node;
                }
            }
            if (stack.isEmpty()) {
                stack.push(node);
            }
            index++;
        }
        
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (stack.isEmpty()) {
                root = temp.node;
                break;
            }
            stack.peek().node.right = temp.node;
        }
        
        return root;
    }
    
    public int getPriority(String s, int base) {
        if (s.equals("+") || s.equals("-")) {
            return 1 + base;
        } else if (s.equals("*") || s.equals("/")) {
            return 2 + base;
        }
        return Integer.MAX_VALUE;
    }
}
