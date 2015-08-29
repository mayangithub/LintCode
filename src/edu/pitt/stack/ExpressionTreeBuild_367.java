/**
 * 
 */
package edu.pitt.stack;

import java.util.Stack;

/**
 * Expression Tree Build #367 --- Accepted
 * The structure of Expression Tree is a binary tree to evaluate certain expressions. 
 * All leaves of the Expression Tree have an number string value. 
 * All non-leaves of the Expression Tree have an operator string value.
 * Now, given an expression array, build the expression tree of this expression, 
 * return the root of this expression tree.
 * Example
 * For the expression (2*6-(23+7)/(1+2)) 
 * (which can be represented by ["2" "*" "6" "-" "(" "23" "+" "7" ")" "/" "(" "1" "+" "2" ")"]). 
 * The expression tree will be like
 *                  [ - ]
 *              /          \
 *         [ * ]              [ / ]
 *       /     \           /         \
 *     [ 2 ]  [ 6 ]      [ + ]        [ + ]
 *                      /    \       /      \
 *                    [ 23 ][ 7 ] [ 1 ]   [ 2 ] .
 * After building the tree, you just need to return root node [-].
 * @author yanma
 * @category Stack
 * @version 2015-08-28
 * @class 4
 * @week 4 0824-0830
 */
public class ExpressionTreeBuild_367 {

	/**
     * @param expression: A string array
     * @return: The root of expression tree
     */
	
	public class ExpressionTreeNode {
		public String symbol;
		public ExpressionTreeNode left, right;
		public ExpressionTreeNode(String symbol) {
			this.symbol = symbol;
			this.left = this.right = null;
		}
	}
     
    class TreeNode {
        String s;
        int priority;
        ExpressionTreeNode enode;
        TreeNode(int priority, String s) {
            this.priority = priority;
            this.s = s;
            this.enode = new ExpressionTreeNode(s);
        }
    }
     
     
     
    public ExpressionTreeNode build(String[] expression) {
        // write your code here
        if (expression == null || expression.length == 0) {
            return null;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ExpressionTreeNode root = null;
        int base = 0;
        int index = 0;
        while (index < expression.length) {
            if (expression[index].equals("(")){
                base += 10;
                index++;
                continue;
            } else if (expression[index].equals(")")) {
                base -= 10;
                index++;
                continue;
            }
            
            int pri = helper(expression[index], base);
            TreeNode node = new TreeNode(pri, expression[index]);
            while (!stack.isEmpty()) {
                if (node.priority > stack.peek().priority) {
                    stack.push(node);
                    break;
                } else {
                    TreeNode out = stack.pop();
                    if (!stack.isEmpty() && node.priority <= stack.peek().priority) {
                        stack.peek().enode.right = out.enode;
                    } else {
                        node.enode.left = out.enode;
                    }
                }
            }
            if (stack.isEmpty()) {
                stack.push(node);
            }
            index++;
        }
        
        while (!stack.isEmpty()) {
            TreeNode out = stack.pop();
            if (stack.isEmpty()) {
                root = out.enode;
                break;
            }
            stack.peek().enode.right = out.enode;
        }
        
        return root;
    }
    
    public int helper(String s, int base) {
        if (s.equals("/") || s.equals("*")) {
            return 2 + base;
        } else if (s.equals("+") || s.equals("-")) {
            return 1 + base;
        }
        return Integer.MAX_VALUE;
    }
	
}
