/**
 * 
 */
package edu.pitt.stack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Expression Evaluation #368 --- Accepted
 * Given an expression string array, return the final result of this expression
 * Example
 * For the expression 2*6-(23+7)/(1+2), input is
 * [
 *   "2", "*", "6", "-", "(",
 *   "23", "+", "7", ")", "/",
 *   (", "1", "+", "2", ")"
 * ],
 * return 2
 * Note
 * The expression contains only integer, +, -, *, /, (, ).
 * @author yanma
 * @category Stack
 * @version 2015-08-30
 * @class 4
 * @week4 0824-0830
 */
public class ExpressionEvaluation_368 {
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
        public TreeNode(int pri, String s) {
            this.priority = pri;
            this.node = new ExpressionTreeNode(s);
        }
    }
    
    public int evaluateExpression(String[] expression) {
        // write your code here
        if (expression == null || expression.length == 0) {
           return 0;
        }
        
        ExpressionTreeNode root = build(expression);
        ArrayList<String> traversal = postOrderTraversal(root);
        Stack<Integer> stack = new Stack<Integer>();
        int index = 0;
        while (index < traversal.size()) {
            calculate(traversal, index, stack);
            index++;
        }
        
        return (stack.isEmpty()) ? 0 : stack.peek();
    }
    
    public void calculate(ArrayList<String> traversal, int index, Stack<Integer> stack) {
        String s = traversal.get(index);
        int first = 0;
        int second = 0;
        int result = 0;
        switch(s) {
            case "+":
                second = stack.pop();
                first = stack.pop();
                result = first + second;
                stack.push(result);
                break;
            case "-":
                second = stack.pop();
                first = stack.pop();
                result = first - second;
                stack.push(result);
                break;
            case "*":
                second = stack.pop();
                first = stack.pop();
                result = first * second;
                stack.push(result);
                break;
            case "/":
                second = stack.pop();
                first = stack.pop();
                result = first / second;
                stack.push(result);
                break;
            default:
                stack.push(Integer.valueOf(s));
                break;
        }
    }
    
    public ArrayList<String> postOrderTraversal(ExpressionTreeNode root) {
        ArrayList<String> result = new ArrayList<String>();
        if (root == null) {
            return result;
        }
        Stack<ExpressionTreeNode> stack = new Stack<ExpressionTreeNode>();
        ExpressionTreeNode curr = null;
        ExpressionTreeNode prev = null;
        
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
                stack.push(curr.right);
            } else {
                result.add(curr.expression);
                stack.pop();
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
        int index = 0;
        int base = 0;
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
