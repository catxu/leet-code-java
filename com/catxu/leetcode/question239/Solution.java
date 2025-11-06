package com.catxu.leetcode.question239;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * 239. Sliding Window Maximum
 */
class Solution {
    // 大顶堆 时间复杂度 O(nlogn)
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length, totalNum = n - k + 1;
        if (totalNum == n) return nums;
        int[] ans = new int[totalNum];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int i = 0, j = 0;
        while (pq.size() < k) {
            pq.offer(new int[]{nums[i], i++});
        }
        ans[j++] = pq.peek()[0];
        while (i < n) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] < i + 1 - k) pq.poll();  // i + 1 - k 为当前滑窗起始下标
            ans[j++] = pq.peek()[0];
            i++;
        }
        return ans;
    }

    // 单调队列
    public int[] maxSlidingWindowII(int[] nums, int k) {
        int n = nums.length, totalNum = n - k + 1;
        if (totalNum == n) return nums;
        Deque<Integer> q = new ArrayDeque<>();
        int[] ans = new int[totalNum];
        for (int left = 0, right = 0; right < n; right++) {
            // 维护队列单调性
            while (!q.isEmpty() && nums[q.peek()] <= nums[right]) {
                q.pop();
            }
            q.offer(right);
            if (right - k + 1 >= 0) ans[left++] = nums[q.peek()];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3}, 2)));
        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(new int[]{3, 1, 3, 3, 5, 3}, 2)));
        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(new int[]{1}, 1)));
        System.out.println(Arrays.toString(new Solution().maxSlidingWindowII(new int[]{3, 1, 3, 3, 5, 3}, 2)));
        System.out.println(Arrays.toString(new Solution().maxSlidingWindowII(new int[]{1}, 1)));
    }
}
