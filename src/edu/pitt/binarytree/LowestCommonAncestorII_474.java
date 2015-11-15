/**
 * 
 */
package edu.pitt.binarytree;

import java.util.ArrayList;

/**
 * Lowest Common Ancestor II #474 --- Accepted
 * Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
 * The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
 * The node has an extra attribute parent which point to the father of itself. The root's parent is null.
 * Example
 * For the following binary tree:
 * 	  4
 * 	 / \
 * 	3   7
 * 	   / \
 * 	  5   6
 * LCA(3, 5) = 4
 * LCA(5, 6) = 7
 * LCA(6, 7) = 7
 * @author yanma
 * @version 2015-11-14
 * @category Binary Tree, Easy
 */
public class LowestCommonAncestorII_474 {
	class ParentTreeNode {
		public ParentTreeNode parent, left, right;
	}
	/**
     * @param root: The root of the tree
     * @param A, B: Two node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {
        // Write your code here   
        if (root == null || A == null || B == null) {
            return null;
        }
        
        // if (A == B) {
        //     return A.parent;
        // } else if (A == root || B == root) {
        //     return root;
        // }
        
        ArrayList<ParentTreeNode> listA = parentList(A, new ArrayList<ParentTreeNode>());
        ArrayList<ParentTreeNode> listB = parentList(B, new ArrayList<ParentTreeNode>());
        
        int indexa = listA.size() - 1;
        int indexb = listB.size() - 1;
        while (indexa >= 0 && indexb >= 0) {
            if (listA.get(indexa) == listB.get(indexb)) {
                indexa--;
                indexb--;
            } else {
                return listA.get(indexa + 1);
            }
        }
        
        if (indexa < 0) {
            return listA.get(0);
        } else if (indexb < 0) {
            return listB.get(0);
        }
        
        return root;
    }
    
    public ArrayList<ParentTreeNode> parentList(ParentTreeNode node, ArrayList<ParentTreeNode> list) {
        if (node == null) {
            return list;
        }
        
        list.add(node);
        node = node.parent;
        return parentList(node, list);
    }

}
