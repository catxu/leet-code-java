package com.catxu.leetcode.question560;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. Subarray Sum Equals K
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0, n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) prefix[i] = prefix[i - 1] + nums[i]; // 构建前缀和
        Map<Integer, Integer> dict = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int diff = prefix[i] - k;
            if (dict.containsKey(diff)) ans += dict.get(diff);
            if (diff == 0) ans++;
            dict.merge(prefix[i], 1, Integer::sum);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subarraySum(new int[]{1, 2, 3}, 3));
        System.out.println(new Solution().subarraySum(new int[]{-1, 1, -1, -1, 0, 1, 1}, -2));
        System.out.println(new Solution().subarraySum(new int[]{0, 0, 0}, 0));
    }
}
