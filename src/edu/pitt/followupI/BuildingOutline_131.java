/**
 * 
 */
package edu.pitt.followupI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Building Outline #131 --- Accepted
 * Given N buildings in a x-axis，
 * each building is a rectangle and can be represented by a triple (start, end, height)，
 * where start is the start position on x-axis, 
 * end is the end position on x-axis and height is the height of the building. 
 * Buildings may overlap if you see them from far away，find the outline of them。
 * An outline can be represented by a triple, (start, end, height), 
 * where start is the start position on x-axis of the outline, 
 * end is the end position on x-axis and height is the height of the outline.
 * Example
 * Given 3 buildings：
	[
	  [1, 3, 3],
	  [2, 4, 4],
	  [5, 6, 1]
	]
 * The outlines are：
	[
	  [1, 2, 3],
	  [2, 4, 4],
	  [5, 6, 1]
	]
 * Note
 * Please merge the adjacent outlines if they have the same height and make sure different outlines cant overlap on x-axis.
 * @author yanma
 * @version 2015-10-13
 * @category Follow Up I
 * @week 11 1012-1018
 */


public class BuildingOutline_131 {

    public class Edge {
        int xaxis;
        int height;
        boolean isstart;
        public Edge(int x, int h) {
            this.xaxis = x;
            this.height = h;
        }
    }
    
    public class EdgeComparator implements Comparator<Edge> {
        public int compare(Edge e1, Edge e2) {
            if (e1.xaxis != e2.xaxis) {
                return e1.xaxis - e2.xaxis;
            } else if (e1.isstart && e2.isstart) {
                return e2.height - e1.height; // when both starting, taller come first
            } else if (!e1.isstart && !e2.isstart) {
                return e1.height - e2.height;
            }
            return (e1.isstart) ? -1: 1;
        }
    }
    
    /**
     * @param buildings: A list of lists of integers
     * @return: Find the outline of those buildings
     */
    public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (buildings == null || buildings.length == 0 || buildings[0].length < 3) {
            return result;
        }
        
        ArrayList<Edge> edges = new ArrayList<Edge>();
        for (int[] building: buildings) {
            Edge left = new Edge(building[0], building[2]);
            left.isstart = true;
            edges.add(left);
            Edge right = new Edge(building[1], building[2]);
            right.isstart = false;
            edges.add(right);
        }
        
        Collections.sort(edges, new EdgeComparator());
        
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(); // negative values
        
        ArrayList<Edge> processed = new ArrayList<Edge>();
        for (Edge edge: edges) {
            if (edge.isstart) {
                if (heap.isEmpty() || edge.height * (-1) < heap.peek()) {
                    processed.add(edge);
                }
                heap.add(edge.height * (-1));
            } else {
                heap.remove(edge.height * (-1));
                if (heap.isEmpty() || edge.height * (-1) < heap.peek()) {
                    if (heap.isEmpty()) {
                        processed.add(new Edge(edge.xaxis, 0));
                    } else {
                        processed.add(new Edge(edge.xaxis, heap.peek() * (-1)));
                    }
                }
            }
        }
        
        if (processed.size() > 0) {
            int pre = processed.get(0).xaxis;
            int height = processed.get(0).height;
            for (int i = 1; i < processed.size(); i++) {
                ArrayList<Integer> now = new ArrayList<Integer>();
                int x = processed.get(i).xaxis;
                if (height > 0) {
                    now.add(pre);
                    now.add(x);
                    now.add(height);
                    result.add(now);
                }
                pre = x;
                height = processed.get(i).height;
            }
        }
        
        return result;
    }
}
