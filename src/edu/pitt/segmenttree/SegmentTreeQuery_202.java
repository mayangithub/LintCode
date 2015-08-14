/**
 * 
 */
package edu.pitt.segmenttree;
import edu.pitt.segmenttree.SegmentTreeNode;

/**
 * Segment Tree Query #202 --- Accepted
 * For an integer array (index from 0 to n-1, where n is the size of this array), in the corresponding SegmentTree, each node stores an extra attribute max to denote the maximum number in the interval of the array (index from start to end).
 * Design a query method with three parameters root, start and end, find the maximum number in the interval [start, end] by the given root of segment tree.
 *  Example
 * For array [1, 4, 2, 3], the corresponding Segment Tree is:
                  [0, 3, max=4]
                 /             \
          [0,1,max=4]        [2,3,max=3]
          /         \        /         \
   [0,0,max=1] [1,1,max=4] [2,2,max=2], [3,3,max=3]
 * query(root, 1, 1), return 4
 * query(root, 1, 2), return 4
 * query(root, 2, 3), return 3
 * query(root, 0, 2), return 4
 * Note
 * It is much easier to understand this problem if you finished Segment Tree Build first.
 * @author yanma
 * @category Segment Tree
 * @version 2015-08-10
 * @class 2,3
 * @week2 0810-0816
 */
public class SegmentTreeQuery_202 {
	
	/**
     *@param root, start, end: The root of segment tree and 
     *                         an segment / interval
     *@return: The maximum number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
    // 1. 如果查询区间 与   线段树 节点区间   相等         =》 直接返回该节点的最大值
    // 2. 如果查询区间 被   线段树 节点区间   包含         =》 查找区间递归向下
    // 3. 如果查询区间 与   线段树 节点空间   不相交       =》 直接返回
    // 4. 如果查询区间 与   线段树 节点空间   相交但不相等  =》 分裂查询空间， 分成一个被节点空间包含的区间，一个与节点空间不相交的区间
        
        if (start > end) {
            return 0;
        }
        
        if (start == root.start && end == root.end) {
            return root.max;
        } 
        
        int mid = (root.start + root.end) / 2;
        int maxleft = Integer.MIN_VALUE;
        int maxright = Integer.MIN_VALUE;
        // if [start, end] intersect/ contained by left range
        if (start <= mid) {
            if (end > mid) {
                maxleft = query(root.left, start, mid); // give to maxleft value, not return
            } else {
                maxleft = query(root.left, start, end);
            }
        }
        
        // if [start, end] intersect/ contained by right range
        if (end > mid) { // end >= mid + 1
            if (start <= mid) { // start <= mid + 1
                maxright = query(root.right, mid + 1, end); // caution: mid + 1 as start
            } else {
                maxright = query(root.right, start, end);// give to maxright value, not return
            }
        }
        
        return Math.max(maxleft, maxright);
    }
    
    
    /**
     * according to 4 conditions and each operations
     *@param root, start, end: The root of segment tree and 
     *                         an segment / interval
     *@return: The maximum number in the interval [start, end]
     */
    public int query1(SegmentTreeNode root, int start, int end) {
        // write your code here
        if (start > end) {
            return Integer.MIN_VALUE;
        }
        
        if (start == root.start && end == root.end) { //相等
            return root.max;
        } 
        
        if (start >= root.start && end <= root.end) { //包含
            int max1 = query1(root.left, start, end);
            int max2 = query1(root.right, start, end);
            return Math.max(max1, max2);
        }
        
        if (start > root.end || end < root.start) { //不相交
            return Integer.MIN_VALUE;
        }
        
        if (end > root.end) {//向右相交不相等
            return query1(root, start, root.end);
        } else if (start < root.start) {//向左相交不相等
            return query1(root, root.start, end);
        }
        
        return Integer.MIN_VALUE;
    }
    

}
