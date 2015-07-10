/**
 * 
 */
package edu.pitt.graph;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clone Graph #137 --- Accepted
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 * OJ's undirected graph serialization:
 * Nodes are labeled uniquely.
 * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 * The graph has a total of three nodes, and therefore contains three parts as separated by #.
 * 	   First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 *     Second node is labeled as 1. Connect node 1 to node 2.
 *     Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 * Visually, the graph looks like the following:
 * 	       1
 * 	      / \
 * 	     /   \
 * 	    0 --- 2
 * 	         / \
 * 	         \_/
 * @author yanma
 * @category Graph and Search
 * @version 2015-07-10
 * @class 7
 */
public class CloneGraph_137 {
	
	/**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node == null) {
            return null;
        }
        
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        ArrayList<UndirectedGraphNode> list = new ArrayList<UndirectedGraphNode>();
        
        UndirectedGraphNode base = new UndirectedGraphNode(node.label);
        map.put(node, base);
        list.add(node);
        int i = 0;
        // create all nodes
        while (i < list.size()) {
            UndirectedGraphNode curr = list.get(i);
            ArrayList<UndirectedGraphNode> neighbors = curr.neighbors;
            for (UndirectedGraphNode neighbor: neighbors) {
                if (!map.containsKey(neighbor)) {
                    UndirectedGraphNode newnode = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, newnode);
                    list.add(neighbor);
                }
            }
            i++;
        }
        
        // copy neighbors
        i = 0;
        while (i < list.size()) {
            UndirectedGraphNode curr = list.get(i);
            UndirectedGraphNode mapcurr = map.get(curr);
            ArrayList<UndirectedGraphNode> neighbors = curr.neighbors;
            for (UndirectedGraphNode neighbor: neighbors) {
                mapcurr.neighbors.add(map.get(neighbor));
            }
            i++;
        }
        
        return map.get(node);
    }

}
