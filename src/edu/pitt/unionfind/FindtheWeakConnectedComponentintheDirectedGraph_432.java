/**
 * 
 */
package edu.pitt.unionfind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Find the Weak Connected Component in the Directed Graph #432 --- Accepted
 * Find the number Weak Connected Component in the directed graph. 
 * Each node in the graph contains a label and a list of its neighbors. 
 * (a connected set of a directed graph is a subgraph in which any two vertices are connected by direct edge path.)
 *  Example
 * Given graph:
	A----->B  C
	 \     |  | 
	  \    |  |
	   \   |  |
	    \  v  v
	     ->D  E <- F
 * Return {A,B,D}, {C,E,F}. Since there are two connected component which are {A,B,D} and {C,E,F}
 * Note
 * Sort the element in the set in increasing order
 * @author yanma
 * @category Union Find
 * @version 2015-08-15
 * @class 2,3 Advanced
 * @week2 0810-0816
 */
public class FindtheWeakConnectedComponentintheDirectedGraph_432 {
	
	public class DirectedGraphNode {
		int label;
		ArrayList<DirectedGraphNode> neighbors;
		DirectedGraphNode(int x) { 
			label = x; 
			neighbors = new ArrayList<DirectedGraphNode>(); 
		}
	}

	public class UnionFind {
        public HashMap<Integer, Integer> fathermap = new HashMap<Integer, Integer>();
        public UnionFind(HashSet<Integer> nodes) {
            for (Integer nodelabel: nodes) {
                fathermap.put(nodelabel, nodelabel);
            }
        }
        
        public int find(int label) { // find biggest brother
            int father = this.fathermap.get(label);
            while (father != fathermap.get(father)) {
                father = fathermap.get(father);
            }
            return father;
        }
        
        public void union(int label1, int label2) {
            int father1 = find(label1);
            int father2 = find(label2);
            if (father1 != father2) {
                fathermap.put(father1, father2);
            }
        }
        
        public int compressed_find(int label) {
            int parent = find(label);
            int bro = label;
            while (fathermap.get(bro) != parent) {
                int temp = fathermap.get(bro);
                fathermap.put(bro, parent);
                bro = temp;
            }
            return parent;
        }
    }
    
    
    /**
     * @param nodes a array of Directed graph node
     * @return a connected set of a directed graph
     */
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        // Write your code here
        if (nodes == null || nodes.size() == 0) {
            return new ArrayList<List<Integer>>();
        }
        
        HashSet<Integer> nodeset = new HashSet<Integer>();
        for (DirectedGraphNode node: nodes) {
            nodeset.add(node.label);
            for (DirectedGraphNode neighbor: node.neighbors) {
                nodeset.add(neighbor.label);
            }
        }
        
        UnionFind uf = new UnionFind(nodeset);
        
        for (DirectedGraphNode node: nodes) {
            for (DirectedGraphNode neighbor: node.neighbors) {
                uf.union(node.label, neighbor.label);
            }
        }
        
        return helper(uf, nodeset);
    }
    
    public List<List<Integer>> helper(UnionFind uf, HashSet<Integer> hashset) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        
        for (Integer label: hashset) {
            int father = uf.find(label);
            if (!map.containsKey(father)) {
                map.put(father, new ArrayList<Integer>());
            }
            ArrayList<Integer> group = map.get(father);
            group.add(label);
            //map.put(father, group);
        }
        
        for (ArrayList<Integer> group: map.values()) {
            Collections.sort(group);
            result.add(group);
        }
        
        return result;
    }
}
