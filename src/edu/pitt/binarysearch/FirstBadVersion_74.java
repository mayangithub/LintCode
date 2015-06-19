/**
 * 
 */
package edu.pitt.binarysearch;

/**
 * First Bad Version #74 --- accepted
 * The code base version is an integer start from 1 to n. 
 * One day, someone committed a bad version in the code case, 
 * so it caused this version and the following versions are all failed in the unit tests. 
 * Find the first bad version.
 * You can call isBadVersion to help you determine which version is the first bad one. 
 * The details interface can be found in the code's annotation part.
 * Example
 * 	Given n = 5:
 * 	isBadVersion(3) -> false
 * 	isBadVersion(5) -> true
 * 	isBadVersion(4) -> true	
 *  Here we are 100% sure that the 4th version is the first bad version.
 * Note
 * 	Please read the annotation in code area to get the correct way to call isBadVersion in different language. 
 * For example, Java is VersionControl.isBadVersion(v)
 * 	Challenge
 * You should call isBadVersion as few as possible.
 * @author yanma
 * @category Binary search
 * @version 2015-06-19
 * @class 2
 */
public class FirstBadVersion_74 {
	/**
	 * public class VersionControl {
	 *     public static boolean isBadVersion(int k);
	 * }
	 * you can use VersionControl.isBadVersion(k) to judge whether 
	 * the kth code version is bad or not.
	*/
	
	/**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        if (n < 1) {
            return 0;
        }
        
        int start = 1;
        int end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (VersionControl.isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (VersionControl.isBadVersion(start)) {
            return start;
        } 
        return end;
    }
	
	
}
