package com.catxu.leetcode.question3066;

import java.util.PriorityQueue;

/**
 * 3066. Minimum Operations to Exceed Threshold Value II
 * <p>
 * You are given a 0-indexed integer array nums, and an integer k.
 * <p>
 * In one operation, you will:
 * <pre>
 * Take the two smallest integers x and y in nums.
 * Remove x and y from nums.
 * Add min(x, y) * 2 + max(x, y) anywhere in the array.
 * Note that you can only apply the described operation if nums contains at least two elements.
 * </pre>
 * Return the minimum number of operations needed so that all elements of the array are greater than or equal to k.
 * <p>
 * Example 1:
 * <pre>
 * Input: nums = [2,11,10,1,3], k = 10
 * Output: 2
 * Explanation: In the first operation, we remove elements 1 and 2, then add 1 * 2 + 2 to nums. nums becomes equal to [4, 11, 10, 3].
 * In the second operation, we remove elements 3 and 4, then add 3 * 2 + 4 to nums. nums becomes equal to [10, 11, 10].
 * At this stage, all the elements of nums are greater than or equal to 10 so we can stop.
 * It can be shown that 2 is the minimum number of operations needed so that all elements of the array are greater than or equal to 10.
 * </pre>
 * Example 2:
 * <pre>
 * Input: nums = [1,1,2,4,9], k = 20
 * Output: 4
 * Explanation: After one operation, nums becomes equal to [2, 4, 9, 3].
 * After two operations, nums becomes equal to [7, 4, 9].
 * After three operations, nums becomes equal to [15, 9].
 * After four operations, nums becomes equal to [33].
 * At this stage, all the elements of nums are greater than 20 so we can stop.
 * It can be shown that 4 is the minimum number of operations needed so that all elements of the array are greater than or equal to 20.
 * </pre>
 * <p>
 * Constraints:
 * <pre>
 * 2 <= nums.length <= 2 * 10<sup>5</sup>
 * 1 <= nums[i] <= 10<sup>9</sup>
 * 1 <= k <= 10<sup>9</sup>
 * The input is generated such that an answer always exists. That is, there exists some sequence of operations after which all elements of the array are greater than or equal to k.
 * </pre>
 */
class Solution {
    public int minOperations(int[] nums, int k) {
        int ans = 0;
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add((long) num);
        }

        while (minHeap.size() > 1) {
            if (minHeap.peek() >= k) {
                break;
            }
            long a = minHeap.poll();
            long b = minHeap.poll();
            long res = a * 2 + b;
            if (res < k) {
                minHeap.add(res);
            }
            ans++;
        }

        return minHeap.isEmpty() ? ans : (minHeap.peek() < k ? ans + 1 : ans);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minOperations(new int[]{2, 11, 10, 1, 3}, 10));
        System.out.println(new Solution().minOperations(new int[]{1, 1, 2, 4, 9}, 20));
        System.out.println(new Solution().minOperations(new int[]{999999999, 999999999, 999999999}, 1000000000));
        System.out.println(new Solution().minOperations(new int[]{15, 90, 76, 23, 66, 28, 37, 16, 45}, 91));
    }

    private void quickSort(int[] nums, int start, int end) {
        if (end <= start) {
            return;
        }
        int pivot = partition(nums, start, end);
        quickSort(nums, start, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }

    private int partition(int[] nums, int start, int end) {
        int i = start - 1, pivot = nums[end];
        for (int j = start; j < end; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        i++;
        swap(nums, i, end);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
