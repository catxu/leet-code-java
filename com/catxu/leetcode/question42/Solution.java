package com.catxu.leetcode.question42;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 42. Trapping Rain Water
 * <p>
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 * <p>
 * Example 1:
 * <pre>
 * <img src="./rainwatertrap.png" />
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * </pre>
 * Example 2:
 * <pre>
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 * </pre>
 * Constraints:
 * <pre>
 * n == height.length
 * 1 <= n <= 2 * 10<sup>4</sup>
 * 0 <= height[i] <= 10<sup>5</sup>
 * </pre>
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

    public int trapII(int[] height) {
        int n = height.length, ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                int bottomHeight = height[stack.pop()];
                int left = stack.peek();
                int h = Math.min(height[i], height[left]) - bottomHeight;
                ans += h * (i - left - 1);
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(s.trap(new int[]{4, 2, 0, 3, 2, 5}));
    }
}
