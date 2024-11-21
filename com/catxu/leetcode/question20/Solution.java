package com.catxu.leetcode.question20;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 * <p>
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * 1. Open brackets must be closed by the same type of brackets.
 * <p>
 * 2. Open brackets must be closed in the correct order.
 * <p>
 * 3. Every close bracket has a corresponding open bracket of the same type.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "()"
 * <p>
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: s = "()[]{}"
 * <p>
 * Output: true
 * <p>
 * Example 3:
 * <p>
 * Input: s = "(]"
 * <p>
 * Output: false
 * <p>
 * Example 4:
 * <p>
 * Input: s = "([])"
 * <p>
 * Output: true
 * <p>
 * Constraints:
 * <p>
 * · 1 <= s.length <= 10<sup>4</sup>
 * <p>
 * · s consists of parentheses only '()[]{}'.
 */
class Solution {
    public boolean isValid(String s) {
        Set<Character> openBrackets = new HashSet<>();
        openBrackets.add('{');
        openBrackets.add('(');
        openBrackets.add('[');
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (openBrackets.contains(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character prevOpenBracket = stack.pop();
                switch (ch) {
                    case ']':
                        if (prevOpenBracket != '[') {
                            return false;
                        }
                        break;
                    case '}':
                        if (prevOpenBracket != '{') {
                            return false;
                        }
                        break;
                    case ')':
                        if (prevOpenBracket != '(') {
                            return false;
                        }
                        break;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.isValid("()"));
//        System.out.println(s.isValid("()[]{}"));
//        System.out.println(s.isValid("(]"));
//        System.out.println(s.isValid("]"));
//        System.out.println(s.isValid("(){}}{"));
        System.out.println(s.isValid("{}{{{(}){{}}{}}}"));
    }
}
