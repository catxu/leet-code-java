package com.catxu.leetcode.question88;

/**
 * 88. Merge Sorted Array
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int end = m + n - 1;
        m--;
        n--;
        while (end >= 0) {
            if (m < 0 || n < 0) {
                if (m < 0) {
                    // 将 nums2 剩下数值复制到 nums1
                    while (n >= 0) {
                        nums1[end--] = nums2[n--];
                    }
                }
                return;
            }
            if (nums1[m] < nums2[n]) {
                nums1[end] = nums2[n];
                n--;
            } else {
                nums1[end] = nums1[m];
                m--;
            }
            end--;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        s.merge(new int[]{1}, 1, new int[]{}, 0);
        s.merge(new int[]{0}, 0, new int[]{1}, 1);
    }
}