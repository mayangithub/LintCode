/**
 * 
 */
package edu.pitt.easy;

import java.util.ArrayList;

/**
 * Insert Interval #30 --- Accepted
 * Given a non-overlapping interval list which is sorted by start point.
 * Insert a new interval into it, make sure the list is still in order and non-overlapping 
 * (merge intervals if necessary).
 * Example
 * Insert [2, 5] into [[1,2], [5,9]], we get [[1,9]].
 * Insert [3, 4] into [[1,2], [5,9]], we get [[1,2], [3,4], [5,9]].
 * @author yanma
 * @category Easy Level
 * @version 2015-08-05
 * @week1 0803-0809
 */
public class InsertInterval_30 {
	
	/**
     * Insert newInterval into intervals.
     * @param intervals: Sorted interval list.
     * @param newInterval: A new interval.
     * @return: A new sorted interval list.
     */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        // write your code here
        if (intervals == null || intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }
        
        int i = 0;
        boolean flag = false;
        while (i < intervals.size() && !flag) {
            if (newInterval.end < intervals.get(i).start) {
                result.add(newInterval);
                flag = true;
                break;
            } else if (newInterval.start > intervals.get(i).end) {
                result.add(intervals.get(i));
                i++;
                continue;
            }
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }
        
        while (i < intervals.size() && flag) {
            result.add(intervals.get(i));
            i++;
        }
        
        if (i == intervals.size() && !flag) {
            result.add(newInterval);
        }
        
        return result;
    }

}
