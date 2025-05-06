package com.catxu.leetcode.weekly440.q2;

import java.util.*;

/**
 * 3478. Choose K Elements With Maximum Sum
 */
class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        // 对 nums1 排序并记录下标
        int n = nums1.length;
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{nums1[i], nums2[i], i};
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        long[] ans = new long[n];
        long sum = 0;
        // 利用小根堆维护 k-sum
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < n; ) {
            int start = i;
            while (i < n && arr[i][0] == arr[start][0]) {
                ans[arr[i][2]] = sum;
                i++;
            }
            for (int j = start; j < i; j++) {
                int val = arr[j][1];
                sum += val;
                minHeap.offer(val);
                if (minHeap.size() > k) {
                    sum -= minHeap.poll();
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findMaxSum(new int[]{4, 2, 1, 5, 3}, new int[]{10, 20, 30, 40, 50}, 2)));
        System.out.println(Arrays.toString(new Solution().findMaxSum(new int[]{2, 2, 2, 2}, new int[]{3, 1, 2, 3}, 1)));
    }
}