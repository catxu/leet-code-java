package com.catxu.leetcode.question494;

/**
 * 494. Target Sum
 */
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (Math.abs(target) > sum) {
            return 0;
        }
        // P(正数集合) + abs(N(负数集合)) = sum
        // P - abs(N) = target
        // P = (sum + target) / 2  为什么减法也可以？！(sum - target) / 2
        int knapsackSize = (sum - target) / 2;
        if (knapsackSize * 2 != sum - target) { // 不能整除说明无法凑出 target
            return 0;
        }
        // dp[j] 装满容量为j的背包有多少种方式
        int[] dp = new int[knapsackSize + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = knapsackSize; j - nums[i] >= 0; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[knapsackSize];
    }

    public int findTargetSumWaysII(int[] nums, int target) {
        int n = nums.length, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum < Math.abs(target)) {
            return 0;
        }
        int w = (sum + target) / 2;
        if (w * 2 != sum + target) {
            return 0;
        }
        // dp[i][j] 0到i物品任取填满容量j的背包有多少种方式
        int[][] dp = new int[n][w + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                if (i == 0) {
                    dp[0][j] += (j - nums[i] == 0 ? 1 : 0);
                    continue;
                }
                if (nums[i] > j) {
                    dp[i][j] = dp[i - 1][j]; // 不放物品 i
                } else {
                    // 不放物品 i 和放物品 i（放物品i需要从背包中腾出j-nums[i]的空间）
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[n - 1][w];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(new Solution().findTargetSumWays(new int[]{0}, 0));
        System.out.println(new Solution().findTargetSumWaysII(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(new Solution().findTargetSumWaysII(new int[]{0}, 0));
    }
}
