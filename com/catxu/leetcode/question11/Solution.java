package com.catxu.leetcode.question11;


/**
 * 11. Container With Most Water
 * <p>
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * <p>
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * <p>
 * Return the maximum amount of water a container can store.
 * <p>
 * Notice that you may not slant the container.
 * <p>
 * Example 1:
 * <p>
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * <p>
 * Example 2:
 * <p>
 * Input: height = [1,1]
 * Output: 1
 * <p>
 * Constraints:
 * <p>
 * n == height.length
 * 2 <= n <= 10^5
 * 0 <= height[i] <= 10^4
 */
class Solution {
    public int maxArea(int[] height) {
        int length = height.length;
        int max = 0;
        int l = 0;
        int r = length - 1;
        int minHeight;
        while (l < r) {
            if (height[l] < height[r]) {
                minHeight = height[l];
                max = Math.max(max, height[l] * (r - l));
                while (l < r && minHeight >= height[l]) {
                    ++l;
                }
            } else {
                minHeight = height[r];
                max = Math.max(max, height[r] * (r - l));
                while (l < r && minHeight >= height[r]) {
                    --r;
                }
            }
        }
        return max;

        /*int n = height.length;
        int max = 0;
        for (int i = 0, j = n - 1; i < j; ) {
            n = j - i;
            max = Math.max(max, Math.min(height[i], height[j]) * n);
            if (height[i] >= height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return max;*/
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxArea(new int[]{1, 1}));
        System.out.println(s.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}