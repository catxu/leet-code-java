package com.catxu.leetcode.question4;

/**
 * 4. Median of Two Sorted Arrays
 * <p>
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * <p>
 * The overall run time complexity should be O(log (m+n)).
 * <p>
 * Example 1:
 * <pre>
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * </pre>
 * Example 2:
 * <pre>
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * </pre>
 * Constraints:
 * <pre>
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -10<sup>6</sup> <= nums1[i], nums2[i] <= 10<sup>6</sup>
 * </pre>
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int m = nums1.length, n = nums2.length;
        int totalLeft = (m + n + 1) / 2; // 整体中点长度
        int left = 0, right = m;
        // 在较短数组上执行二分查找，找到一个划分点 i 使得 i + j = totalLeft 并且
        // 这个划分点 左半部分的最大值 ≤ 右半部分的最小值，即 nums1[i-1] <= nums2[j] && nums2[j-1] <= nums1[i]
        while (left < right) {
            int i = (left + right + 1) / 2;
            int j = totalLeft - i;
            if (nums1[i - 1] > nums2[j]) { // 为什么这里只判断 nums1[i-1] <= nums2[j]，如何保证 nums2[j-1] <= nums1[i]
                right = i - 1;
            } else {
                left = i;
            }
        }

        int i = left, j = totalLeft - i; // i, j 分别为 nums1, nums2 上的划分点
        int nums1LeftMax = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1], nums1RightMin = (i == m) ? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1], nums2RightMin = (j == n) ? Integer.MAX_VALUE : nums2[j];

        if ((m + n) % 2 == 1) {
            return Math.max(nums1LeftMax, nums2LeftMax);
        } else {
            return (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2.0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMedianSortedArrays(new int[]{1}, new int[]{0, 2}));
        System.out.println(new Solution().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

}


