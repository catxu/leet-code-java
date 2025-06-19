package com.catxu.leetcode.question46;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 46. Permutations
 * <p>
 * Given an array nums of distinct integers, return all the possible permutations.
 * <p>
 * You can return the answer in any order.
 * <p>
 * Example 1:
 * <pre>
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * </pre>
 * Example 2:
 * <pre>
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * </pre>
 * Example 3:
 * <pre>
 * Input: nums = [1]
 * Output: [[1]]
 * </pre>
 * Constraints:
 * <pre>
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 * </pre>
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> vis = new HashSet<>();
        backtrack(result, new ArrayList<>(), vis, nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> state, Set<Integer> vis, int[] nums) {
        if (state.size() == nums.length) {
            result.add(new ArrayList<>(state));
            return;
        }
        for (int num : nums) {
            if (vis.add(num)) {
                state.add(num);
                backtrack(result, state, vis, nums);
                state.removeLast();
            }
        }
    }

    // 1, 2, 3 -> 1, 2, 3 -> 1, 2 -> 1 -> 1, 3 -> 1, 3, 2


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.permute(new int[]{1, 2, 3}));
        System.out.println(solution.permute(new int[]{0, 1}));
        System.out.println(solution.permute(new int[]{1}));
    }
}
