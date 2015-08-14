/**
 * 
 */
package edu.pitt.segmenttree;

/**
 * Segment Tree Query II #247 --- Accepted
 * For an array, we can build a SegmentTree for it, 
 * each node stores an extra attribute count to denote the number of elements in the the array which value is between interval start and end. 
 * (The array may not fully filled by elements)
 * Design a query method with three parameters root, start and end, 
 * find the number of elements in the in array's interval [start, end] by the given root of value SegmentTree.
 *  Example
 * For array [0, 2, 3], the corresponding value Segment Tree is:
                     [0, 3, count=3]
                     /             \
          [0,1,count=1]             [2,3,count=2]
          /         \               /            \
   [0,0,count=1] [1,1,count=0] [2,2,count=1], [3,3,count=1]
 * query(1, 1), return 0
 * query(1, 2), return 1
 * query(2, 3), return 2
 * query(0, 2), return 2
 * Note
 * It is much easier to understand this problem if you finished Segment Tree Buildand Segment Tree Query first.
 * @author yanma
 * @category Segment Tree
 * @version 2015-08-13
 * @class 2,3
 * @week2 0810-0816
 */
public class SegmentTreeQueryII_247 {
	 /**
     *@param root, start, end: The root of segment tree and 
     *                         an segment / interval
     *@return: The count number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        if (start > end || root == null) {
            return 0;
        }
        
        if (root.start >= start && root.end <= end) { 
        	//make sense, the [root.start, root.end] means the min and max in segment tree, 
        	//so if the start < root.start or end > root.end, there's impossible to have node values in [start, root.start] and [root.end, end]
            return root.count;
        }
        
        int mid = (root.start + root.end) / 2;
        int countleft = 0;
        int countright = 0;
        
        if (start <= mid) {
            if (end > mid) {
                countleft = query(root.left, start, mid);
            } else {
                countleft = query(root.left, start, end);
            }
        }
        
        if (end >= mid + 1) {
            if (start < mid + 1) {
                countright = query(root.right, mid + 1, end);
            } else {
                countright = query(root.right, start, end);
            }
        }
        
        return countleft + countright;
    }

}
