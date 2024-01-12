package com.catxu.leetcode.question16;

import java.util.Arrays;

/**
 * 16. 3Sum Closest
 * <p>
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 * <p>
 * Return the sum of the three integers.
 * <p>
 * You may assume that each input would have exactly one solution.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * Example 2:
 * <p>
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 * Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 3 <= nums.length <= 500
 * -1000 <= nums[i] <= 1000
 * -10^4 <= target <= 10^4
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left != right) {
                int min = nums[i] + nums[left] + nums[left + 1];
                if (target < min) {
                    if (Math.abs(result - target) > Math.abs(min - target))
                        result = min;
                    break;
                }
                int max = nums[i] + nums[right] + nums[right - 1];
                if (target > max) {
                    if (Math.abs(result - target) > Math.abs(max - target))
                        result = max;
                    break;
                }
                int sum = nums[i] + nums[left] + nums[right];
                // 判断三数之和是否等于target
                if (sum == target)
                    return sum;
                if (Math.abs(sum - target) < Math.abs(result - target))
                    result = sum;
                if (sum > target) {
                    right--;
                    while (left != right && nums[right] == nums[right + 1])
                        right--;
                } else {
                    left++;
                    while (left != right && nums[left] == nums[left - 1])
                        left++;
                }
            }
            while (i < nums.length - 2 && nums[i] == nums[i + 1])
                i++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
//        System.out.println(s.threeSumClosest(new int[]{0, 0, 0}, 1));
        System.out.println(s.threeSumClosest(new int[]{833, 736, 953, -584, -448, 207, 128, -445, 126, 248, 871, 860, 333, -899, 463, 488, -50, -331, 903, 575, 265, 162, -733, 648, 678, 549, 579, -172, -897, 562, -503, -508, 858, 259, -347, -162, -505, -694, 300, -40, -147, 383, -221, -28, -699, 36, -229, 960, 317, -585, 879, 406, 2, 409, -393, -934, 67, 71, -312, 787, 161, 514, 865, 60, 555, 843, -725, -966, -352, 862, 821, 803, -835, -635, 476, -704, -78, 393, 212, 767, -833, 543, 923, -993, 274, -839, 389, 447, 741, 999, -87, 599, -349, -515, -553, -14, -421, -294, -204, -713, 497, 168, 337, -345, -948, 145, 625, 901, 34, -306, -546, -536, 332, -467, -729, 229, -170, -915, 407, 450, 159, -385, 163, -420, 58, 869, 308, -494, 367, -33, 205, -823, -869, 478, -238, -375, 352, 113, -741, -970, -990, 802, -173, -977, 464, -801, -408, -77, 694, -58, -796, -599, -918, 643, -651, -555, 864, -274, 534, 211, -910, 815, -102, 24, -461, -146}, -7111));
    }
}
