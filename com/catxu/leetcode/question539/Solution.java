package com.catxu.leetcode.question539;

import java.util.Arrays;
import java.util.List;

/**
 * 539. Minimum Time Difference
 */
class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        if (n > 1440) return 0;
        int[] nums = new int[n];
        int i = 0, ans = 1440;
        for (String point : timePoints) {
            String[] time = point.split(":");
            int h = Integer.parseInt(time[0]);
            int m = Integer.parseInt(time[1]);
            nums[i] = h * 60 + m;
            i++;
        }
        Arrays.sort(nums);
        for (i = 0; i < n - 1; i++) {
            ans = Math.min(ans, nums[i + 1] - nums[i]); // 比较相邻分差
        }
        ans = Math.min(ans, nums[0] + 1440 - nums[n - 1]); // 比较首尾可能存在的跨天场景
        return ans;
    }
}
