/**
 * 
 */
package edu.pitt.followupI;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import edu.pitt.easy.Interval;

/**
 * Number of Airplanes in the Sky #391 --- Accepted
 * Given an interval list which are flying and landing time of the flight. 
 * How many airplanes are on the sky at most?
 * Example
 * For interval list [[1,10],[2,3],[5,8],[4,7]], return 3
 * Note
 * If landing and flying happens at the same time, we consider landing should happen at first.
 * @author yanma
 * @version 2015-10-12
 * @category Follow Up I
 * @week 11 1012-1018
 */
public class NumberofAirplanesintheSky_391 {

    public class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start;
        }
    }
    
    
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) { 
        // write your code here
        if (airplanes == null) {
            return 0;
        } else if (airplanes.size() <= 1) {
            return airplanes.size();
        }
        
        Collections.sort(airplanes, new IntervalComparator());
        int sky = 0;
        int time = 0;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (Interval interval: airplanes) {
            while (time <= interval.start) {
                if (map.containsKey(time)) {
                    sky -= map.get(time);
                }
                time++;
            }
            sky++;
            max = Math.max(max, sky);
            if (map.containsKey(interval.end)) {
                map.put(interval.end, map.get(interval.end) + 1);
            } else {
                map.put(interval.end, 1);
            }
        }
        
        return max;
    }
}
