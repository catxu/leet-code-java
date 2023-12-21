package com.catxu.leetcode.question6;

/**
 * 6. Zigzag Conversion
 * <p>
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <div>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * </div>
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * Example 1:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * <p>
 * Output: "PAHNAPLSIIGYIR"
 * <p>
 * Example 2:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * <p>
 * Output: "PINALSIGYAHRPI"
 * <p>
 * Explanation:
 * <p>
 * P     I    N
 * <p>
 * A   L S  I G
 * <p>
 * Y A   H R
 * <p>
 * P     I
 * <p>
 * Example 3:
 * <p>
 * Input: s = "A", numRows = 1
 * Output: "A"
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * <p>
 * s consists of English letters (lower-case and upper-case), ',' and '.'.
 * 1 <= numRows <= 1000
 */
class Solution {
    public static String convert(String s, int numRows) {
        int length = s.length();
        if (length <= numRows || numRows == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder(length);
        // 每次循环取出所有满足条件的字母，j为当前字符在chars数组的索引，t为同一行前一个字符的索引
        // 下一个字符的计算公式：
        // 首行和尾行的计算公式： j = t + 2 * (numRows - 2) + 2 => t + 2 * numRows - 2
        // 其他行计算公式 1-自上而下读取时： j = t + 2 * (numRows - i - 1（尾行） - 1（当前行）) + 2 => t + 2 * (numRows - i) - 2
        // 其他行计算公式 2-自下而上读取时： j = t + 2 * (i - 1) + 2 =>  t + 2 * i
        boolean upToDown;
        for (int i = 0; i < numRows; i++) {
            upToDown = true;
            int t;
            for (int j = i; j < length; ) {
                t = j;
                if (i == 0 || i + 1 == numRows) {
                    sb.append(chars[t]);
                    j = t + 2 * numRows - 2;
                } else {
                    sb.append(chars[t]);
                    if (upToDown) {
                        j = t + 2 * (numRows - i) - 2;
                        upToDown = false;
                    } else {
                        j = t + 2 * i;
                        upToDown = true;
                    }
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}