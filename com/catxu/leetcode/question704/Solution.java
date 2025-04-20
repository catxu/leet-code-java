package com.catxu.leetcode.question704;

/**
 * 704.Binary Search
 */
class Solution {
    public int search(int[] nums, int target) {
        // 红蓝染色
        int l = -1, r = nums.length;
        while (l + 1 != r) {
            int m = l + r >> 1;
            if (nums[m] <= target) { // 蓝色 找到最后一个 <= target 的元素
                l = m;
            } else {
                r = m;
            }
        }
        // l[min] = -1
        // l[max] = nums.length - 1 // 循环结束
        // r[min] = 0 // 循环结束
        // r[max] = nums.length
        return l != -1 && nums[l] == target ? l : -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{-1, 0, 3, 5, 9, 9, 9, 9, 9, 12}, 9));
        System.out.println(new Solution().search(new int[]{-1, 0, 3, 5, 9}, 13));
    }
}
