package com.catxu.leetcode.weekly440.q2;

import java.util.*;

/**
 * 3478. Choose K Elements With Maximum Sum
 */
class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        long[] answer = new long[n];
        List<int[]> sortedList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            sortedList.add(new int[]{nums1[i], nums2[i]});
        }

        // 按nums1升序排序
        sortedList.sort(Comparator.comparingInt(a -> a[0]));

        int[] nums1Sorted = new int[n];
        for (int i = 0; i < n; i++) {
            nums1Sorted[i] = sortedList.get(i)[0];
        }

        // 预处理前缀和数组
        long[] prefixSum = new long[n];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long currentSum = 0;

        for (int i = 0; i < n; i++) {
            int num2 = sortedList.get(i)[1];
            minHeap.offer(num2);
            currentSum += num2;

            if (minHeap.size() > k) {
                int removed = minHeap.poll();
                currentSum -= removed;
            }

            prefixSum[i] = currentSum;
        }

        // 处理每个查询
        for (int i = 0; i < n; i++) {
            int x = nums1[i];
            int jMax = findLastSmaller(nums1Sorted, x);
            answer[i] = (jMax != -1) ? prefixSum[jMax] : 0;
        }

        return answer;
    }

    private int findLastSmaller(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int res = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findMaxSum(new int[]{4, 2, 1, 5, 3}, new int[]{10, 20, 30, 40, 50}, 2)));
    }
}