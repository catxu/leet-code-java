package com.catxu.leetcode.question55;

/**
 * 55. Jump Game
 * <p>
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 * <p>
 * Return true if you can reach the last index, or false otherwise.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,3,1,1,4]
 * <p>
 * Output: true
 * <p>
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [3,2,1,0,4]
 * <p>
 * Output: false
 * <p>
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10<sup>4</sup>
 * <p>
 * 0 <= nums[i] <= 10<sup>5</sup>
 */
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(solution.canJump(new int[]{3, 2, 1, 0, 4}));
    }


    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        int count = 0;
        for (int i = nums.length - 2; i >= 0; i--) { //最后一个不用考虑
            if (nums[i] <= count) {
                count++;           //需要跨越的距离
            } else {
                count = 0;
            }
        }
        return count == 0;
    }
}
