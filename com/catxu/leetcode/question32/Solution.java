package com.catxu.leetcode.question32;

import java.util.Stack;

/**
 * 32. Longest Valid Parentheses
 * <p>
 * Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses
 * substring.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "(()"
 * <p>
 * Output: 2
 * <p>
 * Explanation: The longest valid parentheses substring is "()".
 * <p>
 * Example 2:
 * <p>
 * Input: s = ")()())"
 * <p>
 * Output: 4
 * <p>
 * Explanation: The longest valid parentheses substring is "()()".
 * <p>
 * Example 3:
 * <p>
 * Input: s = ""
 * <p>
 * Output: 0
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length <= 3 * 10^4
 * <p>
 * s[i] is '(', or ')'.
 */
class Solution {
    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int result = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    // 前值必然为 ')' 或者 -1，将当前字符')'入栈，表示下一次匹配的起始位置
                    stack.push(i);
                } else {
                    // peek 值有三种情况：
                    // -1  刚好匹配的情况 例如："()"
                    // '(' 的下标，连续多个 '(' 的情况，peek 出来的值为倒数第一个未匹配的 '(' 的下标，例如： "(()"
                    // ')' 的下标：最后一个未匹配 ')' 的下标 "))()"
                    result = Math.max(result, i - stack.peek());
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestValidParentheses("(()"));
        System.out.println(s.longestValidParentheses(")()())"));
        System.out.println(s.longestValidParentheses(""));
    }
}
