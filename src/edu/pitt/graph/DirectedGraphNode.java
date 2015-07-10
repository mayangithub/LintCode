/**
 * 
 */
package edu.pitt.graph;

import java.util.ArrayList;

/**
 * DirectedGraphNode
 * @author yanma
 *
 */
public class DirectedGraphNode {
	
	 int label;
	 ArrayList<DirectedGraphNode> neighbors;
	 DirectedGraphNode(int x) {
		 label = x; 
		 neighbors = new ArrayList<DirectedGraphNode>(); 
	 }

}
