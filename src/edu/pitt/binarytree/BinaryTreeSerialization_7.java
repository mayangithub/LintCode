/**
 * 
 */
package edu.pitt.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Binary Tree Serialization #7 --- Accepted
 * Design an algorithm and write code to serialize and deserialize a binary tree. 
 * Writing the tree to a file is called 'serialization' and reading back from the file to reconstruct the exact same binary tree is 'deserialization'.
 * There is no limit of how you deserialize or serialize a binary tree, 
 * you only need to make sure you can serialize a binary tree to a string and deserialize this string to the original structure.
 * Example
 * An example of testdata: Binary tree {3,9,20,#,#,15,7}, denote the following structure:
	  3
	 / \
	9  20
	  /  \
	 15   7	
 * 	Our data serialization use bfs traversal. This is just for when you got wrong answer and want to debug the input.
 * 	You can use other method to do serializaiton and deserialization.
 * @author yanma
 * @category Binary Tree
 * @version 2015-07-15
 * @class 3
 */
public class BinaryTreeSerialization_7 {
	
	/**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        String result = "";
        
        if (root == null) {
            return result;
        }
        
        StringBuffer bf = new StringBuffer();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        bf.append(root.val);
        while (!queue.isEmpty()) {
            TreeNode head = queue.poll();
            if (head.left != null) {
                queue.offer(head.left);
                bf.append("," + head.left.val);
            } else {
                bf.append(",#");
            }
            if (head.right != null) {
                queue.offer(head.right);
                bf.append("," + head.right.val);
            } else {
                bf.append(",#");
            } 
        }
        result = bf.toString();
        return result;
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if (data == null || data.length() == 0) {
            return null;
        }
        
        ArrayList<TreeNode> nodes = toArray(data);
        TreeNode root = nodes.get(0);
        int rootIndex = 0;
        int childIndex = 0; // child index range
        int size = nodes.size();
        while (rootIndex < size && childIndex < size) { // the root and child index range
            TreeNode parent = nodes.get(rootIndex);
            if (parent != null) {
                parent.left = (childIndex + 1 >= size) ? null : nodes.get(childIndex + 1); // the child index range
                parent.right = (childIndex + 2 >= size) ? null : nodes.get(childIndex + 2);
                childIndex += 2;
            }
            rootIndex++;
        }
        
        return root;
    }
    
    public ArrayList<TreeNode> toArray(String data) {
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        int start = 0;
        int end = start + 1;
        while (end < data.length()) {
            if (data.charAt(end) >= '0' && data.charAt(end) <= '9') {
                end++;
            } else {
                if (data.charAt(end) == ',') {
                    String substring = data.substring(start, end);
                    if (substring.equals("#")) {
                        list.add(null);
                    } else {
                        list.add(new TreeNode(Integer.parseInt(substring, 10)));
                    }
                    start = end + 1; // make the while loop stopable
                    end = start + 1;
                }
            }
            
        }
        
        if (end >= data.length() && start < data.length()) {
            String substring = data.substring(start);
            if (substring.equals("#")) {
                list.add(null);
            } else {
                list.add(new TreeNode(Integer.parseInt(substring, 10)));
            }
        }
        
        return list;
    }

}
