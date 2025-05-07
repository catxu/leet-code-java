package com.catxu.leetcode.question169;

/**
 * 169. Majority Element
 * <p>
 * Given an array nums of size n, return the majority element.
 * <p>
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 * <p>
 * Example 1:
 * <pre>
 * Input: nums = [3,2,3]
 * Output: 3
 * </pre>
 * Example 2:
 * <pre>
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 * </pre>
 * Constraints:
 * <pre>
 * n == nums.length
 * 1 <= n <= 5 * 10<sup>4</sup>
 * -10<sup>9</sup> <= nums[i] <= 10<sup>9</sup>
 * </pre>
 */
class Solution {

    public int majorityElement(int[] nums) {
        // 摩尔投票
        int majority = 0, votes = 0;
        for (int num : nums) {
            if (votes == 0) majority = num;
            votes += (majority == num ? 1 : -1);
        }
        return majority;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.majorityElement(new int[]{3, 2, 3}));
        System.out.println(solution.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
        System.out.println(solution.majorityElement(new int[]{0}));
    }
}
