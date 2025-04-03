package com.catxu.leetcode.question523;

import java.util.HashSet;
import java.util.Set;

/**
 * 523. Continuous Subarray Sum
 */
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        // 同余定理，维护前缀和
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + nums[i - 1];
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            set.add(sum[i - 2] % k);
            // 回溯历史余数，如果找到相同余数，则存在 (sum[j] - sum[i]) % k = 0，即存在 k 的倍数。
            if (set.contains(sum[i] % k)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6));
    }
}
