/**
 * 
 */
package edu.pitt.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Topological Sorting #127 --- Accepted
 * Given an directed graph, a topological order of the graph nodes is defined as follow:
    For each directed edge A -> B in graph, A must before B in the order list.
    The first node in the order can be any node in the graph with no nodes direct to it.
 * Find any topological order for the given graph.
 * Example
 * For graph as follow:
 * The topological order can be:
 * [0, 1, 2, 3, 4, 5]
 * [0, 2, 3, 1, 5, 4]
 * ...
 * Note
 * You can assume that there is at least one topological order in the graph.
 * Challenge
 * Can you do it in both BFS and DFS?
 * @author yanma
 * @category Graph and Search
 * @version 2015-07-10
 * @class 7
 */
public class TopologicalSorting_127 {
	
	/**
	 * BFS
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        // step 1: calculate all indegree for each node
        // step 2: go through the graph list, get all indegree node and add them to queue 
        // step 3: loop through queue, add the node to result list, and look up its neighbors, make them indegree -1, 
        // step 4: see neighbors which has indegree 0, add it to queue,
        // step 5: go to step 3
        
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        if (graph == null || graph.size() == 0) {
            return result;
        }
        
        HashMap<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
        // calculate indegree for each node
        for (DirectedGraphNode fromNode: graph) {
            if (!map.containsKey(fromNode)) {
                map.put(fromNode, 0);
            }
            for (DirectedGraphNode toNode: fromNode.neighbors) {
                if (!map.containsKey(toNode)) {
                    map.put(toNode, 1);
                } else {
                    map.put(toNode, map.get(toNode) + 1);
                }
            }
        }
        
        // add root to list
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        for (DirectedGraphNode fromNode: graph) {
            if (map.get(fromNode) == 0) {
                queue.offer(fromNode);
            }
        }
        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            result.add(node);
            map.put(node, -1);
            for (DirectedGraphNode neighbor: node.neighbors) {
                map.put(neighbor, map.get(neighbor) - 1);
                if (map.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        return result;
    }
    
    
    /**
     * DFS
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort1(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        // step 1: calculate all indegree for each node
        // step 2: go through the graph list, once get the node which has indegree 0, call helper 
        // step 3: add the node to result list, make it indegree be -1, 
    	// step 4: loop through its neighbors, make them indegree minus 1, see neighbors which has indegree 0, call helper for it,
        // step 5: go to step 3
        
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        if (graph == null || graph.size() == 0) {
            return result;
        }
        
        HashMap<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
        // calculate indegree for each node
        for (DirectedGraphNode fromNode: graph) {
            if (!map.containsKey(fromNode)) {
                map.put(fromNode, 0);
            }
            for (DirectedGraphNode toNode: fromNode.neighbors) {
                if (!map.containsKey(toNode)) {
                    map.put(toNode, 1);
                } else {
                    map.put(toNode, map.get(toNode) + 1);
                }
            }
        }
        
        for (DirectedGraphNode node: graph) {
            if (map.get(node) == 0) {
                helper(graph, result, map, node);
            }
        }
        
        return result;
    }
    
    public void helper(ArrayList<DirectedGraphNode> graph, ArrayList<DirectedGraphNode> result, HashMap<DirectedGraphNode, Integer> map, DirectedGraphNode node) {
        result.add(node);
        map.put(node, -1);
        for (DirectedGraphNode neighbor: node.neighbors) {
            map.put(neighbor, map.get(neighbor) - 1);
            if (map.get(neighbor) == 0) {
                helper(graph, result, map, neighbor);
            }
        }
    }

}
