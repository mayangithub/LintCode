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
	public int label;
	public ArrayList<UndirectedGraphNode> neighbors;
	public UndirectedGraphNode(int x) {
		label = x; 
		neighbors = new ArrayList<UndirectedGraphNode>(); 
	}
}
