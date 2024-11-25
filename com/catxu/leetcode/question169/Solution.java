package com.catxu.leetcode.question169;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. Majority Element
 * <p>
 * Given an array nums of size n, return the majority element.
 * <p>
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,2,3]
 * <p>
 * Output: 3
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [2,2,1,1,1,2,2]
 * <p>
 * Output: 2
 * <p>
 * Constraints:
 * <p>
 * n == nums.length
 * <p>
 * 1 <= n <= 5 * 10<sup>4</sup>
 * <p>
 * -10<sup>9</sup> <= nums[i] <= 10<sup>9</sup>
 */
class Solution {

    public int majorityElement(int[] nums) {
        int threshold = nums.length / 2;
        Map<Integer, Integer> elements = new HashMap<>(nums.length);
        for (int num : nums) {
            int times = elements.getOrDefault(num, 0);
            if (++times > threshold) {
                return num;
            }
            elements.put(num, times);
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.majorityElement(new int[]{3, 2, 3}));
        System.out.println(solution.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
        System.out.println(solution.majorityElement(new int[]{0}));
    }
}
