package com.catxu.leetcode.question228;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. Summary Ranges
 */
class Solution {

    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums.length == 0) {
            return ans;
        }
        boolean prevInRange = false;
        ans.add(String.valueOf(nums[0]));
        for (int i = 1; i < nums.length; i++) {
            // 注意整型溢出
            if (nums[i - 1] + 1 != nums[i]) {
                if (prevInRange) {
                    extractRange(ans, nums[i - 1]);
                }
                ans.addLast(String.valueOf(nums[i]));
                prevInRange = false;
            } else {
                prevInRange = true;
            }
        }
        if (prevInRange) {
            extractRange(ans, nums[nums.length - 1]);
        }
        return ans;
    }

    private static void extractRange(List<String> ans, int next) {
        String prev = ans.removeLast();
        String rangedStr = prev + "->" + next;
        ans.addLast(rangedStr);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        System.out.println(new Solution().summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
        System.out.println(new Solution().summaryRanges(new int[]{0}));
        System.out.println(new Solution().summaryRanges(new int[]{-2147483648, 0, 2, 3, 4, 6, 8, 9}));
        System.out.println(new Solution().summaryRanges(new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE}));
    }
}
