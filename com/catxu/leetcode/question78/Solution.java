package com.catxu.leetcode.question78;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets
 * <p>
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * <p>
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [0]
 * <p>
 * Output: [[],[0]]
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10
 * <p>
 * -10 <= nums[i] <= 10
 * <p>
 * All the numbers of nums are unique.
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> state = new ArrayList<>();
        backtrack(res, state, nums, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> state, int[] nums, int start) {
        res.add(new ArrayList<>(state));
        for (int i = start; i < nums.length; i++) {
            state.add(nums[i]);
            backtrack(res, state, nums, i + 1);
            state.remove(state.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.subsets(new int[]{1, 2, 3}));
        System.out.println(s.subsets(new int[]{3, 9}));
        System.out.println(s.subsets(new int[]{9, 3, 2}));
    }
}
