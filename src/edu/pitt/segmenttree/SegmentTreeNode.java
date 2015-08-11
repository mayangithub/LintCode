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
	public int start, end;
	public SegmentTreeNode left, right;
	public SegmentTreeNode(int start, int end) {
		this.start = start;
		this.end = end;
		this.left = this.right = null;
	}
}
