package com.catxu.leetcode.question90;

import java.util.ArrayList;
import java.util.List;

/**
 * 90. Subsets II
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> state = new ArrayList<>();
        dfs(nums, res, state, 0);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> state, int start) {
        res.add(new ArrayList<>(state));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            state.add(nums[i]);
            dfs(nums, res, state, i + 1);
            state.removeLast();
        }
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = partition(nums, start, end);
        quickSort(nums, start, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }

    private int partition(int[] nums, int start, int end) {
        int i = start - 1;
        int pivot = nums[end];
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

    public static void main(String[] args) {
        System.out.println(new Solution().subsetsWithDup(new int[]{1, 2, 2}));
        System.out.println(new Solution().subsetsWithDup(new int[]{2, 2, 2}));
        System.out.println(new Solution().subsetsWithDup(new int[]{0}));
    }
}
