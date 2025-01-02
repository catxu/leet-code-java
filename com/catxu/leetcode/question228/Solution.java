package com.catxu.leetcode.question228;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. Summary Ranges
 */
class Solution {

    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return List.of();
        }
        int prev = nums[0];
        List<String> ans = new ArrayList<>();
        boolean prevInRange = false;
        ans.add(prev + "");
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            // 注意整型溢出
            if (prev + 1 != cur) {
                if (prevInRange) {
                    extractRange(ans, prev);
                }
                ans.addLast(cur + "");
                prevInRange = false;
            } else {
                prevInRange = true;
            }
            prev = cur;
        }
        if (prevInRange) {
            extractRange(ans, prev);
        }
        return ans;
    }

    private static void extractRange(List<String> ans, int prev) {
        String last = ans.removeLast();
        String rangedStr = last + "->" + prev;
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
