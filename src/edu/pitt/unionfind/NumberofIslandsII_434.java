/**
 * 
 */
package edu.pitt.unionfind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Number of Islands II #434 --- Accepted
 * Given a n,m which means the row and column of the 2D matrix and an array of pair A( size k). 
 * Originally, the 2D matrix is all 0 which means there is only sea in the matrix. 
 * The list pair has k operator and each operator has two integer A[i].x, 
 * A[i].y means that you can change the grid matrix[A[i].x][A[i].y] from sea to island. 
 * Return how many island are there in the matrix after each operator.
 * Example
 * Given n = 3, m = 3, array of pair A = [(0,0),(0,1),(2,2),(2,1)].
 * return [1,1,2,2].
 * Note
 * 0 is represented as the sea, 1 is represented as the island. 
 * If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent.
 * @author yanma
 * @category Union Find
 * @version 2015-08-22
 * @class 2,3
 * @week3 0817-0823
 */
public class NumberofIslandsII_434 {
	 class Point {
		      int x;
		      int y;
		      Point() { x = 0; y = 0; }
		      Point(int a, int b) { x = a; y = b; }
	 }
	
	
	class UnionFind {
        public HashMap<Integer, Integer> fathermap = new HashMap<Integer, Integer>();
        
        public UnionFind(HashSet<Integer> nodes) {
            for (Integer node: nodes) {
                fathermap.put(node, node);
            }
        }
        
        public int find(int x) {
            int father = fathermap.get(x);
            while (father != fathermap.get(father)) {
                father = fathermap.get(father);
            }
            return father;
        }
        
        public void union(int x, int y) {
            int father1 = find(x);
            int father2 = find(y);
            if (father1 != father2) {
                fathermap.put(father1, father2);
            }
        }
        
        public int compressedFind(int x) {
            int father = find(x);
            while (father != fathermap.get(x)) {
                int temp = fathermap.get(x);
                fathermap.put(x, father);
                x = temp;
            }
            return father;
        }
    }
    
    
    /**
     * @param n an integer
     * @param m an integer
     * @param operators an array of point
     * @return an integer array
     */
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // Write your code here
        List<Integer> result = new ArrayList<Integer>();
        if (n == 0 || m == 0 || operators == null || operators.length == 0) {
            return result;
        }
        HashSet<Integer> nodes = new HashSet<Integer>();
        UnionFind uf = new UnionFind(nodes);
        int count = 0;
        for (int i = 0; i < operators.length; i++) {
            count++;
            Point point = operators[i];
            int num = point.x * m + point.y;
            nodes.add(num);
            uf.fathermap.put(num, num);
            if (point.x >= 1 && nodes.contains(num - m)) {
                int fa1 = uf.find(num);
                int fa2 = uf.find(num - m);
                if (fa1 != fa2) {
                    count--;
                    uf.union(fa1, fa2);
                }
            }
            if (point.x + 1 < n && nodes.contains(num + m)) {
                int fa1 = uf.find(num);
                int fa2 = uf.find(num + m);
                if (fa1 != fa2) {
                    count--;
                    uf.union(fa1, fa2);
                }
            }
            if (point.y >= 1 && nodes.contains(num - 1)) {
                int fa1 = uf.find(num);
                int fa2 = uf.find(num - 1);
                if (fa1 != fa2) {
                    count--;
                    uf.union(fa1, fa2);
                }
            }
            if (point.y + 1 < m && nodes.contains(num + 1)) {
                int fa1 = uf.find(num);
                int fa2 = uf.find(num + 1);
                if (fa1 != fa2) {
                    count--;
                    uf.union(fa1, fa2);
                }
            }
            result.add(count);
        }
        
        
        return result;
    }
}
