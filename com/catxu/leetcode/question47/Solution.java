package com.catxu.leetcode.question47;

import java.util.ArrayList;
import java.util.List;

/**
 * 47. Permutations II
 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, ans, new ArrayList<>(), visited);
        return ans;
    }

    private void dfs(int[] nums, List<List<Integer>> ans, List<Integer> state, boolean[] visited) {
        if (state.size() == nums.length) {
            ans.add(new ArrayList<>(state));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i - 1] == nums[i] && visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            state.add(nums[i]);
            dfs(nums, ans, state, visited);
            visited[i] = false;
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
        int med = medianThree(nums, start, (start + end) / 2, end);
        swap(nums, med, end);
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

    /* 选取三个候选元素的中位数*/
    private int medianThree(int[] nums, int left, int mid, int right) {
        // 此处使用异或运算来简化代码
        // 异或规则为0 ^ 0 = 1 ^ 1 = 0, 0 ^ 1 = 1 ^ 0 = 1
        if ((nums[left] < nums[mid]) ^ (nums[left] < nums[right])) {
            return left;
        } else if ((nums[mid] < nums[left]) ^ (nums[mid] < nums[right])) {
            return mid;
        } else {
            return right;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().permuteUnique(new int[]{1, 2, 1,2,1}));
        System.out.println(new Solution().permuteUnique(new int[]{1}));
        System.out.println(new Solution().permuteUnique(new int[]{1, 2, 3}));
    }
}
