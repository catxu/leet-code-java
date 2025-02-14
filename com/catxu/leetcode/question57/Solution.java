package com.catxu.leetcode.question57;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 57. Insert Interval
 * <p>
 * You are given an array of non-overlapping intervals <i>intervals</i> where intervals[i] = [start<sub>i</sub>, end<sub>i</sub>] represent the start and the end of the i<sup>th</sup> interval and intervals is sorted in ascending order by start<sub>i</sub>. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 * <p>
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by start<sub>i</sub> and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 * <p>
 * Return intervals after the insertion.
 * <p>
 * Note that you don't need to modify intervals in-place. You can make a new array and return it.
 * <p>
 * Example 1:
 * <pre>
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * </pre>
 * Example 2:
 * <pre>
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * </pre>
 * Constraints:
 * <pre>
 * 0 <= intervals.length <= 10<sup>4</sup>
 * intervals[i].length == 2
 * 0 <= start<sub>i</sub> <= end<sub>i</sub> <= 10<sup>5</sup>
 * intervals is sorted by start<sub>i</sub> in ascending order.
 * newInterval.length == 2
 * 0 <= start <= end <= 10<sup>5</sup>
 * </pre>
 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int left = newInterval[0], right = newInterval[1];
        boolean place = false;
        for (int[] interval : intervals) {
            if (left > interval[1]) {
                // 插入左侧
                res.add(interval);
            } else if (right < interval[0]) {
                // 插入右侧
                if (!place) {
                    res.add(new int[]{left, right});
                    place = true;
                }
                res.add(interval);
            } else {
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!place) {
            res.add(new int[]{left, right});
        }
        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.deepToString(s.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
        System.out.println(Arrays.deepToString(s.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8})));
    }
}
