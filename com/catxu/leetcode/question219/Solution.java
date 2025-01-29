package com.catxu.leetcode.question219;

import java.util.HashSet;
import java.util.Set;

/**
 * 219. Contains Duplicate II
 */
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) {
            return false;
        }
        Set<Integer> window = new HashSet<>();
        if (!initWindow(window, nums, k)) {
            return true;
        }
        for (int i = 1, j = i + k; j < nums.length; j += 1, i += 1) {
            window.remove(nums[i - 1]);
            if (window.contains(nums[j])) {
                return true;
            }
            window.add(nums[j]);
        }
        return false;
    }

    private boolean initWindow(Set<Integer> window, int[] nums, int k) {
        int i = 0;
        while (i < Math.min(k + 1, nums.length)) {
            if (window.contains(nums[i])) {
                return false;
            }
            window.add(nums[i]);
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().containsNearbyDuplicate(new int[]{1, 2, 3, 4}, 4));
        System.out.println(new Solution().containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        System.out.println(new Solution().containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
        System.out.println(new Solution().containsNearbyDuplicate(new int[]{0}, 0));
    }
}
