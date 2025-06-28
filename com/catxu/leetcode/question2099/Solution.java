package com.catxu.leetcode.question2099;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 2099. Find Subsequence of Length K With the Largest Sum
 */
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        Integer[] idx = new Integer[n];
        Arrays.setAll(idx, i -> i);
        Arrays.sort(idx, (i, j) -> nums[j] - nums[i]); // 根据
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = idx[i];
        }
        Arrays.sort(ans);
        for (int i = 0; i < k; i++) {
            ans[i] = nums[ans[i]];
        }
        return ans;
    }

    public int[] maxSubsequenceII(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]); // max heap
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{i, nums[i]});
        }
        int[] ans = new int[k];
        int i = 0;
        while (i != k) {
            int[] e = pq.poll();
            ans[i] = e[0];
            i++;
        }
        Arrays.sort(ans); // 索引排序
        for (i = 0; i < k; i++) {
            ans[i] = nums[ans[i]];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().maxSubsequence(new int[]{3, -1, 4, -2}, 3)));
        System.out.println(Arrays.toString(new Solution().maxSubsequenceII(new int[]{3, -1, 4, -2}, 3)));
    }
}
