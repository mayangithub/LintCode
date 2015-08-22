/**
 * 
 */
package edu.pitt.unionfind;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Number of Islands #433 --- Accepted
 * Given a boolean 2D matrix, find the number of islands. 
 * Example
 * Given graph:
	[
	  [1, 1, 0, 0, 0],
	  [0, 1, 0, 0, 1],
	  [0, 0, 0, 1, 1],
	  [0, 0, 0, 0, 0],
	  [0, 0, 0, 0, 1]
	]
 * return 3.
 * Note
 * 0 is represented as the sea, 1 is represented as the island. 
 * If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent.
 * @author yanma
 * @category Union Find
 * @version 2015-08-18
 * @class 2,3
 * @week3 0817-0823
 */
public class NumberofIslands_433 {
	
	/**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
     
    public class UnionFind {
        public HashMap<Integer, Integer> fathermap = new HashMap<Integer, Integer>();
        
        public UnionFind(HashSet<Integer> nodes) {
            for (Integer node: nodes) {
                fathermap.put(node, node);
            }
        }
        
        public int find(int x) {
            int parent = this.fathermap.get(x);
            while (parent != fathermap.get(parent)) {
                parent = fathermap.get(parent);
            }
            return parent;
        }
        
        public void union(int x, int y) {
            int parent1 = find(x);
            int parent2 = find(y);
            if (parent1 != parent2) {
                fathermap.put(parent1, parent2);
            }
        }
        
        public int compressed_find(int x) {
            int parent = find(x);
            while (fathermap.get(x) != parent) {
                int temp = fathermap.get(x);
                fathermap.put(x, parent);
                x = temp;
            }
            return parent;
        }
        
        
    } 
     
     
    public int numIslands(boolean[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        HashSet<Integer> nodes = transform(grid);
        int rows = grid.length;
        int cols = grid[0].length;
        UnionFind uf = new UnionFind(nodes);
        int count = nodes.size();
        for (Integer node: nodes) {
            boolean connected = false;
            int r = node / cols;
            int c = node % cols;
            int up = r - 1;
            int down = r + 1;
            int left = c - 1;
            int right = c + 1;
            if (up >= 0 && nodes.contains(up * cols + c)) {
                int f1 = uf.find(node);
                int f2 = uf.find(up * cols + c);
                if (f1 != f2) {
                    count--;
                    uf.union(f1, f2);
                }
            }
            if (down < rows && nodes.contains(down * cols + c)) {
                int f1 = uf.find(node);
                int f2 = uf.find(down * cols + c);
                if (f1 != f2) {
                    count--;
                    uf.union(f1, f2);
                }
            }
            if (left >= 0 && nodes.contains(r * cols + left)) {
                int f1 = uf.find(node);
                int f2 = uf.find(r * cols + left);
                if (f1 != f2) {
                    count--;
                    uf.union(f1, f2);
                }
            }
            if (right < cols && nodes.contains(r * cols + right)) {
                int f1 = uf.find(node);
                int f2 = uf.find(r * cols + right);
                if (f1 != f2) {
                    count--;
                    uf.union(f1, f2);
                }
            }
        }
        
        return count;
    }
    
    public HashSet<Integer> transform(boolean[][] grid) {
        HashSet<Integer> nodes = new HashSet<Integer>();
        int rows = grid.length;
        int cols = grid[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c]) {
                    int num = r * cols + c;
                    nodes.add(num);
                }
            }
        }
        return nodes;
    }

}
