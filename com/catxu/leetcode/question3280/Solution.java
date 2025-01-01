package com.catxu.leetcode.question3280;

/**
 * 3280. Convert Date to Binary
 */
class Solution {
    public String convertDateToBinary(String date) {
        StringBuilder sb = new StringBuilder();
        for (String s : date.split("-")) {
            sb.append(Integer.toBinaryString(Integer.parseInt(s))).append("-");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }


    public static void main(String[] args) {
        System.out.println(new Solution().convertDateToBinary("2025-01-01"));
        System.out.println(new Solution().convertDateToBinary("2080-02-29"));
        System.out.println(new Solution().convertDateToBinary("1900-01-01"));
    }
}