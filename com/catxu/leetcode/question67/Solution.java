package com.catxu.leetcode.question67;

/**
 * 67. Add Binary
 * <p>
 * Given two binary strings a and b, return their sum as a binary string.
 * <p>
 * Example 1:
 * <p>
 * Input: a = "11", b = "1"
 * <p>
 * Output: "100"
 * <p>
 * Example 2:
 * <p>
 * Input: a = "1010", b = "1011"
 * <p>
 * Output: "10101"
 * <p>
 * Constraints:
 * <p>
 * 1 <= a.length, b.length <= 10<sup>4</sup>
 * <p>
 * a and b consist only of '0' or '1' characters.
 * <p>
 * Each string does not contain leading zeros except for the zero itself.
 */
class Solution {
    public String addBinary(String a, String b) {
        int l = a.length();
        int r = b.length();
        if (l != r) {
            if (l > r) {
                b = appendZero(b, l - r);
            } else {
                a = appendZero(a, r - l);
            }
        }

        int curry = 0;
        StringBuilder res = new StringBuilder();

        for (int i = a.length() - 1; i >= 0; i--) {
            int sum = (a.charAt(i) - '0') + (b.charAt(i) - '0') + curry;
            if (sum / 2 == 1) {
                curry = 1;
            } else {
                curry = 0;
            }
            res.append(sum % 2);
        }
        if (curry == 1) {
            res.append(curry);
        }
        return res.reverse().toString();
    }

    private String appendZero(String str, int num) {
        StringBuilder sb = new StringBuilder(str);
        while (--num >= 0) {
            sb.insert(0, "0");
        }
        str = sb.toString();
        return str;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("0", "111"));
        System.out.println(solution.addBinary("11", "1"));
        System.out.println(solution.addBinary("1010", "1011"));
    }
}
