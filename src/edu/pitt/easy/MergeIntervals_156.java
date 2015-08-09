/**
 * 
 */
package edu.pitt.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Merge Intervals #156 --- Accepted
 * Given a collection of intervals, merge all overlapping intervals.
 *  Example
 * Given intervals => merged intervals:
	[                     [
	  [1, 3],               [1, 6],
	  [2, 6],      =>       [8, 10],
	  [8, 10],              [15, 18]
	  [15, 18]            ]
	]
 * Challenge
 * O(n log n) time and O(1) extra space.
 * @author yanma
 * @category Easy Level
 * @version 2015-08-09
 * @week1 0803-0809
 */
public class MergeIntervals_156 {
	/**
     * @param intervals: Sorted interval list.
     * @return: A new sorted interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        List<Interval> result = new ArrayList<Interval>();
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        
        Collections.sort(intervals, new IntervalComparator());
        Interval prev = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if (curr.start <= prev.end) {
                prev.end = Math.max(curr.end, prev.end);
            } else {
                result.add(prev);
                prev = curr;
            }
        }
        result.add(prev);
        return result;
    }
    
    public class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }


}
