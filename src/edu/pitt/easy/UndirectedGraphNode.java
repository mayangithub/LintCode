/**
 * 
 */
package edu.pitt.easy;

import java.util.ArrayList;

/**
 * 
 * @author yanma
 *
 */
public class UndirectedGraphNode {
	 int label;
	 ArrayList<UndirectedGraphNode> neighbors;
	 UndirectedGraphNode(int x) { 
		 label = x; 
		 neighbors = new ArrayList<UndirectedGraphNode>();
	 }
}
