package com.catxu.leetcode.question3064;

import java.util.HashMap;
import java.util.Map;

/**
 * 3046. Split the Array
 * <p>
 * You are given an integer array nums of even length. You have to split the array into two parts nums1 and nums2 such that:
 * <p>
 * nums1.length == nums2.length == nums.length / 2.
 * <p>
 * nums1 should contain distinct elements.
 * <p>
 * nums2 should also contain distinct elements.
 * <p>
 * Return true if it is possible to split the array, and false otherwise.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,2,2,3,4]
 * <p>
 * Output: true
 * <p>
 * Explanation: One of the possible ways to split nums is nums1 = [1,2,3] and nums2 = [1,2,4].
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,1,1,1]
 * <p>
 * Output: false
 * <p>
 * Explanation: The only possible way to split nums is nums1 = [1,1] and nums2 = [1,1]. Both nums1 and nums2 do not contain distinct elements. Therefore, we return false.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 100
 * <p>
 * nums.length % 2 == 0
 * <p>
 * 1 <= nums[i] <= 100
 */
class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for (int count : freq.values()) {
            if (count > 2) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPossibleToSplit(new int[]{1, 1, 2, 2, 3, 4}));
        System.out.println(new Solution().isPossibleToSplit(new int[]{1, 1, 1, 1}));
        System.out.println(new Solution().isPossibleToSplit(new int[]{1, 2, 1, 2}));
    }
}
