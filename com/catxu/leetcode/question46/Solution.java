package com.catxu.leetcode.question46;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 * <p>
 * Given an array nums of distinct integers, return all the possible
 * permutations
 * . You can return the answer in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 * <p>
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 * <p>
 * Input: nums = [1]
 * Output: [[1]]
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    // 49 -> 50 -> 25 -> 37 -> 43 -> 46 -> 48 -> 49

    private void backtrack(List<List<Integer>> result, List<Integer> state, int[] nums) {
        if (state.size() == nums.length) {
            result.add(new ArrayList<>(state));
        } else {
            for (int num : nums) {
                if (state.contains(num))
                    continue;
                state.add(num);
                backtrack(result, state, nums);
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
