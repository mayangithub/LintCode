/**
 * 
 */
package edu.pitt.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Route Between Two Nodes in Graph #176 --- Accepted
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 * Example
 * Given graph:
 * A----->B----->C
 *  \     |
 *   \    |
 *    \   |
 *     \  v
 *      ->D----->E
 * for s = B and t = E, return true
 * for s = D and t = C, return false
 * @author yanma
 * @category Graph
 * @version 2015-10-27
 * @week 13 1026-1101
 */
public class RouteBetweenTwoNodesinGraph_176 {
	/**
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
     
    HashMap<DirectedGraphNode, Boolean> map = new HashMap<DirectedGraphNode, Boolean>();
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, 
                            DirectedGraphNode s, DirectedGraphNode t) {
        // write your code here
        if (s == null || t == null) {
            return false;
        }
        
        if (s.label == t.label) {
            return true;
        }
        
        initialize(graph);
        
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        queue.offer(s);
        while (!queue.isEmpty()) {
            if (queue.peek().label == t.label) {
                return true;
            }
            DirectedGraphNode out = queue.poll();
            for (DirectedGraphNode neighbor: out.neighbors) {
                if (!map.get(neighbor)) {
                    queue.offer(neighbor);
                }
            }
            map.put(out, true);
        }
        
        return false;
    }
    
    public void initialize(ArrayList<DirectedGraphNode> graph) {
        for (DirectedGraphNode node: graph) {
            map.put(node, false);
        }
    }

}
