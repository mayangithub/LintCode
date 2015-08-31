/**
 * 
 */
package edu.pitt.stack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Convert Expression to Polish Notation #369 --- Accepted
 * Given an expression string array, return the Polish notation of this expression. (remove the parentheses)
 * Example
 * For the expression [(5 − 6) * 7] (which represented by ["(", "5", "−", "6", ")", "*", "7"]), 
 * the corresponding polish notation is [* - 5 6 7] (which the return value should be ["*", "−", "5", "6", "7"]).
 * @author yanma
 * @category Stack
 * @version 2015-08-31
 * @class 4
 * @week5 0831-0906
 */
public class ConvertExpressiontoPolishNotation_369 {
	/**
     * @param expression: A string array
     * @return: The Polish notation of this expression
     */
    public class ExpressionTreeNode {
        String expression;
        ExpressionTreeNode left, right;
        public ExpressionTreeNode(String exp) {
            this.expression = exp;
            this.left = this.right = null;
        }
    } 
    
    public class TreeNode {
        int priority;
        ExpressionTreeNode node;
        public TreeNode(int pri, String exp) {
            this.priority = pri;
            this.node = new ExpressionTreeNode(exp);
        }
    }
    
    public ArrayList<String> convertToPN(String[] expression) {
        // write your code here
        ArrayList<String> result = new ArrayList<String>();
        if (expression == null || expression.length == 0) {
            return result;
        }
        
        ExpressionTreeNode root = build(expression);
        if (root == null) {
            return result;
        }
        Stack<ExpressionTreeNode> stack = new Stack<ExpressionTreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            ExpressionTreeNode node = stack.pop();
            result.add(node.expression);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
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
                if (!stack.isEmpty() && stack.peek().priority >= priority) {
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
