package com.catxu.leetcode.question4;

/**
 * 4. Median of Two Sorted Arrays
 * <p>
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * <p>
 * The overall run time complexity should be O(log (m+n)).
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,3], nums2 = [2]
 * <p>
 * Output: 2.00000
 * <p>
 * Explanation: merged array = [1,2,3] and median is 2.
 * <p>
 * Example 2:
 * <p>
 * Input: nums1 = [1,2], nums2 = [3,4]
 * <p>
 * Output: 2.50000
 * <p>
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * <p>
 * Constraints:
 * <p>
 * nums1.length == m
 * <p>
 * nums2.length == n
 * <p>
 * 0 <= m <= 1000
 * <p>
 * 0 <= n <= 1000
 * <p>
 * 1 <= m + n <= 2000
 * -10<sup>6</sup> <= nums1[i], nums2[i] <= 10<sup>6</sup>
 */
class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            findMedianSortedArrays(nums2, nums1);
        }
        int total = nums1.length + nums2.length;
        int half = total / 2;
        int left = 0;
        int right = nums2.length - 1;
        while (true) {
            int i = Math.floorDiv(left + right, 2); // Math.floorDiv(-1, 2) = -1
            int j = half - i - 2;
            int shorterLeftVal = i < 0 ? Integer.MIN_VALUE : nums2[i];
            int shorterRightVal = i + 1 >= nums2.length ? Integer.MAX_VALUE : nums2[i + 1];
            int longerLeftVal = j < 0 ? Integer.MIN_VALUE : nums1[j];
            int longerRightVal = j + 1 >= nums1.length ? Integer.MAX_VALUE : nums1[j + 1];
            if (Math.max(shorterLeftVal, longerLeftVal) <= Math.min(shorterRightVal, longerRightVal)) {
                if (total % 2 != 0) {
                    return Math.min(shorterRightVal, longerRightVal);
                }
                return (Math.max(shorterLeftVal, longerLeftVal) + Math.min(shorterRightVal, longerRightVal)) / 2.0;
            } else if (shorterLeftVal > longerRightVal) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1}, new int[]{0,2}));
    }

}


