package com.catxu.leetcode.question88;

/**
 * 88. Merge Sorted Array
 * <p>
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 * <p>
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * <p>
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 * <p>
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * <p>
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 * <p>
 * Example 2:
 * <p>
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * <p>
 * Output: [1]
 * <p>
 * Explanation: The arrays we are merging are [1] and [].
 * <p>
 * The result of the merge is [1].
 * <p>
 * Example 3:
 * <p>
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 * <p>
 * Output: [1]
 * <p>
 * Explanation: The arrays we are merging are [] and [1].
 * <p>
 * The result of the merge is [1].
 * <p>
 * Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 * <p>
 * Constraints:
 * <p>
 * nums1.length == m + n
 * <p>
 * nums2.length == n
 * <p>
 * 0 <= m, n <= 200
 * <p>
 * 1 <= m + n <= 200
 * <p>
 * -10^9 <= nums1[i], nums2[j] <= 10^9
 * <p>
 * Follow up: Can you come up with an algorithm that runs in O(m + n) time?
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
                nums1[end--] = nums2[n--];
            } else {
                nums1[end--] = nums1[m--];
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        s.merge(new int[]{1}, 1, new int[]{}, 0);
        s.merge(new int[]{0}, 0, new int[]{1}, 1);
    }
}