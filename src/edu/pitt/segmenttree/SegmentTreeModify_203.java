/**
 * 
 */
package edu.pitt.segmenttree;

import java.util.Stack;

/**
 * Segment Tree Modify #203 --- Accepted
 * For a Maximum Segment Tree, which each node has an extra value max to store the maximum value in this node's interval.
 * Implement a modify function with three parameter root, index and value to change the node's value with [start, end] = [index, index] to the new given value. 
 * Make sure after this change, every node in segment tree still has the max attribute with the correct value.
 * Example
 * For segment tree:
	                      [1, 4, max=3]
	                    /                \
	        [1, 2, max=2]                [3, 4, max=3]
	       /              \             /             \
	[1, 1, max=2], [2, 2, max=1], [3, 3, max=0], [4, 4, max=3]
 * if call modify(root, 2, 4), we can get:
	                      [1, 4, max=4]
	                    /                \
	        [1, 2, max=4]                [3, 4, max=3]
	       /              \             /             \
	[1, 1, max=2], [2, 2, max=4], [3, 3, max=0], [4, 4, max=3]
 * or call modify(root, 4, 0), we can get:
	                      [1, 4, max=2]
	                    /                \
	        [1, 2, max=2]                [3, 4, max=0]
	       /              \             /             \
	[1, 1, max=2], [2, 2, max=1], [3, 3, max=0], [4, 4, max=0]
 * Note
 * We suggest you finish problem Segment Tree Build and Segment Tree Query first.
 * Challenge
 * Do it in O(h) time, h is the height of the segment tree.
 * @author yanma
 * @category Segment Tree
 * @version 2015-08-13
 * @class 2,3
 * @week2 0810-0816
 */
public class SegmentTreeModify_203 {
	
	/**
	 * Recursive
	 * using the order of execution to find and update max
     *@param root, index, value: The root of segment tree and 
     *@ change the node's value with [index, index] to the new given value
     *@return: void
     */
    public void modify(SegmentTreeNode root, int index, int value) {
        // write your code here
        if (index < root.start || index > root.end) {
            return;
        }
        
        if (root.start == index && root.end == index) {
            root.max = value;
            return;
        }
        
        int mid = (root.start + root.end) / 2;
        if (index <= mid) {
            modify(root.left, index, value); //Recursion
        } else if (index >= mid + 1) {
            modify(root.right, index, value);
        }
        
        root.max = Math.max(root.left.max, root.right.max);
    }
	
	/**
	 * Non-Recursive
     *@param root, index, value: The root of segment tree and 
     *@ change the node's value with [index, index] to the new given value
     *@return: void
     */
    public void modify1(SegmentTreeNode root, int index, int value) {
        // write your code here
        Stack<SegmentTreeNode> stack = new Stack<SegmentTreeNode>();
        if (root.start == index && root.end == index) {
            root.max = value;
            return;
        }
        
        SegmentTreeNode node = root;
        stack.push(node);
        while (node.start != node.end) {
            int mid = (node.start + node.end) / 2;
            if (index <= mid) {
                node = node.left;
                stack.push(node);
            } else {
                node = node.right;
                stack.push(node);
            }
        }
        
        node = stack.pop();
        node.max = value;
        while (!stack.isEmpty()) {
            SegmentTreeNode out = stack.pop();
            out.max = Math.max(out.left.max, out.right.max);
        }
    }

}
