package com.catxu.leetcode.question179;

import java.util.Arrays;

/**
 * 179. Largest Number
 */
class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = nums[i] + "";
        }
        // 根据集合全序关系 total order
        // 对于 nums 中的任意两个值 a 和 b，我们无法直接从常规角度上确定其大小/先后关系
        // 但我们可以根据「结果」来决定 a 和 b 的排序关系：
        // 如果拼接结果 ab 要比 ba 好，那么我们会认为 a 应该放在 b 前面
        Arrays.sort(ss, (a, b) -> {
            String ab = a + b, ba = b + a; // 保证 ab、ba 等长
            return ba.compareTo(ab);
        });
        // 上述解法，我们需要证明两个内容：
        // 1. 该贪心策略能取到全局最优解：反证法，贪心结果ans与全局最优max一定相等
        // 2. 这样的「排序比较逻辑」应用在集合 nums 上具有「全序关系」
        // 例如：[14, 5, 30] 这3个数，30 会在 14 之前，5 会在 30 之前，根据全序传递，所以 5 一定在 14 之前
        StringBuilder sb = new StringBuilder();
        for (String s : ss) {
            sb.append(s);
        }
        int k = 0;
        while (k < sb.length() - 1 && sb.charAt(k) == '0') {
            k++;
        }
        return sb.substring(k);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestNumber(new int[]{5, 14, 7, 30, 2, 8}));
        System.out.println(new Solution().largestNumber(new int[]{78, 5, 4}));

        // 根据本题可以出一个镜像问题：
        // 字符串 s 是由 n 个整数组成的最大数，给定字符串s，找到这 n 个整数，使其组成的和最小，返回 sum 值。
        // 例1： s = "87530214", 输出 8 + 7 + 5 + 30 + 2 + 14 = 66
        // 例2： s = "7854", 输出 78 + 5 + 4 = 87
        // public int findLargestNumSum(String s)
        // Constraints: s >= 0 且 s 是合法整数
        // 从前往后遍历，遇到 s.charAt(i) > s.charAt(i + 1) 将 i 入队列 Queue
        // 从前往后遍历，遇到 s.charAt(i) < s.charAt(i + 1) 将 i - 1 出队，然后加上当前数值重新入队
    }
}
