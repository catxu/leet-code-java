package com.catxu.leetcode.question42;

/**
 * 42. Trapping Rain Water
 * <p>
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 * <p>
 * Example 1:
 * <p>
 * <img src="./rainwatertrap.png" />
 * <p>
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * <p>
 * Output: 6
 * <p>
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * <p>
 * Example 2:
 * <p>
 * Input: height = [4,2,0,3,2,5]
 * <p>
 * Output: 9
 * <p>
 * Constraints:
 * <p>
 * n == height.length
 * <p>
 * 1 <= n <= 2 * 10<sup>4</sup>
 * <p>
 * 0 <= height[i] <= 10<sup>5</sup>
 */
class Solution {
    public int trap(int[] height) {
        // trap water = min(left, right) - h[i]
        int left = 0;
        int right = height.length - 1;
        int maxL = height[left];
        int maxR = height[right];
        int res = 0;
        while (left < right) {
            if (maxL <= maxR) {
                left++;
                res += Math.max(0, maxL - height[left]);
                // 先更新 res，再 update 左边的最大值
                maxL = Math.max(maxL, height[left]);
            } else {
                right--;
                res += Math.max(0, maxR - height[right]);
                maxR = Math.max(maxR, height[right]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(s.trap(new int[]{4, 2, 0, 3, 2, 5}));
    }
}
