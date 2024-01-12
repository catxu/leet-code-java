package com.catxu.leetcode.question18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4Sum
 * <p>
 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 * <p>
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * You may return the answer in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * Example 2:
 * <p>
 * Input: nums = [2,2,2,2,2], target = 8
 * Output: [[2,2,2,2]]
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 200
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (target > 0 && nums[i] > target || target < 0 && nums[i] >= 0) {
                return ans;
            }
            if (i == 0 || nums[i] != nums[i - 1]) {
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j == 1 || (j - 1 == i || nums[j] != nums[j - 1])) {
                        twoSumII(ans, nums, nums[i], j, (long) target - nums[i] - nums[j]);
                    }
                }
            }
        }
        return ans;
    }

    public void twoSumII(List<List<Integer>> ans, int[] nums, int firstNum, int startIndex, long target) {
        int l = startIndex + 1, r = nums.length - 1;
        while (l < r) {
            if (nums[l] + nums[r] > target) {
                --r;
            } else if (nums[l] + nums[r] < target) {
                ++l;
            } else {
                ans.add(Arrays.asList(firstNum, nums[startIndex], nums[l], nums[r]));
                while (l < r && nums[l] == nums[l + 1])
                    ++l;
                while (l < r && nums[r] == nums[r - 1])
                    --r;
                ++l;
                --r;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
//        System.out.println(solution.fourSum(new int[]{2, 2, 2, 2, 2}, 8));
//        System.out.println(solution.fourSum(new int[]{0, 0, 0, 0}, 0));
//        System.out.println(solution.fourSum(new int[]{-2, -1, -1, 1, 1, 2, 2}, 0));
//        System.out.println(solution.fourSum(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11));
        System.out.println(solution.fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296));
        System.out.println(solution.fourSum(new int[]{-1000000000, -1000000000, 1000000000, -1000000000, -1000000000}, 294967296));
    }

}
