package com.catxu.leetcode.question452;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 452. Minimum Number of Arrows to Burst Balloons
 */
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int preIntervalEnd = points[0][1];
        int ans = 1;
        for (int i = 1; i < points.length; i++) {
            if (preIntervalEnd < points[i][0]) {
                ans++;
                preIntervalEnd = points[i][1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] points0 = new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(new Solution().findMinArrowShots(points0));
        int[][] points1 = new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        System.out.println(new Solution().findMinArrowShots(points1));
        int[][] points2 = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        System.out.println(new Solution().findMinArrowShots(points2));
    }
}