/**
 * 
 */
package edu.pitt.segmenttree;

/**
 * SegmentTreeNode
 * @author yanma
 *
 */
public class SegmentTreeNode {
	public int start, end, max, count;
	public SegmentTreeNode left, right;
	public SegmentTreeNode(int start, int end, int max) {
		this.start = start;
		this.end = end;
		this.max = max;
		this.left = this.right = null;
	}
}
