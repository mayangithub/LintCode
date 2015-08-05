/**
 * 
 */
package edu.pitt.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import edu.pitt.graph.UndirectedGraphNode;

/**
 * Find the Connected Component in the Undirected Graph #431 --- Accepted
 * Find the number connected component in the undirected graph. 
 * Each node in the graph contains a label and a list of its neighbors. 
 * (a connected component (or just component) of an undirected graph 
 * is a subgraph in which any two vertices are connected to each other by paths, 
 * and which is connected to no additional vertices in the supergraph.)
 * Example
 * Given graph:
 * A------B  C
 *  \     |  | 
 *   \    |  |
 *    \   |  |
 *     \  |  |
 *       D   E
 * Return {A,B,D}, {C,E}. Since there are two connected component which is {A,B,D}, {C,E}
 * @author yanma
 * @category Easy Level
 * @version 2015-08-04
 * @week1 0803-0809
 */
public class FindtheConnectedComponentintheUndirectedGraph_431 {
	/**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nodes == null || nodes.size() == 0) {
            return result;
        }
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        
        for (UndirectedGraphNode node: nodes) {
            map.put(node.label, false);
        }
        
        helper(nodes, map, result);
        
        return result;
    }
    
    public void helper(ArrayList<UndirectedGraphNode> nodes, HashMap<Integer, Boolean> map, List<List<Integer>> result) {
        for (UndirectedGraphNode node: nodes) {
            if (!map.get(node.label)) {
                List<Integer> inner = new ArrayList<Integer>();
                Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
                queue.offer(node);
                map.put(node.label, true);
                while (!queue.isEmpty()) {
                    UndirectedGraphNode out = queue.poll();
                    inner.add(out.label);
                    for (UndirectedGraphNode neighbor: out.neighbors) {
                        if (!map.get(neighbor.label)) {
                            queue.offer(neighbor);
                            map.put(neighbor.label, true);
                        }
                    }
                }
                Collections.sort(inner);
                result.add(inner);
            }
        }
    }
}
