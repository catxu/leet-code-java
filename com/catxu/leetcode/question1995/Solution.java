package com.catxu.leetcode.question1995;

/**
 * 1995. Count Special Quadruplets
 */
class Solution {

    /*
     * 数组哈希
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(1)
     */
    public int countQuadrupletsII(int[] nums) {
        int n = nums.length, ans = 0;
        int[] cnt = new int[300]; // a + b + c 最大 300
        for (int b = n - 3; b >= 1; b--) {
            for (int d = b + 2; d < n; d++) {
                cnt[nums[d] - nums[b + 1] + 99]++; // d c 最大差为 -99
            }
            for (int a = 0; a < b; a++) {
                ans += cnt[nums[a] + nums[b] + 99];
            }
        }
        return ans;
    }

    /*
     * 多维背包
     * 时间复杂度：O(n∗101∗4)
     * 空间复杂度：O(n∗101∗4)
     */
    public int countQuadruplets(int[] nums) {
        int n = nums.length, ans = 0;
        // 前i个元素组成j使用k个数 的方案数
        int[][][] dp = new int[n + 1][101][4];
        dp[0][0][0] = 1; // 使用0个数 组成0 有1种方案
        for (int i = 1; i <= n; i++) {
            int t = nums[i - 1];
            for (int j = 0; j < 101; j++) { // j 的取值范围 [0, 100]
                for (int k = 0; k < 4; k++) { // k 最多取 3 个数
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j - t >= 0 && k > 0) dp[i][j][k] += dp[i - 1][j - t][k - 1]; // 前 i-1 个数 组成 j - t 的方案数
                }
            }
        }
        for (int i = 3; i < n; i++) {
            ans += dp[i][nums[i]][3]; // 前 i 个数 组成 nums[i] 使用 3 个数的方案数之和
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countQuadruplets(new int[]{1, 2, 3, 6}));
        System.out.println(new Solution().countQuadrupletsII(new int[]{1, 2, 3, 6}));
    }
}
