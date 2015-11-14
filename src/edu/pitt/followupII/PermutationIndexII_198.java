/**
 * 
 */
package edu.pitt.followupII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Permutation Index II Show result #198
 * Given a permutation which may contain repeated numbers, 
 * find its index in all the permutations of these numbers, 
 * which are ordered in lexicographical order. The index begins at 1.
 * Example
 * Given the permutation [1, 4, 2, 2], return 3.
 * @author yanma
 * @category Follow Up II
 * @version 2015-10-26
 * @week13 1026-1101
 */
public class PermutationIndexII_198 {
	/**
     * @param A an integer array
     * @return a long integer
     */
    class Element {
        int start_index;
        int total;
        int occur;
        Element(int index) {
            this.start_index = index;
            this.total = 1;
            this.occur = 0;
        }
    }
     
     
    public long permutationIndexII(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        } else if (A.length == 1) {
            return 1;
        }
        
        int len = A.length;
        int[] sorted = Arrays.copyOf(A, len);
        Arrays.sort(sorted);
        HashMap<Integer, Element> map = new HashMap<Integer, Element>();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        int unique = 0;
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(sorted[i])) {
                Element ele = new Element(unique);
                map.put(sorted[i], ele);
                unique++;
                numbers.add(sorted[i]);
            } else {
                map.get(sorted[i]).total++;
            }
        }
        
        long[] facArray = factorial(len);
        long sum = 0;
        for (int i = 0; i < len; i++) {
            int num = A[i];
            for (int j = 0; j < map.get(num).start_index; j++) {
                if (map.get(numbers.get(j)).occur >= map.get(numbers.get(j)).total) continue;
                int small = numbers.get(j);
                sum += remain(A, i, small, numbers, map, facArray);
            }
            map.get(num).occur++;
        }
        
        return sum + 1;
    }
    
    public long[] factorial(int len) {
        long[] facArray = new long[len];
        facArray[0] = 1;
        for (int i = 1; i < len; i++) {
            facArray[i] = facArray[i - 1] * i;
        }
        
        return facArray;
    }
    
    public long remain(int[] A, int index, int small, ArrayList<Integer> numbers, HashMap<Integer, Element> map, long[] fac) {
        long upper = fac[A.length - index - 1];
        long lower = 1;
        for (int i = 0; i < numbers.size(); i++) {
            int left = map.get(numbers.get(i)).total - map.get(numbers.get(i)).occur;
            left = (numbers.get(i) == small) ? left - 1: left;
            lower *= fac[left];
        }
        
        return upper / lower;
    }

}
