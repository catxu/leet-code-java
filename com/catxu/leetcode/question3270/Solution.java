package com.catxu.leetcode.question3270;

/**
 * 3270. Find the Key of the Numbers
 */
class Solution {
    public int generateKey(int num1, int num2, int num3) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%04d", num1))
                .append(String.format("%04d", num2))
                .append(String.format("%04d", num3));
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            char min = sb.charAt(i) <= sb.charAt(i + 4)
                    ? (sb.charAt(i) <= sb.charAt(i + 8) ? sb.charAt(i) : sb.charAt(i + 8))
                    : (sb.charAt(i + 4) <= sb.charAt(i + 8) ? sb.charAt(i + 4) : sb.charAt(i + 8));
            ans.append((ans.isEmpty() && min == '0') ? "" : min);
        }
        return ans.isEmpty() ? 0 : Integer.parseInt(ans.toString());
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateKey(1, 10, 1000));
        System.out.println(new Solution().generateKey(987, 879, 798));
        System.out.println(new Solution().generateKey(1, 2, 3));
    }
}
