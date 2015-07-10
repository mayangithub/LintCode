/**
 * 
 */
package edu.pitt.graph;

import java.util.ArrayList;

/**
 * UndirectedGraphNode
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
