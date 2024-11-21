package com.catxu.leetcode.question14;

/**
 * 14. Longest Common Prefix
 * <p>
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: strs = ["flower","flow","flight"]
 * <p>
 * Output: "fl"
 * <p>
 * Example 2:
 * <p>
 * Input: strs = ["dog","racecar","car"]
 * <p>
 * Output: ""
 * <p>
 * Explanation: There is no common prefix among the input strings.
 * <p>
 * Constraints:
 * <p>
 * 1 <= strs.length <= 200
 * <p>
 * 0 <= strs[i].length <= 200
 * <p>
 * strs[i] consists of only lowercase English letters.
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String commonPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (commonPrefix.isEmpty()) {
                return commonPrefix;
            }
            int j = -1;
            if (commonPrefix.length() <= strs[i].length()) {
                while (j++ < commonPrefix.length() - 1) {
                    if (commonPrefix.charAt(j) != strs[i].charAt(j)) {
                        commonPrefix = commonPrefix.substring(0, j);
                        break;
                    }
                }
            } else {
                while (j++ < strs[i].length() - 1) {
                    if (strs[i].charAt(j) != commonPrefix.charAt(j)) {
                        break;
                    }
                }
                commonPrefix = commonPrefix.substring(0, j);
            }
        }
        return commonPrefix;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"racecar","dog","car"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"","c","car"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"c",""}));
    }
}
